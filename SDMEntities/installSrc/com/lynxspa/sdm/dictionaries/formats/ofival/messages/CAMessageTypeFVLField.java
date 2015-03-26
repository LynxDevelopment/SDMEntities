package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeFVLField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("FUS:FVL:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("FUS:FVL:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("FUS:FVL:35-39:","c�digo absorbente","STRING",0,"X(5)",null,0,0,"C�DIGO ABSORBENTE",false),
	FIELD8("FUS:FVL:40-51:","c�digo isin absorbente","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN ABSORBENTE",false),
	FIELD9("FUS:FVL:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("FUS:FVL:64-66:","c�digo hecho relevante","STRING",0,"X(3)",null,0,0,"C�DIGO HECHO RELEVANTE",false),
	FIELD11("FUS:FVL:67-74:","fecha fusi�n","STRING",0,"X(8)",null,0,0,"FECHA FUSI�N",false),
	FIELD12("FUS:FVL:75-77:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD13("FUS:FVL:78-82:","c�digo entidad absorbida","STRING",0,"X(05)",null,0,0,"C�DIGO ENTIDAD ABSORBIDA",false),
	FIELD14("FUS:FVL:83-94:","c�digo isin absorbida","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN ABSORBIDA",false),
	FIELD15("FUS:FVL:95-111:","proporci�n absorbente","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N ABSORBENTE",false),
	FIELD16("FUS:FVL:112-128:","proporci�n absorbida","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N ABSORBIDA",false),
	FIELD17("FUS:FVL:129-144:","importe cobrado","STRING",0,"9(08)V9(8)",null,0,0,"IMPORTE COBRADO",false),
	FIELD18("FUS:FVL:145-160:","importe pagado","STRING",0,"9(08)V9(8)",null,0,0,"IMPORTE PAGADO",false),
	FIELD19("FUS:FVL:161-163:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD20("FUS:FVL:164-483:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD21("FUS:FVL:484-484:","picos","STRING",0,"X(01)",null,0,0,"PICOS",false),
	FIELD22("FUS:FVL:485-500:","valoraci�n picos","STRING",0,"9(08)V9(8)",null,0,0,"VALORACI�N PICOS",false),
	FIELD23("FUS:FVL:501-508:","fecha emisi�n","STRING",0,"X(08)",null,0,0,"FECHA EMISI�N",false),
	FIELD24("FUS:FVL:509-516:","fecha abono picos","STRING",0,"X(08)",null,0,0,"FECHA ABONO PICOS",false),
	FIELD25("FUS:FVL:517-524:","fecha abono complemento","STRING",0,"X(08)",null,0,0,"FECHA ABONO COMPLEMENTO",false),
	FIELD26("FUS:FVL:525-525:","indicador tratamiento","STRING",0,"X(01)",null,0,0,"INDICADOR TRATAMIENTO",false),
	FIELD27("FUS:FVL:526-540:","numeraci�n inicial","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL",false),
	FIELD28("FUS:FVL:541-555:","numeraci�n final","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL",false),
	FIELD29("FUS:FVL:556-563:","fecha admisi�n negociaci�n","STRING",0,"X(08)",null,0,0,"FECHA ADMISI�N NEGOCIACI�N",false),
	FIELD30("FUS:FVL:564-1028:","filler","STRING",0,"X(465)",null,0,0,"FILLER",true),
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

	
	CAMessageTypeFVLField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
