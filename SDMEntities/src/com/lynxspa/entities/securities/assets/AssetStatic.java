package com.lynxspa.entities.securities.assets;

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
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.entities.application.flow.operations.OperableAdapter;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.assets.adapters.AssetAdapter;

@Entity
@Table(name="TB_SDM_ASSETSSTATIC") 
public abstract class AssetStatic implements VersionableAdapter,OperableAdapter,AssetAdapter {

	private static final long serialVersionUID = 5079119576348696215L;
	private long id=0l;
	private AssetType assetType=null;
	private int version=0;
	private VersionAuditor auditor=null;
	private OperationStatus operationStatus=null;
	
	public AssetStatic(){
		this(null);
	}
	public AssetStatic(String _user){
		super();
		this.auditor=new VersionAuditor(_user);
		this.operationStatus=new OperationStatus();
	}
		
	@Id
	@SequenceGenerator(name="SEQ_ASSETSTATIC_GEN", sequenceName="SEQ_ASSETSTATIC_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ASSETSTATIC_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETSTATIC_ASSETTYPE")
	@JoinColumn(name="FKASSETTYPE", nullable=false, updatable=false)
	@Index(name="IX_ASSETSTATIC_FKASSETTYPE")
	public AssetType getAssetType() {
		return assetType;
	}
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
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
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
