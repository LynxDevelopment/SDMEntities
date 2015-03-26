package com.lynxspa.sdm.installer;

import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;
import com.lynxspa.entities.application.Application;
import com.lynxspa.entities.application.domains.Domain;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.entities.application.domains.DomainClusterId;
import com.lynxspa.entities.application.domains.DomainId;
import com.lynxspa.entities.application.domains.DomainNorm;
import com.lynxspa.entities.application.domains.DomainNormId;
import com.lynxspa.entities.application.domains.DomainValue;
import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;
import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;
import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.CABasicDomains;
import com.lynxspa.sdm.dictionaries.domains.CADomain;
import com.lynxspa.sdm.dictionaries.domains.DYDomain;
import com.lynxspa.sdm.dictionaries.domains.STDomain;
import com.lynxspa.utils.ReflectionUtils;


public class SDMDomainsDataInstaller implements DbDataInstaller{


	private String user=null;
	private Application application=null;

	
	public SDMDomainsDataInstaller(String _user,Application _application){
		super();
		this.user=_user;
		this.application=_application;
	}
	
    /**
     * @param session
     * @throws Exception
     * @see com.lynxit.utils.installer.DbDataInstaller#createData(org.hibernate.Session)
     */
    public void createData(Session _session) throws Exception{
    	
		Domain domain=null;
		DomainNorm domainNorm=null;
		for(CABasicDomains domainToInstall:CABasicDomains.values()){
			try {
				domain=new Domain(this.user,this.application,domainToInstall);
				_session.save(domain);
				//_session.flush();
				for(DomainNormDictAdapter normToAdd:getDomainNorms(domain)){
					try {
						domainNorm=new DomainNorm(this.user,domain,normToAdd.getCode(),normToAdd.getDescription());
						_session.save(domainNorm);
						//_session.flush();
					} catch (RuntimeException e) {
						System.err.println("Error installing normal ["+normToAdd.getCode()+"] at domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
						e.printStackTrace();
					}
				}
			} catch (RuntimeException e) {
				System.err.println("Error installing domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
				e.printStackTrace();
			}
		}
		
		for(CADomain domainToInstall:CADomain.values()){
			if((domain=HibernateUtils.getEntity(_session,Domain.class,new DomainId(this.application,domainToInstall.getCode())))==null){
				try {
					domain=new Domain(this.user,this.application,domainToInstall);
					_session.save(domain);
					//_session.flush();
					for(DomainNormDictAdapter normToAdd:getDomainNorms(domain)){
						try {
							domainNorm=new DomainNorm(this.user,domain,normToAdd.getCode(),normToAdd.getDescription());
							_session.save(domainNorm);
							//_session.flush();
						} catch (RuntimeException e) {
							System.err.println("Error installing normal ["+normToAdd.getCode()+"] at domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
							e.printStackTrace();
						}
					}
				} catch (RuntimeException e) {
					System.err.println("Error installing domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
					e.printStackTrace();
				}
			}
		}

//		Application staticapplication = (Application)_session.get(Application.class, "STATIC");
		Application staticapplication = (Application)_session.load(Application.class,"STATIC");
		for(STDomain domainToInstall:STDomain.values()){
			if((domain=HibernateUtils.getEntity(_session,Domain.class,new DomainId(staticapplication,domainToInstall.getCode())))==null){
				try {
					domain=new Domain(this.user,staticapplication,domainToInstall);
					_session.save(domain);
					_session.flush();
					for(DomainNormDictAdapter normToAdd:getStaticDomainNorms(domain)){
						try {
							domainNorm=new DomainNorm(this.user,domain,normToAdd.getCode(),normToAdd.getDescription());
							_session.save(domainNorm);
							//_session.flush();
						} catch (RuntimeException e) {
							System.err.println("Error installing normal ["+normToAdd.getCode()+"] at domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
							e.printStackTrace();
						}
					}
					for(DomainClusterDictAdapter clusterToAdd:getStaticDomainClusters(domain)){
						DomainCluster cluster=new DomainCluster(this.user,domain,clusterToAdd);
						_session.save(cluster);
						//_session.flush();
						for(DomainValueDictAdapter clusterValueDict:getStaticDomainClusterValues(cluster)){
							domainNorm=(DomainNorm)_session.load(DomainNorm.class,new DomainNormId(domain,clusterValueDict.getNormalCode()));
							DomainValue domainValue=new DomainValue(this.user,domainNorm,cluster,clusterValueDict);
							_session.save(domainValue);
							_session.flush();
						}
					}
				} catch (RuntimeException e) {
					System.err.println("Error installing domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
					e.printStackTrace();
				}
			}
		}
		Application dynamicapplication = (Application)_session.load(Application.class, "DYNAMIC");
		for(DYDomain domainToInstall:DYDomain.values()){
			if((domain=HibernateUtils.getEntity(_session,Domain.class,new DomainId(dynamicapplication,domainToInstall.getCode())))==null){
				try {
					domain=new Domain(this.user,dynamicapplication,domainToInstall);
					_session.save(domain);
					//_session.flush();
					for(DomainNormDictAdapter normToAdd:getDynamicDomainNorms(domain)){
						try {
							domainNorm=new DomainNorm(this.user,domain,normToAdd.getCode(),normToAdd.getDescription());
							_session.save(domainNorm);
							//_session.flush();
						} catch (RuntimeException e) {
							System.err.println("Error installing normal ["+normToAdd.getCode()+"] at domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
							e.printStackTrace();
						}
					}
					for(DomainClusterDictAdapter clusterToAdd:getDynamicDomainClusters(domain)){
						DomainCluster cluster=new DomainCluster(this.user,domain,clusterToAdd);
						_session.save(cluster);
						//_session.flush();
						for(DomainValueDictAdapter clusterValueDict:getDynamicDomainClusterValues(cluster)){
							domainNorm=(DomainNorm)_session.load(DomainNorm.class,new DomainNormId(domain,clusterValueDict.getNormalCode()));
							DomainValue domainValue=new DomainValue(this.user,domainNorm,cluster,clusterValueDict);
							_session.save(domainValue);
							_session.flush();
						}
					}
				} catch (RuntimeException e) {
					System.err.println("Error installing domain ["+domainToInstall.getCode()+"] of application ["+this.application.getId()+"]");
					e.printStackTrace();
				}
			}
		}
    }

    public static DomainCluster installCluster(Session _session,String _user,Application _application,String _domain, String _cluster){
    	
		Domain domain=null;
    	DomainCluster reply=null;
    	DomainValue domainValue=null;
    	DomainNorm domainNorm=null;
		DomainClusterDictAdapter clusterDict=null;
		DomainValueDictAdapter[] clusterValues=null;
		
		try {
			domain=(Domain)_session.load(Domain.class, new DomainId(_application,_domain));
			//reply=(DomainCluster)_session.load(DomainCluster.class, new DomainClusterId(domain,_cluster));
			if(reply==null){
				
				clusterDict=SDMDomainsDataInstaller.getDomainCluster(domain,_cluster);
				reply=new DomainCluster(_user,domain,clusterDict);
				_session.save(reply);
				_session.flush();
				clusterValues=SDMDomainsDataInstaller.getDomainClusterValues(reply);
				for(DomainValueDictAdapter clusterValueDict:clusterValues){
					try {
						domainNorm=(DomainNorm)_session.load(DomainNorm.class,new DomainNormId(domain,clusterValueDict.getNormalCode()));
						domainValue=new DomainValue(_user,domainNorm,reply,clusterValueDict);
						_session.save(domainValue);
						_session.flush();
					} catch (RuntimeException e) {
						System.err.println("Error installing value ["+clusterValueDict.getValue()+"] from cluster ["+_cluster+"] to domain ["+_domain+"] of application ["+_application.getId()+"]");
						throw e;
					}
				}
			}
		} catch (RuntimeException e) {
			System.err.println("Error installing cluster ["+_cluster+"] to domain ["+_domain+"] of application ["+_application.getId()+"]");
			throw e;
		}
		return reply;
    }
    
	@SuppressWarnings("unchecked")
	private DomainNormDictAdapter[] getDynamicDomainNorms(Domain _domain){
		
		DomainNormDictAdapter[] reply=null;
		Class<DomainNormDictAdapter> domainNormDictClass=null;
		
		try {
			reply=new DomainNormDictAdapter[0]; 
			domainNormDictClass=(Class<DomainNormDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.normals.DYDomain"+_domain.getId().getCode().toUpperCase()+"Norm");
			reply=domainNormDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainNorms for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
	@SuppressWarnings("unchecked")
	private DomainClusterDictAdapter[] getDynamicDomainClusters(Domain _domain){
		
		DomainClusterDictAdapter[] reply=null;
		Class<DomainClusterDictAdapter> domainClusterDictClass=null;
		
		try {
			reply=new DomainClusterDictAdapter[0]; 
			domainClusterDictClass=(Class<DomainClusterDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.clusters.DYDomain"+_domain.getId().getCode().toUpperCase()+"Cluster");
			reply=domainClusterDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainNorms for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
    @SuppressWarnings("unchecked")
	private static DomainValueDictAdapter[] getDynamicDomainClusterValues(DomainCluster _cluster){
		
    	DomainValueDictAdapter[] reply=null;
		Class<DomainValueDictAdapter> domainValueDictClass=null;
		
		try {
			reply=new DomainValueDictAdapter[]{};
			domainValueDictClass=(Class<DomainValueDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.values.DYDomain"+_cluster.getId().getDomain().getId().getCode().toUpperCase()+"Cluster"+_cluster.getId().getCode()+"Value");
			reply=domainValueDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainCluster for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
  
	@SuppressWarnings("unchecked")
	private DomainNormDictAdapter[] getStaticDomainNorms(Domain _domain){
		
		DomainNormDictAdapter[] reply=null;
		Class<DomainNormDictAdapter> domainNormDictClass=null;
		
		try {
			reply=new DomainNormDictAdapter[0]; 
			domainNormDictClass=(Class<DomainNormDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.normals.STDomain"+_domain.getId().getCode().toUpperCase()+"Norm");
			reply=domainNormDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainNorms for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
	
	@SuppressWarnings("unchecked")
	private DomainClusterDictAdapter[] getStaticDomainClusters(Domain _domain){
		
		DomainClusterDictAdapter[] reply=null;
		Class<DomainClusterDictAdapter> domainClusterDictClass=null;
		
		try {
			reply=new DomainClusterDictAdapter[0]; 
			domainClusterDictClass=(Class<DomainClusterDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.clusters.STDomain"+_domain.getId().getCode().toUpperCase()+"Cluster");
			reply=domainClusterDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainNorms for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
    @SuppressWarnings("unchecked")
	private static DomainValueDictAdapter[] getStaticDomainClusterValues(DomainCluster _cluster){
		
    	DomainValueDictAdapter[] reply=null;
		Class<DomainValueDictAdapter> domainValueDictClass=null;
		
		try {
			reply=new DomainValueDictAdapter[]{};
			domainValueDictClass=(Class<DomainValueDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.values.STDomain"+_cluster.getId().getDomain().getId().getCode().toUpperCase()+"Cluster"+_cluster.getId().getCode()+"Value");
			reply=domainValueDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainCluster for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
    
    
	@SuppressWarnings("unchecked")
	private DomainNormDictAdapter[] getDomainNorms(Domain _domain){
		
		DomainNormDictAdapter[] reply=null;
		Class<DomainNormDictAdapter> domainNormDictClass=null;
		
		try {
			reply=new DomainNormDictAdapter[0]; 
			domainNormDictClass=(Class<DomainNormDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.normals.CADomain"+_domain.getId().getCode().toUpperCase()+"Norm");
			reply=domainNormDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainNorms for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}

    @SuppressWarnings("unchecked")
	private static DomainClusterDictAdapter getDomainCluster(Domain _domain,String _cluster){
		
    	DomainClusterDictAdapter reply=null;
    	DomainClusterDictAdapter[] clusters=null;
		Class<DomainClusterDictAdapter> domainClusterDictClass=null;
		
		try {
			domainClusterDictClass=(Class<DomainClusterDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.clusters.CADomain"+_domain.getId().getCode().toUpperCase()+"Cluster");
			clusters=domainClusterDictClass.getEnumConstants();
			for(int ic1=0;((ic1<clusters.length)&&(reply==null));ic1++){
				if(clusters[ic1].getCode().equals(_cluster))
					reply=clusters[ic1];
			}
		} catch (Exception e) {
			System.out.println("DomainCluster for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}

    @SuppressWarnings("unchecked")
	private static DomainValueDictAdapter[] getDomainClusterValues(DomainCluster _cluster){
		
    	DomainValueDictAdapter[] reply=null;
		Class<DomainValueDictAdapter> domainValueDictClass=null;
		
		try {
			reply=new DomainValueDictAdapter[]{};
			domainValueDictClass=(Class<DomainValueDictAdapter>)ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.domains.values.CADomain"+_cluster.getId().getDomain().getId().getCode().toUpperCase()+"Cluster"+_cluster.getId().getCode()+"Value");
			reply=domainValueDictClass.getEnumConstants();
		} catch (Exception e) {
			System.out.println("DomainCluster for ["+e.getMessage()+"] not found");			
		}

		return reply;
	}
}
