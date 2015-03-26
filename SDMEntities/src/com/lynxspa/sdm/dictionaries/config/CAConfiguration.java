package com.lynxspa.sdm.dictionaries.config;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.application.configurations.adapter.ConfigDictAdapter;
import com.lynxspa.sdm.dictionaries.CALiveCycle;


public enum CAConfiguration implements ConfigDictAdapter{

	//Configuration
	TIMETOHISTORIFICATIONMESSAGES("TimeToHistorificationMessages","Time to pass messages data to historic tables in days",ClassType.LONG,new Long(30),true,true),
	HISTORIFICSMESSAGESLIVETIME("HistoricsMessagesLiveTime","Live time of historics messages in month",ClassType.LONG,new Long(10),true,true),
	TIMETOHISTORIFICATIONEVENTS("TimeToHistorificationEvents","Time to pass events data to historic tables in days",ClassType.LONG,new Long(30),true,true),
	HISTORIFICSEVENTSLIVETIME("HistoricsEventsLiveTime","Live time of historics in month",ClassType.LONG,new Long(10),true,true),
	MATCHINGTIMEMARGIN("MatchingTimeMargin","Provider feed match per event time margin in days",ClassType.LONG,new Long(3),true,true),
	TIMETODELETELOGS("TimeToDelteLogs","Time to delete old logs in days",ClassType.LONG,new Long(200),true,true),
	DATABASE("Database", "Database server", ClassType.MIDDLESTRING,"SQLSERVER",true,true),
	INCLUDE_INFOPROVIDERS_AS_RESOURCE_TO_GENERATE_MASTERRECOD("InfoProvidersAsMasterRecord","Include Info Providers As Master Record Resource",ClassType.BOOLEAN,Boolean.TRUE,true,true),
	//	Event lifecycle 
	MATCHINGOPERATIONALDATE("MatchingOperationalDate","Days before operational date when events should be grouped",ClassType.LONG,new Long(30),true,true),
	MASTERRECORDOPERATIONALDATE("MasterRecordOperationalDate","Days before operational date when events should be searched for master-record",ClassType.LONG,new Long(25),true,true),
	AUTHORIZATIONOPERATIONALDATE("AuthorizationOperationalDate","Days before operational date when events should be authorized",ClassType.LONG,new Long(25),true,true),
	BACKOFFICEOPERATIONALDATE("BackOfficeOperationalDate","Days before operational date when events should be sent to backoffice",ClassType.LONG,new Long(10),true,true),
	//Parameterization
	LIVECYCLE("livecycle","Application live cycle",ClassType.LONG,CALiveCycle.EXPORT_EVENTS.getCode(),false,false),
	SECURITYFIELDASSIGNMENTPROVIDER("SecurityFieldAssignmentProvider","Security field assignment for providers",ClassType.LONGSTRING,"BLOOMBERG=1,OFIVAL=2",false,false),
	NORMALIZEONLYINCUSTOMERPORTFOLIO("NormalizeOnlyInCustomerPortfolio","Normalize messages only if security is in customer portfolio",ClassType.BOOLEAN,Boolean.FALSE,true,true),
	NORMALIZEONLYMAINMARKET("normalize.main.market.only","Flag to prenormalize only main market events at event per market info provider",ClassType.BOOLEAN,Boolean.TRUE,true,true),
	FILTEREVENTSBYMANAGERGROUP("FilterEventsByManagerGroup","Filter processed events by manager groups",ClassType.BOOLEAN,Boolean.FALSE,true,true),
	NORMALIZEPREVIOUSNOTFOUNDASNEW("NormalizePreviousNotFoundAsNew","Prenormalize previous messages not found as new messages",ClassType.BOOLEAN,Boolean.FALSE,true,true),
	//Processors
	PORTFOLIOUPDATERPROCESSOR("PortfolioUpdaterProcessor","PortfolioUpdaterProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.portfolioUpdater.PortfolioUpdaterProcessor",false,false),
	PRENORMALIZEPROCESSOR("PrenormalizeProcessor","PrenormalizeProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.prenormalize.DefaultPrenormalizerProcessor",false,false),
	NORMALIZEPROCESSOR("NormalizeProcessor","NormalizeProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.normalize.BeanShellNormalizeProcessor",false,false),
	MATCHERPROCESSOR("MatcherProcessor","MatcherProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.matcher.AlertByDefaultMatcherProcessor",false,false),
	EVENTCOMPLETEPROCESSOR("EventCompleteProcessor","EventCompleteProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.complete.RequiredEventCompleteProcessor",false,false),
	MRPROCESSOR("MRProcessor","MRProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.masterrecord.RulesMRProcessor",false,false),
	AUTHORIZEPROCESSOR("AuthorizeProcessor","AuthorizeProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.authorize.NoAlertsAuthorizationProcess",false,false),
	SENDERPROCESSOR("SenderProcessor","SenderProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.send.NeutralSenderProcessor",false,false),
	NOTIFICATEPROCESSOR("NotificateProcessor","NotificateProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.notificate.NeutralNotificateProcessor",false,false),
	CUSTOMERSECURITYPARSERPROCESSOR("CustomerSecurityParserProcessor","Customer security parser processor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.customer.security.NeutralCustomerSecurityParser",false,false),
	CUSTOMERUPLOADDATAPROCESSOR("CustomerUploadDataProcessor","Customer upload data processor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.customer.DefaultCustomerUploadProcessor",false,false),
	
	NORMALIZESTATICPROCESSOR("NormalizeStaticProcessor","NormalizeProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.jobs.normalization.BeanShellStaticDataNormalizeProcessor",false,false),
	
	//Plannings
	EXECUTECOMMANDPROCESSOR("ExecuteCommandProcessor","ExecuteCommandProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.plannings.ExecuteCommandProcessor",false,false),
	SYSTEM("CoreOperatingSystem","Operating System where Core is executed",ClassType.LONGSTRING,"Unix",true,true),
	//Comunication
	CLEARCACHE("ClearCache","Clears cache at core process",ClassType.BOOLEAN,false,true,false);

	private String code=null;
	private String description=null;
	private ClassType type=null;
	private Object defaultValue=null;
	private boolean updatable=false;
	private boolean editable=false;

	
	CAConfiguration(String _code,String _description,ClassType _type,Object _defaultValue,boolean _updatable,boolean _editable){
		this.code=_code;
		this.description=_description;
		this.type=_type;
		this.defaultValue=_defaultValue;
		this.updatable=_updatable;
		this.editable=_editable;
	}
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public ClassType getType() {
		return type;
	}
	public Object getDefaultValue() {
		return defaultValue;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public boolean isEditable() {
		return editable;
	}
}
