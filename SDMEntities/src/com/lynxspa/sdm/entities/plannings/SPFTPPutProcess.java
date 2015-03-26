package com.lynxspa.sdm.entities.plannings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FTPPUT")
public class SPFTPPutProcess extends SPFTPGetProcess{

	private static final long serialVersionUID = 72209882433726974L;

	public SPFTPPutProcess (){
		
	}
	
	public SPFTPPutProcess(String _user, String _path, String _fileName,
			String _extension, String _description, String _ftpUser, String _ftpPasseword,
			String _ftpServer, String _ftpPath, boolean _overWrite) {
		super(_user, _path, _fileName, _extension, _description, _ftpUser,  _ftpPasseword,
				 _ftpServer,  _ftpPath,_overWrite);
 
	}

	public SPFTPPutProcess(String _user, String _path, String _fileName,
			String _extension, String _description, String _ftpUser, String _ftpPasseword,
			String _ftpServer, String _ftpPath, boolean _overWrite, String _ftpFile, 
			String _ftpProxy, String _ftpPort, String _ftpProxyUser, String _ftpProxyPassword,
			boolean _ftpBinary, boolean _ftpPassiveMode) {
		super(_user, _path, _fileName, _extension, _description, _ftpUser,  _ftpPasseword,
				 _ftpServer,  _ftpPath,_overWrite, _ftpFile, _ftpProxy, _ftpPort, 
				 _ftpProxyUser, _ftpProxyPassword,_ftpBinary, _ftpPassiveMode);
 
	}
}
