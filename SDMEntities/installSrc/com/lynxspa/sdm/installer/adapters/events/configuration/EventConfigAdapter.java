package com.lynxspa.sdm.installer.adapters.events.configuration;


public interface EventConfigAdapter {

	public String getEventType();
	public String getPreferentProvider();
	public String getSecondPreferentProvider();
	public String getOnPrimaryAndSecondaryNotFound();
	public String getOnCustodianAndManualNotFound();
}