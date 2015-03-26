package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeDACField implements CAMessageTypeFieldsDictAdapter{

	FIELD1("DAC:213-292:","observaciones 2","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 2",false),
	FIELD2("DAC:293-372:","observaciones 3","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 3",false),
	FIELD3("DAC:373-381:","retención","STRING",0,"9(03)V9(6)",null,0,0,"RETENCIÓN",false),
	FIELD4("DAC:382-383:","serie","STRING",0,"X(02)",null,0,0,"SERIE",false),
	FIELD5("DAC:384-387:","entidad pagadora 1","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 1",false),
	FIELD6("DAC:388-391:","entidad pagadora 2","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 2",false),
	FIELD7("DAC:392-395:","entidad pagadora 3","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 3",false),
	FIELD8("DAC:396-399:","entidad pagadora 4","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 4",false),
	FIELD9("DAC:400-403:","entidad pagadora 5","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 5",false),
	FIELD10("DAC:404-407:","entidad pagadora 6","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 6",false),
	FIELD11("DAC:408-411:","entidad pagadora 7","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 7",false),
	FIELD12("DAC:412-415:","entidad pagadora 8","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 8",false),
	FIELD13("DAC:416-419:","entidad pagadora 9","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 9",false),
	FIELD14("DAC:420-423:","entidad pagadora 10","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA 10",false),
	FIELD15("DAC:424-425:","acuerdo","STRING",0,"X(02)",null,0,0,"ACUERDO",false),
	FIELD16("DAC:426-428:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD17("DAC:429-444:","bruto €","STRING",0,"9(08)V9(8)",null,0,0,"BRUTO €",false),
	FIELD18("DAC:445-460:","neto €","STRING",0,"9(08)V9(8)",null,0,0,"NETO €",false),
	FIELD19("DAC:461-468:","fecha abono","STRING",0,"X(08)",null,0,0,"FECHA ABONO",false),
	FIELD20("DAC:469-485:","total valores","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES",false),
	FIELD21("DAC:486-501:","total efectivo","STRING",0,"9(14)V9(2)",null,0,0,"TOTAL EFECTIVO",false),
	FIELD22("DAC:502-508:","unidad de contratación","STRING",0,"9(07)",null,0,0,"UNIDAD DE CONTRATACIÓN",false),
	FIELD23("DAC:509-516:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD24("DAC:517-1028:","filler","STRING",0,"X(512)",null,0,0,"FILLER",true),
	FIELD25(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD26(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD27(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD28(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD29(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD30(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD31(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true),
	FIELD32(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD33(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD34(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD35(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD36("DAC:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD37("DAC:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD38("DAC:35-39:","código emisora","STRING",0,"X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD39("DAC:40-51:","código isin","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD40("DAC:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD41("DAC:64-75:","nombre emisora","STRING",0,"X(12)",null,0,0,"NOMBRE EMISORA",false),
	FIELD42("DAC:76-83:","fecha de pago","STRING",0,"X(08)",null,0,0,"FECHA DE PAGO",false),
	FIELD43("DAC:84-86:","secuencia","STRING",0,"9(03)",null,0,0,"SECUENCIA",false),
	FIELD44("DAC:87-91:","cupón","STRING",0,"9(05)",null,0,0,"CUPÓN",false),
	FIELD45("DAC:92-92:","clase/tipo","STRING",0,"X(01)",null,0,0,"CLASE/TIPO",false),
	FIELD46("DAC:93-93:","concepto","STRING",0,"X(01)",null,0,0,"CONCEPTO",false),
	FIELD47("DAC:94-96:","número dividendo","STRING",0,"9(03)",null,0,0,"NÚMERO DIVIDENDO",false),
	FIELD48("DAC:97-100:","ejercicio","STRING",0,"X(04)",null,0,0,"EJERCICIO",false),
	FIELD49("DAC:101-116:","bruto","STRING",0,"9(08)V9(8)",null,0,0,"BRUTO",false),
	FIELD50("DAC:117-132:","neto","STRING",0,"9(08)V9(8)",null,0,0,"NETO",false),
	FIELD51("DAC:133-212:","observaciones 1","STRING",0,"X(80)",null,0,0,"OBSERVACIONES 1",false);	


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

	
	CAMessageTypeDACField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
