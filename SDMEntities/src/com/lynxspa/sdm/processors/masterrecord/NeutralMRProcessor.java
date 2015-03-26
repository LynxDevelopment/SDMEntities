package com.lynxspa.sdm.processors.masterrecord;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;
import com.lynxspa.sdm.entities.events.configuration.CAEventConfig;


public class NeutralMRProcessor implements MRProcessorAdapter {

	public class NeutralMRSelectionBean implements MasterRecordSelection{
		
		private CAEventGroup eventGroup=null;
		private CAEventCollected masterRecordSelected=null;
		private List<LogBean> alerts=null;
		
		public NeutralMRSelectionBean(CAEventGroup _eventGroup,CAEventCollected _masterRecordSelected,List<LogBean> _alerts){
			this.eventGroup=_eventGroup;
			this.masterRecordSelected=_masterRecordSelected;
			this.alerts=_alerts;
		}
		
		public CAEventGroup getEventGroup() {
			return eventGroup;
		}
		public void setEventGroup(CAEventGroup eventGroup) {
			this.eventGroup = eventGroup;
		}

		public CAEventCollected getMasterRecordSelected() {
			return masterRecordSelected;
		}
		protected void setMasterRecordSelected(CAEventCollected masterRecordSelected) {
			this.masterRecordSelected = masterRecordSelected;
		}

		public List<LogBean> getAlerts() {
			return alerts;
		}
		public void setAlerts(List<LogBean> alerts) {
			this.alerts = alerts;
		}
	}
	
	public MasterRecordSelection findMasterRecord(Session _session,CAEventGroup _eventGroup) throws FPMException{
		return new NeutralMRSelectionBean(_eventGroup,(CAEventCollected)_eventGroup.getGroupedEvents().get(0),new ArrayList<LogBean>());
	}
	public MasterRecordSelection test (Session _session,CAEventConfig _eventConfig, CAEventGroup _eventGroup) throws FPMException{
		return new NeutralMRSelectionBean(_eventGroup,(CAEventCollected)_eventGroup.getGroupedEvents().get(0),new ArrayList<LogBean>());
	}
}
