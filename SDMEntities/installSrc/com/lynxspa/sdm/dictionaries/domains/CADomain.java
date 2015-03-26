package com.lynxspa.sdm.dictionaries.domains;

import com.lynxspa.entities.application.domains.adapters.DomainDictAdapter;


public enum CADomain implements DomainDictAdapter{

	INSTRUCTIONREQ("INSTRUCTIONREQ","Instructions from account owner is required",true,true,true),
	PARTICIPATIONMAN("PARTICIPATIONMAN","Participation is mandatory",true,true,true),
	COUNTRY("COUNTRY","Country code in standard ISO-3166 alpha 2",true,true,true),
	CHDVCLASS("CHDVCLASS","Cash dividend class",true,true,false),
	REGIONRETENTIONS("REGIONRETENTIONS","Region retentions",true,true,false);

	
	private String code;
	private String name;
	private boolean deletable=true;
	private boolean updatable=true;
	private boolean cacheable=true;

	
	CADomain(String _code,String _name,boolean _deletable,boolean _updatable,boolean _cacheable){
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
