package com.lynxspa.sdm.dictionaries.securities.securityfinancialassets;

public enum SDMAssetTypeEnum {

	DEBT("DB","Fixed Income"),
	EQUITY("EQ","Equity"),
	FUNDS("FUND","Funds"),
	ETF("ETF","ETF");
	
	private String id;
	private String name;
	
	SDMAssetTypeEnum(String _id, String _name) {
		
		this.id = _id;
		this.name = _name;			
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}