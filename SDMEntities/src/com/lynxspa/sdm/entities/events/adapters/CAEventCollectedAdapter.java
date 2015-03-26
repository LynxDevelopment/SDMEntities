package com.lynxspa.sdm.entities.events.adapters;

import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.providers.CAEventProvider;

public interface CAEventCollectedAdapter extends CAEventAdapter{

	public CAEventProvider getEventProvider();
	public void setEventProvider(CAEventProvider _eventProvider);
	public CAEventGroupAdapter getEventGroup();
	public void setEventGroup(CAEventGroupAdapter eventGroup);
	public CAEventDetailAdapter getEventDetail();
	public void setEventDetail(CAEventDetailAdapter _eventDetail);

	public Boolean getComplete();
	public void setComplete(Boolean complete);
}