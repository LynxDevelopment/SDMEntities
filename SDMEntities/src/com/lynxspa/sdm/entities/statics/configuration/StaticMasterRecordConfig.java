package com.lynxspa.sdm.entities.statics.configuration;

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
import org.hibernate.annotations.Index;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.entities.securities.assets.AssetTypeDetail;


@Entity
@Table(name="TB_SDM_STMRCONFIGS",uniqueConstraints={@UniqueConstraint(columnNames={"FKSTCONFIG","RULEORDER"})})
public class StaticMasterRecordConfig implements InsertableAdapter{
	private static final long serialVersionUID = 4185311433578320902L;
	private long id=0l;
	private StaticConfig staticConfig=null;
	private int ruleOrder=0;
	private AssetTypeDetail detail=null;
	private String target=null;
	private String condition=null;
	private String onTrueResult=null;
	private String onFalseResult=null;
	private String conditionParams=null;
	private InsertAuditor auditor=null;


	public StaticMasterRecordConfig(){
		this(null,null);
	}
	public StaticMasterRecordConfig(String _user,StaticConfig _staticConfig){
		super();
		this.staticConfig=_staticConfig;
		this.auditor=new InsertAuditor(_user);
	}

	@Id
	@SequenceGenerator(name="SEQ_STMRCONF_GEN", sequenceName="SEQ_STMRCONF_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_STMRCONF_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = StaticConfig.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_STMRCONFIGS_STCONFIG")
	@JoinColumn(name="FKSTCONFIG", referencedColumnName="ID")
	@Index(name="IX_STMRCONFIGS_STCONFIG")
	public StaticConfig getStaticConfig() {
		return staticConfig;
	}
	public void setStaticConfig(StaticConfig staticConfig) {
		this.staticConfig = staticConfig;
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

	@ManyToOne(targetEntity = AssetTypeDetail.class,fetch=FetchType.EAGER,optional=false)
	@ForeignKey(name="FK_STMRCONFIGS_ASSTYPEDET")
	@JoinColumn(name="FKASSETTYPEDETAIL")
	@Index(name="IX_STMRCONFIGS_ASSTYPEDET")
	public AssetTypeDetail getDetail() {
		return detail;
	}
	public void setDetail(AssetTypeDetail detail) {
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
