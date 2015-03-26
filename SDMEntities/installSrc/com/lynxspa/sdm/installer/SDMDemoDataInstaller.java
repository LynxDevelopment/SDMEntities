package com.lynxspa.sdm.installer;

import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;
import com.lynxspa.entities.application.Application;
import com.lynxspa.entities.application.configurations.Config;
import com.lynxspa.sdm.dictionaries.config.CAConfiguration;


public class SDMDemoDataInstaller implements DbDataInstaller{

	
	protected String user=null;
	protected Application application=null;

	
	public SDMDemoDataInstaller(){
		super();
		this.user="DEMOINSTALLER";
	}

    /**
     * @param session
     * @throws Exception
     * @see com.lynxit.utils.installer.DbDataInstaller#createData(org.hibernate.Session)
     */
    public void createData(Session _session) throws Exception{
    	System.out.println("SDMDemoDataInstaller createData");
    	this.application=(Application)_session.load(Application.class,"SDM");
    	System.out.println("SDMDemoDataInstaller installParameterization");
    	installParameterization(_session);
    	System.out.println("SDMDemoDataInstaller installConfiguration");
    	installConfiguration(_session);
    }

    protected void installParameterization(Session _session) throws Exception{

    	Config configuration=null;
    	
    	//Lifecycle
    	configuration=new Config(this.user,this.application,CAConfiguration.LIVECYCLE);
    	configuration.setLongValue((Long)CAConfiguration.LIVECYCLE.getDefaultValue());
    	_session.save(configuration);
    	//Processors
    	configuration=new Config(this.user,this.application,CAConfiguration.PORTFOLIOUPDATERPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.PORTFOLIOUPDATERPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.NORMALIZEPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.NORMALIZEPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.EVENTCOMPLETEPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.EVENTCOMPLETEPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.MATCHERPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.MATCHERPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.MRPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.MRPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.AUTHORIZEPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.AUTHORIZEPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.SENDERPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.SENDERPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.NOTIFICATEPROCESSOR);
    	configuration.setLongStringValue((String)CAConfiguration.NOTIFICATEPROCESSOR.getDefaultValue());
    	_session.save(configuration);
    	//Security field assignement
    	configuration=new Config(this.user,this.application,CAConfiguration.SECURITYFIELDASSIGNMENTPROVIDER);
    	configuration.setLongStringValue((String)CAConfiguration.SECURITYFIELDASSIGNMENTPROVIDER.getDefaultValue());
    	_session.save(configuration);
    }
    
    protected void installConfiguration (Session _session) throws Exception{

    	Config configuration=null;
    	
    	configuration=new Config(this.user,this.application,CAConfiguration.HISTORIFICSMESSAGESLIVETIME);
    	configuration.setLongValue((Long)CAConfiguration.HISTORIFICSMESSAGESLIVETIME.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.TIMETOHISTORIFICATIONMESSAGES);
    	configuration.setLongValue((Long)CAConfiguration.TIMETOHISTORIFICATIONMESSAGES.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.HISTORIFICSEVENTSLIVETIME);
    	configuration.setLongValue((Long)CAConfiguration.HISTORIFICSEVENTSLIVETIME.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.TIMETOHISTORIFICATIONEVENTS);
    	configuration.setLongValue((Long)CAConfiguration.TIMETOHISTORIFICATIONEVENTS.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.MATCHINGTIMEMARGIN);
    	configuration.setLongValue((Long)CAConfiguration.MATCHINGTIMEMARGIN.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.MASTERRECORDOPERATIONALDATE);
    	configuration.setLongValue((Long)CAConfiguration.MASTERRECORDOPERATIONALDATE.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.AUTHORIZATIONOPERATIONALDATE);
    	configuration.setLongValue((Long)CAConfiguration.AUTHORIZATIONOPERATIONALDATE.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.BACKOFFICEOPERATIONALDATE);
    	configuration.setLongValue((Long)CAConfiguration.BACKOFFICEOPERATIONALDATE.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.NORMALIZEONLYINCUSTOMERPORTFOLIO);
    	configuration.setBooleanValue((Boolean)CAConfiguration.NORMALIZEONLYINCUSTOMERPORTFOLIO.getDefaultValue());
    	_session.save(configuration);
    	configuration=new Config(this.user,this.application,CAConfiguration.FILTEREVENTSBYMANAGERGROUP);
    	configuration.setBooleanValue((Boolean)CAConfiguration.FILTEREVENTSBYMANAGERGROUP.getDefaultValue());
    	_session.save(configuration);
    }
}
