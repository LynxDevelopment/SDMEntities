package com.lynxspa.entities.securities.assets.messages;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.providers.Provider;


@Entity
@Table(name="TB_SDM_MESSAGETYPES")
public class AssetMessageType implements InsertableAdapter {

	private static final long serialVersionUID = 7459870748328770896L;
	
	private AssetMessageTypeId id=null;
	private String name=null;
	private InsertAuditor auditor=null;
	
	List<AssetMessageFieldConfig> messageFieldConfigs=new ArrayList<AssetMessageFieldConfig>();	
	
	public AssetMessageType(){
		this(null,null,null,null);
	}
	public AssetMessageType(String _user,Provider _provider,AssetType _assetType){
		this(_user,_provider,_assetType,null);
	}
	public AssetMessageType(String _user,Provider _provider,AssetType _assetType,String _name){
		super();
		this.id=new AssetMessageTypeId(_provider,_assetType);
		this.name=_name;
		this.auditor=new InsertAuditor(_user);
	}	
	
	@EmbeddedId
	public AssetMessageTypeId getId() {
		return id;
	}
	public void setId(AssetMessageTypeId id) {
		this.id = id;
	}

	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}

	@OneToMany(targetEntity = AssetMessageFieldConfig.class, mappedBy="id.type",fetch=FetchType.LAZY)
	public List<AssetMessageFieldConfig> getMessageFieldConfigs() {
		return messageFieldConfigs;
	}
	public void setMessageFieldConfigs(List<AssetMessageFieldConfig> messageFieldConfigs) {
		this.messageFieldConfigs = messageFieldConfigs;
	}
}
