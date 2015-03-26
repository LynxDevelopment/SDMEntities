package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum STDomainOPERATIONCODENorm implements DomainNormDictAdapter {

	NORMAL1("REMOVE","Remove"),
	NORMAL2("ERROR","Error"),
	NORMAL3("NEW","New"),
	;
	
	
	private String code=null;
	private String description=null;
	
	
	STDomainOPERATIONCODENorm(String _code,String _description){
		this.code=_code;
		this.description=_description;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public String getDescription() {
		return this.description;
	}

}
