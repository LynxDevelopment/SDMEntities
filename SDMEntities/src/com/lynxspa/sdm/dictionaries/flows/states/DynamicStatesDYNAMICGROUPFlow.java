package com.lynxspa.sdm.dictionaries.flows.states;

import com.lynxspa.entities.application.flow.adapters.StatesDictAdapter;

public enum DynamicStatesDYNAMICGROUPFlow implements StatesDictAdapter{

	PMRS("PMRS","Pending master record","Pending master record selection",true,false),
	MMRS("MMRS","Manual master record selection","Manual master record selection",false,false),
	DISC("DISC","Discarted","Discarted",false,true),
	NAUT("NAUT","Not authorized","Not authorized",false,false),
	MAUT("MAUT","Manual authorization","Manual authorization",false,false),
	AUTH("AUTH","Authorized master record","Authorized master record",false,false),
	TBKU("TBKU","To send Backoffice update","To Send Backoffice update event",false,false),
	TBKC("TBKC","To send Backoffice cancel","To Send Backoffice cancel event",false,false),
	SBOK("SBOK","Sent Backoffice","Sent Backoffice event",false,false),
	SBKO("SBKO","Sent Backoffice fail","Sent Backoffice fail event",false,false),
	//TODO FIXME: SUSC is only for AndBanc Customer. Please move this to customer intaller source 
	SUSC("SUSC","Subscribe","Subscribe",true,true);
	
	
	private String id=null;
	private String name=null;
	private String description=null;
	private boolean initial=false;
	private boolean end=false;
	
	
	DynamicStatesDYNAMICGROUPFlow(String _id,String _name,String _description,boolean _initial,boolean _end){
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
