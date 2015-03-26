package com.lynxspa.sdm.entities.statics.configuration;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.jobs.SDMEnterprise;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.providers.Provider;


@Entity
@Table(name="TB_SDM_STCONFIGMSGFLDS",uniqueConstraints={@UniqueConstraint(columnNames={"FKSTFIELDCONFIG","FKPROVIDER","FKASSETTYPE","FKENTERPRISE"})})
@org.hibernate.annotations.Table(appliesTo="TB_SDM_STCONFIGMSGFLDS",indexes={
		@Index(name="IDX_STCONFMSGFLD_FKSTFILDCONF",columnNames="FKSTFIELDCONFIG"),
		@Index(name="IDX_STCONFMSGFLD_FKSTPROVIDER",columnNames="FKPROVIDER"),
		@Index(name="IDX_STCONFMSGFLD_FKASSTYPE",columnNames="FKASSETTYPE"),
		@Index(name="IDX_STCONFMSGFLD_DELETED",columnNames="ISDELETED")
})
public class StaticFieldMessageConfig implements UpdatableAdapter{

	private static final long serialVersionUID = -7374149649219218222L;
	private long id=0l;
	private StaticFieldConfig staticFieldConfig=null;
	private AssetType assetType=null;
	private Provider provider=null;
	private String normalizationScript=null;
	private SDMEnterprise enterprise=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	

	public StaticFieldMessageConfig(){
		this(null,null,null,null);
	}
	public StaticFieldMessageConfig(String _user,StaticFieldConfig _staticFieldConfig,AssetType _assetType){
		this(_user,_staticFieldConfig,_assetType,null);
	}
	public StaticFieldMessageConfig(String _user,StaticFieldConfig _staticFieldConfig,AssetType _assetType,Provider _provider){
		super();
		this.staticFieldConfig=_staticFieldConfig;
		this.assetType=_assetType;
		this.provider=_provider;
		this.auditor=new UpdateAuditor(_user);
	}
	
	
	@Id
	@SequenceGenerator(name="SEQ_STCONFIGMSGFLDS_GEN", sequenceName="SEQ_STCONFIGMSGFLDS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_STCONFIGMSGFLDS_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = StaticFieldConfig.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_STCONFFLDPRV_STCONFFLD")
	@JoinColumn(name="FKSTFIELDCONFIG", referencedColumnName="ID")
	public StaticFieldConfig getStaticFieldConfig() {
		return staticFieldConfig;
	}
	public void setStaticFieldConfig(StaticFieldConfig staticFieldConfig) {
		this.staticFieldConfig = staticFieldConfig;
	}
	
	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_STCONFFLDMT_ASSETTYPE")
	@JoinColumn(name="FKASSETTYPE", referencedColumnName="ID")
	public AssetType getAssetType() {
		return assetType;
	}
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER, optional=true)
	@ForeignKey(name="FK_STCONFFLDPRV_PROV")
	@JoinColumn(name="FKPROVIDER", referencedColumnName="ID")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
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
	
	@ManyToOne(targetEntity = SDMEnterprise.class,fetch=FetchType.EAGER, optional=false)
	@ForeignKey(name="FK_STCONFFLDMSG_ENT")
	@JoinColumn(name="FKENTERPRISE", referencedColumnName="ID")
	public SDMEnterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(SDMEnterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
}
