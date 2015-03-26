package com.lynxspa.sdm.entities.events.messages.formats;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


@Entity
@Table(name="TB_CA_MESSAGEFIELDCONFIGS")
public class CAMessageFieldConfig implements UpdatableAdapter {

	private static final long serialVersionUID = 801623175004853727L;

	
	private CAMessageFieldConfigId id=null;
	private String fieldName=null; 
	private int fieldLength=0; 
	private String fieldType=null; 
	private String fieldFormat=null; 
	private String displayGroup=null; 
	private int displayRow=0; 
	private int displayColumn=0; 
	private String description=null;
	private boolean hidden=false;
	private int version=0;
	private UpdateAuditor auditor=null;

	
	public CAMessageFieldConfig(){
		super();
		this.auditor=new UpdateAuditor();
	}
	public CAMessageFieldConfig(String _user,CAMessageType _type,String _path){
		super();
		this.id=new CAMessageFieldConfigId(_type,_path);
		this.auditor=new UpdateAuditor(_user);
	}
	public CAMessageFieldConfig(String _user,CAMessageType _type,CAMessageTypeFieldsDictAdapter _messageFieldConfig){
		super();
		this.id=new CAMessageFieldConfigId(_type,_messageFieldConfig.getPath());
		this.fieldName=_messageFieldConfig.getFieldName();
		this.fieldLength=_messageFieldConfig.getFieldLength();
		this.fieldType=_messageFieldConfig.getFieldType();
		this.fieldFormat=_messageFieldConfig.getFieldFormat();
		this.displayGroup=_messageFieldConfig.getDisplayGroup();
		this.displayRow=_messageFieldConfig.getDisplayRow();
		this.displayColumn=_messageFieldConfig.getDisplayColumn();
		this.description=_messageFieldConfig.getDescription();
		this.hidden=_messageFieldConfig.getHidden();
		this.auditor=new UpdateAuditor(_user);
	}
	
	
	@EmbeddedId
	public CAMessageFieldConfigId getId() {
		return id;
	}
	public void setId(CAMessageFieldConfigId id) {
		this.id = id;
	}
	
	@Column(name="FIELDNAME", length=64, nullable=false)
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name="FIELDLENGTH", nullable=true)
	public int getFieldLength() {
		return fieldLength;
	}
	public void setFieldLength(int fieldlength) {
		this.fieldLength = fieldlength;
	}

	@Column(name="FIELDTYPE", length=32, nullable=false)
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Column(name="FIELDFORMAT", length=32, nullable=true)
	public String getFieldFormat() {
		return fieldFormat;
	}
	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}

	@Column(name="DISPLAYGROUP", length=64, nullable=true)
	public String getDisplayGroup() {
		return displayGroup;
	}
	public void setDisplayGroup(String displayGroup) {
		this.displayGroup = displayGroup;
	}

	@Column(name="DISPLAYROW", nullable=false)
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	@Column(name="DISPLAYCOLUMN", nullable=false)
	public int getDisplayColumn() {
		return displayColumn;
	}
	public void setDisplayColumn(int displayColumn) {
		this.displayColumn = displayColumn;
	}

	@Column(name="DESCRIPTION", length=140, nullable=true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="HIDDEN", nullable=false)
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
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
		return this.auditor;
	}
	public void setAuditor(UpdateAuditor _auditor) {
		this.auditor=_auditor;
	}
}
