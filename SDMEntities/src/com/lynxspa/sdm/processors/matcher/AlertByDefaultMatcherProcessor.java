package com.lynxspa.sdm.processors.matcher;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.config.CAConfiguration;
import com.lynxspa.sdm.dictionaries.flows.CAWorkflow;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTGROUPFlow;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;
import com.lynxspa.sdm.managers.SDMConfigManager;
import com.lynxspa.utils.UtilDate;


public class AlertByDefaultMatcherProcessor implements MatcherProcessorAdapter {

	public CAEventGroup findGroupMember(Session _session,CAEventCollected _eventCollected) throws FPMException{
		
		CAEventGroup reply=null;
		Long timeMarginInDays=null;
		Query query=null;
		Date maximumDate=null;
		Date minimumDate=null;
		int eventDate=0;
		
		//Obtain filters data
		timeMarginInDays=(Long)SDMConfigManager.getInstance().getConfiguration(_session,CAConfiguration.MATCHINGTIMEMARGIN);
		if(_eventCollected.getExecutionDate()!=null){
			minimumDate=UtilDate.calculateRelativeDate(_eventCollected.getExecutionDate(),(timeMarginInDays.intValue()*-1),0,0);
			maximumDate=UtilDate.calculateRelativeDate(_eventCollected.getExecutionDate(),timeMarginInDays.intValue(),0,0);
			eventDate=Integer.parseInt((new SimpleDateFormat("yyyyMMdd")).format(_eventCollected.getExecutionDate()));
		}else{
			minimumDate=new Date(0l);
			maximumDate=new Date(0l);
			eventDate=0;
		}
		//Search in actual event groups
		query=_session.createQuery("" +
				"from " +
				"	CAEventGroup as eventGroup " +
				"where " +
				"	eventGroup.auditor.deleted=:isDeleted and " +
				"	eventGroup.auditor.refId=:refId and " +
				"	eventGroup.eventType.id=:eventTypeId and " +
				"	eventGroup.security.id=:securityId and " +
				"	eventGroup.executionDate between :minimumDate and :maximumDate " +
				"order by abs((day(eventGroup.executionDate)+(month(eventGroup.executionDate)*100)+(year(eventGroup.executionDate)*10000))-:eventDate) desc");
		query.setParameter("isDeleted", false);
		query.setParameter("refId", 0l);
		query.setParameter("eventTypeId", _eventCollected.getEventType().getId());
		query.setParameter("securityId", _eventCollected.getSecurity().getId());
		query.setParameter("minimumDate", minimumDate);
		query.setParameter("maximumDate", maximumDate);
		query.setParameter("eventDate", eventDate);
		query.setMaxResults(1);
		query.setFetchSize(1);
		query.setReadOnly(true);
		if((reply=(CAEventGroup)query.uniqueResult())==null){
			//Search in pending collected events
			query=_session.createQuery("" +
					"select" +
					"	count(eventCollected.id)" +
					"from " +
					"	CAEventCollected as eventCollected " +
					"where " +
					"	eventCollected.auditor.deleted=:isDeleted and " +
					"	eventCollected.auditor.refId=:refId and " +
					"	eventCollected.eventType.id=:eventTypeId and " +
					"	eventCollected.security.id=:securityId and " +
					"	eventCollected.executionDate between :minimumDate and :maximumDate");
			query.setParameter("isDeleted", false);
			query.setParameter("refId", 0l);
			query.setParameter("eventTypeId", _eventCollected.getEventType().getId());
			query.setParameter("securityId", _eventCollected.getSecurity().getId());
			query.setParameter("minimumDate", minimumDate);
			query.setParameter("maximumDate", maximumDate);
			query.setMaxResults(1);
			query.setFetchSize(1);
			query.setReadOnly(true);
			if(((Long)query.uniqueResult())>0){
				reply=new CAEventGroup("MATCHERPROCESSALERTBYDEFAULT",_eventCollected);
				reply.getOperationStatus().setState(SDMConfigManager.getInstance().getState(_session, CAWorkflow.EVENTGROUP.getId(), CAStatesEVENTGROUPFlow.PMRS.getId(), true));
				_session.save(reply);
			}
		}

		return reply;
	}
}
