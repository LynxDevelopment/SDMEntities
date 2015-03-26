package com.lynxspa.entities.securities.details.additional;

public enum SpSecurityEnum {
	FIXED("FIXED"),
	EQUITY("EQUITY"),
	FUNDS("FUNDS"),
	ETF("ETF");
	
	private String name;

	SpSecurityEnum(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
