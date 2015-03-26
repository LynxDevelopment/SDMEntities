package com.lynxspa.sdm.dictionaries.formats.inversis;


import com.lynxspa.sdm.installer.adapters.formats.CAFormatClusterDictAdapter;


public enum CADomainCluster implements CAFormatClusterDictAdapter {
	
	EVENTTYPE_INVERSIS("EVENTTYPE","INVERSIS"),
	OPERATION_INVERSIS("OPERATION","INVERSIS"),
	CHDVCLASS_INVERSIS("CHDVCLASS","INVERSIS");
		
	
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
