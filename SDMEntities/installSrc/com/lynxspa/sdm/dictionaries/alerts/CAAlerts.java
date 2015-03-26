package com.lynxspa.sdm.dictionaries.alerts;

public enum CAAlerts {
	
	ALERT1("Normalizacion: Mensajes Previos no encontrados","Mensajes previos no encontrados para actualizar durante la normalizacion","/fpm/sdm/messages/normalization/fail/normalizeFailList.xwb?errorType=error.normalization.previous.new.not.found","select count(*) from CAEventMessage where TRANSMESSKEY = 'error.normalization.previous.new.not.found' and auditor.deleted = 0","00","N"),
	ALERT2("Prenormalizacion: Emisor del mensaje desconocido.","Emisor del mensaje desconocido.","/fpm/sdm/messages/prenormalization/fail/prenormalizeFailList.xwb?errorType=error.prenormalization.unknown.provider","select count(*) from CAEventMessage where TRANSMESSKEY = 'error.prenormalization.unknown.provider'","00","N"),
	ALERT3("Prenormalizacion: Código de Valor desconocido","Valor no Aceptado","/fpm/sdm/messages/prenormalization/fail/prenormalizeFailList.xwb?errorType=error.prenormalization.security.type","select count(*) from CAEventMessage where TRANSMESSKEY = 'error.prenormalization.security.type' and auditor.deleted = 0","00","N"),
	ALERT4("Prenormalizacion: Operacion del mensaje desconocida","Operacion Desconocida <fmt:message key=''error.prenormalization.security.type'' />","/fpm/sdm/messages/prenormalization/fail/prenormalizeFailList.xwb?errorType=error.prenormalization.unknown.operation","select count(*) from CAEventMessage where TRANSMESSKEY = 'error.prenormalization.unknown.operation'  and auditor.deleted = 0","00","N"),
	ALERT5("Valores virtuales","Valores virtuales","/fpm/sdm/administration/securities/viewSecurities.xwb?virtualSecurity=virtual","select count(*) from SPVirtualSecurity sp where sp.class = 'virtual' and auditor.deleted = 0","00","N"),
	ALERT6("Normalizacion: Mensajes a actualizar no normalizados","Mensajes a actualizar no normalizados","/fpm/sdm/messages/normalization/fail/normalizeFailList.xwb?messageNotNormalized=true","select count(*) from CAEventMessage where TRANSMESSKEY = 'error.normalization.previous.new.not.normalized'","00","N");
	
	private String label;
	private String descLabel;
	private String link;
	private String query;
	private String role;
	private String graph;
	
	CAAlerts (String _label, String _descLabel,String _link,String _query, 
			String _role, String _graph){
		
		this.label = _label;
		this.descLabel = _descLabel;
		this.link = _link;
		this.query = _query;
		this.role = _role;
		this.graph = _graph;
	}

	public String getLabel() {
		return label;
	}

	public String getDescLabel() {
		return descLabel;
	}

	public String getLink() {
		return link;
	}

	public String getQuery() {
		return query;
	}

	public String getRole() {
		return role;
	}

	public String getGraph() {
		return graph;
	}
}
