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




/*@org.hibernate.annotations.Table(appliesTo="TB_SP_SECURITY_FUND",indexes={
		//@Index(name="IDX_SECFUND_VERSION",columnNames="VERSION"),
		@Index(name="IDX_SECFUND_DELETED",columnNames="ISDELETED")
})*/
@Entity
@Table(name="TB_SP_SECURITY_FUND") 
public class SpSecurityFund implements Serializable {

	private static final long serialVersionUID = 4611694181983860756L;
	private long id=0l;
	
	private String cntry_issue_iso;
	private String id_mic_prim_exch;
	private String fund_incept_dt;
	private String industry_subgroup;
	private String market_status;
	private String rel_index;
	private String fund_objective_long;
	private String fund_strategy;
	private String fund_mgmt_style;
	private String fund_typ;
	private String fund_geo_focus;
	private String fund_asset_class_focus;
	private String sec_des;
	private String id_bb_unique;
	private String id_bb_company;

	private String market_sector_des;
	private String long_comp_name;
	private String dvd_crncy;
	private String dvd_declared_dt;
	private String dvd_ex_dt;
	private String dvd_freq;
	private String dvd_pay_dt;
	private String dvd_record_dt;
	private String dvd_sh_last;
	private String dvd_typ_last;
	private String eqy_prim_exch;
	private String eqy_split_dt;
	private String eqy_split_ratio;
	private String fund_mgr_fee;
	private String fund_min_invest;
	
	private String transfer_agent;
	private String px_trade_lot_size;
	private String cntry_of_incorporation;
	private String fund_management_co;
	private String security_typ2;
	private String fund_open_shr_class;
	private String fund_open_pymnt_shr;
	private String fund_custodian_long;
	private String min_subsequent_invest;
	
	/*private String codigo_SGC;
	private String cod_CVM;
	private String liquidez;
	private String periodicidade_da_cotacao;
	private String simbolo_de_negociacion;
	private String type_of_collateral;
	private String fiscalidade_estrangeira;
	private String fiscalidade_portuguesa;
	*/
	
	
	public SpSecurityFund(){
	
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
	
	@Id
	@SequenceGenerator(name="CASPSECURITYFUND_GEN", sequenceName="CASPSECURITYFUND_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CASPSECURITYFUND_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long _id) {
		this.id = _id;
	}
	

	@Column(name="CNTRY_ISSUE",nullable=true)
	public String getCntry_issue_iso() {
		return cntry_issue_iso;
	}
	public void setCntry_issue_iso(String cntry_issue_iso) {
		this.cntry_issue_iso = cntry_issue_iso;
	}
	
	@Column(name="ID_MIC_PRIM_EXCH",nullable=true)
	public String getId_mic_prim_exch() {
		return id_mic_prim_exch;
	}
	public void setId_mic_prim_exch(String id_mic_prim_exch) {
		this.id_mic_prim_exch = id_mic_prim_exch;
	}

	@Column(name="FUND_INCEPT_DT",nullable=true)
	public String getFund_incept_dt() {
		return fund_incept_dt;
	}
	public void setFund_incept_dt(String fund_incept_dt) {
		this.fund_incept_dt = fund_incept_dt;
	}
	
	
	@Column(name="INDUSTRY_SUBGROUP",nullable=true)
	public String getIndustry_subgroup() {
		return industry_subgroup;
	}
	public void setIndustry_subgroup(String industry_subgroup) {
		this.industry_subgroup = industry_subgroup;
	}
	@Column(name="MARKET_STATUS",nullable=true)
	public String getMarket_status() {
		return market_status;
	}
	public void setMarket_status(String market_status) {
		this.market_status = market_status;
	}
	@Column(name="REL_INDEX",nullable=true)
	public String getRel_index() {
		return rel_index;
	}
	public void setRel_index(String rel_index) {
		this.rel_index = rel_index;
	}
	@Column(name="FUND_OBJECTIVE_LONG",nullable=true)
	public String getFund_objective_long() {
		return fund_objective_long;
	}
	public void setFund_objective_long(String fund_objective_long) {
		this.fund_objective_long = fund_objective_long;
	}
	@Column(name="FUND_STRATEGY",nullable=true)
	public String getFund_strategy() {
		return fund_strategy;
	}
	public void setFund_strategy(String fund_strategy) {
		this.fund_strategy = fund_strategy;
	}
	@Column(name="FUND_MGMT_STYLE",nullable=true)
	public String getFund_mgmt_style() {
		return fund_mgmt_style;
	}
	public void setFund_mgmt_style(String fund_mgmt_style) {
		this.fund_mgmt_style = fund_mgmt_style;
	}
	@Column(name="FUND_TYPE",nullable=true)
	public String getFund_typ() {
		return fund_typ;
	}
	public void setFund_typ(String fund_typ) {
		this.fund_typ = fund_typ;
	}
	@Column(name="FUND_GEO_FOCUS",nullable=true)
	public String getFund_geo_focus() {
		return fund_geo_focus;
	}
	public void setFund_geo_focus(String fund_geo_focus) {
		this.fund_geo_focus = fund_geo_focus;
	}
	@Column(name="FUND_ASSET_CLASS_FOCUS",nullable=true)
	public String getFund_asset_class_focus() {
		return fund_asset_class_focus;
	}
	public void setFund_asset_class_focus(String fund_asset_class_focus) {
		this.fund_asset_class_focus = fund_asset_class_focus;
	}
	
	@Column(name="SEC_DES",nullable=true)
	public String getSec_des() {
		return sec_des;
	}
	public void setSec_des(String sec_des) {
		this.sec_des = sec_des;
	}
	@Column(name="ID_BB_UNIQUE",nullable=true)
	public String getId_bb_unique() {
		return id_bb_unique;
	}
	public void setId_bb_unique(String id_bb_unique) {
		this.id_bb_unique = id_bb_unique;
	}
	@Column(name="ID_BB_COMPANY",nullable=true)
	public String getId_bb_company() {
		return id_bb_company;
	}
	public void setId_bb_company(String id_bb_company) {
		this.id_bb_company = id_bb_company;
	}


	@Column(name="MARKET_SECTOR_DES",nullable=true)
	public String getMarket_sector_des() {
		return market_sector_des;
	}
	public void setMarket_sector_des(String market_sector_des) {
		this.market_sector_des = market_sector_des;
	}
	@Column(name="",nullable=true)
	public String getLong_comp_name() {
		return long_comp_name;
	}
	public void setLong_comp_name(String long_comp_name) {
		this.long_comp_name = long_comp_name;
	}
	@Column(name="DVD_CRNCY",nullable=true)
	public String getDvd_crncy() {
		return dvd_crncy;
	}
	public void setDvd_crncy(String dvd_crncy) {
		this.dvd_crncy = dvd_crncy;
	}
	@Column(name="DVD_DECLARED_DT",nullable=true)
	public String getDvd_declared_dt() {
		return dvd_declared_dt;
	}
	public void setDvd_declared_dt(String dvd_declared_dt) {
		this.dvd_declared_dt = dvd_declared_dt;
	}
	@Column(name="DVD_EX_DT",nullable=true)
	public String getDvd_ex_dt() {
		return dvd_ex_dt;
	}
	public void setDvd_ex_dt(String dvd_ex_dt) {
		this.dvd_ex_dt = dvd_ex_dt;
	}
	@Column(name="DVD_FREQ",nullable=true)
	public String getDvd_freq() {
		return dvd_freq;
	}
	public void setDvd_freq(String dvd_freq) {
		this.dvd_freq = dvd_freq;
	}
	@Column(name="DVD_PAY_DT",nullable=true)
	public String getDvd_pay_dt() {
		return dvd_pay_dt;
	}
	public void setDvd_pay_dt(String dvd_pay_dt) {
		this.dvd_pay_dt = dvd_pay_dt;
	}
	@Column(name="DVD_RECORD_DT",nullable=true)
	public String getDvd_record_dt() {
		return dvd_record_dt;
	}
	public void setDvd_record_dt(String dvd_record_dt) {
		this.dvd_record_dt = dvd_record_dt;
	}
	@Column(name="DVD_SH_LAST",nullable=true)
	public String getDvd_sh_last() {
		return dvd_sh_last;
	}
	public void setDvd_sh_last(String dvd_sh_last) {
		this.dvd_sh_last = dvd_sh_last;
	}
	@Column(name="DVD_TYP_LAST",nullable=true)
	public String getDvd_typ_last() {
		return dvd_typ_last;
	}
	public void setDvd_typ_last(String dvd_typ_last) {
		this.dvd_typ_last = dvd_typ_last;
	}
	@Column(name="EQY_PRIM_EXCH",nullable=true)
	public String getEqy_prim_exch() {
		return eqy_prim_exch;
	}
	public void setEqy_prim_exch(String eqy_prim_exch) {
		this.eqy_prim_exch = eqy_prim_exch;
	}
	@Column(name="EQY_SPLIT_DT",nullable=true)
	public String getEqy_split_dt() {
		return eqy_split_dt;
	}
	public void setEqy_split_dt(String eqy_split_dt) {
		this.eqy_split_dt = eqy_split_dt;
	}
	@Column(name="EQY_SPLIT_RATIO",nullable=true)
	public String getEqy_split_ratio() {
		return eqy_split_ratio;
	}
	public void setEqy_split_ratio(String eqy_split_ratio) {
		this.eqy_split_ratio = eqy_split_ratio;
	}
	@Column(name="FUND_MGR_FEE",nullable=true)
	public String getFund_mgr_fee() {
		return fund_mgr_fee;
	}
	public void setFund_mgr_fee(String fund_mgr_fee) {
		this.fund_mgr_fee = fund_mgr_fee;
	}
	@Column(name="FUND_MIN_INVEST",nullable=true)
	public String getFund_min_invest() {
		return fund_min_invest;
	}
	public void setFund_min_invest(String fund_min_invest) {
		this.fund_min_invest = fund_min_invest;
	}

	@Column(name="TRANSFER_AGENT",nullable=true)
	public String getTransfer_agent() {
		return transfer_agent;
	}
	public void setTransfer_agent(String transfer_agent) {
		this.transfer_agent = transfer_agent;
	}
	@Column(name="PX_TRADE_LOT_SIZE",nullable=true)
	public String getPx_trade_lot_size() {
		return px_trade_lot_size;
	}
	public void setPx_trade_lot_size(String px_trade_lot_size) {
		this.px_trade_lot_size = px_trade_lot_size;
	}
	@Column(name="CNTRY_OF_INCORPORATION",nullable=true)
	public String getCntry_of_incorporation() {
		return cntry_of_incorporation;
	}
	public void setCntry_of_incorporation(String cntry_of_incorporation) {
		this.cntry_of_incorporation = cntry_of_incorporation;
	}
	@Column(name="FUND_MANAGEMENT_CO",nullable=true)
	public String getFund_management_co() {
		return fund_management_co;
	}
	public void setFund_management_co(String fund_management_co) {
		this.fund_management_co = fund_management_co;
	}
	@Column(name="SECURITY_TYPE2",nullable=true)
	public String getSecurity_typ2() {
		return security_typ2;
	}
	public void setSecurity_typ2(String security_typ2) {
		this.security_typ2 = security_typ2;
	}
	@Column(name="FUND_OPEN_SHR_CLASS",nullable=true)
	public String getFund_open_shr_class() {
		return fund_open_shr_class;
	}
	public void setFund_open_shr_class(String fund_open_shr_class) {
		this.fund_open_shr_class = fund_open_shr_class;
	}
	@Column(name="FUND_OPEN_PYMNT_SHR",nullable=true)
	public String getFund_open_pymnt_shr() {
		return fund_open_pymnt_shr;
	}
	public void setFund_open_pymnt_shr(String fund_open_pymnt_shr) {
		this.fund_open_pymnt_shr = fund_open_pymnt_shr;
	}
	@Column(name="FUND_CUSTODIAN_LONG",nullable=true)
	public String getFund_custodian_long() {
		return fund_custodian_long;
	}
	public void setFund_custodian_long(String fund_custodian_long) {
		this.fund_custodian_long = fund_custodian_long;
	}
	@Column(name="MIN_SUBSQUENT_INVEST",nullable=true)
	public String getMin_subsequent_invest() {
		return min_subsequent_invest;
	}
	public void setMin_subsequent_invest(String min_subsequent_invest) {
		this.min_subsequent_invest = min_subsequent_invest;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Transient
	@Override
	public String toString() {
		String reply="";
		reply = ToStringBuilder.reflectionToString(this); 
		
		return reply;
	}

}//
