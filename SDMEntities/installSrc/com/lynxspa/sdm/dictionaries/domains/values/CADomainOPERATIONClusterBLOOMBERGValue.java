package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainOPERATIONClusterBLOOMBERGValue implements DomainValueDictAdapter {

	VALUE1("NEW","N"),
	VALUE2("CANCEL","D"),
	VALUE3("REPEAT","R"),
	VALUE4("UPDATE","U");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainOPERATIONClusterBLOOMBERGValue(String _normalCode,String _value){
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
