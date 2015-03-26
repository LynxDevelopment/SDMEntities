package com.lynxspa.sdm.processors.authorize;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventGroup;


public interface AuthorizeProcessorAdapter {

	public boolean authorizeMasterRecord(Session _session,CAEventGroup _eventGroup);
}
