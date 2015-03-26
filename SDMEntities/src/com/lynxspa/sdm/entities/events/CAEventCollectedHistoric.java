package com.lynxspa.sdm.entities.events;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.sdm.entities.events.adapters.CAEventCollectedAdapter;
import com.lynxspa.sdm.entities.events.adapters.CAEventGroupAdapter;
import com.lynxspa.sdm.entities.events.details.CAEventDetailHistoric;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;


@Entity
@DiscriminatorValue("collected")
@org.hibernate.annotations.Table(appliesTo="HS_CA_EVENTS",indexes={
		@Index(name="IDX_HSEVENT_FKEVENTGROUP",columnNames="FKEVENTGROUP"),
		@Index(name="IDX_HSEVENT_FKEVENTDETAIL",columnNames="FKEVENTDETAIL"),
		@Index(name="IDX_HSEVENT_FKEVENTPROVIDER",columnNames="FKEVENTPROVIDER")
})
public class CAEventCollectedHistoric extends CAEventHistoric implements CAEventCollectedAdapter{
	
	private static final long serialVersionUID = 5715481671241938311L;

	
	private CAEventProvider eventProvider=null;
	private CAEventGroupAdapter eventGroupHistoric=null;
	private CAEventDetailAdapter eventDetail=null;
	private Boolean complete=false;
	
	
	public CAEventCollectedHistoric(){
		this(null);
	}
	public CAEventCollectedHistoric(String _user){
		super(_user);
	}
	
	
	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSEVENT_PROVIDER")
	@JoinColumn(name="FKEVENTPROVIDER")
	public CAEventProvider getEventProvider() {
		return eventProvider;
	}
	public void setEventProvider(CAEventProvider _eventProvider) {
		this.eventProvider = _eventProvider;
	}
	
	@ManyToOne(targetEntity = CAEventGroupHistoric.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_HSCOLLECTED_GROUP")
	@JoinColumn(name="FKEVENTGROUP")
	public CAEventGroupAdapter getEventGroup() {
		return eventGroupHistoric;
	}
	public void setEventGroup(CAEventGroupAdapter eventGroup) {
		this.eventGroupHistoric = eventGroup;
	}
	
	@ManyToOne(targetEntity = CAEventDetailHistoric.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSEVENT_EVENTDETAIL")
	@JoinColumn(name="FKEVENTDETAIL", nullable=true, updatable=false)
	public CAEventDetailAdapter getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(CAEventDetailAdapter _eventDetail) {
		this.eventDetail = _eventDetail;
	}
	
	@Column(name="ISCOMPLETE")
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
}
