package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeSPLField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("SPL:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("SPL:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("SPL:35-39:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD8("SPL:40-51:","c�digo isin","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD9("SPL:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("SPL:64-66:","hecho relevante","STRING",0,"X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD11("SPL:67-74:","fecha split","STRING",0,"X(08)",null,0,0,"FECHA SPLIT",false),
	FIELD12("SPL:75-77:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD13("SPL:78-94:","factor multiplicaci�n","STRING",0,"9(10)V9(7)",null,0,0,"FACTOR MULTIPLICACI�N",false),
	FIELD14("SPL:95-111:","factor divisi�n","STRING",0,"9(10)V9(7)",null,0,0,"FACTOR DIVISI�N",false),
	FIELD15("SPL:112-127:","nominal anterior","STRING",0,"9(8)V9(8)",null,0,0,"NOMINAL ANTERIOR",false),
	FIELD16("SPL:128-143:","nominal posterior","STRING",0,"9(8)V9(8)",null,0,0,"NOMINAL POSTERIOR",false),
	FIELD17("SPL:144-155:","c�digo isin nuevo","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN NUEVO",false),
	FIELD18("SPL:156-160:","c�digo bolsa anterior","STRING",0,"X(05)",null,0,0,"C�DIGO BOLSA ANTERIOR",false),
	FIELD19("SPL:161-165:","c�digo bolsa posterior","STRING",0,"X(05)",null,0,0,"C�DIGO BOLSA POSTERIOR",false),
	FIELD20("SPL:166-173:","fecha inicio reconstrucci�n","STRING",0,"X(08)",null,0,0,"FECHA INICIO RECONSTRUCCI�N",false),
	FIELD21("SPL:174-181:","fecha fin reconstrucci�n","STRING",0,"X(08)",null,0,0,"FECHA FIN RECONSTRUCCI�N",false),
	FIELD22("SPL:182-261:","observaciones 1","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 1",false),
	FIELD23("SPL:262-341:","observaciones 2","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 2",false),
	FIELD24("SPL:342-421:","observaciones 3","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 3",false),
	FIELD25("SPL:422-429:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD26("SPL:430-446:","total valores anterior","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES ANTERIOR",false),
	FIELD27("SPL:447-463:","total valores posterior","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES POSTERIOR",false),
	FIELD28("SPL:464-478:","numeraci�n inicial","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL",false),
	FIELD29("SPL:479-493:","numeraci�n final","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL",false),
	FIELD30("SPL:494-1028:","filler","STRING",0,"X(535)",null,0,0,"FILLER",true),
	FIELD31(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD32(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD33(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD34(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD35(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD36(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
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

	
	CAMessageTypeSPLField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
