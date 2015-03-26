package com.lynxspa.sdm.entities.alerts;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;

@Entity
@Table (name="TB_CA_ALERTS")
public class CAAlertsProvider implements UpdatableAdapter {

	private static final long serialVersionUID = -5311564462186431877L;
	
	private long id=0l;
	private String query = null;
	private String label = null;
	private String graph = null;
	private String userRole = null;
	private String link = null;
	private String description = null;
	private UpdateAuditor auditor=null;
	private int version=0;
	
	public CAAlertsProvider(){
		super();
		this.auditor=new UpdateAuditor();
	}
	
	public CAAlertsProvider(String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
	}
	
	public CAAlertsProvider(String _user, String _query, String _label, String _graph
			, String _userRole, String _link, String _description){
		super();
		this.query = _query;
		this.label = _label;
		this.graph = _graph;
		this.userRole = _userRole;
		this.link = _link;
		this.description = _description;
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="CAALERTS_GEN", sequenceName="CAALERTS_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAALERTS_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="QUERY", length=256, nullable=false, updatable=false)
	public String getQuery() {
		return query;
	}

	public void setQuery(String _query) {
		this.query = _query;
	}

	@Column(name="LABEL", length=256, nullable=false, updatable=false)
	public String getLabel() {
		return label;
	}

	public void setLabel(String _label) {
		this.label = _label;
	}

	@Column(name="GRAPH", length=1, nullable=false, updatable=false)
	public String getGraph() {
		return graph;
	}

	public void setGraph(String _graph) {
		this.graph = _graph;
	}

	@Column(name="USER_ROLE", length=2, nullable=false, updatable=true)
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String _userRole) {
		this.userRole = _userRole;
	}

	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}

	public void setVersion(int _version) {
		this.version = _version;		
	}

	@Column(name="LINK", length=128, nullable=true, updatable=true)
	public String getLink() {
		return link;
	}

	public void setLink(String _link) {
		this.link = _link;
	}

	@Column(name="DESCRIPTION", length=256, nullable=false, updatable=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String _description) {
		this.description = _description;
	}

	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}

	public void setAuditor(UpdateAuditor _auditor) {
		this.auditor = _auditor;
	}
}
