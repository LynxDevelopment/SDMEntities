package com.lynxspa.sdm.dictionaries.domains.clusters;

import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;

public enum CADomainOPERATIONCluster implements DomainClusterDictAdapter {

	BLOOMBERG("BLOOMBERG","Bloomberg"),
	IBERCLEAR("IBERCLEAR","IberClear"),
	INVERSIS("INVERSIS","Inversis"),
	OFIVAL("OFIVAL","Ofival"),
	SWIFT("SWIFT","Swift");
	
	
	private String code=null;
	private String name=null;
	
	
	CADomainOPERATIONCluster(String _code,String _name){
		this.code=_code;
		this.name=_name;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public String getName() {
		return this.name;
	}
}
