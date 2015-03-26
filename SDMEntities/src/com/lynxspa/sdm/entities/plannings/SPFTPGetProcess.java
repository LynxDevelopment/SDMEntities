package com.lynxspa.sdm.entities.plannings;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FTPGET")
public class SPFTPGetProcess extends SPFileProcess{

	private static final long serialVersionUID = 72209882433726974L;

	private String ftpUser=null;
	private String ftpPassword=null;
	private String ftpServer=null;
	private String ftpPath=null;
	private String ftpFile=null;
	private boolean ftpBinary=true;
	private boolean ftpPassiveMode=true;
	private String ftpProxy=null;
	private String ftpPort=null;
	private String ftpProxyUser=null;
	private String ftpProxyPassword=null;
	
	public SPFTPGetProcess (){
		
	}
	
	public SPFTPGetProcess(String _user, String _path, String _fileName,
			String _extension, String _description, String _ftpUser, String _ftpPasseword,
			String _ftpServer, String _ftpPath, boolean _overWrite) {
		super(_user, _path, _fileName, _extension, _description, _overWrite);
		this.ftpUser = _ftpUser;
		this.ftpPassword = _ftpPasseword;
		this.ftpServer = _ftpServer;
		this.ftpPath = _ftpPath;
		this.ftpFile = null;
		this.ftpProxy = null;
		this.ftpPort = null;
		this.ftpBinary = true;
		this.ftpPassiveMode = true;
		this.ftpProxyUser = null;
		this.ftpProxyPassword = null;
	}

	public SPFTPGetProcess(String _user, String _path, String _fileName,
			String _extension, String _description, String _ftpUser, String _ftpPasseword,
			String _ftpServer, String _ftpPath, boolean _overWrite, String _ftpFile, 
			String _ftpProxy, String _ftpPort, String _ftpProxyUser, String _ftpProxyPassword,
			boolean _ftpBinary, boolean _ftpPassiveMode) {
		super(_user, _path, _fileName, _extension, _description, _overWrite);
		this.ftpUser = _ftpUser;
		this.ftpPassword = _ftpPasseword;
		this.ftpServer = _ftpServer;
		this.ftpPath = _ftpPath;
		this.ftpFile = _ftpFile;
		this.ftpProxy = _ftpProxy;
		this.ftpPort = _ftpPort;
		this.ftpBinary = _ftpBinary;
		this.ftpPassiveMode = _ftpPassiveMode;
		this.ftpProxyUser = _ftpProxyUser;
		this.ftpProxyPassword = _ftpProxyPassword;
	}

	@Column(name="FTP_USER", length=128, nullable=true)
	public String getFtpUser() {
		return ftpUser;
	}
	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}
	
	@Column(name="FTP_PASSWORD", length=128, nullable=true)
	public String getFtpPassword() {
		return ftpPassword;
	}
	public void setFtpPassword(String _ftpPassword) {
		this.ftpPassword = _ftpPassword;
	}
	
	@Column(name="FTP_SERVER", length=128, nullable=true)
	public String getFtpServer() {
		return ftpServer;
	}
	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}

	@Column(name="FTP_PATH", length=256, nullable=true)
	public String getFtpPath() {
		return ftpPath;
	}

	public void setFtpPath(String ftpPath) {
		this.ftpPath = ftpPath;
	}

	@Column(name="FTP_FILE", length=128, nullable=true)
	public String getFtpFile() {
		return ftpFile;
	}

	public void setFtpFile(String ftpFile) {
		this.ftpFile = ftpFile;
	}

	@Column(name="FTP_BINARY", nullable=true)
	public boolean isFtpBinary() {
		return ftpBinary;
	}

	public void setFtpBinary(boolean ftpBinary) {
		this.ftpBinary = ftpBinary;
	}

	@Column(name="FTP_PASSIVE_MODE", nullable=true)
	public boolean isFtpPassiveMode() {
		return ftpPassiveMode;
	}

	public void setFtpPassiveMode(boolean ftpPassiveMode) {
		this.ftpPassiveMode = ftpPassiveMode;
	}

	@Column(name="FTP_PROXY", length=128, nullable=true)
	public String getFtpProxy() {
		return ftpProxy;
	}

	public void setFtpProxy(String ftpProxy) {
		this.ftpProxy = ftpProxy;
	}

	@Column(name="FTP_PORT", length=6, nullable=true)
	public String getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(String ftpPort) {
		this.ftpPort = ftpPort;
	}

	@Column(name="PROXY_USER", length=128, nullable=true)
	public String getFtpProxyUser() {
		return ftpProxyUser;
	}

	public void setFtpProxyUser(String ftpProxyUser) {
		this.ftpProxyUser = ftpProxyUser;
	}

	@Column(name="PROXY_PASSWORD", length=128, nullable=true)
	public String getFtpProxyPassword() {
		return ftpProxyPassword;
	}

	public void setFtpProxyPassword(String ftpProxyPassword) {
		this.ftpProxyPassword = ftpProxyPassword;
	}
	
	
}
