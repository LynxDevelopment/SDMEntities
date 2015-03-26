package com.lynxspa.sdm.processors.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import au.com.bytecode.opencsv.CSVReader;

import com.lynxspa.entities.plannings.SPPlanningProcess;
import com.lynxspa.entities.plannings.SPSecuritiesPlannings;
import com.lynxspa.entities.securities.SPSecurity;
import com.lynxspa.entities.securities.SPSecurityPortfolio;
import com.lynxspa.entities.securities.SPVirtualSecurity;
import com.lynxspa.entities.securities.customers.SPCustomer;
import com.lynxspa.entities.securities.financialassets.SPSecurityFinancialAssets;
import com.lynxspa.entities.securities.markets.SPMarket;
import com.lynxspa.exception.FPMException;
import com.lynxspa.hbt.utils.HibernateUtils;
import com.lynxspa.sdm.dictionaries.flows.states.CAStatesEVENTMESSAGEFlow;
import com.lynxspa.sdm.dictionaries.logs.LogErrorDict;
import com.lynxspa.sdm.managers.SDMConfigManager;
import com.lynxspa.utils.StringUtils;

public class BanifCustomerUploadProcessor implements CustomerUploadDataProcessorAdapter{
	
	private final char SEPARATOR_CSV = '|';
	private final int NUMBER_OF_FIELDS_BY_LINE = 9;
	
	private final String EQUITY_ASSET_CODE = "EQUITY";
	private final String FIXED_ASSET_CODE = "BOND";
	private final String FUNDS_ASSET_CODE = "FUNDS";
	private final String COUPON_ASSET_CODE = "COUPON";
	
	private final String INSERT_OPERATION = "INSERT";
	private final String UPDATE_OPERATION = "UPDATE";
	
	
	
	@Override
	@SuppressWarnings({"unused","unchecked"})
	public void processFile(Session session, SDMConfigManager manager,BufferedReader reader, StatelessSession statelessSession,String user) throws FPMException {
		
		CSVReader csvReader=null;
		String[] nextLine=null;
		int rowNumber=0;
		
		//CSV fields
		String isin = null;
		String micCode = null;
		String customerCode = null;
		String finantialAssetCode = null;
		String portfolioCode= null; // TODO & FIXME: Add this field in next step. We must modify SPSecutityDetails to add more columns...
		String origin=null;			// TODO & FIXME: Add this field in next step. We must modify SPSecutityDetails to add more columns...
		String dateAsString=null;	// TODO & FIXME: Add this field in next step. We must modify SPSecutityDetails to add more columns...
		String contributor=null;	// TODO & FIXME: Add this field in next step. We must modify SPSecutityDetails to add more columns...
		String securityName=null;
		
		Query query = null;
		SPSecurity security = null;
		SPMarket market = null;
		SPVirtualSecurity virtualSecurity = null;
				
		try{		
			//Get assetType conversion BANIF - SDM
			Map<String,String> assetTypeMap = getAssetTypeConversionMap();
			
			//Builder for accumulate error messages
			StringBuilder errMsg=new StringBuilder();
			//Parse data
			csvReader=new CSVReader(reader,SEPARATOR_CSV);
			while((nextLine=csvReader.readNext())!=null){
				rowNumber++;
				if(nextLine.length!=NUMBER_OF_FIELDS_BY_LINE){
					// Current row has different number of rows than what is defined in interface file
					errMsg.append("\n\t- Row "+(rowNumber)+" has "+(Math.abs(nextLine.length-NUMBER_OF_FIELDS_BY_LINE))+" columns "+(nextLine.length>NUMBER_OF_FIELDS_BY_LINE ? "more" : "less")+" than expected ("+NUMBER_OF_FIELDS_BY_LINE+").");	
					continue;
				}
				
				//Get data values
				isin = nextLine[0];
				if(!StringUtils.isEmpty(isin) && isin.length()!=12){
					errMsg.append("\n\t- Row "+(rowNumber)+ " has field ISIN with incorrect format. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				if(StringUtils.isEmpty(isin)){
					errMsg.append("\n\t- Row "+(rowNumber)+ " has field ISIN with incorrect format. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				micCode = nextLine[1];
				if(StringUtils.isEmpty(micCode)){
					errMsg.append("\n\t- Row "+(rowNumber)+ " has field Market with incorrect format. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				//customerCode = nextLine[2];
				customerCode = nextLine[5];
				
				finantialAssetCode = assetTypeMap.get(nextLine[3]);				
				if(StringUtils.isEmpty(finantialAssetCode)){
					errMsg.append("\n\t- Row "+(rowNumber)+ " has field AssetType with incorrect or unknow format. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				//portfolioCode= nextLine[4];
				//origin= nextLine[5];
				portfolioCode= nextLine[5];		// Current PORTFOLIO Field ( swapped with Origin )
				dateAsString= nextLine[6];
				contributor= nextLine[7];
				securityName= nextLine[8];
				
				//Get Security by ISIN + MIC
				query=statelessSession.createQuery("select security from SPSecurity security where isin=:isin and market.mic=:micCode");
				query.setParameter("isin",isin);
				query.setParameter("micCode",micCode);
				query.setMaxResults(1);
				security = (SPSecurity)query.uniqueResult();
				
				//Get Market by MIC
				query=statelessSession.createQuery("select market from SPMarket market where mic=:micCode");
				query.setParameter("micCode",micCode);
				query.setMaxResults(1);
				market = (SPMarket)query.uniqueResult();
				
				if(market==null){
					errMsg.append("\n\t- Row "+(rowNumber)+ " has field Market with unknow MIC CODE. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				
				if(security==null){
					//Insert new Security Operation
					//
					//NOTE:First search for previous "posible" virtualSecurity.
					//This is for the case of input corporate operations that these associated Isin codes are not upload yet.
					query=statelessSession.createQuery("select virtualSecurity from SPVirtualSecurity virtualSecurity where virtualSecurity.auditor.deleted=:deleted and virtualSecurity.isin=:isin and virtualSecurity.class='virtual'");
					query.setParameter("deleted",false);
					query.setParameter("isin",isin);
					List<SPVirtualSecurity> listVirtual = query.list();
					if(listVirtual.size()>0){
						//Get first occurrence
						virtualSecurity = (SPVirtualSecurity) listVirtual.get(0);	
					}
					
					security = new SPSecurity(user);
					security.setCustomerId(customerCode);
					security.setInCustomerPortfolio(true);
					security.setIsin(isin);
					security.setMarket(market);
					security.setName(securityName);
					security.setPlanification(null);
					security.setSecurityDetail(null);
					security.setSecFinancialAssets(getFinancialAssetByCode(finantialAssetCode,statelessSession));
					security.getAuditor().setDeleted(false);
					HibernateUtils.customSave(statelessSession, security, user);
					associatePlanification(finantialAssetCode, security, statelessSession, user, INSERT_OPERATION);
					
					if (virtualSecurity!=null){
						//Update associated messages
						query=statelessSession.createQuery("update CAEventMessage set normalizedSecurity.id=:securityId,operationStatus.state.id.code=:newState where normalizedSecurity.id=:virtualSecurityId");
						query.setLong("securityId", security.getId());
						query.setString("newState", CAStatesEVENTMESSAGEFlow.PRSD.getId());
						query.setLong("virtualSecurityId", virtualSecurity.getId());
						query.executeUpdate();
						//Update security portfolio
						query=statelessSession.createQuery("update SPSecurityPortfolio set security.id=:securityId where security.id=:virtualSecurityId");
						query.setLong("securityId", security.getId());
						query.setLong("virtualSecurityId", virtualSecurity.getId());
						query.executeUpdate();
						//Delete virtual security
						HibernateUtils.customDelete(statelessSession, virtualSecurity, user);							
					}					
				}else{
					//Update Security Operation
					security.setCustomerId(customerCode);
					security.setInCustomerPortfolio(true);
					security.setIsin(isin);
					security.setMarket(market);
					security.setName(securityName);
					security.setPlanification(null);
					security.setSecurityDetail(null);
					security.setSecFinancialAssets(getFinancialAssetByCode(finantialAssetCode,statelessSession));
					security.getAuditor().setDeleted(false);
					HibernateUtils.customUpdate(statelessSession, security,  user);
					associatePlanification(finantialAssetCode, security, statelessSession, user, UPDATE_OPERATION);
				}
					
				// CHECK CUSTOMER
				// If doesn't exist, create it
				SPCustomer customer = null;
				
				if(customerCode != null && customerCode != ""){
					// Look up Customer
					
					//customer = (SPCustomer)statelessSession.get(SPCustomer.class,customerCode);					
					query = (Query)statelessSession.createQuery("from SPCustomer where customerId=:code");
					query.setParameter("code", customerCode);
					customer = (SPCustomer)query.uniqueResult();
					
					// Create new Customer
					if(customer == null){
						customer = new SPCustomer(user,customerCode,customerCode);
						HibernateUtils.customSave(statelessSession, customer, user);
					}
				}
					
				// CREATE or UPDATE PORTFOLIO	
				// Portfolio = [ISIN + CustomerID]
				if (customer != null){
					DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
					Date date = null;
					try {
						date = dateFormat.parse(dateAsString);
					} catch(java.text.ParseException pex){
						errMsg.append("Date Parse Error on line "+(rowNumber)+". Date "+dateAsString+" is not parseable");
					}		
					// Check if already exists
					query = (Query)statelessSession.createQuery("from SPSecurityPortfolio where customer=:customer and security=:security");
					query.setParameter("customer", customer);
					query.setParameter("security", security);
					SPSecurityPortfolio portfolio = (SPSecurityPortfolio)query.uniqueResult();
					
					if(portfolio == null){	// INSERT
						portfolio = new SPSecurityPortfolio(user,customer,security,date);
						HibernateUtils.customSave(statelessSession, portfolio, user);
					}
					/*
					} else {				// UPDATE
						portfolio.setEmissionDate(date);
						HibernateUtils.customUpdate(statelessSession, portfolio, user);
					}
					*/
				} else {
					errMsg.append("\n\t- Row"+ (rowNumber)+ " no CustomerCode found. Couldn't update or insert new Portfolio. Data:"+nextLine[0]+SEPARATOR_CSV+nextLine[1]+SEPARATOR_CSV+nextLine[2]+SEPARATOR_CSV+nextLine[3]+SEPARATOR_CSV+nextLine[4]+SEPARATOR_CSV+nextLine[5]+SEPARATOR_CSV+nextLine[6]+SEPARATOR_CSV+nextLine[7]+SEPARATOR_CSV+nextLine[8]+SEPARATOR_CSV);
					continue;
				}
				
			} // END FILE LINE PROCESS
			
			//Commit this transaction
			HibernateUtils.commitTransaction(statelessSession);
			
			//If any line has errors then launch Exception
			if(errMsg.length()>0){
				throw new FPMException(LogErrorDict.CUSTOMERUPLOADDATA_FILE_FORMAT_ERROR, new Object[]{errMsg.toString()});
			}
			
		}catch(FPMException fpmException){
			throw fpmException;
		}catch(Exception e){
			//Rollback this transaction
			HibernateUtils.rollbackTransaction(statelessSession);
			throw new FPMException(e);
		}finally{
			if(csvReader != null){
				try{
					csvReader.close();
				}catch(IOException ioe){
					throw new FPMException(ioe);
				}
			}
		}
	}
	
	/**
	 * Function to get SPSecurityFinancialAssets from assetCode conversion.
	 */
	private SPSecurityFinancialAssets getFinancialAssetByCode(String assetCode, StatelessSession statelessSession) throws Exception{
		String idAsset = null;
		if(EQUITY_ASSET_CODE.equals(assetCode)){
			idAsset="EQ";
		}else if(FIXED_ASSET_CODE.equals(assetCode)){
			idAsset="DB";
		}else if(FUNDS_ASSET_CODE.equals(assetCode)){
			idAsset="FUND";
		}else if(COUPON_ASSET_CODE.equals(assetCode)){
			idAsset="DB";
		}else{
			throw new Exception("Error asset code not valid:"+assetCode+".Actually only supports these assets codes: EQUITY,BOND,FUNDS,COUPON");
		}
		Query query=statelessSession.createQuery("from SPSecurityFinancialAssets where id=:idAsset");
		query.setParameter("idAsset",idAsset);
		query.setMaxResults(1);
		return (SPSecurityFinancialAssets)query.uniqueResult();
	}
	/**
	 * Function to associate security & coac planifications.
	 */
	private void associatePlanification(String assetCode, SPSecurity security, StatelessSession statelessSession, String user, String insertOrUpdate) throws Exception {
		
		Query query = null;
		String idSecurityPlanning = null;
		String idSDMPlanning = null;
		
		if(EQUITY_ASSET_CODE.equals(assetCode)){
			idSecurityPlanning="PLAN_REQ_SECURITY_RV";
			idSDMPlanning="PLAN_REQ_SDM_RV";
		}else if(FIXED_ASSET_CODE.equals(assetCode)){
			idSecurityPlanning="PLAN_REQ_SECURITY_RF";
			idSDMPlanning="PLAN_REQ_SDM_RF";
		}else if(FUNDS_ASSET_CODE.equals(assetCode)){
			idSecurityPlanning="PLAN_REQ_SECURITY_FD";
			idSDMPlanning="PLAN_REQ_SDM_FD";
		}else if(COUPON_ASSET_CODE.equals(assetCode)){
			idSecurityPlanning="PLAN_REQ_SECURITY_RF";
			idSDMPlanning="PLAN_REQ_SDM_CO";
		}else{
			throw new Exception("Error asset code not valid:"+assetCode+".Actually only supports these assets codes: EQUITY,BOND,FUNDS,COUPON");
		}
		
		if(INSERT_OPERATION.equals(insertOrUpdate)){
			SPSecuritiesPlannings securityPlanning = new SPSecuritiesPlannings();
			securityPlanning.setSecurity(security);
			query = statelessSession.createQuery("from SPPlanningProcess where name=:name");
			query.setString("name", idSecurityPlanning);
			securityPlanning.setPlanning((SPPlanningProcess)query.uniqueResult());
			HibernateUtils.customSave(statelessSession, securityPlanning, user);
			
			SPSecuritiesPlannings sdmPlanning = new SPSecuritiesPlannings();
			sdmPlanning.setSecurity(security);
			query = statelessSession.createQuery("from SPPlanningProcess where name=:name");
			query.setString("name", idSDMPlanning);
			sdmPlanning.setPlanning((SPPlanningProcess)query.uniqueResult());
			HibernateUtils.customSave(statelessSession, sdmPlanning, user);
		}else if(UPDATE_OPERATION.equals(insertOrUpdate)){
			//This case is exceptional...is asset type change (very very very strange) then we remove old planifications associated.
			query = statelessSession.createQuery("delete SPSecuritiesPlannings where security.id=:securityId");
			query.setLong("securityId", security.getId());
			query.executeUpdate();
			
			SPSecuritiesPlannings securityPlanning = new SPSecuritiesPlannings();
			securityPlanning.setSecurity(security);
			query = statelessSession.createQuery("from SPPlanningProcess where name=:name");
			query.setString("name", idSecurityPlanning);
			securityPlanning.setPlanning((SPPlanningProcess)query.uniqueResult());
			HibernateUtils.customSave(statelessSession, securityPlanning, user);
			
			SPSecuritiesPlannings sdmPlanning = new SPSecuritiesPlannings();
			sdmPlanning.setSecurity(security);
			query = statelessSession.createQuery("from SPPlanningProcess where name=:name");
			query.setString("name", idSDMPlanning);
			sdmPlanning.setPlanning((SPPlanningProcess)query.uniqueResult());
			HibernateUtils.customSave(statelessSession, sdmPlanning, user);
		}
		
	}
	/**
	 * Function to maping BANIF products to SDM AssetTypes codes
	 * @return
	 */
	private Map<String,String> getAssetTypeConversionMap() throws Exception{
		Map<String,String> reply = new HashMap<String, String>();
		reply.put("ACÇÕES N/ RESIDENTES ORDINÁRIAS", EQUITY_ASSET_CODE);
		reply.put("ACÇÕES RESIDENTES ORDINÁRIAS",EQUITY_ASSET_CODE);
		reply.put("ACÇÕES PRIVILIGIADAS/PREFERENCIAIS", EQUITY_ASSET_CODE);
		reply.put("ACÇÕES PRÓPRIAS", EQUITY_ASSET_CODE);
		reply.put("OUTRAS ACÇÕES", EQUITY_ASSET_CODE);
		reply.put("OBRIGAÇÕES CAIXA NACIONAIS", FIXED_ASSET_CODE);
		reply.put("OBRIGAÇÕES CUPÃO ZERO", FIXED_ASSET_CODE);
		reply.put("OBRIGAÇÕES DIV PÚB EST (TX FIXA)", FIXED_ASSET_CODE);
		reply.put("OBRIGAÇÕES DIV PÚB EST (TX VAR)", FIXED_ASSET_CODE);
		reply.put("OBRIGAÇÕES DIV PÚB RES (TX FIXA)", FIXED_ASSET_CODE);
		reply.put("OBRIGAÇÕES SUBORDINADAS", FIXED_ASSET_CODE);
		reply.put("OUT.OBRIGAÇÕES N/ RES", FIXED_ASSET_CODE);
		reply.put("OUT.OBRIGAÇÕES OUT EM PÚB (TX FIXA)", FIXED_ASSET_CODE);
		reply.put("OUTRAS OBRIGAÇÕES RESIDENTES", FIXED_ASSET_CODE);
		reply.put("ETF - Exchange-traded Funds", FUNDS_ASSET_CODE);
		reply.put("PARTICIPAÇÕES FIN RESIDENTES", FUNDS_ASSET_CODE);
		reply.put("TÍTULOS PARTICIPAÇÃO RESIDENTES", FUNDS_ASSET_CODE);
		reply.put("UNIDADES PARTICIPAÇÃO RESIDENTES", FUNDS_ASSET_CODE);
		reply.put("UNIDADES PARTICIPAÇÃO N/ RESIDENTES", FUNDS_ASSET_CODE);		
		return reply;
	}
	
}
