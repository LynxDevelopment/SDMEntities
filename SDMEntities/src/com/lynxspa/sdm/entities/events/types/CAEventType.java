package com.lynxspa.sdm.entities.events.types;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.sdm.dictionaries.CAType;

@Entity
@Table(name="TB_CA_EVENTTYPES")
public class CAEventType implements InsertableAdapter{

	private static final long serialVersionUID = -5787836312337800537L;
	
	private String id=null;
	private String name=null;
	private boolean optional=false;
	private String description=null;
	private InsertAuditor auditor=null;


	public CAEventType(){
		this(null,null);
	}
	public CAEventType(String _user){
		this(_user,null);
	}
	public CAEventType(String _user,CAType _type){
		super();
		if(_type!=null){
			this.id=_type.getCode();
			this.name=_type.getName();
			this.description=_type.getDescription();
			this.optional=_type.getOptional();
		}
		this.auditor=new InsertAuditor(_user);
	}

	
	@Id
	@Column(name="ID", length=4, nullable=false, updatable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="NAME", length=64, nullable=false, updatable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ISOPTIONAL", nullable=false, updatable=false)
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	@Column(name="DESCRIPTION",length=256, nullable=true, updatable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}
}
