package com.lynxspa.sdm.entities.events.configuration;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;


@Entity
@Table(name="TB_CA_EVENTMRCONFIGS",uniqueConstraints={@UniqueConstraint(columnNames={"FKEVENTCONFIG","RULEORDER"})})
public class CAEventMasterRecordConfig implements InsertableAdapter{

	private static final long serialVersionUID = -8113015648404438220L;

	
	private long id=0l;
	private CAEventConfig eventConfig=null;
	private int ruleOrder=0;
	private CAEventTypeDetail detail=null;
	private String target=null;
	private String condition=null;
	private String onTrueResult=null;
	private String onFalseResult=null;
	private String conditionParams=null;
	private InsertAuditor auditor=null;


	public CAEventMasterRecordConfig(){
		this(null,null);
	}
	public CAEventMasterRecordConfig(String _user,CAEventConfig _eventConfig){
		super();
		this.eventConfig=_eventConfig;
		this.auditor=new InsertAuditor(_user);
	}

	@Id
	@SequenceGenerator(name="CAEVENTMRCONF_GEN", sequenceName="CAEVENTMRCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVENTMRCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventConfig.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVENTMRCONFIGS_EVENTCONFIG")
	@JoinColumn(name="FKEVENTCONFIG", referencedColumnName="ID")
	public CAEventConfig getEventConfig() {
		return eventConfig;
	}
	public void setEventConfig(CAEventConfig eventConfig) {
		this.eventConfig = eventConfig;
	}

	@Column(name="TARGET",length=64, nullable=true, updatable=true)
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	@Column(name="RULEORDER")
	public int getRuleOrder() {
		return ruleOrder;
	}
	public void setRuleOrder(int ruleOrder) {
		this.ruleOrder = ruleOrder;
	}

	@ManyToOne(targetEntity = CAEventTypeDetail.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_EVENTMRCONFIGS_EVNTYPEDET")
	@JoinColumn(name="FKEVENTTYPEDETAIL")
	public CAEventTypeDetail getDetail() {
		return detail;
	}
	public void setDetail(CAEventTypeDetail detail) {
		this.detail = detail;
	}
	
	@Column(name="CONDITION",length=32)
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@Column(name="ONTRUERESULT",length=32)
	public String getOnTrueResult() {
		return onTrueResult;
	}
	public void setOnTrueResult(String onTrueResult) {
		this.onTrueResult = onTrueResult;
	}
	
	@Column(name="ONFALSERESULT",length=32)
	public String getOnFalseResult() {
		return onFalseResult;
	}
	public void setOnFalseResult(String onFalseResult) {
		this.onFalseResult = onFalseResult;
	}
	
	@Column(name="CONDITIONPARAMS",length=128)
	public String getConditionParams() {
		return conditionParams;
	}
	public void setConditionParams(String conditionParams) {
		this.conditionParams = conditionParams;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(InsertAuditor auditor) {
		this.auditor = auditor;
	}
}
