package com.lynxspa.sdm.dictionaries.formats.bloomberg;


import com.lynxspa.sdm.installer.adapters.formats.CAFormatClusterDictAdapter;


public enum CADomainCluster implements CAFormatClusterDictAdapter {
	
	EVENTTYPE_BLOOMBERG("EVENTTYPE","BLOOMBERG"),
	OPERATION_BLOOMBERG("OPERATION","BLOOMBERG"),
	SECURITYCODETYPE_BLOOMBERG("SECURITYCODETYPE","BLOOMBERG"),
	CHDVCLASS_BLOOMBERG("CHDVCLASS","BLOOMBERG"),
	REGIONRETENTIONS_RETENCION("REGIONRETENTIONS","RETENCION"),
	COUNTRY_ISO3166A3("COUNTRY","ISO3166A3");
		
	
	private String domain=null;
	private String cluster=null;

	
	CADomainCluster(String _domain,String _cluster){
		this.domain=_domain;
		this.cluster=_cluster;
	}
	
	public String getDomain() {
		return this.domain;
	}

	public String getCluster() {
		return this.cluster;
	}

	public String getClusterName() {
		return this.cluster;
	}
}
