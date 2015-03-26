package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeCVCField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("CVC:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("CVC:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("CVC:35-39:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD8("CVC:40-51:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD9("CVC:52-63:","c�digo isin","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD10("CVC:64-66:","hecho relevante","STRING",0,"X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD11("CVC:67-69:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD12("CVC:70-70:","clase junta","STRING",0,"X(01)",null,0,0,"CLASE JUNTA",false),
	FIELD13("CVC:71-78:","fecha primera convocatoria","STRING",0,"X(08)",null,0,0,"FECHA PRIMERA CONVOCATORIA",false),
	FIELD14("CVC:79-86:","hora primera convocatoria","STRING",0,"X(08)",null,0,0,"HORA PRIMERA CONVOCATORIA",false),
	FIELD15("CVC:87-94:","fecha segunda convocatoria","STRING",0,"X(08)",null,0,0,"FECHA SEGUNDA CONVOCATORIA",false),
	FIELD16("CVC:95-102:","hora segunda convocatoria","STRING",0,"X(08)",null,0,0,"HORA SEGUNDA CONVOCATORIA",false),
	FIELD17("CVC:103-119:","m�nimo exigido","STRING",0,"9(10)V9(07)",null,0,0,"M�NIMO EXIGIDO",false),
	FIELD18("CVC:120-122:","d�as derecho de asistencia","STRING",0,"X(03)",null,0,0,"D�AS DERECHO DE ASISTENCIA",false),
	FIELD19("CVC:123-138:","prima bruta","STRING",0,"9(8)V9(8)",null,0,0,"PRIMA BRUTA",false),
	FIELD20("CVC:139-154:","prima neta","STRING",0,"9(8)V9(8)",null,0,0,"PRIMA NETA",false),
	FIELD21("CVC:155-188:","direcci�n","STRING",0,"X(34)",null,0,0,"DIRECCI�N",false),
	FIELD22("CVC:189-190:","tipo v�a","STRING",0,"X(02)",null,0,0,"TIPO V�A",false),
	FIELD23("CVC:191-220:","nombre v�a","STRING",0,"X(30)",null,0,0,"NOMBRE V�A",false),
	FIELD24("CVC:221-225:","numero v�a","STRING",0,"9(05)",null,0,0,"NUMERO V�A",false),
	FIELD25("CVC:226-228:","piso","STRING",0,"9(03)",null,0,0,"PISO",false),
	FIELD26("CVC:229-229:","letra","STRING",0,"X(01)",null,0,0,"LETRA",false),
	FIELD27("CVC:230-259:","plaza","STRING",0,"X(30)",null,0,0,"PLAZA",false),
	FIELD28("CVC:260-264:","c�digo postal","STRING",0,"9(05)",null,0,0,"C�DIGO POSTAL",false),
	FIELD29("CVC:265-344:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD30("CVC:345-346:","tipo acuerdo","STRING",0,"X(02)",null,0,0,"TIPO ACUERDO",false),
	FIELD31("CVC:347-349:","divisa prima","STRING",0,"X(03)",null,0,0,"DIVISA PRIMA",false),
	FIELD32("CVC:350-357:","fecha del derecho","STRING",0,"X(08)",null,0,0,"FECHA DEL DERECHO",false),
	FIELD33("CVC:358-365:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD34("CVC:366-369:","entidad pagadora","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA",false),
	FIELD35("CVC:370-378:","retenci�n","STRING",0,"9(03)V9(06)",null,0,0,"RETENCI�N",false),
	FIELD36("CVC:379-394:","orden del dia","STRING",0,"X(16)",null,0,0,"ORDEN DEL DIA",false),
	FIELD37("CVC:395-405:","tel�fono atenci�n accionista","STRING",0,"X(11)",null,0,0,"TEL�FONO ATENCI�N ACCIONISTA",false),
	FIELD38("CVC:406-406:","indicador prima","STRING",0,"X(01)",null,0,0,"INDICADOR PRIMA",false),
	FIELD39("CVC:407-1028:","filler","STRING",0,"X(622)",null,0,0,"FILLER",true),
	FIELD40(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD41(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD42(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD43(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD44(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD45(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD46(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeCVCField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
