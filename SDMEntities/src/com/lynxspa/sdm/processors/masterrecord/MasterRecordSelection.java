package com.lynxspa.sdm.processors.masterrecord;

import java.util.List;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;

public interface MasterRecordSelection {

	public CAEventGroup getEventGroup();
	public CAEventCollected getMasterRecordSelected();
	public List<LogBean> getAlerts();
}
