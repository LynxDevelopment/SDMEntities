package com.lynxspa.sdm.processors.masterrecord;

import org.hibernate.Session;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.CAEventGroup;
import com.lynxspa.sdm.entities.events.configuration.CAEventConfig;


public interface MRProcessorAdapter {

	public MasterRecordSelection findMasterRecord (Session _session,CAEventGroup _eventGroup) throws FPMException;
	public MasterRecordSelection test (Session _session,CAEventConfig _eventConfig, CAEventGroup _eventGroup) throws FPMException;
}
