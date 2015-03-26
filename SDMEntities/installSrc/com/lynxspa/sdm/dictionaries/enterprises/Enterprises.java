package com.lynxspa.sdm.dictionaries.enterprises;

import com.lynxspa.entities.jobs.SDMEnterprise;

public enum Enterprises {
	
	ENTERPRISE1("Howards","Empresa Mágica","BIC12309","Escocia", "0034986828"),
	ENTERPRISE2("Mercadona","Mercado na","BIC787628","Valencia","961238767");
	
	private String name;
	private String description;
	private String bic;
	private String address;
	private String tlf;
	private SDMEnterprise parentEnterprise;

	Enterprises(String name, String description, String bic, String address, String tlf) {
		this.name=name;
		this.description=description;
		this.bic=bic;
		this.address=address;
		this.tlf=tlf;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getBic() {
		return bic;
	}

	public String getAddress() {
		return address;
	}

	public String getTlf() {
		return tlf;
	}

	public SDMEnterprise getParentEnterprise() {
		return parentEnterprise;
	}

	
	
	
}
