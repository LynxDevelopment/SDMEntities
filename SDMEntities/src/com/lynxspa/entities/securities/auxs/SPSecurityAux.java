package com.lynxspa.entities.securities.auxs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;



@Entity
@Table(name="AUX_TB_SP_SECURITIES")
public class SPSecurityAux {

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String isin=null;
	private String radSufKey=null;
	private String cusip=null;
	private String sedol=null;	
	private String customerId=null;
	private String country=null;
	private String currency=null;
	private String valueType=null;
	private Date expirationDate=null;
	private String indSector=null;
	private String indGrup=null;
	private String indSubgrup=null;
	private String relatedIndex=null;
	private int version=0;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;     	// FALTA
	private String ticker=null;		
	private String market=null;		// FALTA
	private String name=null;		

	public SPSecurityAux(){
		this(null,null,null,null,null,null,null,null,null,null,null,null,null,null);
	}
	
	public SPSecurityAux(String _user, String _isin, String _customerId, String _country,
			String _currency, String _indGrup
			
	){
		super();
		this.auditorId=_user;
		this.isin=_isin;
		this.customerId=_customerId;
		this.country=_country;
		this.currency=_currency;
		this.indGrup=_indGrup;

	}
	
	public SPSecurityAux(String _user,String _isin,String _radSufKey,
			String _cusip, String _sedol, String _customerId, String _country, String _currency,
			String _valueType, Date _expirationDate, String _indSector, String _indGrup,String _indSubgrup,
			String _relatedIndex
	){
		super();
		this.auditorId=_user;
		this.isin=_isin;
		this.radSufKey=_radSufKey;
		this.cusip=_cusip;
		this.sedol=_sedol;	
		this.customerId=_customerId;
		this.country=_country;
		this.currency=_currency;
		this.valueType=_valueType;
		this.expirationDate=_expirationDate;
		this.indSector=_indSector;
		this.indGrup=_indGrup;
		this.indSubgrup=_indSubgrup;
		this.relatedIndex=_relatedIndex;
	}
	
	@Id
	@SequenceGenerator(name="SPSECURITYAUX_GEN", sequenceName="SPSECURITYAUX_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPSECURITYAUX_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="ISIN",length=12, nullable=true)
	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	@Column(name="RADSUFKEY",length=10, nullable=true)	
	public String getRadSufKey() {
		return radSufKey;
	}

	public void setRadSufKey(String radSufKey) {
		this.radSufKey = radSufKey;
	}

	@Column(name="CUSIP",length=9, nullable=true)
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	@Column(name="SEDOL",length=7, nullable=true)		
	public String getSedol() {
		return sedol;
	}

	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	@Column(name="CUSTOMERID", length=64, nullable=false)
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="COUNTRY",length=2, nullable=false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="CURRENCY",length=3, nullable=false)
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name="VALUETYPE",length=32)
	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATIONDATE", nullable=true)
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		
		if(expirationDate!=null){
			this.expirationDate=new Date(expirationDate.getTime());
		}else{
			this.expirationDate=null;
		}
	}

	@Column(name="IND_SECTOR",length=32)
	public String getIndSector() {
		return indSector;
	}
	public void setIndSector(String indSector) {
		this.indSector = indSector;
	}

	@Column(name="IND_GROUP",length=32)
	public String getIndGrup() {
		return indGrup;
	}
	public void setIndGrup(String indGrup) {
		this.indGrup = indGrup;
	}

	@Column(name="IND_SUBGROUP",length=32)
	public String getIndSubgrup() {
		return indSubgrup;
	}
	public void setIndSubgrup(String indSubgrup) {
		this.indSubgrup = indSubgrup;
	}

	@Column(name="REL_INDEX", length=8)
	public String getRelatedIndex() {
		return relatedIndex;
	}
	public void setRelatedIndex(String relatedIndex) {
		this.relatedIndex = relatedIndex;
	}
	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;		
	}
	
	@Column(name="AUDITORID",length=128, nullable=false)
	public String getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	
	@Column(name="ISDELETED", nullable=false)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Column(name="STATE",length=1, nullable=true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="TICKER", length=32, nullable=true)
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@Column(name="MARKET", length=64, nullable=true)
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}

	@Column(name="NAME", length=64, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
