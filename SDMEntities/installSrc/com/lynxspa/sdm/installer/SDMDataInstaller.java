package com.lynxspa.sdm.installer;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;
import com.lynxspa.entities.application.Application;
import com.lynxspa.entities.application.flow.Flow;
import com.lynxspa.entities.application.flow.State;
import com.lynxspa.entities.application.flow.Transition;
import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.jobs.SDMEnterprise;
import com.lynxspa.entities.jobs.SDMJobType;
import com.lynxspa.entities.jobs.SDMJobTypeFields;
import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.AssetTypeDetail;
import com.lynxspa.entities.securities.assets.adapters.AssetTypeDetailAdapter;
import com.lynxspa.entities.securities.assets.providers.Provider;
import com.lynxspa.entities.securities.financialassets.SPSecurityFinancialAssets;
import com.lynxspa.entities.securities.financialassets.SPSecurityFinancialAssetsDetails;
import com.lynxspa.entities.securities.markets.SPMarket;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.admin.SDMAdminNormalization;
import com.lynxspa.sdm.dictionaries.CAType;
import com.lynxspa.sdm.dictionaries.alerts.CAAlerts;
import com.lynxspa.sdm.dictionaries.enterprises.Enterprises;
import com.lynxspa.sdm.dictionaries.flows.CAWorkflow;
import com.lynxspa.sdm.dictionaries.flows.DynamicDataWorkflow;
import com.lynxspa.sdm.dictionaries.flows.StaticDataWorkflow;
import com.lynxspa.sdm.dictionaries.jobs.SDMJobTypes;
import com.lynxspa.sdm.dictionaries.jobs.SDMJobTypesFields;
import com.lynxspa.sdm.dictionaries.markets.CAMarkets;
import com.lynxspa.sdm.dictionaries.providers.BasicProviders;
import com.lynxspa.sdm.dictionaries.securities.securityfinancialassets.CASecurityFinancialAssets;
import com.lynxspa.sdm.dictionaries.securities.securityfinancialassets.SDMAssetTypeEnum;
import com.lynxspa.sdm.entities.alerts.CAAlertsProvider;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.providers.CAFormatProvider;
import com.lynxspa.sdm.entities.events.providers.CAManualEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.providers.AssetProviderAdapter;
import com.lynxspa.sdm.installer.adapters.providers.ProviderAdapter;
import com.lynxspa.utils.ReflectionUtils;


public class SDMDataInstaller implements DbDataInstaller{

	protected Map<CAFormatDictAdapter,CAMessageFormat> formats=null;

	private final String user="INSTALLER";
	private Application application=null;

	
	public SDMDataInstaller(){
		super();
		this.formats=new HashMap<CAFormatDictAdapter, CAMessageFormat>();
	}
	
    /**
     * @param session
     * @throws Exception
     * @see com.lynxit.utils.installer.DbDataInstaller#createData(org.hibernate.Session)
     */
    public void createData(Session _session) throws Exception{
    	installApplication(_session);
    	installFlows(_session);
    	installEventTypes(_session);
    	installMarkets(_session);
    	(new SDMDomainsDataInstaller(this.user,this.application)).createData(_session);
    	installProviders(_session);
    	//System.out.println("Installing Alerts");
    	installAlerts(_session);
    	//System.out.println("Installing SecurityTypes");
    	installSecurityTypes(_session);					// Install OLD Security Types ( backward compatibility )
    	//installPerSecurities(_session);
    	installEnterprises(_session);
    	//System.out.println("Installing AssetProviders");
    	// Static Data
    	installAssetProviders(_session);						// Install Asset Providers
    	//System.out.println("Installing AssetTypes");
    	installAssetTypes(_session);							// Install Asset Stuff ( new model )
    	//System.out.println("Installing StaticDataProvider");
    	//Esteban: tablas sin usar:
    	//installStaticDataProvider(_session, "bloomberg", null);	// Install Asset Messages
    	installJobTypeAndJobTypeFields(_session);
    	
    	installSecuritiesNormalization(_session);
    	System.out.println("Create Data Finished");
    }
 
    private void installSecuritiesNormalization(Session _session){
    	//TODO Introducir datos de configuracion de la normalizacion de securities
    }
    
    
    private void installApplication(Session _session){
    	
    	try {
        	this.application=new Application(this.user,"SDM","SECURITY DATA MANAGEMENT","SECURITY DATA MANAGEMENT");
			this.application.setSoftwareDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
			this.application.setSoftwareVersion(new BigDecimal(3.0d));
			this.application.setDatabaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
			this.application.setDatabaseVersion(new BigDecimal(2.1d));
	    	_session.save(this.application);
	    	
	    	Application staticApplication = new Application(this.user,"STATIC","Static Data","Static Data");
	    	staticApplication.setSoftwareDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
	    	staticApplication.setSoftwareVersion(new BigDecimal(3.0d));
	    	staticApplication.setDatabaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
	    	staticApplication.setDatabaseVersion(new BigDecimal(2.1d));
	    	_session.save(staticApplication);
	    	
	    	Application dynamicApplication = new Application(this.user,"DYNAMIC","Dynamic Data","Dynamic Data");
	    	dynamicApplication.setSoftwareDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
	    	dynamicApplication.setSoftwareVersion(new BigDecimal(3.0d));
	    	dynamicApplication.setDatabaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2014"));
	    	dynamicApplication.setDatabaseVersion(new BigDecimal(2.1d));
	    	_session.save(dynamicApplication);
	    	
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
    }
    
    private void installMarkets(Session _session){
        
    	SPMarket market = null;
    	
    	for(CAMarkets markets:CAMarkets.values()){
    		market=new SPMarket(user,markets.getMic(),markets.getName(),markets.getCountryCode(),markets.getCity(),"");
    		_session.save(market);
    	}
    }

    private void installFlows(Session _session){
    
    	Flow flow=null;
    	State state=null;
    	Transition transition=null;
    	Map<StatesDictAdapter,State> statesObjects=null;
    	String messageKey=null;
    	
    	for(CAWorkflow workflow:CAWorkflow.values()){
    		flow=new Flow(workflow.getId(),workflow.getName(),workflow.getDescription(),this.application,this.user);
    		_session.save(flow);
    		statesObjects=new HashMap<StatesDictAdapter,State>();
    		for(StatesDictAdapter stateDict: getStatesFromFlow(workflow)){
    			state=new State(flow,stateDict.getId(),stateDict.getName(),stateDict.getDescription(),stateDict.isInitial(),stateDict.isEnd(),this.user);
    			_session.save(state);
    			statesObjects.put(stateDict,state);
    		}
    		for(TransitionsDictAdapter transitionDict: getTransitionsFromFlow(workflow)){
    			messageKey=((transitionDict.getMessageLog()!=null)? transitionDict.getMessageLog().getMessageKey(): null);
    			transition=new Transition(flow,transitionDict.getId(),transitionDict.getName(),transitionDict.getDescription(),statesObjects.get(transitionDict.getInitialState()),statesObjects.get(transitionDict.getEndState()),messageKey,this.user);
    			_session.save(transition);
    		}
    	}
    	
    	Application staticApplication = (Application)_session.load(Application.class,"STATIC");
 	
    	for(StaticDataWorkflow workflow:StaticDataWorkflow.values()){
    		flow=new Flow(workflow.getId(),workflow.getName(),workflow.getDescription(),staticApplication,this.user);
    		_session.save(flow);
    		statesObjects=new HashMap<StatesDictAdapter,State>();
    		for(StatesDictAdapter stateDict: getStaticStatesFromFlow(workflow)){
    			state=new State(flow,stateDict.getId(),stateDict.getName(),stateDict.getDescription(),stateDict.isInitial(),stateDict.isEnd(),this.user);
    			_session.save(state);
    			statesObjects.put(stateDict,state);
    		}
    		for(TransitionsDictAdapter transitionDict: getStaticTransitionsFromFlow(workflow)){
    			messageKey=((transitionDict.getMessageLog()!=null)? transitionDict.getMessageLog().getMessageKey(): null);
    			transition=new Transition(flow,transitionDict.getId(),transitionDict.getName(),transitionDict.getDescription(),statesObjects.get(transitionDict.getInitialState()),statesObjects.get(transitionDict.getEndState()),messageKey,this.user);
    			_session.save(transition);
    		}
    	}
    	
    	Application dynamicApplication = (Application)_session.load(Application.class,"DYNAMIC");
    	for(DynamicDataWorkflow workflow:DynamicDataWorkflow.values()){
    		flow=new Flow(workflow.getId(),workflow.getName(),workflow.getDescription(),dynamicApplication,this.user);
    		_session.save(flow);
    		statesObjects=new HashMap<StatesDictAdapter,State>();
    		for(StatesDictAdapter stateDict: getDynamicStatesFromFlow(workflow)){
    			state=new State(flow,stateDict.getId(),stateDict.getName(),stateDict.getDescription(),stateDict.isInitial(),stateDict.isEnd(),this.user);
    			_session.save(state);
    			statesObjects.put(stateDict,state);
    		}
    		for(TransitionsDictAdapter transitionDict: getDynamicTransitionsFromFlow(workflow)){
    			messageKey=((transitionDict.getMessageLog()!=null)? transitionDict.getMessageLog().getMessageKey(): null);
    			transition=new Transition(flow,transitionDict.getId(),transitionDict.getName(),transitionDict.getDescription(),statesObjects.get(transitionDict.getInitialState()),statesObjects.get(transitionDict.getEndState()),messageKey,this.user);
    			_session.save(transition);
    		}
    	}
    }
    
    private void installEventTypes(Session _session) throws FPMException{
    	
    	CAEventType eventType=null;
    	System.out.println("Installing Event Types");
    	for(CAType typeToInstall:CAType.values()){
    		eventType=new CAEventType(this.user,typeToInstall);
    		_session.save(eventType);
    	}
    	System.out.println("Installed Event Types");
    }


    @SuppressWarnings("unchecked")
	protected void installProviders(Session _session) throws Exception{

    	Class providersClass=null;
    	ProviderAdapter provider=null;
    	
    	CAManualEventProvider manualprovider=new CAManualEventProvider(this.user, BasicProviders.MANUAL.getCode(),BasicProviders.MANUAL.getName());
    	_session.save(manualprovider);
    	try{
    		providersClass=Class.forName("com.lynxspa.sdm.installer.providers.EventProviders");
    	}catch (Exception e) {
    		providersClass=com.lynxspa.sdm.installer.demo.EventProviders.class;
		}
    	for(Object providerObject:providersClass.getEnumConstants()){
    		provider=(ProviderAdapter)providerObject;
        	installProvider(_session,provider.getProviderClass(),provider.getCode(),provider.getName(),provider.getIdAtMessage(),provider.getFormat());
    	}
    }
    
    @SuppressWarnings("unchecked")
	protected void installAssetProviders(Session _session) throws Exception{

    	Class providersClass=null;
    	AssetProviderAdapter provider=null;

    	try{
    		providersClass=Class.forName("com.lynxspa.sdm.installer.providers.AssetProviders");
    	}catch (Exception e) {
    		providersClass=com.lynxspa.sdm.installer.demo.AssetProviders.class;
		}
    	for(Object providerObject:providersClass.getEnumConstants()){
    		provider=(AssetProviderAdapter)providerObject;
        	installAssetProvider(_session,provider.getCode(),provider.getName(),provider.getNature(),provider.isDefaultProvider());
    	}
    }
    
    protected void installAssetProvider(Session _session,String _code,String _name,String _nature, boolean _isDefaultProvider){
    	Provider provider = new Provider(_code,_name,_nature,this.user,_isDefaultProvider);
    	_session.save(provider);
    }
    
    public void installAssetTypes(Session _session){
    	
    	AssetType assetType = null;
		AssetTypeDetail assetTypeDetail = null;
		
    	for (SDMAssetTypeEnum assetTypeEnum:SDMAssetTypeEnum.values()) {
    		System.out.println("AssetTypeEnum="+assetTypeEnum.getName());

			assetType = new AssetType(user,assetTypeEnum.getId(),assetTypeEnum.getName());
			_session.save(assetType);
			
			Query eventQuery= _session.createQuery("from SDMEnterprise as enterprise");
			List<SDMEnterprise> enterprises = eventQuery.list();
			for(SDMEnterprise enterprise:enterprises){ 
				for(AssetTypeDetailAdapter detailToAdd:getAssetTypeDetails(_session,assetType)){
					System.out.println("Details. Name="+detailToAdd.getName());
					assetTypeDetail = new AssetTypeDetail(this.user,assetType,detailToAdd);
					assetTypeDetail.setEnterprise(enterprise);
			    	_session.save(assetTypeDetail);
				}
			}
    	}
    }
    
    protected void installProvider(Session _session,Class<? extends CAExternalEventProvider> _type,String _code,String _name,String _idAtMessage,CAFormatDictAdapter _format) throws Exception{
    	
    	CAMessageFormat format=null;
    	Constructor<? extends CAExternalEventProvider> constructor=null;
    	CAExternalEventProvider eventProvider=null;
    	CAFormatProvider formatProvider=null;
    	
    	if((format=this.formats.get(_format))==null){
    		format=SDMFormatsDataInstaller.installFormat(_session,this.user,this.application,_format);
    		this.formats.put(_format,format);
    	}
    	
    	//eventProvider=(CAExternalEventProvider)_session.load(CAExternalEventProvider.class, _code);
    	if(eventProvider==null){
    		System.out.println("eventProvider is null");
	    	constructor=_type.getConstructor(String.class,String.class,String.class);
	    	eventProvider=constructor.newInstance(this.user,_code,_name);
	    	_session.save(eventProvider);
    	}
    	System.out.println("eventProvider is not null");
    	System.out.println("eventProvider:"+eventProvider.getName());
    	formatProvider=new CAFormatProvider(this.user,format,_idAtMessage,eventProvider);
    	_session.save(formatProvider);
    }
    
    public void installStaticDataProvider(Session _session,String _provider,String _name) throws Exception{
    	// Install need entities: Providers, ASsetTypes
    	//installProviders(_session);
    	//installAssetTypes(_session);
    	SDMFormatsDataInstaller.installStaticData(_session,_provider,this.user,this.application,_name);
    }

    private void installAlerts(Session _session){
    	
		CAAlertsProvider alertsProvider = null;
		
		for(CAAlerts alertsProviders:CAAlerts.values()){
			alertsProvider=new CAAlertsProvider(user,alertsProviders.getQuery(),alertsProviders.getLabel(),alertsProviders.getGraph(),alertsProviders.getRole(), alertsProviders.getLink(), alertsProviders.getDescLabel());
			_session.save(alertsProvider);
		}
	}

    private void installSecurityTypes(Session _session){
    	
		SPSecurityFinancialAssets securityType = null;
		SPSecurityFinancialAssetsDetails securityTypeDetails = null;
		
		for(CASecurityFinancialAssets typeToInstall:CASecurityFinancialAssets.values()){
			securityType = new SPSecurityFinancialAssets(user,typeToInstall.getId(),typeToInstall.getName());
			_session.save(securityType);
			
			for(SecurityDetailAdapter detailToAdd:getSecurityTypeDetails(_session,securityType)){
				securityTypeDetails=new SPSecurityFinancialAssetsDetails(this.user,securityType,detailToAdd);
		    	_session.save(securityTypeDetails);
			}
		}
	}
    
    @SuppressWarnings("unchecked")
	private StatesDictAdapter[] getStatesFromFlow(CAWorkflow _workflow){
    	
    	StatesDictAdapter[] reply=null;
		Class<StatesDictAdapter> formatType=null;
		
		try {
			reply=new StatesDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.states.CAStates"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("States of flow ["+_workflow.getId()+"] for for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }

    @SuppressWarnings("unchecked")
	private TransitionsDictAdapter[] getTransitionsFromFlow(CAWorkflow _workflow){
    	
    	TransitionsDictAdapter[] reply=null;
		Class<TransitionsDictAdapter> formatType=null;
		
		try {
			reply=new TransitionsDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.transitions.CATransitions"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Transitions of flow ["+_workflow.getId()+"] for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	private StatesDictAdapter[] getStaticStatesFromFlow(StaticDataWorkflow _workflow){
    	
    	StatesDictAdapter[] reply=null;
		Class<StatesDictAdapter> formatType=null;
		
		try {
			reply=new StatesDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.states.StaticStates"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("States of flow ["+_workflow.getId()+"] for for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }
    


    @SuppressWarnings("unchecked")
	private TransitionsDictAdapter[] getStaticTransitionsFromFlow(StaticDataWorkflow _workflow){
    	
    	TransitionsDictAdapter[] reply=null;
		Class<TransitionsDictAdapter> formatType=null;
		
		try {
			reply=new TransitionsDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.transitions.StaticTransitions"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Transitions of flow ["+_workflow.getId()+"] for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	private StatesDictAdapter[] getDynamicStatesFromFlow(DynamicDataWorkflow _workflow){
    	
    	StatesDictAdapter[] reply=null;
		Class<StatesDictAdapter> formatType=null;
		
		try {
			reply=new StatesDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.states.DynamicStates"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("States of flow ["+_workflow.getId()+"] for for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	private TransitionsDictAdapter[] getDynamicTransitionsFromFlow(DynamicDataWorkflow _workflow){
    	
    	TransitionsDictAdapter[] reply=null;
		Class<TransitionsDictAdapter> formatType=null;
		
		try {
			reply=new TransitionsDictAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.flows.transitions.DynamicTransitions"+_workflow.getId()+"Flow");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Transitions of flow ["+_workflow.getId()+"] for ["+e.getMessage()+"] not found");			
		}
		
		return reply;
    }
    
    
    @SuppressWarnings("unchecked")
	private SecurityDetailAdapter[] getSecurityTypeDetails(Session _session,SPSecurityFinancialAssets _type){

    	SecurityDetailAdapter[] reply=null;
		Class<SecurityDetailAdapter> formatType=null;
		try {
			reply=new SecurityDetailAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.securities.securityfinancialassets."+_type.getId().toUpperCase()+"SecurityFinancialAssetsDetails");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Norms for ["+e.getMessage()+"] not found");			
		}
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	private AssetTypeDetailAdapter[] getAssetTypeDetails(Session _session,AssetType _type){

    	AssetTypeDetailAdapter[] reply=null;
		Class<AssetTypeDetailAdapter> formatType=null;
		try {
			reply=new AssetTypeDetailAdapter[0];
			formatType=ReflectionUtils.instanceClass("com.lynxspa.sdm.dictionaries.sdm.assets."+_type.getId().toUpperCase()+"AssetsDetails");
			reply=formatType.getEnumConstants();
		}catch(Exception e){
			System.out.println("Norms for ["+e.getMessage()+"] not found");			
		}
		return reply;
    }
    
    @SuppressWarnings("unchecked")
	private void installEnterprises(Session _session){

    	SDMEnterprise enterprise = null;
		
		for(Enterprises enterpriseInstall:Enterprises.values()){
			enterprise = new SDMEnterprise(user);
			enterprise.setName(enterpriseInstall.getName());
			enterprise.setBic(enterpriseInstall.getBic());
			enterprise.setDescription(enterpriseInstall.getDescription());
			enterprise.setTlf(enterpriseInstall.getTlf());
			enterprise.setAddress(enterpriseInstall.getAddress());
			_session.save(enterprise);
			
		}
    }
    
    @SuppressWarnings("unchecked")
	private void installJobTypeAndJobTypeFields(Session _session){
    	
    	SDMJobType jobType = null;
    	
    	for(SDMJobTypes jobTypeInstall : SDMJobTypes.values()){
    		jobType = new SDMJobType(user);
    		jobType.setClassExe(jobTypeInstall.getClassExe());
    		jobType.setCommitDirectory(jobTypeInstall.getCommitDirectory());
    		jobType.setCommitSuffix(jobTypeInstall.getCommitSuffix());
    		jobType.setCronExpression(jobTypeInstall.getCronExpression());
    		jobType.setDescription(jobTypeInstall.getDescription());
    		jobType.setInputDirectory(jobTypeInstall.getInputDirectory());
    		jobType.setName(jobTypeInstall.getName());
    		jobType.setPattern(jobTypeInstall.getPattern());
    		jobType.setRollbackDirectory(jobTypeInstall.getRollbackDirectory());
    		jobType.setRollbackSuffix(jobTypeInstall.getRollbackSuffix());
    		jobType.setTemporalSuffix(jobTypeInstall.getTemporalSuffix());
    		
    		_session.save(jobType);
    		
    		SDMJobTypeFields jtfBBField = new SDMJobTypeFields();
    		jtfBBField.setFieldName(SDMJobTypesFields.PROVID_BB.getFieldName());
    		jtfBBField.setValue(SDMJobTypesFields.PROVID_BB.getValue());
    		jtfBBField.setJobType(jobType);
    		_session.save(jtfBBField);
    		
    		SDMJobTypeFields jtfBBAssetType = new SDMJobTypeFields();
    		for(SDMJobTypesFields jtf : SDMJobTypesFields.values()){
    			System.out.println(jtf.getFieldName() +" - " + jobTypeInstall.getId());
    			if(jtf.getFieldName().equals(jobTypeInstall.getId())){
    				jtfBBAssetType.setFieldName(jtf.getFieldName());
    				jtfBBAssetType.setValue(jtf.getValue());
    				jtfBBAssetType.setJobType(jobType);
    				_session.save(jtfBBAssetType);
    			}
    		}
    		
//    		jobType.setFields(new TreeMap<String, SDMJobTypeFields>());
//    		jobType.getFields().put(jtfBBField.getValue(), jtfBBField);
//    		jobType.getFields().put(jtfBBAssetType.getValue(), jtfBBAssetType);
    	}
    }
    
}
