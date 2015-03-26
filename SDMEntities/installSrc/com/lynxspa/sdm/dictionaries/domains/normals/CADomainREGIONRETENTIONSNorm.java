package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainREGIONRETENTIONSNorm implements DomainNormDictAdapter {

	NORMAL1("DE","ALEMANIA"),
	NORMAL2("AU","AUSTRALIA"),
	NORMAL3("AT","AUSTRIA"),
	NORMAL4("BE","BELGICA"),
	NORMAL5("CA","CANADA"),
	NORMAL6("DK","DINAMARCA"),
	NORMAL7("US","ESTADOS UNIDOS"),
	NORMAL8("FI","FINLANDIA"),
	NORMAL9("FR","FRANCIA"),
	NORMAL10("GR","GRECIA"),
	NORMAL11("NL","HOLANDA"),
	NORMAL12("HU","HUNGRIA"),
	NORMAL13("IE","IRLANDA"),
	NORMAL14("IT","ITALIA"),
	NORMAL15("JP","JAPON"),
	NORMAL16("LU","LUXEMBURGO"),
	NORMAL17("NO","NORUEGA"),
	NORMAL18("PL","POLONIA"),
	NORMAL19("PT","PORTUGAL"),
	NORMAL20("GB","REINO UNIDO"),
	NORMAL21("CZ","REPUBLICA CHECA"),
	NORMAL22("SE","SUECIA"),
	NORMAL23("SZ","SUIZA");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainREGIONRETENTIONSNorm(String _code,String _description){
		this.code=_code;
		this.description=_description;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public String getDescription() {
		return this.description;
	}
}
