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
@org.hibernate.annotations.Table(appliesTo="HS_CA_EVENTS",indexes={
	@Index(name="IDX_HSEVENT_FKMASTEREVENT",columnNames="FKMASTEREVENT")
})
public class CAEventGroupHistoric extends CAEventHistoric implements CAEventGroupAdapter{

	private static final long serialVersionUID = 2665736456826385938L;

	
	private CAEventCollectedAdapter masterEvent=null;
	private List<? extends CAEventCollectedAdapter> groupedEvents=null;
	private Date entityDeadLine=null;
	
	public CAEventGroupHistoric(){
		this(null,null);
	}
	public CAEventGroupHistoric(String _user){
		this(_user,null);
	}
	public CAEventGroupHistoric(String _user,CAEventCollected _event){
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

	
	@ManyToOne(targetEntity = CAEventCollectedHistoric.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSGROUP_COLLECTED")
	@JoinColumn(name="FKMASTEREVENT")
	public CAEventCollectedAdapter getMasterEvent() {
		return masterEvent;
	}
	public void setMasterEvent(CAEventCollectedAdapter masterSource) {
		this.masterEvent = masterSource;
	}

	@OneToMany(targetEntity = CAEventCollectedHistoric.class, mappedBy="eventGroup",fetch=FetchType.LAZY)
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
