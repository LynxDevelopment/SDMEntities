package com.lynxspa.entities.securities.customers;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.securities.managers.SPManagerGroup;

@Entity
@Table(name="TB_SP_CUSTOMERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="MANAGERTYPE", discriminatorType=DiscriminatorType.STRING, length=16)
@DiscriminatorValue("group")
@org.hibernate.annotations.Table(appliesTo="TB_SP_CUSTOMERS",indexes={
		@Index(name="IDX_CUSTOMER_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_CUSTOMER_FKMANAGERGROUP",columnNames="FKCUSTMANAGERGROUP")
})
public class SPCustomerGroup implements UpdatableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5060774614300720803L;

	private long id=0l;
	private String name=null;
	private String customerId=null;
	private SPManagerGroup managerGroup=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	
	
	public SPCustomerGroup (){
		this(null,null,null,null);
	}
	public SPCustomerGroup (String _user,String _name){
		this(_user,_name,null,null);
	}
	public SPCustomerGroup (String _user,String _name,String _customerId,SPManagerGroup _managerGroup){
		super();
		this.name=_name;
		this.customerId=_customerId;
		this.managerGroup=_managerGroup;
		this.auditor=new UpdateAuditor(_user);
	}

	@Id
	@SequenceGenerator(name="SPCUSTOMER_GEN", sequenceName="SPCUSTOMER_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPCUSTOMER_GEN")
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
	
	@ManyToOne(targetEntity = SPManagerGroup.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_CUSTOMER_MANAGERGROUP")
	@JoinColumn(name="FKCUSTMANAGERGROUP",nullable=true)
	public SPManagerGroup getManagerGroup() {
		return managerGroup;
	}
	public void setManagerGroup(SPManagerGroup managerGroup) {
		this.managerGroup = managerGroup;
	}
	

}
