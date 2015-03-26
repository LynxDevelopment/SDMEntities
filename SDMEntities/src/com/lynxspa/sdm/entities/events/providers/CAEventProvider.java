package com.lynxspa.sdm.entities.events.providers;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;


@Entity
@Table(name="TB_CA_EVENTPROVIDERS") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EVENTPROVCLASS", discriminatorType=DiscriminatorType.STRING, length=16)
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTPROVIDERS",indexes={
		@Index(name="IDX_EVPROVIDER_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_EVPROVIDER_EVENTPROVCLASS",columnNames="EVENTPROVCLASS")
})
public abstract class CAEventProvider implements UpdatableAdapter{

	private String id=null;
	private String name=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	protected int weight=0;

	
	public CAEventProvider(){
		this(null,null,null);
	}
	public CAEventProvider(String _user,String _id){
		this(_user,_id,null);
	}
	public CAEventProvider(String _user,String _id,String _name){
		super();
		this.id=_id;
		this.name=_name;
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
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Transient
	public boolean isHeavier(CAEventProvider _eventProvider){
		return this.weight<_eventProvider.weight;
	}
}
