package com.lynxspa.sdm.entities.events.providers;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("external")
public abstract class CAExternalEventProvider extends CAEventProvider {

	Set<CAFormatProvider> formats=new HashSet<CAFormatProvider>();
	
	
	protected int weight=3;
	
	
	public CAExternalEventProvider(){
		this(null,null,null);
	}
	public CAExternalEventProvider(String _user,String _id){
		this(_user,_id,null);
	}
	public CAExternalEventProvider(String _user,String _id,String _name){
		super(_user,_id,_name);
	}
	
	
	@OneToMany(targetEntity = CAFormatProvider.class, mappedBy="eventProvider",fetch=FetchType.LAZY)
	public Set<CAFormatProvider> getFormats() {
		return formats;
	}
	public void setFormats(Set<CAFormatProvider> formats) {
		this.formats = formats;
	}
}
