package com.lynxspa.entities.securities.providers.auxs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="AUX_TB_SP_CUSTODIAN_ACCOUNTS")
public class SPProviderAccountAux{

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String name=null;
	private String accountNumber=null;
	private boolean ownAccount=false;
	private int version=0;
	private String eventProviderId= null;
	private String customerId=null;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;

	public SPProviderAccountAux(){
		this(null,0l,null,null);
	}
	
	public SPProviderAccountAux(String _customer, long _customerAmount, Date _emissionDate, String _providerAccount){
		super();
		
		
		
	}
	
	@Id
	@SequenceGenerator(name="SPCUSTACCOUNT_GEN", sequenceName="SPCUSTACCOUNT_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPCUSTACCOUNT_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;		
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

	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="ACCOUNTNUMBER", length=64, nullable=false)
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name="OWNACCOUNT", nullable=false)
	public boolean isOwnAccount() {
		return ownAccount;
	}

	public void setOwnAccount(boolean ownAccount) {
		this.ownAccount = ownAccount;
	}

	@Column(name="PROVIDERID", length=64, nullable=false)
	public String getEventProviderId() {
		return eventProviderId;
	}

	public void setEventProviderId(String eventProviderId) {
		this.eventProviderId = eventProviderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
