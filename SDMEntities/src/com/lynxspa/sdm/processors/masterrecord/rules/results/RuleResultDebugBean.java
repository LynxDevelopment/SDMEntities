package com.lynxspa.sdm.processors.masterrecord.rules.results;

import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.processors.masterrecord.rules.RuleInstance;
import com.lynxspa.sdm.processors.masterrecord.rules.conditions.Condition;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.ConditionEvaluationResult;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;
import com.lynxspa.sdm.utils.EventDetailUtils;

public class RuleResultDebugBean {

	private int executionIndex=0;
	private String target=null;
	private String comparisonType=null;
	private String fieldName=null;
	private String fieldPath=null;
	@SuppressWarnings("unchecked")
	private Class fieldType=null;
	private long masterRecordEventId=0l;
	private String fieldMRValue=null;
	private long comparisonEventId=0l;
	private String fieldComparisonValue=null;
	private Condition condition=null;
	private String[] conditionParams=null;
	private ConditionEvaluationResult comparisonResult=null;
	private Consequence executionResult=null;
	
	
	@SuppressWarnings("unchecked")
	public RuleResultDebugBean(int _executionIndex,CAEventCollected _masterRecordEventId,CAEventCollected _comparisonEventId,RuleInstance _ruleInstance,ConditionEvaluationResult _comparisonResult,Consequence _consequence){
		this.executionIndex=_executionIndex;
		this.target=_ruleInstance.getTarget();
		this.comparisonType=_comparisonEventId.getClass().getName();
		this.fieldName=_ruleInstance.getFieldName();
		this.fieldPath=_ruleInstance.getField();
		this.fieldType=_ruleInstance.getConditionType();
		this.masterRecordEventId=_masterRecordEventId.getId();
		this.fieldMRValue=String.valueOf(EventDetailUtils.getEventDetailValue(_masterRecordEventId.getEventDetail(),_ruleInstance.getField(),0));
		this.comparisonEventId=_comparisonEventId.getId();
		this.fieldComparisonValue=String.valueOf(EventDetailUtils.getEventDetailValue(_comparisonEventId.getEventDetail(),_ruleInstance.getField(),0));
		this.condition=_ruleInstance.getCondition();
		this.conditionParams=_ruleInstance.getParameters();
		this.comparisonResult=_comparisonResult;
		this.executionResult=_consequence;
	}
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getComparisonType() {
		return comparisonType;
	}
	public void setComparisonType(String comparisonType) {
		this.comparisonType = comparisonType;
	}

	public int getExecutionIndex() {
		return executionIndex;
	}
	public void setExecutionIndex(int executionIndex) {
		this.executionIndex = executionIndex;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldPath() {
		return fieldPath;
	}
	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}
	
	@SuppressWarnings("unchecked")
	public Class getFieldType() {
		return fieldType;
	}
	@SuppressWarnings("unchecked")
	public void setFieldType(Class fieldType) {
		this.fieldType = fieldType;
	}
	
	public long getMasterRecordEventId() {
		return masterRecordEventId;
	}
	public void setMasterRecordEventId(long masterRecordEventId) {
		this.masterRecordEventId = masterRecordEventId;
	}
	
	public String getFieldMRValue() {
		return fieldMRValue;
	}
	public void setFieldMRValue(String fieldMRValue) {
		this.fieldMRValue = fieldMRValue;
	}
	
	public long getComparisonEventId() {
		return comparisonEventId;
	}
	public void setComparisonEventId(long comparisonEventId) {
		this.comparisonEventId = comparisonEventId;
	}
	
	public String getFieldComparisonValue() {
		return fieldComparisonValue;
	}
	public void setFieldComparisonValue(String fieldComparisonValue) {
		this.fieldComparisonValue = fieldComparisonValue;
	}
	
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public String[] getConditionParams() {
		return conditionParams;
	}
	public void setConditionParams(String[] conditionParams) {
		this.conditionParams = conditionParams;
	}
	
	public ConditionEvaluationResult getComparisonResult() {
		return comparisonResult;
	}
	public void setComparisonResult(ConditionEvaluationResult comparisonResult) {
		this.comparisonResult = comparisonResult;
	}

	public Consequence getExecutionResult() {
		return executionResult;
	}
	public void setExecutionResult(Consequence executionResult) {
		this.executionResult = executionResult;
	}
}
