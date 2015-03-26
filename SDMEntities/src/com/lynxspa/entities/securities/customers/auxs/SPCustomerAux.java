package com.lynxspa.entities.securities.customers.auxs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="AUX_TB_SP_CUSTOMER")
public class SPCustomerAux {

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String customerId=null;
	private String name=null;
	private String managerId=null;
	private int version=0;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;

	public SPCustomerAux(){
		this(null,null,null,null, false);
	}
	public SPCustomerAux(String _user){
		this(_user,null,null,null, false);
	}
	public SPCustomerAux(String _user, String _customerId, String _name, String _managerId, boolean _deleted){
		super();
		this.customerId = _customerId;
		this.name = _name;
		this.managerId = _managerId;	
		this.auditorId=_user;
		this.deleted =_deleted;
	}
	
	@Id
	@SequenceGenerator(name="SPCUSTOMERAUX_GEN", sequenceName="SPCUSTOMERAUX_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPCUSTOMERAUX_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="CUSTOMERID",length=16, nullable=false)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	@Column(name="NAME",length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="MANAGER",length=16, nullable=false)
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
}
