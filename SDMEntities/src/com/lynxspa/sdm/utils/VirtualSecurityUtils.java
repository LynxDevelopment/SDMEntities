package com.lynxspa.sdm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxspa.entities.application.logs.utils.LogUtils;
import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.exception.FPMException;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTMESSAGEFlow;
import com.lynxspa.sdm.dictionaries.logs.LogInfoDict;
import com.lynxspa.sdm.managers.SDMConfigManager;

public final class VirtualSecurityUtils {


	public static final void replaceVirtualSecurity(final Session _session, final SPSecurity _security, String _user, String _locale) throws FPMException{
		SPVirtualSecurity virtualSecurity = null;
		Query query = null;
		int affectedRows = 0;
		
		query=_session.createQuery("from SPVirtualSecurity where isin=:isinValue");
		query.setString("isinValue", _security.getIsin());
		virtualSecurity = (SPVirtualSecurity)query.uniqueResult();
		
		if (virtualSecurity!=null){
			query=_session.createQuery("update CAEventMessage set normalizedSecurity.id=:securityId,operationStatus.state.id.code=:newState where normalizedSecurity.id=:virtualSecurityId");
			query.setLong("securityId", _security.getId());
			query.setString("newState", CAStatesEVENTMESSAGEFlow.PRSD.getId());
			query.setLong("virtualSecurityId", virtualSecurity.getId());
			affectedRows=query.executeUpdate();
			
			//delete virtual security
			HibernateUtils.customDelete(_session, virtualSecurity, _user);
			LogUtils.createLog(_session,_user,SDMConfigManager.BUNDLENAME,new Locale(_locale),SDMConfigManager.getInstance().getApplication(_session),LogInfoDict.VIRTUAL_SECURITY_REPLACED,new Object[]{virtualSecurity.getId(),_security.getId(),affectedRows},null,false);
		}		
	}

	public static final void replaceVirtualSecurities(final Session _session, String _user, String _locale) throws Exception{
		List<SPSecurity> securities = null;
		List <SPVirtualSecurity> virtualIsines = null;
		Query query = null;
		int affectedRows = 0;
		Long securityId = 0l;
		try {
		virtualIsines = new ArrayList<SPVirtualSecurity>();
		query=_session.createQuery("select virtualSec from SPVirtualSecurity virtualSec where SECURITYCLASS='virtual' and virtualSec.auditor.deleted=:isDeleted and isin is not null");
		query.setParameter("isDeleted", false);
		virtualIsines  = query.list();
		
		if (virtualIsines.size()>0){
			securities = new ArrayList<SPSecurity>();
			for (SPVirtualSecurity virtualSec:virtualIsines){
				query=_session.createQuery("select sec from SPSecurity sec where sec.isin =:isinValue and sec.auditor.deleted=:isDeleted");
				query.setParameter("isinValue", virtualSec.getIsin());
				query.setParameter("isDeleted", false);
				securities = query.list();
				if (securities.size()>0){
					for (SPSecurity sec:securities){
						securityId = sec.getId();
						query=_session.createQuery("update CAEventMessage set normalizedSecurity.id=:securityId,operationStatus.state.id.code=:newState where normalizedSecurity.id=:virtualSecurityId");
						query.setLong("securityId", sec.getId());
						query.setString("newState", CAStatesEVENTMESSAGEFlow.PRSD.getId());
						query.setLong("virtualSecurityId", virtualSec.getId());
						affectedRows=query.executeUpdate();
					}
					if (securityId!=null){
						//delete virtual security
						HibernateUtils.customDelete(_session, virtualSec, _user);
						LogUtils.createLog(_session,_user,SDMConfigManager.BUNDLENAME,new Locale(_locale),SDMConfigManager.getInstance().getApplication(_session),LogInfoDict.VIRTUAL_SECURITY_REPLACED,new Object[]{virtualSec.getId(),securityId,affectedRows},null,false);
					}
					securityId=null;
				}
			}
			HibernateUtils.commitTransaction(_session);
			_session.flush();
		}
		}catch (Exception e){
			throw e;
		}
			
	}
}
