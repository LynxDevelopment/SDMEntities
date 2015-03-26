package com.lynxspa.sdm.processors.normalize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lynxspa.sdm.entities.events.details.CAEventDetail;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtended;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtensionId;
import com.lynxspa.sdm.entities.events.types.CAEventType;

public class NormalizeResultBean implements Serializable {

	private static final long serialVersionUID = 4833710680387605042L;
	
	
	private String output=null;
	private String generatedScript=null; 
	private Exception exception=null;
	private CAEventType type=null;
	private CAEventDetail detail=null;
	private Map<CAEventDetailExtensionId,CAEventDetailExtended> extendedDetails=null;
	
	public NormalizeResultBean(){
		this.detail=new CAEventDetail("NORMALIZER");
		this.extendedDetails=new HashMap<CAEventDetailExtensionId,CAEventDetailExtended>();
	}
	
	public CAEventType getType() {
		return type;
	}
	public void setType(CAEventType type) {
		this.type = type;
	}
	public CAEventDetail getDetail() {
		return detail;
	}
	public void setDetail(CAEventDetail detail) {
		this.detail = detail;
	}
	public Map<CAEventDetailExtensionId,CAEventDetailExtended> getExtendedDetails() {
		return extendedDetails;
	}
	public void setExtendedDetails(Map<CAEventDetailExtensionId,CAEventDetailExtended> extendedDetails) {
		this.extendedDetails = extendedDetails;
	}
	public String getGeneratedScript() {
		return generatedScript;
	}
	public void setGeneratedScript(String generatedScript) {
		this.generatedScript = generatedScript;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
