package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeRFJField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("RFJ:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("RFJ:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("RFJ:35-46:","c�digo isin","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD8("RFJ:47-58:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD9("RFJ:59-60:","tipo activo","STRING",0,"X(02)",null,0,0,"TIPO ACTIVO",false),
	FIELD10("RFJ:61-66:","emisi�n","STRING",0,"X(06)",null,0,0,"EMISI�N",false),
	FIELD11("RFJ:67-67:","�mbito","STRING",0,"X(01)",null,0,0,"�MBITO",false),
	FIELD12("RFJ:68-79:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD13("RFJ:80-159:","nombre largo emisora","STRING",0,"X(80)",null,0,0,"NOMBRE LARGO EMISORA",false),
	FIELD14("RFJ:160-161:","serie","STRING",0,"X(02)",null,0,0,"SERIE",false),
	FIELD15("RFJ:162-177:","nominal unitario","STRING",0,"9(8)V9(08)",null,0,0,"NOMINAL UNITARIO",false),
	FIELD16("RFJ:178-182:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD17("RFJ:183-190:","fecha emisi�n","STRING",0,"X(08)",null,0,0,"FECHA EMISI�N",false),
	FIELD18("RFJ:191-207:","importe total emitido","STRING",0,"9(10)V9(07)",null,0,0,"IMPORTE TOTAL EMITIDO",false),
	FIELD19("RFJ:208-224:","importe total admitido","STRING",0,"9(10)V9(07)",null,0,0,"IMPORTE TOTAL ADMITIDO",false),
	FIELD20("RFJ:225-241:","total t�tulos","STRING",0,"9(10)V9(07)",null,0,0,"TOTAL T�TULOS",false),
	FIELD21("RFJ:242-257:","precio emisi�n","STRING",0,"9(8)V9(08)",null,0,0,"PRECIO EMISI�N",false),
	FIELD22("RFJ:258-265:","fecha admisi�n","STRING",0,"X(08)",null,0,0,"FECHA ADMISI�N",false),
	FIELD23("RFJ:266-266:","tipo cup�n","STRING",0,"X(01)",null,0,0,"TIPO CUP�N",false),
	FIELD24("RFJ:267-275:","tipo inter�s","STRING",0,"9(3)V9(06)",null,0,0,"TIPO INTER�S",false),
	FIELD25("RFJ:276-284:","tipo inter�s nominal","STRING",0,"9(3)V9(06)",null,0,0,"TIPO INTER�S NOMINAL",false),
	FIELD26("RFJ:285-292:","fecha primer pago","STRING",0,"X(08)",null,0,0,"FECHA PRIMER PAGO",false),
	FIELD27("RFJ:293-293:","periodicidad","STRING",0,"X(01)",null,0,0,"PERIODICIDAD",false),
	FIELD28("RFJ:294-294:","tipo amortizaci�n","STRING",0,"X(01)",null,0,0,"TIPO AMORTIZACI�N",false),
	FIELD29("RFJ:295-295:","periodicidad amortizaci�n","STRING",0,"X(01)",null,0,0,"PERIODICIDAD AMORTIZACI�N",false),
	FIELD30("RFJ:296-296:","opci�n amortizaci�n","STRING",0,"X(01)",null,0,0,"OPCI�N AMORTIZACI�N",false),
	FIELD31("RFJ:297-297:","amortizada","STRING",0,"X(01)",null,0,0,"AMORTIZADA",false),
	FIELD32("RFJ:298-305:","fecha inicio amortizaci�n","STRING",0,"X(08)",null,0,0,"FECHA INICIO AMORTIZACI�N",false),
	FIELD33("RFJ:306-313:","fecha fin amortizaci�n","STRING",0,"X(08)",null,0,0,"FECHA FIN AMORTIZACI�N",false),
	FIELD34("RFJ:314-321:","fecha amortizaci�n anticipada","STRING",0,"X(08)",null,0,0,"FECHA AMORTIZACI�N ANTICIPADA",false),
	FIELD35("RFJ:322-322:","situaci�n","STRING",0,"X(01)",null,0,0,"SITUACI�N",false),
	FIELD36("RFJ:323-330:","fecha inicio suscripci�n","STRING",0,"X(08)",null,0,0,"FECHA INICIO SUSCRIPCI�N",false),
	FIELD37("RFJ:331-338:","fecha inicio operaci�n","STRING",0,"X(08)",null,0,0,"FECHA INICIO OPERACI�N",false),
	FIELD38("RFJ:339-346:","fecha fin operaci�n","STRING",0,"X(08)",null,0,0,"FECHA FIN OPERACI�N",false),
	FIELD39("RFJ:347-347:","tipo adjudicaci�n","STRING",0,"X(01)",null,0,0,"TIPO ADJUDICACI�N",false),
	FIELD40("RFJ:348-356:","retenci�n","STRING",0,"9(3)V9(06) ",null,0,0,"RETENCI�N",false),
	FIELD41("RFJ:357-365:","bonificaci�n","STRING",0,"9(3)V9(06) ",null,0,0,"BONIFICACI�N",false),
	FIELD42("RFJ:366-366:","aptitud legal","STRING",0,"X(01)",null,0,0,"APTITUD LEGAL",false),
	FIELD43("RFJ:367-369:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD44("RFJ:370-370:","indicador conversi�n","STRING",0,"X(01)",null,0,0,"INDICADOR CONVERSI�N",false),
	FIELD45("RFJ:371-371:","indicador warrant","STRING",0,"X(01)",null,0,0,"INDICADOR WARRANT",false),
	FIELD46("RFJ:372-387:","valor te�rico derecho","STRING",0,"9(8)V9(08)",null,0,0,"VALOR TE�RICO DERECHO",false),
	FIELD47("RFJ:388-395:","fecha pr�xima amortizaci�n","STRING",0,"X(08)",null,0,0,"FECHA PR�XIMA AMORTIZACI�N",false),
	FIELD48("RFJ:396-403:","fecha pr�xima conversi�n","STRING",0,"X(08)",null,0,0,"FECHA PR�XIMA CONVERSI�N",false),
	FIELD49("RFJ:404-411:","fecha pr�ximo pago cup�n","STRING",0,"X(08)",null,0,0,"FECHA PR�XIMO PAGO CUP�N",false),
	FIELD50("RFJ:412-427:","importe pendiente amortizar","STRING",0,"9(8)V9(08)",null,0,0,"IMPORTE PENDIENTE AMORTIZAR",false),
	FIELD51("RFJ:428-429:","�ndices de referencia","STRING",0,"X(02)",null,0,0,"�NDICES DE REFERENCIA",false),
	FIELD52("RFJ:430-437:","fecha desembolso","STRING",0,"X(08)",null,0,0,"FECHA DESEMBOLSO",false),
	FIELD53("RFJ:438-441:","entidad agente","STRING",0,"X(04)",null,0,0,"ENTIDAD AGENTE",false),
	FIELD54("RFJ:442-453:","cif emisor","STRING",0,"X(12)",null,0,0,"CIF EMISOR",false),
	FIELD55("RFJ:454-470:","petici�n m�xima","STRING",0,"9(10)V9(07)",null,0,0,"PETICI�N M�XIMA",false),
	FIELD56("RFJ:471-487:","petici�n m�nima","STRING",0,"9(10)V9(07)",null,0,0,"PETICI�N M�NIMA",false),
	FIELD57("RFJ:488-492:","c�digo bolsa madrid","STRING",0,"X(05)",null,0,0,"C�DIGO BOLSA MADRID",false),
	FIELD58("RFJ:493-1028:","filler","STRING",0,"X(536)",null,0,0,"FILLER",true),
	FIELD59(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD60(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD61(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD62(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD63(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD64(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD65(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeRFJField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
