package com.lynxspa.sdm.dictionaries.formats.ofival;


import com.lynxspa.sdm.dictionaries.formats.CAFormat;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatMessageTypeDictAdapter;


public enum CAMessageType implements CAFormatMessageTypeDictAdapter{

	TYPEAMP("AMP","Amplicación capital",CAFormat.OFIVAL),
	TYPEDAC("DAC","Dividendos",CAFormat.OFIVAL),
	TYPEDEV("DEV","Devolución aportaciones",CAFormat.OFIVAL),
	TYPESPL("SPL","Splits/contrasplits",CAFormat.OFIVAL),
	TYPEOPA("OPA","OPA",CAFormat.OFIVAL),
	TYPEOPV("OPV","OPV/OPS",CAFormat.OFIVAL),
	TYPECVC("CVC","Convocatoria junta",CAFormat.OFIVAL),
	TYPETHR("THR","Texto hechos relevantes",CAFormat.OFIVAL),
	TYPEFUS("FUS","Fusiones",CAFormat.OFIVAL),
	TYPEFVL("FVL","Valores fusionados",CAFormat.OFIVAL),
	TYPERFJ("RFJ","Renta fija",CAFormat.OFIVAL),
	TYPEAMS("AMS","Amortizaciones",CAFormat.OFIVAL),
	TYPECUP("CUP","Cupones",CAFormat.OFIVAL),
	TYPEWAR("WAR","Warrants y certificados",CAFormat.OFIVAL);	
	
	
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
