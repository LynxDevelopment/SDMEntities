package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainOPERATIONClusterINVERSISValue implements DomainValueDictAdapter {

	VALUE1("NEW","A");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainOPERATIONClusterINVERSISValue(String _normalCode,String _value){
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
