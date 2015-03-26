package com.lynxspa.test;


import org.apache.tools.ant.BuildException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lynxspa.dictionaries.DomainNormalCluster;
import com.lynxspa.entities.application.Application;
import com.lynxspa.entities.application.domains.Domain;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.entities.application.domains.DomainNorm;
import com.lynxspa.entities.application.domains.DomainNormId;
import com.lynxspa.entities.application.domains.DomainValue;
import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;
import com.lynxspa.entities.application.domains.adapters.DomainDictAdapter;
import com.lynxspa.hbt.utils.DatabaseManager;
import com.lynxspa.managers.ConfigManager;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.installer.SDMDataInstaller;
import com.lynxspa.sdm.installer.SDMDemoDataInstaller;
import com.lynxspa.sdm.processors.normalize.BeanShellNormalizeProcessor;
import com.lynxspa.sdm.processors.normalize.NormalizeResultBean;


public class Tester extends ConfigManager{

	private boolean simulation = false;
	public static String configurationFile="hibernate.cfg.xml";
	
	public class DomainDict implements DomainClusterDictAdapter,DomainDictAdapter{

		private String code=null;
		private String name="";
		
		public DomainDict(String _code){
			this.code=_code;
		}
		
		public String getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}
		
		public boolean isDeletable(){ return false;}
		public boolean isUpdatable(){ return false;}
		public boolean isCacheable(){ return false;}
	}


	public Tester(SessionFactory _factory) throws Exception{
		super();
		
		Session session=null;
		Transaction transaction=null;
		
		try{
			session=_factory.getCurrentSession();
			transaction=session.beginTransaction();
			//testDynamicTables(session);
			//testDomains(session);
			//testBeanShellNormalizer(session);
			testCreateInstallData(session);
			if((transaction!=null)&&(transaction.isActive()))
				transaction.commit();
		}catch (Exception e) {
			if((transaction!=null)&&(transaction.isActive()))
				transaction.rollback();
			throw e;
		}finally{
			if((session!=null)&&(session.isOpen()))
				session.close();
		}
	}
	
	
	public void testBeanShellNormalizer (Session _session) throws Exception{

		BeanShellNormalizeProcessor normalizer=new BeanShellNormalizeProcessor();
		CAEventMessage message=(CAEventMessage)_session.get(CAEventMessage.class,new Long(2630));
		NormalizeResultBean result=normalizer.normalize(_session, message);
		System.out.println("Script:\n"+result.getGeneratedScript());
		System.out.println("Output:\n"+result.getOutput());
		System.out.println("Exception:\n"+result.getException());
	}
	
	public void testDomains(Session _session) throws Exception{
		
		System.out.println("Incio validación Dominios");
		System.out.println("	Instalación de dominios de test");
		testInsertDomains(_session);
		_session.flush();
		System.out.println("	Validación de acceso a los dominios de test");
		System.out.println("		Domain1 NORMAL-Cluster1");
		this.getDomain(_session, new DomainDict("DOMAIN1"),  DomainNormalCluster.NORMAL,  new DomainDict("Cluster1"));
		System.out.println("		Domain1 Cluster2-NORMAL");
		this.getDomain(_session, new DomainDict("DOMAIN1"),  new DomainDict("Cluster2"),  DomainNormalCluster.NORMAL);
		System.out.println("		Domain1 Cluster1-Cluster2");
		this.getDomain(_session, new DomainDict("DOMAIN1"),  new DomainDict("Cluster1"),  new DomainDict("Cluster2"));
		System.out.println("		Domain1 Cluster2-Cluster1");
		this.getDomain(_session, new DomainDict("DOMAIN1"),  new DomainDict("Cluster2"),  new DomainDict("Cluster1"));
		System.out.println("		Domain2 NORMAL-Cluster2");
		this.getDomain(_session, new DomainDict("DOMAIN2"),  DomainNormalCluster.NORMAL,  new DomainDict("Cluster2"));
		System.out.println("		Domain2 Cluster1-NORMAL");
		this.getDomain(_session, new DomainDict("DOMAIN2"),  new DomainDict("Cluster1"),  DomainNormalCluster.NORMAL);
		System.out.println("		Domain2 Cluster1-Cluster2");
		this.getDomain(_session, new DomainDict("DOMAIN2"),  new DomainDict("Cluster1"),  new DomainDict("Cluster2"));
		System.out.println("		Domain2 Cluster2-Cluster1");
		this.getDomain(_session, new DomainDict("DOMAIN2"),  new DomainDict("Cluster2"),  new DomainDict("Cluster1"));
		System.out.println("Fin validación Dominios");
	}
	
	public void testInsertDomains(Session _session){
		
		Domain domain=null;
    	DomainCluster domainCluster=null;

    	Application application=new Application("TESTER","APP1","Aplication1","Aplicación de test");
    	_session.save(application);
    	//Domain
    	domain=new Domain("TESTER",application,"DOMAIN1","DOMAIN1");
    	_session.save(domain);
    	//Norm
   		_session.save(new DomainNorm("TESTER",domain,"NORM1","NORM1"));
   		_session.save(new DomainNorm("TESTER",domain,"NORM2","NORM2"));
   		_session.save(new DomainNorm("TESTER",domain,"NORM3","NORM3"));
   		//Clusters
   		//	Cluster1
		domainCluster=new DomainCluster("TESTER",domain,"Cluster1","Cluster1");
		_session.save(domainCluster);
		//	Values1
    	_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM1")),domainCluster,"Cluster1-NORM1"));
    	_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM2")),domainCluster,"Cluster1-NORM2"));
		_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM3")),domainCluster,"Cluster1-NORM3"));
   		//	Cluster1
		domainCluster=new DomainCluster("TESTER",domain,"Cluster2","Cluster2");
		_session.save(domainCluster);
		//	Values1
    	_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM1")),domainCluster,"Cluster2-NORM1"));
		_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM3")),domainCluster,"Cluster2-NORM3"));
    	//Domain
    	domain=new Domain("TESTER",application,"DOMAIN2","DOMAIN2");
    	_session.save(domain);
    	//Norm
   		_session.save(new DomainNorm("TESTER",domain,"NORM1","NORM1"));
   		_session.save(new DomainNorm("TESTER",domain,"NORM2","NORM2"));
   		_session.save(new DomainNorm("TESTER",domain,"NORM3","NORM3"));
   		//Clusters
   		//	Cluster1
		domainCluster=new DomainCluster("TESTER",domain,"Cluster1","Cluster1");
		_session.save(domainCluster);
		//	Values1
    	_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM2")),domainCluster,"Cluster1-NORM2"));
		_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM3")),domainCluster,"Cluster1-NORM3"));
   		//	Cluster1
		domainCluster=new DomainCluster("TESTER",domain,"Cluster2","Cluster2");
		_session.save(domainCluster);
		//	Values1
    	_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM1")),domainCluster,"Cluster2-NORM1"));
		_session.save(new DomainValue("TESTER",(DomainNorm)_session.get(DomainNorm.class,new DomainNormId(domain,"NORM3")),domainCluster,"Cluster2-NORM3"));
	}

	public void testCreateInstallData(Session _session) throws Exception{
		try{
			//(new COACDataInstaller()).installAssetTypes(_session);
        }catch(Exception e){
        	_session.getTransaction().rollback();
        	e.printStackTrace();
        	throw new BuildException(e);
        }finally{
    		DatabaseManager.getSessionFactory().close();
        }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory=null;
		
		try{
			factory=DatabaseManager.getSessionFactory(Tester.configurationFile);
            new Tester(factory);
        }catch(Exception e){
        	e.printStackTrace();
        	throw new BuildException(e);
        }catch(Throwable e){
        	e.printStackTrace();
        	throw new BuildException(e);
        }finally{
    		DatabaseManager.getSessionFactory().close();
        }
	}

	@Override
	public String getApplicationName() {
		
		return "SDM";
	}

	@Override
	public String getBundleName() {
		return "sdm";
	}

}
