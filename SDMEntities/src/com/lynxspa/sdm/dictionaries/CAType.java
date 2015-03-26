package com.lynxspa.sdm.dictionaries;


public enum CAType {


	CHDV("CHDV","cash dividend","Cash dividend",false),
	CINC("CINC","capital increase","Capital increase",false),
	SPLT("SPLT","split","Split",false),
	ISPL("ISPL","inverse split","Inverse split",false),
	OFPA("OFPA","OPA","OPA",true),
	OFPV("OFPV","OPV","OPV",true),
	MEET("MEET","general meeting","General meeting",true),
	MRGR("MRGR","merger","Merger",false),
	CPST("CPST","coupon","Coupon",false),
	STDV("STDV","stock dividend","Stock dividend",false),
	REDO("REDO","redenomination","Redenomination",false),
	DLST("DLST","delisting","Delisting",false),
	SOFF("SOFF","spin-off","Spin-off",false),
	BRUP("BRUP","bankrupcy","Bankrupcy",false),
	BBCK("BBCK","buyback","Buyback",false),
	PVCH("PVCH","par value change","Par value change",false),
	DIVS("DIVS","divestiture","Divestiture",false),
	EXCH("EXCH","exchange","Exchange",true),
	PINK("PINK","pay in kind","Pay in kind",false),
	RHTS("RHTS","rights offering","Rights offering",true),
	CONV("CONV","conversion","Conversion",false),
	CHAN("CHAN","change","Change",false),
	CHST("CHST","change state","Change state",false),
	OTHR("OTHR","other","Other",false);
	
	
	private String code;
	private String name;
	private String description;
	private boolean optional=true;

	
	CAType(String _code,String _name,String _description,boolean _optional){
	
		this.code=_code;
		this.name=_name;
		this.description=_description;
		this.optional=_optional;
	}
	
	
	public String getCode() {
		return code;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getOptional(){
		return optional;
	}
}
