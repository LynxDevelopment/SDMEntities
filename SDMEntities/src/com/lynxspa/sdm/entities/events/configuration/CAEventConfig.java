package com.lynxspa.sdm.entities.events.configuration;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;


@Entity
@Table(name="TB_CA_EVENTCONFIGS",uniqueConstraints={@UniqueConstraint(columnNames={"FKEVENTTYPE"})})
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTCONFIGS",indexes={
		@Index(name="IDX_EVCONFIG_DELETED",columnNames="ISDELETED")
})
public class CAEventConfig implements UpdatableAdapter{

	private static final long serialVersionUID = -6177927482583801265L;
	
	
	private long id=0l;
	private CAEventType eventType=null;
	private CAEventProvider preferentProvider=null;
	private CAEventProvider secondPreferentProvider=null;
	private String onPrimaryAndSecondaryNotFound=null;
	private String onCustodianAndManualNotFound=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	private List<CAEventMasterRecordConfig> masterRecordConfigs=null;
	private List<CAEventFieldConfig> eventFieldConfigs=null;


	public CAEventConfig(){
		this(null,null);
	}
	public CAEventConfig(String _user,CAEventType _eventType){
		super();
		this.eventType=_eventType;
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="CAEVENTCONF_GEN", sequenceName="CAEVENTCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVENTCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventType.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVENTCONFIG_EVENTTYPE")
	@JoinColumn(name="FKEVENTTYPE", referencedColumnName="ID")
	public CAEventType getEventType() {
		return eventType;
	}
	public void setEventType(CAEventType eventType) {
		this.eventType = eventType;
	}

	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER, optional=false)
	@ForeignKey(name="FK_EVENTCONFIG_EVENTPROVIDER1")
	@JoinColumn(name="FKPREFPROVIDER1", nullable=false)
	public CAEventProvider getPreferentProvider() {
		return preferentProvider;
	}
	public void setPreferentProvider(CAEventProvider preferentProvider) {
		this.preferentProvider = preferentProvider;
	}

	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_EVENTCONFIG_EVENTPROVIDER2")
	@JoinColumn(name="FKSECPREFPROV2", nullable=true)
	public CAEventProvider getSecondPreferentProvider() {
		return secondPreferentProvider;
	}
	public void setSecondPreferentProvider(CAEventProvider secondPreferentProvider) {
		this.secondPreferentProvider = secondPreferentProvider;
	}
	
	@Column(name="PRIMSECNOTFOUND", length=32, nullable=false)
	public String getOnPrimaryAndSecondaryNotFound() {
		return onPrimaryAndSecondaryNotFound;
	}
	public void setOnPrimaryAndSecondaryNotFound(String onPrimaryAndSecondaryNotFound) {
		this.onPrimaryAndSecondaryNotFound = onPrimaryAndSecondaryNotFound;
	}
	
	@Column(name="CUSTMANNOTFOUND", length=32, nullable=false)
	public String getOnCustodianAndManualNotFound() {
		return onCustodianAndManualNotFound;
	}
	public void setOnCustodianAndManualNotFound(String onCustodianAndManualNotFound) {
		this.onCustodianAndManualNotFound = onCustodianAndManualNotFound;
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
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}
	
	@OneToMany(targetEntity = CAEventMasterRecordConfig.class, mappedBy="eventConfig",fetch=FetchType.LAZY)
	@OrderBy("ruleOrder")
	public List<CAEventMasterRecordConfig> getMasterRecordConfigs() {
		return masterRecordConfigs;
	}
	public void setMasterRecordConfigs(List<CAEventMasterRecordConfig> masterRecordConfigs) {
		this.masterRecordConfigs = masterRecordConfigs;
	}
	
	@OneToMany(targetEntity = CAEventFieldConfig.class, mappedBy="eventConfig",fetch=FetchType.LAZY)
	public List<CAEventFieldConfig> getEventFieldConfigs() {
		return eventFieldConfigs;
	}
	public void setEventFieldConfigs(List<CAEventFieldConfig> eventFieldConfigs) {
		this.eventFieldConfigs = eventFieldConfigs;
	}
}
