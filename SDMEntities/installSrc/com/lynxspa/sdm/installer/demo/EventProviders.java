package com.lynxspa.sdm.installer.demo;

import com.lynxspa.sdm.dictionaries.formats.CAFormat;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;
import com.lynxspa.sdm.installer.adapters.providers.ProviderAdapter;


public enum EventProviders implements ProviderAdapter{

	BLOOMBERG("BLOOMBERG",com.lynxspa.sdm.entities.events.providers.CAInfoEventProvider.class,"Bloomberg",CAFormat.BLOOMBERG,"BLOOMBERG");
//	OFIVAL("OFIVAL",com.lynxspa.sdm.entities.events.providers.CAInfoEventProvider.class,"Bolsa Madrid",CAFormat.OFIVAL,"OFIVAL"),
//	CUSTBSNT("CUSTBSNT",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Custodio Santander",CAFormat.SWIFT,"BSDTGB2X"),
//	CUSTBPA1("CUSTBPA1",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Custodio bpa1",CAFormat.SWIFT,"MGTCBEBE"),
//	CUSTBPA2("CUSTBPA2",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Custodio bpa2",CAFormat.SWIFT,"CRESCHZZ"),
//	CUSTBPA3("CUSTBPA3",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Custodio bpa3",CAFormat.SWIFT,"CEDELULL"),
//	IBERCLEAR("IBERCLEAR",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Iberclear",CAFormat.IBERCLEAR,"IBERCLEAR"),
//	INVERSIS("INVERSIS",com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider.class,"Inversis",CAFormat.INVERSIS,"INVERSIS");

	
	private String code=null;
	private Class<? extends CAExternalEventProvider> providerClass=null;
	private String name=null;
	private CAFormatDictAdapter format=null;
	private String idAtMessage=null;


	EventProviders(String _code,Class<? extends CAExternalEventProvider> _providerClass,String _name,CAFormatDictAdapter _format,String _idAtMessage){
		this.code=_code;
		this.providerClass=_providerClass;
		this.name=_name;
		this.format=_format;
		this.idAtMessage=_idAtMessage;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public Class<? extends CAExternalEventProvider> getProviderClass() {
		return this.providerClass;
	}
	public String getName() {
		return this.name;
	}
	public CAFormatDictAdapter getFormat() {
		return this.format;
	}
	public String getIdAtMessage() {
		return this.idAtMessage;
	}
}