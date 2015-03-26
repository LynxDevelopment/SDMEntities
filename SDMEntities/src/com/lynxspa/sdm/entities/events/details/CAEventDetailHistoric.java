package com.lynxspa.sdm.entities.events.details;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import com.lynxspa.entities.VersionAuditor;
import com.lynxspa.entities.VersionableAdapter;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailExtendedAdapter;
import com.lynxspa.utils.StringUtils;


@Entity
@Table(name="HS_CA_EVENTDETAILS") 
@org.hibernate.annotations.Table(appliesTo="HS_CA_EVENTDETAILS",indexes={
	@Index(name="IDX_HSEVDETAIL_OPERDATE",columnNames="OPERATIONALDATE"),
	@Index(name="IDX_HSEVDETAIL_REFID",columnNames="REFID"),
	@Index(name="IDX_HSEVDETAIL_VERSION",columnNames="VERSION"),
	@Index(name="IDX_HSEVDETAIL_DELETED",columnNames="ISDELETED")
})
public class CAEventDetailHistoric implements VersionableAdapter,CAEventDetailAdapter{

	private static final long serialVersionUID = -2768321567594017346L;
	
	private long id=0l;
	private Date subscriptionDate=null;
	private Date executionDate=null;
	private Date expirationDate=null;
	private Date operationalDate=null;
	private HashMap<String, Object> dynamicTable=null;
	private int version=0;
	private VersionAuditor auditor=null;
	
	private Map<String,? extends CAEventDetailExtendedAdapter> extensions=new HashMap<String,CAEventDetailExtendedHistoric>();
	
	
	public CAEventDetailHistoric(){
		this(null);
	}
	public CAEventDetailHistoric(String _user){
		super();
		dynamicTable=new HashMap<String, Object>();
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

	@Temporal(TemporalType.DATE)
	@Column(name="SUSCRIPTIONDATE",nullable=true)
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="EXECUTIONDATE",nullable=true)
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATIONDATE",nullable=true)
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="OPERATIONALDATE",nullable=true)
	public Date getOperationalDate() {
		return operationalDate;
	}
	public void setOperationalDate(Date operationalDate) {
		this.operationalDate = operationalDate;
	}
	
	@Type(type="com.lynxspa.hbt.custom.types.DynamicTable",parameters={@Parameter(name="elementsPerType",value="10")})
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
	public void setDynamicTable(HashMap<String, Object> _dynamicTable) {
		this.dynamicTable = _dynamicTable;
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
	
	@OneToMany(targetEntity = CAEventDetailExtendedHistoric.class, mappedBy="mainDetail",fetch=FetchType.LAZY)
	@MapKey(name="extensionIdCode")
	@Where(clause="REFID=0")
	public Map<String,? extends CAEventDetailExtendedAdapter> getExtensions() {
		return extensions;
	}
	public void setExtensions(Map<String,? extends CAEventDetailExtendedAdapter> extensions) {
		this.extensions = extensions;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//Help Functions
	@Transient
	public Object get(String _field){
		
		Object reply=null;
		String st1=null;
		
		if(_field!=null){
			st1=_field.toUpperCase();
			if(st1.startsWith("SUBSCRIPTIONDATE"))
				reply=this.subscriptionDate;
			if(st1.startsWith("EXECUTIONDATE"))
				reply=this.executionDate;
			if(st1.startsWith("EXPIRATIONDATE"))
				reply=this.expirationDate;
			if(st1.startsWith("OPERATIONALDATE"))
				reply=this.operationalDate;
			if(reply==null)
				reply=this.dynamicTable.get(st1);
		}			
		
		return reply; 
	}
	@Transient
	public void set(String _field,Object _value) throws FPMException{

		String st1=null;
		
		try {
			if(_field!=null){
				st1=_field.toUpperCase();
				if(st1.startsWith("SUBSCRIPTIONDATE")){
					this.subscriptionDate=(Date)_value;
				}else if(st1.startsWith("EXECUTIONDATE")){
					this.executionDate=(Date)_value;
				}else if(st1.startsWith("EXPIRATIONDATE")){
					this.expirationDate=(Date)_value;
				}else if(st1.startsWith("OPERATIONALDATE")){
					this.operationalDate=(Date)_value;
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
	@Transient
	@SuppressWarnings("unchecked")
	public void addExtension(CAEventDetailExtendedAdapter _extension){
		((Map<String,CAEventDetailExtendedHistoric>)this.extensions).put(_extension.getExtensionId().toString(),(CAEventDetailExtendedHistoric)_extension);
	}
	
	@Transient
	@Override
	public String toString() {
		
		String reply="";
		
		reply+="subscriptionDate: "+this.subscriptionDate+"\n";
		reply+="executionDate: "+this.executionDate+"\n";
		reply+="expirationDate: "+this.expirationDate+"\n";
		reply+="operationalDate: "+this.operationalDate+"\n";
		reply+="DynamicTable:\n";
		for(String name:this.dynamicTable.keySet()){
			reply+="	"+name+": "+this.dynamicTable.get(name)+"\n";
		}
		
		return reply;
	}
}
