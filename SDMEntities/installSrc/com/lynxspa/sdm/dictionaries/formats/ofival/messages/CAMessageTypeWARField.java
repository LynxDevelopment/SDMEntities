package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeWARField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("WAR:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("WAR:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("WAR:35-46:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD8("WAR:47-54:","fecha actualización","STRING",0,"X(08)",null,0,0,"FECHA ACTUALIZACIÓN",false),
	FIELD9("WAR:55-59:","código contratación","STRING",0,"X(05)",null,0,0,"CÓDIGO CONTRATACIÓN",false),
	FIELD10("WAR:60-61:","tipo de mercado","STRING",0,"X(02)",null,0,0,"TIPO DE MERCADO",false),
	FIELD11("WAR:62-63:","sistema contratación","STRING",0,"X(02)",null,0,0,"SISTEMA CONTRATACIÓN",false),
	FIELD12("WAR:64-64:","tipo warrants","STRING",0,"X(01)",null,0,0,"TIPO WARRANTS",false),
	FIELD13("WAR:65-104:","nombre warrants","STRING",0,"X(40)",null,0,0,"NOMBRE WARRANTS",false),
	FIELD14("WAR:105-184:","nombre warrants","STRING",0,"X(80)",null,0,0,"NOMBRE WARRANTS",false),
	FIELD15("WAR:185-201:","total admitidos","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL ADMITIDOS",false),
	FIELD16("WAR:202-206:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD17("WAR:207-207:","clase warrants","STRING",0,"X(01)",null,0,0,"CLASE WARRANTS",false),
	FIELD18("WAR:208-208:","tipo ejercicio","STRING",0,"X(01)",null,0,0,"TIPO EJERCICIO",false),
	FIELD19("WAR:209-224:","precio de ejercicio","STRING",0,"9(08)V9(8)",null,0,0,"PRECIO DE EJERCICIO",false),
	FIELD20("WAR:225-227:","divisa ejercicio","STRING",0,"X(03)",null,0,0,"DIVISA EJERCICIO",false),
	FIELD21("WAR:228-228:","indicador perpetuo","STRING",0,"X(01)",null,0,0,"INDICADOR PERPETUO",false),
	FIELD22("WAR:229-236:","fecha vencimiento","STRING",0,"X(08)",null,0,0,"FECHA VENCIMIENTO",false),
	FIELD23("WAR:237-237:","indicador liquidación","STRING",0,"X(01)",null,0,0,"INDICADOR LIQUIDACIÓN",false),
	FIELD24("WAR:238-254:","total títulos emitidos","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL TÍTULOS EMITIDOS",false),
	FIELD25("WAR:255-262:","fecha emisión","STRING",0,"X(08)",null,0,0,"FECHA EMISIÓN",false),
	FIELD26("WAR:263-278:","precio emisión","STRING",0,"9(08)V9(8)",null,0,0,"PRECIO EMISIÓN",false),
	FIELD27("WAR:279-298:","paridad-ratio","STRING",0,"X(20)",null,0,0,"PARIDAD-RATIO",false),
	FIELD28("WAR:299-310:","código isin subyacente","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN SUBYACENTE",false),
	FIELD29("WAR:311-390:","nombre subyacente","STRING",0,"X(80)",null,0,0,"NOMBRE SUBYACENTE",false),
	FIELD30("WAR:391-392:","tipo subyacente","STRING",0,"X(02)",null,0,0,"TIPO SUBYACENTE",false),
	FIELD31("WAR:393-395:","divisa subyacente","STRING",0,"X(03)",null,0,0,"DIVISA SUBYACENTE",false),
	FIELD32("WAR:396-435:","nombre largo emisora","STRING",0,"X(40)",null,0,0,"NOMBRE LARGO EMISORA",false),
	FIELD33("WAR:436-436:","tipo cotización","STRING",0,"X(01)",null,0,0,"TIPO COTIZACIÓN",false),
	FIELD34("WAR:437-437:","estilo","STRING",0,"X(01)",null,0,0,"ESTILO",false),
	FIELD35("WAR:438-445:","fecha admisión","STRING",0,"X(08)",null,0,0,"FECHA ADMISIÓN",false),
	FIELD36("WAR:446-465:","situación","STRING",0,"X(20)",null,0,0,"SITUACIÓN",false),
	FIELD37("WAR:466-1028:","filler","STRING",0,"X(563)",null,0,0,"FILLER",true),
	FIELD38(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD39(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD40(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD41(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD42(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD43(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD44(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeWARField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
