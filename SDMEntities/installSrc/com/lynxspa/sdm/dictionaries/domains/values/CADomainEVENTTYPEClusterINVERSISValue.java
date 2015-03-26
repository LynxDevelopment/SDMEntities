package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainEVENTTYPEClusterINVERSISValue implements DomainValueDictAdapter {

	/*VALUE1("OTHR","DERE"),
	VALUE2("OTHR","DADI"),
	VALUE3("OTHR","DODI"),
	VALUE4("OTHR","JGRE"),
	VALUE5("OTHR","COIV"),
	VALUE6("OTHR","EQIV"),
	VALUE7("OTHR","SDDI"),
	VALUE8("OTHR","SUIV"),
	VALUE9("OTHR","ASDI"),
	VALUE10("OTHR","OEIE"),
	VALUE11("OTHR","OAIV"),
	VALUE12("OTHR","ANIE"),
	VALUE13("OTHR","RNIE"),
	VALUE14("OTHR","OPOP"),
	VALUE15("OTHR","PERE"),
	VALUE16("OTHR","SPIV"),
	VALUE17("OTHR","OOIV"),
	VALUE18("OTHR","EGDI"),
	VALUE19("OTHR","DMRE"),
	VALUE20("OTHR","DTDI"),
	VALUE21("OTHR","FXIV"),
	VALUE22("OTHR","BPIE"),
	VALUE23("OTHR","SCRE"),
	VALUE24("OTHR","TLTX");*/
	DE("CHDV","DE"),
	DA("STDV","DA"),
	DO("STDV","DO"),
	JG("OTHR","JG"),
	CO("CHAN","CO"),
	EQ("OTHR","EQ"),
	SD("OTHR","SD"),
	SU("OTHR","SU"),
	AS("CINC","AS"),
	OE("OTHR","OE"),
	OA("OTHR","OA"),
	AN("OTHR","AN"),
	RN("OTHR","RN"),
	OP("OTHR","OP"),
	PE("OTHR","PE"),
	SP("SPLT","SP"),
	OO("OFPA","OO"),
	EG("SOFF","EG"),
	DM("CHDV","DM"),
	DT("STDV","DT"),
	FX("OTHR","FX"),
	BP("OTHR","BP"),
	SC("OTHR","SC"),
	TL("OTHR","TL");

	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainEVENTTYPEClusterINVERSISValue(String _normalCode,String _value){
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
