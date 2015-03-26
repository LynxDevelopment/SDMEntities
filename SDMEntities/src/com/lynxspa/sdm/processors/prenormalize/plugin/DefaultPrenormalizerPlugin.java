package com.lynxspa.sdm.processors.prenormalize.plugin;

import org.hibernate.Session;

import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.CABasicDomains;
import com.lynxspa.sdm.dictionaries.CAType;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.managers.SDMConfigManager;

public class DefaultPrenormalizerPlugin {

	public CAEventType prenormalizeEventType(final Session _session,final CAEventMessage _message,final String _user,final String _locale) throws FPMException{
		
		CAEventType reply = null;

		final String normalizedEventType=SDMConfigManager.getInstance().getDomainNorm(_session,CABasicDomains.EVENTTYPE.getCode(), _message, _message.getEventType());
		if(normalizedEventType!=null){
			reply=(CAEventType)_session.load(CAEventType.class, normalizedEventType);
		}else{
			reply=(CAEventType)_session.load(CAEventType.class, CAType.OTHR.getCode());
		}
		
		return reply;
	}
	
	public boolean isMainMarket(final Session _session,final CAEventMessage _message,final SPVirtualSecurity _security,final String _user,final String _locale) throws FPMException{
		return true;
	}
}
