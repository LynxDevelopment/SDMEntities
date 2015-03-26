package com.lynxspa.sdm.dictionaries.flows.transitions;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTMESSAGEFlow;

public enum CATransitionsEVENTMESSAGEFlow implements TransitionsDictAdapter{

	PNNG_PNFA("PRSD_PNFA","pre-normalize fails","solve pre-normalization incidence",CAStatesEVENTMESSAGEFlow.PRSD,CAStatesEVENTMESSAGEFlow.PNFA,null,null),
	PNFA_PRSD("PNFA_PRSD","retry prenormalization","retry prenormalization",CAStatesEVENTMESSAGEFlow.PNFA,CAStatesEVENTMESSAGEFlow.PRSD,null,null),
	PNFA_MSDS("PNFA_MSDS","discard prenormalization","discard prenormalization",CAStatesEVENTMESSAGEFlow.PNFA,CAStatesEVENTMESSAGEFlow.MSDS,null,null),
	PRSD_PNRM("PRSD_PNRM","pre-normalize done","message prenormalized",CAStatesEVENTMESSAGEFlow.PRSD,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	PNRM_NNRM("PNRM_NNRM","no normalize","not normalizable",CAStatesEVENTMESSAGEFlow.PNRM,CAStatesEVENTMESSAGEFlow.NNRM,null,null),
	NNRM_PNRM("NNRM_PNRM","retry normalization","retry normalization of no normalizable",CAStatesEVENTMESSAGEFlow.NNRM,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	NNRM_PRSD("NNRM_PRSD","retry pre-normalization","retry pre-normalization of no normalizable",CAStatesEVENTMESSAGEFlow.NNRM,CAStatesEVENTMESSAGEFlow.PRSD,null,null),
	NNRM_DISC("NNRM_DISC","discard","discard normalization not normalizable",CAStatesEVENTMESSAGEFlow.NNRM,CAStatesEVENTMESSAGEFlow.DISC,null,null),
	PNRM_NRFA("PNRM_NRFA","normalization fail","fail normalization",CAStatesEVENTMESSAGEFlow.PNRM,CAStatesEVENTMESSAGEFlow.NRFA,null,null),
	NRFA_PNRM("NRFA_PNRM","retry normalization","retry normalization of failed normalization",CAStatesEVENTMESSAGEFlow.NRFA,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	NRFA_DISC("NRFA_DISC","discard","discard normalization failed",CAStatesEVENTMESSAGEFlow.NRFA,CAStatesEVENTMESSAGEFlow.DISC,null,null),
	PNRM_PENF("PNRM_PENF","event not found","previous event not found",CAStatesEVENTMESSAGEFlow.PNRM,CAStatesEVENTMESSAGEFlow.PENF,null,null),
	PENF_PNRM("PENF_PNRM","retry normalization","retry normalization of previous event not found",CAStatesEVENTMESSAGEFlow.PENF,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	PENF_DISC("PENF_DISC","discard","discard normalization of previous event not found",CAStatesEVENTMESSAGEFlow.PENF,CAStatesEVENTMESSAGEFlow.DISC,null,null),
	DISC_PNRM("DISC_PNRM","retry normalization","retry normalization of discarded message",CAStatesEVENTMESSAGEFlow.DISC,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	MSDS_PRSD("MSDS_PRSD","retry prenormalization","retry prenormalization of discarded message",CAStatesEVENTMESSAGEFlow.DISC,CAStatesEVENTMESSAGEFlow.PNRM,null,null),
	PNRM_NORM("PNRM_NORM","normalize finish","finish normalization",CAStatesEVENTMESSAGEFlow.PNRM,CAStatesEVENTMESSAGEFlow.NORM,null,null),
	NORM_NRFA("NORM_NRFA","normalization update fail","normalization update fail",CAStatesEVENTMESSAGEFlow.NORM,CAStatesEVENTMESSAGEFlow.NRFA,null,null);

	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;
	
	
	CATransitionsEVENTMESSAGEFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
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
