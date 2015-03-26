package com.lynxspa.sdm.dictionaries.formats;


import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;


public enum CAFormat implements CAFormatDictAdapter{

	BLOOMBERG("BLOOMBERG","Bloomberg","bloomberg","*.cax"),
	OFIVAL("OFIVAL","Ofival","ofival","*.ofv"),
	SWIFT("SWIFT","Swift","swift","*.swf"),
	IBERCLEAR("IBERCLEAR","IberClear","iberclear","*.dat"),
	INVERSIS("INVERSIS","Inversis","inversis","*.dat");	

	
	private String code;
	private String name;
	private String path;
	private String pattern;

	
	CAFormat(String _code,String _name,String _path,String _pattern){
		this.code=_code;
		this.name=_name;
		this.path=_path;
		this.pattern=_pattern;
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getPath(){
		return path;
	}
	public String getPattern(){
		return pattern;
	}
}
