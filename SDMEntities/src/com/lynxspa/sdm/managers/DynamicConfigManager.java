package com.lynxspa.sdm.managers;

import com.lynxspa.managers.ConfigManager;

public class DynamicConfigManager extends ConfigManager{
	
	public static final String APPLICATIONNAME="DYNAMIC";
	public static final String BUNDLENAME="sdm";
		
	private DynamicConfigManager(){
		super();
		super.initialize();
	}
	
	public static DynamicConfigManager getInstance(){
		if(DynamicConfigManager.instance==null){
			synchronized(DynamicConfigManager.class){
				if(DynamicConfigManager.instance==null){
					DynamicConfigManager.instance=new DynamicConfigManager();
				}
			}
		}	
		return DynamicConfigManager.instance;
	}
	
	public static DynamicConfigManager instance=null;
		
	public String getApplicationName() {
		return DynamicConfigManager.APPLICATIONNAME;
	}
		
	public String getBundleName(){
		return DynamicConfigManager.BUNDLENAME;
	}
	
}