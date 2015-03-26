package com.lynxspa.sdm.installer.config.security;

import com.lynxspa.xweb.installer.adapters.ResourceCollectionDictAdapter;


public enum ResourceCollectionDict implements ResourceCollectionDictAdapter{
	
	XWEB("XWEB","xweb resource collection","/xweb-res",true),
	SDM("SDM","sdm resource collection","/fpm",true);
	
	private String name=null;
	private String description=null;
	private String urlPattern=null;
	private boolean restrictionEnabled=true;
	
	ResourceCollectionDict(String _name,String _description,String _urlPattern,boolean _restrictionEnabled){
		this.name=_name;
		this.description=_description;
		this.urlPattern=_urlPattern;
		this.restrictionEnabled=_restrictionEnabled;
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getUrlPattern() {
		return urlPattern;
	}
	public boolean isRestrictionEnabled() {
		return restrictionEnabled;
	}
}
