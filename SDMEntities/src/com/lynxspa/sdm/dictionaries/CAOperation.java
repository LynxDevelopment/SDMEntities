package com.lynxspa.sdm.dictionaries;

public enum CAOperation {

	NEW("NEW","new","New event"),
	UPDATE("UPDATE","update","Event updated"),
	CANCELATION("CANCEL","cancel","Event canceled"),
	REPEAT("REPEAT","repeat","Event repeated");
	
	
	private String code=null;
	private String name=null;
	private String description=null;
	
	CAOperation(String _code,String _name,String _description){
		this.code=_code;
		this.name=_name;
		this.description=_description;
	}
	
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
