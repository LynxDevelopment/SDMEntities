package com.lynxspa.sdm.processors.normalize.staticdata;

import java.util.List;

import org.hibernate.Session;

import com.lynxspa.entities.securities.assets.messages.AssetMessage;
import com.lynxspa.sdm.processors.normalize.NormalizeScriptConfigBean;

public interface StaticDataNormalizeProcesorAdapter {
	public StaticDataNormalizeResultBean test(Session _session,List<NormalizeScriptConfigBean> _scripts,AssetMessage _message) throws Exception;
	public StaticDataNormalizeResultBean normalize(Session _session,AssetMessage _message) throws Exception;
}
