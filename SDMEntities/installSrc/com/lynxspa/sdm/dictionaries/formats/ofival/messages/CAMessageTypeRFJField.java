package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeRFJField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("RFJ:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("RFJ:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("RFJ:35-46:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD8("RFJ:47-58:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD9("RFJ:59-60:","tipo activo","STRING",0,"X(02)",null,0,0,"TIPO ACTIVO",false),
	FIELD10("RFJ:61-66:","emisión","STRING",0,"X(06)",null,0,0,"EMISIÓN",false),
	FIELD11("RFJ:67-67:","ámbito","STRING",0,"X(01)",null,0,0,"ÁMBITO",false),
	FIELD12("RFJ:68-79:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD13("RFJ:80-159:","nombre largo emisora","STRING",0,"X(80)",null,0,0,"NOMBRE LARGO EMISORA",false),
	FIELD14("RFJ:160-161:","serie","STRING",0,"X(02)",null,0,0,"SERIE",false),
	FIELD15("RFJ:162-177:","nominal unitario","STRING",0,"9(8)V9(08)",null,0,0,"NOMINAL UNITARIO",false),
	FIELD16("RFJ:178-182:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD17("RFJ:183-190:","fecha emisión","STRING",0,"X(08)",null,0,0,"FECHA EMISIÓN",false),
	FIELD18("RFJ:191-207:","importe total emitido","STRING",0,"9(10)V9(07)",null,0,0,"IMPORTE TOTAL EMITIDO",false),
	FIELD19("RFJ:208-224:","importe total admitido","STRING",0,"9(10)V9(07)",null,0,0,"IMPORTE TOTAL ADMITIDO",false),
	FIELD20("RFJ:225-241:","total títulos","STRING",0,"9(10)V9(07)",null,0,0,"TOTAL TÍTULOS",false),
	FIELD21("RFJ:242-257:","precio emisión","STRING",0,"9(8)V9(08)",null,0,0,"PRECIO EMISIÓN",false),
	FIELD22("RFJ:258-265:","fecha admisión","STRING",0,"X(08)",null,0,0,"FECHA ADMISIÓN",false),
	FIELD23("RFJ:266-266:","tipo cupón","STRING",0,"X(01)",null,0,0,"TIPO CUPÓN",false),
	FIELD24("RFJ:267-275:","tipo interés","STRING",0,"9(3)V9(06)",null,0,0,"TIPO INTERÉS",false),
	FIELD25("RFJ:276-284:","tipo interés nominal","STRING",0,"9(3)V9(06)",null,0,0,"TIPO INTERÉS NOMINAL",false),
	FIELD26("RFJ:285-292:","fecha primer pago","STRING",0,"X(08)",null,0,0,"FECHA PRIMER PAGO",false),
	FIELD27("RFJ:293-293:","periodicidad","STRING",0,"X(01)",null,0,0,"PERIODICIDAD",false),
	FIELD28("RFJ:294-294:","tipo amortización","STRING",0,"X(01)",null,0,0,"TIPO AMORTIZACIÓN",false),
	FIELD29("RFJ:295-295:","periodicidad amortización","STRING",0,"X(01)",null,0,0,"PERIODICIDAD AMORTIZACIÓN",false),
	FIELD30("RFJ:296-296:","opción amortización","STRING",0,"X(01)",null,0,0,"OPCIÓN AMORTIZACIÓN",false),
	FIELD31("RFJ:297-297:","amortizada","STRING",0,"X(01)",null,0,0,"AMORTIZADA",false),
	FIELD32("RFJ:298-305:","fecha inicio amortización","STRING",0,"X(08)",null,0,0,"FECHA INICIO AMORTIZACIÓN",false),
	FIELD33("RFJ:306-313:","fecha fin amortización","STRING",0,"X(08)",null,0,0,"FECHA FIN AMORTIZACIÓN",false),
	FIELD34("RFJ:314-321:","fecha amortización anticipada","STRING",0,"X(08)",null,0,0,"FECHA AMORTIZACIÓN ANTICIPADA",false),
	FIELD35("RFJ:322-322:","situación","STRING",0,"X(01)",null,0,0,"SITUACIÓN",false),
	FIELD36("RFJ:323-330:","fecha inicio suscripción","STRING",0,"X(08)",null,0,0,"FECHA INICIO SUSCRIPCIÓN",false),
	FIELD37("RFJ:331-338:","fecha inicio operación","STRING",0,"X(08)",null,0,0,"FECHA INICIO OPERACIÓN",false),
	FIELD38("RFJ:339-346:","fecha fin operación","STRING",0,"X(08)",null,0,0,"FECHA FIN OPERACIÓN",false),
	FIELD39("RFJ:347-347:","tipo adjudicación","STRING",0,"X(01)",null,0,0,"TIPO ADJUDICACIÓN",false),
	FIELD40("RFJ:348-356:","retención","STRING",0,"9(3)V9(06) ",null,0,0,"RETENCIÓN",false),
	FIELD41("RFJ:357-365:","bonificación","STRING",0,"9(3)V9(06) ",null,0,0,"BONIFICACIÓN",false),
	FIELD42("RFJ:366-366:","aptitud legal","STRING",0,"X(01)",null,0,0,"APTITUD LEGAL",false),
	FIELD43("RFJ:367-369:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD44("RFJ:370-370:","indicador conversión","STRING",0,"X(01)",null,0,0,"INDICADOR CONVERSIÓN",false),
	FIELD45("RFJ:371-371:","indicador warrant","STRING",0,"X(01)",null,0,0,"INDICADOR WARRANT",false),
	FIELD46("RFJ:372-387:","valor teórico derecho","STRING",0,"9(8)V9(08)",null,0,0,"VALOR TEÓRICO DERECHO",false),
	FIELD47("RFJ:388-395:","fecha próxima amortización","STRING",0,"X(08)",null,0,0,"FECHA PRÓXIMA AMORTIZACIÓN",false),
	FIELD48("RFJ:396-403:","fecha próxima conversión","STRING",0,"X(08)",null,0,0,"FECHA PRÓXIMA CONVERSIÓN",false),
	FIELD49("RFJ:404-411:","fecha próximo pago cupón","STRING",0,"X(08)",null,0,0,"FECHA PRÓXIMO PAGO CUPÓN",false),
	FIELD50("RFJ:412-427:","importe pendiente amortizar","STRING",0,"9(8)V9(08)",null,0,0,"IMPORTE PENDIENTE AMORTIZAR",false),
	FIELD51("RFJ:428-429:","índices de referencia","STRING",0,"X(02)",null,0,0,"ÍNDICES DE REFERENCIA",false),
	FIELD52("RFJ:430-437:","fecha desembolso","STRING",0,"X(08)",null,0,0,"FECHA DESEMBOLSO",false),
	FIELD53("RFJ:438-441:","entidad agente","STRING",0,"X(04)",null,0,0,"ENTIDAD AGENTE",false),
	FIELD54("RFJ:442-453:","cif emisor","STRING",0,"X(12)",null,0,0,"CIF EMISOR",false),
	FIELD55("RFJ:454-470:","petición máxima","STRING",0,"9(10)V9(07)",null,0,0,"PETICIÓN MÁXIMA",false),
	FIELD56("RFJ:471-487:","petición mínima","STRING",0,"9(10)V9(07)",null,0,0,"PETICIÓN MÍNIMA",false),
	FIELD57("RFJ:488-492:","código bolsa madrid","STRING",0,"X(05)",null,0,0,"CÓDIGO BOLSA MADRID",false),
	FIELD58("RFJ:493-1028:","filler","STRING",0,"X(536)",null,0,0,"FILLER",true),
	FIELD59(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD60(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD61(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD62(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD63(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD64(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
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
