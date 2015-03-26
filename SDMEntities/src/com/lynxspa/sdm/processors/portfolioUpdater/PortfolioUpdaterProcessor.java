package com.lynxspa.sdm.processors.portfolioUpdater;

import java.util.Locale;

import org.hibernate.Session;

import com.lynxspa.entities.application.logs.utils.LogUtils;
import com.lynxspa.sdm.dictionaries.logs.LogInfoDict;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.managers.SDMConfigManager;

public class PortfolioUpdaterProcessor implements PortfolioUpdaterAdapter {

	public void updatePortfolio(Session _session,CAEventMessage _message,String _locale) throws Exception{
		
		SDMConfigManager manager=SDMConfigManager.getInstance();
		LogUtils.createLog(_session,"UPDATERPROCESSOR", manager.getBundleName(),new Locale(_locale), manager.getApplication(_session), LogInfoDict.PORTFOLIO_UPDATER_UNKNOWN_PORTFOLIO, new Object[]{_message.getAccount(),_message.getId()}, null);
	}
}
