package com.lynxspa.sdm.processors.complete;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventCollected;


public interface EventCompleteAdapter {

	public boolean isEventComplete(Session _session,CAEventCollected _eventCollected) throws Exception;
}
