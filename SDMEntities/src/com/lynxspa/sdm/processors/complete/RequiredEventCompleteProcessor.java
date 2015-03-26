package com.lynxspa.sdm.processors.complete;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.utils.EventDetailUtils;


public class RequiredEventCompleteProcessor implements EventCompleteAdapter {

	@SuppressWarnings("unchecked")
	public boolean isEventComplete(Session _session, CAEventCollected _eventCollected) throws Exception{
		
		boolean reply=true;
		Query query=null;
		List<String> requiredFields=null;
		
		query=_session.createQuery("select details.fieldPath from CAEventFieldConfig as config join config.eventTypeDetail as details with details.eventType.id=:eventTypeId where config.required=1");
		query.setParameter("eventTypeId", _eventCollected.getEventType().getId());
		query.setReadOnly(true);
		query.setFetchSize(165);
		requiredFields=(List<String>)query.list();
		for(int ic1=0;((reply)&&(ic1<requiredFields.size()));ic1++){
			reply=EventDetailUtils.isEventDetailValueNull(_eventCollected.getEventDetail(),requiredFields.get(ic1));	
		}
		
		return reply;
	}

}
