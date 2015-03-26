package com.lynxspa.sdm.entities.events.providers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFormat;


@Entity
@Table(name="TB_CA_FORMATPROVIDERS")
@org.hibernate.annotations.Table(appliesTo="TB_CA_FORMATPROVIDERS",indexes={
	@Index(name="IDX_FORMATPROV_FKFORMAT",columnNames={"FKMESSAGEFORMAT","IDATMESSAGE"}),
	@Index(name="IDX_FORMATPROV_FKPROVIDER",columnNames="FKEVENTPROVIDER")
})
public class CAFormatProvider implements Serializable,InsertableAdapter {

	private static final long serialVersionUID = -741825041928820202L;

	
	private long id=0l;
	private String idAtMessage=null;
	private CAExternalEventProvider eventProvider=null;
	private CAMessageFormat messageFormat=null;
	private InsertAuditor auditor=null;

	
	public CAFormatProvider(){
		this(null,null,null,null);
	}
	public CAFormatProvider(String _user,CAMessageFormat _messageFormat,CAExternalEventProvider _eventProvider){
		this(_user,_messageFormat,_messageFormat.getId(),_eventProvider);
	}
	public CAFormatProvider(String _user,CAMessageFormat _messageFormat,String _idAtMessage,CAExternalEventProvider _eventProvider){
		super();
		this.idAtMessage=_idAtMessage;
		this.messageFormat=_messageFormat;
		this.eventProvider=_eventProvider;
		this.auditor=new InsertAuditor(_user);
	}

	
	@Id
	@SequenceGenerator(name="CAFORMATPROV_GEN", sequenceName="CAFORMATPROV_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAFORMATPROV_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="IDATMESSAGE",length=16, nullable=false)
	public String getIdAtMessage() {
		return idAtMessage;
	}
	public void setIdAtMessage(String idAtMessage) {
		this.idAtMessage = idAtMessage;
	}
	
	@ManyToOne(targetEntity = CAMessageFormat.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_FORMATPROV_FORMAT")
	@JoinColumn(name="FKMESSAGEFORMAT", nullable=false, updatable=false)
	public CAMessageFormat getMessageFormat() {
		return messageFormat;
	}
	public void setMessageFormat(CAMessageFormat messageFormat) {
		this.messageFormat = messageFormat;
	}
	
	@ManyToOne(targetEntity = CAExternalEventProvider.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_FORMATPROV_PROVIDER")
	@JoinColumn(name="FKEVENTPROVIDER", nullable=false, updatable=false)
	public CAExternalEventProvider getEventProvider() {
		return eventProvider;
	}
	public void setEventProvider(CAExternalEventProvider eventProvider) {
		this.eventProvider = eventProvider;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}
}
