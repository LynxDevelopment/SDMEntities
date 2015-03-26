package com.lynxspa.sdm.dictionaries.flows;

import com.lynxspa.entities.application.flow.adapters.FlowsDictAdapter;

public enum DynamicDataWorkflow implements FlowsDictAdapter{

	DYNAMICMESSAGE("DYNAMICMESSAGE","dynamic message","dynamic messages flow according"),
	DYNAMICCOLLECTED("DYNAMICCOLLECTED","dynamic collected","collected dynamics flow according to provider"),
	EVENTGROUP("DYNAMICGROUP","dynamic group","group dynamics flow");
	
	
	private String id=null;
	private String name=null;
	private String description=null;

	
	DynamicDataWorkflow(String _id,String _name,String _description){
		this.id=_id;
		this.name=_name;
		this.description=_description;
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
}
