package com.lynxspa.sdm.processors.authorize;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventGroup;


public class NoAlertsAuthorizationProcess implements AuthorizeProcessorAdapter{

	public boolean authorizeMasterRecord(Session _session, CAEventGroup group) {
		return (group.getOperationStatus().getTransitionMessageKey()==null);
	}
}
