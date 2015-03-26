package com.lynxspa.sdm.entities.events.answers;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;

@Entity
@Table(name="TB_CA_ANSWERTYPES")
public class CAAnswerType implements InsertableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7858458767974259276L;
	
	private String id=null;
	private String name=null;
	private String description=null;
	private InsertAuditor auditor=null;

	public CAAnswerType (){
		
	}
	
	public CAAnswerType(String _user,String  _code, String _name, String _description) {
		super();
		this.id=_code;
		this.name=_name;
		this.description=_description;
		this.auditor=new InsertAuditor(_user);
	}
	
	@Id
	@Column(name="ID", length=16, nullable=false, updatable=false)
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
