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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;


@Entity
@Table(name="TB_CA_EVENTCONFIGFIELDS",uniqueConstraints={@UniqueConstraint(columnNames={"FKEVENTCONFIG","FKEVENTTYPEDETAIL"})})
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTCONFIGFIELDS",indexes={
		@Index(name="IDX_EVCONFFLD_FKEVCONF",columnNames="FKEVENTCONFIG"),
		@Index(name="IDX_EVCONFFLD_FKEVTYPEDET",columnNames="FKEVENTTYPEDETAIL"),
		@Index(name="IDX_EVCONFFLD_DELETED",columnNames="ISDELETED")
})
public class CAEventFieldConfig implements UpdatableAdapter{

	private static final long serialVersionUID = -6177927482583801265L;
	
	private long id=0l;
	private CAEventConfig eventConfig=null;
	private CAEventTypeDetail eventTypeDetail=null;
	private boolean required=false;
	
	private int version=0;
	private UpdateAuditor auditor=null;
		
	private List<CAEventFieldMessageConfig> messageConfigs=null;
	

	public CAEventFieldConfig(){
		this(null,null,null);
	}
	public CAEventFieldConfig(String _user,CAEventConfig _eventConfig,CAEventTypeDetail _eventTypeDetail){
		super();
		this.auditor=new UpdateAuditor(_user);
		this.eventConfig=_eventConfig;
		this.eventTypeDetail=_eventTypeDetail;
	}
	
	
	@Id
	@SequenceGenerator(name="CAEVFIELDCONF_GEN", sequenceName="CAEVFIELDCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVFIELDCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventConfig.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVNCONFFIELD_EVENTCONFIG")
	@JoinColumn(name="FKEVENTCONFIG",referencedColumnName="ID")
	public CAEventConfig getEventConfig() {
		return eventConfig;
	}
	public void setEventConfig(CAEventConfig eventConfig) {
		this.eventConfig = eventConfig;
	}
	
	@ManyToOne(targetEntity = CAEventTypeDetail.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVNCONFFIELD_EVNTYPEDET")
	@JoinColumn(name="FKEVENTTYPEDETAIL")
	public CAEventTypeDetail getEventTypeDetail() {
		return eventTypeDetail;
	}
	public void setEventTypeDetail(CAEventTypeDetail eventTypeDetail) {
		this.eventTypeDetail = eventTypeDetail;
	}
	
	@Column(name="ISREQUIRED",nullable=false, updatable=true)
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}	
	
	@OneToMany(targetEntity = CAEventFieldMessageConfig.class, mappedBy="eventFieldConfig")
	public List<CAEventFieldMessageConfig> getMessageConfigs() {
		return messageConfigs;
	}
	public void setMessageConfigs(List<CAEventFieldMessageConfig> messageConfigs) {
		this.messageConfigs = messageConfigs;
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
}
