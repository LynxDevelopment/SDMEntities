package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum DYDomainDYOPERATIONCODEClusterBLOOMBERGDYNAMICValue implements DomainValueDictAdapter {

	VALUE1("ERROR","10"),
	VALUE2("REMOVE","-1"),
	VALUE3("NEW","0"),
	;
	
	
	private String normalCode=null;
	private String value=null;
	
	
	DYDomainDYOPERATIONCODEClusterBLOOMBERGDYNAMICValue(String _normalCode,String _value){
		this.normalCode=_normalCode;
		this.value=_value;
	}
	
	
	public String getNormalCode() {
		return this.normalCode;
	}
	public String getValue() {
		return this.value;
	}
}
