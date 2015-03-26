package com.lynxspa.sdm.dictionaries.config;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.application.configurations.adapter.ConfigDictAdapter;

public enum SDMConfiguration  implements ConfigDictAdapter{
	
	NORMALIZEPROCESSOR("NormalizeProcessor","NormalizeProcessor class",ClassType.LONGSTRING,"com.lynxspa.sdm.processors.normalize.staticdata.BeanShellStaticDataNormalizeProcessor",false,false);
	
	private String code=null;
	private String description=null;
	private ClassType type=null;
	private Object defaultValue=null;
	private boolean updatable=false;
	private boolean editable=false;

	
	SDMConfiguration(String _code,String _description,ClassType _type,Object _defaultValue,boolean _updatable,boolean _editable){
		this.code=_code;
		this.description=_description;
		this.type=_type;
		this.defaultValue=_defaultValue;
		this.updatable=_updatable;
		this.editable=_editable;
	}
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public ClassType getType() {
		return type;
	}
	public Object getDefaultValue() {
		return defaultValue;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public boolean isEditable() {
		return editable;
	}
}
