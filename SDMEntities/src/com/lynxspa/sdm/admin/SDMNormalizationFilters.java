package com.lynxspa.sdm.admin;

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

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.sdm.installer.SDMNormalizationInstaller;

@Entity
@Table(name="TB_SDM_NORMALIZATION_FILTERS") 
public class SDMNormalizationFilters {
	private long id =0l;
	private SDMAdminNormalization normaliaztion = null;
	private String filterClass=null;
	private String conditionFilter=null;
	private String name = null;
	
	@Id
	@SequenceGenerator(name="NORM_FILTER_GEN", sequenceName="NORM_FILTER_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="NORM_FILTER_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = SDMAdminNormalization.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_NORM")
	@JoinColumn(name="FKNORMALIZATION",nullable=true,updatable=false)
	public SDMAdminNormalization getNormaliaztion() {
		return normaliaztion;
	}
	public void setNormaliaztion(SDMAdminNormalization normaliaztion) {
		this.normaliaztion = normaliaztion;
	}
	
	@Column(name="FILTER_CLASS", nullable=false, length=128)
	public String getFilterClass() {
		return filterClass;
	}
	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}
	
	@Column(name="CONDITION", nullable=true, length=512)
	public String getConditionFilter() {
		return conditionFilter;
	}
	public void setConditionFilter(String conditionFilter) {
		this.conditionFilter = conditionFilter;
	}
	
	@Column(name="FILTER_NAME", nullable=false, length=64)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
