package com.lynxspa.sdm.dictionaries.formats.inversis.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeINVField implements CAMessageTypeFieldsDictAdapter{
/*
	FIELD1("INV:1744-1998:","información adicional 1","STRING",0,"X(255)",null,0,0,"Información Adicional 1",false),
	FIELD2("INV:1999-2253:","información adicional 2","STRING",0,"X(255)",null,0,0,"Información Adicional 2",false),
	FIELD3("INV:2254-4000:","filler","STRING",0,"X(1747)",null,0,0,"Filler",false),
	FIELD4("INV:ORDENDIA","Orden del dia","STRING",0,"X(3954)",null,0,0,"Orden del dia",false),
	FIELD5("INV:1-4:","empresa","STRING",0,"X(04)",null,0,0,"Empresa",false),
	FIELD6("INV:5-14:","institución","STRING",0,"X(10)",null,0,0,"Institución",false),
	FIELD7("INV:15-22:","fecha de trasmisión","STRING",0,"X(08)",null,0,0,"Fecha de trasmisión",false),
	FIELD8("INV:23-37:","tipo de fichero","STRING",0,"X(15)",null,0,0,"Tipo de fichero",false),
	FIELD9("INV:38-46:","referencia operación financiera","STRING",0,"9(9)",null,0,0,"Referencia Operación Financiera",false),
	FIELD10("INV:47-55:","código interno del valor origen","STRING",0,"9(9)",null,0,0,"Código interno del valor origen",false),
	FIELD11("INV:56-67:","código isin del valor origen","STRING",0,"X(12)",null,0,0,"Código ISIN del valor origen",false),
	FIELD12("INV:68-82:","código del valor origen en el mercado","STRING",0,"X(15)",null,0,0,"Código del valor origen en el Mercado",false),
	FIELD13("INV:83-92:","código de mercado por defecto","STRING",0,"X(10)",null,0,0,"Código de Mercado por defecto",false),
	FIELD14("INV:93-95:","código divisa de cotización del valor origen","STRING",0,"X(03)",null,0,0,"Código Divisa de Cotización del valor origen",false),
	FIELD15("INV:96-104:","código interno del valor destino","STRING",0,"9(9)",null,0,0,"Código interno del valor destino",false),
	FIELD16("INV:105-116:","código isin del valor destino","STRING",0,"X(12)",null,0,0,"Código ISIN del valor destino",false),
	FIELD17("INV:117-131:","código del valor destino en el mercado","STRING",0,"X(15)",null,0,0,"Código del valor destino en el Mercado",false),
	FIELD18("INV:132-141:","código de mercado por defecto","STRING",0,"X(10)",null,0,0,"Código de Mercado por defecto",false),
	FIELD19("INV:142-144:","código divisa de cotización del valor destino","STRING",0,"X(03)",null,0,0,"Código Divisa de Cotización del valor destino",false),
	FIELD20("INV:145-146:","tipo operación financiera","STRING",0,"X(02)",null,0,0,"Tipo Operación Financiera",false),
	FIELD21("INV:147-148:","subtipo operación financiera","STRING",0,"X(02)",null,0,0,"Subtipo Operación Financiera",false),
	FIELD22("INV:149-173:","filler","STRING",0,"X(25)",null,0,0,"FILLER",false),
	FIELD23("INV:174-429:","filler","STRING",0,"X(256)",null,0,0,"FILLER",false),
	FIELD24("INV:430-437:","fecha del anuncio por parte de la emisora","STRING",0,"X(08)",null,0,0,"Fecha del Anuncio por parte de la emisora",false),
	FIELD25("INV:438-439:","modo operación","STRING",0,"X(02)",null,0,0,"Modo Operación",false),
	FIELD26("INV:440-447:","fecha del anuncio de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha del anuncio de la Operación Financiera",false),
	FIELD27("INV:448-455:","fecha de ejecución de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha de Ejecución de la Operación Financiera",false),
	FIELD28("INV:456-463:","fecha inicio de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha Inicio de la Operación Financiera",false),
	FIELD29("INV:464-471:","fecha fin de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha Fin de la Operación Financiera",false),
	FIELD30("INV:472-479:","fecha limite respuesta","STRING",0,"X(08)",null,0,0,"Fecha limite respuesta",false),
	FIELD31("INV:480-487:","fecha de la posición con derecho a la operación financiera.","STRING",0,"X(08)",null,0,0,"Fecha de la posición con derecho a la operación financiera.",false),
	FIELD32("INV:488-490:","código de la divisa de los importes","STRING",0,"X(03)",null,0,0,"Código de la divisa de los importes",false),
	FIELD33("INV:491-512:","proporción títulos viejos","STRING",0,"9(22)V9(8)",null,0,0,"Proporción títulos viejos",false),
	FIELD34("INV:513-534:","proporción títulos nuevos","STRING",0,"9(22)V9(8)",null,0,0,"Proporción títulos nuevos",false),
	FIELD35("INV:535-555:","efectivo ó valor teórico","STRING",0,"9(21)V9(9)",null,0,0,"Efectivo ó valor teórico",false),
	FIELD36("INV:556-576:","importe para fracciones","STRING",0,"9(21)V9(9)",null,0,0,"Importe para fracciones",false),
	FIELD37("INV:577-597:","prima","STRING",0,"9(21)V9(9)",null,0,0,"Prima",false),
	FIELD38("INV:598-609:","tipo redondeo (exceso ó defecto)","STRING",0,"X(12)",null,0,0,"Tipo redondeo (exceso ó defecto)",false),
	FIELD39("INV:610-630:","importe bruto por título","STRING",0,"9(21)V9(9)",null,0,0,"Importe bruto por título",false),
	FIELD40("INV:631-638:","retención en origen","STRING",0,"9(8)V9(4)",null,0,0,"Retención en origen",false),
	FIELD41("INV:639-646:","retención en destino","STRING",0,"9(8)V9(4)",null,0,0,"Retención en destino",false),
	FIELD42("INV:647-667:","ajuste nominal ó bonificación","STRING",0,"9(21)V9(9)",null,0,0,"Ajuste nominal ó bonificación",false),
	FIELD43("INV:668-669:","tipo de junta","STRING",0,"X(02)",null,0,0,"Tipo de Junta",false),
	FIELD44("INV:670-691:","numero mínimo de títulos para asistencia","STRING",0,"9(22)V9(8)",null,0,0,"Numero mínimo de títulos para asistencia",false),
	FIELD45("INV:692-699:","fecha primera convocatoria","STRING",0,"X(08)",null,0,0,"Fecha primera convocatoria",false),
	FIELD46("INV:700-707:","fecha segunda convocatoria","STRING",0,"X(08)",null,0,0,"Fecha segunda convocatoria",false),
	FIELD47("INV:708-962:","lugar de celebración","STRING",0,"X(255)",null,0,0,"Lugar de celebración",false),
	FIELD48("INV:963-1012:","oferente","STRING",0,"X(50)",null,0,0,"Oferente",false),
	FIELD49("INV:1013-1062:","tipo de opa/tipo junta","STRING",0,"X(50)",null,0,0,"Tipo de OPA/Tipo Junta",false),
	FIELD50("INV:1063-1066:","hora primera convocatoria","STRING",0,"X(04)",null,0,0,"Hora Primera Convocatoria",false),
	FIELD51("INV:1067-1070:","hora segunda convocatoria","STRING",0,"X(04)",null,0,0,"Hora Segunda Convocatoria",false),
	FIELD52("INV:1071-1073:","código de instrucción por defecto","STRING",0,"9(3)",null,0,0,"Código de Instrucción Por Defecto",false),
	FIELD53("INV:1074-1075:","modo operación","STRING",0,"X(02)",null,0,0,"Modo Operación",false),
	FIELD54("INV:1076-1084:","referencia operación financiera relacionada","STRING",0,"9(9)",null,0,0,"Referencia Operación Financiera Relacionada",false),
	FIELD55("INV:1085-1093:","numero de decimales","STRING",0,"9(9)",null,0,0,"Numero de Decimales",false),
	FIELD56("INV:1094-1094:","tipo de proporcionalidad","STRING",0,"X(01)",null,0,0,"Tipo de Proporcionalidad",false),
	FIELD57("INV:1095-1101:","código de hecho","STRING",0,"X(07)",null,0,0,"Código de Hecho",false),
	FIELD58("INV:1102-1201:","descripción corta operación financiera","STRING",0,"X(100)",null,0,0,"Descripción corta operación financiera",false),
	FIELD59("INV:1202-1701:","descripción larga operación financiera","STRING",0,"X(500)",null,0,0,"Descripción larga operación financiera",false),
	FIELD60("INV:1702-1722:","precio reinversión","STRING",0,"9(21)V9(9)",null,0,0,"Precio Reinversión",false),
	FIELD61("INV:1723-1743:","precio de retención","STRING",0,"9(21)V9(9)",null,0,0,"Precio de Retención",false);
	*/
	
	FIELD1("INV:1-4:","Empresa:","STRING",0,"X(04)",null,0,0,"Empresa",false),
	FIELD2("INV:5-14:","Institución","STRING",0,"X(10)",null,0,0,"Institución",false),
	FIELD3("INV:15-22:","Fecha de trasmisión","STRING",0,"X(08)",null,0,0,"Fecha de trasmisión",false),
	FIELD4("INV:23-37:","Tipo de fichero","STRING",0,"X(15)",null,0,0,"Tipo de fichero",false),
	FIELD5("INV:38-46:","Referencia Operación Financiera","STRING",0,"X(09)",null,0,0,"Referencia Operación Financiera",false),
	FIELD6("INV:47-48:","Codigo de tipo de hecho","STRING",0,"X(02)",null,0,0,"Codigo de tipo de hecho",false),
	FIELD7("INV:49-98:","Tipo de hecho","STRING",0,"X(50)",null,0,0,"Tipo de hecho",false),
	FIELD8("INV:99-107:","Codigo interno del valor origen","STRING",0,"9(9)",null,0,0,"Codigo interno del valor origen",false),
	FIELD9("INV:108-119:","Código ISIN del valor origen","STRING",0,"X(12)",null,0,0,"Código ISIN del valor origen",false),
	FIELD10("INV:120-149:","Descripcion del valor origen","STRING",0,"X(30)",null,0,0,"Descripcion del valor origen",false),
	FIELD11("INV:150-159:","Código de Mercado por defecto","STRING",0,"X(10)",null,0,0,"Código de Mercado por defecto",false),
	FIELD12("INV:160-162:","Código Divisa de Cotización del valor origen","STRING",0,"X(03)",null,0,0,"Código Divisa de Cotización del valor origen",false),
	FIELD13("INV:163-172:","Tipo de producto valor origen","STRING",0,"X(10)",null,0,0,"Tipo de producto valor origen",false),
	FIELD14("INV:173-184:","Código ISIN del valor destino","STRING",0,"X(12)",null,0,0,"Código ISIN del valor destino",false),
	FIELD15("INV:185-193:","codigo interno del valor destino","STRING",0,"9(09)",null,0,0,"codigo interno del valor destino",false),
	FIELD16("INV:194-223:","Descripcion del valor destino","STRING",0,"X(30)",null,0,0,"Descripcion del valor destino",false),
	FIELD17("INV:224-233:","Código de Mercado por defecto","STRING",0,"X(10)",null,0,0,"Código de Mercado por defecto",false),
	FIELD18("INV:234-236:","Código Divisa de Cotización del valor destino","STRING",0,"X(03)",null,0,0,"Código Divisa de Cotización del valor destino",false),
	FIELD19("INV:237-246:","Tipo de prodcto valor destino","STRING",0,"X(10)",null,0,0,"Tipo de prodcto valor destino",false),
	FIELD20("INV:247-274:","Cuenta","STRING",0,"X(28)",null,0,0,"Cuenta",false),
	FIELD21("INV:275-302:","Cuenta Externa","STRING",0,"X(28)",null,0,0,"Cuenta Externa",false),
	FIELD22("INV:303-342:","Descripcion de la cuenta","STRING",0,"X(40)",null,0,0,"Descripcion de la cuenta",false),
	FIELD23("INV:343-364:","Numero de Titulos de la cuenta","STRING",0,"9(22)V9(08)",null,0,0,"Numero de Titulos de la cuenta",false),
	FIELD24("INV:365-382:","Nominal de la cuenta","STRING",0,"9(18)V9(02)",null,0,0,"Nominal de la cuenta",false),
	FIELD25("INV:383-390:","Fecha Posicion","STRING",0,"X(08)",null,0,0,"Fecha Posicion",false),
	FIELD26("INV:391-412:","numero de titulos nuevo valor","STRING",0,"9(22)V9(08)",null,0,0,"numero de titulos nuevo valor",false),
	FIELD27("INV:413-433:","Tipo de cambio","STRING",0,"9(21)V9(09)",null,0,0,"Tipo de cambio",false),
	FIELD28("INV:434-436:","Divisa","STRING",0,"X(03)",null,0,0,"Divisa",false),
	FIELD29("INV:437-454:","Precio por titulo","STRING",0,"9(18)V9(08)",null,0,0,"Precio por titulo",false),
	FIELD30("INV:455-472:","Importe bruto ","STRING",0,"9(18)V9(02)",null,0,0,"Importe bruto ",false),
	FIELD31("INV:473-480:","Retencion en origen","STRING",0,"9(8)V9(04)",null,0,0,"Retencion en origen",false),
	FIELD32("INV:481-498:","Retencion en origen en cliente","STRING",0,"9(18)V9(02)",null,0,0,"Retencion en origen en cliente",false),
	FIELD33("INV:499-516:","Importe neto en origen","STRING",0,"9(18)V9(02)",null,0,0,"Importe neto en origen",false),
	FIELD34("INV:517-524:","Retencion en destino","STRING",0,"9(8)V9(04)",null,0,0,"Retencion en destino",false),
	FIELD35("INV:525-542:","Retencion en destino en cliente","STRING",0,"9(18)V9(02)",null,0,0,"Retencion en destino en cliente",false),
	FIELD36("INV:543-560:","Importe neto en destino","STRING",0,"9(18)V9(02)",null,0,0,"Importe neto en destino",false),
	FIELD37("INV:561-568:","Fecha Liquidacion","STRING",0,"X(08)",null,0,0,"Fecha Liquidacion",false),
	FIELD38("INV:569-576:","Fecha Valor","STRING",0,"X(08)",null,0,0,"Fecha Valor",false),
	FIELD39("INV:577-584:","Fecha Fin Flujo","STRING",0,"X(08)",null,0,0,"Fecha Fin Flujo",false),
	FIELD40("INV:585-624:","Nombre del depositario","STRING",0,"X(40)",null,0,0,"Nombre del depositario",false),
	FIELD41("INV:625-634:","Codigo tipo amortizacion","STRING",0,"X(10)",null,0,0,"Codigo tipo amortizacion",false),
	FIELD42("INV:635-649:","Descripcion tipo de amortizacion","STRING",0,"X(15)",null,0,0,"Descripcion tipo de amortizacion",false),
	FIELD43("INV:650-658:","Referencia Operación Financiera Relacionada","STRING",0,"X(09)",null,0,0,"Referencia Operación Financiera Relacionada",false),
	FIELD44("INV:659-660:","Codigo de tipo de hecho relacionado","STRING",0,"X(02)",null,0,0,"Codigo de tipo de hecho relacionado",false),
	FIELD45("INV:661-710:","Descripcion tipo de hecho relacionado","STRING",0,"X(50)",null,0,0,"Descripcion tipo de hecho relacionado",false),
	FIELD46("INV:711-718:","Fecha de ejecucion de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha de ejecucion de la operación financiera",false),
	FIELD47("INV:719-726:","Fecha inicio de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha inicio de la operación financiera",false),
	FIELD48("INV:727-734:","Fecha fin de la operación financiera","STRING",0,"X(08)",null,0,0,"Fecha fin de la operación financiera",false),
	FIELD49("INV:735-742:","Fecha limite respuesta","STRING",0,"X(08)",null,0,0,"Fecha limite respuesta",false),
	FIELD50("INV:743-764:","Proporcion titulos viejos","STRING",0,"9(22)V9(8)",null,0,0,"Proporcion titulos viejos",false),
	FIELD51("INV:765-786:","Proporcion titulos nuevos","STRING",0,"9(22)V9(8)",null,0,0,"Proporcion titulos nuevos",false),
	FIELD52("INV:787-807:","Efectivo o valor teorico","STRING",0,"9(21)V9(9)",null,0,0,"Efectivo o valor teorico",false),
	FIELD53("INV:808-828:","Importe para fracciones","STRING",0,"9(21)V9(9)",null,0,0,"Importe para fracciones",false),
	FIELD54("INV:829-849:","Prima","STRING",0,"9(21)V9(9)",null,0,0,"Prima",false),
	FIELD55("INV:850-861:","Tipo rendodeo","STRING",0,"X(12)",null,0,0,"Tipo rendodeo",false),
	FIELD56("INV:862-863:","Tipo de Junta","STRING",0,"X(02)",null,0,0,"Tipo de Junta",false),
	FIELD57("INV:864-885:","Numero minimo de titulos por asistencia","STRING",0,"9(22)V9(08)",null,0,0,"Numero minimo de titulos por asistencia",false),
	FIELD58("INV:886-893:","Fecha Primera convocatoria","STRING",0,"X(08)",null,0,0,"Fecha Primera convocatoria",false),
	FIELD59("INV:894-901:","Fecha Segunda Convocatoria","STRING",0,"X(08)",null,0,0,"Fecha Segunda Convocatoria",false),
	FIELD60("INV:902-1156:","Lugar de Celebracion","STRING",0,"X(255)",null,0,0,"Lugar de Celebracion",false),
	FIELD61("INV:1157-1206:","Oferente","STRING",0,"X(50)",null,0,0,"Oferente",false),
	FIELD62("INV:1207-1256:","Tipo de OPA/Tipo Junta","STRING",0,"X(50)",null,0,0,"Tipo de OPA/Tipo Junta",false),
	FIELD63("INV:1257-1260:","Hora Primera Convocatoria","STRING",0,"X(04)",null,0,0,"Hora Primera Convocatoria",false),
	FIELD64("INV:1261-1264:","Hora Segunda Convocatoria","STRING",0,"X(04)",null,0,0,"Hora Segunda Convocatoria",false),
	FIELD65("INV:1265-1267:","Código de Instrucción Por Defecto","STRING",0,"9(3)",null,0,0,"Código de Instrucción Por Defecto",false),
	FIELD66("INV:1268-1269:","Modo Operación","STRING",0,"X(02)",null,0,0,"Modo Operación",false),
	FIELD67("INV:1270-1278:","Numero de Decimales","STRING",0,"9(9)",null,0,0,"Numero de Decimales",false),
	FIELD68("INV:1279-1279:","Tipo de Proporcionalidad","STRING",0,"X(01)",null,0,0,"Tipo de Proporcionalidad",false),
	FIELD69("INV:1280-4000:","Filler","STRING",0,"X(2721)",null,0,0,"Filler",false);

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

	
	CAMessageTypeINVField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
