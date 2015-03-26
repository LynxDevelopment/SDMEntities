package com.lynxspa.sdm.installer.adapters.formats.fields;

public interface AssetMessageTypeFieldsDictAdapter{
	public String getPath();
	public String getFieldName();
	public int getFieldLength();
	public String getDisplayGroup();
	public int getDisplayRow();
	public int getDisplayColumn();
	public String getDescription();
	public String getProvider();
	public String getType();
	public boolean getHidden();
}
