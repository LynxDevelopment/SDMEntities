package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeFVLField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("FUS:FVL:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("FUS:FVL:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("FUS:FVL:35-39:","código absorbente","STRING",0,"X(5)",null,0,0,"CÓDIGO ABSORBENTE",false),
	FIELD8("FUS:FVL:40-51:","código isin absorbente","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN ABSORBENTE",false),
	FIELD9("FUS:FVL:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("FUS:FVL:64-66:","código hecho relevante","STRING",0,"X(3)",null,0,0,"CÓDIGO HECHO RELEVANTE",false),
	FIELD11("FUS:FVL:67-74:","fecha fusión","STRING",0,"X(8)",null,0,0,"FECHA FUSIÓN",false),
	FIELD12("FUS:FVL:75-77:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD13("FUS:FVL:78-82:","código entidad absorbida","STRING",0,"X(05)",null,0,0,"CÓDIGO ENTIDAD ABSORBIDA",false),
	FIELD14("FUS:FVL:83-94:","código isin absorbida","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN ABSORBIDA",false),
	FIELD15("FUS:FVL:95-111:","proporción absorbente","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCIÓN ABSORBENTE",false),
	FIELD16("FUS:FVL:112-128:","proporción absorbida","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCIÓN ABSORBIDA",false),
	FIELD17("FUS:FVL:129-144:","importe cobrado","STRING",0,"9(08)V9(8)",null,0,0,"IMPORTE COBRADO",false),
	FIELD18("FUS:FVL:145-160:","importe pagado","STRING",0,"9(08)V9(8)",null,0,0,"IMPORTE PAGADO",false),
	FIELD19("FUS:FVL:161-163:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD20("FUS:FVL:164-483:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD21("FUS:FVL:484-484:","picos","STRING",0,"X(01)",null,0,0,"PICOS",false),
	FIELD22("FUS:FVL:485-500:","valoración picos","STRING",0,"9(08)V9(8)",null,0,0,"VALORACIÓN PICOS",false),
	FIELD23("FUS:FVL:501-508:","fecha emisión","STRING",0,"X(08)",null,0,0,"FECHA EMISIÓN",false),
	FIELD24("FUS:FVL:509-516:","fecha abono picos","STRING",0,"X(08)",null,0,0,"FECHA ABONO PICOS",false),
	FIELD25("FUS:FVL:517-524:","fecha abono complemento","STRING",0,"X(08)",null,0,0,"FECHA ABONO COMPLEMENTO",false),
	FIELD26("FUS:FVL:525-525:","indicador tratamiento","STRING",0,"X(01)",null,0,0,"INDICADOR TRATAMIENTO",false),
	FIELD27("FUS:FVL:526-540:","numeración inicial","STRING",0,"9(15)",null,0,0,"NUMERACIÓN INICIAL",false),
	FIELD28("FUS:FVL:541-555:","numeración final","STRING",0,"9(15)",null,0,0,"NUMERACIÓN FINAL",false),
	FIELD29("FUS:FVL:556-563:","fecha admisión negociación","STRING",0,"X(08)",null,0,0,"FECHA ADMISIÓN NEGOCIACIÓN",false),
	FIELD30("FUS:FVL:564-1028:","filler","STRING",0,"X(465)",null,0,0,"FILLER",true),
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
