package com.lynxspa.sdm.processors.normalize;

import java.util.List;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.messages.CAEventMessage;


public interface NormalizeProcessorAdapter {
	
	public NormalizeResultBean test(Session _session,List<NormalizeScriptConfigBean> _scripts,CAEventMessage _message) throws Exception;
	public NormalizeResultBean normalize(Session _session,CAEventMessage _message) throws Exception;
}
