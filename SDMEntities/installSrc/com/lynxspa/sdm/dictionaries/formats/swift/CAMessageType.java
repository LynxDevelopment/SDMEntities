package com.lynxspa.sdm.dictionaries.formats.swift;


import com.lynxspa.sdm.dictionaries.formats.CAFormat;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatMessageTypeDictAdapter;


public enum CAMessageType implements CAFormatMessageTypeDictAdapter{

	TYPE564("564","Notification",CAFormat.SWIFT),
	TYPE565("565","Instruction",CAFormat.SWIFT),
	TYPE566("566","Confirmation",CAFormat.SWIFT),
	TYPE567("567","Status advice",CAFormat.SWIFT),
	TYPE568("568","Narrative",CAFormat.SWIFT);	
	
	
	private String code;
	private String name;
	private CAFormatDictAdapter format=null;

	
	CAMessageType(String _code,String _name,CAFormatDictAdapter _format){
		this.code=_code;
		this.name=_name;
		this.format=_format;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public CAFormatDictAdapter getFormat() {
		return format;
	}
}
