package com.lynxspa.sdm.processors.masterrecord.rules.consequences;

public enum Consequence{

	MASTERRECORD("MASTERRECORD",2,"master.record",false,true),
	ALERTANDMASTERRECORD("ALERTANDMASTERRECORD",1,"alert.and.master.record",true,true),
	ALERTANDMANUAL("ALERTANDMANUAL",0,"alert.and.manual",true,false);
	
	
	private String code=null;
	private int weight=0;
	private String description=null;
	private boolean alert=false;
	private boolean masterRecord=false;

	
	Consequence(String _code,int _weight,String _description,boolean _alert,boolean _masterRecord){
		this.code=_code;
		this.weight=_weight;
		this.description=_description;
		this.alert=_alert;
		this.masterRecord=_masterRecord;
	}	
	
	
	public String getCode() {
		return code;
	}
	public int getWeight() {
		return weight;
	}
	public String getDescription() {
		return description;
	}
	public boolean isAlert() {
		return alert;
	}
	public boolean isMasterRecord() {
		return masterRecord;
	}
	
	
	public Consequence accumulatePriority(Consequence _consequence){
		
		Consequence reply=this;
		
		if(_consequence.weight<this.weight){
			reply=_consequence;
		}
		
		return reply;
	}
}
