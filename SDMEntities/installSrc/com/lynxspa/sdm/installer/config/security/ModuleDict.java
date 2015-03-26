package com.lynxspa.sdm.installer.config.security;

import com.lynxspa.xweb.installer.adapters.FunctionDictAdapter;
import com.lynxspa.xweb.installer.adapters.ModuleDictAdapter;

public enum ModuleDict implements ModuleDictAdapter{
	
	SDM("SDM","Security Data Management","/fpm/routing/administration/index.xwb","Corporate actions administration pannel","/images/icons/miscellaneous/invoice/invoice_32_h_g.gif",FunctionSDMDict.class),
	PLANNING("PLANNINGS","Plannings","/fpm/sdm/plannings/viewPlanifications.xwb","Plannings administration pannel","/images/icons/miscellaneous/invoice/invoice_32_h_g.gif",FunctionPLANNINGDict.class);
	
	private String id=null;
	private String title=null;
	private String adminUri=null;
	private String description=null;
	private String icon1=null;
	private Class<? extends FunctionDictAdapter> functions=null;
	
	ModuleDict(String _id,String _title,String _adminUri,String _description,String _icon1,Class<? extends FunctionDictAdapter> _functions){
		this.id=_id;
		this.title=_title;
		this.adminUri=_adminUri;
		this.description=_description;
		this.icon1=_icon1;
		this.functions=_functions;
	}

	public String getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAdminUri(){
		return this.adminUri;
	}
	public String getDescription(){
		return this.description;
	}
	public String getIcon1(){
		return this.icon1;
	}
	public Class<? extends FunctionDictAdapter> getFunctions(){
		return this.functions;
	}
}
