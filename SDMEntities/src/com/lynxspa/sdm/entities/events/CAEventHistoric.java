package com.lynxspa.sdm.entities.events;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.entities.application.flow.operations.OperableAdapter;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.sdm.entities.events.adapters.CAEventAdapter;
import com.lynxspa.sdm.entities.events.types.CAEventType;


@Entity
@Table(name="HS_CA_EVENTS") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EVENTCLASS", discriminatorType=DiscriminatorType.STRING, length=32)
@org.hibernate.annotations.Table(appliesTo="HS_CA_EVENTS",indexes={
		@Index(name="IDX_HSEVENT_REFID",columnNames="REFID"),
		@Index(name="IDX_HSEVENT_VERSION",columnNames="VERSION"),
		@Index(name="IDX_HSEVENT_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_HSEVENT_EVENTCLASS",columnNames="EVENTCLASS"),
		@Index(name="IDX_HSEVENT_STATUS",columnNames={"ISENDED","FKSTATEFLOW","FKSTATE"}),
		@Index(name="IDX_HSEVENT_SECURITY",columnNames="FKSECURITY"),
		@Index(name="IDX_HSEVENT_EVENTTYPE",columnNames="FKEVENTTYPE"),
		@Index(name="IDX_HSEVENT_OPERDATE",columnNames="OPERATIONALDATE")
})
public class CAEventHistoric implements VersionableAdapter,OperableAdapter,CAEventAdapter{
	
	private static final long serialVersionUID = 3827494125619620502L;

	private long id=0l;
	private CAEventType eventType=null;
	private SPSecurity security=null;
	private Date subscriptionDate=null;
	private Date executionDate=null;
	private Date expirationDate=null;
	private Date operationalDate=null;
	private boolean providerUpdated=false;
	private boolean providerCancelled=false;
	private int version=0;
	private VersionAuditor auditor=null;
	private OperationStatus operationStatus=null;
	private boolean mandatory=false;
	
	public CAEventHistoric(){
		this(null);
	}
	public CAEventHistoric(String _user){
		super();
		this.auditor=new VersionAuditor(_user);
		this.operationStatus=new OperationStatus();
	}
	
	
	@Id
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSEVENT_EVENTTYPE")
	@JoinColumn(name="FKEVENTTYPE", nullable=false, updatable=false)
	public CAEventType getEventType() {
		return eventType;
	}
	public void setEventType(CAEventType eventType) {
		this.eventType = eventType;
	}
	
	@ManyToOne(targetEntity = SPSecurity.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSEVENT_SECURITY")
	@JoinColumn(name="FKSECURITY", nullable=true)
	public SPSecurity getSecurity() {
		return security;
	}
	public void setSecurity(SPSecurity security) {
		this.security = security;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="SUBSCRIPTIONDATE", nullable=true)
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date suscriptionDate) {
		this.subscriptionDate = suscriptionDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXECUTIONDATE", nullable=true)
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATIONDATE", nullable=true)
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="OPERATIONALDATE", nullable=true)
	public Date getOperationalDate() {
		return operationalDate;
	}
	public void setOperationalDate(Date operationalDate) {
		this.operationalDate = operationalDate;
	}
	
	@Column(name="ISPROVUPDATED", nullable=false)
	public boolean isProviderUpdated() {
		return providerUpdated;
	}
	public void setProviderUpdated(boolean providerUpdated) {
		this.providerUpdated = providerUpdated;
	}
	
	@Column(name="ISPROVCANCELLED", nullable=false)
	public boolean isProviderCancelled() {
		return providerCancelled;
	}
	public void setProviderCancelled(boolean providerCancelled) {
		this.providerCancelled = providerCancelled;
	}
	
	@Column(name="ISMANDATORY", nullable=false)
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}	
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Embedded
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	
	@Embedded
	public VersionAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(VersionAuditor _auditor) {
		this.auditor=_auditor;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
