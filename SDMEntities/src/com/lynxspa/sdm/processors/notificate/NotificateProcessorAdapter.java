package com.lynxspa.sdm.processors.notificate;

import org.hibernate.Session;

import com.lynxspa.sdm.dictionaries.CAOperation;
import com.lynxspa.sdm.entities.events.CAEventGroup;


public interface NotificateProcessorAdapter {

	public void notifyEvent(Session _session,CAOperation _notificationType,CAEventGroup _eventGroup);
}
