package com.lynxspa.entities.securities.assets.adapters;

import com.lynxspa.entities.securities.assets.adapters.AssetAdapter;
import com.lynxspa.entities.securities.assets.adapters.AssetDetailAdapter;
import com.lynxspa.entities.securities.assets.adapters.AssetGroupAdapter;
import com.lynxspa.entities.securities.assets.providers.Provider;

public interface AssetCollectedAdapter extends AssetAdapter{
	
	public Provider getProvider();
	public void setProvider(Provider _provider);
	public AssetGroupAdapter getAssetGroup();
	public void setAssetGroup(AssetGroupAdapter assetGroup);
	public AssetDetailAdapter getAssetDetail();
	public void setAssetDetail(AssetDetailAdapter _assetDetail);

//	public Boolean getComplete();
//	public void setComplete(Boolean complete);

}
