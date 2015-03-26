package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum STDomainASSETTYPEClusterBLOOMBERGSTATICValue implements DomainValueDictAdapter {

	VALUE1("EQ","EQ"),
	VALUE2("DB","DB"),
	VALUE3("FUND","FUND"),
	VALUE4("ETF","ETF"),
	;
	
	
	private String normalCode=null;
	private String value=null;
	
	
	STDomainASSETTYPEClusterBLOOMBERGSTATICValue(String _normalCode,String _value){
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
