package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainOPERATIONClusterSWIFTValue implements DomainValueDictAdapter {

	VALUE1("CANCEL","CANC"),
	VALUE2("CANCEL","CANC/CODU"),
	VALUE3("CANCEL","CANC/COPY"),
	VALUE4("CANCEL","CANC/DUPL"),
	VALUE5("NEW","NEWM"),
	VALUE6("REPEAT","NEWM/CODU"),
	VALUE7("REPEAT","NEWM/COPY"),
	VALUE8("REPEAT","NEWM/DUPL"),
	VALUE9("REPEAT","REPE"),
	VALUE10("REPEAT","REPE/CODU"),
	VALUE11("REPEAT","REPE/COPY"),
	VALUE12("REPEAT","REPE/DUPL"),
	VALUE13("UPDATE","REPL"),
	VALUE14("REPEAT","REPL/CODU"),
	VALUE15("UPDATE","REPL/COPY"),
	VALUE16("REPEAT","REPL/DUPL"),
	VALUE17("REPEAT","RMDR"),
	VALUE18("REPEAT","RMDR/CODU"),
	VALUE19("REPEAT","RMDR/COPY"),
	VALUE20("REPEAT","RMDR/DUPL"),
	VALUE21("UPDATE","WITH"),
	VALUE22("REPEAT","WITH/CODU"),
	VALUE23("UPDATE","WITH/COPY"),
	VALUE24("REPEAT","WITH/DUPL");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainOPERATIONClusterSWIFTValue(String _normalCode,String _value){
		this.normalCode=_normalCode;
		this.value=_value;
	}
	
	
	public String getNormalCode() {
		return this.normalCode;
	}
	public String getValue() {
		return this.value;
	}
}
