package com.lynxspa.entities.securities.auxs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="AUX_TB_SP_SECURITYPORTFOLIO")
public class SPSecurityPortfolioAux{

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String customer=null;
	private long customerAmount=0l;
	private Date emissionDate=null;
	private int version=0;
	private String providerAccount=null;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;
	private String cartera=null;
	private String security=null;
	
	public SPSecurityPortfolioAux(){
		this(null,0l,null,null);
	}
	
	public SPSecurityPortfolioAux(String _customer, long _customerAmount, Date _emissionDate, String _providerAccount){
		super();
		
		this.customer = _customer;	
		this.customerAmount = _customerAmount;
		this.customerAmount=_customerAmount;
		this.emissionDate=_emissionDate;
		this.providerAccount=_providerAccount;
		
	}
	
	@Id
	@SequenceGenerator(name="SPSECPORAUX_GEN", sequenceName="SPSECPORAUX_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPSECPORAUX_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="CUSTOMER",length=64, nullable=false)		
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Column(name="CUSTOMERAMOUNT", nullable=false)	
	public long getCustomerAmount() {
		return customerAmount;
	}
	public void setCustomerAmount(long customerAmount) {
		this.customerAmount = customerAmount;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;		
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EMISSIONDATE", nullable=false)
	public Date getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	
	@Column(name="PROVIDERACCOUNT",length=64, nullable=false)
	public String getProviderAccount() {
		return providerAccount;
	}
	public void setProviderAccount(String providerAccount) {
		this.providerAccount = providerAccount;
	}
	
	@Column(name="AUDITORID",length=128, nullable=false)
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	
	@Column(name="ISDELETED", nullable=false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Column(name="STATE",length=1, nullable=true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name="PORTFOLIO",length=64, nullable=false)
	public String getCartera() {
		return cartera;
	}
	public void setCartera(String cartera) {
		this.cartera = cartera;
	}

	@Column(name="SECURITY",length=64, nullable=false)
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}	
	
}
