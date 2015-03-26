package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainEVENTTYPEClusterBLOOMBERGValue implements DomainValueDictAdapter {

	VALUE1("OFPA","ACQUIS"),
	VALUE2("OFPV","EQY_OFFER"),
	VALUE3("MEET","SH_HOLDER_MEET"),
	VALUE4("MRGR","MERG"),
	VALUE5("CHDV","DVD_CASH"),
	VALUE6("STDV","DVD_STOCK"),
	VALUE7("REDO","REDENOMINATION"),
	VALUE8("CHAN","CHG_NAME"),
	VALUE9("CHAN","CHG_DOM"),
	VALUE10("CHAN","CHG_RLOT"),
	VALUE11("CHAN","CHG_TKR"),
	VALUE12("CHAN","CHG_ID"),
	VALUE13("CHAN","CHG_VOTE"),
	VALUE14("CHAN","CHG_LIST"),
	VALUE15("CHST","CHG_STATE"),
	VALUE16("CPST","CPN");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainEVENTTYPEClusterBLOOMBERGValue(String _normalCode,String _value){
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
