package com.lynxspa.sdm.installer;

import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.lynxspa.entities.application.Application;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.messages.AssetMessageFieldConfig;
import com.lynxspa.entities.securities.assets.messages.AssetMessageType;
import com.lynxspa.entities.securities.assets.providers.Provider;
import com.lynxspa.sdm.entities.domains.CADomainClusterFormat;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFieldConfig;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.installer.adapters.formats.AssetMessageTypeAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatClusterDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatMessageTypeDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.fields.AssetMessageTypeFieldsDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;
import com.lynxspa.utils.ReflectionUtils;


public class SDMFormatsDataInstaller{

    public static CAMessageFormat installFormat(Session _session,String _user,Application _application,CAFormatDictAdapter _format) throws Exception{
    	
       	CAMessageFormat reply=null;
    	CAMessageType messageType=null;
    	CAMessageFieldConfig messageFieldConfig=null;
    	CADomainClusterFormat clusterFormat=null;
    	HashSet<String> duplicates=null;
    	DomainCluster cluster=null;
    	
    	try {
			reply=new CAMessageFormat(_user,_format);
			_session.save(reply);
			for(CAFormatMessageTypeDictAdapter messageTypeToInsert:getMessageTypes(_format)){
			    messageType=new CAMessageType(_user,reply,messageTypeToInsert.getCode(),messageTypeToInsert.getName());
			    _session.save(messageType);
				duplicates=new HashSet<String>();
				for(CAMessageTypeFieldsDictAdapter fieldToInsert:getMessageTypeFields(_format,messageTypeToInsert)){
					messageFieldConfig=new CAMessageFieldConfig(_user,messageType,fieldToInsert);
					if(duplicates.contains(messageFieldConfig.getId().getPath())){
						throw new Exception("duplicated ["+messageFieldConfig.getId().getPath()+"] in ["+messageTypeToInsert.getCode()+"] for ["+_format.getCode()+"]!");
					}
					duplicates.add(messageFieldConfig.getId().getPath());
			       _session.save(messageFieldConfig);
				}
			}
			for(CAFormatClusterDictAdapter clusterToInsert:getAssociatedClusters(_format)){
				cluster=SDMDomainsDataInstaller.installCluster(_session, _user, _application, clusterToInsert.getDomain(), clusterToInsert.getCluster());
				clusterFormat=new CADomainClusterFormat(_user,cluster,reply);
				_session.save(clusterFormat);
			}
		} catch (RuntimeException e) {
			System.out.println("Error installing Format ["+_format.getCode()+"] to application ["+_application.getId()+"]");
			throw e;
		}
   		
   		return reply;
    }

    public static void installStaticData(Session _session,String _provider,String _user,Application _app,String _name) throws Exception{    	
    	try {
    		// Install Message Types
    		for(AssetMessageTypeAdapter eMessageType:getAssetMessageTypes(_provider)){    			
    			try {
    				Provider provider = null;
    				AssetType assetType = null;
    				provider  = (Provider)_session.createQuery("from Provider where id=:id").setParameter("id",new Long(eMessageType.getProvider())).uniqueResult();
					assetType = (AssetType)_session.createQuery("from AssetType where id=:id").setParameter("id", eMessageType.getAssetType()).uniqueResult();				
					String name = eMessageType.getAssetType()+":"+eMessageType.getProvider();										
					AssetMessageType messageType = new AssetMessageType(_user,provider,assetType,name);
					_session.save(messageType);   				
    			}catch(HibernateException e){
    				System.out.println("Error creating message type for Provider="+eMessageType.getProvider()+", AssetType="+eMessageType.getAssetType()+" Message=["+e.getMessage()+"]");
    			}
    		}
    		    		    		
    		for(AssetMessageType messageType:(List<AssetMessageType>)_session.createQuery("from AssetMessageType").list()){
	    		// Persist AssetMessageFieldConfig	    		
	    		for(AssetMessageTypeFieldsDictAdapter fieldToInsert:getAssetMessageFieldConfigs(_provider)){
	    			AssetMessageFieldConfig messageFieldConfig = new AssetMessageFieldConfig((String)_user,messageType,fieldToInsert);
					_session.save(messageFieldConfig);
				}
    		}
		} catch (RuntimeException e) {
			System.out.println("Error installing Static Message");
			throw e;
		}
    }

	@SuppressWarnings("unchecked")
	private static AssetMessageTypeFieldsDictAdapter[] getAssetMessageFieldConfigs(String provider){
		AssetMessageTypeFieldsDictAdapter[] reply = null;
		Class<AssetMessageTypeFieldsDictAdapter> formatType = null;
		try {
			reply=new AssetMessageTypeFieldsDictAdapter[0];
			formatType=(Class<AssetMessageTypeFieldsDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.formats."+provider+".messages.AssetMessageTypeField");
			reply=formatType.getEnumConstants();
		} catch (Exception e) {
			System.out.println("AssetMessageFields for provider "+provider+" ["+e.getMessage()+"] not found");			
		}	
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	private static AssetMessageTypeAdapter[] getAssetMessageTypes(String provider){
		
		AssetMessageTypeAdapter[] reply=null;
		Class<AssetMessageTypeAdapter> formatType=null;
		
		try {
			reply=new AssetMessageTypeAdapter[0];
			formatType=(Class<AssetMessageTypeAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.formats."+provider+".EAssetMessageType");
			reply=formatType.getEnumConstants();
		} catch (Exception e) {
			System.out.println("MessageTypes for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	private static CAMessageTypeFieldsDictAdapter[] getMessageTypeFields(CAFormatDictAdapter _format,CAFormatMessageTypeDictAdapter _messageType){
		
		CAMessageTypeFieldsDictAdapter[] reply=null;
		Class<CAMessageTypeFieldsDictAdapter> formatType=null;
		
		try {
			reply=new CAMessageTypeFieldsDictAdapter[0];
			formatType=(Class<CAMessageTypeFieldsDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.formats."+_format.getCode().toLowerCase()+".messages.CAMessageType"+_messageType.getCode().toUpperCase()+"Field");
			reply=formatType.getEnumConstants();
		} catch (Exception e) {
			System.out.println("MessageTypeFields for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
	}

	@SuppressWarnings("unchecked")
	private static CAFormatMessageTypeDictAdapter[] getMessageTypes(CAFormatDictAdapter _format){
		
		CAFormatMessageTypeDictAdapter[] reply=null;
		Class<CAFormatMessageTypeDictAdapter> formatType=null;
		
		try {
			reply=new CAFormatMessageTypeDictAdapter[0];
			System.out.println("Clase: com.lynxspa.sdm.dictionaries.formats."+_format.getCode().toLowerCase()+".CAMessageType");
			formatType=(Class<CAFormatMessageTypeDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.formats."+_format.getCode().toLowerCase()+".CAMessageType");
			reply=formatType.getEnumConstants();
		} catch (Exception e) {
			System.out.println("MessageTypes for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	private static CAFormatClusterDictAdapter[] getAssociatedClusters(CAFormatDictAdapter _format){
		
		CAFormatClusterDictAdapter[] reply=null;
		Class<CAFormatClusterDictAdapter> formatCluster=null;
		
		try {
			reply=new CAFormatClusterDictAdapter[0];
			formatCluster=(Class<CAFormatClusterDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.formats."+_format.getCode().toLowerCase()+".CADomainCluster");
			reply=formatCluster.getEnumConstants();
		} catch (Exception e) {
			System.out.println("AssociatedClusters for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
	}
}
