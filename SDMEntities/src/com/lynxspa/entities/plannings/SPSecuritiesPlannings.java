package com.lynxspa.entities.plannings;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.securities.SPVirtualSecurity;

@Entity
@Table(name="TB_SP_SECURITY_PLANNING")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_PLANNING")
public class SPSecuritiesPlannings implements Serializable{

	private static final long serialVersionUID = -8188421172249283187L;
    private long id;
	
    private SPVirtualSecurity security;
    private SPPlanningProcess planning;
    
    public SPSecuritiesPlannings (){
		
	}
	
    public SPSecuritiesPlannings(SPVirtualSecurity _security, SPPlanningProcess _planning) {
		this.security= _security;
		this.planning = _planning;
	}

    @ManyToOne(targetEntity = SPVirtualSecurity.class,fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@ForeignKey(name="FK_SECURITY_PLANNING")
	@JoinColumn(name="FKSECURITY")
	public SPVirtualSecurity getSecurity() {
		return security;
	}
	public void setSecurity(SPVirtualSecurity security) {
		this.security = security;
	}

	@ManyToOne(targetEntity = SPPlanningProcess.class,fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	@ForeignKey(name="FK_PLANNING")
	@JoinColumn(name="FKPLANNING")
	public SPPlanningProcess getPlanning() {
		return planning;
	}
	public void setPlanning(SPPlanningProcess planning) {
		this.planning = planning;
	}

	@Id
	@SequenceGenerator(name="SPPERSECURITYPLANIFICATION_GEN", sequenceName="SPPERSECURITYPLANIFICATION_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPPERSECURITYPLANIFICATION_GEN")
	@Column(name="ID", nullable=false, unique=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Transient
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
	
}
