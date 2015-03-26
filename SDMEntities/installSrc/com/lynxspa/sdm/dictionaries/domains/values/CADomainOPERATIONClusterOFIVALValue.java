package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainOPERATIONClusterOFIVALValue implements DomainValueDictAdapter {

	VALUE1("NEW","A"),
	VALUE2("CANCEL","B"),
	VALUE3("UPDATE","M"),
	VALUE4("REPEAT","R");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainOPERATIONClusterOFIVALValue(String _normalCode,String _value){
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
