package com.lynxspa.sdm.processors.masterrecord;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.dictionaries.logs.LogWarningDict;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.entities.events.CAEventGroup;
import com.lynxspa.sdm.entities.events.configuration.CAEventConfig;
import com.lynxspa.sdm.entities.events.configuration.CAEventMasterRecordConfig;
import com.lynxspa.sdm.entities.events.providers.CACustodianEventProvider;
import com.lynxspa.sdm.entities.events.providers.CAManualEventProvider;
import com.lynxspa.sdm.managers.SDMConfigManager;
import com.lynxspa.sdm.processors.masterrecord.rules.RuleFactory;
import com.lynxspa.sdm.processors.masterrecord.rules.RuleInstance;
import com.lynxspa.sdm.processors.masterrecord.rules.RuleMachine;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;
import com.lynxspa.sdm.processors.masterrecord.rules.results.RulesResultBean;

public class RulesMRProcessor implements MRProcessorAdapter {

	
	@SuppressWarnings("unchecked")
	protected MasterRecordSelection internalSelectMR (Session _session,CAEventConfig _eventConfig, CAEventGroup _eventGroup,boolean _debug) throws FPMException {
		
		RulesResultBean reply=null;
		RuleFactory ruleFactory=null;
		List<RuleInstance> rules=null;
		RuleMachine ruleMachine=null;
		CAEventCollected primaryMasterRecord=null;
		CAEventCollected secondaryMasterRecord=null;
		CAEventCollected selectedMasterRecord=null;
		List<CAEventCollected> groupEvents=null;
		List<LogBean> startingAlerts=null;
		boolean custodianOrManual=false;
		Consequence startingConsequence=Consequence.MASTERRECORD;
		
		startingAlerts=new ArrayList<LogBean>();
		//Prepare ruleMachine
		ruleFactory=new RuleFactory();
		rules=new ArrayList<RuleInstance>();
		for(CAEventMasterRecordConfig configRule:_eventConfig.getMasterRecordConfigs()){
			rules.add(ruleFactory.getConditionInstance(configRule.getTarget(),configRule.getDetail(),configRule.getCondition(),configRule.getOnTrueResult(),configRule.getOnFalseResult(),configRule.getConditionParams()));
		}
		//Find potential MasterRecord
		groupEvents=(List<CAEventCollected>)_eventGroup.getGroupedEvents();
		for(CAEventCollected event:groupEvents){
			if((primaryMasterRecord==null)&&(event.getEventProvider().getId().equals(_eventConfig.getPreferentProvider().getId()))){
				primaryMasterRecord=event;
			}
			if((secondaryMasterRecord==null)&&(event.getEventProvider().getId().equals(_eventConfig.getSecondPreferentProvider().getId()))){
				secondaryMasterRecord=event;
			}
			if((event.getEventProvider() instanceof CACustodianEventProvider)||(event.getEventProvider() instanceof CAManualEventProvider))
				custodianOrManual=true;
		}
		selectedMasterRecord=(primaryMasterRecord!=null)? primaryMasterRecord : secondaryMasterRecord;
		if(selectedMasterRecord==null){
			startingConsequence=startingConsequence.accumulatePriority(Consequence.valueOf(_eventConfig.getOnPrimaryAndSecondaryNotFound()));
			if(!Consequence.valueOf(_eventConfig.getOnPrimaryAndSecondaryNotFound()).isMasterRecord())
				throw new FPMException(LogWarningDict.PRIMARYANDSECONDARYMRNOTFOUND);
			if(Consequence.valueOf(_eventConfig.getOnPrimaryAndSecondaryNotFound()).isAlert())
				startingAlerts.add(new LogBean(LogWarningDict.PRIMARYANDSECONDARYMRNOTFOUND));
			for(CAEventCollected event:groupEvents){
				if((selectedMasterRecord==null)||(selectedMasterRecord.getEventProvider().isHeavier(event.getEventProvider()))){
					selectedMasterRecord=event;
				}
			}
		}
		//First rule validation if exist any custodian or manual provider
		if(!custodianOrManual){
			startingConsequence=startingConsequence.accumulatePriority(Consequence.valueOf(_eventConfig.getOnCustodianAndManualNotFound()));
			if(!Consequence.valueOf(_eventConfig.getOnCustodianAndManualNotFound()).isMasterRecord())
				throw new FPMException(LogWarningDict.MANUALANDCUSTODIANNOTFOUND);
			if(Consequence.valueOf(_eventConfig.getOnCustodianAndManualNotFound()).isAlert())
				startingAlerts.add(new LogBean(LogWarningDict.MANUALANDCUSTODIANNOTFOUND));
		}
		//Eval rules
		ruleMachine=new RuleMachine(_debug);
		reply=ruleMachine.evalRules(startingConsequence,startingAlerts,rules,selectedMasterRecord,groupEvents);
				
		return reply;
	}

	public MasterRecordSelection findMasterRecord(Session _session, CAEventGroup _eventGroup) throws FPMException {
		
		RulesResultBean reply=null;
		CAEventConfig eventConfig=null;
		
		eventConfig=SDMConfigManager.getInstance().getEventConfigurations(_session, _eventGroup.getEventType());
		reply=(RulesResultBean)internalSelectMR(_session,eventConfig,_eventGroup,false);
		
		return reply;
	}

	@SuppressWarnings("unchecked")
	public MasterRecordSelection test(Session _session,CAEventConfig _eventConfig, CAEventGroup _eventGroup) throws FPMException {
		
		return internalSelectMR(_session,_eventConfig,_eventGroup,false);
	}
}
