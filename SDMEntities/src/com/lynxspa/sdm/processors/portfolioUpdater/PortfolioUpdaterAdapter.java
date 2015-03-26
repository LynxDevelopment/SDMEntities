package com.lynxspa.sdm.processors.portfolioUpdater;

import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.messages.CAEventMessage;


public interface PortfolioUpdaterAdapter {

	public void updatePortfolio(Session _session,CAEventMessage _message,String _locale) throws Exception;
}
