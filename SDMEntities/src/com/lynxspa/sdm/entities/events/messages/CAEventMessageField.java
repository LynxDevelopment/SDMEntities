package com.lynxspa.sdm.entities.events.messages;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.InsertAuditor;
import com.lynxspa.entities.InsertableAdapter;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageAdapter;
import com.lynxspa.sdm.entities.events.messages.adapters.CAEventMessageFieldAdapter;
import com.lynxspa.sdm.entities.events.messages.formats.CAMessageFieldConfig;


@Entity
@Table(name="TB_CA_EVENTMESSAGEFIELDS")
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTMESSAGEFIELDS",indexes={
		@Index(name="IDX_EVMESGFLD_FKEVENTMESSAGE",columnNames="FKEVENTMESSAGE")
})
public class CAEventMessageField implements InsertableAdapter, CAEventMessageFieldAdapter{

	private static final long serialVersionUID = 3827494125661070502L;

	private static final int SHORT=16;
	private static final int LONG=128;
	private static final int VERYLONG=256;
	private static final int CLOB=10000;
	
	
	private long id=0l;
	private CAEventMessageAdapter message=null;
	private int type=CAEventMessageField.SHORT;
	private String path=null;
	private String valueShort=null;
	private String valueLong=null;
	private String valueVeryLong=null;
	private String valueClob=null;
	private CAMessageFieldConfig config=null;
	private InsertAuditor auditor=null;

	
	public CAEventMessageField(){
		this(null,null,null,null);
	}
	public CAEventMessageField(String _user,String _path,String _value){
		this(_user,null,_path,_value);
	}
	public CAEventMessageField(String _user,CAEventMessage _message,String _path,String _value){
		super();
		this.message=_message;
		this.path=_path;
		setValue(_value);
		this.auditor=new InsertAuditor(_user);
	}
	
	
	@Id
	@SequenceGenerator(name="CAEVMESSFLD_GEN", sequenceName="CAEVMESSFLD_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVMESSFLD_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventMessage.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_EVENTFIELD_MESSAGE")
	@JoinColumn(name="FKEVENTMESSAGE", nullable=false, updatable=false)
	public CAEventMessageAdapter getMessage() {
		return message;
	}
	public void setMessage(CAEventMessageAdapter message) {
		this.message = message;
	}

	@Column(name="FIELDTYPE", nullable=false, updatable=false)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Column(name="PATH", length=128, nullable=false, updatable=false)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name="VALUESHORT", length=16, nullable=true, updatable=false)
	public String getValueShort() {
		return valueShort;
	}
	public void setValueShort(String valueShort) {
		this.valueShort = valueShort;
	}
	
	@Column(name="VALUELONG", length=128, nullable=true, updatable=false)
	public String getValueLong() {
		return valueLong;
	}
	public void setValueLong(String valueLong) {
		this.valueLong = valueLong;
	}
	
	@Column(name="VALUEVERYLONG", length=256, nullable=true, updatable=false)
	public String getValueVeryLong() {
		return valueVeryLong;
	}
	public void setValueVeryLong(String valueVeryLong) {
		this.valueVeryLong = valueVeryLong;
	}
	
	@Lob
	@Column(length=32768)
	public String getValueClob() {
		return valueClob;
	}
	public void setValueClob(String valueClob) {
		this.valueClob = valueClob;
	}
	
	@Embedded
	public InsertAuditor getAuditor() {
		return this.auditor;
	}
	public void setAuditor(InsertAuditor _auditor) {
		this.auditor=_auditor;
	}
	
	@Transient
	public String getValue() {

		String reply=null;
		
		switch(this.type){
			case CAEventMessageField.SHORT: 	reply=this.getValueShort();
												break;
			case CAEventMessageField.LONG: 		reply=this.getValueLong();
												break;
			case CAEventMessageField.VERYLONG: 	reply=this.getValueVeryLong();
												break;
			case CAEventMessageField.CLOB: 		reply=this.getValueClob();
												break;
		}
		
		return reply;
	}
	@Transient
	public void setValue(String value) {

		if(value!=null){
			if(value.length()<=CAEventMessageField.SHORT){
				this.setType(CAEventMessageField.SHORT);
				this.setValueShort(value);	
			}else{
				if(value.length()<=CAEventMessageField.LONG){
					this.setType(CAEventMessageField.LONG);
					this.setValueLong(value);
				}else{
					if(value.length()<=CAEventMessageField.VERYLONG){
						this.setType(CAEventMessageField.VERYLONG);
						this.setValueVeryLong(value);
					}else{
						this.setType(CAEventMessageField.CLOB);
						this.setValueClob(value);
					}
				}
			}
		}
	}

	@Transient
	public CAMessageFieldConfig getConfig() {
		return config;
	}
	public void setConfig(CAMessageFieldConfig config) {
		this.config = config;
	}
}
