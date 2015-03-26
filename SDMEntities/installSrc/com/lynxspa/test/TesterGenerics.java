package com.lynxspa.test;

import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.messages.CAEventMessageField;
import com.lynxspa.sdm.entities.events.messages.CAEventMessageFieldHistoric;
import com.lynxspa.sdm.entities.events.messages.CAEventMessageHistoric;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageAdapter;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageFieldAdapter;

public class TesterGenerics{

	public static void main(String[] args){
		
		CAEventMessageAdapter message=new CAEventMessage();
		CAEventMessageAdapter messageHistoric=new CAEventMessageHistoric();
		CAEventMessageFieldAdapter messageField=new CAEventMessageField();
		CAEventMessageFieldAdapter messageFieldHistoric=new CAEventMessageFieldHistoric();
		
System.out.println("0");
		message.addField(messageField);
System.out.println("1");
		messageHistoric.addField(messageFieldHistoric);
System.out.println("2");
	messageHistoric.addField(messageField);	
System.out.println("3");
	message.addField(messageFieldHistoric);
System.out.println("4");
	}
}
