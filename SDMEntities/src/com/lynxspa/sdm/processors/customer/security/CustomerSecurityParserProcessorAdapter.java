package com.lynxspa.sdm.processors.customer.security;

import java.io.FileInputStream;

import org.hibernate.Session;

import com.lynxspa.exception.FPMException;

public interface CustomerSecurityParserProcessorAdapter {

	public int processFile (Session _session,FileInputStream _stream,CustomerSecurityRegisterCallback _callback,final String _encoding,final String _filename) throws FPMException;
}
