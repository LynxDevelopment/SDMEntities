package com.lynxspa.sdm.dictionaries;

public enum CALiveCycle {

	IMPORT_MESSAGES(0,"import.messages","Import messages"),
	PRENORMALIZE_IMPORT(1,"prenormalize.message","Prenormalize messages"),
	NORMALIZE_MESSAGES(2,"normalize.messages","Normalize messages"),
	EVENT_MATCH(3,"event.match","Event match"),
	MASTER_RECORD(4,"master.record","Master record"),
	VALIDATE_MASTER_RECORD(5,"validate.master","Validate master record"),
	EXPORT_EVENTS(6,"export.events","Export events");
	
	
	private long code=0;
	private String name=null;
	private String description=null;
	
	
	CALiveCycle(long _code,String _name,String _description){
		this.code=_code;
		this.name=_name;
		this.description=_description;
	}

	
	public long getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}
