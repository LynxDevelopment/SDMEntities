package com.lynxspa.sdm.entities.domains;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.application.domains.DomainCluster;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;


@Embeddable
public class CADomainClusterFormatId implements Serializable{
	
	private static final long serialVersionUID = -4562284249375035158L;

	private DomainCluster domainCluster=null;
	private CAMessageFormat format=null;

	
	public CADomainClusterFormatId() {
		super();
	}
	public CADomainClusterFormatId(DomainCluster _domainCluster,CAMessageFormat _format) {
		super();
		this.domainCluster=_domainCluster;
		this.format=_format;
	}

	@ManyToOne(targetEntity = DomainCluster.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_DOMCLSFORM_CLUSTER")
	@JoinColumns({
		@JoinColumn(name="FKAPPLICATION", referencedColumnName="FKAPPLICATION",nullable=false),
		@JoinColumn(name="FKDOMAIN", referencedColumnName="FKDOMAIN",nullable=false),
		@JoinColumn(name="FKDOMAINCLUSTER", referencedColumnName="CODE",nullable=false)
	})
	public DomainCluster getDomainCluster() {
		return domainCluster;
	}
	public void setDomainCluster(DomainCluster _domainCluster) {
		this.domainCluster=_domainCluster;
	}
	
	@ManyToOne(targetEntity = CAMessageFormat.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_DOMCLSFORM_FORMAT",inverseName="ID")
	@JoinColumn(name="FKMESSAGEFORMAT", insertable=false, updatable=false,nullable=false)
	public CAMessageFormat getFormat() {
		return format;
	}
	public void setFormat(CAMessageFormat _format) {
		this.format=_format;
	}

		
	@Override
	public boolean equals(Object obj) {
		
		boolean reply=false;
		CADomainClusterFormatId comparedId=null;
		
		if(obj instanceof CADomainClusterFormatId){
			comparedId=(CADomainClusterFormatId)obj;
			if((this.getDomainCluster()!=null)&&(this.getFormat()!=null)&&(this.getDomainCluster().equals(comparedId.getDomainCluster()))&&(this.getFormat().equals(comparedId.getFormat())))
				reply=true;
		}
		
		return reply;
	}
		
	@Override
	public int hashCode() {
			
		int reply=0;
			
		reply=(this.getDomainCluster()!=null)? this.getDomainCluster().hashCode() : 1;
		reply*=(this.getFormat()!=null)? this.getFormat().hashCode() : 1;
			
		return reply;
	}
}
