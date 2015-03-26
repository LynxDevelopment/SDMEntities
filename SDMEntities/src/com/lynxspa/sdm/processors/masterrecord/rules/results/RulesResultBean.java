package com.lynxspa.sdm.processors.masterrecord.rules.results;

import java.util.ArrayList;
import java.util.List;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;
import com.lynxspa.sdm.processors.masterrecord.MasterRecordSelection;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;


public class RulesResultBean implements MasterRecordSelection{

	private CAEventGroup eventGroup=null;
	private CAEventCollected masterRecordSelected=null;
	private Consequence consequence=null;
	private List<LogBean> alerts=null;
	private List<RuleResultDebugBean> debugInfo=null;
	
	
	public RulesResultBean(CAEventCollected _masterRecordSelected,Consequence _consequence){
		this.masterRecordSelected=_masterRecordSelected;
		this.consequence=_consequence;
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

	public Consequence getConsequence() {
		return consequence;
	}
	public void setConsequence(Consequence consequence) {
		this.consequence = consequence;
	}
	
	public List<LogBean> getAlerts() {
		return alerts;
	}
	public void setAlerts(List<LogBean> alerts) {
		this.alerts = alerts;
	}
	public void addAlert(LogBean _alert) {
		if(this.alerts==null)
			this.alerts=new ArrayList<LogBean>();
		this.alerts.add(_alert);
	}
	
	public List<RuleResultDebugBean> getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(List<RuleResultDebugBean> debugInfo) {
		this.debugInfo = debugInfo;
	}
	public void addDebugInfo(RuleResultDebugBean _debugInfo) {
		if(this.debugInfo==null)
			this.debugInfo=new ArrayList<RuleResultDebugBean>();
		this.debugInfo.add(_debugInfo);
	}

	public void accumulateResult(Consequence _ruleResultBean){
		this.consequence=this.consequence.accumulatePriority(_ruleResultBean);
	}
}
