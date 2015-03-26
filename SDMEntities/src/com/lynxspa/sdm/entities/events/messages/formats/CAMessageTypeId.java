package com.lynxspa.sdm.entities.events.messages.formats;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;


@Embeddable
public class CAMessageTypeId implements Serializable {

	private static final long serialVersionUID = -2219969651539106396L;
	
	
	private CAMessageFormat format=null;
	private String code=null;
	
	
	public CAMessageTypeId(){
		this(null,null);
	}
	public CAMessageTypeId(CAMessageFormat _format,String _code){
		super();
		this.format=_format;
		this.code=_code;
	}
	
	
	@ManyToOne(targetEntity = CAMessageFormat.class,fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@ForeignKey(name="FK_TYPE_FORMAT")
	@JoinColumn(name="FKFORMAT", nullable=false, updatable=false)
	public CAMessageFormat getFormat() {
		return format;
	}
	public void setFormat(CAMessageFormat format) {
		this.format = format;
	}
	
	@Column(name="CODE", length=16, nullable=false, updatable=false)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean reply=false;
		CAMessageTypeId compared=null;
		
		if(obj instanceof CAMessageTypeId){
			compared=(CAMessageTypeId)obj;
			if((this.getFormat()!=null)&&(this.getCode()!=null)&&(this.getFormat().equals(compared.getFormat()))&&(this.getCode().equals(compared.getCode())))
				reply=true;
		}
		
		return reply;
	}
	
	@Override
	public int hashCode() {
		
		int reply=0;
		
		reply=(this.getFormat()!=null)? this.getFormat().hashCode() : 1;
		reply*=(this.getCode()!=null)? this.getCode().hashCode() : 1;
		
		return reply;
	}	
}
