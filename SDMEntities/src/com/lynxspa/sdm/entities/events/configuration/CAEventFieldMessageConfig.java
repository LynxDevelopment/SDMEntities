package com.lynxspa.sdm.entities.events.configuration;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;


@Entity
@Table(name="TB_CA_EVENTCONFIGMSGFLDS",uniqueConstraints={@UniqueConstraint(columnNames={"FKEVENTFIELDCONFIG","FKFORMAT","FKMSGTYPE","FKEVENTPROVIDER"})})
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTCONFIGMSGFLDS",indexes={
		@Index(name="IDX_EVCONFMSGFLD_FKEVFILDCONF",columnNames="FKEVENTFIELDCONFIG"),
		@Index(name="IDX_EVCONFMSGFLD_FKMESSAGETYPE",columnNames={"FKFORMAT","FKMSGTYPE"}),
		@Index(name="IDX_EVCONFMSGFLD_FKEVPROVIDER",columnNames="FKEVENTPROVIDER"),
		@Index(name="IDX_EVCONFMSGFLD_DELETED",columnNames="ISDELETED")
})
public class CAEventFieldMessageConfig implements UpdatableAdapter{

	private static final long serialVersionUID = -4894988973912948031L;

	
	private long id=0l;
	private CAEventFieldConfig eventFieldConfig=null;
	private CAMessageType messageType=null;
	private CAEventProvider provider=null;
	private String normalizationScript=null;

	private int version=0;
	private UpdateAuditor auditor=null;
	

	public CAEventFieldMessageConfig(){
		this(null,null,null,null);
	}
	public CAEventFieldMessageConfig(String _user,CAEventFieldConfig _eventFieldConfig,CAMessageType _messageType){
		this(_user,_eventFieldConfig,_messageType,null);
	}
	public CAEventFieldMessageConfig(String _user,CAEventFieldConfig _eventFieldConfig,CAMessageType _messageType,CAEventProvider _provider){
		super();
		this.eventFieldConfig=_eventFieldConfig;
		this.messageType=_messageType;
		this.provider=_provider;
		this.auditor=new UpdateAuditor(_user);
	}
	
	
	@Id
	@SequenceGenerator(name="CAEVFLDMESSCONF_GEN", sequenceName="CAEVFLDMESSCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVFLDMESSCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventFieldConfig.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVNCONFFLDPRV_EVNCONFFLD")
	@JoinColumn(name="FKEVENTFIELDCONFIG", referencedColumnName="ID")
	public CAEventFieldConfig getEventFieldConfig() {
		return eventFieldConfig;
	}
	public void setEventFieldConfig(CAEventFieldConfig eventFieldConfig) {
		this.eventFieldConfig = eventFieldConfig;
	}
	
	@ManyToOne(targetEntity = CAMessageType.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVNCONFFLDMT_EVENTMESG")
	@JoinColumns({
		@JoinColumn(name="FKFORMAT", referencedColumnName="FKFORMAT"),
		@JoinColumn(name="FKMSGTYPE", referencedColumnName="CODE")
	})
	public CAMessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(CAMessageType messageType) {
		this.messageType = messageType;
	}

	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER,optional=true)
	@ForeignKey(name="FK_EVNCONFFLDPRV_EVENTPROV")
	@JoinColumn(name="FKEVENTPROVIDER", referencedColumnName="ID")
	public CAEventProvider getProvider() {
		return provider;
	}
	public void setProvider(CAEventProvider provider) {
		this.provider = provider;
	}
	
	@Column(name="NORMSCRIPT", length=2048, nullable=true, updatable=true)
	public String getNormalizationScript() {
		return normalizationScript;
	}
	public void setNormalizationScript(String normalizationScript) {
		this.normalizationScript = normalizationScript;
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
