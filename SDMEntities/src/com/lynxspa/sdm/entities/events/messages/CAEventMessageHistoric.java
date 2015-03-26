package com.lynxspa.sdm.entities.events.messages;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.application.flow.operations.OperableAdapter;
import com.lynxspa.entities.application.flow.operations.OperationStatus;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageAdapter;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageFieldAdapter;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageType;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;


@Entity
@Table(name="HS_CA_EVENTMESSAGES")
@org.hibernate.annotations.Table(appliesTo="HS_CA_EVENTMESSAGES",indexes={
		@Index(name="IDX_HSEVMESSAGE_FKEVENT",columnNames="FKEVENT"),
		@Index(name="IDX_HSEVMESSAGE_FKFORMAT",columnNames="FKFORMAT"),
		@Index(name="IDX_HSEVMESSAGE_FKEVENTTYPE",columnNames="FKEVENTTYPE"),
		@Index(name="IDX_HSEVMESSAGE_FKSECURITY",columnNames="FKSECURITY"),
		@Index(name="IDX_HSEVMESSAGE_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_HSEVMESSAGE_CRTDATE",columnNames="CRTDATE"),
		@Index(name="IDX_HSEVMESSAGE_EFFECTIVEDATE",columnNames="EFFECTIVEDATE"),
		@Index(name="IDX_HSEVMESSAGE_MESSAGEID",columnNames="MESSAGEID"),
		@Index(name="IDX_HSEVMESSAGE_ISEXTENSION",columnNames="ISEXTENSION"),
		@Index(name="IDX_HSEVMESSAGE_OPERATIONNORM",columnNames="OPERATIONNORM"),
		@Index(name="IDX_HSEVMESSAGE_PROVIDER",columnNames="FKPROVIDER"),
		@Index(name="IDX_HSEVMESSAGE_STATUS",columnNames={"ISENDED","FKSTATE"}),
		@Index(name="IDX_HSEVMESSAGE_SENDTIMESTAMP",columnNames="SENDERTIMESTAMP"),
		@Index(name="IDX_HSEVMESSAGE_ISINPORTFOLIO",columnNames="ISINPORTFOLIO")
})
public class CAEventMessageHistoric implements UpdatableAdapter,OperableAdapter,CAEventMessageAdapter{

	private static final long serialVersionUID = -5080248360737530513L;

	
	private long id=0l;
	private long normalizedEvent=0l;
	private String originId=null;
	private String originName=null;
	private String originType=null;
	private int originPosition=0;
	private String messageId=null;
	private CAMessageType messageType=null;
	private String eventType=null;
	private String operation=null;
	private String sender=null;
	private String receiver=null;
	private String eventReference=null;
	private String eventMessageReference=null;
	private String previousEventMessageReference=null;
	private String securityType=null;
	private String security=null;
	private String securityName=null;
	private Date announceDate=null;
	private Date effectiveDate=null;
	private String account=null;
	private long amount=0l;
	private String originalMessage=null;
	private boolean extension=false;
	private String extensionReference=null;
	private Date senderTimestamp=null;
	//Pre-normalized attributes
	private boolean mainMarket=false;
	private boolean inCustomerPortfolio=false;
	private CAEventType normalizedEventType=null;
	private SPVirtualSecurity normalizedSecurity=null;
	private String normalizedOperation=null;
	private CAExternalEventProvider eventProvider=null;
	//Standard attributes
	private int version=0;
	private UpdateAuditor auditor=null;
	private OperationStatus operationStatus=null;

	private Map<String,? extends CAEventMessageFieldAdapter> fields=new HashMap<String,CAEventMessageFieldHistoric>();
	
	
	public CAEventMessageHistoric(){
		this(null);
	}
	public CAEventMessageHistoric(String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
		this.operationStatus=new OperationStatus();
	}
	
	
	@Id
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="FKEVENT", nullable=true, updatable=true)
	public long getNormalizedEvent() {
		return normalizedEvent;
	}
	public void setNormalizedEvent(long normalizedEvent) {
		this.normalizedEvent = normalizedEvent;
	}
	
	@Column(name="ORIGINID", length=16, nullable=true)
	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	
	@Column(name="ORIGINNAME", length=512, nullable=true)
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	
	@Column(name="ORIGINTYPE", length=64, nullable=true)
	public String getOriginType() {
		return originType;
	}
	public void setOriginType(String originType) {
		this.originType = originType;
	}
	
	@Column(name="ORIGINPOSITION", nullable=true)
	public int getOriginPosition() {
		return originPosition;
	}
	public void setOriginPosition(int originPosition) {
		this.originPosition = originPosition;
	}
	
	@Column(name="MESSAGEID",length=128, nullable=true)
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(targetEntity = CAMessageType.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_HSEVENTMESSAGE_TYPE")
	@JoinColumns({
		@JoinColumn(name="FKFORMAT", referencedColumnName="FKFORMAT"),
		@JoinColumn(name="FKTYPE", referencedColumnName="CODE")
	})
	public CAMessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(CAMessageType messageType) {
		this.messageType = messageType;
	}

	@Column(name="EVENTTYPE",length=64, nullable=true)
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Column(name="OPERATION",length=64, nullable=true)
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name="SENDER",length=64, nullable=true)
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	@Column(name="ISEXTENSION", nullable=true)
	public boolean isExtension() {
		return extension;
	}
	public void setExtension(boolean extension) {
		this.extension = extension;
	}
	
	@Column(name="EXTENSIONREF",length=64, nullable=true)
	public String getExtensionReference() {
		return extensionReference;
	}
	public void setExtensionReference(String extensionReference) {
		this.extensionReference = extensionReference;
	}

	@Column(name="RECEIVER",length=64, nullable=true)
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name="EVENTREFERENCE",length=64, nullable=true)
	public String getEventReference() {
		return eventReference;
	}
	public void setEventReference(String eventReference) {
		this.eventReference = eventReference;
	}

	@Column(name="EVENTMESSGREF",length=64, nullable=true)
	public String getEventMessageReference() {
		return eventMessageReference;
	}
	public void setEventMessageReference(String eventMessageReference) {
		this.eventMessageReference = eventMessageReference;
	}

	@Column(name="PREVEVENTMESSGREF",length=64, nullable=true)
	public String getPreviousEventMessageReference() {
		return previousEventMessageReference;
	}
	public void setPreviousEventMessageReference(String previousEventMessageReference) {
		this.previousEventMessageReference = previousEventMessageReference;
	}

	@Column(name="SECURITYTYPE",length=64, nullable=true)
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	
	@Column(name="SECURITY",length=64, nullable=true)
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}

	@Column(name="SECURITYNAME",length=128, nullable=true)
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="ANNOUNCEDATE", nullable=true)
	public Date getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(Date announceDate) {
		this.announceDate = announceDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="EFFECTIVEDATE", nullable=true)
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SENDERTIMESTAMP", nullable=true)
	public Date getSenderTimestamp() {
		return senderTimestamp;
	}
	public void setSenderTimestamp(Date senderTimestamp) {
		this.senderTimestamp = senderTimestamp;
	}
	
	@Column(name="ACCOUNT", length=64, nullable=true)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	@Column(name="AMOUNT", nullable=true)
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Lob
	@Column(name="ORIGINALMESSAGE",length=32768, nullable=true)
	public String getOriginalMessage() {
		return originalMessage;
	}
	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}
	
	@ManyToOne(targetEntity = CAEventType.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_HSEVENTMESSAGE_EVENTTYPE")
	@JoinColumn(name="FKEVENTTYPE", nullable=true,updatable=true)
	public CAEventType getNormalizedEventType() {
		return normalizedEventType;
	}
	public void setNormalizedEventType(CAEventType normalizedEventType) {
		this.normalizedEventType = normalizedEventType;
	}
	
	@ManyToOne(targetEntity = SPVirtualSecurity.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_HSEVENTMESSAGE_SECURITY")
	@JoinColumn(name="FKSECURITY", nullable=true,updatable=true)
	public SPVirtualSecurity getNormalizedSecurity() {
		return normalizedSecurity;
	}
	public void setNormalizedSecurity(SPVirtualSecurity normalizedSecurity) {
		this.normalizedSecurity = normalizedSecurity;
	}

	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name="OPERATIONNORM",length=6)
	public String getNormalizedOperation() {
		return normalizedOperation;
	}
	public void setNormalizedOperation(String normalizedOperation) {
		this.normalizedOperation = normalizedOperation;
	}
	
	@ManyToOne(targetEntity = CAExternalEventProvider.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_HSEVENTMESSAGE_PROVIDER")
	@JoinColumn(name="FKPROVIDER", nullable=true,updatable=true)
	public CAExternalEventProvider getEventProvider() {
		return eventProvider;
	}
	public void setEventProvider(CAExternalEventProvider eventProvider) {
		this.eventProvider = eventProvider;
	}
	
	@Column(name="ISMAINMARKET")
	public boolean isMainMarket() {
		return mainMarket;
	}
	public void setMainMarket(boolean mainMarket) {
		this.mainMarket = mainMarket;
	}
	
	@Column(name="ISINPORTFOLIO")
	public boolean isInCustomerPortfolio() {
		return inCustomerPortfolio;
	}
	public void setInCustomerPortfolio(boolean inCustomerPortfolio) {
		this.inCustomerPortfolio = inCustomerPortfolio;
	}
	
	@Embedded
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	
	@Embedded
	public UpdateAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(UpdateAuditor _auditor) {
		this.auditor=_auditor;
	}

	@OneToMany(targetEntity = CAEventMessageFieldHistoric.class, mappedBy="message",fetch=FetchType.LAZY)
	@MapKey(name="path")
	public Map<String,? extends CAEventMessageFieldAdapter> getFields() {
		return fields;
	}
	public void setFields(Map<String,? extends CAEventMessageFieldAdapter> fields) {
		this.fields = fields;
	}
	@Transient
	@SuppressWarnings("unchecked")
	public void addField(CAEventMessageFieldAdapter field) {
		((Map<String,CAEventMessageFieldHistoric>)this.fields).put(field.getPath(), (CAEventMessageFieldHistoric)field);
	}
	@Transient
	@SuppressWarnings("unchecked")
	public void addField(String _path, String _value) {
		CAEventMessageFieldHistoric field=new CAEventMessageFieldHistoric(this.getAuditor().getCreationUser(),this,_path,_value);
		((Map<String,CAEventMessageFieldHistoric>)this.fields).put(field.getPath(),field);
	}
	@Transient
	public String getField(String _path) {
		
		String reply=null;
		CAEventMessageFieldAdapter field=null;
		
		field=this.fields.get(_path);
		if(field!=null)
			reply=field.getValue();
		
		return reply;
	}

	@Transient
	public String toString(){
		
		String reply="CAEventMessageHistoric:\n";
		
		reply+="id="+String.valueOf(this.id)+"\n";
		reply+="originId="+String.valueOf(this.originId)+"\n";
		reply+="originName="+String.valueOf(this.originName)+"\n";
		reply+="originType="+String.valueOf(this.originType)+"\n";
		reply+="originPosition="+String.valueOf(this.originPosition)+"\n";
		reply+="messageId="+String.valueOf(this.messageId)+"\n";
		reply+="messageType="+String.valueOf(this.messageType)+"\n";
		reply+="operation="+String.valueOf(this.operation)+"\n";
		reply+="sender="+String.valueOf(this.sender)+"\n";
		reply+="receiver="+String.valueOf(this.receiver)+"\n";
		reply+="securityType="+String.valueOf(this.securityType)+"\n";
		reply+="security="+String.valueOf(this.security)+"\n";
		reply+="announceDate="+String.valueOf(this.announceDate)+"\n";
		reply+="effectiveDate="+String.valueOf(this.effectiveDate)+"\n";
		reply+="account="+String.valueOf(this.account)+"\n";
		reply+="amount="+String.valueOf(this.amount)+"\n";
		reply+="normalizedEvent="+String.valueOf(this.normalizedEvent)+"\n";

		return reply;
	}
}
