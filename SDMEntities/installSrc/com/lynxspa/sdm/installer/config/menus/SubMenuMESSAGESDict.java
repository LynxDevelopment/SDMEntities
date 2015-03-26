package com.lynxspa.sdm.installer.config.menus;

import com.lynxspa.xweb.installer.adapters.MenuDictAdapter;

public enum SubMenuMESSAGESDict implements MenuDictAdapter{

	MESSAGESLIST("MESSAGESLIST","/sdm/messages/messagelist","messages list","/fpm/sdm/messages/messageList.xwb",null,null),
	PRENORMMESSAGESLIST("PRENORMMESSAGESLIST","/sdm/messages/prenormalizedmessagelist","prenormalized messages list","/fpm/sdm/messages/prenormalization/prenormalizedMessageList.xwb",null,null),
	PRENORMALIZEFAILLIST("PRENORMALIZEFAILLIST","/sdm/messages/prenormalizefaillist","prenormalization fail list","/fpm/sdm/messages/prenormalization/fail/prenormalizeFailList.xwb",null,null),
	NORMALIZEFAILLIST("NORMALIZEFAILLIST","/sdm/messages/normalizefaillist","normalization fail list","/fpm/sdm/messages/normalization/fail/normalizeFailList.xwb",null,null),
	NORMALIZEIGNORELIST("NORMALIZEFAILLIST","/sdm/messages/normalizeignorelist","normalization ignore list","/fpm/sdm/messages/normalization/ignore/normalizeIgnoreList.xwb",null,null),
	DISCARTEDMESSAGES("DISCARTEDMESSAGES","/sdm/messages/discardedmessagelist","discarded messages list","/fpm/sdm/messages/discarded/discardedMessageList.xwb",null,null);
	
	private String internalCode=null;
	private String code=null;
	private String name=null;
	private String url=null;
	private String urlIcon1=null;
	private String urlIcon2=null;

	SubMenuMESSAGESDict(String _internalCode,String _code,String _name,String _url,String _urlIcon1,String _urlIcon2){
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
