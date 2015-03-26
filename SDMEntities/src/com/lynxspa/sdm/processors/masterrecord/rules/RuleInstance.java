package com.lynxspa.sdm.processors.masterrecord.rules;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lynxspa.entities.application.logs.utils.LogBean;
import com.lynxspa.sdm.processors.masterrecord.rules.consequences.ConditionEvaluationResult;


public class RuleInstance<T extends Comparable<T>> extends RuleBean {

	
	@SuppressWarnings("unchecked")
	protected RuleInstance(Class type) {
		super(type);
	}

	public ConditionEvaluationResult evalCondition(Comparable<T> _leftValue,Comparable<T> _rightValue){
		
		ConditionEvaluationResult reply=ConditionEvaluationResult.SKIPPED;
		boolean evaluationResult=true;
		
		if(_rightValue!=null){
			evaluationResult=this.condition.executeCondition(this,_leftValue,_rightValue,this.parameters);
			reply=(evaluationResult)? ConditionEvaluationResult.TRUE : ConditionEvaluationResult.FALSE;
		}
		
		return reply;
	}

	public LogBean getConditionAlert(String _leftValueId,String _rightValueId){
		
		LogBean reply=null;
		List<String> messageParams=null;
		
		reply=new LogBean(this.condition);
		messageParams=new ArrayList<String>();
		messageParams.add(this.fieldName);
		messageParams.add(_leftValueId);
		messageParams.add(_rightValueId);
		if((this.parameters!=null)&&(this.parameters.length>0)){
			messageParams.add(this.parameters[0]);
			if(this.parameters[1].charAt(0)=='%'){
				messageParams.add(this.parameters[1]);
			}else{
				if(Date.class.equals(this.conditionType)){
					messageParams.add("condition.param.days");
				}else{
					messageParams.add("condition.param.units");
				}
			}
			
		}
		reply.setParameters(messageParams.toArray());
		
		return reply;
	}

	@SuppressWarnings("unchecked")
	public Comparable<T> computeDifference(Comparable<T> _leftValue, Comparable<T> _rightValue){
		
		Comparable<T> reply=null;

		if(Boolean.class.equals(this.conditionType)){
			reply=(Comparable<T>)Boolean.TRUE;
		}else if(Long.class.equals(this.conditionType)){
			reply=(Comparable<T>)new Long(Math.abs((((Long)_leftValue).longValue()-((Long)_rightValue).longValue())));
		}else if(Double.class.equals(this.conditionType)){
			reply=(Comparable<T>)new Double(Math.abs((((Double)_leftValue).doubleValue()-((Double)_rightValue).doubleValue())));
		}else if(Date.class.equals(this.conditionType)){
			reply=(Comparable<T>)new Date(Math.abs((((Date)_leftValue).getTime()-((Date)_rightValue).getTime())));
		}else if(String.class.equals(this.conditionType)){
			reply=(Comparable<T>)((String)_leftValue).substring((((String)_rightValue).length()<(((String)_leftValue).length())? ((String)_rightValue).length() : (((String)_leftValue).length())));
		}
		
		return reply;
	}

	@SuppressWarnings("unchecked")
	public int computePercentDifference(Comparable<T> _leftValue, Comparable<T> _rightValue){
		
		int reply=0;

		if(Boolean.class.equals(this.conditionType)){
			reply=((((Boolean)_leftValue)==((Boolean)_rightValue))? 0 : 100);
		}else if(Long.class.equals(this.conditionType)){
			reply=(int)(Math.abs((((Long)_leftValue).longValue()-((Long)_rightValue).longValue()))*100/((Long)_leftValue).longValue());
		}else if(Double.class.equals(this.conditionType)){
			reply=(int)(Math.abs((((Double)_leftValue).doubleValue()-((Double)_rightValue).doubleValue()))*100/((Double)_leftValue).doubleValue());
		}else if(Date.class.equals(this.conditionType)){
			reply=(int)(Math.abs((((Date)_leftValue).getTime()-((Date)_rightValue).getTime()))*100/((Date)_leftValue).getTime());
		}else if(String.class.equals(this.conditionType)){
			reply=(int)(Math.abs((((String)_leftValue).length()-((String)_rightValue).length()))*100/((String)_leftValue).length());
		}
		
		return reply;
	}

	@SuppressWarnings("unchecked")
	public Comparable<T> parseValue(String _amount){
		
		Comparable<T> reply=null;

		if(Boolean.class.equals(this.conditionType)){
			reply=(Comparable<T>)Boolean.TRUE;
		}else if(Long.class.equals(this.conditionType)){
			reply=(Comparable<T>)new Long(_amount);
		}else if(Double.class.equals(this.conditionType)){
			reply=(Comparable<T>)new Double(_amount);
		}else if(Date.class.equals(this.conditionType)){
			Calendar calendar=null;
			calendar=Calendar.getInstance();
			calendar.setTimeInMillis(0l);
			calendar.add(Calendar.DAY_OF_YEAR,Integer.parseInt(_amount));
			reply=(Comparable<T>)calendar.getTime();
		}else if(String.class.equals(this.conditionType)){
			reply=(Comparable<T>)_amount;
		}
		
		return reply;
	}
}
