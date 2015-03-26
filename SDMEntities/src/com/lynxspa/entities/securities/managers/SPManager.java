package com.lynxspa.entities.securities.managers;

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


@Entity
@Table(name="TB_SP_MANAGERS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_MANAGERS",indexes={
		@Index(name="IDX_MANAGER_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_MANAGER_FKMANAGERGROUP",columnNames="FKMANAGERGROUP")
})
public class SPManager implements UpdatableAdapter{

	private static final long serialVersionUID = 6813347464609064582L;
	
	private long id=0l;
	private String name=null;
	private String customerId=null;
	private SPManagerGroup managerGroup=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	private String email=null;

	
	public SPManager (){
		this(null,null,null,null);
	}
	public SPManager (String _user,String _name){
		this(_user,_name,null,null);
	}
	public SPManager (String _user,String _name,String _customerId){
		this(_user,_name,_customerId,null);
	}
	
	public SPManager (String _user,String _name,String _customerId,SPManagerGroup _managerGroup){
		super();
		this.name=_name;
		this.customerId=_customerId;
		this.managerGroup=_managerGroup;
		this.auditor=new UpdateAuditor(_user);
	}

	@Id
	@SequenceGenerator(name="SPMANAGER_GEN", sequenceName="SPMANAGER_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPMANAGER_GEN")
	@Column(name="ID", nullable=false)
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
	
	@ManyToOne(targetEntity = SPManagerGroup.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_MANAGER_MANAGERGROUP")
	@JoinColumn(name="FKMANAGERGROUP",nullable=true)
	public SPManagerGroup getManagerGroup() {
		return managerGroup;
	}
	public void setManagerGroup(SPManagerGroup managerGroup) {
		this.managerGroup = managerGroup;
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
	
	@Column(name="EMAIL", length=64, nullable=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
