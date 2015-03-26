package com.lynxspa.entities.securities.details.additional;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Index;
import com.lynxspa.entities.securities.SPSecurity;


@Entity
@Table(name="TB_SP_SECURITY_FIXED") 
//@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_FIXED",indexes={
		//@Index(name="IDX_SECFUND_VERSION",columnNames="VERSION"),
	//	@Index(name="IDX_SECFUND_DELETED",columnNames="ISDELETED")
//})

public class SpSecurityFixedIncome  implements Serializable {
	
	private static final long serialVersionUID = -484882619578016800L;

	private long id=0l;
	
	private String amt_issued;
	private String amt_outstanding;
	private String announce_dt;
	private String basic_spread;
	private String calc_typ_des;
	private String collat_typ;
	private String country;
	private String cpn;
	private String cpn_crncy;
	private String cpn_freq;
	private String cpn_typ;
	private String extendible;
	private String final_maturity;
	private String first_cpn_dt;
	private String id_bb_unique;
	private String is_perpetual;
	private String is_unit_traded;
	private String issue_dt;
	private String issue_px;
	private String issuer;
	private String issuer_industry;
	private String long_comp_name;
	private String market_issue;
	private String maturity;
	private String min_increment;
	private String min_piece;
	private String mty_typ;
	private String par_amt;
	private String post_euro_day_cnt_des;
	private String pre_euro_day_cnt_des;
	private String prev_cpn_dt;
	private String redemp_crncy;
	private String redemp_val;
	private String reset_idx;
	private String security_des;
	private String series;
	private String short_name;
	private String structured_note;
	private String trade_crncy;
	private String trade_status;
	
	public SpSecurityFixedIncome(){

	}


	/*
	//@PrimaryKeyJoinColumn//Asi se me crea una columna en con el id, si no lo comentara seria dificil ver la relaccion.
	@OneToOne(cascade=CascadeType.ALL)
	private SPSecurity sPSecurity;
		
	public SPSecurity getSPSecurity() {
		return sPSecurity;
	}
	public void setSPSecurity(SPSecurity sPSecurity) {
		this.sPSecurity = sPSecurity;
	}
	
	*/
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Id
	@SequenceGenerator(name="CASPSECURITYFIXED_GEN", sequenceName="CASPSECURITYFIXED_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CASPSECURITYFIXED_GEN")
	@Column(name="ID", nullable=true, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long _id) {
		this.id = _id;
	}
	
	@Transient
	@Override
	public String toString() {
		String reply="";
		reply = ToStringBuilder.reflectionToString(this); 
		
		return reply;
	}
	@Column(name="",nullable=true)
	public String getAmt_issued() {
		return amt_issued;
	}
	public void setAmt_issued(String amt_issued) {
		this.amt_issued = amt_issued;
	}
	@Column(name="",nullable=true)
	public String getAmt_outstanding() {
		return amt_outstanding;
	}
	public void setAmt_outstanding(String amt_outstanding) {
		this.amt_outstanding = amt_outstanding;
	}
	@Column(name="",nullable=true)
	public String getAnnounce_dt() {
		return announce_dt;
	}
	public void setAnnounce_dt(String announce_dt) {
		this.announce_dt = announce_dt;
	}
	@Column(name="",nullable=true)
	public String getBasic_spread() {
		return basic_spread;
	}
	public void setBasic_spread(String basic_spread) {
		this.basic_spread = basic_spread;
	}
	@Column(name="",nullable=true)
	public String getCalc_typ_des() {
		return calc_typ_des;
	}
	public void setCalc_typ_des(String calc_typ_des) {
		this.calc_typ_des = calc_typ_des;
	}
	@Column(name="",nullable=true)
	public String getCollat_typ() {
		return collat_typ;
	}
	public void setCollat_typ(String collat_typ) {
		this.collat_typ = collat_typ;
	}
	@Column(name="",nullable=true)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="",nullable=true)
	public String getCpn() {
		return cpn;
	}
	public void setCpn(String cpn) {
		this.cpn = cpn;
	}
	@Column(name="",nullable=true)
	public String getCpn_crncy() {
		return cpn_crncy;
	}
	public void setCpn_crncy(String cpn_crncy) {
		this.cpn_crncy = cpn_crncy;
	}
	@Column(name="",nullable=true)
	public String getCpn_freq() {
		return cpn_freq;
	}
	public void setCpn_freq(String cpn_freq) {
		this.cpn_freq = cpn_freq;
	}
	@Column(name="",nullable=true)
	public String getCpn_typ() {
		return cpn_typ;
	}
	public void setCpn_typ(String cpn_typ) {
		this.cpn_typ = cpn_typ;
	}
	@Column(name="",nullable=true)
	public String getExtendible() {
		return extendible;
	}
	public void setExtendible(String extendible) {
		this.extendible = extendible;
	}
	@Column(name="",nullable=true)
	public String getFinal_maturity() {
		return final_maturity;
	}
	public void setFinal_maturity(String final_maturity) {
		this.final_maturity = final_maturity;
	}
	@Column(name="",nullable=true)
	public String getFirst_cpn_dt() {
		return first_cpn_dt;
	}
	public void setFirst_cpn_dt(String first_cpn_dt) {
		this.first_cpn_dt = first_cpn_dt;
	}
	@Column(name="",nullable=true)
	public String getId_bb_unique() {
		return id_bb_unique;
	}
	public void setId_bb_unique(String id_bb_unique) {
		this.id_bb_unique = id_bb_unique;
	}
	@Column(name="",nullable=true)
	public String getIs_perpetual() {
		return is_perpetual;
	}
	public void setIs_perpetual(String is_perpetual) {
		this.is_perpetual = is_perpetual;
	}
	@Column(name="",nullable=true)
	public String getIs_unit_traded() {
		return is_unit_traded;
	}
	public void setIs_unit_traded(String is_unit_traded) {
		this.is_unit_traded = is_unit_traded;
	}
	@Column(name="",nullable=true)
	public String getIssue_dt() {
		return issue_dt;
	}
	public void setIssue_dt(String issue_dt) {
		this.issue_dt = issue_dt;
	}
	@Column(name="",nullable=true)
	public String getIssue_px() {
		return issue_px;
	}
	public void setIssue_px(String issue_px) {
		this.issue_px = issue_px;
	}
	@Column(name="",nullable=true)
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	@Column(name="",nullable=true)
	public String getIssuer_industry() {
		return issuer_industry;
	}
	public void setIssuer_industry(String issuer_industry) {
		this.issuer_industry = issuer_industry;
	}
	@Column(name="",nullable=true)
	public String getLong_comp_name() {
		return long_comp_name;
	}
	public void setLong_comp_name(String long_comp_name) {
		this.long_comp_name = long_comp_name;
	}
	@Column(name="",nullable=true)
	public String getMarket_issue() {
		return market_issue;
	}
	public void setMarket_issue(String market_issue) {
		this.market_issue = market_issue;
	}
	@Column(name="",nullable=true)
	public String getMaturity() {
		return maturity;
	}
	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	@Column(name="",nullable=true)
	public String getMin_increment() {
		return min_increment;
	}
	public void setMin_increment(String min_increment) {
		this.min_increment = min_increment;
	}
	@Column(name="",nullable=true)
	public String getMin_piece() {
		return min_piece;
	}
	public void setMin_piece(String min_piece) {
		this.min_piece = min_piece;
	}
	@Column(name="",nullable=true)
	public String getMty_typ() {
		return mty_typ;
	}
	public void setMty_typ(String mty_typ) {
		this.mty_typ = mty_typ;
	}
	@Column(name="",nullable=true)
	public String getPar_amt() {
		return par_amt;
	}
	public void setPar_amt(String par_amt) {
		this.par_amt = par_amt;
	}
	@Column(name="",nullable=true)
	public String getPost_euro_day_cnt_des() {
		return post_euro_day_cnt_des;
	}
	public void setPost_euro_day_cnt_des(String post_euro_day_cnt_des) {
		this.post_euro_day_cnt_des = post_euro_day_cnt_des;
	}
	@Column(name="",nullable=true)
	public String getPre_euro_day_cnt_des() {
		return pre_euro_day_cnt_des;
	}
	public void setPre_euro_day_cnt_des(String pre_euro_day_cnt_des) {
		this.pre_euro_day_cnt_des = pre_euro_day_cnt_des;
	}
	@Column(name="",nullable=true)
	public String getPrev_cpn_dt() {
		return prev_cpn_dt;
	}
	public void setPrev_cpn_dt(String prev_cpn_dt) {
		this.prev_cpn_dt = prev_cpn_dt;
	}
	@Column(name="",nullable=true)
	public String getRedemp_crncy() {
		return redemp_crncy;
	}
	public void setRedemp_crncy(String redemp_crncy) {
		this.redemp_crncy = redemp_crncy;
	}
	@Column(name="",nullable=true)
	public String getRedemp_val() {
		return redemp_val;
	}
	public void setRedemp_val(String redemp_val) {
		this.redemp_val = redemp_val;
	}
	@Column(name="",nullable=true)
	public String getReset_idx() {
		return reset_idx;
	}
	public void setReset_idx(String reset_idx) {
		this.reset_idx = reset_idx;
	}
	@Column(name="",nullable=true)
	public String getSecurity_des() {
		return security_des;
	}
	public void setSecurity_des(String security_des) {
		this.security_des = security_des;
	}
	@Column(name="",nullable=true)
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	@Column(name="",nullable=true)
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	@Column(name="",nullable=true)
	public String getStructured_note() {
		return structured_note;
	}
	public void setStructured_note(String structured_note) {
		this.structured_note = structured_note;
	}
	@Column(name="",nullable=true)
	public String getTrade_crncy() {
		return trade_crncy;
	}
	public void setTrade_crncy(String trade_crncy) {
		this.trade_crncy = trade_crncy;
	}
	@Column(name="",nullable=true)
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
