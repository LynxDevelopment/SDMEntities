package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeFUSField implements CAMessageTypeFieldsDictAdapter{

	FIELD1("FUS:67-74:","fecha fusi�n","STRING",0,"X(08)",null,0,0,"FECHA FUSI�N",false),
	FIELD2("FUS:75-77:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD3("FUS:78-78:","tipo de fusi�n","STRING",0,"X(01)",null,0,0,"TIPO DE FUSI�N",false),
	FIELD4("FUS:79-81:","valores implicados","STRING",0,"9(03)",null,0,0,"VALORES IMPLICADOS",false),
	FIELD5("FUS:82-89:","fecha inicio fusi�n","STRING",0,"X(08)",null,0,0,"FECHA INICIO FUSI�N",false),
	FIELD6("FUS:90-97:","fecha fin fusi�n","STRING",0,"X(08)",null,0,0,"FECHA FIN FUSI�N",false),
	FIELD7("FUS:98-497:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD8("FUS:498-505:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD9("FUS:506-509:","entidad agente","STRING",0,"X(04)",null,0,0,"ENTIDAD AGENTE",false),
	FIELD10("FUS:510-517:","fecha emisi�n","STRING",0,"X(08)",null,0,0,"FECHA EMISI�N",false),
	FIELD11("FUS:518-525:","fecha admisi�n a negociaci�n","STRING",0,"X(08)",null,0,0,"FECHA ADMISI�N A NEGOCIACI�N",false),
	FIELD12("FUS:526-526:","clase hecho relevante","STRING",0,"X(01)",null,0,0,"CLASE HECHO RELEVANTE",false),
	FIELD13("FUS:527-541:","numeraci�n inicial","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL",false),
	FIELD14("FUS:542-556:","numeraci�n final","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL",false),
	FIELD15("FUS:557-1028:","filler","STRING",0,"X(472)",null,0,0,"FILLER",true),
	FIELD16(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD17(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD18(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD19(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD20(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD21(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD22(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true),
	FIELD23(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD24(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD25(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD26(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD27("FUS:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD28("FUS:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD29("FUS:35-39:","c�digo entidad absorbente","STRING",0,"X(05)",null,0,0,"C�DIGO ENTIDAD ABSORBENTE",false),
	FIELD30("FUS:40-51:","c�digo isin absorbente","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN ABSORBENTE",false),
	FIELD31("FUS:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD32("FUS:64-66:","c�digo hecho relevante","STRING",0,"X(03)",null,0,0,"C�DIGO HECHO RELEVANTE",false);	


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

	
	CAMessageTypeFUSField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
