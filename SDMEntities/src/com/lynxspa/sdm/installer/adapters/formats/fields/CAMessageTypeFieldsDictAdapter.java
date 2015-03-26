package com.lynxspa.sdm.installer.adapters.formats.fields;

public interface CAMessageTypeFieldsDictAdapter {

	public String getPath();
	public String getFieldName();
	public int getFieldLength();
	public String getFieldType();
	public String getFieldFormat();
	public String getDisplayGroup();
	public int getDisplayRow();
	public int getDisplayColumn();
	public String getDescription();
	public boolean getHidden();
}
