package com.lynxspa.sdm.entities.events.providers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("external.cust")
public class CACustodianEventProvider extends CAExternalEventProvider {

	private static final long serialVersionUID = -7191752943442774530L;

	
	protected int weight=2;
	
	
	public CACustodianEventProvider(){
		this(null,null,null);
	}
	public CACustodianEventProvider(String _user,String _id){
		this(_user,_id,null);
	}
	public CACustodianEventProvider(String _user,String _id,String _name){
		super(_user,_id,_name);
	}
}
