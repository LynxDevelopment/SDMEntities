package com.lynxspa.sdm.processors.normalize.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.managers.SDMConfigManager;


public class EventMessageWrapper {
	
	private CAMessageType messageType = null;
	private Map<String, MessageField> fieldsMap = null;
	protected SDMConfigManager manager = null;
	private Session session = null;
	private SPSecurity normalizedSecurity=null; 
	private String normalizedOperation=null; 
	private CAExternalEventProvider normalizedProvider=null; 
	private CAEventType normalizedEventType=null;
	private String originalMessage;
	
	
	public EventMessageWrapper(Session _session, List<MessageField> _fields,CAMessageType _messageType,SPSecurity _normalizedSecurity,String _normalizedOperation,CAExternalEventProvider _normalizedProvider,CAEventType _normalizedEventType,String _originalMessage) throws Exception {
		
		this.session=_session;
		this.messageType=_messageType;
		this.manager=SDMConfigManager.getInstance();
		this.fieldsMap=new HashMap<String, MessageField>();
		this.normalizedSecurity=_normalizedSecurity;
		this.normalizedOperation=_normalizedOperation;
		this.normalizedProvider=_normalizedProvider;
		this.normalizedEventType=_normalizedEventType;
		for (MessageField messageField:_fields) {
			this.fieldsMap.put(messageField.path, messageField);
		}
		this.originalMessage=_originalMessage;
	}

	/**
	 * Returns a Map that contains the message fields by message path
	 * @return map with message path as key and MessageField as value
	 */
	public Map<String, MessageField> getFieldsMap(){
		return this.fieldsMap;
	}

	/**
	 * Returns a field from a path
	 * @param _path exact path of field (Ex for bloomberg: BDY:DVD_CASH:CP_RECORD_DT)
	 * @return MessageField or null if not found
	 */
	public MessageField getField(String _path) throws Exception {

		MessageField reply=null;
		
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
	public List<MessageField> findFields(String _path) throws Exception {

		List<MessageField> reply = null;

		reply=new ArrayList<MessageField>();
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
	public List<MessageField> getMatchFields(String _path) throws Exception {

		List<MessageField> reply = null;
		String regularExpPath=null;

		reply = new ArrayList<MessageField>();
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
	public List<MessageField> getMatchFieldsInList(List<MessageField> _fields, String _path) throws Exception {

		List<MessageField> reply = null;
		String regularExpPath=null;

		reply = new ArrayList<MessageField>();
		regularExpPath=_path.replaceAll("\\(","\\\\(");
		regularExpPath=regularExpPath.replaceAll("\\)","\\\\)");
		regularExpPath=regularExpPath.replaceAll("\\*",".*");
		regularExpPath="("+regularExpPath+")(.*)";
		for(MessageField field:_fields) {
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

		domain=this.manager.getDomain(this.session,_domain, this.messageType.getId().getFormat().getId());
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
	 * Returns the normalized Security
	 * @return normalized security
	 */
	public SPSecurity getNormalizedSecurity() {
		return normalizedSecurity;
	}

	/**
	 * Returns the normalized Operation
	 * @return normalized security
	 */
	public String getNormalizedOperation() {
		return normalizedOperation;
	}

	/**
	 * Returns the normalized provider
	 * @return normalized provider
	 */
	public CAExternalEventProvider getNormalizedProvider() {
		return normalizedProvider;
	}

	/**
	 * Returns the normalized event type
	 * @return normalized event type
	 */
	public CAEventType getNormalizedEventType() {
		return normalizedEventType;
	}
	/**
	 * Getter for original message
	 */
	public String getOriginalMessage() {
		return originalMessage;
	}
	
}
