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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.providers.Provider;


@Entity
@Table(name="TB_SDM_STCONFIGS",uniqueConstraints={@UniqueConstraint(columnNames={"FKASSETTYPE"})})
@org.hibernate.annotations.Table(appliesTo="TB_SDM_STCONFIGS",indexes={
		@Index(name="IDX_STCONFIG_DELETED",columnNames="ISDELETED")
})
public class StaticConfig implements UpdatableAdapter{

	private static final long serialVersionUID = 6670188868240424149L;
	private long id=0l;
	private AssetType assetType=null;
	private Provider preferentProvider=null;
	private Provider secondPreferentProvider=null;
	private Provider thirdPreferentProvider=null;
	private Provider fourPreferentProvider=null;
	private Provider fivePreferentProvider=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	private List<StaticMasterRecordConfig> masterRecordConfigs=null;
	private List<StaticFieldConfig> staticFieldConfigs=null;


	public StaticConfig(){
		this(null,null);
	}
	public StaticConfig(String _user,AssetType _assetType){
		super();
		this.assetType=_assetType;
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="SEQ_STCONF_GEN", sequenceName="SEQ_STCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_STCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_STCONFIG_ASSETTYPE")
	@JoinColumn(name="FKASSETTYPE", referencedColumnName="ID")
	public AssetType getAssetType() {
		return assetType;
	}
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=false)
	@ForeignKey(name="FK_STCONFIG_PROVIDER1")
	@JoinColumn(name="FKPROVIDER1", nullable=false)
	@Index(name="IX_STCONFIG_PROVIDER1")
	public Provider getPreferentProvider() {
		return preferentProvider;
	}
	public void setPreferentProvider(Provider preferentProvider) {
		this.preferentProvider = preferentProvider;
	}

	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_STTCONFIG_PROVIDER2")
	@JoinColumn(name="FKPROVIDER2", nullable=true)
	@Index(name="IX_STCONFIG_PROVIDER2")
	public Provider getSecondPreferentProvider() {
		return secondPreferentProvider;
	}
	public void setSecondPreferentProvider(Provider secondPreferentProvider) {
		this.secondPreferentProvider = secondPreferentProvider;
	}
	
	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_STTCONFIG_PROVIDER3")
	@JoinColumn(name="FKPROVIDER3", nullable=true)
	@Index(name="IX_STCONFIG_PROVIDER3")
	public Provider getThirdPreferentProvider() {
		return thirdPreferentProvider;
	}
	public void setThirdPreferentProvider(Provider thirdPreferentProvider) {
		this.thirdPreferentProvider = thirdPreferentProvider;
	}
	
	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_STTCONFIG_PROVIDER4")
	@JoinColumn(name="FKPROVIDER4", nullable=true)
	@Index(name="IX_STCONFIG_PROVIDER4")
	public Provider getFourPreferentProvider() {
		return fourPreferentProvider;
	}
	public void setFourPreferentProvider(Provider fourPreferentProvider) {
		this.fourPreferentProvider = fourPreferentProvider;
	}
	
	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_STTCONFIG_PROVIDER5")
	@JoinColumn(name="FKPROVIDER5", nullable=true)
	@Index(name="IX_STCONFIG_PROVIDER5")
	public Provider getFivePreferentProvider() {
		return fivePreferentProvider;
	}
	public void setFivePreferentProvider(Provider fivePreferentProvider) {
		this.fivePreferentProvider = fivePreferentProvider;
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
	
	@OneToMany(targetEntity = StaticMasterRecordConfig.class, mappedBy="staticConfig",fetch=FetchType.LAZY)
	@OrderBy("ruleOrder")
	public List<StaticMasterRecordConfig> getMasterRecordConfigs() {
		return masterRecordConfigs;
	}
	public void setMasterRecordConfigs(List<StaticMasterRecordConfig> masterRecordConfigs) {
		this.masterRecordConfigs = masterRecordConfigs;
	}
	
	@OneToMany(targetEntity = StaticFieldConfig.class, mappedBy="staticConfig",fetch=FetchType.LAZY)
	public List<StaticFieldConfig> getStaticFieldConfigs() {
		return staticFieldConfigs;
	}
	public void setStaticFieldConfigs(List<StaticFieldConfig> staticFieldConfigs) {
		this.staticFieldConfigs = staticFieldConfigs;
	}
}
