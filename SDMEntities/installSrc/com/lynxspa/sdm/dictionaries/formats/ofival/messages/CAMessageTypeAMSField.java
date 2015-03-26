package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeAMSField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("AMS:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("AMS:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("AMS:35-46:","c�digo isin","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD8("AMS:47-58:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD9("AMS:59-60:","tipo activo","STRING",0,"X(02)",null,0,0,"TIPO ACTIVO",false),
	FIELD10("AMS:61-66:","c�digo emisi�n","STRING",0,"X(06)",null,0,0,"C�DIGO EMISI�N",false),
	FIELD11("AMS:67-69:","secuencia amortizaci�n","STRING",0,"9(03)",null,0,0,"SECUENCIA AMORTIZACI�N",false),
	FIELD12("AMS:70-77:","fecha amortizaci�n","STRING",0,"X(08)",null,0,0,"FECHA AMORTIZACI�N",false),
	FIELD13("AMS:78-80:","c�digo hecho relevante","STRING",0,"X(03)",null,0,0,"C�DIGO HECHO RELEVANTE",false),
	FIELD14("AMS:81-88:","fecha emisi�n","STRING",0,"X(08)",null,0,0,"FECHA EMISI�N",false),
	FIELD15("AMS:89-93:","c�digo emisora","STRING",0,"X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD16("AMS:94-108:","numeraci�n inicial","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL",false),
	FIELD17("AMS:109-123:","numeraci�n final","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL",false),
	FIELD18("AMS:124-140:","total t�tulos amortizados","STRING",0,"9(10)V9(07)",null,0,0,"TOTAL T�TULOS AMORTIZADOS",false),
	FIELD19("AMS:141-156:","importe amortizado","STRING",0,"9(08)V9(08)",null,0,0,"IMPORTE AMORTIZADO",false),
	FIELD20("AMS:157-165:","precio","STRING",0,"9(03)V9(06)",null,0,0,"PRECIO",false),
	FIELD21("AMS:166-181:","importe pendiente amortizar","STRING",0,"9(08)V9(08)",null,0,0,"IMPORTE PENDIENTE AMORTIZAR",false),
	FIELD22("AMS:182-182:","car�cter amortizaci�n","STRING",0,"X(01)",null,0,0,"CAR�CTER AMORTIZACI�N",false),
	FIELD23("AMS:183-183:","voluntariedad amortizaci�n","STRING",0,"X(01)",null,0,0,"VOLUNTARIEDAD AMORTIZACI�N",false),
	FIELD24("AMS:184-184:","clase amortizaci�n","STRING",0,"X(01)",null,0,0,"CLASE AMORTIZACI�N",false),
	FIELD25("AMS:185-200:","nominal anterior","STRING",0,"9(08)V9(08)",null,0,0,"NOMINAL ANTERIOR",false),
	FIELD26("AMS:201-216:","nominal nuevo","STRING",0,"9(08)V9(08)",null,0,0,"NOMINAL NUEVO",false),
	FIELD27("AMS:217-224:","fecha inicio","STRING",0,"X(08)",null,0,0,"FECHA INICIO",false),
	FIELD28("AMS:225-232:","fecha fin","STRING",0,"X(08)",null,0,0,"FECHA FIN",false),
	FIELD29("AMS:233-233:","valores","STRING",0,"X(01)",null,0,0,"VALORES",false),
	FIELD30("AMS:234-249:","precio","STRING",0,"9(08)V9(08)",null,0,0,"PRECIO",false),
	FIELD31("AMS:250-266:","total t�tulos","STRING",0,"9(10)V9(07)",null,0,0,"TOTAL T�TULOS",false),
	FIELD32("AMS:267-281:","numeraci�n inicial nuevos","STRING",0,"9(15)",null,0,0,"NUMERACI�N INICIAL NUEVOS",false),
	FIELD33("AMS:282-296:","numeraci�n final nuevos","STRING",0,"9(15)",null,0,0,"NUMERACI�N FINAL NUEVOS",false),
	FIELD34("AMS:297-304:","fecha beneficios","STRING",0,"X(08)",null,0,0,"FECHA BENEFICIOS",false),
	FIELD35("AMS:305-312:","fecha dividendos","STRING",0,"X(08)",null,0,0,"FECHA DIVIDENDOS",false),
	FIELD36("AMS:313-320:","fecha suscripci�n","STRING",0,"X(08)",null,0,0,"FECHA SUSCRIPCI�N",false),
	FIELD37("AMS:321-400:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD38("AMS:401-403:","divisa","STRING",0,"X(03)",null,0,0,"DIVISA",false),
	FIELD39("AMS:404-415:","c�digo isin amortizado","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN AMORTIZADO",false),
	FIELD40("AMS:416-423:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD41("AMS:424-427:","entidad agente","STRING",0,"X(04)",null,0,0,"ENTIDAD AGENTE",false),
	FIELD42("AMS:428-444:","ajuste","STRING",0,"9(10)V9(07)",null,0,0,"AJUSTE",false),
	FIELD43("AMS:445-452:","fecha sorteo","STRING",0,"X(08)",null,0,0,"FECHA SORTEO",false),
	FIELD44("AMS:453-468:","importe bruto prima amortizaci�n","STRING",0,"9(08)V9(08)",null,0,0,"IMPORTE BRUTO PRIMA AMORTIZACI�N",false),
	FIELD45("AMS:469-484:","importe neto prima amortizaci�n","STRING",0,"8(08)V9(08)",null,0,0,"IMPORTE NETO PRIMA AMORTIZACI�N",false),
	FIELD46("AMS:485-493:","retenci�n prima amortizaci�n","STRING",0,"9(03)V9(06)",null,0,0,"RETENCI�N PRIMA AMORTIZACI�N",false),
	FIELD47("AMS:494-502:","redondeo","STRING",0,"9(03)V9(06)",null,0,0,"REDONDEO",false),
	FIELD48("AMS:503-519:","proporci�n valor entregado","STRING",0,"9(10)V9(07)",null,0,0,"PROPORCI�N VALOR ENTREGADO",false),
	FIELD49("AMS:520-536:","proporci�n valor recibido","STRING",0,"9(10)V9(07)",null,0,0,"PROPORCI�N VALOR RECIBIDO",false),
	FIELD50("AMS:537-586:","criterio de valoraci�n 1","STRING",0,"X(50)",null,0,0,"CRITERIO DE VALORACI�N 1",false),
	FIELD51("AMS:587-636:","criterio de valoraci�n 2","STRING",0,"X(50)",null,0,0,"CRITERIO DE VALORACI�N 2",false),
	FIELD52("AMS:637-1028:","filler","STRING",0,"X(392)",null,0,0,"FILLER",true),
	FIELD53(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD54(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD55(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD56(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD57(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD58(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
	FIELD59(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeAMSField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
