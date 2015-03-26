package com.lynxspa.sdm.entities.events.types;

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
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.installer.adapters.events.EventDetailAdapter;



@Entity
@Table(name="TB_CA_EVENTTYPEDETAILS")
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTTYPEDETAILS",indexes={
		@Index(name="IDX_EVTYPEDET_FKEVENTTYPE",columnNames="FKEVENTTYPE"),
		@Index(name="IDX_EVTYPEDET_FIELDPATH",columnNames="FIELDPATH"),
		@Index(name="IDX_EVTYPEDET_ISDISPLAYINTABLE",columnNames="ISDISPLAYINTABLE"),
		@Index(name="IDX_EVTYPEDET_DELETED",columnNames="ISDELETED")
})
public class CAEventTypeDetail implements UpdatableAdapter{

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	private CAEventType eventType=null;
	private String fieldPath=null;
	private String name=null;
	private String fieldType=null;
	private String format=null;
	private int maxLength=0;
	private String displayGroup=null;
	private boolean displayInTable=false;
	private int displayInTableOrder=0;
	private int displayGroupOrder=0;
	private int displayInGroupOrder=0;
	private int displayRow=0;
	private int displayColumn=0;
	private int displayTop=0;
	private int displayLeft=0;
	private String description=null;
	private boolean extension=false;
	private boolean basic=false;
	private boolean hidden=false;
	private boolean editableNormalization=false;
	private int version=0;
	private UpdateAuditor auditor=null;


	public CAEventTypeDetail(){
		this(null,null,null);
	}
	public CAEventTypeDetail(String _user){
		this(_user,null,null);
	}
	public CAEventTypeDetail(String _user,CAEventType _eventType,EventDetailAdapter _eventDetail){
		super();
		this.eventType=_eventType;
		if(_eventDetail!=null){
			this.fieldPath=_eventDetail.getFieldPath();
			this.name=_eventDetail.getName();
			this.fieldType=_eventDetail.getFieldType().getCode();
			this.format=_eventDetail.getFormat();
			this.maxLength=((_eventDetail.getMaxLength()==0)? _eventDetail.getFieldType().getMaxLength() : ((_eventDetail.getMaxLength()>_eventDetail.getFieldType().getMaxLength())? _eventDetail.getFieldType().getMaxLength() : _eventDetail.getMaxLength()));
			this.displayInTable=_eventDetail.isDisplayInTable();
			this.displayInTableOrder=_eventDetail.getDisplayInTableOrder();
			this.displayGroup=_eventDetail.getDisplayGroup();
			this.displayGroupOrder=_eventDetail.getDisplayGroupOrder();
			this.displayInGroupOrder=_eventDetail.getDisplayInGroupOrder();
			this.displayRow=_eventDetail.getDisplayRow();
			this.displayColumn=_eventDetail.getDisplayColumn();
			this.displayTop=_eventDetail.getDisplayTop(); 
			this.displayLeft=_eventDetail.getDisplayLeft();
			this.description=_eventDetail.getDescription();
			this.extension=_eventDetail.isExtension();
			this.hidden=_eventDetail.isHidden();
			this.basic=_eventDetail.isBasic();
			this.editableNormalization=_eventDetail.isEditableNormalization();
		}
		this.auditor=new UpdateAuditor(_user);
	}
	
	
	@Id
	@SequenceGenerator(name="CAEVTYPEDET_GEN", sequenceName="CAEVTYPEDET_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVTYPEDET_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = CAEventType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_DETAIL_EVENTTYPE")
	@JoinColumn(name="FKEVENTTYPE", nullable=false, updatable=false)
	public CAEventType getEventType() {
		return eventType;
	}
	public void setEventType(CAEventType eventType) {
		this.eventType = eventType;
	}
	
	@Column(name="FIELDPATH",length=32, nullable=false)
	public String getFieldPath() {
		return fieldPath;
	}
	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}
	
	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="FIELDTYPE", length=16, nullable=false)
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	@Column(name="FORMAT", length=32, nullable=true)
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	@Column(name="MAXLENGTH", nullable=false)
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	@Column(name="ISDISPLAYINTABLE", nullable=false)
	public boolean isDisplayInTable() {
		return displayInTable;
	}
	public void setDisplayInTable(boolean displayInTable) {
		this.displayInTable = displayInTable;
	}
	
	@Column(name="DISPLAYINTABLEORDER", nullable=false)
	public int getDisplayInTableOrder() {
		return displayInTableOrder;
	}
	public void setDisplayInTableOrder(int displayInTableOrder) {
		this.displayInTableOrder = displayInTableOrder;
	}

	@Column(name="DISPLAYGROUP", length=64, nullable=false)
	public String getDisplayGroup() {
		return displayGroup;
	}
	public void setDisplayGroup(String displayGroup) {
		this.displayGroup = displayGroup;
	}
	
	@Column(name="DISPLAYGROUPORDER", nullable=false)
	public int getDisplayGroupOrder() {
		return displayGroupOrder;
	}
	public void setDisplayGroupOrder(int displayGroupOrder) {
		this.displayGroupOrder = displayGroupOrder;
	}
	
	@Column(name="DISPLAYINGROUPORDER", nullable=true)
	public int getDisplayInGroupOrder() {
		return displayInGroupOrder;
	}
	public void setDisplayInGroupOrder(int displayInGroupOrder) {
		this.displayInGroupOrder = displayInGroupOrder;
	}
	
	@Column(name="DISPLAYROW", nullable=true)
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	
	@Column(name="DISPLAYCOLUMN", nullable=true)
	public int getDisplayColumn() {
		return displayColumn;
	}
	public void setDisplayColumn(int displayColumn) {
		this.displayColumn = displayColumn;
	}

	@Column(name="DISPLAYTOP", nullable=true)
	public int getDisplayTop() {
		return displayTop;
	}
	public void setDisplayTop(int displayTop) {
		this.displayTop = displayTop;
	}
	
	@Column(name="DISPLAYLEFT", nullable=true)
	public int getDisplayLeft() {
		return displayLeft;
	}
	public void setDisplayLeft(int displayLeft) {
		this.displayLeft = displayLeft;
	}
	
	@Column(name="DESCRIPTION",length=256, nullable=true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="ISEXTENSION", nullable=false)
	public boolean isExtension() {
		return extension;
	}
	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	@Column(name="ISHIDDEN", nullable=false)
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	@Column(name="ISBASIC", nullable=false)
	public boolean isBasic() {
		return basic;
	}
	public void setBasic(boolean basic) {
		this.basic = basic;
	}
	
	@Column(name="EDITABLENORMALIZATION", nullable=false)
	public boolean isEditableNormalization(){
		return editableNormalization;
	}
	public void setEditableNormalization(boolean editableNormalization){
		this.editableNormalization=editableNormalization;
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
}
