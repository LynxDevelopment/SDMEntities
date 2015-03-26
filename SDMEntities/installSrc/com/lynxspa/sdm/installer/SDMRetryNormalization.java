package com.lynxspa.sdm.installer;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.entities.application.Application;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTMESSAGEFlow;
import com.lynxit.utils.installer.DbDataInstaller;

public class SDMRetryNormalization implements DbDataInstaller {
	
	protected String user=null;
	protected Application application=null;
	protected String configurationClassPath=null;

	
	public SDMRetryNormalization(){
		super();
		this.user="DEMOINSTALLER";
	}
	
	public void createData(Session _session) throws Exception {
		this.application=(Application)_session.get(Application.class,"SDM");
    	this.configurationClassPath="com.lynxspa.sdm.dictionaries.events.configuration";
    	System.out.println("Borrando eventos");
    	deleteEvents(_session);
    	System.out.println("Actualizando mensajes para volver a ser normalizados");
    	updateMessages(_session);
	}
	
	protected void deleteEvents(Session _session) throws Exception{
		Query query=null;
		int affectedValues=0;

		query = _session.createQuery("delete CAEvent");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTS:"+affectedValues);
    	query = _session.createQuery("delete CAEventDetail");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTDETAILS:"+affectedValues);
    	query = _session.createQuery("delete CAEventDetailExtended");
    	affectedValues=query.executeUpdate();
    	System.out.println("Registros borrados de la tabla  TB_CA_EVENTEXTDETAILS:"+affectedValues);
	}
	
	protected void updateMessages(Session _session) throws Exception{
		Query query=null;
		int affectedValues=0;
		
		
		
    	String[] oldValues = {CAStatesEVENTMESSAGEFlow.PRSD.getId(),CAStatesEVENTMESSAGEFlow.MSDS.getId(),CAStatesEVENTMESSAGEFlow.PNFA.getId(),
			CAStatesEVENTMESSAGEFlow.NNRM.getId(), CAStatesEVENTMESSAGEFlow.NORM.getId(), CAStatesEVENTMESSAGEFlow.NRFA.getId()};
        query = _session.createQuery("update CAEventMessage set operationStatus.state.id.code=:newState where operationStatus.state.id.code in (:oldStates)");
        query.setString("newState", CAStatesEVENTMESSAGEFlow.PNRM.getId());
        query.setParameterList("oldStates", oldValues);
        affectedValues = query.executeUpdate();
        System.out.println("Mensajes con estado modificado:"+affectedValues);
	}
}
