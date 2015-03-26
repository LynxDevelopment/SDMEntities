package com.lynxspa.sdm.dictionaries.logs;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;
import com.lynxspa.exception.FPMExceptionMessage;
import com.lynxspa.exception.FPMExceptionType;

public enum LogWarningDict implements LogDictAdapter,FPMExceptionMessage{

	
	//Master Record
	PRIMARYANDSECONDARYMRNOTFOUND("warning.primary.and.secondary.mr.not.found","Neither primary and secondary preferred master record not found"),
	MANUALANDCUSTODIANNOTFOUND("warning.manual.and.custodian.mr.not.found","Neither manual and custodian providers not found"),
	//Market creation
	MARKET_CREATED_BY_SECURITY_LOADER("warning.market.created.by.security.loader","Market {0} created by security loader verify if it''s correct.");
	
	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	LogWarningDict(String _key,String _defaultMessage){
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
		return LogLevel.WARNING;
	}
	public FPMExceptionType getType() {
		return FPMExceptionType.WARNING;
	}
}
