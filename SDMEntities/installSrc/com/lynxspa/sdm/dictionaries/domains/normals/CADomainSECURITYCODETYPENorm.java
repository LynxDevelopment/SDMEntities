package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainSECURITYCODETYPENorm implements DomainNormDictAdapter {

	NORMAL1("CUSIP","Committee on Uniform Security Identification Procedures"),
	NORMAL2("ISIN","International Securities Identifying Number"),
	NORMAL3("SEDOL","Stock Exchange Daily Official List");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainSECURITYCODETYPENorm(String _code,String _description){
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
