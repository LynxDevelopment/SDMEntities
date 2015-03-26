package com.lynxspa.sdm.processors.masterrecord.rules.targets;

import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider;
import com.lynxspa.sdm.entities.events.providers.CAInfoEventProvider;
import com.lynxspa.sdm.entities.events.providers.CAManualEventProvider;


public enum Target{

	EVERYBODY("EVERYBODY","everybody",false){
		public boolean isTarget(Object _posibleTarget,String _extraParam){
			return true;
		}
	},
	MANUAL("MANUAL","manual",false){
		public boolean isTarget(Object _posibleTarget,String _extraParam){
			return (((CAEventCollected)_posibleTarget).getEventProvider() instanceof CAManualEventProvider);
		}
	},
	CUSTODIANS("CUSTODIANS","custodian",false){
		public boolean isTarget(Object _posibleTarget,String _extraParam){
			return (((CAEventCollected)_posibleTarget).getEventProvider() instanceof CACustodianEventProvider);
		}
	},
	PROVIDERINFO("PROVIDERINFO","provider.info",false){
		public boolean isTarget(Object _posibleTarget,String _extraParam){
			return (((CAEventCollected)_posibleTarget).getEventProvider() instanceof CAInfoEventProvider);
		}
	},
	PROVIDER("PROVIDER","alert.and.master.record",true){
		public boolean isTarget(Object _posibleTarget,String _extraParam){
			return (((CAEventCollected)_posibleTarget).getEventProvider().getId().equals(_extraParam));
		}
	};
	
	
	private String code=null;
	private String description=null;
	private boolean particular=false;

	
	Target(String _code,String _description,boolean _particular){
		this.code=_code;
		this.description=_description;
		this.particular=_particular;
	}	
	
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public boolean isParticular() {
		return particular;
	}
	
	public abstract boolean isTarget(Object _posibleTarget,String _extraParam);
}
