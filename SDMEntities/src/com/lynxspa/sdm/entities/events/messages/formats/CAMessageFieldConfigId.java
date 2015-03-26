package com.lynxspa.sdm.entities.events.messages.formats;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;


@Embeddable
public class CAMessageFieldConfigId implements Serializable {

	private static final long serialVersionUID = -4421614319901668245L;
	
	
	private CAMessageType type=null;
	private String path=null;
	
	
	public CAMessageFieldConfigId(){
		this(null,null);
	}
	public CAMessageFieldConfigId(CAMessageType _type,String _path){
		super();
		this.type=_type;
		this.path=_path;
	}
	
	
	@ManyToOne(targetEntity = CAMessageType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_FIELD_TYPE")
	@JoinColumns({
		@JoinColumn(name="FKFORMAT", referencedColumnName="FKFORMAT", nullable=false, updatable=false),
		@JoinColumn(name="FKTYPE", referencedColumnName="CODE", nullable=false, updatable=false)
	})
	public CAMessageType getType() {
		return type;
	}
	public void setType(CAMessageType type) {
		this.type = type;
	}
	
	@Column(name="PATH", length=128, nullable=false, updatable=false)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean reply=false;
		CAMessageFieldConfigId compared=null;
		
		if(obj instanceof CAMessageFieldConfigId){
			compared=(CAMessageFieldConfigId)obj;
			if((this.getType()!=null)&&(this.getPath()!=null)&&(this.getType().equals(compared.getType()))&&(this.getPath().equals(compared.getPath())))
				reply=true;
		}
		
		return reply;
	}
	
	@Override
	public int hashCode() {
		
		int reply=0;
		
		reply=(this.getType()!=null)? this.getType().hashCode() : 1;
		reply*=(this.getPath()!=null)? this.getPath().hashCode() : 1;
		
		return reply;
	}	

}
