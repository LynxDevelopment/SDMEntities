package com.lynxspa.sdm.processors.masterrecord.rules;

import java.util.List;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.exception.FPMException;
import com.lynxspa.exception.FPMExceptionMessage;
import com.lynxspa.sdm.entities.events.CAEventCollected;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.ConditionEvaluationResult;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;
import com.lynxspa.sdm.processors.masterrecord.rules.results.RuleResultDebugBean;
import com.lynxspa.sdm.processors.masterrecord.rules.results.RulesResultBean;
import com.lynxspa.sdm.utils.EventDetailUtils;


public class RuleMachine {

	private boolean debug=false;
	
	
	public RuleMachine(){
	}
	public RuleMachine(boolean _debug){
		this.debug=_debug;
	}
	
	
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	
	@SuppressWarnings("unchecked")
	public RulesResultBean evalRules(Consequence _startingConsequence,List<LogBean> _startingAlerts,List<RuleInstance> _conditions,CAEventCollected _masterRecordCandidate,List<CAEventCollected> _eventsCollected) throws FPMException{
		
		RulesResultBean reply=null;
		ConditionEvaluationResult conditionResult=null;
		Consequence ruleEvalResult=null;
		CAEventCollected comparingEventCollected=null;
		RuleInstance evaluatingCondition=null;
		LogBean log=null;
		int ic=0;

		reply=new RulesResultBean(_masterRecordCandidate,_startingConsequence);
		reply.setAlerts(_startingAlerts);
		for(int ic1=0;ic1<_eventsCollected.size();ic1++){
			comparingEventCollected=_eventsCollected.get(ic1);
			if(comparingEventCollected.getId()!=_masterRecordCandidate.getId()){
				for(int ic2=0;ic2<_conditions.size();ic2++){
					conditionResult=null;
					evaluatingCondition=_conditions.get(ic2);
					if(evaluatingCondition.getTargetConstant().isTarget(comparingEventCollected, evaluatingCondition.getTargetParam())){
						conditionResult=evaluatingCondition.evalCondition((Comparable)EventDetailUtils.getEventDetailValue(comparingEventCollected.getEventDetail(), evaluatingCondition.getField(),0),(Comparable)EventDetailUtils.getEventDetailValue(_masterRecordCandidate.getEventDetail(),evaluatingCondition.getField(),0));
						if(conditionResult.isEvaluated()){
							ruleEvalResult=(conditionResult.isOk())? evaluatingCondition.getResultOnTrue() : evaluatingCondition.getResultOnFalse();
							reply.accumulateResult(ruleEvalResult);
							if(!ruleEvalResult.isMasterRecord()){
								log=evaluatingCondition.getConditionAlert(String.valueOf(_masterRecordCandidate.getId()),String.valueOf(comparingEventCollected.getId()));
								throw new FPMException((FPMExceptionMessage)log.getMessage(),log.getParameters());
							}
							if(ruleEvalResult.isAlert())
								reply.addAlert(evaluatingCondition.getConditionAlert(String.valueOf(_masterRecordCandidate.getId()),String.valueOf(comparingEventCollected.getId())));
						}
					}else{
						conditionResult=ConditionEvaluationResult.NOTTARGET;
					}
					if(debug)
						reply.addDebugInfo(new RuleResultDebugBean(ic,_masterRecordCandidate,comparingEventCollected,evaluatingCondition,conditionResult,ruleEvalResult));
					ic++;
				}
			}
		}
		
		return reply;
	}
}
