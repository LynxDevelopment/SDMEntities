package com.lynxspa.sdm.entities.events.adapters;

import java.util.List;

public interface CAEventGroupAdapter extends CAEventAdapter{

	public CAEventCollectedAdapter getMasterEvent();
	public void setMasterEvent(CAEventCollectedAdapter masterSource);

	public List<? extends CAEventCollectedAdapter> getGroupedEvents();
	public void setGroupedEvents(List<? extends CAEventCollectedAdapter> groupedEvents);
}