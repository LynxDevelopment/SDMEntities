package com.lynxspa.entities.securities.details.additional;




import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.securities.SPSecurity;


@Entity
@Table(name="TB_SP_SECURITY_EQUITY") 
//@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_EQUITY",indexes={
		//@Index(name="IDX_SECEQUITY_VERSION",columnNames="VERSION"),
		//@Index(name="IDX_SECEQUITY_DELETED",columnNames="ISDELETED")
//})
public class SpSecurityEquity implements Serializable {

	private static final long serialVersionUID = -49195943209533265L;
	private long id=0l;

	private String cntry_issue_iso;
	private String id_mic_prim_exch;
	private String eqy_sh_out;
	private String industry_subgroup;
	private String market_status;
	private String rel_index;
	private String eqy_sh_out_dt;
	private String eqy_init_po_dt;
	private String eqy_po_dt;
	private String multiple_share;
	private String par_amt;
	private String adr_sh_per_adr;
	private String dvd_sh_last;
	private String last_dps_gross;
	private String voting_rights;
	private String adr_adr_per_sh;
	private String px_quote_lot_size;
	private String eqy_sh_out_tot_mult_sh;
	private String total_voting_shares_value;
	private String id_bb_company;
	private String id_bb_security;
	private String px_trade_lot_size;
	
	private String security_typ2;
	private String eqy_prim_exch;
	private String dvd_typ_last;
	private String market_sector_des;
	private String ticker;
	
	private String country;
	private String dvd_crncy;
	private String dvd_freq;
	private String eqy_split_ratio;
	private String par_val_crncy;
	private String eqy_prim_security_ticker;
	private String id_mic_local_exch;
	private String dvd_pay_dt;
	private String dvd_record_dt;
	private String dvd_declared_dt;
	private String eqy_split_dt;
	private String dvd_ex_dt;
	private String long_comp_name;
	
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
	@SequenceGenerator(name="CASPSECURITYEQUITY_GEN", sequenceName="CASPSECURITYEQUITY_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CASPSECURITYEQUITY_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long _id) {
		this.id = _id;
	}


	
	@Column(name="CNTRY", nullable=true)
	public String getCntry_issue_iso() {
		return cntry_issue_iso;
	}
	public void setCntry_issue_iso(String cntry_issue_iso) {
		this.cntry_issue_iso = cntry_issue_iso;
	}
	
	@Column(name="ID_MIC", nullable=true)
	public String getId_mic_prim_exch() {
		return id_mic_prim_exch;
	}
	public void setId_mic_prim_exch(String id_mic_prim_exch) {
		this.id_mic_prim_exch = id_mic_prim_exch;
	}
	
	@Column(name="EQY_SH_OUT", nullable=true)
	public String getEqy_sh_out() {
		return eqy_sh_out;
	}
	public void setEqy_sh_out(String eqy_sh_out) {
		this.eqy_sh_out = eqy_sh_out;
	}

	@Column(name="INDUSTRY_SUBGROUP", nullable=true)
	public String getIndustry_subgroup() {
		return industry_subgroup;
	}
	public void setIndustry_subgroup(String industry_subgroup) {
		this.industry_subgroup = industry_subgroup;
	}
	
	@Column(name="MARKET_STATUS", nullable=true)
	public String getMarket_status() {
		return market_status;
	}
	public void setMarket_status(String market_status) {
		this.market_status = market_status;
	}
	@Column(name="REL_INDEX", nullable=true)
	public String getRel_index() {
		return rel_index;
	}
	public void setRel_index(String rel_index) {
		this.rel_index = rel_index;
	}
	@Column(name="EQY_SH_OUT_DT", nullable=true)
	public String getEqy_sh_out_dt() {
		return eqy_sh_out_dt;
	}
	public void setEqy_sh_out_dt(String eqy_sh_out_dt) {
		this.eqy_sh_out_dt = eqy_sh_out_dt;
	}
	
	@Column(name="EQY_SH_PO_DT", nullable=true)
	public String getEqy_init_po_dt() {
		return eqy_init_po_dt;
	}
	public void setEqy_init_po_dt(String eqy_init_po_dt) {
		this.eqy_init_po_dt = eqy_init_po_dt;
	}
	@Column(name="EQY_PO_DT", nullable=true)
	public String getEqy_po_dt() {
		return eqy_po_dt;
	}
	public void setEqy_po_dt(String eqy_po_dt) {
		this.eqy_po_dt = eqy_po_dt;
	}
	@Column(name="MULTIPLE_SHARE", nullable=true)
	public String getMultiple_share() {
		return multiple_share;
	}
	public void setMultiple_share(String multiple_share) {
		this.multiple_share = multiple_share;
	}
	@Column(name="PAR_AMT", nullable=true)
	public String getPar_amt() {
		return par_amt;
	}
	public void setPar_amt(String par_amt) {
		this.par_amt = par_amt;
	}
	@Column(name="ADR_SH_PER_ADR", nullable=true)
	public String getAdr_sh_per_adr() {
		return adr_sh_per_adr;
	}
	public void setAdr_sh_per_adr(String adr_sh_per_adr) {
		this.adr_sh_per_adr = adr_sh_per_adr;
	}
	@Column(name="DVD_LAST", nullable=true)
	public String getDvd_sh_last() {
		return dvd_sh_last;
	}
	public void setDvd_sh_last(String dvd_sh_last) {
		this.dvd_sh_last = dvd_sh_last;
	}
	@Column(name="LAST_DPS", nullable=true)
	public String getLast_dps_gross() {
		return last_dps_gross;
	}
	public void setLast_dps_gross(String last_dps_gross) {
		this.last_dps_gross = last_dps_gross;
	}
	@Column(name="VOTING_RIGHTS", nullable=true)
	public String getVoting_rights() {
		return voting_rights;
	}
	public void setVoting_rights(String voting_rights) {
		this.voting_rights = voting_rights;
	}
	@Column(name="ADR_SH_PER_SH", nullable=true)
	public String getAdr_adr_per_sh() {
		return adr_adr_per_sh;
	}
	public void setAdr_adr_per_sh(String adr_adr_per_sh) {
		this.adr_adr_per_sh = adr_adr_per_sh;
	}
	@Column(name="PX_QUOTE_LOT_SIZE", nullable=true)
	public String getPx_quote_lot_size() {
		return px_quote_lot_size;
	}
	public void setPx_quote_lot_size(String px_quote_lot_size) {
		this.px_quote_lot_size = px_quote_lot_size;
	}
	@Column(name="EQY_SH_OUT_TOT", nullable=true)
	public String getEqy_sh_out_tot_mult_sh() {
		return eqy_sh_out_tot_mult_sh;
	}
	public void setEqy_sh_out_tot_mult_sh(String eqy_sh_out_tot_mult_sh) {
		this.eqy_sh_out_tot_mult_sh = eqy_sh_out_tot_mult_sh;
	}
	@Column(name="TOTAL_VOTING", nullable=true)
	public String getTotal_voting_shares_value() {
		return total_voting_shares_value;
	}
	public void setTotal_voting_shares_value(String total_voting_shares_value) {
		this.total_voting_shares_value = total_voting_shares_value;
	}
	@Column(name="ID_BB_COMPANY", nullable=true)
	public String getId_bb_company() {
		return id_bb_company;
	}
	public void setId_bb_company(String id_bb_company) {
		this.id_bb_company = id_bb_company;
	}
	@Column(name="ID_BB_SECURITY", nullable=true)
	public String getId_bb_security() {
		return id_bb_security;
	}
	public void setId_bb_security(String id_bb_security) {
		this.id_bb_security = id_bb_security;
	}
	@Column(name="PX_TRADE_LOT_SIZE", nullable=true)
	public String getPx_trade_lot_size() {
		return px_trade_lot_size;
	}
	public void setPx_trade_lot_size(String px_trade_lot_size) {
		this.px_trade_lot_size = px_trade_lot_size;
	}

	@Column(name="SECURITY_TYPE2", nullable=true)
	public String getSecurity_typ2() {
		return security_typ2;
	}
	public void setSecurity_typ2(String security_typ2) {
		this.security_typ2 = security_typ2;
	}
	@Column(name="EQY_PRIM_EXCH", nullable=true)
	public String getEqy_prim_exch() {
		return eqy_prim_exch;
	}
	public void setEqy_prim_exch(String eqy_prim_exch) {
		this.eqy_prim_exch = eqy_prim_exch;
	}
	@Column(name="DVD_TYP_LAST", nullable=true)
	public String getDvd_typ_last() {
		return dvd_typ_last;
	}
	public void setDvd_typ_last(String dvd_typ_last) {
		this.dvd_typ_last = dvd_typ_last;
	}
	@Column(name="MARKET_SECTOR", nullable=true)
	public String getMarket_sector_des() {
		return market_sector_des;
	}
	public void setMarket_sector_des(String market_sector_des) {
		this.market_sector_des = market_sector_des;
	}
	@Column(name="TICKER", nullable=true)
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@Column(name="COUNTRY", nullable=true)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="DVD_CRNCY", nullable=true)
	public String getDvd_crncy() {
		return dvd_crncy;
	}
	public void setDvd_crncy(String dvd_crncy) {
		this.dvd_crncy = dvd_crncy;
	}
	@Column(name="DVD_FREQ", nullable=true)
	public String getDvd_freq() {
		return dvd_freq;
	}
	public void setDvd_freq(String dvd_freq) {
		this.dvd_freq = dvd_freq;
	}
	@Column(name="EQY_SPLIT_RATIO", nullable=true)
	public String getEqy_split_ratio() {
		return eqy_split_ratio;
	}
	public void setEqy_split_ratio(String eqy_split_ratio) {
		this.eqy_split_ratio = eqy_split_ratio;
	}
	@Column(name="PAR_VAL_CRNCY", nullable=true)
	public String getPar_val_crncy() {
		return par_val_crncy;
	}
	public void setPar_val_crncy(String par_val_crncy) {
		this.par_val_crncy = par_val_crncy;
	}
	@Column(name="EQY_PRIM_SECURITY_TICKER", nullable=true)
	public String getEqy_prim_security_ticker() {
		return eqy_prim_security_ticker;
	}
	public void setEqy_prim_security_ticker(String eqy_prim_security_ticker) {
		this.eqy_prim_security_ticker = eqy_prim_security_ticker;
	}
	@Column(name="ID_MIC_LOCAL", nullable=true)
	public String getId_mic_local_exch() {
		return id_mic_local_exch;
	}
	public void setId_mic_local_exch(String id_mic_local_exch) {
		this.id_mic_local_exch = id_mic_local_exch;
	}
	@Column(name="DVD_PAY_DT", nullable=true)
	public String getDvd_pay_dt() {
		return dvd_pay_dt;
	}
	public void setDvd_pay_dt(String dvd_pay_dt) {
		this.dvd_pay_dt = dvd_pay_dt;
	}
	@Column(name="DVD_RECORD_DT", nullable=true)
	public String getDvd_record_dt() {
		return dvd_record_dt;
	}
	public void setDvd_record_dt(String dvd_record_dt) {
		this.dvd_record_dt = dvd_record_dt;
	}
	@Column(name="DVD_DECLARED_DT", nullable=true)
	public String getDvd_declared_dt() {
		return dvd_declared_dt;
	}
	public void setDvd_declared_dt(String dvd_declared_dt) {
		this.dvd_declared_dt = dvd_declared_dt;
	}
	@Column(name="EQY_SPLIT_DT", nullable=true)
	public String getEqy_split_dt() {
		return eqy_split_dt;
	}
	public void setEqy_split_dt(String eqy_split_dt) {
		this.eqy_split_dt = eqy_split_dt;
	}
	@Column(name="DVD_EX_DT", nullable=true)
	public String getDvd_ex_dt() {
		return dvd_ex_dt;
	}
	public void setDvd_ex_dt(String dvd_ex_dt) {
		this.dvd_ex_dt = dvd_ex_dt;
	}
	@Column(name="LONG_COMP_NAME", nullable=true)
	public String getLong_comp_name() {
		return long_comp_name;
	}
	public void setLong_comp_name(String long_comp_name) {
		this.long_comp_name = long_comp_name;
	}
	@Transient
	@Override
	public String toString() {
		String reply="";
		reply = ToStringBuilder.reflectionToString(this); 
		
		return reply;
	}
	
	
	
}


