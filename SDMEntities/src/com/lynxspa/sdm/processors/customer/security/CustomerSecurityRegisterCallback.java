package com.lynxspa.sdm.processors.customer.security;

import com.lynxspa.sdm.importers.securities.beans.SecurityBean;

public interface CustomerSecurityRegisterCallback {

	public void processRegister(SecurityBean _securityBean,int _position);
}
