package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainEVENTTYPENorm implements DomainNormDictAdapter {

	NORMAL1("BRUP","Bankrupcy"),
	NORMAL2("BBCK","Buyback"),
	NORMAL3("CINC","Capital increase"),
	NORMAL4("CHDV","Cash dividend"),
	NORMAL5("CHAN","Change"),
	NORMAL6("CHST","Change state"),
	NORMAL7("CONV","Conversion"),
	NORMAL8("CPST","Coupon"),
	NORMAL9("DLST","Delisting"),
	NORMAL10("DIVS","Divestiture"),
	NORMAL11("EXCH","Exchange"),
	NORMAL12("MEET","General meeting"),
	NORMAL13("ISPL","Inverse split"),
	NORMAL14("MRGR","Merger"),
	NORMAL15("OFPA","OPA"),
	NORMAL16("OFPV","OPV"),
	NORMAL17("OTHR","Other"),
	NORMAL18("PVCH","Par value change"),
	NORMAL19("PINK","Pay in kind"),
	NORMAL20("REDO","Redenomination"),
	NORMAL21("RHTS","Rights offering"),
	NORMAL22("SOFF","Spin-off"),
	NORMAL23("SPLT","Split"),
	NORMAL24("STDV","Stock dividend");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainEVENTTYPENorm(String _code,String _description){
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
