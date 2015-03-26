package com.lynxspa.entities.securities.assets.adapters;

import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.assets.AssetType;

public interface AssetAdapter {
	
	public long getId();
	public void setId(long id);

	public int getVersion();
	public void setVersion(int version);

	public AssetType getAssetType();
	public void setAssetType(AssetType assetType);

	public OperationStatus getOperationStatus();
	public void setOperationStatus(OperationStatus operationStatus);
	//public VersionAuditor getAuditor();
	//public void setAuditor(VersionAuditor auditor);

}
