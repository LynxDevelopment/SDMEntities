package com.lynxspa.entities.securities.assets;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.securities.assets.adapters.AssetCollectedAdapter;
import com.lynxspa.entities.securities.assets.adapters.AssetDetailAdapter;
import com.lynxspa.entities.securities.assets.adapters.AssetGroupAdapter;
import com.lynxspa.entities.securities.assets.providers.Provider;


@Entity
@DiscriminatorValue("collected")
public class AssetDynamicCollected extends AssetDynamic implements AssetCollectedAdapter{
	
	private static final long serialVersionUID = 7744720487857295450L;
	private Provider provider=null;
	private AssetGroupAdapter assetGroup=null;
	private AssetDetailAdapter assetDetail=null;
	
	public AssetDynamicCollected(){
		this(null);
	}
	public AssetDynamicCollected(String _user){
		super(_user);
	}
	
	
	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETDYNAMIC_PROVIDER")
	@JoinColumn(name="FKASSETPROVIDER",nullable=true,updatable=false)
	@Index(name="IX_FK_ASSETDYNAMIC_PROVIDER")
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider _provider) {
		this.provider = _provider;
	}
	
	@ManyToOne(targetEntity = AssetDynamicGroup.class,fetch=FetchType.EAGER,optional=true)
	@ForeignKey(name="FK_ASSETDYNAMICCOLLECTED_GROUP")
	@JoinColumn(name="FKASSETGROUP",nullable=true,updatable=true)
	@Index(name="IX_FKASSETDYNAMICGROUP")
	public AssetGroupAdapter getAssetGroup() {
		return assetGroup;
	}
	public void setAssetGroup(AssetGroupAdapter assetGroup) {
		this.assetGroup = assetGroup;
	}
	
	@ManyToOne(targetEntity = AssetDynamicDetails.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETDYNAMIC_ASSETDETAIL")
	@JoinColumn(name="FKASSETDETAIL", nullable=true, updatable=false)
	@Index(name="IX_FK_ASSETDYNAMIC_ASSETDETAIL")
	public AssetDetailAdapter getAssetDetail() {
		return assetDetail;
	}
	public void setAssetDetail(AssetDetailAdapter _assetDetail) {
		this.assetDetail = _assetDetail;
	}
}
