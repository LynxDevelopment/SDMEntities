package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeDEVField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("DEV:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("DEV:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("DEV:35-39:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD8("DEV:40-51:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD9("DEV:52-54:","hecho relevante","STRING",0,"X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD10("DEV:55-66:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD11("DEV:67-78:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD12("DEV:79-86:","fecha pago","STRING",0,"X(08)",null,0,0,"FECHA PAGO",false),
	FIELD13("DEV:87-89:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD14("DEV:90-90:","tipo","STRING",0,"X(01)",null,0,0,"TIPO",false),
	FIELD15("DEV:91-106:","bruto","STRING",0,"9(08)V9(8)",null,0,0,"BRUTO",false),
	FIELD16("DEV:107-122:","neto","STRING",0,"9(08)V9(8)",null,0,0,"NETO",false),
	FIELD17("DEV:123-202:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD18("DEV:203-211:","retención","STRING",0,"9(03)V9(6)",null,0,0,"RETENCIÓN",false),
	FIELD19("DEV:212-214:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD20("DEV:215-222:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD21("DEV:223-226:","entidad pagadora 1","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 1",false),
	FIELD22("DEV:227-230:","entidad pagadora 2","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 2",false),
	FIELD23("DEV:231-234:","entidad pagadora 3","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 3",false),
	FIELD24("DEV:235-238:","entidad pagadora 4","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 4",false),
	FIELD25("DEV:239-242:","entidad pagadora 5","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 5",false),
	FIELD26("DEV:243-246:","entidad pagadora 6","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 6",false),
	FIELD27("DEV:247-250:","entidad pagadora 7","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 7",false),
	FIELD28("DEV:251-254:","entidad pagadora 8","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 8",false),
	FIELD29("DEV:255-258:","entidad pagadora 9","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 9",false),
	FIELD30("DEV:259-262:","entidad pagadora 10","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 10",false),
	FIELD31("DEV:263-270:","fecha acuerdo","STRING",0,"X(08)",null,0,0,"FECHA ACUERDO",false),
	FIELD32("DEV:271-1028:","filler","STRING",0,"X(258)",null,0,0,"FILLER",true),
	FIELD33(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD34(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD35(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD36(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD37(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD38(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD39(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeDEVField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
