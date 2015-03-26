package com.lynxspa.sdm.entities.domains;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;


@Entity
@Table(name="TB_CA_DOMAINCLUSTERFORMATS")
public class CADomainClusterFormat implements InsertableAdapter{
	
	private static final long serialVersionUID = -4562284249375035158L;


	private CADomainClusterFormatId id=null;
	private InsertAuditor auditor=null;

	
	public CADomainClusterFormat() {
		super();
		this.auditor=new InsertAuditor();
	}
	public CADomainClusterFormat(String _user,DomainCluster _domainCluster,CAMessageFormat _format) {
		super();
		this.id=new CADomainClusterFormatId(_domainCluster,_format);
		this.auditor=new InsertAuditor(_user);
	}
	
	
	@EmbeddedId
	public CADomainClusterFormatId getId() {
		return id;
	}
	public void setId(CADomainClusterFormatId _id) {
		this.id=_id;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}
}
