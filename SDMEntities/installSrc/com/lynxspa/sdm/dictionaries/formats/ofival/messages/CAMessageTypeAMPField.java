package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeAMPField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("AMP:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("AMP:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("AMP:35-39:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD8("AMP:40-51:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD9("AMP:52-54:","hecho relevante","STRING",0,"X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD10("AMP:55-62:","fecha inicio","STRING",0,"X(08)",null,0,0,"FECHA INICIO",false),
	FIELD11("AMP:63-65:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD12("AMP:66-73:","fecha fin","STRING",0,"X(08)",null,0,0,"FECHA FIN",false),
	FIELD13("AMP:74-81:","fecha acuerdo","STRING",0,"X(08)",null,0,0,"FECHA ACUERDO",false),
	FIELD14("AMP:82-89:","fecha oferta","STRING",0,"X(08)",null,0,0,"FECHA OFERTA",false),
	FIELD15("AMP:90-105:","nominal total","STRING",0,"9(14)V9(2)",null,0,0,"NOMINAL TOTAL",false),
	FIELD16("AMP:106-122:","total valores","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES",false),
	FIELD17("AMP:123-137:","numeraci�n inicial","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL",false),
	FIELD18("AMP:138-152:","numeraci�n final","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL",false),
	FIELD19("AMP:153-153:","clase","STRING",0,"X(01)",null,0,0,"CLASE",false),
	FIELD20("AMP:154-154:","naturaleza","STRING",0,"X(01)",null,0,0,"NATURALEZA",false),
	FIELD21("AMP:155-156:","serie","STRING",0,"X(02)",null,0,0,"SERIE",false),
	FIELD22("AMP:157-172:","nominal unitario","STRING",0,"9(8)V9(8)",null,0,0,"NOMINAL UNITARIO",false),
	FIELD23("AMP:173-189:","proporci�n anterior","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N ANTERIOR",false),
	FIELD24("AMP:190-206:","proporci�n posterior","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N POSTERIOR",false),
	FIELD25("AMP:207-207:","derechos","STRING",0,"X(01)",null,0,0,"DERECHOS",false),
	FIELD26("AMP:208-210:","cup�n","STRING",0,"9(03)",null,0,0,"CUP�N",false),
	FIELD27("AMP:211-226:","valor te�rico derecho","STRING",0,"9(8)V9(8)",null,0,0,"VALOR TE�RICO DERECHO",false),
	FIELD28("AMP:227-242:","valor te�rico convertibles","STRING",0,"9(8)V9(8)",null,0,0,"VALOR TE�RICO CONVERTIBLES",false),
	FIELD29("AMP:243-243:","tipo","STRING",0,"X(01)",null,0,0,"TIPO",false),
	FIELD30("AMP:244-259:","precio","STRING",0,"9(8)V9(8)",null,0,0,"PRECIO",false),
	FIELD31("AMP:260-275:","desembolso","STRING",0,"9(8)V9(8)",null,0,0,"DESEMBOLSO",false),
	FIELD32("AMP:276-291:","desembolso pasivo 1","STRING",0,"9(8)V9(8)",null,0,0,"DESEMBOLSO PASIVO 1",false),
	FIELD33("AMP:292-299:","fecha desembolso pasivo 1","STRING",0,"X(08)",null,0,0,"FECHA DESEMBOLSO PASIVO 1",false),
	FIELD34("AMP:300-315:","desembolso pasivo 2","STRING",0,"9(8)V9(8)",null,0,0,"DESEMBOLSO PASIVO 2",false),
	FIELD35("AMP:316-323:","fecha desembolso pasivo 2","STRING",0,"X(08)",null,0,0,"FECHA DESEMBOLSO PASIVO 2",false),
	FIELD36("AMP:324-339:","gastos suscriptor","STRING",0,"9(8)V9(8)",null,0,0,"GASTOS SUSCRIPTOR",false),
	FIELD37("AMP:340-348:","% liberado","STRING",0,"9(3)V9(6)",null,0,0,"% LIBERADO",false),
	FIELD38("AMP:349-356:","fecha derechos pol�ticos","STRING",0,"X(08)",null,0,0,"FECHA DERECHOS POL�TICOS",false),
	FIELD39("AMP:357-364:","fecha beneficios","STRING",0,"X(08)",null,0,0,"FECHA BENEFICIOS",false),
	FIELD40("AMP:365-372:","fecha derecho dividendo","STRING",0,"X(08)",null,0,0,"FECHA DERECHO DIVIDENDO",false),
	FIELD41("AMP:373-384:","c�digo isin nuevas","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN NUEVAS",false),
	FIELD42("AMP:385-396:","c�digo isin derechos","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN DERECHOS",false),
	FIELD43("AMP:397-397:","transmisibilidad","STRING",0,"X(01)",null,0,0,"TRANSMISIBILIDAD",false),
	FIELD44("AMP:398-398:","representaci�n","STRING",0,"X(01)",null,0,0,"REPRESENTACI�N",false),
	FIELD45("AMP:399-401:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD46("AMP:402-404:","divisa negociaci�n","STRING",0,"X(03)",null,0,0,"DIVISA NEGOCIACI�N",false),
	FIELD47("AMP:405-420:","menor derecho","STRING",0,"9(8)V9(8)",null,0,0,"MENOR DERECHO",false),
	FIELD48("AMP:421-421:","indicador de liberado","STRING",0,"X(01)",null,0,0,"INDICADOR DE LIBERADO",false),
	FIELD49("AMP:422-429:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD50("AMP:430-437:","fecha desembolso","STRING",0,"X(08)",null,0,0,"FECHA DESEMBOLSO",false),
	FIELD51("AMP:438-441:","entidad agente","STRING",0,"X(04)",null,0,0,"ENTIDAD AGENTE",false),
	FIELD52("AMP:442-443:","sistema de contrataci�n","STRING",0,"X(02)",null,0,0,"SISTEMA DE CONTRATACI�N",false),
	FIELD53("AMP:444-444:","bolsa negociaci�n derechos","STRING",0,"X(01)",null,0,0,"BOLSA NEGOCIACI�N DERECHOS",false),
	FIELD54("AMP:445-445:","periodo de suscripci�n","STRING",0,"X(01)",null,0,0,"PERIODO DE SUSCRIPCI�N",false),
	FIELD55("AMP:446-453:","fecha inicio ordinario","STRING",0,"X(08)",null,0,0,"FECHA INICIO ORDINARIO",false),
	FIELD56("AMP:454-461:","fecha fin ordinario","STRING",0,"X(08)",null,0,0,"FECHA FIN ORDINARIO",false),
	FIELD57("AMP:462-469:","fecha inicio complementario","STRING",0,"X(08)",null,0,0,"FECHA INICIO COMPLEMENTARIO",false),
	FIELD58("AMP:470-477:","fecha fin complementario","STRING",0,"X(08)",null,0,0,"FECHA FIN COMPLEMENTARIO",false),
	FIELD59("AMP:478-485:","fecha inicio preferente","STRING",0,"X(08)",null,0,0,"FECHA INICIO PREFERENTE",false),
	FIELD60("AMP:486-493:","fecha fin preferente","STRING",0,"X(08)",null,0,0,"FECHA FIN PREFERENTE",false),
	FIELD61("AMP:494-494:","tipo (libre/condicionado)","STRING",0,"X(01)",null,0,0,"TIPO (LIBRE/CONDICIONADO)",false),
	FIELD62("AMP:495-511:","m�ximo petici�n tramo2","STRING",0,"9(10)V9(7)",null,0,0,"M�XIMO PETICI�N TRAMO2",false),
	FIELD63("AMP:512-528:","m�nimo petici�n tramo","STRING",0,"9(10)V9(7)",null,0,0,"M�NIMO PETICI�N TRAMO",false),
	FIELD64("AMP:529-1028:","filler","STRING",0,"X(500)",null,0,0,"FILLER",true),
	FIELD65(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD66(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD67(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD68(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD69(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD70(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD71(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


	private String path=null; 
	private String fieldName=null; 
	private int fieldLength=0; 
	private String fieldType=null; 
	private String fieldFormat=null; 
	private String displayGroup=null; 
	private int displayRow=0; 
	private int displayColumn=0; 
	private String description=null;
	private boolean hidden=false;

	
	CAMessageTypeAMPField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
		this.path=_path;
		this.fieldName=_fieldName;
		this.fieldLength=_fieldLength;
		this.fieldType=_fieldType;
		this.fieldFormat=_fieldFormat;
		this.displayGroup=_displayGroup;
		this.displayRow=_displayRow;
		this.displayColumn=_displayColumn;
		this.description=_description;
		this.hidden=_hidden;
	}

	
	public String getPath() {
		return path;
	}
	public String getFieldName() {
		return fieldName;
	}
	public int getFieldLength() {
		return fieldLength;
	}
	public String getFieldType() {
		return fieldType;
	}
	public String getFieldFormat() {
		return fieldFormat;
	}
	public String getDisplayGroup() {
		return displayGroup;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public int getDisplayColumn() {
		return displayColumn;
	}
	public String getDescription() {
		return description;
	}
	public boolean getHidden() {
		return hidden;
	}
}
