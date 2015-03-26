package com.lynxspa.entities.jobs;

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

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;

@Entity
@Table(name="TB_SDM_ERROR_VALUES")
/*
@org.hibernate.annotations.Table(appliesTo="TB_SDM_ERROR_VALUES",indexes={@Index(name="ID_ERROR", columnNames="ID"),})
*/
@org.hibernate.annotations.Table(appliesTo="TB_SDM_ERROR_VALUES")

public class SDMErrorValue implements UpdatableAdapter{
	
	private static final long serialVersionUID = 2613624285639410058L;
	
	private long id = 0l;
	private int version=0;
	private String error = null;
	private SDMValue value = null;
	private UpdateAuditor auditor = null;
	
	public SDMErrorValue(){
		super();
		this.auditor=new UpdateAuditor();
	}
	
	public SDMErrorValue(String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="SDMERRORVALUE_GEN", sequenceName="SDMERRORVALUE_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SDMERRORVALUE_GEN")
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
	
	@Column(name="ERROR", length=50, nullable=true)
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@ManyToOne(targetEntity = SDMValue.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ERRORVALUE_VALUE")
	@JoinColumn(name="FKVALUE", nullable=true)
	public SDMValue getValue() {
		return value;
	}
	
	public void setValue(SDMValue value) {
		this.value = value;
	}
	
	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}
}
