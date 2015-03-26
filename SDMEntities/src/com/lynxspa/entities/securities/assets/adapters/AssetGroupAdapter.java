package com.lynxspa.entities.securities.assets.adapters;

import java.util.List;

public interface AssetGroupAdapter extends AssetAdapter{

	public AssetCollectedAdapter getMasterAsset();
	public void setMasterAsset(AssetCollectedAdapter masterSource);

	public List<? extends AssetCollectedAdapter> getGroupedAssets();
	public void setGroupedAssets(List<? extends AssetCollectedAdapter> groupedAssets);
}

