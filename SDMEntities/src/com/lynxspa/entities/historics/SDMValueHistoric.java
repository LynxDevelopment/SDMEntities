package com.lynxspa.entities.historics;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.jobs.SDMJobField;

@Entity
@Table(name="HS_SDM_VALUES")
//@org.hibernate.annotations.Table(appliesTo="TB_SDM_VALUES",indexes={@Index(name="ID_VALUE", columnNames="ID"),})
@org.hibernate.annotations.Table(appliesTo="HS_SDM_VALUES")

public class SDMValueHistoric implements UpdatableAdapter{
	
	private static final long serialVersionUID = 2613624285639410058L;
	
	private long id = 0l;
	private int version=0;
	private String value = null;
	private SDMJobField jobField = null;
	private SDMRowHistoric row = null;
	private UpdateAuditor auditor = null;
	
	public SDMValueHistoric(){
		super();
		this.auditor=new UpdateAuditor();
	}
	
	public SDMValueHistoric(String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
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
	
	@Column(name="VALUE", length=100, nullable=true)
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@ManyToOne(targetEntity = SDMJobField.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_VALUE_HISTORIC_JOBFIELD")
	@JoinColumn(name="FKJOBFIELD", nullable=true)
	public SDMJobField getJobField() {
		return jobField;
	}

	public void setJobField(SDMJobField jobField) {
		this.jobField = jobField;
	}

	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	@ManyToOne(targetEntity=SDMRowHistoric.class, fetch=FetchType.LAZY)
	@JoinColumn(name="FKROW",nullable=false,updatable=false)
	public SDMRowHistoric getRow() {
		return row;
	}
	public void setRow(SDMRowHistoric row) {
		this.row = row;
	}
	
	
}
