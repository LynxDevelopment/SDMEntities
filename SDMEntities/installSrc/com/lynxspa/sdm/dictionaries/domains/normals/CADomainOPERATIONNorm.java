package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainOPERATIONNorm implements DomainNormDictAdapter {

	NORMAL1("CANCEL","Event canceled"),
	NORMAL2("REPEAT","Event repeated"),
	NORMAL3("UPDATE","Event updated"),
	NORMAL4("NEW","New event");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainOPERATIONNorm(String _code,String _description){
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
