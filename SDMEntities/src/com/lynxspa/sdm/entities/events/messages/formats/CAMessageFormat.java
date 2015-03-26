package com.lynxspa.sdm.entities.events.messages.formats;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.domains.CADomainClusterFormat;
import com.lynxspa.sdm.installer.adapters.formats.CAFormatDictAdapter;


@Entity
@Table(name="TB_CA_MESSAGEFORMATS")
@org.hibernate.annotations.Table(appliesTo="TB_CA_MESSAGEFORMATS",indexes={
		@Index(name="IDX_MESGFORMAT_DELETED",columnNames="ISDELETED")
})
public class CAMessageFormat implements UpdatableAdapter {

	private static final long serialVersionUID = -6853840498318838977L;

	
	private String id=null;
	private String name=null;
	private String path=null;
	private String pattern=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	
	private List<CAMessageType> messageTypes=new ArrayList<CAMessageType>();
	private List<CADomainClusterFormat> domainClusters=new ArrayList<CADomainClusterFormat>();
	
	
	public CAMessageFormat(){
		this(null,null,null,null,null);
	}
	public CAMessageFormat(String _user,String _id){
		this(_user,_id,null,null,null);
	}
	public CAMessageFormat(String _user,CAFormatDictAdapter _format){
		this(_user,_format.getCode(),_format.getName(),_format.getPath(),_format.getPattern());
	}
	public CAMessageFormat(String _user,String _id,String _name,String _path,String _pattern){
		super();
		this.id=_id;
		this.name=_name;
		this.path=_path;
		this.pattern=_pattern;
		this.auditor=new UpdateAuditor(_user);
	}
	
	
	@Id
	@Column(name="ID", length=16, nullable=false, updatable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="PATH", length=128, nullable=false)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name="PATTERN", length=64, nullable=false)
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	@Embedded
	public UpdateAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(UpdateAuditor _auditor) {
		this.auditor=_auditor;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@OneToMany(targetEntity = CAMessageType.class, mappedBy="id.format",fetch=FetchType.LAZY)
	public List<CAMessageType> getMessageTypes() {
		return messageTypes;
	}
	public void setMessageTypes(List<CAMessageType> messageTypes) {
		this.messageTypes = messageTypes;
	}
	
	@OneToMany(targetEntity = CADomainClusterFormat.class, mappedBy="id.format",fetch=FetchType.LAZY)
	public List<CADomainClusterFormat> getDomainClusters() {
		return domainClusters;
	}
	public void setDomainClusters(List<CADomainClusterFormat> domainClusters) {
		this.domainClusters = domainClusters;
	}
}
