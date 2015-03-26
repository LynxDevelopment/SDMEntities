package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeOPAField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("OPA:29-33:","versión","STRING",0,"X(05)",null,0,0,"VERSIÓN",true),
	FIELD6("OPA:34-34:","actuación","STRING",0,"X(01)",null,0,0,"ACTUACIÓN",true),
	FIELD7("OPA:35-39:","código emisora","STRING",0," X(05)",null,0,0,"CÓDIGO EMISORA",false),
	FIELD8("OPA:40-51:","código isin","STRING",0," X(12)",null,0,0,"CÓDIGO ISIN",false),
	FIELD9("OPA:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("OPA:64-66:","secuencia","STRING",0," 9(03)",null,0,0,"SECUENCIA",false),
	FIELD11("OPA:67-69:","hecho relevante","STRING",0," X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD12("OPA:70-77:","fecha inicio","STRING",0,"X(08)",null,0,0,"FECHA INICIO",false),
	FIELD13("OPA:78-85:","fecha fin","STRING",0," X(08)",null,0,0,"FECHA FIN",false),
	FIELD14("OPA:86-165:","texto plazo 1","STRING",0,"X(80)",null,0,0,"TEXTO PLAZO 1",false),
	FIELD15("OPA:166-170:","código oferente","STRING",0," X(05)",null,0,0,"CÓDIGO OFERENTE",false),
	FIELD16("OPA:171-210:","nombre oferente","STRING",0,"X(40)",null,0,0,"NOMBRE OFERENTE",false),
	FIELD17("OPA:211-227:","total valores (máximo)","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES (MÁXIMO)",false),
	FIELD18("OPA:228-244:","valores mínimos","STRING",0,"9(10)V9(7)",null,0,0,"VALORES MÍNIMOS",false),
	FIELD19("OPA:245-260:","cambio/contraprestación","STRING",0,"9(8)V9(8)",null,0,0,"CAMBIO/CONTRAPRESTACIÓN",false),
	FIELD20("OPA:261-261:","resultado","STRING",0," X(01)",null,0,0,"RESULTADO",false),
	FIELD21("OPA:262-278:","valores aceptados","STRING",0,"9(10)V9(7)",null,0,0,"VALORES ACEPTADOS",false),
	FIELD22("OPA:279-286:","fecha verificación","STRING",0,"X(08)",null,0,0,"FECHA VERIFICACIÓN",false),
	FIELD23("OPA:287-294:","fecha cancelación","STRING",0," X(08)",null,0,0,"FECHA CANCELACIÓN",false),
	FIELD24("OPA:295-454:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD25("OPA:455-462:","fecha adjudicación","STRING",0,"X(08)",null,0,0,"FECHA ADJUDICACIÓN",false),
	FIELD26("OPA:463-470:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD27("OPA:471-471:","indicador tipo opa","STRING",0,"X(01)",null,0,0,"INDICADOR TIPO OPA",false),
	FIELD28("OPA:472-475:","entidad designada agente","STRING",0,"X(04)",null,0,0,"ENTIDAD DESIGNADA AGENTE",false),
	FIELD29("OPA:476-476:","prorrateo","STRING",0,"X(01)",null,0,0,"PRORRATEO",false),
	FIELD30("OPA:477-477:","tipo contraprestación","STRING",0,"X(01)",null,0,0,"TIPO CONTRAPRESTACIÓN",false),
	FIELD31("OPA:478-480:","divisa contraprestación","STRING",0,"X(03)",null,0,0,"DIVISA CONTRAPRESTACIÓN",false),
	FIELD32("OPA:481-492:","código isin contraprestación","STRING",0,"X(12)",null,0,0,"CÓDIGO ISIN CONTRAPRESTACIÓN",false),
	FIELD33("OPA:493-509:","proporción valor opado","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCIÓN VALOR OPADO",false),
	FIELD34("OPA:510-526:","proporción valor contraprestación","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCIÓN VALOR CONTRAPRESTACIÓN",false),
	FIELD35("OPA:527-527:","picos","STRING",0,"X(01)",null,0,0,"PICOS",false),
	FIELD36("OPA:528-543:","compensación picos","STRING",0,"9(08)V9(8)",null,0,0,"COMPENSACIÓN PICOS",false),
	FIELD37("OPA:544-560:","prorrateo lineal","STRING",0,"9(10)V9(7)",null,0,0,"PRORRATEO LINEAL",false),
	FIELD38("OPA:561-569:","prorrateo coeficiente","STRING",0,"9(03)V9(6)",null,0,0,"PRORRATEO COEFICIENTE",false),
	FIELD39("OPA:570-570:","prorrateo redondeo","STRING",0,"X(01)",null,0,0,"PRORRATEO REDONDEO",false),
	FIELD40("OPA:571-1028:","filler","STRING",0,"X(458)",null,0,0,"FILLER",true),
	FIELD41(":1029-1036:","fecha-grabación","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN",true),
	FIELD42(":1037-1046:","hora-grabación","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN",true),
	FIELD43(":1047-1054:","usuario-grabación","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN",true),
	FIELD44(":1055-1062:","fecha-grabación-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACIÓN-ORIGEN",true),
	FIELD45(":1063-1072:","hora-grabación-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACIÓN-ORIGEN",true),
	FIELD46(":1073-1080:","usuario-grabación-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACIÓN-ORIGEN",true),
	FIELD47(":1081-1100:","filler","STRING",0,"X(19)","footer info",0,0,"FILLER",true);	


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

	
	CAMessageTypeOPAField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
