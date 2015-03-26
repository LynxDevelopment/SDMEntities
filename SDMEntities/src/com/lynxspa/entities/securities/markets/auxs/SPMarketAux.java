package com.lynxspa.entities.securities.markets.auxs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="AUX_TB_SP_MARKETS")
public class SPMarketAux {

	private static final long serialVersionUID = -5787836312337800537L;
	
	private long id=0l;
	
	private String mic=null;
	private String marketCode=null;	
	private String name=null;
	private String country=null;
	private String city=null;
	private int version=0;
	private String auditorId=null;
	private boolean deleted=false;
	private String state=null;
	
	public SPMarketAux(){
		this(null,null,null,null,null);
	}

	public SPMarketAux(String _mic, String _marketCode, String _name, String _country, String _city){
		super();
		this.mic = _mic;
		this.marketCode = _marketCode;		
		this.name = _name;
		this.country = _country;	
		this.city = _city;

	}
	
	@Id
	@SequenceGenerator(name="SPMARKETAUX_GEN", sequenceName="SPMARKETAUX_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SPMARKETAUX_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public String getMic() {
		return mic;
	}
	public void setMic(String mic) {
		this.mic = mic;
	}
	
	@Column(name="MARKETCODE",length=64, nullable=false)
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	
	@Column(name="NAME",length=128, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="COUNTRY",length=2, nullable=false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name="CITY",length=32, nullable=false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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

}
