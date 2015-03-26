package com.lynxspa.sdm.dictionaries.formats.swift;


import com.lynxspa.sdm.installer.adapters.formats.CAFormatClusterDictAdapter;


public enum CADomainCluster implements CAFormatClusterDictAdapter {
	
	EVENTTYPE_SWIFT("EVENTTYPE","SWIFT"),
	OPERATION_SWIFT("OPERATION","SWIFT"),
	PARTICIPATIONMAN_SWIFT("PARTICIPATIONMAN","SWIFT"),
	INSTRUCTIONREQ_SWIFT("INSTRUCTIONREQ","SWIFT"),
	SECURITYCODETYPE_SWIFT("SECURITYCODETYPE","SWIFT");
	
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
