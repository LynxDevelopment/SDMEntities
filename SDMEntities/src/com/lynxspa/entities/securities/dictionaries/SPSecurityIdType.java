package com.lynxspa.entities.securities.dictionaries;

public enum SPSecurityIdType {
	
	ISIN("ISIN","International Securities Identifying Number","isin",12),
	CUSIP("CUSIP","Committee on Uniform Security Identification Procedures","cusip",9),	
	SEDOL("SEDOL","Stock Exchange Daily Official List","sedol",7);	
	
	private String code=null;
	private String description=null;
	private String securityField=null;
	private int maxLength=0;
	
	
	SPSecurityIdType(String _code,String _description,String _securityField,int _maxLength){
		this.code=_code;
		this.description=_description;
		this.securityField=_securityField;
		this.maxLength=_maxLength;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public String getDescription() {
		return this.description;
	}
	public String getSecurityField() {
		return securityField;
	}
	public int getMaxLength() {
		return maxLength;
	}
}
