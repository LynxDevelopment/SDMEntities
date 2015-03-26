package com.lynxspa.entities.securities.details;

import java.util.HashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.utils.StringUtils;

@Entity
@Table(name="TB_SP_SECURITYDETAILS") 
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITYDETAILS",indexes={
		@Index(name="IDX_SECDETAIL_VERSION",columnNames="VERSION"),
		@Index(name="IDX_SECDETAIL_DELETED",columnNames="ISDELETED")
})
public class SPSecurityDetail implements UpdatableAdapter {

	private static final long serialVersionUID = -2768325864974017346L;
	
	private long id=0l;
	private HashMap<String, String> dynamicTable=null;
	private int version=0;
	//private VersionAuditor auditor=null;
	private UpdateAuditor auditor=null;
	
	public SPSecurityDetail(){
		super();
		this.auditor=new UpdateAuditor();
	}
	public SPSecurityDetail(String _user){
		super();
		dynamicTable=new HashMap<String, String>();
		//this.auditor=new VersionAuditor(_user);
		this.auditor=new UpdateAuditor(_user);
	}
	

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	@Id
	@SequenceGenerator(name="CASPSECURITYDETAIL_GEN", sequenceName="CASPSECURITYDETAIL_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CASPSECURITYDETAIL_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long _id) {
		this.id = _id;
	}
	
	@Type(type="com.lynxspa.hbt.custom.types.DynamicStringTable",parameters={@Parameter(name="elementsPerType",value="40")})
	@Columns(columns={
		@Column(name="SHORTSTRING1", length=16, nullable=true),@Column(name="SHORTSTRING2", length=16, nullable=true),@Column(name="SHORTSTRING3", length=16, nullable=true),@Column(name="SHORTSTRING4", length=16, nullable=true),@Column(name="SHORTSTRING5", length=16, nullable=true),@Column(name="SHORTSTRING6", length=16, nullable=true),@Column(name="SHORTSTRING7", length=16, nullable=true),@Column(name="SHORTSTRING8", length=16, nullable=true),@Column(name="SHORTSTRING9", length=16, nullable=true),@Column(name="SHORTSTRING10", length=16, nullable=true),
		@Column(name="SHORTSTRING11", length=16, nullable=true),@Column(name="SHORTSTRING12", length=16, nullable=true),@Column(name="SHORTSTRING13", length=16, nullable=true),@Column(name="SHORTSTRING14", length=16, nullable=true),@Column(name="SHORTSTRING15", length=16, nullable=true),@Column(name="SHORTSTRING16", length=16, nullable=true),@Column(name="SHORTSTRING17", length=16, nullable=true),@Column(name="SHORTSTRING18", length=16, nullable=true),@Column(name="SHORTSTRING19", length=16, nullable=true),@Column(name="SHORTSTRING20", length=16, nullable=true),
		@Column(name="SHORTSTRING21", length=16, nullable=true),@Column(name="SHORTSTRING22", length=16, nullable=true),@Column(name="SHORTSTRING23", length=16, nullable=true),@Column(name="SHORTSTRING24", length=16, nullable=true),@Column(name="SHORTSTRING25", length=16, nullable=true),@Column(name="SHORTSTRING26", length=16, nullable=true),@Column(name="SHORTSTRING27", length=16, nullable=true),@Column(name="SHORTSTRING28", length=16, nullable=true),@Column(name="SHORTSTRING29", length=16, nullable=true),@Column(name="SHORTSTRING30", length=16, nullable=true),
		@Column(name="SHORTSTRING31", length=16, nullable=true),@Column(name="SHORTSTRING32", length=16, nullable=true),@Column(name="SHORTSTRING33", length=16, nullable=true),@Column(name="SHORTSTRING34", length=16, nullable=true),@Column(name="SHORTSTRING35", length=16, nullable=true),@Column(name="SHORTSTRING36", length=16, nullable=true),@Column(name="SHORTSTRING37", length=16, nullable=true),@Column(name="SHORTSTRING38", length=16, nullable=true),@Column(name="SHORTSTRING39", length=16, nullable=true),@Column(name="SHORTSTRING40", length=16, nullable=true),
		@Column(name="MIDDLESTRING1", length=32, nullable=true),@Column(name="MIDDLESTRING2", length=32, nullable=true),@Column(name="MIDDLESTRING3", length=32, nullable=true),@Column(name="MIDDLESTRING4", length=32, nullable=true),@Column(name="MIDDLESTRING5", length=32, nullable=true),@Column(name="MIDDLESTRING6", length=32, nullable=true),@Column(name="MIDDLESTRING7", length=32, nullable=true),@Column(name="MIDDLESTRING8", length=32, nullable=true),@Column(name="MIDDLESTRING9", length=32, nullable=true),@Column(name="MIDDLESTRING10", length=32, nullable=true),
		@Column(name="MIDDLESTRING11", length=32, nullable=true),@Column(name="MIDDLESTRING12", length=32, nullable=true),@Column(name="MIDDLESTRING13", length=32, nullable=true),@Column(name="MIDDLESTRING14", length=32, nullable=true),@Column(name="MIDDLESTRING15", length=32, nullable=true),@Column(name="MIDDLESTRING16", length=32, nullable=true),@Column(name="MIDDLESTRING17", length=32, nullable=true),@Column(name="MIDDLESTRING18", length=32, nullable=true),@Column(name="MIDDLESTRING19", length=32, nullable=true),@Column(name="MIDDLESTRING20", length=32, nullable=true),
		@Column(name="MIDDLESTRING21", length=32, nullable=true),@Column(name="MIDDLESTRING22", length=32, nullable=true),@Column(name="MIDDLESTRING23", length=32, nullable=true),@Column(name="MIDDLESTRING24", length=32, nullable=true),@Column(name="MIDDLESTRING25", length=32, nullable=true),@Column(name="MIDDLESTRING26", length=32, nullable=true),@Column(name="MIDDLESTRING27", length=32, nullable=true),@Column(name="MIDDLESTRING28", length=32, nullable=true),@Column(name="MIDDLESTRING29", length=32, nullable=true),@Column(name="MIDDLESTRING30", length=32, nullable=true),
		@Column(name="MIDDLESTRING31", length=32, nullable=true),@Column(name="MIDDLESTRING32", length=32, nullable=true),@Column(name="MIDDLESTRING33", length=32, nullable=true),@Column(name="MIDDLESTRING34", length=32, nullable=true),@Column(name="MIDDLESTRING35", length=32, nullable=true),@Column(name="MIDDLESTRING36", length=32, nullable=true),@Column(name="MIDDLESTRING37", length=32, nullable=true),@Column(name="MIDDLESTRING38", length=32, nullable=true),@Column(name="MIDDLESTRING39", length=32, nullable=true),@Column(name="MIDDLESTRING40", length=32, nullable=true),
		@Column(name="LONGSTRING1", length=64, nullable=true),@Column(name="LONGSTRING2", length=64, nullable=true),@Column(name="LONGSTRING3", length=64, nullable=true),@Column(name="LONGSTRING4", length=64, nullable=true),@Column(name="LONGSTRING5", length=64, nullable=true),@Column(name="LONGSTRING6", length=64, nullable=true),@Column(name="LONGSTRING7", length=64, nullable=true),@Column(name="LONGSTRING8", length=64, nullable=true),@Column(name="LONGSTRING9", length=64, nullable=true),@Column(name="LONGSTRING10", length=64, nullable=true),
		@Column(name="LONGSTRING11", length=64, nullable=true),@Column(name="LONGSTRING12", length=64, nullable=true),@Column(name="LONGSTRING13", length=64, nullable=true),@Column(name="LONGSTRING14", length=64, nullable=true),@Column(name="LONGSTRING15", length=64, nullable=true),@Column(name="LONGSTRING16", length=64, nullable=true),@Column(name="LONGSTRING17", length=64, nullable=true),@Column(name="LONGSTRING18", length=64, nullable=true),@Column(name="LONGSTRING19", length=64, nullable=true),@Column(name="LONGSTRING20", length=64, nullable=true),
		@Column(name="LONGSTRING21", length=64, nullable=true),@Column(name="LONGSTRING22", length=64, nullable=true),@Column(name="LONGSTRING23", length=64, nullable=true),@Column(name="LONGSTRING24", length=64, nullable=true),@Column(name="LONGSTRING25", length=64, nullable=true),@Column(name="LONGSTRING26", length=64, nullable=true),@Column(name="LONGSTRING27", length=64, nullable=true),@Column(name="LONGSTRING28", length=64, nullable=true),@Column(name="LONGSTRING29", length=64, nullable=true),@Column(name="LONGSTRING30", length=64, nullable=true),
		@Column(name="LONGSTRING31", length=64, nullable=true),@Column(name="LONGSTRING32", length=64, nullable=true),@Column(name="LONGSTRING33", length=64, nullable=true),@Column(name="LONGSTRING34", length=64, nullable=true),@Column(name="LONGSTRING35", length=64, nullable=true),@Column(name="LONGSTRING36", length=64, nullable=true),@Column(name="LONGSTRING37", length=64, nullable=true),@Column(name="LONGSTRING38", length=64, nullable=true),@Column(name="LONGSTRING39", length=64, nullable=true),@Column(name="LONGSTRING40", length=64, nullable=true),
		@Column(name="VERYLONGSTRING1", length=128, nullable=true),@Column(name="VERYLONGSTRING2", length=128, nullable=true),@Column(name="VERYLONGSTRING3", length=128, nullable=true),@Column(name="VERYLONGSTRING4", length=128, nullable=true),@Column(name="VERYLONGSTRING5", length=128, nullable=true),@Column(name="VERYLONGSTRING6", length=128, nullable=true),@Column(name="VERYLONGSTRING7", length=128, nullable=true),@Column(name="VERYLONGSTRING8", length=128, nullable=true),@Column(name="VERYLONGSTRING9", length=128, nullable=true),@Column(name="VERYLONGSTRING10", length=128, nullable=true),
		@Column(name="VERYLONGSTRING11", length=128, nullable=true),@Column(name="VERYLONGSTRING12", length=128, nullable=true),@Column(name="VERYLONGSTRING13", length=128, nullable=true),@Column(name="VERYLONGSTRING14", length=128, nullable=true),@Column(name="VERYLONGSTRING15", length=128, nullable=true),@Column(name="VERYLONGSTRING16", length=128, nullable=true),@Column(name="VERYLONGSTRING17", length=128, nullable=true),@Column(name="VERYLONGSTRING18", length=128, nullable=true),@Column(name="VERYLONGSTRING19", length=128, nullable=true),@Column(name="VERYLONGSTRING20", length=128, nullable=true),
		@Column(name="VERYLONGSTRING21", length=128, nullable=true),@Column(name="VERYLONGSTRING22", length=128, nullable=true),@Column(name="VERYLONGSTRING23", length=128, nullable=true),@Column(name="VERYLONGSTRING24", length=128, nullable=true),@Column(name="VERYLONGSTRING25", length=128, nullable=true),@Column(name="VERYLONGSTRING26", length=128, nullable=true),@Column(name="VERYLONGSTRING27", length=128, nullable=true),@Column(name="VERYLONGSTRING28", length=128, nullable=true),@Column(name="VERYLONGSTRING29", length=128, nullable=true),@Column(name="VERYLONGSTRING30", length=128, nullable=true),
		@Column(name="VERYLONGSTRING31", length=128, nullable=true),@Column(name="VERYLONGSTRING32", length=128, nullable=true),@Column(name="VERYLONGSTRING33", length=128, nullable=true),@Column(name="VERYLONGSTRING34", length=128, nullable=true),@Column(name="VERYLONGSTRING35", length=128, nullable=true),@Column(name="VERYLONGSTRING36", length=128, nullable=true),@Column(name="VERYLONGSTRING37", length=128, nullable=true),@Column(name="VERYLONGSTRING38", length=128, nullable=true),@Column(name="VERYLONGSTRING39", length=128, nullable=true),@Column(name="VERYLONGSTRING40", length=128, nullable=true)
	})
	
	@Basic(fetch = FetchType.EAGER)
	public HashMap<String, String> getDynamicTable() {
		return dynamicTable;
	}
	public void setDynamicTable(HashMap<String, String> dynamicTable) {
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
	
	/*@Embedded
	public VersionAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(VersionAuditor auditor) {
		this.auditor = auditor;
	}*/
	
	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}
	
	@Transient
	public String get(String _field){
		
		String reply=null;
		String st1=null;
		
		if(_field!=null){
			st1=_field.toUpperCase();
			reply=this.dynamicTable.get(st1);
		}			

		return reply; 
	}
	
	@Transient
	public void set(String _field,String _value){

		String st1=null;
		if(_field!=null){
			st1=_field.toUpperCase();		
			if(st1.startsWith("SHORTSTRING")){
				this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString(_value,16)));
			}else if(st1.startsWith("MIDDLESTRING")){
				this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString(_value,64)));
			}else if(st1.startsWith("LONGSTRING")){
				this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString(_value,128)));
			}else if(st1.startsWith("VERYLONGSTRING")){
				this.dynamicTable.put(st1,((_value==null)? null : StringUtils.fitString(_value,256)));
			}else{
				this.dynamicTable.put(st1,_value);
			}
		}
	}
	
	@Transient
	@Override
	public String toString() {
		String reply="";
		reply = ToStringBuilder.reflectionToString(this); 
		
		return reply;
	}
	
	
	
}
