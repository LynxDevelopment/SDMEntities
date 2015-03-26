package com.lynxspa.sdm.dictionaries.logs.statics;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;

public enum LogStaticInfoDict implements LogDictAdapter {

	//Normalization
	NORMALIZE_SCRIPT_NOT_FOUND("info.normalize.script.not.found","Normalization script is not installed."),
	CANCELATION_OVER_MASTERRECORD("info.cancelation.over.masterrecord","Canceled event of the same master record group"),
	CANCELATION_OVER_AUTHORIZED("info.cancelation.over.authorized","Canceled event of the same master record group"),
	CANCELATION_OVER_SENTEVENT("info.cancelation.over.sent.event","Canceled event of allready sent message"),
	CANCELED_EVENT_OF_GROUP("info.canceled.event.of.group","Canceled event of group"),
	UPDATE_OVER_MASTERRECORD("info.update.over.masterrecord","Update event of the same master record group"),
	UPDATE_OVER_AUTHORIZED("info.update.over.authorized","Update event of the same master record group"),
	UPDATE_OVER_SENTEVENT("info.update.over.sent.event","Update event of allready sent message"),
	UPDATE_EVENT_OF_GROUP("info.update.event.of.group","Updated event of group");
	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	
	LogStaticInfoDict(String _key,String _defaultMessage){
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
		return LogLevel.INFO;
	}
}
