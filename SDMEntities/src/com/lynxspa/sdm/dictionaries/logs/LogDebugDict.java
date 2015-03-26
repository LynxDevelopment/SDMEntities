package com.lynxspa.sdm.dictionaries.logs;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;

public enum LogDebugDict implements LogDictAdapter {

	MESSAGE_PROCESSED("message.processed","Message {0} processed:\n{1}"),
	NOTIFICATION_NOT_NECESARY("notification.not.necessary","Notification to agent not necessary, masterevent {0} without client positions");
	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	LogDebugDict(String _key,String _defaultMessage){
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
		return LogLevel.DEBUG;
	}
}
