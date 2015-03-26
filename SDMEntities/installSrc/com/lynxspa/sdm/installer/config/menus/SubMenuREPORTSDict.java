package com.lynxspa.sdm.installer.config.menus;

import com.lynxspa.xweb.installer.adapters.MenuDictAdapter;

public enum SubMenuREPORTSDict implements MenuDictAdapter{

	SENDEVENTS("SENDEVENTS","/sdm/reports/sendevents","send events","/fpm/sdm/reports/sendEvents.xwb",null,null);
	
	private String internalCode=null;
	private String code=null;
	private String name=null;
	private String url=null;
	private String urlIcon1=null;
	private String urlIcon2=null;
	
	SubMenuREPORTSDict(String _internalCode,String _code,String _name,String _url,String _urlIcon1,String _urlIcon2){
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
