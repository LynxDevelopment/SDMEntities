package com.lynxspa.sdm.entities.statics.configuration;

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
import com.lynxspa.entities.securities.assets.AssetTypeDetail;


@Entity
@Table(name="TB_SDM_STCONFIGFIELDS",uniqueConstraints={@UniqueConstraint(columnNames={"FKSTATICCONFIG","FKASSETTYPEDETAIL"})})
@org.hibernate.annotations.Table(appliesTo="TB_SDM_STCONFIGFIELDS",indexes={
		@Index(name="IDX_STCONFFLD_FKSTCONF",columnNames="FKSTATICCONFIG"),
		@Index(name="IDX_STCONFFLD_FKASSTYPEDET",columnNames="FKASSETTYPEDETAIL"),
		@Index(name="IDX_STCONFFLD_DELETED",columnNames="ISDELETED")
})
public class StaticFieldConfig implements UpdatableAdapter{

	private static final long serialVersionUID = -7560051405488639357L;
	private long id=0l;
	private StaticConfig staticConfig=null;
	private AssetTypeDetail assetTypeDetail=null;
	private boolean required=false;
	
	private int version=0;
	private UpdateAuditor auditor=null;
		
	private List<StaticFieldMessageConfig> messageConfigs=null;
	

	public StaticFieldConfig(){
		this(null,null,null);
	}
	public StaticFieldConfig(String _user,StaticConfig _staticConfig,AssetTypeDetail _assetTypeDetail){
		super();
		this.auditor=new UpdateAuditor(_user);
		this.staticConfig=_staticConfig;
		this.assetTypeDetail=_assetTypeDetail;
	}
	
	
	@Id
	@SequenceGenerator(name="SEQ_CONFIGFIELDS_GEN", sequenceName="SEQ_CONFIGFIELDS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CONFIGFIELDS_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = StaticConfig.class,fetch=FetchType.EAGER,optional=true)
	@ForeignKey(name="FK_ASSCONFFIELD_STATICCONFIG")
	@JoinColumn(name="FKSTATICCONFIG",referencedColumnName="ID")
	public StaticConfig getStaticConfig() {
		return staticConfig;
	}
	public void setStaticConfig(StaticConfig staticConfig) {
		this.staticConfig = staticConfig;
	}
	
	@ManyToOne(targetEntity = AssetTypeDetail.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_ASSCONFFIELD_ASSTYPEDET")
	@JoinColumn(name="FKASSETTYPEDETAIL")
	public AssetTypeDetail getAssetTypeDetail() {
		return assetTypeDetail;
	}
	public void setAssetTypeDetail(AssetTypeDetail assetTypeDetail) {
		this.assetTypeDetail = assetTypeDetail;
	}
	
	@Column(name="ISREQUIRED",nullable=false, updatable=true)
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}	
	
	@OneToMany(targetEntity = StaticFieldMessageConfig.class, mappedBy="staticFieldConfig")
	public List<StaticFieldMessageConfig> getMessageConfigs() {
		return messageConfigs;
	}
	public void setMessageConfigs(List<StaticFieldMessageConfig> messageConfigs) {
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
