package com.lynxspa.sdm.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.dictionaries.DomainNormalCluster;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;
import com.lynxspa.entities.jobs.SDMEnterprise;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.providers.Provider;
import com.lynxspa.exception.FPMException;
import com.lynxspa.managers.ConfigManager;
import com.lynxspa.sdm.dictionaries.config.SDMConfiguration;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;
import com.lynxspa.sdm.entities.statics.configuration.StaticFieldMessageConfig;
import com.lynxspa.sdm.processors.normalize.NormalizeScriptConfigBean;

public class StaticConfigManager extends ConfigManager{
	
	public static final String APPLICATIONNAME="STATIC";
	public static final String BUNDLENAME="sdm";
	private Map<String,Object> processors=null;
	private Map<String,List<NormalizeScriptConfigBean>> normalizationScripts=null;
	private Map<String,Map<String,DomainClusterDictAdapter>> formatsClusters=null;
	
	private StaticConfigManager(){
		super();
		super.initialize();
		synchronized(SDMConfigManager.class){
			this.processors=new HashMap<String, Object>();
			this.normalizationScripts=new HashMap<String, List<NormalizeScriptConfigBean>>();
			this.formatsClusters=new HashMap<String, Map<String,DomainClusterDictAdapter>>();
		}
	}
	
	public static StaticConfigManager getInstance(){
		if(StaticConfigManager.instance==null){
			synchronized(StaticConfigManager.class){
				if(StaticConfigManager.instance==null){
					StaticConfigManager.instance=new StaticConfigManager();
				}
			}
		}	
		return StaticConfigManager.instance;
	}
	
	public static StaticConfigManager instance=null;
		
	public String getApplicationName() {
		return StaticConfigManager.APPLICATIONNAME;
	}
		
	public String getBundleName(){
		return StaticConfigManager.BUNDLENAME;
	}
	
	//Processors Loader
	public Object getProcessor(final Session _session,final SDMConfiguration _configuration) throws FPMException{

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
	
	public List<NormalizeScriptConfigBean> getNormalizationScripts(final Session _session,final Provider _provider,final AssetType _assetType, final SDMEnterprise _enterprise) throws FPMException{
		
		List<NormalizeScriptConfigBean> reply=null;
		
		final String normalizationScriptKey=_provider.getCode()+_assetType.getId()+_enterprise.getId();
		if((reply=this.normalizationScripts.get(normalizationScriptKey))==null){
			synchronized(StaticConfigManager.class){
				if((reply=this.normalizationScripts.get(normalizationScriptKey))==null){
					reply=LoadNormalizationScripts(_session,_provider,_assetType,_enterprise);
					this.normalizationScripts.put(normalizationScriptKey,reply);
				}				
			}
		}
		
		return reply;
	}
	
	//Normalization scripts
	@SuppressWarnings("unchecked")
	private List<NormalizeScriptConfigBean> LoadNormalizationScripts(final Session _session,final Provider _provider,final AssetType _messageType, final SDMEnterprise _enterprise) throws FPMException{
	
		List<NormalizeScriptConfigBean> reply=null;
		List<StaticFieldMessageConfig> staticFieldMessageConfigList=null;
		
		//Search for provider level scripts configuration
		final Map<String,NormalizeScriptConfigBean> configurationBeans=new HashMap<String, NormalizeScriptConfigBean>();
		final Query query=_session.createQuery("" +
				"select " +
				"	messageFieldConfig " +
				"from " +
				"	StaticFieldMessageConfig as messageFieldConfig " +
				"where " +
				"	messageFieldConfig.assetType.id=:assetTypeId and " +
				"	messageFieldConfig.enterprise.id=:enterpriseId and " +
				"	( " +
				"		messageFieldConfig.provider is null or " +
				"		messageFieldConfig.provider.id=:providerId " +
				"	) and" +
				"	messageFieldConfig.normalizationScript is not null " +
				"order by " +
				"	messageFieldConfig.provider " +
				"desc ");
		query.setString("assetTypeId", _messageType.getId());
		query.setString("assetTypeId", _messageType.getId());
		query.setLong("enterpriseId",_enterprise.getId());
		query.setLong("providerId",_provider.getId());
		staticFieldMessageConfigList=query.list();
		if(!staticFieldMessageConfigList.isEmpty()){
			if (staticFieldMessageConfigList.size()>0){
				for(StaticFieldMessageConfig staticFieldMessageConfig:staticFieldMessageConfigList){
					configurationBeans.put(staticFieldMessageConfig.getStaticFieldConfig().getAssetTypeDetail().getFieldPath(),new NormalizeScriptConfigBean(staticFieldMessageConfig.getStaticFieldConfig().getAssetTypeDetail().getFieldPath(),staticFieldMessageConfig.getNormalizationScript(),false));
				}
			}
		}
		if(!configurationBeans.isEmpty())
			reply=new ArrayList<NormalizeScriptConfigBean>(configurationBeans.values());
		
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
}