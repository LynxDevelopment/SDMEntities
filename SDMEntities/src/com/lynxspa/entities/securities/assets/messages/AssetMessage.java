package com.lynxspa.entities.securities.assets.messages;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.messages.adapters.AssetMessageAdapter;
import com.lynxspa.entities.securities.assets.messages.adapters.AssetMessageFieldAdapter;
import com.lynxspa.entities.securities.assets.providers.Provider;

@Entity
@Table(name="TB_SDM_ASSETMESSAGES")
@org.hibernate.annotations.Table(appliesTo="TB_SDM_ASSETMESSAGES",indexes={
		@Index(name="IDX_ASSETMESSAGE_FKASSETTYPE",columnNames="FKASSETTYPE"),
		@Index(name="IDX_ASSETMESSAGE_FKASSET",columnNames="FKASSET"),
		@Index(name="IDX_ASSETMESSAGE_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_ASSETMESSAGE_CRTDATE",columnNames="CRTDATE"),
		@Index(name="IDX_ASSETMESSAGE_MESSAGEID",columnNames="MESSAGEID"),
		@Index(name="IDX_ASSETMESSAGE_ISEXTENSION",columnNames="ISEXTENSION"),
		@Index(name="IDX_ASSETMESSAGE_PROVIDER",columnNames="FKPROVIDER"),
		@Index(name="IDX_ASSETMESSAGE_STATUS",columnNames={"ISENDED","FKSTATE"}),
		@Index(name="IDX_ASSETMESSAGE_SENDTIMESTAMP",columnNames="SENDERTIMESTAMP"),
		@Index(name="IDX_ASSETMESSAGE_ISINPORTFOLIO",columnNames="ISINPORTFOLIO")
})
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="MESSAGECLASS", discriminatorType=DiscriminatorType.STRING, length=32)
@DiscriminatorValue("static.message")
public class AssetMessage implements UpdatableAdapter,OperableAdapter,AssetMessageAdapter{
	
	private static final long serialVersionUID = 7919390348842259341L;
	
	private long id=0l;
	private long normalizedAsset=0l; //El valor de esta columna se rellena cuando el mensaje se ha normalizado y cuando se ha creado el Objeto Asset
	private String originId=null;
	private String originName=null;
	private String originType=null;
	private int originPosition=0;
	private String messageId=null;  //Esta columna debe tener un valor único para evitar duplicidad de mensajes.
									//De momento la candidata seria la combinación: assetType+ISIN+MIC+MONEDA+PROVIDER+YYYYMMDD
	
	private String assetType=null;
	private String sender=null;
	private String receiver=null;
		
	private String securityType=null;
	private String security=null;
	private String securityName=null;
	private String originalMessage=null;
	private boolean extension=false;
	private Date senderTimestamp=null;
	//Pre-normalized attributes
	private boolean mainMarket=false;
	private boolean inCustomerPortfolio=false;
	private AssetType normalizedAssetType=null;
	//private SPVirtualSecurity normalizedSecurity=null;  //Pregunta: Mirar si se rellena esta columna cuando se ha normalizado el mensaje.
	
	private Provider provider=null;
	//Standard attributes
	private int version=0;
	private UpdateAuditor auditor=null;
	private OperationStatus operationStatus=null;
	
	private String operationCode = null;
	private String normalizeOperationCode=null;
	

	private Map<String,? extends AssetMessageFieldAdapter> fields=new HashMap<String,AssetMessageField>();
	
	
	public AssetMessage(){
		this(null);
	}
	public AssetMessage(String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
		this.operationStatus=new OperationStatus();
	}
	
	
	@Id
	@SequenceGenerator(name="SEQ_ASSETMESSAGE_GEN", sequenceName="SEQ_ASSETMESSAGE_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ASSETMESSAGE_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="FKASSET", nullable=true, updatable=true)
	public long getNormalizedAsset() {
		return normalizedAsset;
	}
	public void setNormalizedAsset(long normalizedAsset) {
		this.normalizedAsset = normalizedAsset;
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

	@Column(name="ASSETTYPE",length=64, nullable=true)
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
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
	
	@Column(name="RECEIVER",length=64, nullable=true)
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SENDERTIMESTAMP", nullable=true)
	public Date getSenderTimestamp() {
		return senderTimestamp;
	}
	public void setSenderTimestamp(Date senderTimestamp) {
		this.senderTimestamp = senderTimestamp;
	}
	
	@Lob
	@Column(name="ORIGINALMESSAGE",length=32768, nullable=true)
	public String getOriginalMessage() {
		return originalMessage;
	}
	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}

	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_ASSETMESSAGE_ASSETTYPE")
	@JoinColumn(name="FKASSETTYPE", nullable=true,updatable=true)
	public AssetType getNormalizedAssetType() {
		return normalizedAssetType;
	}
	public void setNormalizedAssetType(AssetType normalizedAssetType) {
		this.normalizedAssetType = normalizedAssetType;
	}

	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@ManyToOne(targetEntity = Provider.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_ASSETMESSAGE_PROVIDER")
	@JoinColumn(name="FKPROVIDER", nullable=true,updatable=true)
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
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
	@Column(name="OPERATIONCODE",length=6, nullable=true)
	public String getOperationCode() {
		return operationCode;
	}
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
	
	@Column(name="NORMOPERATIONCODE",length=6, nullable=true)
	public String getNormalizeOperationCode() {
		return normalizeOperationCode;
	}
	public void setNormalizeOperationCode(String normalizeOperationCode) {
		this.normalizeOperationCode = normalizeOperationCode;
	}
	@OneToMany(targetEntity = AssetMessageField.class, mappedBy="message",fetch=FetchType.LAZY)
	@MapKey(name="path")
	public Map<String,? extends AssetMessageFieldAdapter> getFields() {
		return fields;
	}
	public void setFields(Map<String,? extends AssetMessageFieldAdapter> fields) {
		this.fields = fields;
	}

	@Transient
	@SuppressWarnings("unchecked")
	public void addField(AssetMessageFieldAdapter field) {
		((Map<String,AssetMessageField>)this.fields).put(field.getPath(),(AssetMessageField)field);
	}
	@Transient
	@SuppressWarnings("unchecked")
	public void addField(String _path, String _value) {
		AssetMessageField field=new AssetMessageField(this.getAuditor().getCreationUser(),this,_path,_value);
		((Map<String,AssetMessageField>)this.fields).put(field.getPath(),field);
	}
	@Transient
	public String getField(String _path) {
		
		String reply=null;
		AssetMessageFieldAdapter field=null;
		
		field=this.fields.get(_path);
		if(field!=null)
			reply=field.getValue();
		
		return reply;
	}

}
