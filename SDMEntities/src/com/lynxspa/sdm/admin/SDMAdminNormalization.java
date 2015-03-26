package com.lynxspa.sdm.admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;

@Entity
@Table(name="TB_SDM_NORMALIZATIONS")
@org.hibernate.annotations.Table(appliesTo="TB_SDM_NORMALIZATIONS",indexes={
		@Index(name="IDX_NORMALIZATION_NAME", columnNames="NAME")
})
public class SDMAdminNormalization implements UpdatableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7066511509659064381L;
	
	private long id =0l;
	private int version=0;
	private UpdateAuditor auditor=null;
	private String incomingDataClass=null;
	private String outgoingFieldsClass=null;
	private String outgoingDataClass=null;
	private String name=null;
	private List<SDMNormalizationFilters> filterFields= new ArrayList<SDMNormalizationFilters>();
	
	@Id
	@SequenceGenerator(name="NORMALIZATION_GEN", sequenceName="NORMALIZATION_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="NORMALIZATION_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	@Column(name="INCOMING_DATA_CLASS", nullable=false, length=128)
	public String getIncomingDataClass() {
		return incomingDataClass;
	}
	public void setIncomingDataClass(String incomingDataClass) {
		this.incomingDataClass = incomingDataClass;
	}
	
	@Column(name="OUTGOING_FIELDS_CLASS", nullable=false, length=128)
	public String getOutgoingFieldsClass() {
		return outgoingFieldsClass;
	}
	public void setOutgoingFieldsClass(String outgoingFieldsClass) {
		this.outgoingFieldsClass = outgoingFieldsClass;
	}
	
	
	@Column(name="OUTGOING_DATA_CLASS", nullable=false, length=128)
	public String getOutgoingDataClass() {
		return outgoingDataClass;
	}
	public void setOutgoingDataClass(String outgoingDataClass) {
		this.outgoingDataClass = outgoingDataClass;
	}
	
	@OneToMany(targetEntity = SDMNormalizationFilters.class, mappedBy="normaliaztion",fetch=FetchType.EAGER)
	public List<SDMNormalizationFilters> getFilterFields() {
		return filterFields;
	}
	public void setFilterFields(List<SDMNormalizationFilters> filterFields) {
		this.filterFields = filterFields;
	}
	
	@Column(name="NAME", nullable=false, length=64)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
