package com.lynxspa.sdm.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.dictionaries.DomainNormalCluster;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;
import com.lynxspa.exception.FPMException;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.managers.ConfigManager;
import com.lynxspa.sdm.dictionaries.config.CAConfiguration;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.entities.events.adapters.CAEventCollectedAdapter;
import com.lynxspa.sdm.entities.events.configuration.CAEventConfig;
import com.lynxspa.sdm.entities.events.configuration.CAEventFieldMessageConfig;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageAdapter;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFieldConfig;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageTypeId;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;
import com.lynxspa.sdm.processors.normalize.NormalizeScriptConfigBean;
import com.lynxspa.sdm.utils.CAEventTypeDetailComparator;


public class SDMConfigManager extends ConfigManager{

	public static final String APPLICATIONNAME="SDM";
	public static final String BUNDLENAME="sdm";
	
	
	public static SDMConfigManager instance=null;

	
	private Map<String,Object> processors=null;
	private Map<String,CAMessageFormat> messageFormats=null;
	private Map<CAMessageFormat,Map<String,CAMessageType>> messageTypes=null;
	private Map<String,Map<String,CAMessageFieldConfig>> messageFieldConfigs=null;
	private Map<String,Map<String,DomainClusterDictAdapter>> formatsClusters=null;
	private Map<String,Integer> securityProviderIdFields=null;
	private Map<String,List<NormalizeScriptConfigBean>> normalizationScripts=null;
	private Map<String,CAEventConfig> eventConfigurations=null;
	private Map<String,List<CAEventTypeDetail>> eventDetails=null;
	
	@SuppressWarnings("unchecked")
	private SDMConfigManager(){
	
		super();
		initialize();
	}

	public static SDMConfigManager getInstance(){
		
		if(SDMConfigManager.instance==null){
			synchronized(SDMConfigManager.class){
				if(SDMConfigManager.instance==null){
					SDMConfigManager.instance=new SDMConfigManager();
				}
			}
		}
		
		return SDMConfigManager.instance;
	}

	public void initialize(){
		super.initialize();
		synchronized(SDMConfigManager.class){
			this.processors=new HashMap<String, Object>();
			this.messageFormats=new HashMap<String, CAMessageFormat>();
			this.messageTypes=new HashMap<CAMessageFormat, Map<String,CAMessageType>>();
			this.messageFieldConfigs=new HashMap<String,Map<String,CAMessageFieldConfig>>();
			this.formatsClusters=new HashMap<String, Map<String,DomainClusterDictAdapter>>();
			this.securityProviderIdFields=new HashMap<String, Integer>();
			this.normalizationScripts=new HashMap<String, List<NormalizeScriptConfigBean>>();
			this.eventConfigurations=new HashMap<String,CAEventConfig>();
			this.eventDetails=new HashMap<String,List<CAEventTypeDetail>>();
		}
	}
	
	@Override
	public String getApplicationName() {
		return SDMConfigManager.APPLICATIONNAME;
	}
	@Override
	public String getBundleName(){
		return SDMConfigManager.BUNDLENAME;
	}

	//Processors Loader
	public Object getProcessor(final Session _session,final CAConfiguration _configuration) throws FPMException{

		Object reply=null;
		
		if((reply=this.processors.get(_configuration.getCode()))==null){
			synchronized(SDMConfigManager.class) {
				if((reply=this.processors.get(_configuration.getCode()))==null){
					try{
						reply=Class.forName((String)getConfiguration(_session,_configuration)).newInstance();
						this.processors.put(_configuration.getCode(),reply);
					}catch (FPMException e) {
						throw e;
					}catch (Exception e) {
						throw new FPMException(LogErrorDict.PROCESSOR_CLASS_NOT_FOUND,new Object[]{_configuration.getCode()},e);
					}
					
				}					
			}
		}

		return reply;
	}

	//Domains Loader
	@SuppressWarnings("unchecked")
	private DomainClusterDictAdapter loadCluster (final Session _session,final String _domain,final String _format) throws FPMException{
	
		DomainClusterDictAdapter reply=null;
		Query query=null;
		
		try{
			query=_session.createQuery("" +
					"select " +
					"	clusterformat.id.domainCluster " +
					"from " +
					"	CADomainClusterFormat clusterformat " +
					"where " +
					"	clusterformat.id.format.id=:format and " +
					"	clusterformat.id.domainCluster.id.domain.id.application=:application and " +
					"	clusterformat.id.domainCluster.id.domain.id.code=:domain");
			query.setParameter("format", _format);
			query.setParameter("application", getApplication(_session));
			query.setParameter("domain", _domain);
			reply=(DomainCluster)query.uniqueResult();
		}catch (Exception e) {
			throw new FPMException(LogErrorDict.PROCESSOR_DOMAIN_CLUSTER_LOAD_FAIL,new Object[]{_format,_domain},e);
		}
		
		return reply;
	}
	public Map<String,String> getDomain(final Session _session,final String _domain,final String _format) throws FPMException{
		
		Map<String,String> reply=null;
		DomainClusterDictAdapter cluster=null;
		Map<String,DomainClusterDictAdapter> formats=null;
		
		try{
			reply=new HashMap<String, String>();
			if((formats=this.formatsClusters.get(_domain))==null){
				synchronized(SDMConfigManager.class) {
					if((formats=this.formatsClusters.get(_domain))==null){
						cluster=loadCluster(_session,_domain,_format);
						formats=new HashMap<String, DomainClusterDictAdapter>();
						formats.put(_format, cluster);
						this.formatsClusters.put(_domain,formats);
					}
				}
			}
			if((cluster=formats.get(_format))==null){
				synchronized(SDMConfigManager.class) {
					if((cluster=formats.get(_format))==null){
						cluster=loadCluster(_session,_domain,_format);
						formats.put(_format, cluster);
					}
				}
			}
			if(cluster!=null)
				reply=getDomain(_session,_domain, cluster.getCode(), DomainNormalCluster.NORMAL.getCode());
		}catch(FPMException e){
			throw e;
		}catch(Throwable e){
			throw new FPMException(LogErrorDict.PROCESSOR_DOMAIN_FORMAT_LOAD_FAIL,new Object[]{_format,_domain},e);
		}
		
		return reply;
	}
	public Map<String,String> getDomain(final Session _session,final String _domain,final CAEventMessage _message) throws FPMException{
		return getDomain(_session,_domain,_message.getMessageType().getId().getFormat().getId());
	}

	public String getDomainNorm(final Session _session,final String _domain,final CAMessageFormat _format,final String _value) throws FPMException{
		return getDomain(_session,_domain,_format.getId()).get(_value);
	}
	public String getDomainNorm(final Session _session,final String _domain,final CAEventMessage _message,final String _value) throws FPMException{
		return getDomainNorm(_session,_domain,_message.getMessageType().getId().getFormat(),_value);
	}
	public String getDomainNorm(final Session _session,final String _domain,final DomainClusterDictAdapter _cluster,final String _value) throws FPMException{
		return getDomain(_session,_domain,_cluster.getCode(),DomainNormalCluster.NORMAL.getCode()).get(_value);
	}
	public String getDomainNorm(final Session _session,final String _domain,final String _cluster,final String _value) throws FPMException{
		return getDomain(_session,_domain,_cluster,DomainNormalCluster.NORMAL.getCode()).get(_value);
	}
	public String getDomainValue(final Session _session,final String _domain,final String _cluster,final String _value) throws FPMException{
		return getDomain(_session,_domain,DomainNormalCluster.NORMAL.getCode(),_cluster).get(_value);
	}
	public String getDomainTranslation(final Session _session,final String _domain,final String _fromCluster,final String _toCluster,final String _value) throws FPMException{
		return getDomain(_session,_domain,_fromCluster,_toCluster).get(_value);
	}
	
	//Message formats and types load
	public CAMessageFormat getMessageFormat(final Session _session,final String _format) throws FPMException{
		
		CAMessageFormat reply=null;
		
		if((reply=this.messageFormats.get(_format))==null){
			synchronized(SDMConfigManager.class) {
				if((reply=this.messageFormats.get(_format))==null){
					try{
						reply=(CAMessageFormat)_session.get(CAMessageFormat.class,_format);
						if(reply==null)
							throw new FPMException(LogErrorDict.FORMAT_NOT_INSTALLED,new Object[]{_format});
						this.messageFormats.put(_format,reply);
					}catch (FPMException e) {
						throw e;
					}catch (Exception e) {
						throw new FPMException(LogErrorDict.FORMAT_LOAD_FAIL,new Object[]{_format},e);
					}
				}					
			}
		}
				
		return reply;
	}
	public CAMessageType getMessageType(final Session _session,final String _format,final String _type) throws FPMException{
		
		CAMessageType reply=null;
		Map<String,CAMessageType> typesofFormat=null;
		
		try{
			final CAMessageFormat format=getMessageFormat(_session,_format);
			if((typesofFormat=this.messageTypes.get(format))==null){
				synchronized(SDMConfigManager.class) {
					if((typesofFormat=this.messageTypes.get(format))==null){
						reply=(CAMessageType)_session.get(CAMessageType.class, new CAMessageTypeId(format,_type));
						if(reply==null)
							throw new FPMException(LogErrorDict.MESSAGETYPE_NOT_INSTALLED,new Object[]{_type,_format});
						typesofFormat=new HashMap<String, CAMessageType>();
						typesofFormat.put(_type, reply);
						this.messageTypes.put(format, typesofFormat);
					}					
				}
			}
			if((reply=typesofFormat.get(_type))==null){
				synchronized(SDMConfigManager.class) {
					if((reply=typesofFormat.get(_type))==null){
						reply=(CAMessageType)_session.get(CAMessageType.class, new CAMessageTypeId(format,_type));
						if(reply==null)
							throw new FPMException(LogErrorDict.MESSAGETYPE_NOT_INSTALLED,new Object[]{_type,_format});
						typesofFormat.put(_type, reply);
					}
				}
			}
		}catch(FPMException e){
			throw e;
		}catch(Throwable e){
			throw new FPMException(LogErrorDict.MESSAGETYPE_LOAD_FAIL,new Object[]{_type,_format},e);
		}

		return reply;
	}
	
	public Integer getSecurityProviderIdField (final Session _session,final String _infoProvider) throws FPMException{
		
		Integer reply=null;
		
		if(this.securityProviderIdFields.size()==0){
			synchronized(SDMConfigManager.class) {
				if(this.securityProviderIdFields.size()==0){
					final String assignmentFields=(String)getConfiguration(_session,CAConfiguration.SECURITYFIELDASSIGNMENTPROVIDER);
					final String[] assignments=assignmentFields.split(",");
					for(String assignment:assignments){
						final String[] values=assignment.split("=");
						this.securityProviderIdFields.put(values[0],Integer.parseInt(values[1]));
					}
				}				
			}
		}
		reply=this.securityProviderIdFields.get(_infoProvider);
		
		return reply;
	}
	
	//Normalization scripts
	@SuppressWarnings("unchecked")
	private List<NormalizeScriptConfigBean> LoadNormalizationScripts(final Session _session,final CAEventType _eventType,final CAMessageType _messageType,final CAExternalEventProvider _provider) throws FPMException{
	
		List<NormalizeScriptConfigBean> reply=null;
		List<CAEventFieldMessageConfig> eventFieldMessageConfigList=null;
		
		//Search for provider level scripts configuration
		final Map<String,NormalizeScriptConfigBean> configurationBeans=new HashMap<String, NormalizeScriptConfigBean>();
		final Query query=_session.createQuery("" +
				"select " +
				"	messageFieldConfig " +
				"from " +
				"	CAEventFieldMessageConfig as messageFieldConfig " +
				"	join " +
				"		messageFieldConfig.eventFieldConfig as eventFieldConfig " +
				"	join " +
				"		eventFieldConfig.eventTypeDetail " +
				"	join " +
				"		eventFieldConfig.eventConfig as eventConfig " +
				"		with " +
				"			eventConfig.eventType.id=:eventTypeId " +
				"where " +
				"	messageFieldConfig.messageType.id.code=:messageTypeId and " +
				"	messageFieldConfig.messageType.id.format.id=:formatId and " +
				"	( " +
				"		messageFieldConfig.provider is null or " +
				"		messageFieldConfig.provider.id=:providerId " +
				"	) and" +
				"	messageFieldConfig.normalizationScript is not null " +
				"order by " +
				"	messageFieldConfig.provider " +
				"desc ");
		query.setParameter("eventTypeId", _eventType.getId());
		query.setParameter("messageTypeId",_messageType.getId().getCode());
		query.setParameter("formatId",_messageType.getId().getFormat().getId());
		query.setParameter("providerId", _provider.getId());
		if(((eventFieldMessageConfigList=query.list())!=null)&&(eventFieldMessageConfigList.size()>0)){
			for(CAEventFieldMessageConfig eventFieldMessageConfig:eventFieldMessageConfigList){
				configurationBeans.put(eventFieldMessageConfig.getEventFieldConfig().getEventTypeDetail().getFieldPath(),new NormalizeScriptConfigBean(eventFieldMessageConfig.getEventFieldConfig().getEventTypeDetail().getFieldPath(),eventFieldMessageConfig.getNormalizationScript(),eventFieldMessageConfig.getEventFieldConfig().getEventTypeDetail().isExtension()));
			}
		}
		if(!configurationBeans.isEmpty())
			reply=new ArrayList<NormalizeScriptConfigBean>(configurationBeans.values());
		
		return reply;
	}
	
	public List<NormalizeScriptConfigBean> getNormalizationScripts(final Session _session,final CAEventType _eventType,final CAMessageType _messageType,final CAExternalEventProvider _provider) throws FPMException{
		
		List<NormalizeScriptConfigBean> reply=null;
		
		final String normalizationScriptKey=_eventType.getId()+_messageType.getId().getCode()+_messageType.getId().getFormat().getId()+_provider.getId();
		if((reply=this.normalizationScripts.get(normalizationScriptKey))==null){
			synchronized(SDMConfigManager.class){
				if((reply=this.normalizationScripts.get(normalizationScriptKey))==null){
					reply=LoadNormalizationScripts(_session,_eventType,_messageType,_provider);
					this.normalizationScripts.put(normalizationScriptKey,reply);
				}				
			}
		}
		
		return reply;
	}
	
	public CAEventConfig getEventConfigurations(final Session _session,final CAEventType _eventType) throws FPMException{
		
		CAEventConfig reply=null;
		Query query=null;
		
		if((reply=this.eventConfigurations.get(_eventType.getId()))==null){
			synchronized(SDMConfigManager.class) {
				if((reply=this.eventConfigurations.get(_eventType.getId()))==null){
					query=_session.createQuery("select eventConfig from CAEventConfig as eventConfig where eventConfig.eventType.id=:eventTypeId");
					query.setString("eventTypeId",_eventType.getId());
					query.setFetchSize(1);
					reply=(CAEventConfig)query.uniqueResult();
					this.eventConfigurations.put(_eventType.getId(),reply);
				}
			}
		}
		
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,CAMessageFieldConfig> getMessageFieldConfigs(final Session _session,final String _formatId,final String _messageTypeId) throws FPMException{
		
		Map<String,CAMessageFieldConfig> reply=null;
		
		final String key=_formatId+_messageTypeId;
		if((reply=this.messageFieldConfigs.get(key))==null){
			synchronized(SDMConfigManager.class) {
				if((reply=this.messageFieldConfigs.get(_formatId+_messageTypeId))==null){
					reply=new HashMap<String, CAMessageFieldConfig>(256);
					final Query query=HibernateUtils.createQuery(_session,"select config from CAMessageFieldConfig as config where config.id.type.id.format.id=:formatId and config.id.type.id.code=:typeId");
					query.setParameter("formatId",_formatId);
					query.setParameter("typeId",_messageTypeId);
					query.setReadOnly(true);
					for(CAMessageFieldConfig config:(List<CAMessageFieldConfig>)query.list())
						reply.put(config.getId().getPath(), config);
					this.messageFieldConfigs.put(key,reply);
				}				
			}
		}
		
		return reply;
	}
	public Map<String,CAMessageFieldConfig> getMessageFieldConfigs(final Session _session,final CAMessageType _messageType) throws FPMException{
		return getMessageFieldConfigs(_session,_messageType.getId().getFormat().getId(),_messageType.getId().getCode());
	}
	public Map<String,CAMessageFieldConfig> getMessageFieldConfigs(final Session _session,final CAEventMessageAdapter _eventMessage) throws FPMException{
		return getMessageFieldConfigs(_session,_eventMessage.getMessageType().getId().getFormat().getId(),_eventMessage.getMessageType().getId().getCode());
	}

	public String getCleanedMessageFieldPath(final String _fieldPath){
		return _fieldPath.replaceAll("(\\(\\d*\\))|(\\([^0-9]\\))","").replaceAll("//", "/");
	}

	@SuppressWarnings("unchecked")
	public List<CAEventTypeDetail> getEventTypeDetails(final Session _session,final String _eventTypeId) throws FPMException{
		
		List<CAEventTypeDetail> reply=null;
		
		if((reply=this.eventDetails.get(_eventTypeId))==null){
			synchronized(SDMConfigManager.class) {
				if((reply=this.eventDetails.get(_eventTypeId))==null){
					final Query query=HibernateUtils.createQuery(_session,"from CAEventTypeDetail where eventType.id=:eventTypeId and auditor.deleted=:isDeleted");
					query.setString("eventTypeId",_eventTypeId);
					query.setBoolean("isDeleted",false);
					query.setReadOnly(true);
					if((reply=(List<CAEventTypeDetail>)query.list())==null){
						reply=new ArrayList<CAEventTypeDetail>(1);
					}else{
						reply=new ArrayList<CAEventTypeDetail>(reply);
					}
					Collections.sort(reply, new CAEventTypeDetailComparator());
					this.eventDetails.put(_eventTypeId,reply);
				}				
			}
		}
		
		return reply;
	}
	public List<CAEventTypeDetail> getEventTypeDetails(final Session _session,final CAEventType _eventType) throws FPMException{
		return getEventTypeDetails(_session,_eventType.getId());
	}
	public List<CAEventTypeDetail> getEventTypeDetails(final Session _session,final CAEventCollectedAdapter _eventCollected) throws FPMException{
		return getEventTypeDetails(_session,_eventCollected.getEventType().getId());
	}
}
