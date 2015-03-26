package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainINSTRUCTIONREQNorm implements DomainNormDictAdapter {

	NORMAL1("false","Instruction from account owner is not required"),
	NORMAL2("true","Instruction from account owner is required");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainINSTRUCTIONREQNorm(String _code,String _description){
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
