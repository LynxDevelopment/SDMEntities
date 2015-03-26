package com.lynxspa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.AnnotationConfiguration;

import com.lynxspa.entities.application.logs.utils.LogUtils;
import com.lynxspa.entities.historics.SDMRowHistoric;
import com.lynxspa.entities.jobs.SDMRow;
import com.lynxspa.entities.jobs.SDMSecurityRow;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.config.CAConfiguration;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.managers.SDMConfigManager;

public class CopyHistoryMain {
	
	private static Integer historificationCommitSize=100;
	
	public static Integer getHistorificationCommitSize() {
		return historificationCommitSize;
	}
	public void setHistorificationCommitSize(Integer _historificationCommitSize) {
		this.historificationCommitSize = _historificationCommitSize;
	}
	
	private static String user;
	public static String getUser() {
		return user;
	}
	public void setUser(String _user) {
		this.user = _user;
	}
	
	private static String locale=null;
	public static String getLocale() {
		return locale;
	}
	public void setLocale(String _locale) {
		this.locale = _locale;
	}
	
	public static long getDaysToHistorify (Session _session) throws Exception{
		
		Long reply= null;
		SDMConfigManager manager=null;
		long DEFAULT_DAYS_TO_HISTORIFY = 30;
		
		try{
			manager=SDMConfigManager.getInstance();
			reply=(Long)manager.getConfiguration(_session,CAConfiguration.TIMETOHISTORIFICATIONMESSAGES);
		}catch (Exception e){
			e.printStackTrace();
			reply=DEFAULT_DAYS_TO_HISTORIFY;
		}
		
		return reply;
	}

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Query rowQuery = null;
		SDMRowHistoric rowHistoric = null;
		long daysTohistorify = 0l;
		Calendar historificableDate=null;
		SDMConfigManager manager=null;
		Session statefullSession=null;
		StatelessSession statelessSession=null;
		long processingTime=0l;
		long proccessedCorrectly=0;
		long proccessedWrong=0;
		int rowsMarkedForHistorification=0;
		int rowsHistorified=0;
		int valuesHistorified=0;
		int historifiedValuesUpdated=0;
		int rowsDeleted=0;
		int valuesDeleted=0;
		int historifiedRowsUpdated=0;
		long initialId=0l;
		long lastId=0l;
		
		try {
			System.out.println("main");
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			statefullSession = sessionFactory.openSession();
			statefullSession.beginTransaction();
			statelessSession = sessionFactory.openStatelessSession(statefullSession.connection());
			processingTime=System.currentTimeMillis();
			daysTohistorify=getDaysToHistorify(statefullSession);
			historificableDate=Calendar.getInstance();
			historificableDate.add(Calendar.DAY_OF_YEAR,(int)(daysTohistorify*(-1)));
			System.out.println("Setting SDMRow older than "+String.valueOf(historificableDate)+" to delete status");
			rowQuery=statelessSession.createQuery("update SDMSecurityRow set auditor.deleted=:deleted where auditor.creationDate<=:calculatedDate");
			rowQuery.setParameter("deleted", true);
			rowQuery.setParameter("calculatedDate",historificableDate.getTime());
			rowsMarkedForHistorification=rowQuery.executeUpdate();
			HibernateUtils.commitTransaction(statefullSession);
			System.out.println("Affected rows: "+rowsMarkedForHistorification);
			if(rowsMarkedForHistorification>0){
				HibernateUtils.beguinTransaction(statefullSession);
				System.out.println("Recovering SDMRow first id");
				rowQuery=statefullSession.createQuery("select id from SDMSecurityRow where auditor.deleted=:deleted order by id asc");
				rowQuery.setParameter("deleted",true);
				rowQuery.setFetchSize(1);
				rowQuery.setMaxResults(1);
				initialId=(Long)rowQuery.uniqueResult();
				System.out.println("First id: "+initialId);
				System.out.println("Recovering SDMRow last id");
				rowQuery=statefullSession.createQuery("select id from SDMSecurityRow where auditor.deleted=:deleted order by id desc");
				rowQuery.setParameter("deleted",true);
				rowQuery.setFetchSize(1);
				rowQuery.setMaxResults(1);
				lastId=(Long)rowQuery.uniqueResult();
				System.out.println("Last id: "+lastId);
				HibernateUtils.commitTransaction(statefullSession);
				System.out.println("maxId:"+initialId+getHistorificationCommitSize());
				System.out.println("initialId:"+initialId);
				System.out.println("lastId:"+lastId);
				for(long maxId=initialId+getHistorificationCommitSize();initialId<lastId;maxId+=getHistorificationCommitSize(),initialId+=getHistorificationCommitSize()){
					System.out.println("Historifing from "+initialId+" to "+maxId);
					HibernateUtils.beguinTransaction(statelessSession);
					rowsHistorified=0;
					valuesHistorified=0;
					historifiedValuesUpdated=0;
					rowsDeleted=0;
					valuesDeleted=0;
					historifiedRowsUpdated=0;
					try{
						System.out.println("	Saving SDMRowHistoric from SDMRow");
						// Prueba
						/*rowQuery=statefullSession.createQuery("" +
									"	select " +
									"	sdmRow.id," +
									"	sdmRow.record," +
									"	sdmRow.version," +
									"	sdmRow.value," +
									"	sdmRow.job," +
									"	sdmRow.auditor," +
									//"	sdmRow.sdmValues," +
									"	sdmRow.operationStatus, " +
									"	sdmRow.securityIsin," +
									"	sdmRow.securityTicker," +
									"	sdmRow.securityMic," +
									"	sdmRow.securityName " +
								"from SDMSecurityRow as sdmRow "+
								"where sdmRow.auditor.deleted=:deleted and sdmRow.id>=:initialId and sdmRow.id<:endId");
						rowQuery.setParameter("deleted",true);
						rowQuery.setParameter("initialId",initialId);
						rowQuery.setParameter("endId",maxId);
						List<SDMSecurityRow> listSdmRow = new ArrayList<SDMSecurityRow>();
						listSdmRow = rowQuery.list();
						System.out.println("listSdmRow.size():"+listSdmRow.size());
						if(listSdmRow.size()>0){
							Iterator<SDMSecurityRow> it = listSdmRow.iterator();
							while (it.hasNext()){
								SDMSecurityRow row = it.next();
								System.out.println("id:"+row.getId());
								System.out.println("record:"+row.getRecord());
								System.out.println("value:"+row.getValue());
								System.out.println("version:"+row.getVersion());
								if(row.getAuditor()!=null){
									System.out.println("auditor No es nulo");
								}else{
									System.out.println("auditor es nulo");
								}
								if(row.getJob()!=null){
									System.out.println("job No es nulo");
								}else{
									System.out.println("job es nulo");
								}
								if(row.getOperationStatus()!=null){
									System.out.println("OperationStatus No es nulo");
								}else{
									System.out.println("OperationStatus es nulo");
								}
								if(row.getSdmValues()!=null){
									System.out.println("SdmValues No es nulo");
								}else{
									System.out.println("SdmValues es nulo");
								}
							}
						}*/
						rowQuery=statelessSession.createQuery("" +
								"insert into SDMSecurityRowHistoric " +
									"(" +
									"   id," + 
									"   record," + 
									"   version," + 
									"	value," +
									"	job," + 
									"	auditor," + 
									//"	sdmValues," +
									"	operationStatus, "+
									"	securityIsin, "+
									"	securityTicker, "+
									"	securityMic, "+
									"	securityName) "+
								"select " +
									"	sdmRow.id," +
									"	sdmRow.record," +
									"	sdmRow.version," +
									"	sdmRow.value," +
									"	sdmRow.job," +
									"	sdmRow.auditor," +
									//"	sdmRow.sdmValues," +
									"	sdmRow.operationStatus, " +
									"	sdmRow.securityIsin, " +
									"	sdmRow.securityTicker, " +
									"	sdmRow.securityMic, " +
									"	sdmRow.securityName " +
									"from SDMSecurityRow as sdmRow " +
									"where sdmRow.auditor.deleted=:deleted and sdmRow.id>=:initialId and sdmRow.id<:endId");
						rowQuery.setParameter("deleted",true);
						rowQuery.setParameter("initialId",initialId);
						rowQuery.setParameter("endId",maxId);
						System.out.println("rowQuery.getQueryString():"+rowQuery.getQueryString());
						rowsHistorified=rowQuery.executeUpdate();
						if (rowsHistorified>0){
							System.out.println("	Recovering last SDMRowHistoric");
							rowQuery=statelessSession.createQuery("from SDMSecurityRowHistoric order by id desc");
							rowQuery.setFetchSize(1);
							rowQuery.setMaxResults(1);
							rowHistoric=(SDMRowHistoric)rowQuery.uniqueResult();
							System.out.println("	Last SDMRowHistoric is "+rowHistoric.getId());
							System.out.println("	Saving SDMValueHistoric from SDMValue");
							rowQuery=statelessSession.createQuery("" +
									"insert into SDMValueHistoric " +
										"(id, row, version, value, jobField, auditor) " +
									"select " +
										"field.id,(select rowHistoric from SDMSecurityRowHistoric rowHistoric where rowHistoric.id=:lastHistoricRowId),field.version,field.value,field.jobField,field.auditor "+
									"from SDMValue as field " +
									"where field.row.auditor.deleted=:deleted and field.row.id>=:initialId and field.row.id<:endId");
							rowQuery.setParameter("lastHistoricRowId",rowHistoric.getId());
							rowQuery.setParameter("deleted",true);
							rowQuery.setParameter("initialId",initialId);
							rowQuery.setParameter("endId",maxId);
							valuesHistorified=rowQuery.executeUpdate();
							/*System.out.println("	Updating historified SDMValue with correct message");
							rowQuery=statelessSession.createQuery("update SDMSecurityRowHistoric valueHistoric set valueHistoric.id=(select value.id from SDMValue value where value.id=valueHistoric.id) where valueHistoric.row=:lastHistoricRow");
							rowQuery.setParameter("lastHistoricRow",rowHistoric);
							historifiedValuesUpdated=rowQuery.executeUpdate();*/
							System.out.println("	Historified SDMValue updated");
							System.out.println("	Deleting historified SDMValue");
							rowQuery=statelessSession.createQuery("delete SDMValue as field where field.id in (select row.id from SDMSecurityRow as row where row.auditor.deleted=:deleted and row.id>=:initialId and row.id<:endId)");
							rowQuery.setParameter("deleted", true);
							rowQuery.setParameter("initialId",initialId);
							rowQuery.setParameter("endId",maxId);
							valuesDeleted=rowQuery.executeUpdate();
							System.out.println("	Deleting historified SDMRow");
							rowQuery=statelessSession.createQuery("delete SDMSecurityRow as row where row.auditor.deleted=:deleted and row.id>=:initialId and row.id<:endId");
							rowQuery.setParameter("deleted", true);
							rowQuery.setParameter("initialId",initialId);
							rowQuery.setParameter("endId",maxId);
							rowsDeleted=rowQuery.executeUpdate();
							System.out.println("	Updating historified SDMRow with setting delete to false");
							rowQuery=statelessSession.createQuery("update SDMSecurityRowHistoric row set row.auditor.deleted=:deletedFalse where row.auditor.deleted=:deletedTrue and row.id>=:initialId and row.id<:endId");
							rowQuery.setParameter("deletedFalse",false);
							rowQuery.setParameter("deletedTrue",true);
							rowQuery.setParameter("initialId",initialId);
							rowQuery.setParameter("endId",maxId);
							historifiedRowsUpdated=rowQuery.executeUpdate();
							System.out.println("	Historified SDMRow updated");
							HibernateUtils.commitTransaction(statelessSession);
							System.out.println("Historification from "+initialId+" to "+maxId+" ends correctly");
							proccessedCorrectly+=rowsHistorified;
						}else{
							System.out.println("Rows between "+initialId+" and "+maxId+" do not exists. No action to do");
						}
					}catch (Exception e) {
						System.out.println("Historification from "+initialId+" to "+maxId+" fail");
						e.printStackTrace();
						HibernateUtils.rollbackTransaction(statelessSession);
						//LogUtils.createLog(statefullSession, getUser(), manager.getBundleName(), new Locale(getLocale()), manager.getApplication(statefullSession), LogErrorDict.HISTORIFICATION_BLOCK_FAIL, new Object[]{initialId,maxId,rowsHistorified,valuesHistorified,historifiedValuesUpdated,valuesDeleted,rowsDeleted,historifiedRowsUpdated}, e);
						proccessedWrong+=rowsHistorified;
					}
				}
			}
			processingTime=System.currentTimeMillis()-processingTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(statefullSession!=null){
				//statefullSession.getTransaction().commit();
				statefullSession.close();
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		
		System.out.println("Final");
		
		
	}

}
