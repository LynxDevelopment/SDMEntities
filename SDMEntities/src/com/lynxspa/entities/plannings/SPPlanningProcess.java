package com.lynxspa.entities.plannings;

import java.nio.ByteBuffer;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;

@Entity
@Table(name="TB_SP_PLANNING_PROCESS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_PLANNING_PROCESS",indexes={
		@Index(name="IDX_PROCESS",columnNames="FKPROCESS")
})
public class SPPlanningProcess implements VersionableAdapter {

	private static final long serialVersionUID = -6800199664733536561L;
	private long id = 0l;
	private String cron=null;
	private String name=null;
	private byte[] template=null;
	private SPProcess process = null;
	private VersionAuditor auditor=null;
	private int version=0;
	private String templateString;
	private Date executionDate;
	private boolean manual;
	
	public SPPlanningProcess() {
	}
	
	public SPPlanningProcess(String _user, String _name, String cron, byte[] template, 
			SPProcess _process) {
		super();
		this.cron = cron;
		this.template = template;
		this.auditor = new VersionAuditor(_user);
		this.process = _process;
		this.name = _name;
		this.manual=false;
	}
	
	public SPPlanningProcess(String _user, String _name, String cron, byte[] template, 
			SPProcess _process, boolean _manual) {
		super();
		this.cron = cron;
		this.template = template;
		this.auditor = new VersionAuditor(_user);
		this.process = _process;
		this.name = _name;
		this.manual=_manual;
	}
	
	@Id
	@SequenceGenerator(name="SPPLANIFICATION_GEN", sequenceName="SPPLANIFICATION_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPPLANIFICATION_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="CRON", length=30, nullable=false)
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}

	@Column(name="NAME", length=30, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EXECUTIONDATE")
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	@Lob
	@Column(name="TEMPLATE", length=10000)
	@Basic(fetch=FetchType.LAZY)
	public byte[] getTemplate() {
		return template;
	}
	public void setTemplate(byte[] template) {
		this.template = template;
	}

	@Transient
	public Byte[] getObjectTemplate() {
		
		Byte[] reply=null;
		
		reply=new Byte[this.template.length];
		for(int ic1=0;ic1<this.template.length;ic1++)
			reply[ic1]=this.template[ic1];
		
		return reply;
	}
	public void setObjectTemplate(Byte[] template) {
		
		this.template=new byte[template.length];
		for(int ic1=0;ic1<template.length;ic1++)
			this.template[ic1]=template[ic1];
	}
	
	@ManyToOne(targetEntity = SPProcess.class,fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@ForeignKey(name="FK_PROCESS")
	@JoinColumn(name="FKPROCESS")
	public SPProcess getProcess() {
		return process;
	}
	public void setProcess(SPProcess _persecurityProcess) {
		this.process = _persecurityProcess;
	}

	@Column(name="MANUAL")
	public boolean isManual() {
		return manual;
	}
	public void setManual(boolean manual) {
		this.manual = manual;
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
	public String getTemplateString() {
		StringBuffer templateStr = null;
		if (this.template!=null){
			templateStr=new StringBuffer("");
			for (int k = 0; k < template.length; k++) {
				templateStr.append((char)template[k]);
			}
			this.templateString = templateStr.toString();
		}
		return templateString;
	}

	public void setTemplateString(String templateString) {
		this.templateString = templateString;
	}
	
	//TODO Se debería eliminar en cuanto se solucione en problema de los arrays con los mappings y utilizar directamente el template
	@Transient
	public ByteBuffer getTemplateBuffer(){
		
		ByteBuffer reply=null;
		
		reply=ByteBuffer.allocate(this.template.length);
		reply.put(this.template);
		
		return reply;
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SPPlanningProcess && obj!=null) {
			SPPlanningProcess otherPersecurity = (SPPlanningProcess) obj;
			boolean res = (otherPersecurity.getCron().equals(cron) && 
            		otherPersecurity.getTemplate()==template );
            return res;
        }

        return true;
	}	
}
