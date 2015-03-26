package com.lynxspa.sdm.installer.config.menus;

import com.lynxspa.xweb.installer.adapters.MenuDictAdapter;

public enum SubMenuSDMDict implements MenuDictAdapter {

	MESSAGES("MESSAGES","/sdm/messages","messages",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuMESSAGESDict.class),
	EVENTS("EVENTS","/sdm/events","events",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuEVENTSDict.class),
	MATCHING("MATCHING","/sdm/matching","matching",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuMATCHINGDict.class),
	MASTERRECORD("MASTERRECORD","/sdm/masterrecord","master record",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuMASTERRECORDDict.class),
	REPORTS("REPORTS","/sdm/reports","reports",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuREPORTSDict.class),
	LOGS("LOGS","/sdm/logs","logs",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuLOGSDict.class),
	ADMINISTRATION("ADMINISTRATION","/sdm/administration","administration",null,"/images/icons/miscellaneous/invoice/invoice_32_h_g.gif",null,com.lynxspa.sdm.installer.config.menus.SubMenuADMINISTRATIONDict.class),
	PLANNINGS("PLANNINGS","/sdm/plannings","plannings",null,"/images/icons/miscellaneous/invoice/invoice_32_h_g.gif",null,com.lynxspa.sdm.installer.config.menus.SubMenuPLANNINGSDict.class),
	ALERTS("ALERTS","/sdm/alerts","alerts",null,null,null,com.lynxspa.sdm.installer.config.menus.SubMenuALERTSDict.class);
	
	private String internalCode=null;
	private String code=null;
	private String name=null;
	private String url=null;
	private String urlIcon1=null;
	private String urlIcon2=null;
	private Class<? extends MenuDictAdapter> submenu=null;
	
	SubMenuSDMDict(String _internalCode,String _code,String _name,String _url,String _urlIcon1,String _urlIcon2,Class<? extends MenuDictAdapter> _submenu){
		this.internalCode=_internalCode;
		this.code=_code;
		this.name=_name;
		this.url=_url;
		this.urlIcon1=_urlIcon1;
		this.urlIcon2=_urlIcon2;
		this.submenu=_submenu;
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
		return this.submenu;
	}
	public boolean isExistent(){
		return false;
	}
}
