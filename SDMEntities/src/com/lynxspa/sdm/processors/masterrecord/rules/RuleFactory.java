package com.lynxspa.sdm.processors.masterrecord.rules;

import java.util.Date;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.sdm.entities.events.types.CAEventTypeDetail;
import com.lynxspa.sdm.processors.masterrecord.rules.conditions.Condition;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.Consequence;


public class RuleFactory extends RuleBean{

	
	public RuleFactory(){
		super(Object.class);
	}
	
	@SuppressWarnings("unchecked")
	public RuleInstance getConditionInstance(String _target,CAEventTypeDetail _eventDetail,String _condition,String _resultOnTrue,String _resultOnFalse,String _conditionParams){
		
		RuleInstance reply=null;
		
		reply=buildRuleInstance(_target,_eventDetail,Condition.valueOf(_condition),Consequence.valueOf(_resultOnTrue),Consequence.valueOf(_resultOnFalse),_conditionParams); 
		
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	protected RuleInstance buildRuleInstance(String _target,CAEventTypeDetail _eventDetail,Condition _condition,Consequence _resultOnTrue,Consequence _resultOnFalse,String _conditionParams){
		
		RuleInstance reply=null;
		ClassType classType=null;
		
		classType=ClassType.valueOf(_eventDetail.getFieldType());
		if(ClassType.BOOLEAN.equals(classType)){
			reply=new RuleInstance<Boolean>(Boolean.class);
		}else if(ClassType.LONG.equals(classType)){
			reply=new RuleInstance<Long>(Long.class);
		}else if(ClassType.DOUBLE.equals(classType)){
			reply=new RuleInstance<Double>(Double.class);
		}else if(ClassType.TIMESTAMP.equals(classType)){
			reply=new RuleInstance<Date>(Date.class);
		}else{
			reply=new RuleInstance<String>(String.class);
		}
		reply.setTarget(_target);
		reply.setField(_eventDetail.getFieldPath());
		reply.setFieldName(_eventDetail.getName());
		reply.setCondition(_condition);
		reply.setResultOnTrue(_resultOnTrue);
		reply.setResultOnFalse(_resultOnFalse);
		if((_conditionParams!=null)&&(_conditionParams.length()>0))
			reply.setParameters(_conditionParams.split("\\|"));
		
		return reply;
	}
}
