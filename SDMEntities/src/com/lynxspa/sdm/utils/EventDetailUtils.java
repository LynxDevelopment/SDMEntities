package com.lynxspa.sdm.utils;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtensionId;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailAdapter;
import com.lynxspa.sdm.entities.events.details.adapters.CAEventDetailExtendedAdapter;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;

public final class EventDetailUtils {

	public static final void setEventDetailValue(final CAEventDetailAdapter _eventDetail,final String _path,final Object _value,final int _extensionNumber) throws FPMException{
		
		final String[] splittedPath=_path.split(":");
		if(splittedPath[0]!=null){
			final String fieldPath=(splittedPath.length>2)? splittedPath[1]+splittedPath[2] : splittedPath[1];
			if("BODY".equals(splittedPath[0])){
				_eventDetail.set(fieldPath,_value);
			}else{
				final CAEventDetailExtendedAdapter extension=_eventDetail.getExtensions().get(new CAEventDetailExtensionId(splittedPath[0],_extensionNumber).toString());
				if(extension!=null)
					extension.set(fieldPath,_value);
			}
		}
	}

	public static final Object getEventDetailValue(final CAEventDetailAdapter _eventDetail,final String _path,final int _extensionNumber){
		
		Object reply=null;
		
		final String[] splittedPath=_path.split(":");
		if(splittedPath[0]!=null){
			final String fieldPath=(splittedPath.length>2)? splittedPath[1]+splittedPath[2] : splittedPath[1];
			if("BODY".equals(splittedPath[0])){
				reply=_eventDetail.get(fieldPath);
			}else{
				final CAEventDetailExtendedAdapter extension=_eventDetail.getExtensions().get(new CAEventDetailExtensionId(splittedPath[0],_extensionNumber).toString());
				if(extension!=null)
					reply=extension.get(fieldPath);
			}
		}
		
		return reply;
	}

	public static final boolean isEventDetailValueNull(final CAEventDetailAdapter _eventDetail,final String _path){
		return (EventDetailUtils.getEventDetailValue(_eventDetail,_path,0)!=null);
	}
	
	public static final String getExtensionCode(final CAEventTypeDetail _eventTypeDetail){
		
		String reply="BODY";
		
		final String extensionName=_eventTypeDetail.getFieldPath();
		if(extensionName.charAt(0)!='$'){
			final int extensionEnd=extensionName.indexOf(':');
			reply=(extensionEnd==-1)? extensionName : extensionName.substring(0,extensionEnd);
		}
		
		return reply;
	}
}
