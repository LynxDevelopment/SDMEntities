package com.lynxspa.sdm.dictionaries.domains.clusters;

import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;

public enum DYDomainDYOPERATIONCODECluster implements DomainClusterDictAdapter {

	BLOOMBERG("BLOOMBERGDYNAMIC","Bloomberg Dynamic"),
	;
	
	
	private String code=null;
	private String name=null;
	
	
	DYDomainDYOPERATIONCODECluster(String _code,String _name){
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
