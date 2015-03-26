package com.lynxspa.sdm.dictionaries.providers;

public enum BasicProviders {

	MANUAL("MANUAL", "manual provider");

	private String code = null;
	private String name = null;
	
	private BasicProviders(String code, String name){
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
