package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainPARTICIPATIONMANNorm implements DomainNormDictAdapter {

	NORMAL1("true","Participation is mandatory"),
	NORMAL2("false","Participation is not mandatory");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainPARTICIPATIONMANNorm(String _code,String _description){
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
