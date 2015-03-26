package com.lynxspa.entities.securities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.plannings.SPPlanningProcess;
import com.lynxspa.entities.securities.details.SPSecurityDetail;
import com.lynxspa.entities.securities.financialassets.SPSecurityFinancialAssets;

@Entity
@Table(name="TB_SP_SECURITIES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="SECURITYCLASS", discriminatorType=DiscriminatorType.STRING, length=16)
@DiscriminatorValue("virtual")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITIES",indexes={
		@Index(name="IDX_SECURITY_DELETED",columnNames="ISDELETED"),
		@Index(name="IDX_SECURITY_SECURITYCLASS",columnNames="SECURITYCLASS"),
		@Index(name="IDX_SECURITY_ISIN", columnNames="ISIN"),
		@Index(name="IDX_SECURITY_CUSIP", columnNames="CUSIP"),
		@Index(name="IDX_SECURITY_SEDOL", columnNames="SEDOL"),
		@Index(name="IDX_SECURITY_INFPROV1", columnNames="PROVIDER_ID1"),
		@Index(name="IDX_SECURITY_INFPROV2", columnNames="PROVIDER_ID2"),
		@Index(name="IDX_SECURITY_INFPROV3", columnNames="PROVIDER_ID3"),
		@Index(name="IDX_SECURITY_PLANIFICATION", columnNames="FKPLANIFICATION"),
		@Index(name="IDX_SECURITY_DETAIL", columnNames="FKDETAIL"),
		@Index(name="IDX_SECURITY_FINANCIALASSET", columnNames="FKFINANCIALASSET")
})

public class SPVirtualSecurity implements UpdatableAdapter{
	
	private static final long serialVersionUID = 2613624285639410058L;
	
	
	private long id=0l;
	private String isin=null;
	private String cusip=null;
	private String sedol=null;
	private String name=null;
	private String infoProviderId1=null;
	private String infoProviderId2=null;
	private String infoProviderId3=null;
	private String country= null;
	private String securityType= null;
	private String indSector=null;
	private String indGroup=null;
	private String indSubGroup=null;
	private String relIndex=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	private boolean inCustomerPortfolio=false;
	private SPSecurityFinancialAssets secFinancialAssets=null;
	private SPSecurityDetail securityDetail=null;
	private SPPlanningProcess planification=null;
	
	public SPVirtualSecurity (){
		super();
		this.auditor=new UpdateAuditor();
	}
	public SPVirtualSecurity (String _user){
		super();
		this.auditor=new UpdateAuditor(_user);
		this.inCustomerPortfolio=false;
	}
	
	@Id
	@SequenceGenerator(name="SPSECURITY_GEN", sequenceName="SPSECURITY_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPSECURITY_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="ISIN", length=12, nullable=true)
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}

	@Column(name="CUSIP", length=9, nullable=true)
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	@Column(name="SEDOL", length=7, nullable=true)
	public String getSedol() {
		return sedol;
	}
	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Column(name="PROVIDER_ID1", length=16)
	public String getInfoProviderId1() {
		return infoProviderId1;
	}
	public void setInfoProviderId1(String infoProviderId1) {
		this.infoProviderId1 = infoProviderId1;
	}
	@Column(name="PROVIDER_ID2", length=16)
	public String getInfoProviderId2() {
		return infoProviderId2;
	}
	public void setInfoProviderId2(String infoProviderId2) {
		this.infoProviderId2 = infoProviderId2;
	}
	@Column(name="PROVIDER_ID3", length=16)
	public String getInfoProviderId3() {
		return infoProviderId3;
	}
	public void setInfoProviderId3(String infoProviderId3) {
		this.infoProviderId3 = infoProviderId3;
	}
	@Column(name="COUNTRY", length=2)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="SEC_TYPE", length=32)
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	@Column(name="IND_SECTOR",length=32)
	public String getIndSector() {
		return indSector;
	}
	public void setIndSector(String indSector) {
		this.indSector = indSector;
	}
	@Column(name="IND_GROUP",length=32)
	public String getIndGroup() {
		return indGroup;
	}
	public void setIndGroup(String indGroup) {
		this.indGroup = indGroup;
	}
	@Column(name="IND_SUBGROUP",length=32)
	public String getIndSubGroup() {
		return indSubGroup;
	}
	public void setIndSubGroup(String indSubGroup) {
		this.indSubGroup = indSubGroup;
	}
	@Column(name="REL_INDEX", length=8)
	public String getRelIndex() {
		return relIndex;
	}
	public void setRelIndex(String relIndex) {
		this.relIndex = relIndex;
	}

	@Column(name="INCUSTPORTFOLIO", nullable=false)
	public boolean isInCustomerPortfolio() {
		return inCustomerPortfolio;
	}
	public void setInCustomerPortfolio(boolean inCustomerPortfolio) {
		this.inCustomerPortfolio = inCustomerPortfolio;
	}
	
	@ManyToOne(targetEntity = SPSecurityFinancialAssets.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_FINACIAL_ASSET")
	@JoinColumn(name="FKFINANCIALASSET", nullable=true)
	public SPSecurityFinancialAssets getSecFinancialAssets() {
		return secFinancialAssets;
	}
	public void setSecFinancialAssets(SPSecurityFinancialAssets secFinancialAssets) {
		this.secFinancialAssets = secFinancialAssets;
	}
	
	@OneToOne(targetEntity = SPSecurityDetail.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_SECURITY_DETAIL")
	@JoinColumn(name="FKDETAIL", nullable=true)
	public SPSecurityDetail getSecurityDetail() {
		return securityDetail;
	}
	public void setSecurityDetail(SPSecurityDetail _securityDetail) {
		this.securityDetail = _securityDetail;
	}
	
	@ManyToOne(targetEntity = SPPlanningProcess.class,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_PLANIFICATION")
	@JoinColumn(name="FKPLANIFICATION", nullable=true)
	public SPPlanningProcess getPlanification() {
		return planification;
	}
	public void setPlanification(SPPlanningProcess _perSecurity) {
		this.planification = _perSecurity;
	}
}
