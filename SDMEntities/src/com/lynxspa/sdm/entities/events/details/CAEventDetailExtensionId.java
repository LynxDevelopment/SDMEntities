package com.lynxspa.sdm.entities.events.details;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CAEventDetailExtensionId implements Serializable,Comparable<CAEventDetailExtensionId>{

	private static final long serialVersionUID = 6151918482544313288L;

	private String extensionName=null;
	private int extensionNumber=0;

	
	public CAEventDetailExtensionId(){
		this(null,0);
	}
	public CAEventDetailExtensionId(String _extensionIdCode){
		super();
		if(_extensionIdCode!=null){
			final String[] splittedCode=_extensionIdCode.split("\\|");
			this.extensionName=splittedCode[0];
			this.extensionNumber=Integer.valueOf(splittedCode[1]);
		}
	}
	public CAEventDetailExtensionId(String _extensionName,int _extensionNumber){
		super();
		this.extensionName=_extensionName;
		this.extensionNumber=_extensionNumber;
	}
	
	
	@Column(name="EXTENSIONNAME", length=16, nullable=false)
	public String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}
	
	@Column(name="EXTENSIONNUMBER", nullable=false)
	public int getExtensionNumber() {
		return extensionNumber;
	}
	public void setExtensionNumber(int extensionNumber) {
		this.extensionNumber = extensionNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean reply=false;
		CAEventDetailExtensionId compared=null;
		
		if(obj instanceof CAEventDetailExtensionId){
			compared=(CAEventDetailExtensionId)obj;
			if((this.getExtensionName()!=null)&&(this.getExtensionName().equals(compared.getExtensionName()))&&(this.getExtensionNumber()==compared.getExtensionNumber()))
				reply=true;
		}
		
		return reply;
	}
	
	@Override
	public int hashCode() {
		
		int reply=0;
		
		reply=(this.getExtensionName()!=null)? this.getExtensionName().hashCode() : 1;
		reply*=1+this.getExtensionNumber();
		
		return reply;
	}	

	public int compareTo(CAEventDetailExtensionId _toCompare){
		
		int reply=0;
		
		if(_toCompare==null)
			return -1;
		if(this!=_toCompare){
			if((this.extensionName==null)||(_toCompare.extensionName==null)){
				reply=(this.extensionName==null)? -1 : 1;
			}else{
				if((reply=this.getExtensionName().compareTo(_toCompare.extensionName))==0){
					if(this.getExtensionNumber()!=_toCompare.getExtensionNumber()){
						reply=(this.getExtensionNumber()<_toCompare.getExtensionNumber())? -1 : 1;
					}
				}
			}
		}
		
		return reply;
	}

	@Override
	public String toString(){
		return String.valueOf(this.extensionName+'|'+this.extensionNumber);
	}
}
