package com.lynxspa.entities.securities.managers;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;


@Entity
@Table(name="TB_SP_MANAGERGROUPS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_MANAGERGROUPS",indexes={
		@Index(name="IDX_MANAGERGROUP_DELETED",columnNames="ISDELETED")
})
public class SPManagerGroup implements UpdatableAdapter{

	private static final long serialVersionUID = -1020695539831625431L;

	
	private long id = 0l;
	private String name = null;
	private String customerId=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	
	
	public SPManagerGroup(){
		this(null,null,null);
	}
	public SPManagerGroup(String _user,String _name){
		this(_user,_name,null);
	}
	public SPManagerGroup(String _user,String _name,String _customerId){
		super();
		this.name=_name;
		this.customerId=_customerId;
		this.auditor=new UpdateAuditor(_user);
	}

	@Id
	@SequenceGenerator(name="SPMANAGERGROUP_GEN", sequenceName="SPMANAGERGROUP_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPMANAGERGROUP_GEN")
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
	
	@Column(name="CUSTOMERID", length=64, nullable=true)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
}