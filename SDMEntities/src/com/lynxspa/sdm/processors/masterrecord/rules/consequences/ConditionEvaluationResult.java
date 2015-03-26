package com.lynxspa.sdm.processors.masterrecord.rules.consequences;

public enum ConditionEvaluationResult{

	TRUE("TRUE","condition.eval.true",true,true),
	FALSE("FALSE","condition.eval.false",true,false),
	SKIPPED("SKIPPED","condition.not.evaluated",false,false),
	NOTTARGET("NOTTARGET","condition.not.applicable",false,false);
	
	
	private String code=null;
	private String description=null;
	private boolean evaluated=false;
	private boolean ok=false;

	
	ConditionEvaluationResult(String _code,String _description,boolean _evaluated,boolean _ok){
		this.code=_code;
		this.description=_description;
		this.evaluated=_evaluated;
		this.ok=_ok;
	}	
	
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public boolean isEvaluated() {
		return evaluated;
	}
	public boolean isOk() {
		return ok;
	}
}
