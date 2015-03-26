package com.lynxspa.sdm.dictionaries;

import com.lynxspa.entities.application.domains.adapters.DomainDictAdapter;


public enum CABasicDomains implements DomainDictAdapter{

	EVENTTYPE("EVENTTYPE","Event type",false,false,true),
	OPERATION("OPERATION","Operation",false,false,true),
	SECURITYCODETYPE("SECURITYCODETYPE","Type of security identifier",true,true,true);

	
	private String code;
	private String name;
	private boolean deletable=true;
	private boolean updatable=true;
	private boolean cacheable=true;

	
	CABasicDomains(String _code,String _name,boolean _deletable,boolean _updatable,boolean _cacheable){
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
