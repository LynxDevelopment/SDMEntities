package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeTHRField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("THR:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("THR:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("THR:35-39:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD8("THR:40-47:","fecha efectiva","STRING",0,"X(08)",null,0,0,"FECHA EFECTIVA",false),
	FIELD9("THR:48-50:","c�digo hecho relevante","STRING",0,"X(03)",null,0,0,"C�DIGO HECHO RELEVANTE",false),
	FIELD10("THR:51-53:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD11("THR:54-65:","c�digo isin","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD12("THR:66-68:","n�mero de l�nea","STRING",0,"9(03)",null,0,0,"N�MERO DE L�NEA",false),
	FIELD13("THR:69-148:","texto","STRING",0,"X(80)",null,0,0,"TEXTO",false),
	FIELD14("THR:149-1028:","filler","STRING",0,"X(880)",null,0,0,"FILLER",true),
	FIELD15(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD16(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD17(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD18(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD19(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD20(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD21(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeTHRField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
