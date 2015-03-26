package com.lynxspa.sdm.processors.prenormalize;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.exception.FPMException;
import com.lynxspa.exception.dict.BasicErrorDict;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.CABasicDomains;
import com.lynxspa.sdm.dictionaries.CAType;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.entities.events.messages.CAEventMessage;
import com.lynxspa.sdm.entities.events.providers.CAExternalEventProvider;
import com.lynxspa.sdm.entities.events.types.CAEventType;
import com.lynxspa.sdm.managers.SDMConfigManager;
import com.lynxspa.sdm.processors.prenormalize.plugin.DefaultPrenormalizerPlugin;
import com.lynxspa.utils.ReflectionUtils;
import com.lynxspa.utils.StringUtils;

public class DefaultPrenormalizerProcessor implements PrenormalizerProcessorAdapter {

	private DefaultPrenormalizerPlugin defaultPlugin=null;
	private volatile Map<String,DefaultPrenormalizerPlugin> prenormalizerPlugins=null;
	
	public DefaultPrenormalizerProcessor(){
		this.defaultPlugin=new DefaultPrenormalizerPlugin();
		this.prenormalizerPlugins=new HashMap<String, DefaultPrenormalizerPlugin>(); 
	}
	
	@SuppressWarnings("unchecked")
	protected DefaultPrenormalizerPlugin getPrenormalizerPlugin(String _eventProviderId) throws FPMException{
	
		DefaultPrenormalizerPlugin reply=null;
		
		if((reply=this.prenormalizerPlugins.get(_eventProviderId))==null){
			synchronized(DefaultPrenormalizerProcessor.class){
				if((reply=this.prenormalizerPlugins.get(_eventProviderId))==null){
					Class<DefaultPrenormalizerPlugin> prenormalizerClass=null;
					try{prenormalizerClass=(Class<DefaultPrenormalizerPlugin>)Class.forName("com.lynxspa.sdm.prenormalizer.providers."+_eventProviderId);}catch (Throwable e) {}
					if(prenormalizerClass!=null){
						try{
							reply=prenormalizerClass.newInstance();
						}catch(Throwable e){
							throw new FPMException(e);
						}
					}else{
						reply=this.defaultPlugin;
					}
					this.prenormalizerPlugins.put(_eventProviderId,reply);
				}
			}
		}
		
		return reply;
	}
	
	public String prenormalizeOperation(Session _session,CAEventMessage _message, String _user, String _locale) throws FPMException{

		String reply=null;
		
		try{
			if(_message.getOperation()==null)
				throw new FPMException(LogErrorDict.UNKNOWN_OPERATION,new Object[]{"null",_message.getId(),_message.getMessageType().getId().getFormat().getId()+" - "+_message.getMessageType().getId().getCode()});
			if((reply=SDMConfigManager.getInstance().getDomainNorm(_session, CABasicDomains.OPERATION.getCode(),_message, _message.getOperation()))==null)
				throw new FPMException(LogErrorDict.UNKNOWN_OPERATION,new Object[]{_message.getOperation(),_message.getId(),_message.getMessageType().getId().getFormat().getId()+" - "+_message.getMessageType().getId().getCode()});
		}catch(FPMException e){
			throw e;
		}catch (Exception e) {
			throw new FPMException(BasicErrorDict.UNEXPECTED_ERROR,e);
		}
		
		return reply;
	}

	public CAExternalEventProvider prenormalizeProvider(Session _session,CAEventMessage _message, String _user, String _locale) throws FPMException{

		CAExternalEventProvider reply=null;
		
		try{
			final Query query=_session.createQuery("select p from CAFormatProvider as fp join fp.eventProvider as p where p.auditor.deleted=:isAuditorDeleted and fp.messageFormat=:format and fp.idAtMessage=:idAtMessage");
			query.setParameter("isAuditorDeleted",false);
			query.setParameter("format", _message.getMessageType().getId().getFormat());
			query.setParameter("idAtMessage", _message.getSender());
			query.setFetchSize(1);
			query.setMaxResults(1);
			if((reply=(CAExternalEventProvider)query.uniqueResult())==null)
				throw new FPMException(LogErrorDict.UNKNOWN_PROVIDER,new Object[]{_message.getSender(),_message.getId(),_message.getMessageType().getId().getFormat().getId()+" - "+_message.getMessageType().getId().getCode()});
		}catch(FPMException e){
			throw e;
		}catch (Exception e) {
			throw new FPMException(BasicErrorDict.UNEXPECTED_ERROR,e);
		}
		
		return reply;
	}
	
	@SuppressWarnings("unchecked")
	public CAEventType prenormalizeEventType(Session _session,CAEventMessage _message, String _user, String _locale) throws FPMException{

		CAEventType reply=null;
		if (_message.getEventProvider()!=null){
			final DefaultPrenormalizerPlugin prenormalizer=getPrenormalizerPlugin(_message.getEventProvider().getId());
			reply=prenormalizer.prenormalizeEventType(_session, _message, _user, _locale);
		}else{
			reply = (CAEventType)_session.load(CAEventType.class, CAType.OTHR.getCode());
		}
		return reply;
	}

	public SPVirtualSecurity prenormalizeSecurity(Session _session,CAEventMessage _message, String _user, String _locale) throws FPMException{
		
		SPVirtualSecurity reply=null;
		Query query=null;
		
		try{
			final String securityType=_message.getSecurityType();
			final String codetosearch=StringUtils.checkNotExist(SDMConfigManager.getInstance().getDomainNorm(_session, CABasicDomains.SECURITYCODETYPE.getCode(),_message,securityType.trim().toUpperCase()),securityType.trim().toUpperCase());
			//Security existence validation
			if(_message.getSecurity()==null)
				throw new FPMException(LogErrorDict.SECURITY_NOT_FOUND,new Object[]{_message.getId()});
			//Security search
			if("ISIN".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and isin=:securityId");
			}else if("CUSIP".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and cusip=:securityId");
			}else if("SEDOL".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and sedol=:securityId");
			}else if("IPRVID1".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and infoProviderId1=:securityId");
			}else if("IPRVID2".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and infoProviderId2=:securityId");
			}else if("IPRVID3".equalsIgnoreCase(codetosearch)){
				query=_session.createQuery("from SPVirtualSecurity where auditor.deleted=:isDeleted and infoProviderId3=:securityId");
			}else{
				throw new FPMException(LogErrorDict.SECURITYTYPE_NOT_FOUND,new Object[]{codetosearch,_message.getId()});
			}
			query.setBoolean("isDeleted",false);
			query.setString("securityId",_message.getSecurity());
			query.setFetchSize(1);
			query.setMaxResults(1);
			reply=(SPVirtualSecurity)query.uniqueResult();
			reply=ReflectionUtils.deproxy(reply, SPVirtualSecurity.class);
			//Security not found creating new virtual security
			if(reply==null){
				reply = new SPVirtualSecurity();
				reply.setName(StringUtils.getSecureSizeValue(_message.getSecurityName(),64,"UNKNOWN"));
				if("ISIN".equalsIgnoreCase(codetosearch)){
					reply.setIsin(StringUtils.getSecureSizeValue(_message.getSecurity(),12,null));
				}else if("CUSIP".equalsIgnoreCase(codetosearch)){
					reply.setCusip(StringUtils.getSecureSizeValue(_message.getSecurity(),9,null));
				}else if("SEDOL".equalsIgnoreCase(codetosearch)){
					reply.setSedol(StringUtils.getSecureSizeValue(_message.getSecurity(),7,null));
				}else if("IPRVID1".equalsIgnoreCase(codetosearch)){
					reply.setInfoProviderId1(StringUtils.getSecureSizeValue(_message.getSecurity(),16,null));
				}else if("IPRVID2".equalsIgnoreCase(codetosearch)){
					reply.setInfoProviderId2(StringUtils.getSecureSizeValue(_message.getSecurity(),16,null));
				}else if("IPRVID3".equalsIgnoreCase(codetosearch)){
					reply.setInfoProviderId3(StringUtils.getSecureSizeValue(_message.getSecurity(),16,null));
				}
				HibernateUtils.customSave(_session,reply,_user);
			}
			//Set if is in customer portfolio
			if(reply instanceof SPSecurity){
				_message.setInCustomerPortfolio(((SPSecurity)reply).isInCustomerPortfolio());
			}else{
				_message.setInCustomerPortfolio(false);
			}
			//Set normalizable
			final DefaultPrenormalizerPlugin prenormalizer=getPrenormalizerPlugin(_message.getEventProvider().getId());
			_message.setMainMarket(prenormalizer.isMainMarket(_session,_message,reply,_user,_locale));
		}catch (FPMException e) {
			throw e;
		}catch (Exception e) {
			throw new FPMException(BasicErrorDict.UNEXPECTED_ERROR,e);
		}
		
		return reply;
	}
}
