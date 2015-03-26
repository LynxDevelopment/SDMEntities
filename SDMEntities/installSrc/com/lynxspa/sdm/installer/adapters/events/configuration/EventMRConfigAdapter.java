package com.lynxspa.sdm.installer.adapters.events.configuration;

public interface EventMRConfigAdapter {

	public int getRuleOrder();
	public String getTarget();
	public String getFieldPath();
	public String getCondition();
	public String getOnTrueResult();
	public String getOnFalseResult();
	public String getConditionParams();
}
