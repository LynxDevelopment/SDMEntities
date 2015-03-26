package com.lynxspa.sdm.dictionaries.logs;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;

public enum LogAuditDict implements LogDictAdapter {

	PORTFOLIO_UPDATER_UPDATE("info.portfolio.updater.update","Portfolio {0} updated to {1} shares for message {2}.");

	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	LogAuditDict(String _key,String _defaultMessage){
		this.messageKey=_key;
		this.defaultMessage=_defaultMessage;
	}

	
	public String getMessageKey() {
		return this.messageKey;
	}
	public String getDefaultMessage() {
		return this.defaultMessage;
	}
	public LogLevel getLevel() {
		return LogLevel.AUDIT;
	}
}
