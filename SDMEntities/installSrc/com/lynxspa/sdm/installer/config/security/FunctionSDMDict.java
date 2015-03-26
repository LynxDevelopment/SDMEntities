package com.lynxspa.sdm.installer.config.security;

import com.lynxspa.xweb.installer.adapters.FunctionDictAdapter;
import com.lynxspa.xweb.installer.adapters.ModuleDictAdapter;

public enum FunctionSDMDict implements FunctionDictAdapter{
	
	/* MACROFUNCTIONS */
	EVENTMESSAGEVIEW("EVENTMESSAGEVIEW","/fpm/sdm/messages","View list and details of messages"),
	MASTERREGISTERVIEW("MASTERREGISTERVIEW","/fpm/sdm/events","View list and details of master events"),	
	LOGSVIEW("LOGSVIEW","/fpm/sdm/logs","View list and details of logs"),

	/* MICROFUNCTIONS */
	ADDUPDATESECURITIES("ADDUPDATESECURITIES","/fpm/sdm/administration/securities/insertUpdateSecuritiesFormAction.do","Manually add/Update securities"),	
	SOLVEVIRTUALSECURITIES("SOLVEVIRTUALSECURITIES","/fpm/sdm/administration/securities/solveVirtualSecurityFormAction.do","Manually solve virtual securities"),
	
	ADDUPDATEMARKETS("ADDUPDATEMARKETS","/fpm/sdm/administration/markets/insertUpdateMarketsFormAction.do","Manually Add/Update markets"),	
	DELETEMARKETS("DELETEMARKETS","/fpm/sdm/administration/markets/deleteMarketsFormAction.do","Manually delete markets"),	

	ADDUPDATEEVENTPROVIDERS("ADDUPDATEEVENTPROVIDERS","/fpm/sdm/administration/events/providers/insertUpdateEventProviderFormAction.do","Manually Add/Update event providers"),	
	DELETEEVENTPROVIDERS("DELETEEVENTPROVIDERS","/fpm/sdm/administration/events/providers/deleteEventProviderFormAction.do","Manually Delete event providers"),	
	EXPORTEVENTPROVIDERS("EXPORTEVENTPROVIDERS","/fpm/sdm/administration/events/providers/exportEventProviderFormAction.do","Export event provider information"),	
	
	RETRYPRENORMALIZATIONLIST("RETRYPRENORMALIZATIONLIST","/fpm/sdm/messages/prenormalization/fail/retryPrenormalizeListFormAction.do","Manually retry prenormalization of list"),	
	RETRYPRENORMALIZATION("RETRYPRENORMALIZATION","/fpm/sdm/messages/prenormalization/fail/retryPrenormalizeDetailFormAction.do","Manually retry prenormalization of one message"),	
	DISCARDPRENORMALIZATIONLIST("DISCARDPRENORMALIZATIONLIST","/fpm/sdm/messages/prenormalization/fail/discardListFormAction.do","Manually discard a list of messages"),	
	DISCARDPRENORMALIZATION("DISCARDPRENORMALIZATION","/fpm/sdm/messages/prenormalization/fail/discardDetailFormAction.do","Manually discard one message"),	
	
	SELECTMASTERRECORD("SELECTMASTERRECORD","/fpm/sdm/masterrecord/masterRecord.xwb","Manually select master record"),
	FILTERMASTERRECORD("FILTERMASTERRECORD","/fpm/sdm/masterrecord/masterRecordList.xwb","Filter master record data"),
	PARSEDMESSAGEVIEW("PARSEDMESSAGEVIEW","/fpm/sdm/messages","View the parsed message"),

	ADDUPDATEMANAGERS("ADDUPDATEMANAGERS","/fpm/sdm/administration/managers/insertUpdateManagersFormAction.do","Manually Add/Update managers"),	
	DELETEMANAGERS("DELETEMANAGERS","/fpm/sdm/administration/managers/deleteManagersFormAction.do","Manually delete managers"),	
	
	ADDUPDATEMANAGERGROUPS("ADDUPDATEMANAGERGROUPS","/fpm/sdm/administration/managers/insertUpdateManagerGroupsFormAction.do","Manually Add/Update manager groups"),	
	DELETEMANAGERGROUPS("DELETEMANAGERGROUPS","/fpm/sdm/administration/managers/deleteManagerGroupsFormAction.do","Manually delete manager groups");
	
	
	private String code=null;
	private String url=null;
	private String name=null;
	
	FunctionSDMDict(String _code,String _url,String _name){
		this.code=_code;
		this.url=_url;
		this.name=_name;
	}

	public String getCode() {
		return code;
	}
	public String getUrl() {
		return url;
	}
	public String getName() {
		return name;
	}
	public ModuleDictAdapter getModule(){
		return ModuleDict.SDM;
	}
}
