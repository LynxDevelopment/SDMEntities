package com.lynxspa.sdm.processors.normalize.staticdata;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.Session;

import bsh.Interpreter;

import com.lynxspa.entities.securities.assets.AssetType;
import com.lynxspa.entities.securities.assets.messages.AssetMessage;
import com.lynxspa.entities.securities.assets.messages.AssetMessageField;
import com.lynxspa.entities.securities.assets.providers.Provider;
import com.lynxspa.sdm.entities.events.details.CAEventDetailExtended;
import com.lynxspa.sdm.managers.StaticConfigManager;
import com.lynxspa.sdm.processors.normalize.NormalizeScriptConfigBean;
import com.lynxspa.sdm.processors.normalize.utils.StaticMessageField;

public class BeanShellStaticDataNormalizeProcessor implements StaticDataNormalizeProcesorAdapter{
	
	private StringBuffer buildScript(List<NormalizeScriptConfigBean> _scripts) throws Exception{
		
		StringBuffer reply=null;
		String[] fieldPathSplitted=null;
		String extension=null;
		String field=null;
		int position=0;

		reply=new StringBuffer();
		//Field Normalization
		for(NormalizeScriptConfigBean config:_scripts){
			if((config.getScript()!=null)&&(!"".equals(config.getScript()))){
				fieldPathSplitted=config.getTableFieldPath().split(":");
				extension=fieldPathSplitted[0];
				if(!config.isExtension()){
					field=(fieldPathSplitted.length>=2)? fieldPathSplitted[1] : null;
					position=(fieldPathSplitted.length==3)? Integer.parseInt(fieldPathSplitted[2]) : 0;
					reply.append("Object get"+extension+field+position+"(StaticEventMessageWrapper _message){\n");
					reply.append("	\ntry{\n");
					reply.append("		"+config.getScript());
					reply.append("	\n}catch(FieldNotFoundException e){\n");
					reply.append("		print(e);");
					reply.append("	\n}\n");
					reply.append("\n	return null;");
					reply.append("\n}\n");
					if("BODY".equals(extension)){
						reply.append("Object value"+extension+field+position+"=get"+extension+field+position+"(initialContext);\n");
					}
				}
			}
		}
		//Field Recovery data by extension
		for(NormalizeScriptConfigBean config:_scripts){
			if((config.getScript()!=null)&&(!"".equals(config.getScript()))){
				fieldPathSplitted=config.getTableFieldPath().split(":");
				extension=fieldPathSplitted[0];
				if(config.isExtension()){
					reply.append("List get"+extension+"(StaticEventMessageWrapper _message){");
					reply.append("	"+config.getScript());
					reply.append("\n}\n");
					reply.append("List value"+extension+"Fields=get"+extension+"(initialContext);\n");
					reply.append("List value"+extension+"=new ArrayList();\n");
					reply.append("for(int ic1=0;ic1<value"+extension+"Fields.size();ic1++){\n");
					reply.append("	Map content=new HashMap();\n");
					for(NormalizeScriptConfigBean extensionConfigs:_scripts){
						if((!extensionConfigs.isExtension())&&(extensionConfigs.getScript()!=null)&&(!"".equals(extensionConfigs.getScript()))){
							String[] extensionfieldPathSplitted=extensionConfigs.getTableFieldPath().split(":");
							if(extension.equals(extensionfieldPathSplitted[0])){
								field=(extensionfieldPathSplitted.length>=2)? extensionfieldPathSplitted[1] : null;
								position=(extensionfieldPathSplitted.length==3)? Integer.parseInt(extensionfieldPathSplitted[2]) : 0;
								reply.append("	content.put(\""+field+position+"\",get"+extension+field+position+"(new StaticEventMessageWrapper(session,value"+extension+"Fields.get(ic1),initialContext.getNormalizedOperation(),initialContext.getNormalizedProvider(),initialContext.getNormalizedEventType())));\n");
							}
						}
					}
					reply.append("	value"+extension+".add(content);\n");
					reply.append("\n}\n");
				}
			}
		}
		
		return reply;
	}
	
	private Interpreter prepareContext(Session _session, AssetMessage _message,PrintStream _stream) throws Exception {

		Interpreter reply=null;
		List<StaticMessageField> fields=null;
		StringBuffer initialScript=null;

		_session.lock(_message, LockMode.NONE);
		initialScript=new StringBuffer();
		initialScript.append("import java.util.*;\n");
		initialScript.append("import java.text.*;\n");
		initialScript.append("import org.hibernate.Session;\n");
		initialScript.append("import com.lynxspa.sdm.processors.normalize.utils.StaticMessageField;\n");
		initialScript.append("import com.lynxspa.sdm.processors.normalize.utils.StaticEventMessageWrapper;\n");
		initialScript.append("import com.lynxspa.entities.securities.assets.messages.AssetMessageType;\n");
		initialScript.append("import com.lynxspa.sdm.processors.normalize.utils.FieldNotFoundException;\n");
		initialScript.append("import com.lynxspa.sdm.processors.normalize.utils.SDMSwiftParser;\n");
		initialScript.append("import com.prowidesoftware.swift.*;\n");
		initialScript.append("Session session=null;\n");
		initialScript.append("List fields=null;\n");
		initialScript.append("AssetMessageType messageType=null;\n");
		initialScript.append("StaticEventMessageWrapper initialContext=null;\n");
		reply=new Interpreter(null,_stream,_stream,false);
		reply.eval(initialScript.toString());
		reply.set("session",_session);
		fields=new ArrayList<StaticMessageField>();
		for(String path:_message.getFields().keySet()){
			final AssetMessageField messageField=(AssetMessageField) _message.getFields().get(path);
			if((messageField.getValue()!=null)&&(messageField.getValue().trim().length()>0)){
				//fields.add(new StaticMessageField(messageField));
			}
		}
		reply.set("fields",fields);
		//reply.set("messageType",);
		//reply.set("normalizedSecurity",_session.load(SPSecurity.class, _message.getNormalizedSecurity().getId()));
		reply.set("normalizedOperation",_message.getNormalizeOperationCode());
		reply.set("normalizedProvider",_session.load(Provider.class,_message.getProvider().getId()));
		reply.set("normalizedAssetType",_session.load(AssetType.class,_message.getAssetType()));
		reply.set("originalMessage",_message.getOriginalMessage());
		reply.eval("initialContext=new StaticEventMessageWrapper(session,fields,normalizedOperation,normalizedProvider,normalizedAssetType,originalMessage);\n\n\n");
		
		return reply;
	}

	private void setExtensionFieldValues(CAEventDetailExtended _extensions,Map<String,Object> _values) throws Exception{

		Object value=null;
		
		for(String _valueName:_values.keySet()){
			value=_values.get(_valueName);
			if(value!=null){
				_extensions.set(_valueName, value);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private StaticDataNormalizeResultBean recoverDataFromScriptContext(StaticDataNormalizeResultBean _result,List<NormalizeScriptConfigBean> _scripts,Interpreter _context) throws Exception{

		StaticDataNormalizeResultBean reply=null;
		String[] fieldPathSplitted=null;
		String extension=null;
		String field=null;
		int position=0;
		Object value=null;

		reply=_result;	
		for(NormalizeScriptConfigBean config:_scripts){
			if((config.getScript()!=null)&&(!"".equals(config.getScript()))){
				fieldPathSplitted=config.getTableFieldPath().split(":");
				extension=fieldPathSplitted[0];
				if(!config.isExtension()){
					if("BODY".equals(extension)){
						field=(fieldPathSplitted.length>=2)? fieldPathSplitted[1] : null;
						position=(fieldPathSplitted.length==3)? Integer.parseInt(fieldPathSplitted[2]) : 0;
						if((value=_context.get("value"+extension+field+position))!=null)
							reply.getDetails().set(field+position,value);
					}
				}
			}
		}

		return reply;
	}

	
	protected StaticDataNormalizeResultBean scriptsProcessing(Session _session,List<NormalizeScriptConfigBean> _scripts, AssetMessage _message) throws Exception {
		
		StaticDataNormalizeResultBean reply=null;
		Interpreter beanshellContext=null;
		StringBuffer script=null;
		PrintStream stream=null;
		ByteArrayOutputStream outputStream=null;
		
		reply=new StaticDataNormalizeResultBean();
		if((_scripts!=null)&&(_scripts.size()>0)){
			//Prepare bean shell script
			script=buildScript(_scripts);
			reply.setGeneratedScript(script.toString());
			//Evaluate Script
			outputStream=new ByteArrayOutputStream();
			stream=new PrintStream(outputStream,false,"ISO-8859-1");
			beanshellContext=prepareContext(_session,_message,stream);
			//Evaluate Script
			try{
				beanshellContext.eval(script.toString());
				reply=recoverDataFromScriptContext(reply,_scripts,beanshellContext);
			}catch (Exception e) {
				reply.setException(e);
			}
			stream.flush();
			reply.setOutput(outputStream.toString());
			stream.close();
		}
		
		return reply;
	}

	
	public StaticDataNormalizeResultBean normalize(Session _session, AssetMessage _message) throws Exception{
		
		StaticDataNormalizeResultBean reply=null;
		List<NormalizeScriptConfigBean> scripts=null;
		
		reply=new StaticDataNormalizeResultBean(); 
		//Search for scripts configuration
		//scripts=StaticConfigManager.getInstance().getNormalizationScripts(_session, _message.getProvider(), _message.getNormalizedAssetType());
		//call script processing
		reply=scriptsProcessing(_session,scripts,_message);

		return reply;
	}
	
	
	public StaticDataNormalizeResultBean test(Session _session,List<NormalizeScriptConfigBean> _scripts, AssetMessage _message) throws Exception {
		return scriptsProcessing(_session,_scripts,_message);
	}
}
