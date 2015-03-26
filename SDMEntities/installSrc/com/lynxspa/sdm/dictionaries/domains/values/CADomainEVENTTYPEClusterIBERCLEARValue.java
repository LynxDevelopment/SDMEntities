package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainEVENTTYPEClusterIBERCLEARValue implements DomainValueDictAdapter {

	VALUE1("OTHR","23"),
	VALUE2("OTHR","24"),
	VALUE3("OTHR","25"),
	VALUE4("OTHR","31"),
	VALUE5("OTHR","32"),
	VALUE6("OTHR","38"),
	VALUE7("OTHR","39"),
	VALUE8("OTHR","48"),
	VALUE9("OTHR","11"),
	VALUE10("OTHR","12"),
	VALUE11("OTHR","13"),
	VALUE12("OTHR","14"),
	VALUE13("CHDV","15"),
	VALUE14("OTHR","16"),
	VALUE15("OTHR","17"),
	VALUE16("OTHR","18"),
	VALUE17("OTHR","19"),
	VALUE18("OTHR","21"),
	VALUE19("OTHR","22");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainEVENTTYPEClusterIBERCLEARValue(String _normalCode,String _value){
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
