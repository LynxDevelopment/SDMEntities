package com.lynxspa.sdm.entities.events.details.adapters;

import java.util.HashMap;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtensionId;

public interface CAEventDetailExtendedAdapter{

	public long getId();
	public void setId(long id);

	public CAEventDetailAdapter getMainDetail();
	public void setMainDetail(CAEventDetailAdapter mainDetail);
	public CAEventDetailExtensionId getExtensionId();
	public void setExtensionId(CAEventDetailExtensionId extensionId);
	public HashMap<String,Object> getDynamicTable();
	public void setDynamicTable(HashMap<String,Object> dynamicTable);
	public String getNarrative();
	public void setNarrative(String narrative);

	public Object get(String _field);
	public void set(String _field,Object _value) throws FPMException;

	public int getVersion();
	public void setVersion(int version);

	public VersionAuditor getAuditor();
	public void setAuditor(VersionAuditor auditor);
}