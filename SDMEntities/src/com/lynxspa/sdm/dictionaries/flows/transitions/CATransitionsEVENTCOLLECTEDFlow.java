package com.lynxspa.sdm.dictionaries.flows.transitions;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTCOLLECTEDFlow;

public enum CATransitionsEVENTCOLLECTEDFlow implements TransitionsDictAdapter{

	UNMC_MNMC("UNMC_MNMC","manual matching","can't be matched automatically",CAStatesEVENTCOLLECTEDFlow.UNMC,CAStatesEVENTCOLLECTEDFlow.MNMC,null,null),
	MNMC_MTCH("MNMC_MTCH","manual match","manual match",CAStatesEVENTCOLLECTEDFlow.MNMC,CAStatesEVENTCOLLECTEDFlow.MTCH,null,null),
	UNMC_MTCH("UNMC_MTCH","automatic match","automatic match",CAStatesEVENTCOLLECTEDFlow.UNMC,CAStatesEVENTCOLLECTEDFlow.MTCH,null,null),
	MTCH_MNMC("MTCH_MNMC","manual unmatch","manual unmatch",CAStatesEVENTCOLLECTEDFlow.MTCH,CAStatesEVENTCOLLECTEDFlow.MNMC,null,null);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;
	
	
	CATransitionsEVENTCOLLECTEDFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
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
