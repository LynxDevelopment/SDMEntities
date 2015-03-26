package com.lynxspa.sdm.dictionaries.securities.securityfinancialassets;

public enum CASecurityFinancialAssets {

	DEBT("DB","Renta Fija"),
	EQUITY("EQ","Renta Variable"),
	NOEUROPEANEQUITY("NEEQ","Renta Variable no Europea"),
	FUNDS("FUND","Fondos");

	private String id;
	private String name;
	
	CASecurityFinancialAssets(String _id, String _name) {
		
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