package com.lynxspa.sdm.dictionaries.formats.ofival.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeOPAField implements CAMessageTypeFieldsDictAdapter{

	FIELD1(":1-8:","secuencia general","STRING",0,"9(08)","header info",0,0,"SECUENCIA GENERAL",true),
	FIELD2(":9-16:","servicio","STRING",0,"X(08)","header info",0,0,"SERVICIO",true),
	FIELD3(":17-24:","secuencia particular","STRING",0,"X(08)","header info",0,0,"SECUENCIA PARTICULAR",true),
	FIELD4(":25-28:","longitud datos registro","STRING",0,"9(04)","header info",0,0,"LONGITUD DATOS REGISTRO",true),
	FIELD5("OPA:29-33:","versi�n","STRING",0,"X(05)",null,0,0,"VERSI�N",true),
	FIELD6("OPA:34-34:","actuaci�n","STRING",0,"X(01)",null,0,0,"ACTUACI�N",true),
	FIELD7("OPA:35-39:","c�digo emisora","STRING",0," X(05)",null,0,0,"C�DIGO EMISORA",false),
	FIELD8("OPA:40-51:","c�digo isin","STRING",0," X(12)",null,0,0,"C�DIGO ISIN",false),
	FIELD9("OPA:52-63:","nombre valor","STRING",0,"X(12)",null,0,0,"NOMBRE VALOR",false),
	FIELD10("OPA:64-66:","secuencia","STRING",0," 9(03)",null,0,0,"SECUENCIA",false),
	FIELD11("OPA:67-69:","hecho relevante","STRING",0," X(03)",null,0,0,"HECHO RELEVANTE",false),
	FIELD12("OPA:70-77:","fecha inicio","STRING",0,"X(08)",null,0,0,"FECHA INICIO",false),
	FIELD13("OPA:78-85:","fecha fin","STRING",0," X(08)",null,0,0,"FECHA FIN",false),
	FIELD14("OPA:86-165:","texto plazo 1","STRING",0,"X(80)",null,0,0,"TEXTO PLAZO 1",false),
	FIELD15("OPA:166-170:","c�digo oferente","STRING",0," X(05)",null,0,0,"C�DIGO OFERENTE",false),
	FIELD16("OPA:171-210:","nombre oferente","STRING",0,"X(40)",null,0,0,"NOMBRE OFERENTE",false),
	FIELD17("OPA:211-227:","total valores (m�ximo)","STRING",0,"9(10)V9(7)",null,0,0,"TOTAL VALORES (M�XIMO)",false),
	FIELD18("OPA:228-244:","valores m�nimos","STRING",0,"9(10)V9(7)",null,0,0,"VALORES M�NIMOS",false),
	FIELD19("OPA:245-260:","cambio/contraprestaci�n","STRING",0,"9(8)V9(8)",null,0,0,"CAMBIO/CONTRAPRESTACI�N",false),
	FIELD20("OPA:261-261:","resultado","STRING",0," X(01)",null,0,0,"RESULTADO",false),
	FIELD21("OPA:262-278:","valores aceptados","STRING",0,"9(10)V9(7)",null,0,0,"VALORES ACEPTADOS",false),
	FIELD22("OPA:279-286:","fecha verificaci�n","STRING",0,"X(08)",null,0,0,"FECHA VERIFICACI�N",false),
	FIELD23("OPA:287-294:","fecha cancelaci�n","STRING",0," X(08)",null,0,0,"FECHA CANCELACI�N",false),
	FIELD24("OPA:295-454:","observaciones","STRING",0,"X(80)",null,0,0,"OBSERVACIONES",false),
	FIELD25("OPA:455-462:","fecha adjudicaci�n","STRING",0,"X(08)",null,0,0,"FECHA ADJUDICACI�N",false),
	FIELD26("OPA:463-470:","fecha exdate","STRING",0,"X(08)",null,0,0,"FECHA EXDATE",false),
	FIELD27("OPA:471-471:","indicador tipo opa","STRING",0,"X(01)",null,0,0,"INDICADOR TIPO OPA",false),
	FIELD28("OPA:472-475:","entidad designada agente","STRING",0,"X(04)",null,0,0,"ENTIDAD DESIGNADA AGENTE",false),
	FIELD29("OPA:476-476:","prorrateo","STRING",0,"X(01)",null,0,0,"PRORRATEO",false),
	FIELD30("OPA:477-477:","tipo contraprestaci�n","STRING",0,"X(01)",null,0,0,"TIPO CONTRAPRESTACI�N",false),
	FIELD31("OPA:478-480:","divisa contraprestaci�n","STRING",0,"X(03)",null,0,0,"DIVISA CONTRAPRESTACI�N",false),
	FIELD32("OPA:481-492:","c�digo isin contraprestaci�n","STRING",0,"X(12)",null,0,0,"C�DIGO ISIN CONTRAPRESTACI�N",false),
	FIELD33("OPA:493-509:","proporci�n valor opado","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N VALOR OPADO",false),
	FIELD34("OPA:510-526:","proporci�n valor contraprestaci�n","STRING",0,"9(10)V9(7)",null,0,0,"PROPORCI�N VALOR CONTRAPRESTACI�N",false),
	FIELD35("OPA:527-527:","picos","STRING",0,"X(01)",null,0,0,"PICOS",false),
	FIELD36("OPA:528-543:","compensaci�n picos","STRING",0,"9(08)V9(8)",null,0,0,"COMPENSACI�N PICOS",false),
	FIELD37("OPA:544-560:","prorrateo lineal","STRING",0,"9(10)V9(7)",null,0,0,"PRORRATEO LINEAL",false),
	FIELD38("OPA:561-569:","prorrateo coeficiente","STRING",0,"9(03)V9(6)",null,0,0,"PRORRATEO COEFICIENTE",false),
	FIELD39("OPA:570-570:","prorrateo redondeo","STRING",0,"X(01)",null,0,0,"PRORRATEO REDONDEO",false),
	FIELD40("OPA:571-1028:","filler","STRING",0,"X(458)",null,0,0,"FILLER",true),
	FIELD41(":1029-1036:","fecha-grabaci�n","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N",true),
	FIELD42(":1037-1046:","hora-grabaci�n","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N",true),
	FIELD43(":1047-1054:","usuario-grabaci�n","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N",true),
	FIELD44(":1055-1062:","fecha-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"FECHA-GRABACI�N-ORIGEN",true),
	FIELD45(":1063-1072:","hora-grabaci�n-origen","STRING",0,"X(10)","footer info",0,0,"HORA-GRABACI�N-ORIGEN",true),
	FIELD46(":1073-1080:","usuario-grabaci�n-origen","STRING",0,"X(08)","footer info",0,0,"USUARIO-GRABACI�N-ORIGEN",true),
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
