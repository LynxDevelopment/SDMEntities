package com.lynxspa.sdm.installer.adapters.events.configuration;


public interface EventFieldMessageConfigAdapter {

	public abstract String getFieldPath();
	public abstract String getMessageFormat();
	public abstract String getMessageType();
	public abstract String getNormalizationScript();
}