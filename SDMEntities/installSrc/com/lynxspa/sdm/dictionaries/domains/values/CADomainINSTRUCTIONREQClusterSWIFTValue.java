package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainINSTRUCTIONREQClusterSWIFTValue implements DomainValueDictAdapter {

	VALUE1("true","CHOS"),
	VALUE2("false","MAND"),
	VALUE3("true","VOLU");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainINSTRUCTIONREQClusterSWIFTValue(String _normalCode,String _value){
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
