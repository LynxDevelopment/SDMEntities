package com.lynxspa.sdm.processors.prenormalize;

import org.hibernate.Session;

import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;

public interface PrenormalizerProcessorAdapter {

	public String prenormalizeOperation(Session _session,CAEventMessage _message,String _user,String _locale) throws FPMException;
	public CAExternalEventProvider prenormalizeProvider(Session _session,CAEventMessage _message,String _user,String _locale) throws FPMException;
	public CAEventType prenormalizeEventType(Session _session,CAEventMessage _message,String _user,String _locale) throws FPMException;
	public SPVirtualSecurity prenormalizeSecurity(Session _session,CAEventMessage _message,String _user,String _locale) throws FPMException;
}
