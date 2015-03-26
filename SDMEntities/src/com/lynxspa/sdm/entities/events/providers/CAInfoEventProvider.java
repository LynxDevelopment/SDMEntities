package com.lynxspa.sdm.entities.events.providers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("external.info")
public class CAInfoEventProvider extends CAExternalEventProvider{

	private static final long serialVersionUID = 4567033317511668061L;

	
	protected int weight=3;
	
	
	public CAInfoEventProvider(){
		this(null,null,null);
	}
	public CAInfoEventProvider(String _user,String _id){
		this(_user,_id,null);
	}
	public CAInfoEventProvider(String _user,String _id,String _name){
		super(_user,_id,_name);
	}
}
