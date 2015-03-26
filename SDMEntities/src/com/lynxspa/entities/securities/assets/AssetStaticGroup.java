package com.lynxspa.entities.securities.assets;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Where;

import com.lynxspa.entities.securities.assets.adapters.AssetCollectedAdapter;
import com.lynxspa.entities.securities.assets.adapters.AssetGroupAdapter;

@Entity
@DiscriminatorValue("group")
public class AssetStaticGroup extends AssetStatic implements AssetGroupAdapter{

	private static final long serialVersionUID = 7082406728984397031L;
	private AssetCollectedAdapter masterAsset=null;
	private List<? extends AssetCollectedAdapter> groupedAssets=null;
	private Date entityDeadLine=null;
	
	public AssetStaticGroup(){
		this(null,null);
	}
	public AssetStaticGroup(String _user){
		this(_user,null);
	}
	public AssetStaticGroup(String _user,AssetStaticCollected _asset){
		super(_user);
		if(_asset!=null){
			setAssetType(_asset.getAssetType());

		}
	}

	@ManyToOne(targetEntity = AssetStaticCollected.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_GROUP_ASSETSTATICCOLLECTED")
	@JoinColumn(name="FKMASTERASSET")
	@Index(name="IX_FKMASTERASSETSTATIC")
	public AssetCollectedAdapter getMasterAsset() {
		return masterAsset;
	}
	public void setMasterAsset(AssetCollectedAdapter masterSource) {
		this.masterAsset = masterSource;
	}

	@OneToMany(targetEntity = AssetStaticCollected.class, mappedBy="assetGroup",fetch=FetchType.LAZY)
	@Where(clause="REFID=0")
	public List<? extends AssetCollectedAdapter> getGroupedAssets() {
		return groupedAssets;
	}
	public void setGroupedAssets(List<? extends AssetCollectedAdapter> groupedAssets) {
		this.groupedAssets = groupedAssets;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENTITYOPERATIONALDATE", nullable=true)
	public Date getEntityDeadLine() {
		return entityDeadLine;
	}
	public void setEntityDeadLine(Date entityDeadLine) {
		this.entityDeadLine = entityDeadLine;
	}
}
