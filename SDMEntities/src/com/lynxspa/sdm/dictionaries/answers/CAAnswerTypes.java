package com.lynxspa.sdm.dictionaries.answers;

public enum CAAnswerTypes {
	
	CHAR("CHAR","Cheks","Varias opciones, una respuesta"),
	SHORTSTRING("SHORTSTRING","Texto Corto","Max. 32 caracteres"),
	MIDDLESTRING("MIDDLESTRING","Texto Medio","Max. 64 caracteres"),
	LONGSTRING("LONGSTRING","Texto Largo","Max. 128 caracteres"),
	VERYLONGSTRING("VERYLONGSTRING","Texto muy largo",""),
	DOUBLE("DOUBLE","Número decimal","Respuesta si o no"),
	TIMESTAMP("TIMESTAMP","Fecha",""),
	LONG("LONG","Número entero",""),
	BOOLEAN("BOOLEAN","SI/NO","");

	String code = null;
	String name = null;
	String description= null;

	CAAnswerTypes (String _code, String _name, String _description){
		this.code = _code;
		this.name = _name;
		this.description = _description;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
