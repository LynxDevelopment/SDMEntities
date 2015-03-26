package com.lynxspa.sdm.dictionaries.logs.statics;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;
import com.lynxspa.exception.FPMExceptionMessage;
import com.lynxspa.exception.FPMExceptionType;

public enum LogStaticErrorDict implements LogDictAdapter,FPMExceptionMessage{

//	Normalization
	PREVIOUS_NEW_MESSAGE_NOT_FOUND("error.normalization.previous.new.not.found","Normalization of message {0} fail. Previous message NEW not found, can't update event."),
	PREVIOUS_NEW_MESSAGE_NOT_NORMALIZED("error.normalization.previous.new.not.normalized","Normalization of message {0} fail. Previous message NEW {1} is not yet normalized, can't update event."),
	NORMALIZATION_SCRIPTING_ERROR("error.normalization.scripting","Normalization of message {0} has failed due a script exception."),
	NORMALIZATION_RESULT_NULL("error.null.normalization.result","Normalization of message {0} has resturned a null result."),
	NORMALIZATION_FAIL("error.normalization.fail","Normalization fail."),
	NORMALIZATION_UNKNOWN_FIELD("error.normalization.unknown.field","Event field {0} unknown."),
	NORMALIZATION_EVENT_FIELD_TYPE("error.normalization.field.type","Event field {0} type wrong.");
	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	LogStaticErrorDict(String _key,String _defaultMessage){
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
		return LogLevel.ERROR;
	}
	public FPMExceptionType getType() {
		return FPMExceptionType.ERROR;
	}
	
}
