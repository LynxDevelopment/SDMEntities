package com.lynxspa.sdm.dictionaries.formats.iberclear.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeX02Field implements CAMessageTypeFieldsDictAdapter{

	FIELD1("IBC:1-3:","opcforma","STRING",0,"X(03)",null,0,0,"IDENTIFICATIVO DE FORMATO",false),
	FIELD2("IBC:4-7:","opcentad","STRING",0,"X(04)",null,0,0,"ENTIDAD PARTICIPANTE",false),
	FIELD3("IBC:8-19:","opcvalor","STRING",0,"X(12)",null,0,0,"CLASE DE VALOR",false),
	FIELD4("IBC:20-21:","opctipop","STRING",0,"X(02)",null,0,0,"TIPO DE OPERACIÓN",false),
	FIELD5("IBC:22-25:","opnopfin","STRING",0,"X(04)",null,0,0,"NÚMERO DE OPERACIÓN",false),
	FIELD6("IBC:26-40:","opdopfin","STRING",0,"X(15)",null,0,0,"DESCRIPCIÓN DE LA OPERAC. FINANCIERA",false),
	FIELD7("IBC:41-52:","opcvasec","STRING",0,"X(12)",null,0,0,"CLASE DE VALOR SECUNDARIO",false),
	FIELD8("IBC:53-65:","opinomnu","STRING",0,"9(11)V9(2)",null,0,0,"VALOR NOMINAL",false),
	FIELD9("IBC:66-73:","opfanota","STRING",0,"X(08)",null,0,0,"FECHA ANOTACIÓN",false),
	FIELD10("IBC:74-81:","opfinico","STRING",0,"X(08)",null,0,0,"FECHA INICIO COMUNICACIÓN",false),
	FIELD11("IBC:82-89:","opffinco","STRING",0,"X(08)",null,0,0,"FECHA FINALIZACIÓN COMUNICACIÓN",false),
	FIELD12("IBC:90-97:","opfecier","STRING",0,"X(08)",null,0,0,"FECHA CIERRE",false),
	FIELD13("IBC:98-115:","opiimpun","STRING",0,"9(10)V9(8)",null,0,0,"IMPORTE UNITARIO",false),
	FIELD14("IBC:116-122:","opqvalen","STRING",0,"9(07)",null,0,0,"PROPORCIÓN VALORES ENTREGADOS",false),
	FIELD15("IBC:123-129:","opqvalre","STRING",0,"9(07)",null,0,0,"PROPORCIÓN VALORES RECIBIDOS",false),
	FIELD16("IBC:130-135:","opcenti1","STRING",0,"X(06)",null,0,0,"ENTIDAD AGENTE 1",false),
	FIELD17("IBC:136-141:","opcenti2","STRING",0,"X(06)",null,0,0,"ENTIDAD AGENTE 2",false),
	FIELD18("IBC:142-147:","opcenti3","STRING",0,"X(06)",null,0,0,"ENTIDAD AGENTE 3",false),
	FIELD19("IBC:148-153:","opcenti4","STRING",0,"X(06)",null,0,0,"ENTIDAD AGENTE 4",false),
	FIELD20("IBC:154-161:","opfealta","STRING",0,"X(08)",null,0,0,"FECHA ALTA",false),
	FIELD21("IBC:162-169:","opfemodi","STRING",0,"X(08)",null,0,0,"FECHA MODIFICACIÓN",false),
	FIELD22("IBC:170-170:","opuactua","STRING",0,"X(01)",null,0,0,"INDICADOR DE ACTUACIÓN",false),
	FIELD23("IBC:171-171:","opucuent","STRING",0,"X(01)",null,0,0,"INDICADOR DE CUENTA",false),
	FIELD24("IBC:172-179:","opfliqui","STRING",0,"X(08)",null,0,0,"FECHA LIQUIDACIÓN",false),
	FIELD25("IBC:180-180:","oputicta","STRING",0,"X(01)",null,0,0,"TIPO DE CUENTA",false),
	FIELD26("IBC:181-185:","opnumcta","STRING",0,"9(05)",null,0,0,"NÚMERO DE CUENTA",false),
	FIELD27("IBC:186-189:","opcentpa","STRING",0,"X(04)",null,0,0,"ENTIDAD PAGADORA",false);	


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

	
	CAMessageTypeX02Field(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
