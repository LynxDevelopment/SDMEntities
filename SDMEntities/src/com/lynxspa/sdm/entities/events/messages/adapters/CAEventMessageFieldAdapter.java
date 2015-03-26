package com.lynxspa.sdm.entities.events.messages.adapters;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFieldConfig;

public interface CAEventMessageFieldAdapter{

	public long getId();
	public void setId(long id);

	public CAEventMessageAdapter getMessage();
	public void setMessage(CAEventMessageAdapter message);

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
	public CAMessageFieldConfig getConfig();
	public void setConfig(CAMessageFieldConfig config);
}