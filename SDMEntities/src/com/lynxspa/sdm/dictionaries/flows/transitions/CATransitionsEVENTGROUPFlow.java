package com.lynxspa.sdm.dictionaries.flows.transitions;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTGROUPFlow;

public enum CATransitionsEVENTGROUPFlow implements TransitionsDictAdapter{

	PMRS_DISC("PMRS_DISC","Matching manual discard","Matching discarted manually",CAStatesEVENTGROUPFlow.PMRS,CAStatesEVENTGROUPFlow.DISC,null,null),
	PMRS_NAUT("PMRS_NAUT","automatic MR found","automatic master record selected",CAStatesEVENTGROUPFlow.PMRS,CAStatesEVENTGROUPFlow.NAUT,null,null),
	PMRS_MMRS("PMRS_MMRS","automatic MR not found","automatic master record not selected",CAStatesEVENTGROUPFlow.PMRS,CAStatesEVENTGROUPFlow.MMRS,null,null),
	MMRS_DISC("MMRS_DISC","Matching manual discard","Matching discarted manually",CAStatesEVENTGROUPFlow.MMRS,CAStatesEVENTGROUPFlow.DISC,null,null),
	MMRS_NAUT("MMRS_NAUT","manual MR select","manual master record select",CAStatesEVENTGROUPFlow.MMRS,CAStatesEVENTGROUPFlow.NAUT,null,null),
	NAUT_MAUT("NAUT_MAUT","manual authorization","manual authorization required",CAStatesEVENTGROUPFlow.NAUT,CAStatesEVENTGROUPFlow.MAUT,null,null),
	MAUT_AUTH("MAUT_AUTH","manually authorized","master record manually authorized",CAStatesEVENTGROUPFlow.MAUT,CAStatesEVENTGROUPFlow.AUTH,null,null),
	MAUT_MMRS("MAUT_MMRS","return to manual MR","return to manual master record selection",CAStatesEVENTGROUPFlow.MAUT,CAStatesEVENTGROUPFlow.MMRS,null,null),
	NAUT_AUTH("NAUT_AUTH","MR authorize","master record authorized",CAStatesEVENTGROUPFlow.NAUT,CAStatesEVENTGROUPFlow.AUTH,null,null),
	AUTH_PMRS("AUTH_PMRS","Rollback authorization","Rollback authorization",CAStatesEVENTGROUPFlow.AUTH,CAStatesEVENTGROUPFlow.PMRS,null,null),
	AUTH_SBOK("AUTH_SBOK","Send to back office new","send to back office new event",CAStatesEVENTGROUPFlow.AUTH,CAStatesEVENTGROUPFlow.SBOK,null,null),
	AUTH_SBKO("AUTH_SBKO","Send to back office failed","send to back office failed",CAStatesEVENTGROUPFlow.AUTH,CAStatesEVENTGROUPFlow.SBKO,null,null),
	SBKO_AUTH("SBKO_AUTH","Repeat backoffice","Repeat backoffice send",CAStatesEVENTGROUPFlow.SBKO,CAStatesEVENTGROUPFlow.AUTH,null,null);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;	
	
	
	CATransitionsEVENTGROUPFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
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
