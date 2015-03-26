package com.lynxspa.sdm.dictionaries.formats.bloomberg;

import com.lynxspa.sdm.installer.adapters.formats.AssetMessageTypeAdapter;

public enum EAssetMessageType implements AssetMessageTypeAdapter{

	FIELD1("DB",1),
	FIELD2("EQ",1),
	FIELD3("FUND",1),
	FIELD4("EQ",2),
	FIELD5("DB",2),
	FIELD6("FUND",2);
	
	
	private String assetType;
	private int provider;

	
	EAssetMessageType(String _assetType,int _provider){
		this.assetType = _assetType;
		this.provider = _provider;
	}


	public String getAssetType() {
		return assetType;
	}

	public int getProvider() {
		return provider;
	}	
}
