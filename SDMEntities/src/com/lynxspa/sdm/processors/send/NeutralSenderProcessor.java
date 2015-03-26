package com.lynxspa.sdm.processors.send;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventGroup;

public class NeutralSenderProcessor implements SenderProcessorAdapter {

	public boolean sendEvent(Session _session, CAEventGroup group) {
		return false;
	}
}
