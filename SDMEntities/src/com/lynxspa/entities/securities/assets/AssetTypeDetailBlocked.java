package com.lynxspa.entities.securities.assets;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.securities.assets.providers.Provider;

@Entity
@Table(name="TB_SDM_ASSETTYPE_DETAILS_BLK")
public class AssetTypeDetailBlocked implements UpdatableAdapter {
	
	private static final long serialVersionUID = -4437651333655528550L;
	private Long id=null;
	private AssetTypeDetail assetTypeDetail=null;
	private Provider provider=null;
	private Date beginBlockedDate=null;
	private Date endBlockedDate=null;
	private int version=0;
	private UpdateAuditor auditor=null;

	
	public AssetTypeDetailBlocked(){
		super();
	}

	@Id
	@SequenceGenerator(name="SEQ_ASSETTYPE_DETAIL_BLK_GEN", sequenceName="SEQ_ASSETTYPE_DETAIL_BLK_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ASSETTYPE_DETAIL_BLK_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = AssetTypeDetail.class)
	@ForeignKey(name="FK_DETAILBLK_ASSETDETAIL")
	@JoinColumn(name="FKASSETTYPEDETAIL", nullable=false, updatable=false)
	@Index(name="IX_DETAILBLK_ASSETDETAIL")
	public AssetTypeDetail getAssetTypeDetail() {
		return assetTypeDetail;
	}
	
	public void setAssetTypeDetail(AssetTypeDetail assetTypeDetail) {
		this.assetTypeDetail = assetTypeDetail;
	}

	@ManyToOne(targetEntity = Provider.class)
	@ForeignKey(name="FK_DETAILBLK_PROVIDER")
	@JoinColumn(name="FKPROVIDER", nullable=false, updatable=false)
	@Index(name="IX_DETAILBLK_PROVIDER")
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BEGINBLOCKEDDATE", nullable=false)
	public Date getBeginBlockedDate() {
		return beginBlockedDate;
	}
	
	public void setBeginBlockedDate(Date beginBlockedDate) {
		this.beginBlockedDate = beginBlockedDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ENDBLOCKEDDATE", nullable=false)
	
	public Date getEndBlockedDate() {
		return endBlockedDate;
	}
	
	public void setEndBlockedDate(Date endBlockedDate) {
		this.endBlockedDate = endBlockedDate;
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
