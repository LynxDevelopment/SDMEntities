package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeCUPField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("CUP:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("CUP:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("CUP:35-46:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD8("CUP:47-58:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD9("CUP:59-60:","tipo activo","STRING",0,"X(02)",null,0,0,"TIPO ACTIVO",false),
	FIELD10("CUP:61-66:","código emisión","STRING",0,"X(06)",null,0,0,"CÓDIGO EMISIÓN",false),
	FIELD11("CUP:67-69:","secuencia cupón","STRING",0,"9(03)",null,0,0,"SECUENCIA CUPÓN",false),
	FIELD12("CUP:70-77:","fecha pago","STRING",0,"X(08)",null,0,0,"FECHA PAGO",false),
	FIELD13("CUP:78-85:","fecha emisión","STRING",0,"X(08)",null,0,0,"FECHA EMISIÓN",false),
	FIELD14("CUP:86-88:","código hecho relevante","STRING",0,"X(03)",null,0,0,"CÓDIGO HECHO RELEVANTE",false),
	FIELD15("CUP:89-96:","fecha fin pago","STRING",0,"X(08)",null,0,0,"FECHA FIN PAGO",false),
	FIELD16("CUP:97-101:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD17("CUP:102-117:","importe bruto","STRING",0,"9(08)V9(08)",null,0,0,"IMPORTE BRUTO",false),
	FIELD18("CUP:118-133:","importe neto","STRING",0,"9(08)V9(08)",null,0,0,"IMPORTE NETO",false),
	FIELD19("CUP:134-142:","tipo interés bruto","STRING",0,"9(03)V9(06)",null,0,0,"TIPO INTERÉS BRUTO",false),
	FIELD20("CUP:143-151:","tipo interés neto","STRING",0,"9(03)V9(06)",null,0,0,"TIPO INTERÉS NETO",false),
	FIELD21("CUP:152-160:","porcentaje prima","STRING",0,"9(03)V9(06)",null,0,0,"PORCENTAJE PRIMA",false),
	FIELD22("CUP:161-161:","tipo cupón","STRING",0,"X(01)",null,0,0,"TIPO CUPÓN",false),
	FIELD23("CUP:162-191:","observaciones","STRING",0,"X(30)",null,0,0,"OBSERVACIONES",false),
	FIELD24("CUP:192-200:","retención","STRING",0,"9(03)V9(06)",null,0,0,"RETENCIÓN",false),
	FIELD25("CUP:201-209:","bonificación","STRING",0,"9(03)V9(06)",null,0,0,"BONIFICACIÓN",false),
	FIELD26("CUP:210-212:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD27("CUP:213-220:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD28("CUP:221-224:","entidad pagadora","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA",false),
	FIELD29("CUP:225-1028:","filler","STRING",0,"X(804)",null,0,0,"FILLER",true),
	FIELD30(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD31(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD32(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD33(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD34(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD35(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD36(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeCUPField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
