package com.lynxspa.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.impl.SessionFactoryImpl;

public class ConexionSquirrel {
	public static String configurationFile ="E:/workspace_sdm/SDM/SDMEntities/src/hibernate.cfg.xml";
	
	private static SessionFactory sessionFactory;
	
	public SessionFactoryImpl getSessionFactoryImpl(){
		SessionFactoryImpl session=null;
		try{
			File hibernateFile = new File (ConexionSquirrel.configurationFile);
//			System.out.println("Fichero "+(hibernateFile==null));
//			System.out.println("Fichero "+hibernateFile.getAbsolutePath());
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.configure(hibernateFile);
			sessionFactory = config.buildSessionFactory();
			session =(SessionFactoryImpl)sessionFactory;
			System.out.println("Terminando");
		}catch(Throwable ex){
			System.err.println("Error creando sesionFactory "+ex.getMessage()); 
		}finally{
//			String [] entities = session.getStatistics().getEntityNames();
//			for (String entity:entities){
//				System.out.println("session: "+entity);
//			}
		}
		
		return session;
	}
	
	public static void main(String[] args) {
		ConexionSquirrel con = new ConexionSquirrel();
		con.getSessionFactoryImpl();
	}
}
