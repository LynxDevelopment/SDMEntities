package com.lynxspa.entities.securities.assets.adapters;

import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;

public interface AssetTypeDetailAdapter extends SecurityDetailAdapter{
	public abstract String getNature();
	public abstract boolean isEditable();
	public abstract boolean isFilter();
	public abstract boolean isEditableNormalization();
}
