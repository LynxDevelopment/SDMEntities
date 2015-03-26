package com.lynxspa.sdm.dictionaries.flows.transitions;


import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;
import com.lynxspa.entities.application.flow.adapters.TransitionsDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.sdm.dictionaries.flows.states.StaticStatesSTATICMESSAGEFlow;

public enum StaticTransitionsSTATICMESSAGEFlow implements TransitionsDictAdapter{

	PNNG_PNFA("PRSD_PNFA","pre-normalize fails","solve pre-normalization incidence",StaticStatesSTATICMESSAGEFlow.PRSD,StaticStatesSTATICMESSAGEFlow.PNFA,null,null),
	PNFA_PRSD("PNFA_PRSD","retry prenormalization","retry prenormalization",StaticStatesSTATICMESSAGEFlow.PNFA,StaticStatesSTATICMESSAGEFlow.PRSD,null,null),
	PNFA_MSDS("PNFA_MSDS","discard prenormalization","discard prenormalization",StaticStatesSTATICMESSAGEFlow.PNFA,StaticStatesSTATICMESSAGEFlow.MSDS,null,null),
	PRSD_PNRM("PRSD_PNRM","pre-normalize done","message prenormalized",StaticStatesSTATICMESSAGEFlow.PRSD,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	PNRM_NNRM("PNRM_NNRM","no normalize","not normalizable",StaticStatesSTATICMESSAGEFlow.PNRM,StaticStatesSTATICMESSAGEFlow.NNRM,null,null),
	NNRM_PNRM("NNRM_PNRM","retry normalization","retry normalization of no normalizable",StaticStatesSTATICMESSAGEFlow.NNRM,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	NNRM_PRSD("NNRM_PRSD","retry pre-normalization","retry pre-normalization of no normalizable",StaticStatesSTATICMESSAGEFlow.NNRM,StaticStatesSTATICMESSAGEFlow.PRSD,null,null),
	NNRM_DISC("NNRM_DISC","discard","discard normalization not normalizable",StaticStatesSTATICMESSAGEFlow.NNRM,StaticStatesSTATICMESSAGEFlow.DISC,null,null),
	PNRM_NRFA("PNRM_NRFA","normalization fail","fail normalization",StaticStatesSTATICMESSAGEFlow.PNRM,StaticStatesSTATICMESSAGEFlow.NRFA,null,null),
	NRFA_PNRM("NRFA_PNRM","retry normalization","retry normalization of failed normalization",StaticStatesSTATICMESSAGEFlow.NRFA,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	NRFA_DISC("NRFA_DISC","discard","discard normalization failed",StaticStatesSTATICMESSAGEFlow.NRFA,StaticStatesSTATICMESSAGEFlow.DISC,null,null),
	PNRM_PENF("PNRM_PENF","event not found","previous event not found",StaticStatesSTATICMESSAGEFlow.PNRM,StaticStatesSTATICMESSAGEFlow.PENF,null,null),
	PENF_PNRM("PENF_PNRM","retry normalization","retry normalization of previous event not found",StaticStatesSTATICMESSAGEFlow.PENF,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	PENF_DISC("PENF_DISC","discard","discard normalization of previous event not found",StaticStatesSTATICMESSAGEFlow.PENF,StaticStatesSTATICMESSAGEFlow.DISC,null,null),
	DISC_PNRM("DISC_PNRM","retry normalization","retry normalization of discarded message",StaticStatesSTATICMESSAGEFlow.DISC,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	MSDS_PRSD("MSDS_PRSD","retry prenormalization","retry prenormalization of discarded message",StaticStatesSTATICMESSAGEFlow.DISC,StaticStatesSTATICMESSAGEFlow.PNRM,null,null),
	PNRM_NORM("PNRM_NORM","normalize finish","finish normalization",StaticStatesSTATICMESSAGEFlow.PNRM,StaticStatesSTATICMESSAGEFlow.NORM,null,null),
	NORM_NRFA("NORM_NRFA","normalization update fail","normalization update fail",StaticStatesSTATICMESSAGEFlow.NORM,StaticStatesSTATICMESSAGEFlow.NRFA,null,null);

	
	private String id=null;
	private String name=null;
	private String description=null;
	private StatesDictAdapter initialState=null;
	private StatesDictAdapter endState=null;
	private String transitionExecutorClass=null;
	private LogDictAdapter logMessage=null;
	
	
	StaticTransitionsSTATICMESSAGEFlow(String _id,String _name,String _description,StatesDictAdapter _initialState,StatesDictAdapter _endState,String _transitionExecutorClass,LogDictAdapter _logMessage){
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
