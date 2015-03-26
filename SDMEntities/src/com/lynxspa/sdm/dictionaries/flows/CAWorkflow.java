package com.lynxspa.sdm.dictionaries.flows;

import com.lynxspa.entities.application.flow.adapters.FlowsDictAdapter;

public enum CAWorkflow implements FlowsDictAdapter{

	EVENTMESSAGE("EVENTMESSAGE","event message","event messages flow according"),
	EVENTCOLLECTED("EVENTCOLLECTED","event collected","collected events flow according to provider"),
	EVENTGROUP("EVENTGROUP","event group","group events flow");
	
	
	private String id=null;
	private String name=null;
	private String description=null;

	
	CAWorkflow(String _id,String _name,String _description){
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
