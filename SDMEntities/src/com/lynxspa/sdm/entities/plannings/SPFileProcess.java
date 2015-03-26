package com.lynxspa.sdm.entities.plannings;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.lynxspa.entities.plannings.SPProcess;

@Entity
@DiscriminatorValue("FILETOPATH")
public class SPFileProcess extends SPProcess {

	private static final long serialVersionUID = 2799512184239835654L;
	private String path=null;
	private String fileName=null;
	private String extension=null;
	private boolean overwrite=false;

	public SPFileProcess (){
		
	}
	
	public SPFileProcess(String _user, String _path, String fileName,
			String _extension, String _description, boolean _overWrite) {
		super(_user,_description);
		this.path = _path;
		this.fileName = fileName;
		this.extension = _extension;
		this.overwrite = _overWrite;
	}


	@Column(name="PATH", length=64, nullable=false)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name="FILENAME", length=64, nullable=false)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="FILEEXTENSION", length=6, nullable=false)
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Column(name="OVERWRITE", nullable=false)
	public boolean isOverwrite() {
		return overwrite;
	}

	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}	
}
