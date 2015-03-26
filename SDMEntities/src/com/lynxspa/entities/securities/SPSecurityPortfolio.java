package com.lynxspa.entities.securities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.entities.securities.customers.SPCustomer;
import com.lynxspa.entities.securities.providers.SPProviderAccount;


@Entity
@Table(name="TB_SP_SECURITYPORTFOLIO")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITYPORTFOLIO",indexes={
		@Index(name="IDX_SECPORT_VERSION",columnNames="VERSION"),
		@Index(name="IDX_SECPORT_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_SECPORT_FKPORTFOLIO",columnNames="FKCUSTOMER"),
		@Index(name="IDX_SECPORT_FKSECURITY",columnNames="FKSECURITY"),
		@Index(name="IDX_SECPORT_EMISSIONDATE",columnNames="EMISSIONDATE")
})
public class SPSecurityPortfolio implements VersionableAdapter {
	
	private static final long serialVersionUID = -5186532129450338585L;

	
	private long id=0l;
	private SPCustomer customer=null;
	private SPVirtualSecurity security=null;
	private long customerAmount=0l;
	private long custodianAmount=0l;
	private int version=0;
	private VersionAuditor auditor=null;
	private Date emissionDate=null;
	private SPProviderAccount custodianAccount=null;
	
	public SPSecurityPortfolio() {
		this(null,null,null,0l,0l,Calendar.getInstance().getTime());
	}
	public SPSecurityPortfolio(String _user,SPCustomer _customer,SPVirtualSecurity _security,Date _emissionDate) {
		this(_user,_customer,_security,0l,0l,_emissionDate);
	}
	public SPSecurityPortfolio(String _user,SPCustomer _customer,SPVirtualSecurity _security,long _customerAmount,long _custodianAmount,Date _emissionDate) {
		super();
		this.security=_security;
		this.customer=_customer;
		this.customerAmount=_customerAmount;
		this.custodianAmount=_custodianAmount;
		this.auditor=new VersionAuditor(_user);
		this.setEmissionDate(_emissionDate);
	}

	@Id
	@SequenceGenerator(name="SPSECPORT_GEN", sequenceName="SPSECPORT_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPSECPORT_GEN")
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = SPCustomer.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECPORT_CUSTOMER",inverseName="ID")
	@JoinColumn(name="FKCUSTOMER", nullable=true, updatable=false)
	public SPCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(SPCustomer _customer) {
		this.customer = _customer;
	}

	/*@ManyToOne(targetEntity = SPPortfolio.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECPORT_PORTFOLIO",inverseName="ID")
	@JoinColumn(name="FKPORTFOLIO", nullable=false, updatable=false)
	public SPPortfolio getPortfolio() {
		return portfolio;
	}
	protected void setPortfolio(SPPortfolio _portfolio) {
		this.portfolio=_portfolio;
	}*/
	
	
	
	@ManyToOne(targetEntity = SPVirtualSecurity.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECPORT_SECURITY",inverseName="ID")
	@JoinColumn(name="FKSECURITY", nullable=false, updatable=false)
	public SPVirtualSecurity getSecurity() {
		return security;
	}
	protected void setSecurity(SPSecurity _security) {
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
		
		if(_emissionDate!=null){
			this.emissionDate=new Date(_emissionDate.getTime());
		}else{
			this.emissionDate=null;
		}
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
	
	@ManyToOne(targetEntity = SPProviderAccount.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECPORT_PROVACCOUNTS",inverseName="ID")
	@JoinColumn(name="FKPROVIDERACCOUNT", nullable=true, updatable=false)
	public SPProviderAccount getCustodianAccount() {
		return custodianAccount;
	}
	public void setCustodianAccount(SPProviderAccount custodianAccount) {
		this.custodianAccount = custodianAccount;
	}
	
	
}
