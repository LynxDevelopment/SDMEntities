package com.lynxspa.sdm.installer.config.security;

import com.lynxspa.xweb.installer.adapters.FunctionDictAdapter;
import com.lynxspa.xweb.installer.adapters.ModuleDictAdapter;

public enum FunctionPLANNINGDict implements FunctionDictAdapter{
	
	EXECUTEPLANIFICATIONS("PLANIFICATIONS_EXECUTE","","Planification execution"),
	EDITPLANIFICATIONS("PLANIFICATIONSVIEW","/fpm/sdm/plannings/viewPlanifications.xwb", "Planifications edition");
	
	private String code=null;
	private String url=null;
	private String name=null;
	
	FunctionPLANNINGDict(String _code,String _url,String _name){
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
		return ModuleDict.PLANNING;
	}
}
