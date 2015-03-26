package com.lynxspa.entities.securities.managers.auxs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="AUX_TB_SP_MANAGER")
public class SPManagerAux {

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String customerId=null;
	private String name=null;
	private String email=null;
	
	private int version=0;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;


	public SPManagerAux(){
		this(null,null,null);
	}
	public SPManagerAux(String _customerId, String _name, String _auditorId){
		this(_customerId,_name,null,_auditorId,false,null);
	}
	public SPManagerAux(String _customerId, String _name, String _email, String _auditorId, boolean _deleted, String _state){
		super();
		this.customerId = _customerId;
		this.name = _name;
		this.email = _email;
		this.auditorId=_auditorId;
		this.deleted = _deleted;
		this.state=_state;
	}
	
	@Id
	@SequenceGenerator(name="SPEXCPORMAN_GEN", sequenceName="SPEXCPORMAN_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPEXCPORMAN_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="CUSTOMERID",length=10, nullable=false)
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
	
	@Column(name="EMAIL",length=320, nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

