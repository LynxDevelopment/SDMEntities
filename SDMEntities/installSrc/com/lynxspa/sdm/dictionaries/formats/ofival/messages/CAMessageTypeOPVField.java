package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeOPVField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("OPV:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("OPV:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("OPV:35-39:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD8("OPV:40-51:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD9("OPV:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("OPV:64-64:","concepto","STRING",0," X(01)",null,0,0,"CONCEPTO",false),
	FIELD11("OPV:65-67:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD12("OPV:68-70:","hecho relevante","STRING",0,"X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD13("OPV:71-78:","fecha inicio oferta","STRING",0," X(08)",null,0,0,"FECHA INICIO OFERTA",false),
	FIELD14("OPV:79-86:","fecha fin oferta","STRING",0,"X(08)",null,0,0,"FECHA FIN OFERTA",false),
	FIELD15("OPV:87-91:","código oferente","STRING",0," X(05)",null,0,0,"CÓDIGO OFERENTE",false),
	FIELD16("OPV:92-131:","nombre oferente","STRING",0,"X(40)",null,0,0,"NOMBRE OFERENTE",false),
	FIELD17("OPV:132-139:","fecha fijación precio","STRING",0," X(08)",null,0,0,"FECHA FIJACIÓN PRECIO",false),
	FIELD18("OPV:140-147:","fecha fijación máximo","STRING",0," X(08)",null,0,0,"FECHA FIJACIÓN MÁXIMO",false),
	FIELD19("OPV:148-164:","total ofertado","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL OFERTADO",false),
	FIELD20("OPV:165-165:","green shoe","STRING",0,"X(01)",null,0,0,"GREEN SHOE",false),
	FIELD21("OPV:166-182:","total green shoe","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL GREEN SHOE",false),
	FIELD22("OPV:183-190:","fecha adjudicación","STRING",0,"X(08)",null,0,0,"FECHA ADJUDICACIÓN",false),
	FIELD23("OPV:191-198:","fecha cancelación","STRING",0," X(08)",null,0,0,"FECHA CANCELACIÓN",false),
	FIELD24("OPV:199-278:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD25("OPV:279-286:","fecha autorización","STRING",0,"X(08)",null,0,0,"FECHA AUTORIZACIÓN",false),
	FIELD26("OPV:287-301:","numeración inicial","STRING",0,"9(15)",null,0,0,"NUMERACIÓN INICIAL",false),
	FIELD27("OPV:302-316:","numeración final","STRING",0,"9(15)",null,0,0,"NUMERACIÓN FINAL",false),
	FIELD28("OPV:317-332:","precio máximo","STRING",0,"9(08)V9(8)",null,0,0,"PRECIO MÁXIMO",false),
	FIELD29("OPV:333-335:","divisa del precio","STRING",0,"X(03)",null,0,0,"DIVISA DEL PRECIO",false),
	FIELD30("OPV:336-1028:","filler","STRING",0,"X(693)",null,0,0,"FILLER",true),
	FIELD31(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD32(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD33(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD34(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD35(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD36(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD37(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeOPVField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
