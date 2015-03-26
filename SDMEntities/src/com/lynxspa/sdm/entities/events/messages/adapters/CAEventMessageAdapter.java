package com.lynxspa.sdm.entities.events.messages.adapters;

import java.util.Date;
import java.util.Map;

import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;

public interface CAEventMessageAdapter{

	public long getId();
	public void setId(long id);
	
	public int getVersion();
	public void setVersion(int version);

	public long getNormalizedEvent();
	public void setNormalizedEvent(long normalizedEvent);
	public String getOriginId();
	public void setOriginId(String originId);
	public String getOriginName();
	public void setOriginName(String originName);
	public String getOriginType();
	public void setOriginType(String originType);
	public int getOriginPosition();
	public void setOriginPosition(int originPosition);
	public String getMessageId();
	public void setMessageId(String messageId);
	public CAMessageType getMessageType();
	public void setMessageType(CAMessageType messageType);
	public String getEventType();
	public void setEventType(String eventType);
	public String getOperation();
	public void setOperation(String operation);
	public String getSender();
	public void setSender(String sender);
	public boolean isExtension();
	public void setExtension(boolean extension);
	public String getExtensionReference();
	public void setExtensionReference(String extensionReference);
	public String getReceiver();
	public void setReceiver(String receiver);
	public String getEventReference();
	public void setEventReference(String eventReference);
	public String getEventMessageReference();
	public void setEventMessageReference(String eventMessageReference);
	public String getPreviousEventMessageReference();
	public void setPreviousEventMessageReference(String previousEventMessageReference);
	public String getSecurityType();
	public void setSecurityType(String securityType);
	public String getSecurity();
	public void setSecurity(String security);
	public String getSecurityName();
	public void setSecurityName(String securityName);
	public Date getAnnounceDate();
	public void setAnnounceDate(Date announceDate);
	public Date getEffectiveDate();
	public void setEffectiveDate(Date effectiveDate);
	public Date getSenderTimestamp();
	public void setSenderTimestamp(Date senderTimestamp);
	public String getAccount();
	public void setAccount(String account);
	public long getAmount();
	public void setAmount(long amount);
	public String getOriginalMessage();
	public void setOriginalMessage(String originalMessage);
	public CAEventType getNormalizedEventType();
	public void setNormalizedEventType(CAEventType normalizedEventType);
	public SPVirtualSecurity getNormalizedSecurity();
	public void setNormalizedSecurity(SPVirtualSecurity normalizedSecurity);
	public String getNormalizedOperation();
	public void setNormalizedOperation(String normalizedOperation);
	public CAExternalEventProvider getEventProvider();
	public void setEventProvider(CAExternalEventProvider eventProvider);
	public boolean isMainMarket();
	public void setMainMarket(boolean mainMarket);
	public boolean isInCustomerPortfolio();
	public void setInCustomerPortfolio(boolean inCustomerPortfolio);

	public OperationStatus getOperationStatus();
	public void setOperationStatus(OperationStatus operationStatus);
	public UpdateAuditor getAuditor();
	public void setAuditor(UpdateAuditor _auditor);

	public Map<String,? extends CAEventMessageFieldAdapter> getFields();
	public void setFields(Map<String,? extends CAEventMessageFieldAdapter> fields);
	public void addField(CAEventMessageFieldAdapter field);
	public void addField(String _path,String _value);
	public String getField(String _path);
}