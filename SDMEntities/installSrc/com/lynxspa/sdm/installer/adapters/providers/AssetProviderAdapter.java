package com.lynxspa.sdm.installer.adapters.providers;

public interface AssetProviderAdapter {

	public String getCode();
	public String getName();
	public String getNature();
	public boolean isDefaultProvider();
}
