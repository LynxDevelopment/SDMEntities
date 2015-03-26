package com.lynxspa.sdm.processors.normalize.staticdata;

import java.io.Serializable;
import java.util.HashMap;

import com.lynxspa.entities.securities.assets.AssetStaticDetails;
import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.sdm.entities.events.details.CAEventDetail;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtended;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtensionId;

public class StaticDataNormalizeResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2266232935356812212L;

	private String output=null;
	private String generatedScript=null; 
	private Exception exception=null;
	private AssetType type=null;
	private AssetStaticDetails details=null;
	
	public StaticDataNormalizeResultBean(){
		this.details=new AssetStaticDetails("NORMALIZER");
	}
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
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
	public AssetType getType() {
		return type;
	}
	public void setType(AssetType type) {
		this.type = type;
	}
	public AssetStaticDetails getDetails() {
		return details;
	}
	public void setDetails(AssetStaticDetails details) {
		this.details = details;
	}
	
	
}
