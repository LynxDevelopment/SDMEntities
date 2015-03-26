package com.lynxspa.entities.jobs.beans;

// Generated 31-mar-2014 12:33:54 by Hibernate Tools 3.2.0.b9

import com.lynxspa.entities.UpdateAuditor;

/**
 * SDMErrorValue generated by hbm2java
 */
public class SDMErrorValueBean {

	private long id;
	private SDMValueBean value;
	private int version;
	private String error;
	private UpdateAuditor auditor;

	public SDMErrorValueBean() {
	}

	public SDMErrorValueBean(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	public SDMErrorValueBean(SDMValueBean value, String error,
			UpdateAuditor auditor) {
		this.value = value;
		this.error = error;
		this.auditor = auditor;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SDMValueBean getValue() {
		return this.value;
	}

	public void setValue(SDMValueBean value) {
		this.value = value;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public UpdateAuditor getAuditor() {
		return this.auditor;
	}

	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

}
