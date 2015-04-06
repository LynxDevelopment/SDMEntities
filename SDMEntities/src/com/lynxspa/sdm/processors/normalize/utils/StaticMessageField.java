package com.lynxspa.sdm.processors.normalize.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.lynxspa.entities.jobs.SDMJobField;

public class StaticMessageField {
	private static Pattern pattern=Pattern.compile("\\([^0-9]\\)");
	
	/** Field Path */
	public String path=null;
	/** Field Value */
	public String value=null;
	/** Field Format */
	public char format=' ';
	/** Date Format */
	public String dateFormat = null;
	
	public StaticMessageField(SDMJobField _field, String _value) throws Exception{
		this.path=_field.getPath();
		this.value=_value;
		String group=(new Scanner(_field.getPath())).findInLine(StaticMessageField.pattern);
		if((group!=null)&&(group.length()>1))
			this.format=group.charAt(1);
	}
	public StaticMessageField(SDMJobField _field, String _value, String dateFormat) throws Exception{
		this.path=_field.getPath();
		this.value=_value;
		String group=(new Scanner(_field.getPath())).findInLine(StaticMessageField.pattern);
		if((group!=null)&&(group.length()>1))
			this.format=group.charAt(1);
		this.dateFormat = dateFormat;
	}
	public StaticMessageField(String _path,String _value,char _format) throws Exception{
		this.path=_path;
		this.value=_value;
		this.format=_format;
	}
	public StaticMessageField(String _path,String _value, String dateFormat) throws Exception{
		this.path=_path;
		this.value=_value;
		this.dateFormat = dateFormat;
	}
	public StaticMessageField(String _path,String _value,char _format, String dateFormat) throws Exception{
		this.path=_path;
		this.value=_value;
		this.format=_format;
		this.dateFormat = dateFormat;
	}
	
	public String toString(){
		return "["+this.path+"]["+this.value+"]["+this.format+"]";
	}
}
