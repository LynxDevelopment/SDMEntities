package com.lynxspa.sdm.importers.securities.beans;

import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.entities.securities.details.SPSecurityDetail;
import com.lynxspa.entities.securities.financialassets.SPSecurityFinancialAssets;

public class SecurityBean {

	public enum ActionsToDo{
		INSERT_OR_UPDATE,
		UPDATE,
		DELETE;
	}
	
	private SPSecurity security=null;
	private String originName=null;
	private int originPosition=0;
	private String format=null;
	private ActionsToDo action=null;
	private SPSecurityDetail secDetails=null;
	private SPSecurityFinancialAssets financialAsset;
	
	public SPSecurity getSecurity() {
		return security;
	}
	public void setSecurity(SPSecurity security) {
		this.security = security;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String _originName) {
		this.originName = _originName;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getOriginPosition() {
		return originPosition;
	}
	public void setOriginPosition(int _originPosition) {
		this.originPosition = _originPosition;
	}
	public ActionsToDo getAction() {
		return action;
	}
	public void setAction(ActionsToDo action) {
		this.action = action;
	}
	public SPSecurityDetail getSecDetails() {
		return secDetails;
	}
	public void setSecDetails(SPSecurityDetail secDetails) {
		this.secDetails = secDetails;
	}
	public SPSecurityFinancialAssets getFinancialAsset() {
		return financialAsset;
	}
	public void setFinancialAsset(SPSecurityFinancialAssets financialAsset) {
		this.financialAsset = financialAsset;
	}
	
}
