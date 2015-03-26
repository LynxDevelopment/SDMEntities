package com.lynxspa.sdm.installer;

import org.hibernate.Session;

import com.lynxit.utils.installer.DbDataInstaller;

public class SDMDevelopInstaller implements DbDataInstaller {

	@SuppressWarnings("unchecked")
	public void createData(Session _session) throws Exception {
		
		Class<DbDataInstaller> customizationInstallerClass=null;
		DbDataInstaller customizationInstaller=null;
		
		try{
			customizationInstallerClass=(Class<DbDataInstaller>) Class.forName("com.lynxspa.sdm.installer.SDMDemoCustomizationInstaller");
			customizationInstaller=customizationInstallerClass.newInstance();
		}catch (Exception e) {
			System.out.println("Class [com.lynxspa.sdm.installer.SDMDemoCustomizationInstaller] not found, installing SDMDemoDataInstaller");
			customizationInstaller=new SDMDemoDataInstaller();
		}
		customizationInstaller.createData(_session);
	}
}
