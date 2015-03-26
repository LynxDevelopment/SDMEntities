package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainPARTICIPATIONMANClusterSWIFTValue implements DomainValueDictAdapter {

	VALUE1("true","CHOS"),
	VALUE2("true","MAND"),
	VALUE3("false","VOLU");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainPARTICIPATIONMANClusterSWIFTValue(String _normalCode,String _value){
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
