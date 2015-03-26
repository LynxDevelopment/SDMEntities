package com.lynxspa.fpm.functions;

import org.hibernate.Query;
import org.hibernate.Session;

import com.lynxit.fpm.functionlibraries.FunctionLibrarySupport;
import com.lynxit.fpm.resources.Resource;
import com.lynxit.fpm.resources.ResourceId;
import com.lynxit.fpm.resources.ResourcesManager;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.entities.securities.dictionaries.SPSecurityIdType;
import com.lynxspa.exception.FPMException;
import com.lynxspa.exception.FPMRuntimeException;
import com.lynxspa.exception.dict.BasicWarningDict;


public abstract class PortfolioFrameworkFunctions extends FunctionLibrarySupport {	
	
	public SPVirtualSecurity getSecurity(String _resourceName,String _securityIdType,String _securityId) throws Exception{
		
		SPVirtualSecurity reply=null;
		Resource<Session> resource=null;
		Query query=null;
		SPSecurityIdType securityIdType=null;
		
		try{
			securityIdType=SPSecurityIdType.valueOf(_securityIdType);
			if(securityIdType==null)
				throw new FPMException(BasicWarningDict.SECURITYCODE_TYPE_NOTACCEPTED,new Object[]{_securityIdType,_securityId});
			resource=ResourcesManager.getInstance().getResource(new ResourceId<Session>(_resourceName));
			query=resource.getCurrentInstance().createQuery("from SPVirtualSecurity as security where security."+securityIdType.getSecurityField()+"=:"+securityIdType.getSecurityField());
			query.setParameter(securityIdType.getSecurityField(),_securityId);
			reply=(SPVirtualSecurity)query.uniqueResult();
		}catch(Throwable e){
			throw new FPMRuntimeException(e);
		}
		
		return reply;
	}
}
