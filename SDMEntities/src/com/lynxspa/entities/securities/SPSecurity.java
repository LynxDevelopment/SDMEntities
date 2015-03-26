package com.lynxspa.entities.securities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.securities.details.additional.SpSecurityETF;
import com.lynxspa.entities.securities.details.additional.SpSecurityEquity;
import com.lynxspa.entities.securities.details.additional.SpSecurityFixedIncome;
import com.lynxspa.entities.securities.details.additional.SpSecurityFund;
import com.lynxspa.entities.securities.markets.SPMarket;


@Entity
@DiscriminatorValue("customer")
@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITIES",indexes={
		@Index(name="IDX_SECURITY_TICKER", columnNames="TICKER"),
		@Index(name="IDX_SECURITY_FKMARKET", columnNames="FKMARKET")
})
public class SPSecurity extends SPVirtualSecurity{
	
	private static final long serialVersionUID = 4037770470253764137L;


	private SPMarket market=null;
	private String customerId=null;
	private String currency=null;
	private Date expirationDate=null;
	private String ticker;
	
	private SpSecurityEquity securityEquity=null ;
	private SpSecurityFund securityFund=null;
	private SpSecurityETF securityETF=null;
	private SpSecurityFixedIncome securityFixedIncome=null;
	
	public SPSecurity (){
		this(null);
	}
	public SPSecurity (String _user){
		super(_user);
	}
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_SECURITY_EQUITY")
	@JoinColumn(name="FKSECURITYEQUITY", nullable=true)
	public SpSecurityEquity getSecurityEquity() {
		return securityEquity;
	}
	public void setSecurityEquity(SpSecurityEquity equityFields) {
		this.securityEquity = equityFields;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_SECURITY_FUND")
	@JoinColumn(name="FKSECURITYFUND", nullable=true)
	public SpSecurityFund getSecurityFund() { 
		return securityFund;
	}
	public void setSecurityFund(SpSecurityFund fundFields) {
		this.securityFund = fundFields;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_SECURITY_ETF")
	@JoinColumn(name="FKSECURITYETF", nullable=true)
	public SpSecurityETF getSecurityETF() {
		return securityETF;
	}
	public void setSecurityETF(SpSecurityETF eTFFields) {
		this.securityETF = eTFFields;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@ForeignKey(name="FK_SECURITY_FIXED_INCOME")
	@JoinColumn(name="FKSECURITYFIXEDINCOME", nullable=true)
	public SpSecurityFixedIncome getSecurityFixedIncome() {
		return securityFixedIncome;
	}
	public void setSecurityFixedIncome(SpSecurityFixedIncome securityFixedIncome) {
		this.securityFixedIncome = securityFixedIncome;
	}
	
	
	@ManyToOne(targetEntity = SPMarket.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_SECURITY_MARKET")
	@JoinColumn(name="FKMARKET", nullable=true)
	public SPMarket getMarket() {
		return market;
	}
	public void setMarket(SPMarket _market) {
		this.market = _market;
	}
	
	@Column(name="CUSTOMERID", length=64, nullable=true)
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="CURRENCY", length=3, nullable=true)
	public String getCurrency() {
		return currency;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	@Column(name="TICKER", length=32, nullable=true)
	public String getTicker() {
		return ticker;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
}
