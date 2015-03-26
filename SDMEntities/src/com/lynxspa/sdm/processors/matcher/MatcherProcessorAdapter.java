package com.lynxspa.sdm.processors.matcher;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;


public interface MatcherProcessorAdapter {

	public CAEventGroup findGroupMember(Session _session,CAEventCollected _eventCollected) throws Exception;
}
