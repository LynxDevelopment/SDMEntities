package com.lynxspa.sdm.entities.events.providers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("manual")
public class CAManualEventProvider extends CAEventProvider {

	private static final long serialVersionUID = 679586496810510389L;
	
	
	protected int weight=1;
	
	
	public CAManualEventProvider(){
		this(null,null,null);
	}
	public CAManualEventProvider(String _user,String _id){
		this(_user,_id,null);
	}
	public CAManualEventProvider(String _user,String _id,String _name){
		super(_user,_id,_name);
	}
}
