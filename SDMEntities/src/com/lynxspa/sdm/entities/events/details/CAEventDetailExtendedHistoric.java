package com.lynxspa.sdm.entities.events.details;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailExtendedAdapter;
import com.lynxspa.utils.StringUtils;


@Entity
@Table(name="HS_CA_EVENTEXTDETAILS",uniqueConstraints={
	@UniqueConstraint(columnNames={"FKEVENTDETAIL","EXTENSIONNAME","EXTENSIONNUMBER","VERSION"})	
}) 
@org.hibernate.annotations.Table(
	appliesTo="HS_CA_EVENTEXTDETAILS",
	indexes={
		@Index(name="IDX_HSEXTDETAIL_FKEVENTDETAIL",columnNames="FKEVENTDETAIL"),
		@Index(name="IDX_HSEVTEXTDETAIL_VERSION",columnNames="VERSION"),
		@Index(name="IDX_HSEVTEXTDETAIL_REFID",columnNames="REFID"),
		@Index(name="IDX_HSEVTEXTDETAIL_EXTENSIONID",columnNames={"EXTENSIONNAME","EXTENSIONNUMBER"}),
		@Index(name="IDX_HSEVTEXTDETAIL_DELETED",columnNames="ISDELETED")
	}
)
public class CAEventDetailExtendedHistoric implements VersionableAdapter,CAEventDetailExtendedAdapter {

	private static final long serialVersionUID = -2768321567594017346L;
	
	private long id=0l;
	private CAEventDetailAdapter mainDetail=null;
	private CAEventDetailExtensionId extensionId=null;
	private String extensionIdCode=null;
	private HashMap<String, Object> dynamicTable=null;
	private String narrative=null;
	private int version=0;
	private VersionAuditor auditor=null;
	
	
	public CAEventDetailExtendedHistoric(){
		this(null,null,0);
	}
	public CAEventDetailExtendedHistoric(String _user,String _extensionName){
		this(_user,_extensionName,0);
	}
	public CAEventDetailExtendedHistoric(String _user,String _extensionName,int _extensionNumber){
		super();
		this.extensionId=new CAEventDetailExtensionId(_extensionName,_extensionNumber);
		if(this.extensionId!=null)
			this.extensionIdCode=this.extensionId.toString();
		this.dynamicTable=new HashMap<String, Object>();
		this.auditor=new VersionAuditor(_user);
	}
	
	
	@Id
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	@ManyToOne(targetEntity = CAEventDetailHistoric.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HSEXTENDED_DETAIL")
	@JoinColumn(name="FKEVENTDETAIL", nullable=false, updatable=false)
	public CAEventDetailAdapter getMainDetail() {
		return mainDetail;
	}
	public void setMainDetail(CAEventDetailAdapter mainDetail) {
		this.mainDetail = mainDetail;
	}
	
	@Embedded
	public CAEventDetailExtensionId getExtensionId() {
		return extensionId;
	}
	public void setExtensionId(CAEventDetailExtensionId extensionId) {
		this.extensionId = extensionId;
		if(this.extensionId!=null)
			this.extensionIdCode=this.extensionId.toString();
	}
	
	@Column(name="EXTENSIONIDCODE",insertable=true)
	public String getExtensionIdCode() {
		return extensionIdCode;
	}
	public void setExtensionIdCode(String _extensionIdCode) {
		this.extensionIdCode=_extensionIdCode;
	}

	
	@Type(type="com.lynxspa.hbt.custom.types.DynamicTable",
		  parameters={@Parameter(name="elementsPerType",value="10")})
	@Columns(columns={
		@Column(name="BOOLEAN1",nullable=true),@Column(name="BOOLEAN2",nullable=true),@Column(name="BOOLEAN3",nullable=true),@Column(name="BOOLEAN4",nullable=true),@Column(name="BOOLEAN5",nullable=true),@Column(name="BOOLEAN6",nullable=true),@Column(name="BOOLEAN7",nullable=true),@Column(name="BOOLEAN8",nullable=true),@Column(name="BOOLEAN9",nullable=true),@Column(name="BOOLEAN10",nullable=true),
		@Column(name="LONG1",nullable=true),@Column(name="LONG2",nullable=true),@Column(name="LONG3",nullable=true),@Column(name="LONG4",nullable=true),@Column(name="LONG5",nullable=true),@Column(name="LONG6",nullable=true),@Column(name="LONG7",nullable=true),@Column(name="LONG8",nullable=true),@Column(name="LONG9",nullable=true),@Column(name="LONG10",nullable=true),
		@Column(name="DOUBLE1",nullable=true),@Column(name="DOUBLE2",nullable=true),@Column(name="DOUBLE3",nullable=true),@Column(name="DOUBLE4",nullable=true),@Column(name="DOUBLE5",nullable=true),@Column(name="DOUBLE6",nullable=true),@Column(name="DOUBLE7",nullable=true),@Column(name="DOUBLE8",nullable=true),@Column(name="DOUBLE9",nullable=true),@Column(name="DOUBLE10",nullable=true),
		@Column(name="TIMESTAMP1",nullable=true),@Column(name="TIMESTAMP2",nullable=true),@Column(name="TIMESTAMP3",nullable=true),@Column(name="TIMESTAMP4",nullable=true),@Column(name="TIMESTAMP5",nullable=true),@Column(name="TIMESTAMP6",nullable=true),@Column(name="TIMESTAMP7",nullable=true),@Column(name="TIMESTAMP8",nullable=true),@Column(name="TIMESTAMP9",nullable=true),@Column(name="TIMESTAMP10",nullable=true),
		@Column(name="SHORTSTRING1", length=16, nullable=true),@Column(name="SHORTSTRING2", length=16, nullable=true),@Column(name="SHORTSTRING3", length=16, nullable=true),@Column(name="SHORTSTRING4", length=16, nullable=true),@Column(name="SHORTSTRING5", length=16, nullable=true),@Column(name="SHORTSTRING6", length=16, nullable=true),@Column(name="SHORTSTRING7", length=16, nullable=true),@Column(name="SHORTSTRING8", length=16, nullable=true),@Column(name="SHORTSTRING9", length=16, nullable=true),@Column(name="SHORTSTRING10", length=16, nullable=true),
		@Column(name="MIDDLESTRING1", length=64, nullable=true),@Column(name="MIDDLESTRING2", length=64, nullable=true),@Column(name="MIDDLESTRING3", length=64, nullable=true),@Column(name="MIDDLESTRING4", length=64, nullable=true),@Column(name="MIDDLESTRING5", length=64, nullable=true),@Column(name="MIDDLESTRING6", length=64, nullable=true),@Column(name="MIDDLESTRING7", length=64, nullable=true),@Column(name="MIDDLESTRING8", length=64, nullable=true),@Column(name="MIDDLESTRING9", length=64, nullable=true),@Column(name="MIDDLESTRING10", length=64, nullable=true),
		@Column(name="LONGSTRING1", length=128, nullable=true),@Column(name="LONGSTRING2", length=128, nullable=true),@Column(name="LONGSTRING3", length=128, nullable=true),@Column(name="LONGSTRING4", length=128, nullable=true),@Column(name="LONGSTRING5", length=128, nullable=true),@Column(name="LONGSTRING6", length=128, nullable=true),@Column(name="LONGSTRING7", length=128, nullable=true),@Column(name="LONGSTRING8", length=128, nullable=true),@Column(name="LONGSTRING9", length=128, nullable=true),@Column(name="LONGSTRING10", length=128, nullable=true),
		@Column(name="VERYLONGSTRING1", length=256, nullable=true),@Column(name="VERYLONGSTRING2", length=256, nullable=true),@Column(name="VERYLONGSTRING3", length=256, nullable=true),@Column(name="VERYLONGSTRING4", length=256, nullable=true),@Column(name="VERYLONGSTRING5", length=256, nullable=true),@Column(name="VERYLONGSTRING6", length=256, nullable=true),@Column(name="VERYLONGSTRING7", length=256, nullable=true),@Column(name="VERYLONGSTRING8", length=256, nullable=true),@Column(name="VERYLONGSTRING9", length=256, nullable=true),@Column(name="VERYLONGSTRING10", length=256, nullable=true),
	})
	@Basic(fetch = FetchType.EAGER)
	public HashMap<String, Object> getDynamicTable() {
		return dynamicTable;
	}
	public void setDynamicTable(HashMap<String, Object> dynamicTable) {
		this.dynamicTable = dynamicTable;
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
	public VersionAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
	@Lob
	@Column(name="NARRATIVE",length=32768)
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	
	//Help Functions
	@Transient
	public Object get(String _field){
		
		Object reply=null;
		String st1=null;
		
		if(_field!=null){
			st1=_field.toUpperCase();
			if(st1.startsWith("CLOB")){
				reply=this.narrative;
			}else{
				reply=this.dynamicTable.get(st1);
			}
		}
		
		return reply;
	}
	@Transient
	public void set(String _field,Object _value) throws FPMException{

		String st1=null;
		
		try{
			if(_field!=null){
				st1=_field.toUpperCase();
				if(st1.startsWith("CLOB")){
						this.narrative=(String)_value;
				}else{
					if(st1.startsWith("SHORTSTRING")){
						this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString((String)_value,16)));
					}else if(st1.startsWith("MIDDLESTRING")){
						this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString((String)_value,64)));
					}else if(st1.startsWith("LONGSTRING")){
						this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString((String)_value,128)));
					}else if(st1.startsWith("VERYLONGSTRING")){
						this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString((String)_value,256)));
					}else if(st1.startsWith("BOOLEAN")){
						this.dynamicTable.put(st1,(Boolean)_value);
					}else if(st1.startsWith("LONG")){
						this.dynamicTable.put(st1,(Long)_value);
					}else if(st1.startsWith("DOUBLE")){
						this.dynamicTable.put(st1,(Double)_value);
					}else if(st1.startsWith("TIMESTAMP")){
						this.dynamicTable.put(st1,(Date)_value);
					}else{
						throw new FPMException(LogErrorDict.NORMALIZATION_UNKNOWN_FIELD,new Object[]{st1});
					}
				}
			}
		} catch (ClassCastException e) {
			throw new FPMException(LogErrorDict.NORMALIZATION_EVENT_FIELD_TYPE,new Object[]{st1},e);
		}
	}
}
