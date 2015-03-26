package com.lynxspa.sdm.installer.adapters.providers;

import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;

public interface ProviderAdapter {

	public Class<? extends CAExternalEventProvider> getProviderClass();
	public String getCode();
	public String getName();
	public String getIdAtMessage();
	public CAFormatDictAdapter getFormat();
}
