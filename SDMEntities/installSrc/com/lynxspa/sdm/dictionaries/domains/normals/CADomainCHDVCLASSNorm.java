package com.lynxspa.sdm.dictionaries.domains.normals;

import com.lynxspa.entities.application.domains.adapters.DomainNormDictAdapter;

public enum CADomainCHDVCLASSNorm implements DomainNormDictAdapter {

	NORMAL1("CANC","Cancelled"),
	NORMAL2("CAGS","class.capital.gains"),
	NORMAL3("DAAC","class.daily.accrual"),
	NORMAL4("DEFR","class.deferred"),
	NORMAL5("DISC","class.discontinued"),
	NORMAL6("DIST","class.distribution"),
	NORMAL7("ESTD","class.estimated"),
	NORMAL8("VINT","class.fifth.interim"),
	NORMAL9("FINAL","class.final"),
	NORMAL10("IINT","class.first.interim"),
	NORMAL11("FINT","class.fourth.interim"),
	NORMAL12("INCM","class.income"),
	NORMAL13("ICNT","class.income.notra"),
	NORMAL14("IOCP","class.interest.oncap"),
	NORMAL15("INTM","class.interim"),
	NORMAL16("LIQI","class.liquidation"),
	NORMAL17("LIQU","class.liquidation"),
	NORMAL18("LTCG","class.lt.cap.gain"),
	NORMAL19("MEMO","class.memorial"),
	NORMAL20("MISC","class.misc"),
	NORMAL21("MISAA","class.misc.adjall"),
	NORMAL22("MISAP","class.misc.adjprc"),
	NORMAL23("NDPD","class.no.dvd.period"),
	NORMAL24("OMIT","class.omited"),
	NORMAL25("PNSD","class.partnership.dst"),
	NORMAL26("PFRR","class.pfd.rights.redemption"),
	NORMAL27("PROW","class.proceds.warrants"),
	NORMAL28("PFDR","class.proceeds.rights"),
	NORMAL29("PROS","class.proceeds.shares"),
	NORMAL30("PRAT","class.pro.rata"),
	NORMAL31("RCAT","class.return.capital"),
	NORMAL32("RCAP","class.return.capital.adjprc"),
	NORMAL33("RCAA","class.return.capital.adjustall"),
	NORMAL34("RCNT","class.return.capital.notra"),
	NORMAL35("REPR","class.return.premium"),
	NORMAL36("RTRP","class.rights.redemtpion"),
	NORMAL37("SINT","class.second.interim"),
	NORMAL38("SPNT","class.spec.prc.notra"),
	NORMAL39("STCG","class.st.cap.gain"),
	NORMAL40("SRCA","class.storm.reform.cash"),
	NORMAL41("TINT","class.third.interim"),
	NORMAL42("RECA","regular.cash"),
	NORMAL43("SAPR","spec.adj.prc"),
	NORMAL44("SPCA","special.cash");
	
	
	private String code=null;
	private String description=null;
	
	
	CADomainCHDVCLASSNorm(String _code,String _description){
		this.code=_code;
		this.description=_description;
	}
	
	
	public String getCode() {
		return this.code;
	}
	public String getDescription() {
		return this.description;
	}
}
