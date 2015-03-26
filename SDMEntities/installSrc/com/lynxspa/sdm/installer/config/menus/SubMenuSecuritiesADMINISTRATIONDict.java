package com.lynxspa.sdm.installer.config.menus;

import com.lynxspa.xweb.installer.adapters.MenuDictAdapter;

public enum SubMenuSecuritiesADMINISTRATIONDict implements MenuDictAdapter{

	CONFIGURATION("CONFIGURATION","/sdm/administration/configuration","configuration","/fpm/sdm/administration/configuration/configurationList.xwb","/images/icons/common_toolbar/options_3/options_3_32_h_g.gif",null),
	//Domains
	DOMAINS("DOMAINS","/sdm/administration/domains/domains","domains","/fpm/sdm/administration/domains/viewDomains.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),	
	//Messages
	MESSAGEFORMATS("MESSAGEFORMATS","/sdm/administration/messageformats","message formats","/fpm/sdm/administration/messageformats/viewMessageFormats.xwb","/images/icons/common_toolbar/options_3/options_3_32_h_g.gif",null),
	//Events
	EVENTDETAILS("EVENTDETAILS","/sdm/administration/events/details","event details","/fpm/sdm/administration/events/details/viewEventDetails.xwb","/images/icons/common_toolbar/options_3/options_3_32_h_g.gif",null),
	PROVIDERS("PROVIDERS","/sdm/administration/events/providers","event providers","/fpm/sdm/administration/events/providers/viewEventProviders.xwb","/images/icons/common_toolbar/options_3/options_3_32_h_g.gif",null),
	NORMALIZER("NORMALIZER","/sdm/administration/events/normalization","normalizer","/fpm/sdm/administration/events/normalization/normalizationProcessorConfig.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	COMPANALIZER("COMPANALIZER","/sdm/administration/events/companalizer","complete analizer","/fpm/sdm/administration/events/companalizer/completeAnalizerConfig.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	MASTERRECORD("MASTERRECORD","/sdm/administration/events/masterrecord","master record","/fpm/sdm/administration/events/masterrecord/masterRecordConfig.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	//Portfolios
	MARKETS("MARKETS","/sdm/administration/markets","markets","/fpm/sdm/administration/markets/viewMarkets.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	SECURITIES("SECURITIES","/sdm/administration/securities","securities","/fpm/sdm/administration/securities/viewSecurities.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	MANAGERS("MANAGERS","/sdm/administration/managers/managers","managers","/fpm/sdm/administration/managers/viewManagers.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	MANAGERGROUPS("MANAGERGROUPS","/sdm/administration/managers/groups","managergroups","/fpm/sdm/administration/managers/viewManagerGroups.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null);

	
	private String internalCode=null;
	private String code=null;
	private String name=null;
	private String url=null;
	private String urlIcon1=null;
	private String urlIcon2=null;

	SubMenuSecuritiesADMINISTRATIONDict(String _internalCode,String _code,String _name,String _url,String _urlIcon1,String _urlIcon2){
		this.internalCode=_internalCode;
		this.code=_code;
		this.name=_name;
		this.url=_url;
		this.urlIcon1=_urlIcon1;
		this.urlIcon2=_urlIcon2;
	}


	public String getInternalCode() {
		return internalCode;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getUrlIcon1() {
		return urlIcon1;
	}
	public String getUrlIcon2() {
		return urlIcon2;
	}
	public Class<? extends MenuDictAdapter> getSubmenuDict() {
		return null;
	}
	public boolean isExistent(){
		return false;
	}
}
