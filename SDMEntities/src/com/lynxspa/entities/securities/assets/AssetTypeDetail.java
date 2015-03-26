package com.lynxspa.entities.securities.assets;

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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.jobs.SDMEnterprise;
import com.lynxspa.entities.securities.assets.adapters.AssetTypeDetailAdapter;


@Entity
@Table(name="TB_SDM_ASSETTYPE_DETAILS")
@org.hibernate.annotations.Table(appliesTo="TB_SDM_ASSETTYPE_DETAILS",indexes={
		@Index(name="IDX_ASSETTYPEDETAIL_NAME",columnNames="NAME"),
		@Index(name="IDX_ASSETTYPEDETAIL_ASSETTYPE",columnNames="FKASSETTYPE"),
		@Index(name="IDX_ASSETTYPEDETAIL_NATURE",columnNames="NATURE"),
})
public class AssetTypeDetail implements UpdatableAdapter {

	private static final long serialVersionUID = 2855721721354164181L;
	private long id=0l;
	private AssetType assetType=null;
	private SDMEnterprise enterprise=null;
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
	private int version=0;
	private UpdateAuditor auditor=null;
	private boolean store=false;
	private String nature=null; //Indicate if is static or dinamic nature data
	private boolean editable=false;
	private boolean filter=false;
	private boolean editableNormalization=false;
	
	
	public AssetTypeDetail() {
	}

	public AssetTypeDetail(String _user, AssetType _assetType, AssetTypeDetailAdapter _assetTypeDetail) {
		super();
		this.assetType=_assetType;
		if(_assetTypeDetail!=null){
			this.fieldPath=_assetTypeDetail.getFieldPath();
			this.name=_assetTypeDetail.getName();
			this.fieldType=_assetTypeDetail.getFieldType().getCode();
			this.format=_assetTypeDetail.getFormat();
			this.maxLength=((_assetTypeDetail.getMaxLength()==0)? _assetTypeDetail.getFieldType().getMaxLength() : ((_assetTypeDetail.getMaxLength()>_assetTypeDetail.getFieldType().getMaxLength())? _assetTypeDetail.getFieldType().getMaxLength() : _assetTypeDetail.getMaxLength()));
			this.displayInTable=_assetTypeDetail.isDisplayInTable();
			this.displayInTableOrder=_assetTypeDetail.getDisplayInTableOrder();
			this.displayGroup=_assetTypeDetail.getDisplayGroup();
			this.displayGroupOrder=_assetTypeDetail.getDisplayGroupOrder();
			this.displayInGroupOrder=_assetTypeDetail.getDisplayInGroupOrder();
			this.displayRow=_assetTypeDetail.getDisplayRow();
			this.displayColumn=_assetTypeDetail.getDisplayColumn();
			this.displayTop=_assetTypeDetail.getDisplayTop(); 
			this.displayLeft=_assetTypeDetail.getDisplayLeft();
			this.description=_assetTypeDetail.getDescription();
			this.extension=_assetTypeDetail.isExtension();
			this.hidden=_assetTypeDetail.isHidden();
			this.store = _assetTypeDetail.isStore();
			this.nature = _assetTypeDetail.getNature();
			this.editable =_assetTypeDetail.isEditable();
			this.filter=_assetTypeDetail.isFilter();
			this.editableNormalization=_assetTypeDetail.isEditableNormalization();
		}
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="SEQ_ASSETTYPE_DETAIL_GEN", sequenceName="SEQ_ASSETTYPE_DETAIL_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ASSETTYPE_DETAIL_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = AssetType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETTYPEDETAIL_ASSETTYPE")
	@JoinColumn(name="FKASSETTYPE", nullable=false, updatable=false)
	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType _assetType) {
		this.assetType = _assetType;
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
	
	
	@Column(name="ISSTORE",nullable=false)
	public boolean isStore() {
		return store;
	}

	public void setStore(boolean store) {
		this.store = store;
	}

	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor _auditor) {
		this.auditor = _auditor;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="NATURE",length=1, nullable=true)
	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@ManyToOne(targetEntity = SDMEnterprise.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ASSETTYPEDETAIL_ENTERPRISE")
	@JoinColumn(name="FKENTERPRISE", nullable=true, updatable=false)
	public SDMEnterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(SDMEnterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Column(name="ISEDITABLE", nullable=false)
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Column(name="ISFILTER", nullable=false)
	public boolean isFilter() {
		return filter;
	}
	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	@Column(name="ISEDITABLENORMALIZATION", nullable=false)
	public boolean isEditableNormalization() {
		return editableNormalization;
	}

	public void setEditableNormalization(boolean editableNormalization) {
		this.editableNormalization = editableNormalization;
	}

	
	
}
