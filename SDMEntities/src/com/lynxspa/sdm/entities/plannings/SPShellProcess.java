package com.lynxspa.sdm.entities.plannings;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SHELL")
public class SPShellProcess extends SPFileProcess {

	private static final long serialVersionUID = 2268717140490105601L;
	private String shell=null;

	public SPShellProcess() {

	}

	public SPShellProcess(String _user, String _path,
			String fileName, String _extension, String _description,
			boolean write, String _shell) {
		super(_user, _path, fileName, _extension, _description, write);
		this.shell = _shell;
	}

	@Column(name="SHELL", length=256)
	public String getShell() {
		return shell;
	}

	public void setShell(String shell) {
		this.shell = shell;
	}
	
}
