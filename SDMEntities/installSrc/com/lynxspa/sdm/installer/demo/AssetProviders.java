package com.lynxspa.sdm.installer.demo;

import com.lynxspa.sdm.installer.adapters.providers.AssetProviderAdapter;


public enum AssetProviders implements AssetProviderAdapter{
	
	BLOOMBERGSTATIC("BLOOMBERGSTATIC","Bloomberg Static Data","S",true),
	BLOOMBERGDYNAMIC("BLOOMBERGDYNAMIC","Bloomberg Dynamic Data","D",true),

	;

	private String code=null;
	private String name=null;
	private String nature=null; // Indicate if nature is static or dynamic
	boolean isDefaultProvider;
	
	
	private AssetProviders(String code, String name, String nature,boolean isDefaultProvider) {
		this.code = code;
		this.name = name;
		this.nature = nature;
		this.isDefaultProvider = isDefaultProvider;
	}


	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}


	public String getNature() {
		return nature;
	}


	public boolean isDefaultProvider() {
		return isDefaultProvider;
	}



}
