package com.lynxspa.sdm.processors.masterrecord.rules;

import com.lynxspa.sdm.processors.masterrecord.rules.conditions.Condition;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;
import com.lynxspa.sdm.processors.masterrecord.rules.targets.Target;


public abstract class RuleBean {

	protected String target=null;
	protected Target targetConstant=null;
	protected String targetParam=null;
	protected String field=null;
	protected String fieldName=null;
	protected Condition condition=null;
	protected Consequence resultOnTrue=null;
	protected Consequence resultOnFalse=null;
	protected String[] parameters=new String[]{};
	@SuppressWarnings("unchecked")
	protected Class conditionType=null;

	@SuppressWarnings("unchecked")
	protected RuleBean(Class _conditionType){
		this.conditionType=_conditionType;
	}

	public String getField(){
		return this.field;
	}
	protected void setField(String _field){
		this.field=_field;
	}
	
	public String getTarget() {
		return target;
	}
	public Target getTargetConstant() {
		return targetConstant;
	}
	public String getTargetParam() {
		return targetParam;
	}
	protected void setTarget(String target) {
		
		if(target.indexOf(':')>=0){
			this.targetConstant=Target.valueOf(target.substring(0,target.indexOf(':')));
			this.targetParam=target.substring(target.indexOf(':'));
		}else{
			this.targetConstant=Target.valueOf(target);
		}
		this.target = target;
	}

	public String getFieldName() {
		return fieldName;
	}
	protected void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public Condition getCondition() {
		return condition;
	}
	protected void setCondition(Condition _condition){
		this.condition=_condition;
	}

	public Consequence getResultOnTrue() {
		return resultOnTrue;
	}
	protected void setResultOnTrue(Consequence _resultOnTrue){
		this.resultOnTrue=_resultOnTrue;
	}

	public Consequence getResultOnFalse() {
		return resultOnFalse;
	}
	protected void setResultOnFalse(Consequence _resultOnFalse){
		this.resultOnFalse=_resultOnFalse;
	}

	public String[] getParameters() {
		return parameters;
	}
	protected void setParameters(String[] _stringParameters){
		this.parameters=_stringParameters;
	}

	@SuppressWarnings("unchecked")
	public Class getConditionType() {
		return conditionType;
	}

}
