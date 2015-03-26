package com.lynxspa.sdm.processors.customer;

import java.io.BufferedReader;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.lynxspa.exception.FPMException;
import com.lynxspa.sdm.managers.SDMConfigManager;

public class DefaultCustomerUploadProcessor implements CustomerUploadDataProcessorAdapter{

	public void processFile(Session session, SDMConfigManager manager, BufferedReader reader, StatelessSession statelessSession, String user) throws FPMException {
		//Nothing to do
		System.out.println("DefaultCustomerUploadProcessor::processFile() NOTHING TO DO!! Change TB_CONFIG table to point out to your own customer processor");
	}

}
