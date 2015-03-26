package com.lynxspa.sdm.entities.statics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.entities.application.flow.operations.OperableAdapter;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.markets.SPMarket;

@Entity
@Table(name="TB_SDM_SECEVENTS") 
public class StaticEvent implements VersionableAdapter,OperableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2511721828579455766L;
	private long id=0l;
	private int version=0;
	private VersionAuditor auditor=null;
	private OperationStatus operationStatus=null;
	private AssetType assetType=null;
	private StaticEventDetails secEventDetail=null;
	private SPMarket market=null;
	private boolean complete=false;
	
	@Id
	@SequenceGenerator(name="SECEVENT_GEN", sequenceName="SECEVENT_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SECEVENT_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public VersionAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETTYPE_SECURITY")
	@JoinColumn(name="FKASSETTYPE", nullable=true)
	public AssetType getAssetType() {
		return assetType;
	}
	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="FKSECEVENTDETAIL")
	public StaticEventDetails getSecEventDetail() {
		return secEventDetail;
	}
	public void setSecEventDetail(StaticEventDetails secEventDetail) {
		this.secEventDetail = secEventDetail;
	}
	
	@ManyToOne(targetEntity = SPMarket.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECEVENT_MARKET")
	@JoinColumn(name="FKMARKET", nullable=true)
	public SPMarket getMarket() {
		return market;
	}
	public void setMarket(SPMarket market) {
		this.market = market;
	}
	
	@Column(name="ISCOMPLETE",nullable=true)
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	

	
	
}
