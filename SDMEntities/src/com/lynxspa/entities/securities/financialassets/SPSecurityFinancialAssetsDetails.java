package com.lynxspa.entities.securities.financialassets;

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
import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;

@Entity
@Table(name="TB_SP_SECURITY_FASSETS_DETAILS")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_FASSETS_DETAILS",indexes={
		@Index(name="IDX_SECURITYFADET_NAME",columnNames="NAME"),
		@Index(name="IDX_SECURITYFADET_FA",columnNames="FKSECURITYFA")
})
public class SPSecurityFinancialAssetsDetails implements UpdatableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1228915466982729142L;

	private long id=0l;
	private SPSecurityFinancialAssets securityType=null;
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
	
	
	
	public SPSecurityFinancialAssetsDetails() {
	}

	public SPSecurityFinancialAssetsDetails(String _user, SPSecurityFinancialAssets _securityType, SecurityDetailAdapter _securityDetail) {
		super();
		this.securityType=_securityType;
		if(_securityDetail!=null){
			this.fieldPath=_securityDetail.getFieldPath();
			this.name=_securityDetail.getName();
			this.fieldType=_securityDetail.getFieldType().getCode();
			this.format=_securityDetail.getFormat();
			this.maxLength=((_securityDetail.getMaxLength()==0)? _securityDetail.getFieldType().getMaxLength() : ((_securityDetail.getMaxLength()>_securityDetail.getFieldType().getMaxLength())? _securityDetail.getFieldType().getMaxLength() : _securityDetail.getMaxLength()));
			this.displayInTable=_securityDetail.isDisplayInTable();
			this.displayInTableOrder=_securityDetail.getDisplayInTableOrder();
			this.displayGroup=_securityDetail.getDisplayGroup();
			this.displayGroupOrder=_securityDetail.getDisplayGroupOrder();
			this.displayInGroupOrder=_securityDetail.getDisplayInGroupOrder();
			this.displayRow=_securityDetail.getDisplayRow();
			this.displayColumn=_securityDetail.getDisplayColumn();
			this.displayTop=_securityDetail.getDisplayTop(); 
			this.displayLeft=_securityDetail.getDisplayLeft();
			this.description=_securityDetail.getDescription();
			this.extension=_securityDetail.isExtension();
			this.hidden=_securityDetail.isHidden();
			this.store = _securityDetail.isStore();
		}
		this.auditor=new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="SPSECFADET_GEN", sequenceName="SPSECFADET_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPSECFADET_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = SPSecurityFinancialAssets.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_DETAIL_SECFA")
	@JoinColumn(name="FKSECURITYFA", nullable=false, updatable=false)
	public SPSecurityFinancialAssets getSecurityType() {
		return securityType;
	}

	public void setSecurityType(SPSecurityFinancialAssets _securityType) {
		this.securityType = _securityType;
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
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
