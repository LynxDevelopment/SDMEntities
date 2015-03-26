package com.lynxspa.sdm.dictionaries.formats.inversis;


import com.lynxspa.sdm.dictionaries.formats.CAFormat;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatMessageTypeDictAdapter;


public enum CAMessageType implements CAFormatMessageTypeDictAdapter{

	TYPEINV("INV","Operaciones Financieras Inversis",CAFormat.INVERSIS);	
	
	
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
