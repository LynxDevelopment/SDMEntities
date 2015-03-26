package com.lynxspa.sdm.entities.events.messages.formats;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;


@Entity
@Table(name="TB_CA_MESSAGETYPES")
public class CAMessageType implements InsertableAdapter {

	private static final long serialVersionUID = 7459870748328770896L;
	
	
	private CAMessageTypeId id=null;
	private String name=null;
	private InsertAuditor auditor=null;
	
	List<CAMessageFieldConfig> messageFieldConfigs=new ArrayList<CAMessageFieldConfig>();
	
	
	public CAMessageType(){
		this(null,null,null,null);
	}
	public CAMessageType(String _user,CAMessageFormat _format,String _code){
		this(_user,_format,_code,null);
	}
	public CAMessageType(String _user,CAMessageFormat _format,String _code,String _name){
		super();
		this.id=new CAMessageTypeId(_format,_code);
		this.name=_name;
		this.auditor=new InsertAuditor(_user);
	}
	
	
	@EmbeddedId
	public CAMessageTypeId getId() {
		return id;
	}
	public void setId(CAMessageTypeId id) {
		this.id = id;
	}

	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}

	@OneToMany(targetEntity = CAMessageFieldConfig.class, mappedBy="id.type",fetch=FetchType.LAZY)
	public List<CAMessageFieldConfig> getMessageFieldConfigs() {
		return messageFieldConfigs;
	}
	public void setMessageFieldConfigs(List<CAMessageFieldConfig> messageFieldConfigs) {
		this.messageFieldConfigs = messageFieldConfigs;
	}
}
