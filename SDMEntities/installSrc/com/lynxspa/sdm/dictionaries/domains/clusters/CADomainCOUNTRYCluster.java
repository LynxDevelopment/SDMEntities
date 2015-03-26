package com.lynxspa.sdm.dictionaries.domains.clusters;

import com.lynxspa.entities.application.domains.adapters.DomainClusterDictAdapter;

public enum CADomainCOUNTRYCluster implements DomainClusterDictAdapter {

	ISO3166A3("ISO3166A3","Standard ISO-3166 alpha 3"),
	ISO3166N3("ISO3166N3","Standard ISO-3166 numeric");
	
	
	private String code=null;
	private String name=null;
	
	
	CADomainCOUNTRYCluster(String _code,String _name){
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
