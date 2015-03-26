package com.lynxspa.sdm.processors.normalize.utils;

import java.text.MessageFormat;

public class FieldNotFoundException extends Exception{

	private static final long serialVersionUID=2350177518480232070L;
	private static final String MESSAGE="Field {0} not found: {1}";
	
	
	public String searchedField=null;
	
	
	public FieldNotFoundException(){
		this(null,null,null);
	}
	public FieldNotFoundException(String _searchedField){
		this(_searchedField,null,null);
	}
	public FieldNotFoundException(String _searchedField,String _message){
		this(_searchedField,_message,null);
	}
	public FieldNotFoundException(String _searchedField,Throwable _cause){
		this(_searchedField,null,_cause);
	}
	public FieldNotFoundException(String _searchedField,String _message,Throwable _cause){
		super(_message, _cause);
		this.searchedField=_searchedField;
	}

	
	public String getSearchedField(){
		return searchedField;
	}

	@Override
	public String getMessage(){
		return MessageFormat.format(FieldNotFoundException.MESSAGE,this.searchedField,super.getMessage());
	}
}
