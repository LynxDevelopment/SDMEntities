package com.lynxspa.sdm.processors.normalize.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.lynxspa.sdm.entities.events.messages.CAEventMessageField;

public class MessageField{
	
	private static Pattern pattern=Pattern.compile("\\([^0-9]\\)");
	
	/** Field Path */
	public String path=null;
	/** Field Value */
	public String value=null;
	/** Field Format */
	public char format=' ';
	
	public MessageField(CAEventMessageField _field) throws Exception{
		this.path=_field.getPath();
		this.value=_field.getValue();
		String group=(new Scanner(_field.getPath())).findInLine(MessageField.pattern);
		if((group!=null)&&(group.length()>1))
			this.format=group.charAt(1);
	}
	public MessageField(String _path,String _value,char _format) throws Exception{
		this.path=_path;
		this.value=_value;
		this.format=_format;
	}
	
	public String toString(){
		return "["+this.path+"]["+this.value+"]["+this.format+"]";
	}
}