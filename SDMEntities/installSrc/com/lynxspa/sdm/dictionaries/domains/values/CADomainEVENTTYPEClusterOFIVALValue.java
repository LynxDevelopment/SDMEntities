package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainEVENTTYPEClusterOFIVALValue implements DomainValueDictAdapter {

	VALUE1("CINC","AMP"),
	VALUE2("CHDV","DAC"),
	VALUE3("OTHR","DEV"),
	VALUE4("SPLT","SPL"),
	VALUE5("OFPA","OPA"),
	VALUE6("OFPV","OPV"),
	VALUE7("MEET","CVC"),
	VALUE8("MEET","THR"),
	VALUE9("MRGR","FUS"),
	VALUE10("MRGR","FVL"),
	VALUE11("OTHR","RFJ"),
	VALUE12("OTHR","AMS"),
	VALUE13("CPST","CUP"),
	VALUE14("OTHR","WAR"),
	VALUE15("OTHR","PRC");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainEVENTTYPEClusterOFIVALValue(String _normalCode,String _value){
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
