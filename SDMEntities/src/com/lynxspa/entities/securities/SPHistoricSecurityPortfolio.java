package com.lynxspa.entities.securities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.entities.securities.customers.SPCustomer;


@Entity
@Table(name="HS_SP_SECURITYPORTFOLIO")
@org.hibernate.annotations.Table(appliesTo="HS_SP_SECURITYPORTFOLIO",indexes={
		@Index(name="IDX_HSSECPORT_DELETED",columnNames="ISDELETED")
})
public class SPHistoricSecurityPortfolio implements VersionableAdapter {
	
	private static final long serialVersionUID = -3304761594816493249L;

	
	private long id=0l;
	private SPCustomer customer=null;
	private SPVirtualSecurity  security=null;
	private long customerAmount=0l;
	private long custodianAmount=0l;
	private int version=0;
	private VersionAuditor auditor=null;
	private Date emissionDate=null;

	
	public SPHistoricSecurityPortfolio() {
		this(null,null,null,0l,0l,Calendar.getInstance().getTime());
	}
	public SPHistoricSecurityPortfolio(String _user,SPCustomer _customer,SPSecurity _security,Date _emissionDate) {
		this(_user,_customer,_security,0l,0l,_emissionDate);
	}
	public SPHistoricSecurityPortfolio(String _user,SPCustomer _customer,SPSecurity _security,long _customerAmount,long _custodianAmount,Date _emissionDate) {
		super();
		this.security=_security;
		this.customer=_customer;
		this.customerAmount=_customerAmount;
		this.custodianAmount=_custodianAmount;
		this.auditor=new VersionAuditor(_user);
		this.emissionDate = _emissionDate;
	}

	@Id
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = SPCustomer.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HS_SECPORT_CUSTOMER",inverseName="ID")
	@JoinColumn(name="FKCUSTOMER", nullable=false, updatable=false)
	public SPCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(SPCustomer _customer) {
		this.customer = _customer;
	}
	
	@ManyToOne(targetEntity = SPVirtualSecurity.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HS_SECPORT_SECURITY",inverseName="ID")
	@JoinColumn(name="FKSECURITY", nullable=false, updatable=false)
	public SPVirtualSecurity  getSecurity() {
		return security;
	}
	protected void setSecurity(SPVirtualSecurity  _security) {
		this.security=_security;
	}
	
	@Column(name="CUSTOMERAMOUNT", nullable=true)
	public long getCustomerAmount() {
		return customerAmount;
	}
	public void setCustomerAmount(long customerAmount) {
		this.customerAmount = customerAmount;
	}

	@Column(name="CUSTODIANAMOUNT", nullable=true)
	public long getCustodianAmount() {
		return custodianAmount;
	}
	public void setCustodianAmount(long custodianAmount) {
		this.custodianAmount = custodianAmount;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EMISSIONDATE", nullable=false)
	public Date getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(Date _emissionDate) {
		this.emissionDate = _emissionDate;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@Embedded
	public VersionAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
