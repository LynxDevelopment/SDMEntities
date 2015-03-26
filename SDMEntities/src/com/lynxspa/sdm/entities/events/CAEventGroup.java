package com.lynxspa.sdm.entities.events;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Where;

import com.lynxspa.sdm.entities.events.adapters.CAEventCollectedAdapter;
import com.lynxspa.sdm.entities.events.adapters.CAEventGroupAdapter;


@Entity
@DiscriminatorValue("group")
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTS",indexes={
	@Index(name="IDX_EVENT_FKMASTEREVENT",columnNames="FKMASTEREVENT")
})
public class CAEventGroup extends CAEvent implements CAEventGroupAdapter{

	private static final long serialVersionUID = 2665736813916385938L;

	
	private CAEventCollectedAdapter masterEvent=null;
	
	
	private List<? extends CAEventCollectedAdapter> groupedEvents=null;
	private Date entityDeadLine=null;
	
	public CAEventGroup(){
		this(null,null);
	}
	public CAEventGroup(String _user){
		this(_user,null);
	}
	public CAEventGroup(String _user,CAEventCollected _event){
		super(_user);
		if(_event!=null){
			setEventType(_event.getEventType());
			setExecutionDate(_event.getExecutionDate());
			setExpirationDate(_event.getExpirationDate());
			setOperationalDate(_event.getOperationalDate());
			setSecurity(_event.getSecurity());
			setSubscriptionDate(_event.getSubscriptionDate());
		}
	}

	
	@ManyToOne(targetEntity = CAEventCollected.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_GROUP_COLLECTED")
	@JoinColumn(name="FKMASTEREVENT")
	public CAEventCollectedAdapter getMasterEvent() {
		return masterEvent;
	}
	public void setMasterEvent(CAEventCollectedAdapter masterSource) {
		this.masterEvent = masterSource;
	}

	@OneToMany(targetEntity = CAEventCollected.class, mappedBy="eventGroup",fetch=FetchType.LAZY)
	@Where(clause="REFID=0")
	public List<? extends CAEventCollectedAdapter> getGroupedEvents() {
		return groupedEvents;
	}
	public void setGroupedEvents(List<? extends CAEventCollectedAdapter> groupedEvents) {
		this.groupedEvents = groupedEvents;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENTITYOPERATIONALDATE", nullable=true)
	public Date getEntityDeadLine() {
		return entityDeadLine;
	}
	public void setEntityDeadLine(Date entityDeadLine) {
		this.entityDeadLine = entityDeadLine;
	}
}
