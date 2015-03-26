package com.lynxspa.sdm.utils;

import java.util.Comparator;

import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;

public class CAEventTypeDetailComparator implements Comparator<CAEventTypeDetail>{

	public int compare(CAEventTypeDetail _eventDetail1,CAEventTypeDetail _eventDetail2){
		
		int reply=0;
		
		if(_eventDetail1!=_eventDetail2){
			if(_eventDetail1==null){
				reply=1;
			}else if(_eventDetail2==null){
				reply=-1;
			}else if(!_eventDetail1.getFieldPath().equals(_eventDetail2.getFieldPath())){
				//Extension check (always first)
				if((_eventDetail1.isExtension()||_eventDetail1.isExtension())&&(_eventDetail1.isExtension()!=_eventDetail1.isExtension())){
					reply=(_eventDetail1.isExtension())? -1 : 1;
				}else{
					//Group by extension
					final String extensionName1=EventDetailUtils.getExtensionCode(_eventDetail1);
					final String extensionName2=EventDetailUtils.getExtensionCode(_eventDetail2);
					reply=extensionName1.compareTo(extensionName2);
					if(reply==0){
						//Group by display group order
						if(_eventDetail1.getDisplayGroupOrder()!=_eventDetail2.getDisplayGroupOrder()){
							reply=(_eventDetail1.getDisplayGroupOrder()<_eventDetail2.getDisplayGroupOrder())? -1 : 1;
						}else{
							//Group by display in group order
							if(_eventDetail1.getDisplayInGroupOrder()!=_eventDetail2.getDisplayInGroupOrder()){
								reply=(_eventDetail1.getDisplayInGroupOrder()<_eventDetail2.getDisplayInGroupOrder())? -1 : 1;
							}
						}
					}else{
						if("BODY".equals(extensionName1)){
							reply=-1;
						}else if("BODY".equals(extensionName2)){
							reply=1;
						}
					}
				}
			}
		}
		
		return reply;
	}
}
