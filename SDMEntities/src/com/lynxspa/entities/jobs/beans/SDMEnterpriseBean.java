package com.lynxspa.entities.jobs.beans;

// Generated 31-mar-2014 12:33:54 by Hibernate Tools 3.2.0.b9

import com.lynxspa.entities.UpdateAuditor;

/**
 * SDMEnterprise generated by hbm2java
 */
public class SDMEnterpriseBean {

	private long id;
	private String address;
	private String name;
	private String description;
	private int version;
	private String bic;
	private String tlf;
	private UpdateAuditor auditor;
	private SDMEnterpriseBean parentEnterprise;

	public SDMEnterpriseBean() {
	}

	public SDMEnterpriseBean(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	public SDMEnterpriseBean(String address, String name, String description,
			String bic, String tlf, UpdateAuditor auditor,
			SDMEnterpriseBean parentEnterprise) {
		this.address = address;
		this.name = name;
		this.description = description;
		this.bic = bic;
		this.tlf = tlf;
		this.auditor = auditor;
		this.parentEnterprise = parentEnterprise;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getBic() {
		return this.bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getTlf() {
		return this.tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public UpdateAuditor getAuditor() {
		return this.auditor;
	}

	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	public SDMEnterpriseBean getParentEnterprise() {
		return this.parentEnterprise;
	}

	public void setParentEnterprise(SDMEnterpriseBean parentEnterprise) {
		this.parentEnterprise = parentEnterprise;
	}

}