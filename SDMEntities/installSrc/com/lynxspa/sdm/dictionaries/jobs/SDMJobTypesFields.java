package com.lynxspa.sdm.dictionaries.jobs;



public enum SDMJobTypesFields {

	ASSTYP_EQ("EQ","AssetTypeId"),
	ASSTYP_FD("FD","AssetTypeId"),
	ASSTYP_FI("FI","AssetTypeId"),
	ASSTYP_ET("ET","AssetTypeId"),
	PROVID_BB("BLOOMBERGSTATIC","ProviderId");

	private String fieldName;
	private String value;
	
	SDMJobTypesFields(String _fieldName,String _value){
	
		this.fieldName=_fieldName;
		this.value=_value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getValue() {
		return value;
	}
	
}
