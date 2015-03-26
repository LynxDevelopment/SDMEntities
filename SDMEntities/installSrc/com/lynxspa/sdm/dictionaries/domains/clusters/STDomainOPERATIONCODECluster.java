package com.lynxspa.sdm.dictionaries.domains.clusters;

import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;

public enum STDomainOPERATIONCODECluster implements DomainClusterDictAdapter {

	BLOOMBERG("BLOOMBERGSTATIC","Bloomberg Static"),
	;
	
	
	private String code=null;
	private String name=null;
	
	
	STDomainOPERATIONCODECluster(String _code,String _name){
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
