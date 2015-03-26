package com.lynxspa.sdm.processors.masterrecord.rules.conditions;

import com.lynxspa.entities.application.logs.utils.LogDictAdapter;
import com.lynxspa.entities.application.logs.utils.LogLevel;
import com.lynxspa.exception.FPMExceptionMessage;
import com.lynxspa.exception.FPMExceptionType;
import com.lynxspa.sdm.processors.masterrecord.rules.RuleInstance;


public enum Condition implements LogDictAdapter,FPMExceptionMessage{

	LESS("LESS","condition.less","warning.rules.less.alert","{0} field in event {1} is greater than or equal to selected master record {2}",false){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;

			if((_leftValue!=null)&&(_leftValue.compareTo(_rightValue)<0))
				reply=true;
			
			return reply;
		}
	},
	LESSOREQUAL("LESSOREQUAL","condition.less.or.equal","warning.rules.lessorequal.alert","{0} field in event {1} is greater than selected master record {2}",false){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;

			if((_leftValue!=null)&&(_leftValue.compareTo(_rightValue)<=0))
				reply=true;

			return reply;
		}
	},
	EQUAL("EQUAL","condition.equal","warning.rules.equal.alert","{0} field in event {1} is different of selected master record {2}",false){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;

			if((_leftValue!=null)&&(_leftValue.compareTo(_rightValue)==0))
				reply=true;
			
			return reply;
		}
	},
	GREATEROREQUAL("GREATEROREQUAL","condition.greater.or.equal","warning.rules.greaterorequal.alert","{0} field in event {1} is less of selected master record {2}",false){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;

			if((_leftValue!=null)&&(_leftValue.compareTo(_rightValue)>=0))
				reply=true;
			
			return reply;
		}
	},
	GREATER("GREATER","condition.greater","warning.rules.greater.alert","{0} field in event {1} is less than or equal to selected master record {2}",false){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;

			if((_leftValue!=null)&&(_leftValue.compareTo(_rightValue)>0))
				reply=true;
			
			return reply;
		}
	},
	INBOTTOMMARGIN("INBOTTOMMARGIN","condition.in.bottom.margin","warning.rules.inbottommargin.alert","{0} field in event {1} is out of lower margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;
			
			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)<=0){
					reply=true;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=true;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=true;
					}
				}
			}
				
			return reply;
		}
	},
	INTOPMARGIN("INTOPMARGIN","condition.in.top.margin","warning.rules.intopmargin.alert","{0} field in event {1} is out of top margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;
			
			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)>=0){
					reply=true;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=true;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=true;
					}
				}
			}
				
			return reply;
		}
	},
	INBOTTOMANDTOPMARGIN("INBOTTOMANDTOPMARGIN","condition.in.bottomandtop.margin","warning.rules.intopandbottommargin.alert","{0} field in event {1} is out of margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=false;
			
			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)==0){
					reply=true;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=true;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=true;
					}
				}
			}
				
			return reply;
		}
	},
	OUTBOTTOMMARGIN("OUTBOTTOMMARGIN","condition.out.bottom.margin","warning.rules.intopmargin.alert","{0} field in event {1} is in lower margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=true;

			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)<=0){
					reply=false;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=false;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=false;
					}
				}
			}

			return reply;
		}
	},
	OUTTOPMARGIN("OUTTOPMARGIN","condition.out.top.margin","warning.rules.intopmargin.alert","{0} field in event {1} is in top margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=true;

			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)>=0){
					reply=false;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=false;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=false;
					}
				}
			}

			return reply;
		}
	},
	OUTBOTTOMORTOPMARGIN("OUTBOTTOMORTOPMARGIN","condition.out.bottomortop.margin","warning.rules.intopmargin.alert","{0} field in event {1} is in margin of {3} {4} compared to selected master record {2}",true){
		@SuppressWarnings("unchecked")
		public boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams){
			
			boolean reply=true;

			if(_leftValue!=null){
				if(_leftValue.compareTo(_rightValue)==0){
					reply=false;
				}else{
					if("%".equals(_conditionParams[1])){
						int percentDifference=0;
						percentDifference=_typedCondition.computePercentDifference(_leftValue, _rightValue);
						if(percentDifference<Integer.parseInt(_conditionParams[0]))
							reply=false;
					}else{
						Comparable differenceResult=null;
						differenceResult=_typedCondition.computeDifference(_leftValue, _rightValue);
						if(differenceResult.compareTo(_typedCondition.parseValue(_conditionParams[0]))<0)
							reply=false;
					}
				}
			}

			return reply;
		}
	};
	
	
	private String code=null;
	private String description=null;
	private String messageKey=null;
	private String defaultMessage=null;
	private boolean additionalParameters=false;

	
	Condition(String _code,String _description,String _messageKey,String _defaultMessage,boolean _additionalParameters){
		this.code=_code;
		this.description=_description;
		this.messageKey=_messageKey;
		this.defaultMessage=_defaultMessage;
		this.additionalParameters=_additionalParameters;
	}
	
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public boolean getAdditionalParameters() {
		return additionalParameters;
	}
	public String getMessageKey(){
		return messageKey;
	}
	public String getDefaultMessage(){
		return defaultMessage;
	}
	public LogLevel getLevel(){
		return LogLevel.WARNING;
	}
	public FPMExceptionType getType() {
		return FPMExceptionType.WARNING;
	}
	
	@SuppressWarnings("unchecked")
	public abstract boolean executeCondition(RuleInstance _typedCondition,Comparable _leftValue, Comparable _rightValue,String... _conditionParams);
}
