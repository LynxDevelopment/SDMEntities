package com.lynxspa.entities.securities.providers;

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
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;

@Entity
@Table(name="TB_SP_CUSTODIAN_ACCOUNTS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_CUSTODIAN_ACCOUNTS",indexes={
		@Index(name="IDX_CUSTODIAN_DELETED",columnNames="ISDELETED")
})
public class SPProviderAccount implements UpdatableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6321880973587492688L;
	
	private long id=0l;
	private String name=null;
	private String accountNumber=null;
	private boolean ownAccount=false;
	private int version=0;
	private UpdateAuditor auditor=null;
	private CAEventProvider eventProvider= null;

	public SPProviderAccount (){
		this(null,null,null,true);
	}

	public SPProviderAccount (String _user,String _name,String _accountNumber,boolean _ownAccount){
		super();
		this.name=_name;
		accountNumber = _accountNumber;
		ownAccount = _ownAccount;
		this.auditor=new UpdateAuditor(_user);
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
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	@Id
	@SequenceGenerator(name="SPPROVIDERACCOUNT_GEN", sequenceName="SPPROVIDERACCOUNT_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPPROVIDERACCOUNT_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	@ManyToOne(targetEntity = CAEventProvider.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_PROVIDER")
	@JoinColumn(name="FKPROVIDER")
	public CAEventProvider getEventProvider() {
		return eventProvider;
	}

	public void setEventProvider(CAEventProvider eventProvider) {
		this.eventProvider = eventProvider;
	}

}
