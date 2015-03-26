package com.lynxspa.sdm.dictionaries.logs;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;

public enum LogInfoDict implements LogDictAdapter {

	//Generic
	MESSAGE_FORMAT_NOT_INSTALLED("info.message.format.not.installed","Message {0} of format {1} discarted because format is not installed."),
	//Feed Loading
	START_PARSE("info.feed.loading.start.process","Start corporate actions {0} parsing [{1}]."),
	END_PARSE("info.feed.loading.end.process","End corporate actions {0} [{1}] parse spending {2,time,HH:mm:ss.SSS} for {3} messages:\n	Ignored messages: {4}\n	Grouped messages: {5}\n	Filtered messages: {6}\n	Duplicated messages: {7}\n	Error Messages: {8}\n	---------------------------\n	Inserted messages: {9}"),
	MESSAGE_FILTER_DISCART("info.feed.loading.message.filtered","Message {0} from {1} of type {2} discarted by filter."),
	MESSAGE_FILTER_ACCEPT("info.feed.loading.message.accepted","Message {0} from {1} of type {2} accepted by filter."),
	DUPLICATED_MESSAGE_DISCARTED("info.feed.loading.message.duplicated","Duplicated {0} message {1} discarted."),
	//Pre-normalization
	SECURITY_FINDER_SECURITY_NOT_FOUND("info.prenormalize.security.not.found","Security {0} of type {1} not found, temporally security created with id: {2}."),
	//	Security upload
	START_SECURITY_PARSE("info.security.upload.start.process","Start Security {0} parsing [{1}]."),
	END_SECURITY_PARSE("info.security.upload.end.process","End Security {0} [{1}] parse spending {2,time,HH:mm:ss.SSS} for {3} messages."),
	START_SECURITY_FUNDS_PARSE("info.security.funds.upload.start.process","Start Security Funds {0} parsing [{1}]."),
	END_SECURITY_FUNDS_PARSE("info.security.funds.upload.end.process","End Security Funds {0} [{1}] parse spending {2,time,HH:mm:ss.SSS} for {3} messages."),
	SECURITY_DIF_INTERESTING("info.security.dif.interesting","Security {0} with ISIN {1} has not been load because of dif interesting"),
	VIRTUAL_SECURITY_INSERTED("info.virtual.security.inserted","Security {0} has created from virtual security {1} modifying {2} event messages."),
	VIRTUAL_SECURITY_REPLACED("info.virtual.security.replaced","Virtual security {0} has been replaced by {1} modifying {2} event messages."),
	//Normalization
	NORMALIZE_SCRIPT_NOT_FOUND("info.normalize.script.not.found","Normalization script is not installed."),
	VIRTUALSECURITY_MESSAGE_NOT_NORMALIZABLE("info.virtual.security.message.not.normalizable","Virtual security message can't be normalized."),
	SECURITY_NOT_INPORTFOLIO("info.security.not.in.portfolio","Security is not in portfolio."),
	CANCELATION_OVER_MASTERRECORD("info.cancelation.over.masterrecord","Canceled event of the same master record group"),
	CANCELATION_OVER_AUTHORIZED("info.cancelation.over.authorized","Canceled event of the same master record group"),
	CANCELATION_OVER_SENTEVENT("info.cancelation.over.sent.event","Canceled event of allready sent message"),
	CANCELED_EVENT_OF_GROUP("info.canceled.event.of.group","Canceled event of group"),
	UPDATE_OVER_MASTERRECORD("info.update.over.masterrecord","Update event of the same master record group"),
	UPDATE_OVER_AUTHORIZED("info.update.over.authorized","Update event of the same master record group"),
	UPDATE_OVER_SENTEVENT("info.update.over.sent.event","Update event of allready sent message"),
	UPDATE_EVENT_OF_GROUP("info.update.event.of.group","Updated event of group"),
	SECURITY_MESSAGE_NOT_IN_PRINCIPAL_MARKET("info.security.message.not.in.principal.market","Security message not in principal market"),
	//Historification
	START_HISTORIFY("info.historify.start.process","Start historifying messages prenormalized and processed {0} days or more ago."),
	END_HISTORIFY("info.historify.end.process","End historifying messages spending {0,time,HH:mm:ss.SSS} for {1} messages:\n	Messages historified: {2}\n	 Messages failed: {3}"),
	START_HISTORIFYEVENTS("info.historifyevents.start.process","Start historifying events generated {0} days or more ago."),
	END_HISTORIFYEVENTS("info.historifyevents.end.process","End historifying events spending {0,time,HH:mm:ss.SSS} for {1} events:\n	Events historified: {2}\n	 Details Historified {3}\n  	DetailsExtended Historified {4}\n"),
	START_LIVETIME_MESSAGES_HISTORIFIED("info.delete.messages.historified.start.proccess","Start deleting messages historified {0} days or more ago "),
	END_LIVETIME_MESSAGES_HISTORIFIED("info.delete.messages.historified.stop.proccess","End deleting {0} messages and {1} fields historified, spending {2,time,HH:mm:ss.SSS}"),
	START_LIVETIME_EVENTS_HISTORIFIED("info.delete.events.historified.start.proccess","Start deleting events historified {0} days or more ago "),
	END_LIVETIME_EVENTS_HISTORIFIED("info.delete.events.historified.stop.proccess","End deleting {0} events,{1} eventDetails and {2} eventExtendedDetails, spending {3,time,HH:mm:ss.SSS}"),
	START_LOGS_HISTORIFICATION("info.delete.logs.start.proccess","Start deleting logs {0} days or more ago "),
	END_LOGS_HISTORIFICATION("info.delete.logs.stop.proccess","End deleting logs spending {0,time,HH:mm:ss.SSS} for {1} logs"),
	//Message consumer
	MESSAGE_CONSUMER_DISCART_MESSAGE("info.message.consumer.discart.by.operation","Message {0} discarted by message consumer because message notification files of {1} are not processed."),
	//Portfolio updater
	PORTFOLIO_UPDATER_UNKNOWN_PORTFOLIO("info.portfolio.updater.unkown.portfolio","Unkown portfolio {0} from message {2}."),
	//Auxs Tables Load
	AUX_TABLE_LOAD_BEGIN("info.aux.tables.load","Begining to process table {0} with {1} rows"),
	AUX_TABLE_LOAD_END("info.aux.tables.load","End of load of table {0}, {1} rows processed, {2} errors"),
	//Parametrizable messages
	PROCESS_BEGIN("info.process.begin","Process {0} begin at {1}"),
	PROCESS_END("info.process.end", "Process {0} end at {1}");
	
	private String messageKey=null;
	private String defaultMessage=null;
	
	
	LogInfoDict(String _key,String _defaultMessage){
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
