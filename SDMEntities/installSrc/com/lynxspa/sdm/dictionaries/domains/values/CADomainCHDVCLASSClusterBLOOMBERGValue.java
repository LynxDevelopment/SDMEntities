package com.lynxspa.sdm.dictionaries.domains.values;

import com.lynxspa.entities.application.domains.adapters.DomainValueDictAdapter;

public enum CADomainCHDVCLASSClusterBLOOMBERGValue implements DomainValueDictAdapter {

	VALUE1("RECA","1000"),
	VALUE2("SPCA","1001"),
	VALUE3("SAPR","1002"),
	VALUE4("INTM","1003"),
	VALUE5("SINT","1004"),
	VALUE6("TINT","1005"),
	VALUE7("FINT","1006"),
	VALUE8("VINT","1007"),
	VALUE9("INCM","1008"),
	VALUE10("CAGS","1009"),
	VALUE11("ESTD","1010"),
	VALUE12("MEMO","1011"),
	VALUE13("PNSD","1012"),
	VALUE14("FINAL","1013"),
	VALUE15("RCAT","1014"),
	VALUE16("RCAP","1015"),
	VALUE17("RCAA","1016"),
	VALUE18("RTRP","1017"),
	VALUE19("LIQU","1018"),
	VALUE20("OMIT","1019"),
	VALUE21("DISC","1020"),
	VALUE22("MISC","1021"),
	VALUE23("MISAP","1022"),
	VALUE24("MISAA","1023"),
	VALUE25("IOCP","1024"),
	VALUE26("LIQI","1025"),
	VALUE27("PFRR","1027"),
	VALUE28("PFDR","1028"),
	VALUE29("PROS","1029"),
	VALUE30("PROW","1030"),
	VALUE31("IINT","1031"),
	VALUE32("DIST","1032"),
	VALUE33("NDPD","1033"),
	VALUE34("LTCG","1034"),
	VALUE35("CANC","1038"),
	VALUE36("DEFR","1039"),
	VALUE37("ICNT","1041"),
	VALUE38("DAAC","1042"),
	VALUE39("PRAT","1040"),
	VALUE40("RCNT","1037"),
	VALUE41("REPR","1026"),
	VALUE42("SPNT","1036"),
	VALUE43("SRCA","1043"),
	VALUE44("STCG","1035");
	
	
	private String normalCode=null;
	private String value=null;
	
	
	CADomainCHDVCLASSClusterBLOOMBERGValue(String _normalCode,String _value){
		this.normalCode=_normalCode;
		this.value=_value;
	}
	
	
	public String getNormalCode() {
		return this.normalCode;
	}
	public String getValue() {
		return this.value;
	}
}
