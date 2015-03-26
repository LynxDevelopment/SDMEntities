package com.lynxspa.sdm.entities.events.details.adapters;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.exception.FPMException;

public interface CAEventDetailAdapter{

	public long getId();
	public void setId(long id);
	
	public Date getSubscriptionDate();
	public void setSubscriptionDate(Date subscriptionDate);
	public Date getExecutionDate();
	public void setExecutionDate(Date executionDate);
	public Date getExpirationDate();
	public void setExpirationDate(Date expirationDate);
	public Date getOperationalDate();
	public void setOperationalDate(Date operationalDate);
	public HashMap<String,Object> getDynamicTable();
	public void setDynamicTable(HashMap<String,Object> _dynamicTable);
	
	public Object get(String _field);
	public void set(String _field,Object _value) throws FPMException;

	public Map<String,? extends CAEventDetailExtendedAdapter> getExtensions();
	public void setExtensions(Map<String,? extends CAEventDetailExtendedAdapter> extensions);
	public void addExtension(CAEventDetailExtendedAdapter _extension);

	public int getVersion();
	public void setVersion(int version);
	
	public VersionAuditor getAuditor();
	public void setAuditor(VersionAuditor auditor);
}