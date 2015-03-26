package com.lynxspa.entities.securities.financialassets;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;

@Entity
@Table(name="TB_SP_SECURITY_FASSETS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_FASSETS",indexes={
		@Index(name="IDX_SECURITYFA_NAME",columnNames="NAME")
})
public class SPSecurityFinancialAssets implements InsertableAdapter{

	private static final long serialVersionUID = 7900715735790575724L;
	private String id=null;
	private String name=null;
	private InsertAuditor auditor=null;
	
	public SPSecurityFinancialAssets() {
	}
	
	public SPSecurityFinancialAssets(String _user, String _id, String _name) {
		super();
		this.id = _id;
		this.name = _name;
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

	@Column(name="NAME", length=64, nullable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
	
		return ToStringBuilder.reflectionToString(this);
	}
	

	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}

}
