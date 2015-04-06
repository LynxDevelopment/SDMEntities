package com.lynxspa.sdm.processors.normalize.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.lynxspa.entities.jobs.SDMJobField;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.providers.Provider;
import com.lynxspa.sdm.managers.StaticConfigManager;

public class StaticEventMessageWrapper {
	
	//private AssetType messageType = null;
	private Map<String, StaticMessageField> fieldsMap = null;
	protected StaticConfigManager manager = null;
	private Session session = null;
	private Provider normalizedProvider=null; 
	private AssetType normalizedAssetType=null;
	private String originalMessage;
	
	public StaticEventMessageWrapper(Session _session, List<StaticMessageField> _fields, Provider _normalizedProvider,AssetType _normalizedAssetType,String _originalMessage) throws Exception {
		
		this.session=_session;
		//this.messageType=_messageType;
		this.manager=StaticConfigManager.getInstance();
		this.fieldsMap=new HashMap<String, StaticMessageField>();
		//this.normalizedSecurity=_normalizedSecurity;
		this.normalizedProvider=_normalizedProvider;
		this.normalizedAssetType=_normalizedAssetType;
		for (StaticMessageField messageField:_fields) {
			this.fieldsMap.put(messageField.path, messageField);
		}
		this.originalMessage=_originalMessage;
	}
	
	
	public StaticEventMessageWrapper(Session _session, List<StaticMessageField> _fields, String _originalMessage) throws Exception {
		
		this.session=_session;
		this.manager=StaticConfigManager.getInstance();
		this.fieldsMap=new HashMap<String, StaticMessageField>();
//		System.out.println("Num Fields: "+_fields.size());
		int i=1;
		for (StaticMessageField messageField:_fields) {
			try{
				this.fieldsMap.put(messageField.path, messageField);
				i++;
			}catch(Exception e){
				System.err.println("Error en field "+ i +" error:" +e.getMessage());
				e.printStackTrace();
			}
		}
		this.originalMessage=_originalMessage;
	}
	/**
	 * Returns a Map that contains the message fields by message path
	 * @return map with message path as key and MessageField as value
	 */
	public Map<String, StaticMessageField> getFieldsMap(){
		return this.fieldsMap;
	}

	/**
	 * Returns a field from a path
	 * @param _path exact path of field (Ex for bloomberg: BDY:DVD_CASH:CP_RECORD_DT)
	 * @return MessageField or null if not found
	 */
	public StaticMessageField getField(String _path) throws Exception {

		StaticMessageField reply=null;
		
		if((reply=this.fieldsMap.get(_path))==null)
			throw new FieldNotFoundException(_path);
		
		return reply;
	}

	/**
	 * Returns a list of message fields that matches the given path<br/>
	 * It's used to recover the repeatable fields ignore repeat indexes in the path
	 * Example:<br/>
	 * 		Existent fields:<br/> 
	 * 		&nbsp;-> 2:O:MIR:DATE<br/>
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(2):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(3):20(C)::CORP//<br/>
	 * 		Path pattern used:
	 * 		&nbsp;-> 4:16R:GENL:20(C)::CORP//<br/>
	 * 		The result should be a list with:
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(2):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(3):20(C)::CORP//<br/>
	 * 		Path pattern used:
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		The result should be a list with:
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(2):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(3):20(C)::CORP//<br/>
	 * @param _path path to find a block of fields 
	 * @return MessageField list, if no results found returns an empty list 
	 */
	public List<StaticMessageField> findFields(String _path) throws Exception {

		List<StaticMessageField> reply = null;

		reply=new ArrayList<StaticMessageField>();
		for (String fieldPath:this.fieldsMap.keySet()) {
			if (fieldPath.replaceAll("\\(*(\\w)\\)", "").equals(_path.replaceAll("\\(*(\\w)\\)", "")))
				reply.add(this.fieldsMap.get(fieldPath));
		}
		if(reply.size()==0)
			throw new FieldNotFoundException(_path);

		return reply;
	}

	/**
	 * Returns a list of message fields that matches the given path pattern<br/>
	 * Can be used the comodin (*) and isn't necessary to use full path name
	 * Example:<br/>
	 * 		Existent fields:<br/> 
	 * 		&nbsp;-> 2:O:MIR:DATE<br/>
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(A)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(B):<br/>
	 * 		&nbsp;-> 4:16R:GENL(3):20(C)::CORP//<br/>
	 * 		Path pattern used:
	 * 		&nbsp;-> 4:16R:GENL(1):20(*):<br/>
	 * 		The result should be a list with:
	 * 		&nbsp;-> 4:16R:GENL(1):20(A)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(1):20(B):<br/>
	 * 		Path pattern used:
	 * 		&nbsp;-> 4:16R:GENL(1):20(*)::<br/>
	 * 		The result should be a list with:
	 * 		&nbsp;-> 4:16R:GENL(1):20(A)::CORP//<br/>
	 * 		Path pattern used:
	 * 		&nbsp;-> 4:16R:GENL(*):20(C):<br/>
	 * 		The result should be a list with:
	 * 		&nbsp;-> 4:16R:GENL(0):20(C)::CORP//<br/>
	 * 		&nbsp;-> 4:16R:GENL(3):20(C)::CORP//<br/>
	 * @param _path path pattern to find a block of fields 
	 * @return MessageField list and empty list if no matches found
	 */
	public List<StaticMessageField> getMatchFields(String _path) throws Exception {

		List<StaticMessageField> reply = null;
		String regularExpPath=null;

		reply = new ArrayList<StaticMessageField>();
		regularExpPath=_path.replaceAll("\\(","\\\\(");
		regularExpPath=regularExpPath.replaceAll("\\)","\\\\)");
		regularExpPath=regularExpPath.replaceAll("\\*",".*");
		regularExpPath="("+regularExpPath+")(.*)";
		for (String fieldPath:this.fieldsMap.keySet()) {
			if(fieldPath.matches(regularExpPath))
				reply.add(this.fieldsMap.get(fieldPath));
		}
		if(reply.size()==0)
			throw new FieldNotFoundException(_path);

		return reply;
	}

	/**
	 * It's the same as @method(getMatchFields(String)) but acting over the given MessageField list
	 * @param _fields list of fields to search
	 * @param _path pattern to find a block of fields 
	 * @return MessageField list and empty list if no matches found
	 */
	public List<StaticMessageField> getMatchFieldsInList(List<StaticMessageField> _fields, String _path) throws Exception {

		List<StaticMessageField> reply = null;
		String regularExpPath=null;

		reply = new ArrayList<StaticMessageField>();
		regularExpPath=_path.replaceAll("\\(","\\\\(");
		regularExpPath=regularExpPath.replaceAll("\\)","\\\\)");
		regularExpPath=regularExpPath.replaceAll("\\*",".*");
		regularExpPath="("+regularExpPath+")(.*)";
		for(StaticMessageField field:_fields) {
			if(field.path.matches(regularExpPath))
				reply.add(field);
		}
		if(reply.size()==0)
			throw new FieldNotFoundException(_path);

		return reply;
	}

	/**
	 * Translate the given value to the given domain to the format value
	 * @param _domain Domain id where search
	 * @param _value value to translate
	 * @return Translated value or null if domain not exist or not exist for this message format
	 */
	public String getDomainValue(String _domain, String _value) throws Exception {

		String reply = null;
		Map<String, String> domain = null;

		domain=this.manager.getDomain(this.session,_domain, this.normalizedAssetType.getId());
		if(domain!=null)
			reply=domain.get(_value);

		return reply;
	}

	/**
	 * Translate the given value throught the given domain from one cluster to another
	 * @param _value value to translate
	 * @param _domain Domain id where search
	 * @param _fromCluster Cluster origin 
	 * @param _toCluster Cluster destiny
	 * @return First translated value found
	 */
	public String getTranslateValue(String _value,String _domain,String _fromCluster,String _toCluster) throws Exception {
		return this.manager.getDomainTranslation(this.session, _domain, _fromCluster, _toCluster, _value);
	}

	/**
	 * Translate the given value throught the given domain from normal to cluster
	 * @param _value value to translate
	 * @param _domain Domain id where search
	 * @param _toCluster Cluster destiny
	 * @return First translated value found
	 */
	public String getTranslateValueFromNormal(String _value,String _domain,String _toCluster) throws Exception {
		return this.manager.getDomainValue(this.session, _domain, _toCluster, _value);
	}
	
	/**
	 * Translate the given value throught the given domain from cluster to normal
	 * @param _value value to translate
	 * @param _domain Domain id where search
	 * @param _fromCluster Cluster origin 
	 * @return First translated value found
	 */
	public String getTranslateValueToNormal(String _value,String _domain,String _fromCluster) throws Exception {
		return this.manager.getDomainNorm(this.session, _domain, _fromCluster, _value);
	}

	/**
	 * Returns the normalized provider
	 * @return normalized provider
	 */
	public Provider getNormalizedProvider() {
		return normalizedProvider;
	}

	/**
	 * Returns the normalized event type
	 * @return normalized event type
	 */
	public AssetType getNormalizedAssetType() {
		return normalizedAssetType;
	}
	/**
	 * Getter for original message
	 */
	public String getOriginalMessage() {
		return originalMessage;
	}
}
