package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum DYDomainDYNAMICASSETTYPENorm implements DomainNormDictAdapter {

	NORMAL1("EQ","assetType.equity"),
	NORMAL2("DB","assetType.fixed.income"),
	NORMAL3("FUND","assetType.fund"),
	NORMAL4("ETF","assetType.etf"),
	;
	
	
	private String code=null;
	private String description=null;
	
	
	DYDomainDYNAMICASSETTYPENorm(String _code,String _description){
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
