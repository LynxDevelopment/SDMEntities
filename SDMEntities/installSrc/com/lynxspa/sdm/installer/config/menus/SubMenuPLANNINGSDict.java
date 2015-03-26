package com.lynxspa.sdm.installer.config.menus;

import com.lynxspa.xweb.installer.adapters.MenuDictAdapter;

public enum SubMenuPLANNINGSDict implements MenuDictAdapter{

	PLANNINGSVIEW("PLANNINGSSVIEW","/sdm/plannings/viewPlannings","planningsview","/fpm/sdm/plannings/viewPlanifications.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null),
	PLANNINGSPROCESS("PLANNINGSSPROCESS","/sdm/plannings/viewProcess","planningsprocess","/fpm/sdm/plannings/viewProcess.xwb","/images/icons/edit_and_word_processing/rulers/rulers_32_h_g.gif",null);
	
	private String internalCode=null;
	private String code=null;
	private String name=null;
	private String url=null;
	private String urlIcon1=null;
	private String urlIcon2=null;

	SubMenuPLANNINGSDict(String _internalCode,String _code,String _name,String _url,String _urlIcon1,String _urlIcon2){
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
