package com.lynxspa.sdm.processors.matcher;

import org.hibernate.Session;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;

public class SimpleMatcherProcessor implements MatcherProcessorAdapter {

	public CAEventGroup findGroupMember(Session _session,CAEventCollected _eventCollected) throws FPMException{
		
		return null;
	}
}
