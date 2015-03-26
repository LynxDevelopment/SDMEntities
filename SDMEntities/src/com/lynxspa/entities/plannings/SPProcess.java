package com.lynxspa.entities.plannings;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;

@Entity
@Table(name="TB_SP_PROCESS")
@DiscriminatorColumn(name="PROCESSTYPE", discriminatorType=DiscriminatorType.STRING, length=16)
public class SPProcess implements VersionableAdapter {

	private static final long serialVersionUID = 2799512184239835654L;
	private long id =0l;
	private VersionAuditor auditor=null;
	private int version=0;
	private String description=null;
	
	public SPProcess (){
		
	}
	
	public SPProcess(String _user, String _description) {
		super();
		this.auditor=new VersionAuditor(_user);
		this.description = _description;
	}

	@Id
	@SequenceGenerator(name="SPPROCESS_GEN", sequenceName="SPPROCESS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPPROCESS_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}

	public void setId(long _id) {
		this.id = _id;
	}

	@Column(name="DESCRIPTION", nullable=false,length=16)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Embedded
	public VersionAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@Transient
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
