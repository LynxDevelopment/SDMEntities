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
import com.lynxspa.sdm.entities.events.details.CAEventDetail;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;


@Entity
@DiscriminatorValue("collected")
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTS",indexes={
		@Index(name="IDX_EVENT_FKEVENTGROUP",columnNames="FKEVENTGROUP"),
		@Index(name="IDX_EVENT_FKEVENTDETAIL",columnNames="FKEVENTDETAIL"),
		@Index(name="IDX_EVENT_FKEVENTPROVIDER",columnNames="FKEVENTPROVIDER")
})
public class CAEventCollected extends CAEvent implements CAEventCollectedAdapter{
	
	private static final long serialVersionUID = 5715481671241938311L;

	
	private CAEventProvider eventProvider=null;
	private CAEventGroupAdapter eventGroup=null;
	private CAEventDetailAdapter eventDetail=null;
	private Boolean complete=false;
	
	
	public CAEventCollected(){
		this(null);
	}
	public CAEventCollected(String _user){
		super(_user);
	}
	
	
	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_EVENT_PROVIDER")
	@JoinColumn(name="FKEVENTPROVIDER",nullable=true,updatable=false)
	public CAEventProvider getEventProvider() {
		return eventProvider;
	}
	public void setEventProvider(CAEventProvider _eventProvider) {
		this.eventProvider = _eventProvider;
	}
	
	@ManyToOne(targetEntity = CAEventGroup.class,fetch=FetchType.EAGER,optional=true)
	@ForeignKey(name="FK_COLLECTED_GROUP")
	@JoinColumn(name="FKEVENTGROUP",nullable=true,updatable=true)
	public CAEventGroupAdapter getEventGroup() {
		return eventGroup;
	}
	public void setEventGroup(CAEventGroupAdapter eventGroup) {
		this.eventGroup = eventGroup;
	}
	
	@ManyToOne(targetEntity = CAEventDetail.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_EVENT_EVENTDETAIL")
	@JoinColumn(name="FKEVENTDETAIL", nullable=true, updatable=false)
	public CAEventDetailAdapter getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(CAEventDetailAdapter _eventDetail) {
		this.eventDetail = _eventDetail;
	}
	
	@Column(name="ISCOMPLETE",nullable=true)
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
}
