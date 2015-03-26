package com.lynxspa.sdm.installer;


import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lynxspa.hbt.utils.DatabaseManager;


public class Install extends Task {

	private String configuration=null;
	private boolean simulation=false;
	
	
	public void setSimulation(boolean simulation) {
		System.out.println("simulation: "+simulation);
		this.simulation = simulation;
	}
	
	public void setConfiguration(String configuration) {
		System.out.println("Configuration: "+configuration);
		this.configuration = configuration;
	}

	
	public void execute() {

		SessionFactory factory=null;
		Session session=null;
		System.out.println("execute: ");
		try{
			factory = DatabaseManager.getSessionFactory(this.configuration);
			session=factory.getCurrentSession();
            session.beginTransaction();
            //Init install applications
            (new SDMDataInstaller()).createData(session);
            (new SDMDemoDataInstaller()).createData(session);
            //End install applications
            if (this.simulation)
            	session.getTransaction().rollback();
            else
            	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	e.printStackTrace();
        	throw new BuildException(e);
        }finally{
    		DatabaseManager.getSessionFactory().close();
        }
	}
}
