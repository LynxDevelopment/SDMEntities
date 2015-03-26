package com.lynxspa.sdm.processors.normalize;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.messages.CAEventMessage;

public class NeutralNormalizeProcessor implements NormalizeProcessorAdapter {

	public NormalizeResultBean normalize(Session _session, CAEventMessage _message) throws Exception{
		
		return test(_session,new ArrayList<NormalizeScriptConfigBean>(),_message);
	}

	public NormalizeResultBean test(Session _session,List<NormalizeScriptConfigBean> _scripts, CAEventMessage _message) throws Exception {

		return new NormalizeResultBean();
	}

}
