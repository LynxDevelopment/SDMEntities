package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainREGIONRETENTIONSClusterRETENCIONValue implements DomainValueDictAdapter {

	VALUE1("DK","28"),
	VALUE2("AU","30"),
	VALUE3("AT","25"),
	VALUE4("BE","25"),
	VALUE5("CA","15"),
	VALUE6("DE","26.375"),
	VALUE7("US","15"),
	VALUE8("FI","28"),
	VALUE9("FR","25"),
	VALUE10("GR","10"),
	VALUE11("NL","15"),
	VALUE12("IE","20"),
	VALUE13("IT","27"),
	VALUE14("JP","7"),
	VALUE15("LU","0"),
	VALUE16("NO","15"),
	VALUE17("PT","20"),
	VALUE18("GB","10"),
	VALUE19("SE","30"),
	VALUE20("SZ","35"),
	VALUE21("CZ","15"),
	VALUE22("HU","25"),
	VALUE23("PL","19");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainREGIONRETENTIONSClusterRETENCIONValue(String _normalCode,String _value){
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
