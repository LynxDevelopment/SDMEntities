package com.lynxspa.sdm.processors.complete;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventCollected;

public class NeutralEventCompletProcessor implements EventCompleteAdapter {

	public boolean isEventComplete(Session _session, CAEventCollected collected) throws Exception{
		return true;
	}

}
