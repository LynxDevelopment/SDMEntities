package com.lynxspa.sdm.entities.events.adapters;

import java.util.Date;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.sdm.entities.events.types.CAEventType;

public interface CAEventAdapter{

	public long getId();
	public void setId(long id);

	public int getVersion();
	public void setVersion(int version);

	public CAEventType getEventType();
	public void setEventType(CAEventType eventType);
	public SPSecurity getSecurity();
	public void setSecurity(SPSecurity security);
	public Date getSubscriptionDate();
	public void setSubscriptionDate(Date suscriptionDate);
	public Date getExecutionDate();
	public void setExecutionDate(Date executionDate);
	public Date getExpirationDate();
	public void setExpirationDate(Date expirationDate);
	public Date getOperationalDate();
	public void setOperationalDate(Date operationalDate);
	public boolean isProviderUpdated();
	public void setProviderUpdated(boolean providerUpdated);
	public boolean isProviderCancelled();
	public void setProviderCancelled(boolean providerCancelled);

	public OperationStatus getOperationStatus();
	public void setOperationStatus(OperationStatus operationStatus);
	public VersionAuditor getAuditor();
	public void setAuditor(VersionAuditor auditor);
}