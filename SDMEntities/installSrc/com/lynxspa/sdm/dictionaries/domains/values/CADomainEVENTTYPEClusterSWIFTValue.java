package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainEVENTTYPEClusterSWIFTValue implements DomainValueDictAdapter {

	VALUE1("OTHR","ACTV"),
	VALUE2("OTHR","ATTI"),
	VALUE3("BBCK","BIDS"),
	VALUE4("CINC","BONU"),
	VALUE5("OTHR","BPUT"),
	VALUE6("BRUP","BRUP"),
	VALUE7("OTHR","CAPG"),
	VALUE8("OTHR","CERT"),
	VALUE9("CHAN","CHAN"),
	VALUE10("OTHR","CLSA"),
	VALUE11("OTHR","CMET"),
	VALUE12("OTHR","CONS"),
	VALUE13("CONV","CONV"),
	VALUE14("OTHR","COOP"),
	VALUE15("CPST","CPST"),
	VALUE16("PVCH","DECR"),
	VALUE17("DIVS","DETI"),
	VALUE18("OTHR","DFLT"),
	VALUE19("DLST","DLST"),
	VALUE20("OTHR","DRAW"),
	VALUE21("OTHR","DRIP"),
	VALUE22("OTHR","DSCL"),
	VALUE23("OTHR","DTCH"),
	VALUE24("CHDV","DVCA"),
	VALUE25("OTHR","DVOP"),
	VALUE26("OTHR","DVSC"),
	VALUE27("STDV","DVSE"),
	VALUE28("EXCH","EXOF"),
	VALUE29("OTHR","EXRI"),
	VALUE30("OTHR","EXTM"),
	VALUE31("OTHR","EXWA"),
	VALUE32("PVCH","INCR"),
	VALUE33("CPST","INTR"),
	VALUE34("OTHR","LIQU"),
	VALUE35("OTHR","MCAL"),
	VALUE36("MEET","MEET"),
	VALUE37("MRGR","MRGR"),
	VALUE38("OTHR","ODLT"),
	VALUE39("MEET","OMET"),
	VALUE40("OTHR","OTHR"),
	VALUE41("OTHR","PARI"),
	VALUE42("OTHR","PCAL"),
	VALUE43("OTHR","PDEF"),
	VALUE44("PINK","PINK"),
	VALUE45("CHST","PLAC"),
	VALUE46("OTHR","PPMT"),
	VALUE47("OTHR","PRED"),
	VALUE48("OTHR","PRII"),
	VALUE49("OFPV","PRIO"),
	VALUE50("OTHR","REDM"),
	VALUE51("REDO","REDO"),
	VALUE52("OTHR","REMK"),
	VALUE53("OTHR","RHDI"),
	VALUE54("RHTS","RHTS"),
	VALUE55("OTHR","SHPR"),
	VALUE56("OTHR","SMAL"),
	VALUE57("SOFF","SOFF"),
	VALUE58("SPLT","SPLF"),
	VALUE59("ISPL","SPLR"),
	VALUE60("OTHR","SUSP"),
	VALUE61("OFPA","TEND"),
	VALUE62("OTHR","TREC"),
	VALUE63("OTHR","WRTH"),
	VALUE64("OTHR","WTRC"),
	VALUE65("MEET","XMET");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainEVENTTYPEClusterSWIFTValue(String _normalCode,String _value){
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
