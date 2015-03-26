package com.lynxspa.sdm.dictionaries.flows.transitions;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.DynamicStatesDYNAMICCOLLECTEDFlow;

public enum DynamicTransitionsDYNAMICCOLLECTEDFlow implements TransitionsDictAdapter{
	PNDV_VRFD("PNDV_VRFD","verified","verified",DynamicStatesDYNAMICCOLLECTEDFlow.PNDV,DynamicStatesDYNAMICCOLLECTEDFlow.VRFD,null,null),
	PNDV_ERVF("PNDV_ERVF","error verified","error verified",DynamicStatesDYNAMICCOLLECTEDFlow.PNDV,DynamicStatesDYNAMICCOLLECTEDFlow.ERVF,null,null),
	ERVF_PNDV("ERVF_PNDV","retry verified","retry verified",DynamicStatesDYNAMICCOLLECTEDFlow.ERVF,DynamicStatesDYNAMICCOLLECTEDFlow.PNDV,null,null),
	UNMC_MNMC("UNMC_MNMC","manual matching","can't be matched automatically",DynamicStatesDYNAMICCOLLECTEDFlow.UNMC,DynamicStatesDYNAMICCOLLECTEDFlow.MNMC,null,null),
	MNMC_MTCH("MNMC_MTCH","manual match","manual match",DynamicStatesDYNAMICCOLLECTEDFlow.MNMC,DynamicStatesDYNAMICCOLLECTEDFlow.MTCH,null,null),
	UNMC_MTCH("UNMC_MTCH","automatic match","automatic match",DynamicStatesDYNAMICCOLLECTEDFlow.UNMC,DynamicStatesDYNAMICCOLLECTEDFlow.MTCH,null,null),
	MTCH_MNMC("MTCH_MNMC","manual unmatch","manual unmatch",DynamicStatesDYNAMICCOLLECTEDFlow.MTCH,DynamicStatesDYNAMICCOLLECTEDFlow.MNMC,null,null);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;
	
	
	DynamicTransitionsDYNAMICCOLLECTEDFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
		this.id=_id;
		this.name=_name;
		this.description=_description;
		this.initialState=_initialState;
		this.endState=_endState;
		this.transitionExecutorClass=_transitionExecutorClass;
		this.logMessage=_logMessage;
	}

	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public StatesDictAdapter getInitialState() {
		return initialState;
	}
	public StatesDictAdapter getEndState() {
		return endState;
	}
	public String getTransitionExecutorClass() {
		return transitionExecutorClass;
	}
	public LogDictAdapter getMessageLog() {
		return logMessage;
	}
}
