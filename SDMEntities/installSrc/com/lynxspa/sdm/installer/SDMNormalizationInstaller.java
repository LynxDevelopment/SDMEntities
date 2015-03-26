package com.lynxspa.sdm.installer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;
import com.lynxspa.entities.application.Application;
import com.lynxspa.exception.FPMException;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.CAType;
import com.lynxspa.sdm.dictionaries.events.BasicEventDetail;
import com.lynxspa.sdm.dictionaries.providers.BasicProviders;
import com.lynxspa.sdm.entities.events.configuration.CAEventConfig;
import com.lynxspa.sdm.entities.events.configuration.CAEventFieldConfig;
import com.lynxspa.sdm.entities.events.configuration.CAEventFieldMessageConfig;
import com.lynxspa.sdm.entities.events.configuration.CAEventMasterRecordConfig;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;
import com.lynxspa.sdm.entities.events.providers.CAFormatProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;
import com.lynxspa.sdm.installer.adapters.events.EventDetailAdapter;
import com.lynxspa.sdm.installer.adapters.events.configuration.EventConfigAdapter;
import com.lynxspa.sdm.installer.adapters.events.configuration.EventFieldConfigAdapter;
import com.lynxspa.sdm.installer.adapters.events.configuration.EventFieldMessageConfigAdapter;
import com.lynxspa.sdm.installer.adapters.events.configuration.EventFieldMessageProviderConfigAdapter;
import com.lynxspa.sdm.installer.adapters.events.configuration.EventMRConfigAdapter;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;
import com.lynxspa.utils.ReflectionUtils;

public class SDMNormalizationInstaller implements DbDataInstaller {

	protected String user=null;
	protected Application application=null;
	protected String configurationClassPath=null;

	
	public SDMNormalizationInstaller(){
		super();
		this.user="DEMOINSTALLER";
	}
	
	public void createData(Session _session) throws Exception {
		this.application=(Application)_session.get(Application.class,"SDM");
    	this.configurationClassPath="com.lynxspa.sdm.dictionaries.events.configuration";
    	System.out.println("Borrando registros de la base de datos");
    	deleteAll(_session);
    	System.out.println("Instalando datos en TB_CA_EVENTTYPEDETAILS");
    	installEventTypeDetails(_session);
    	System.out.println("Instalando datos de Normalizacion");
    	installEventTypeConfigurations(_session);
    	System.out.println("Datos de normalización instalados");
	}


	protected void deleteAll(Session _session) throws Exception{
		Query query=null;
		int affectedValues=0;
		
    	query = _session.createQuery("delete CAEventFieldMessageConfig");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTCONFIGMSGFLDS:"+affectedValues);
    	query = _session.createQuery("delete CAEventFieldConfig");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTCONFIGFIELDS:"+affectedValues);
    	query = _session.createQuery("delete CAEventMasterRecordConfig");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTMRCONFIGS:"+affectedValues);
		query = _session.createQuery("delete CAEventTypeDetail");
		affectedValues=query.executeUpdate();
		System.out.println("Registros borrados de la tabla  TB_CA_EVENTTYPEDETAILS:"+affectedValues);
		query = _session.createQuery("delete CAEventConfig");
		affectedValues=query.executeUpdate();
		System.out.println("Registros borrados de la tabla  TB_CA_EVENTCONFIGS:"+affectedValues);
	}
	
	@SuppressWarnings("unchecked")
	protected void installEventTypeConfigurations(Session _session) throws Exception{
    	
    	Query query=null;
    	CAEventConfig eventConfig=null;
    	CAEventFieldConfig eventFieldConfig=null;
    	CAEventMasterRecordConfig masterRecordConfig=null;
    	CAEventFieldMessageConfig eventFieldMessageConfig=null;
    	Map<String,CAEventFieldConfig> eventFieldConfigInstalled=null;
    	Map<String,CAFormatProvider> formatProviders=null;
    	Map<String,EventConfigAdapter> eventConfigs=null;
    	EventConfigAdapter eventConfigAdapter=null;
    	Map<String,EventFieldConfigAdapter> eventFieldConfigs=null;
    	EventFieldConfigAdapter eventFieldConfigAdapter=null;
    	Class<EventFieldMessageConfigAdapter> eventFieldMessageConfigClass=null;
    	Class<EventFieldMessageProviderConfigAdapter> eventFieldMessageProviderConfigClass=null;
    	List<EventMRConfigAdapter> masterRecordConfigs=null;
    	Map<String,CAEventTypeDetail> eventDetails=null;
    	
    	System.out.println("installEventTypeConfigurations");
    	//Recover global data
    	eventConfigs=getEventConfigs();
    	formatProviders=getProviders(_session);
    	//Start processing
    	query=_session.createQuery("from CAEventType");
    	for(Object eventType:query.list()){
    		//Install event config
    		System.out.println("Install event config");
    		eventConfig=new CAEventConfig(this.user,(CAEventType)eventType);
			eventConfig.setPreferentProvider((CAEventProvider)_session.load(CAEventProvider.class,BasicProviders.MANUAL.getCode()));
			eventConfig.setOnPrimaryAndSecondaryNotFound(Consequence.ALERTANDMANUAL.getCode());
			eventConfig.setOnCustodianAndManualNotFound(Consequence.ALERTANDMASTERRECORD.getCode());
    		if((eventConfigAdapter=eventConfigs.get(((CAEventType)eventType).getId()))!=null){
    			if(eventConfigAdapter.getPreferentProvider()!=null)
        			eventConfig.setPreferentProvider((CAEventProvider)_session.load(CAEventProvider.class,eventConfigAdapter.getPreferentProvider()));
    			if(eventConfigAdapter.getSecondPreferentProvider()!=null)
    				eventConfig.setSecondPreferentProvider((CAEventProvider)_session.load(CAEventProvider.class,eventConfigAdapter.getSecondPreferentProvider()));
    			eventConfig.setOnPrimaryAndSecondaryNotFound(eventConfigAdapter.getOnPrimaryAndSecondaryNotFound());
    			eventConfig.setOnCustodianAndManualNotFound(eventConfigAdapter.getOnCustodianAndManualNotFound());
    		}
    		_session.save(eventConfig);
    		//Install event field config
    		System.out.println("Install event field config");
    		eventFieldConfigInstalled=new HashMap<String, CAEventFieldConfig>();
    		eventFieldConfigs=getEventFieldConfigs(eventConfig.getEventType().getId());
        	query=_session.createQuery("from CAEventTypeDetail where eventType.id=:eventTypeId");
        	query.setParameter("eventTypeId", ((CAEventType)eventType).getId());
        	eventDetails=new HashMap<String, CAEventTypeDetail>();
        	for(Object eventTypeDetail:query.list()){
        		eventDetails.put(((CAEventTypeDetail)eventTypeDetail).getFieldPath(),(CAEventTypeDetail)eventTypeDetail);
        		eventFieldConfig=new CAEventFieldConfig(this.user,eventConfig,(CAEventTypeDetail)eventTypeDetail);
        		if((eventFieldConfigAdapter=eventFieldConfigs.get(((CAEventTypeDetail)eventTypeDetail).getFieldPath()))!=null){
        			eventFieldConfig.setRequired(eventFieldConfigAdapter.isRequired());
        		}
        		_session.save(eventFieldConfig);
        		eventFieldConfigInstalled.put(((CAEventTypeDetail)eventTypeDetail).getFieldPath(), eventFieldConfig);
        	}
        	
    		//Install event master record configs
        	System.out.println("Install event master record configs for "+eventConfig.getEventType().getId());
    		masterRecordConfigs=getEventMRConfigs(eventConfig.getEventType().getId());
    		for(EventMRConfigAdapter masterRecordConfigAdapter:masterRecordConfigs){
    			masterRecordConfig=new CAEventMasterRecordConfig(this.user,eventConfig);
    			masterRecordConfig.setRuleOrder(masterRecordConfigAdapter.getRuleOrder());
    			masterRecordConfig.setTarget(masterRecordConfigAdapter.getTarget());
    			if (eventDetails.get(masterRecordConfigAdapter.getFieldPath())==null){
    				System.out.println("EventDetail with path "+masterRecordConfigAdapter.getFieldPath()+" didn't found");
    				throw new Exception("EventDetail with path "+masterRecordConfigAdapter.getFieldPath()+" didn't found");
    			}
    			masterRecordConfig.setDetail(eventDetails.get(masterRecordConfigAdapter.getFieldPath()));
    			masterRecordConfig.setCondition(masterRecordConfigAdapter.getCondition());
    			masterRecordConfig.setOnTrueResult(masterRecordConfigAdapter.getOnTrueResult());
    			masterRecordConfig.setOnFalseResult(masterRecordConfigAdapter.getOnFalseResult());
    			masterRecordConfig.setConditionParams(masterRecordConfigAdapter.getConditionParams());
    			_session.save(masterRecordConfig);
    		}
    		//Install event field message
    		System.out.println("Install event field message");
    		query=_session.createQuery("from CAMessageType");
        	for(Object messageType:query.list()){
        		eventFieldMessageConfigClass=getEventFieldMessageConfigs(eventConfig.getEventType().getId(),((CAMessageType)messageType).getId().getFormat().getId(),((CAMessageType)messageType).getId().getCode());
        		if(eventFieldMessageConfigClass!=null){
        			for(EventFieldMessageConfigAdapter messageAdapter:eventFieldMessageConfigClass.getEnumConstants()){
        				if (eventFieldConfigInstalled.containsKey(messageAdapter.getFieldPath())){
	        				eventFieldConfig=eventFieldConfigInstalled.get(messageAdapter.getFieldPath());
	        				eventFieldMessageConfig=new CAEventFieldMessageConfig(this.user,eventFieldConfig,(CAMessageType)messageType);
	        				eventFieldMessageConfig.setNormalizationScript(messageAdapter.getNormalizationScript());
	        				_session.save(eventFieldMessageConfig);
        				}else{
        					System.out.println("FieldPath "+messageAdapter.getFieldPath()+ " in ["+this.configurationClassPath+"."+eventConfig.getEventType().getId()+"Event"+((CAMessageType)messageType).getId().getFormat().getId()+"Format"+((CAMessageType)messageType).getId().getCode()+"TypeConfig"+"] not found in "+ eventConfig.getEventType().getId() +"EventDetail");
        					throw new Exception("FieldPath not found"+messageAdapter.getFieldPath());
        				}
        			}
        		}
            	for(String providerId:formatProviders.keySet()){
            		if(formatProviders.get(providerId).getMessageFormat().getId().equals(((CAMessageType)messageType).getId().getFormat().getId())){
	            		eventFieldMessageProviderConfigClass=getEventFieldMessageProviderConfigs(eventConfig.getEventType().getId(),((CAMessageType)messageType).getId().getFormat().getId(),((CAMessageType)messageType).getId().getCode(),providerId);
	            		if(eventFieldMessageProviderConfigClass!=null){
	            			for(EventFieldMessageProviderConfigAdapter messageAdapter:eventFieldMessageProviderConfigClass.getEnumConstants()){
	                			eventFieldConfig=eventFieldConfigInstalled.get(messageAdapter.getFieldPath());
	            				eventFieldMessageConfig=new CAEventFieldMessageConfig(this.user,eventFieldConfig,(CAMessageType)messageType,formatProviders.get(providerId).getEventProvider());
	            				eventFieldMessageConfig.setNormalizationScript(messageAdapter.getNormalizationScript());
	            				_session.save(eventFieldMessageConfig);
	            			}
	            		}
            		}
            	}
            }
    	}
    }

    protected Map<String,CAFormatProvider> getProviders(Session _session){
    	
    	Map<String,CAFormatProvider> reply=null;
    	Query query=null;

    	reply=new HashMap<String, CAFormatProvider>();	
		query=_session.createQuery("from CAFormatProvider");
		for(Object provider:query.list()){
			reply.put(((CAFormatProvider)provider).getEventProvider().getId(), (CAFormatProvider)provider);
		}
		
		return reply;
    }

    @SuppressWarnings("unchecked")
	protected Map<String,EventConfigAdapter> getEventConfigs() throws Exception{
    	
    	Map<String,EventConfigAdapter> reply=null;
    	Class<EventConfigAdapter> eventConfigClass=null;

    	reply=new HashMap<String, EventConfigAdapter>();
    	try{
	    	eventConfigClass=(Class<EventConfigAdapter>)ReflectionUtils.instanceClass(this.configurationClassPath+".masterrecord.EventConfig");
			for(EventConfigAdapter eventConfig:eventConfigClass.getEnumConstants()){
				reply.put(eventConfig.getEventType(),eventConfig);
			}
		}catch (Exception e) {
			System.out.println("Event configuration not found");			
		}
 		
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	protected List<EventMRConfigAdapter> getEventMRConfigs(String _eventTypeId) throws Exception{
    	
    	List<EventMRConfigAdapter> reply=null;
    	Class<EventMRConfigAdapter> eventConfigClass=null;

    	reply=new ArrayList<EventMRConfigAdapter>();
    	try{
	    	eventConfigClass=(Class<EventMRConfigAdapter>)ReflectionUtils.instanceClass(this.configurationClassPath+".masterrecord."+_eventTypeId+"MRConfig");
			for(EventMRConfigAdapter eventConfig:eventConfigClass.getEnumConstants()){
				reply.add(eventConfig);
			}
		}catch (Exception e) {
			System.out.println("Master record configuration for ["+this.configurationClassPath+".masterrecord."+_eventTypeId+"MRConfig] not found");			
		}
 		
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	protected Map<String,EventFieldConfigAdapter> getEventFieldConfigs(String _eventType) throws Exception{
    	
    	Map<String,EventFieldConfigAdapter> reply=null;
    	Class<EventFieldConfigAdapter> eventConfigClass=null;

    	reply=new HashMap<String, EventFieldConfigAdapter>();
    	try{
	    	eventConfigClass=(Class<EventFieldConfigAdapter>)ReflectionUtils.instanceClass(this.configurationClassPath+"."+_eventType+"TypeEventConfig");
			for(EventFieldConfigAdapter eventConfig:eventConfigClass.getEnumConstants()){
				reply.put(eventConfig.getFieldPath(),eventConfig);
			}
    	}catch (Exception e) {
    		System.out.println("Configuration for ["+e.getMessage()+"] not found");			
		}
 		
		return reply;
    }

    @SuppressWarnings("unchecked")
	protected Class<EventFieldMessageConfigAdapter> getEventFieldMessageConfigs(String _eventType,String _messageFormat,String _messageType) throws Exception{
    	
    	Class<EventFieldMessageConfigAdapter> reply=null;

    	try{
    		System.out.println("MyConfiguration for ["+this.configurationClassPath+"."+_eventType+"Event"+_messageFormat+"Format"+_messageType+"TypeConfig"+"]");
    		reply=(Class<EventFieldMessageConfigAdapter>)ReflectionUtils.instanceClass(this.configurationClassPath+"."+_eventType+"Event"+_messageFormat+"Format"+_messageType+"TypeConfig");
    		System.out.println("Configuration for ["+this.configurationClassPath+"."+_eventType+"Event"+_messageFormat+"Format"+_messageType+"TypeConfig"+"] found");			
    	}catch (Exception e) {
    		System.out.println("Configuration for ["+e.getMessage()+"] not found");			
		}
 		
		return reply;
    }

    @SuppressWarnings("unchecked")
	protected Class<EventFieldMessageProviderConfigAdapter> getEventFieldMessageProviderConfigs(String _eventType,String _messageFormat,String _messageType,String _provider) throws Exception{
    	
    	Class<EventFieldMessageProviderConfigAdapter> reply=null;

    	try{
    		reply=(Class<EventFieldMessageProviderConfigAdapter>)ReflectionUtils.instanceClass(this.configurationClassPath+"."+_eventType+"Event"+_messageFormat+"Format"+_messageType+"Type"+_provider+"ProviderConfig");
    		System.out.println("Configuration for ["+this.configurationClassPath+"."+_eventType+"Event"+_messageFormat+"Format"+_messageType+"Type"+_provider+"ProviderConfig"+"] found");			
    	}catch (Exception e) {
    		System.out.println("Configuration for ["+e.getMessage()+"] not found");			
		}
 		
		return reply;
    }
    
   private void installEventTypeDetails(Session _session) throws FPMException{
    	
    	CAEventType eventType=null;
    	CAEventTypeDetail eventTypeDetail=null;
    	
		final Query query=HibernateUtils.createQuery(_session,"from CAEventTypeDetail where eventType.id=:eventTypeId and fieldPath=:fieldPath");
    	for(CAType typeToInstall:CAType.values()){
    		eventType=new CAEventType(this.user,typeToInstall);

    		for(EventDetailAdapter detailToAdd:BasicEventDetail.values()){
    			eventTypeDetail=new CAEventTypeDetail(this.user,eventType,detailToAdd);
		    	_session.save(eventTypeDetail);
			}
			query.setString("eventTypeId",eventType.getId());
    		for(EventDetailAdapter detailToAdd:getEventTypeDetails(_session,eventType)){
    			query.setString("fieldPath",detailToAdd.getFieldPath());
    			if((eventTypeDetail=(CAEventTypeDetail)query.uniqueResult())==null){
        			eventTypeDetail=new CAEventTypeDetail(this.user,eventType,detailToAdd);
    		    	_session.save(eventTypeDetail);
    			}else{
    				eventTypeDetail.setFormat(detailToAdd.getFormat());
    				eventTypeDetail.setMaxLength(((detailToAdd.getMaxLength()==0)? detailToAdd.getFieldType().getMaxLength() : ((detailToAdd.getMaxLength()>detailToAdd.getFieldType().getMaxLength())? detailToAdd.getFieldType().getMaxLength() : detailToAdd.getMaxLength())));
    				eventTypeDetail.setDisplayInTable(detailToAdd.isDisplayInTable());
    				eventTypeDetail.setDisplayInTableOrder(detailToAdd.getDisplayInTableOrder());
    				eventTypeDetail.setDisplayGroup(detailToAdd.getDisplayGroup());
    				eventTypeDetail.setDisplayGroupOrder(detailToAdd.getDisplayGroupOrder());
    				eventTypeDetail.setDisplayInGroupOrder(detailToAdd.getDisplayInGroupOrder());
    				eventTypeDetail.setHidden(detailToAdd.isHidden());
    		    	_session.update(eventTypeDetail);
    			}
			}
    	}
    }
   
   @SuppressWarnings("unchecked")
	private EventDetailAdapter[] getEventTypeDetails(Session _session,CAEventType _type){

   	EventDetailAdapter[] reply=null;
		Class<EventDetailAdapter> formatType=null;
		
		try {
			reply=new EventDetailAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.events."+_type.getId().toUpperCase()+"EventDetail");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Norms for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
   }

}
