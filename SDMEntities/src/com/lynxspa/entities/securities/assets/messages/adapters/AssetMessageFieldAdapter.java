package com.lynxspa.entities.securities.assets.messages.adapters;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.securities.assets.messages.AssetMessageFieldConfig;

public interface AssetMessageFieldAdapter {
	
	public long getId();
	public void setId(long id);

	public AssetMessageAdapter getMessage();
	public void setMessage(AssetMessageAdapter message);

	public int getType();
	public void setType(int type);
	public String getPath();
	public void setPath(String path);
	public String getValueShort();
	public void setValueShort(String valueShort);
	public String getValueLong();
	public void setValueLong(String valueLong);
	public String getValueVeryLong();
	public void setValueVeryLong(String valueVeryLong);
	public String getValueClob();
	public void setValueClob(String valueClob);

	public InsertAuditor getAuditor();
	public void setAuditor(InsertAuditor _auditor);

	public String getValue();
	public void setValue(String value);
	public AssetMessageFieldConfig getConfig();
	public void setConfig(AssetMessageFieldConfig config);

}
