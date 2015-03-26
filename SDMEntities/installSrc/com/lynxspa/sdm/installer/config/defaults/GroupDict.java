package com.lynxspa.sdm.installer.config.defaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lynxspa.sdm.installer.config.menus.MenuDict;
import com.lynxspa.sdm.installer.config.security.FunctionSDMDict;
import com.lynxspa.sdm.installer.config.security.FunctionPLANNINGDict;
import com.lynxspa.sdm.installer.config.security.ResourceCollectionDict;
import com.lynxspa.xweb.installer.adapters.FunctionDictAdapter;
import com.lynxspa.xweb.installer.adapters.GroupDictAdapter;

public enum GroupDict implements GroupDictAdapter{
	
	SDMCONFIGURATOR("SDMCONFIGURATOR","Configurator group for sdm",new FunctionDictAdapter[][]{FunctionSDMDict.values(),FunctionPLANNINGDict.values()},new String[]{MenuDict.SDM.getCode()},new String[]{ResourceCollectionDict.XWEB.getName(),ResourceCollectionDict.SDM.getName()});
	
	private String code=null;
	private String name=null;
	private FunctionDictAdapter[] functions=null;
	private String[] menus=null;
	private String[] resourceCollections=null;
	
	GroupDict(String _code,String _name,FunctionDictAdapter[][] _functions,String[] _menus,String[] _resourceCollections){
		this.code=_code;
		this.name=_name;
		if(_functions!=null){
			List<FunctionDictAdapter> functionsList=new ArrayList<FunctionDictAdapter>();
			for(FunctionDictAdapter[] functionsArray:_functions){
				functionsList.addAll(Arrays.asList(functionsArray));
			}
			this.functions=functionsList.toArray(new FunctionDictAdapter[]{});
		}
		this.menus=_menus;
		this.resourceCollections=_resourceCollections;
	}

	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public FunctionDictAdapter[] getFunctions() {
		return functions;
	}
	public String[] getMenus() {
		return menus;
	}
	public String[] getResourceCollections() {
		return resourceCollections;
	}
	public boolean isSystemGroup(){
		return false;
	}
}
