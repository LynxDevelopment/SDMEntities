package com.lynxspa.sdm.dictionaries;

public enum CASecurityTypes {

	ISIN("ISIN","International Securities Identification Number"),
	CUSIP("CUSIP","Committee on Uniform Securities Identification Procedures"),
	SEDOL("SEDOL","Stock Exchange Daily Official List");

	
	private String code=null;
	private String name=null;
	
	
	CASecurityTypes(String _code,String _name){
		this.code=_code;
		this.name=_name;
	}

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
