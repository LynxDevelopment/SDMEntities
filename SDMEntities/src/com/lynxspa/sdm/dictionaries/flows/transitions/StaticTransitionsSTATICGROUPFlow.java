package com.lynxspa.sdm.dictionaries.flows.transitions;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.StaticStatesSTATICGROUPFlow;

public enum StaticTransitionsSTATICGROUPFlow implements TransitionsDictAdapter{

	PMRS_DISC("PMRS_DISC","Matching manual discard","Matching discarted manually",StaticStatesSTATICGROUPFlow.PMRS,StaticStatesSTATICGROUPFlow.DISC,null,null),
	PMRS_NAUT("PMRS_NAUT","automatic MR found","automatic master record selected",StaticStatesSTATICGROUPFlow.PMRS,StaticStatesSTATICGROUPFlow.NAUT,null,null),
	PMRS_MMRS("PMRS_MMRS","automatic MR not found","automatic master record not selected",StaticStatesSTATICGROUPFlow.PMRS,StaticStatesSTATICGROUPFlow.MMRS,null,null),
	MMRS_DISC("MMRS_DISC","Matching manual discard","Matching discarted manually",StaticStatesSTATICGROUPFlow.MMRS,StaticStatesSTATICGROUPFlow.DISC,null,null),
	MMRS_NAUT("MMRS_NAUT","manual MR select","manual master record select",StaticStatesSTATICGROUPFlow.MMRS,StaticStatesSTATICGROUPFlow.NAUT,null,null),
	NAUT_MAUT("NAUT_MAUT","manual authorization","manual authorization required",StaticStatesSTATICGROUPFlow.NAUT,StaticStatesSTATICGROUPFlow.MAUT,null,null),
	MAUT_AUTH("MAUT_AUTH","manually authorized","master record manually authorized",StaticStatesSTATICGROUPFlow.MAUT,StaticStatesSTATICGROUPFlow.AUTH,null,null),
	MAUT_MMRS("MAUT_MMRS","return to manual MR","return to manual master record selection",StaticStatesSTATICGROUPFlow.MAUT,StaticStatesSTATICGROUPFlow.MMRS,null,null),
	NAUT_AUTH("NAUT_AUTH","MR authorize","master record authorized",StaticStatesSTATICGROUPFlow.NAUT,StaticStatesSTATICGROUPFlow.AUTH,null,null),
	AUTH_PMRS("AUTH_PMRS","Rollback authorization","Rollback authorization",StaticStatesSTATICGROUPFlow.AUTH,StaticStatesSTATICGROUPFlow.PMRS,null,null),
	AUTH_SBOK("AUTH_SBOK","Send to back office new","send to back office new event",StaticStatesSTATICGROUPFlow.AUTH,StaticStatesSTATICGROUPFlow.SBOK,null,null),
	AUTH_SBKO("AUTH_SBKO","Send to back office failed","send to back office failed",StaticStatesSTATICGROUPFlow.AUTH,StaticStatesSTATICGROUPFlow.SBKO,null,null),
	SBKO_AUTH("SBKO_AUTH","Repeat backoffice","Repeat backoffice send",StaticStatesSTATICGROUPFlow.SBKO,StaticStatesSTATICGROUPFlow.AUTH,null,null);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;	
	
	
	StaticTransitionsSTATICGROUPFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
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
