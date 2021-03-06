package com.lynxspa.sdm.dictionaries.domains;

import com.lynxspa.entities.application.domains.adapters.DomainDictAdapter;

public enum DYDomain implements DomainDictAdapter{


	ASSETTYPE("DYNAMICASSETTYPE","Type of asset",true,true,true),
	OPERATIONCODE("DYOPERATIONCODE","Operation code",true,true,true);
	
	
	private String code;
	private String name;
	private boolean deletable=true;
	private boolean updatable=true;
	private boolean cacheable=true;
	
	
	DYDomain(String _code,String _name,boolean _deletable,boolean _updatable,boolean _cacheable){
		this.code=_code;
		this.name=_name;
		this.deletable=_deletable;
		this.updatable=_updatable;
		this.cacheable=_cacheable;
	}

	
	public String getCode() {
		return code;
	}
	public String getName() {
		return this.name;
	}
	public boolean isDeletable() {
		return this.deletable;
	}
	public boolean isUpdatable() {
		return this.updatable;
	}
	public boolean isCacheable(){
		return this.cacheable;
	}

}
