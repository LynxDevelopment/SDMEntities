package com.lynxspa.entities.securities.assets.messages;

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
import com.lynxspa.entities.securities.assets.messages.adapters.AssetMessageAdapter;
import com.lynxspa.entities.securities.assets.messages.adapters.AssetMessageFieldAdapter;


@Entity
@Table(name="TB_SDM_ASSETMESSAGEFIELDS")
@org.hibernate.annotations.Table(appliesTo="TB_SDM_ASSETMESSAGEFIELDS",indexes={
		@Index(name="IDX_EVMESGFLD_FKASSETMESSAGE",columnNames="FKASSETMESSAGE")
})

public class AssetMessageField implements InsertableAdapter, AssetMessageFieldAdapter{

	private static final long serialVersionUID = 3827494125661070502L;

	private static final int SHORT=16;
	private static final int LONG=128;
	private static final int VERYLONG=256;
	private static final int CLOB=10000;
	
	
	private long id=0l;
	private AssetMessageAdapter message=null;
	private int type=AssetMessageField.SHORT;
	private String path=null;
	private String valueShort=null;
	private String valueLong=null;
	private String valueVeryLong=null;
	private String valueClob=null;
	private AssetMessageFieldConfig config=null;
	private InsertAuditor auditor=null;

	
	public AssetMessageField(){
		this(null,null,null,null);
	}
	public AssetMessageField(String _user,String _path,String _value){
		this(_user,null,_path,_value);
	}
	public AssetMessageField(String _user,AssetMessage _message,String _path,String _value){
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
	
	@ManyToOne(targetEntity = AssetMessage.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETFIELD_MESSAGE")
	@JoinColumn(name="FKASSETMESSAGE", nullable=false, updatable=false)
	public AssetMessageAdapter getMessage() {
		return message;
	}
	public void setMessage(AssetMessageAdapter message) {
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
			case AssetMessageField.SHORT: 	reply=this.getValueShort();
												break;
			case AssetMessageField.LONG: 		reply=this.getValueLong();
												break;
			case AssetMessageField.VERYLONG: 	reply=this.getValueVeryLong();
												break;
			case AssetMessageField.CLOB: 		reply=this.getValueClob();
												break;
		}
		
		return reply;
	}
	@Transient
	public void setValue(String value) {

		if(value!=null){
			if(value.length()<=AssetMessageField.SHORT){
				this.setType(AssetMessageField.SHORT);
				this.setValueShort(value);	
			}else{
				if(value.length()<=AssetMessageField.LONG){
					this.setType(AssetMessageField.LONG);
					this.setValueLong(value);
				}else{
					if(value.length()<=AssetMessageField.VERYLONG){
						this.setType(AssetMessageField.VERYLONG);
						this.setValueVeryLong(value);
					}else{
						this.setType(AssetMessageField.CLOB);
						this.setValueClob(value);
					}
				}
			}
		}
	}

	@Transient
	public AssetMessageFieldConfig getConfig() {
		return config;
	}
	public void setConfig(AssetMessageFieldConfig config) {
		this.config = config;
	}

}
