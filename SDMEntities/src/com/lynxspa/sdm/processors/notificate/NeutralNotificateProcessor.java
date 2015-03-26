package com.lynxspa.sdm.processors.notificate;

import org.hibernate.Session;

import com.lynxspa.sdm.dictionaries.CAOperation;
import com.lynxspa.sdm.entities.events.CAEventGroup;

public class NeutralNotificateProcessor implements NotificateProcessorAdapter {

	public void notifyEvent(Session _session, CAOperation type,CAEventGroup group) {
	}
}
