package com.lynxspa.sdm.dictionaries.flows.states;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;

public enum CAStatesEVENTCOLLECTEDFlow implements StatesDictAdapter{

	UNMC("UNMC","unmatched","event is not matched",true,false),
	MNMC("MNMC","manual mathing","event must be matched manually",false,false),
	MTCH("MTCH","matched","event is matched",false,true);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private boolean initial=false;
	private boolean end=false;
	
	
	CAStatesEVENTCOLLECTEDFlow(String _id,String _name,String _description,boolean _initial,boolean _end){
		this.id=_id;
		this.name=_name;
		this.description=_description;
		this.initial=_initial;
		this.end=_end;
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
	public boolean isInitial() {
		return initial;
	}
	public boolean isEnd() {
		return end;
	}
}
