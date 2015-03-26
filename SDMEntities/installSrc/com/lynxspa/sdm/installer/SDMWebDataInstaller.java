package com.lynxspa.sdm.installer;

import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;
import com.lynxspa.sdm.installer.config.defaults.GroupDict;
import com.lynxspa.sdm.installer.config.defaults.UserDict;
import com.lynxspa.sdm.installer.config.menus.MenuDict;
import com.lynxspa.sdm.installer.config.security.ModuleDict;
import com.lynxspa.sdm.installer.config.security.ResourceCollectionDict;
import com.lynxspa.xweb.installer.WebInstaller;


public class SDMWebDataInstaller extends WebInstaller{

	
	public SDMWebDataInstaller(){
		super();
		this.moduleDictClass=ModuleDict.class;
		this.menuDictClass=MenuDict.class;
		this.resourceCollectionDictClass=ResourceCollectionDict.class;
		this.groupDictClass=GroupDict.class;
		this.userDictClass=UserDict.class;
	}

	@Override
	protected void preUserData(Session _session) {
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void postUserData(Session _session) {
		
    	Class<DbDataInstaller> customerInstallerClass=null;
    	DbDataInstaller customerInstaller=null;

    	//Configuring coac for customer
        try{
        	customerInstallerClass=(Class<DbDataInstaller>)Class.forName("com.lynxspa.sdm.installer.SDMWebCustomerDataInstaller");
        	customerInstaller=customerInstallerClass.newInstance();
        }catch(Exception e){
        	System.out.println("Customer installer [com.lynxspa.sdm.installer.SDMWebCustomerDataInstaller] not found.");
        	customerInstaller=null;
        }
        if(customerInstaller!=null){
            try{
            	customerInstaller.createData(_session);
            }catch(Exception e){
            	throw new RuntimeException(e);
            }
        }
	}
}
