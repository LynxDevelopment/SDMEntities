package com.lynxspa.sdm.dictionaries.formats.bloomberg.messages;

import com.lynxspa.sdm.installer.adapters.formats.fields.AssetMessageTypeFieldsDictAdapter;

public enum AssetMessageTypeField implements AssetMessageTypeFieldsDictAdapter {
	
	// Fields: path, name, length, displayGroup, displayRow, displayCol, description, hidden
	FIELD1("BDY","TICKER",0,"general",0,0,"Ticker",false),
	FIELD2("BDY","EXCH_CODE",0,"general",0,0,"Exchange Code",false),
	FIELD3("BDY","NAME",0,"general",0,0,"Name",false),
	FIELD4("BDY","COUNTRY",0,"general",0,0,"Country",false),
	FIELD5("BDY","CRNCY",0,"general",0,0,"Currency",false),
	FIELD6("BDY","SECURITY_TYP",0,"general",0,0,"Security Type",false),
	FIELD7("BDY","PAR_AMT",0,"general",0,0,"Par Amount",false),
	FIELD8("BDY","EQY_PRIM_EXCH",0,"general",0,0,"Primary Exchange Name",false),
	FIELD9("BDY","EQY_PRIM_EXCH_SHRT",0,"general",0,0,"Primary Exchange Code",false),
	FIELD10("BDY","EQY_SIC_CODE",0,"general",0,0,"SIC Code",false),
	FIELD11("BDY","EQY_SIC_NAME",0,"general",0,0,"SIC Name",false),
	FIELD12("BDY","INDUSTRY_GROUP",0,"general",0,0,"Industry Group",false),
	FIELD13("BDY","INDUSTRY_SUBGROUP",0,"general",0,0,"Industry Subgroup",false),
	FIELD14("BDY","INDUSTRY_SECTOR",0,"general",0,0,"Industry Sector",false),
	FIELD15("BDY","ID_SEDOL1",0,"general",0,0,"Sedol1 Number",false),
	FIELD16("BDY","ID_WERTPAPIER",0,"general",0,0,"Wertpapier Number",false),
	FIELD17("BDY","ID_ISIN",0,"general",0,0,"ISIN Number",false),
	FIELD18("BDY","ID_DUTCH",0,"general",0,0,"Dutch Number",false),
	FIELD19("BDY","ID_VALOREN",0,"general",0,0,"Valoren Number",false),
	FIELD20("BDY","ID_FRENCH",0,"general",0,0,"French Number",false),
	FIELD21("BDY","ID_BELGIUM",0,"general",0,0,"Belgium Number",false),
	FIELD22("BDY","ID_BB_COMPANY",0,"general",0,0,"Company ID",false),
	FIELD23("BDY","ID_BB_SECURITY",0,"general",0,0,"Security ID",false),
	FIELD24("BDY","ID_CUSIP",0,"general",0,0,"Cusip Number",false),
	FIELD25("BDY","ID_COMMON",0,"general",0,0,"Common Number",false),
	FIELD26("BDY","ADR_UNDL_TICKER",0,"general",0,0,"Underlying Ticker",false),
	FIELD27("BDY","ADR_SH_PER_ADR",0,"general",0,0,"Shares per ADR",false),
	FIELD28("BDY","DVD_CRNCY",0,"general",0,0,"Dividend Currency",false),
	FIELD29("BDY","EQY_DVD_SH_12M_NET",0,"general",0,0,"Dividend Per Share 12 Month (Net)",false),
	FIELD30("BDY","DVD_SH_LAST",0,"general",0,0,"Dividend Per Share Last Net",false),
	FIELD31("BDY","LAST_DPS_GROSS",0,"general",0,0,"Dividend Per Share Last (Gross)",false),
	FIELD32("BDY","EQY_DVD_PCT_FRANKED",0,"general",0,0,"Percent Franked (Australia)",false),
	FIELD33("BDY","DVD_TYP_LAST",0,"general",0,0,"Dividend Type",false),
	FIELD34("BDY","DVD_FREQ",0,"general",0,0,"Dividend Frequency",false),
	FIELD35("BDY","DVD_PAY_DT",0,"general",0,0,"Dividend Pay Date",false),
	FIELD36("BDY","DVD_RECORD_DT",0,"general",0,0,"Dividend Record Date",false),
	FIELD37("BDY","DVD_DECLARED_DT",0,"general",0,0,"Dividend Declared Date",false),
	FIELD38("BDY","EQY_SPLIT_DT",0,"general",0,0,"Split Date",false),
	FIELD39("BDY","EQY_SPLIT_RATIO",0,"general",0,0,"Split Ratio",false),
	FIELD40("BDY","DVD_EX_DT",0,"general",0,0,"Dividend Ex Date",false),
	FIELD41("BDY","EQY_DVD_EX_FLAG",0,"general",0,0,"Ex-Dividend Flag",false),
	FIELD42("BDY","INDUSTRY_SUBGROUP_NUM",0,"general",0,0,"Industry Subgroup Number",false),
	FIELD43("BDY","CNTRY_ISSUE_ISO",0,"general",0,0,"ISO Country of Issue",false),
	FIELD44("BDY","MARKET_STATUS",0,"general",0,0,"Market Status",false),
	FIELD45("BDY","ID_BB_PARENT_CO",0,"general",0,0,"Parent Company ID",false),
	FIELD46("BDY","ADR_UNDL_CMPID",0,"general",0,0,"Underlying Company ID",false),
	FIELD47("BDY","ADR_UNDL_SECID",0,"general",0,0,"Underlying Security ID",false),
	FIELD48("BDY","REL_INDEX",0,"general",0,0,"Relative Index",false),
	FIELD49("BDY","PX_TRADE_LOT_SIZE",0,"general",0,0,"Trade Lot Size",false),
	FIELD50("BDY","PARENT_COMP_TICKER",0,"general",0,0,"Parent Company Ticker",false),
	FIELD51("BDY","PARENT_COMP_NAME",0,"general",0,0,"Parent Company Name",false),
	FIELD52("BDY","ID_LOCAL",0,"general",0,0,"Local ID",false),
	FIELD53("BDY","LONG_COMP_NAME",0,"general",0,0,"Long Company Name",false),
	FIELD54("BDY","PARENT_INDUSTRY_GROUP",0,"general",0,0,"Parent Industry Group",false),
	FIELD55("BDY","PARENT_INDUSTRY_SUBGROUP",0,"general",0,0,"Parent Industry Subgroup",false),
	FIELD56("BDY","PARENT_INDUSTRY_SECTOR",0,"general",0,0,"Parent Industry Sector",false),
	FIELD57("BDY","VOTING_RIGHTS",0,"general",0,0,"Voting Rights Per Share",false),
	FIELD58("BDY","ID_BB_PRIM_SECURITY_FLAG",0,"general",0,0,"Equity Primary Security Flag",false),
	FIELD59("BDY","PRE_EURO_ID_ISIN",0,"general",0,0,"Pre-Euro Redenom. ISIN Number",false),
	FIELD60("BDY","PRE_REDENOM_CRNCY",0,"general",0,0,"Pre-Redenomination Currency",false),
	FIELD61("BDY","PRE_EURO_PAR_AMT",0,"general",0,0,"Pre-Euro Redenom. Par Amount",false),
	FIELD62("BDY","POST_REDENOM_CRNCY",0,"general",0,0,"Post-Redenomination Currency",false),
	FIELD63("BDY","POST_EURO_PAR_AMT",0,"general",0,0,"Post-Euro Redenom. Par Amount",false),
	FIELD64("BDY","POST_EURO_ID_ISIN",0,"general",0,0,"Post-Euro Redenom. ISIN Number",false),
	FIELD65("BDY","REDENOM_DT",0,"general",0,0,"Redenomination Date",false),
	FIELD66("BDY","REDENOM_METHOD",0,"general",0,0,"Redenomination Method",false),
	FIELD67("BDY","REDENOM_ROUND_METHOD",0,"general",0,0,"Redenomination Rounding Method",false),
	FIELD68("BDY","PAR_VAL_CRNCY",0,"general",0,0,"Par Value Currency",false),
	FIELD69("BDY","EQY_SH_OUT",0,"general",0,0,"Current Shares Outstanding",false),
	FIELD70("BDY","EQY_SH_OUT_DT",0,"general",0,0,"Current Shares Outstanding Date",false),
	FIELD71("BDY","ID_BB_UNIQUE",0,"general",0,0,"Unique Bloomberg Identifier",false),
	FIELD72("BDY","MARKET_SECTOR_DES",0,"general",0,0,"Market Sector Description",false),
	FIELD73("BDY","IS_STK_MARGINABLE",0,"general",0,0,"Stock Marginable Indicator",false),
	FIELD74("BDY","144A_FLAG",0,"general",0,0,"144A Eligible Indicator",false),
	FIELD75("BDY","TRANSFER_AGENT",0,"general",0,0,"Transfer Agent",false),
	FIELD76("BDY","EQY_PRIM_SECURITY_TICKER",0,"general",0,0,"Primary Security Ticker",false),
	FIELD77("BDY","EQY_PRIM_SECURITY_COMP_EXCH",0,"general",0,0,"Primary Security Composite Exchange Code",false),
	FIELD78("BDY","IS_SETS",0,"general",0,0,"Security on SETS Indicator",false),
	FIELD79("BDY","WHICH_JAPANESE_SECTION",0,"general",0,0,"Trading Section for Japanese Stock",false),
	FIELD80("BDY","ADR_ADR_PER_SH",0,"general",0,0,"ADR per Share",false),
	FIELD81("BDY","EQY_PRIM_SECURITY_PRIM_EXCH",0,"general",0,0,"Primary Security Primary Exchange Code",false),
	FIELD82("BDY","EQY_FUND_CRNCY",0,"general",0,0,"Equity Fundamental Currency",false),
	FIELD83("BDY","WHEN_ISSUED",0,"general",0,0,"When Issued",false),
	FIELD84("BDY","CDR_COUNTRY_CODE",0,"general",0,0,"CDR Country Code",false),
	FIELD85("BDY","CDR_EXCH_CODE",0,"general",0,0,"CDR Exchange Code",false),
	FIELD86("BDY","CNTRY_OF_INCORPORATION",0,"general",0,0,"Country of Incorporation",false),
	FIELD87("BDY","CNTRY_OF_DOMICILE",0,"general",0,0,"Country of Domicile",false),
	FIELD88("BDY","SEC_RESTRICT",0,"general",0,0,"SEC Restrict",false),
	FIELD89("BDY","EQY_SH_OUT_REAL",0,"general",0,0,"Current Shares Outstanding Real Value",false),
	FIELD90("BDY","ADR_UNDL_CRNCY",0,"general",0,0,"Currency of Underlying",false),
	FIELD91("BDY","MULTIPLE_SHARE",0,"general",0,0,"Company Has Multiple Shares Indicator",false),
	FIELD92("BDY","PX_QUOTE_LOT_SIZE",0,"general",0,0,"Quote Lot Size",false),
	FIELD93("BDY","PX_ROUND_LOT_SIZE",0,"general",0,0,"Round Lot Size",false),
	FIELD94("BDY","ID_SEDOL2",0,"general",0,0,"Sedol2 Number",false),
	FIELD95("BDY","SEDOL1_COUNTRY_ISO",0,"general",0,0,"SEDOL1 ISO Country",false),
	FIELD96("BDY","SEDOL2_COUNTRY_ISO",0,"general",0,0,"SEDOL2 ISO Country",false),
	FIELD97("BDY","ID_MIC_PRIM_EXCH",0,"general",0,0,"Primary Exchange MIC",false),
	FIELD98("BDY","ID_MIC_LOCAL_EXCH",0,"general",0,0,"Local Exchange MIC",false),
	FIELD99("BDY","LSE_SECTOR",0,"general",0,0,"LSE Sector",false),
	FIELD100("BDY","LSE_SEGMENT",0,"general",0,0,"LSE Segment",false),
	FIELD101("BDY","EQY_SH_OUT_TOT_MULT_SH",0,"general",0,0,"Current Shares Outstanding for All Classes",false),
	FIELD102("BDY","SECURITY_TYP2",0,"general",0,0,"Security Type 2",false),
	FIELD103("BDY","ID_BB_PRIM_SECURITY",0,"general",0,0,"Equity Primary Security ID",false),
	FIELD104("BDY","EQY_OPT_AVAIL",0,"general",0,0,"Options Available",false),
	FIELD105("BDY","EQY_FREE_FLOAT_PCT",0,"general",0,0,"Free Float Percent",false),
	FIELD106("BDY","TICKER_AND_EXCH_CODE",0,"general",0,0,"Ticker and Exchange Code",false),
	FIELD107("BDY","EQY_INIT_PO_DT",0,"general",0,0,"Initial Pub Offer Date",false),
	FIELD108("BDY","EQY_PO_DT",0,"general",0,0,"Last Pub Offer Date",false),
	FIELD109("BDY","EQY_INIT_PO_SH_PX",0,"general",0,0,"Initial Pub Offer Share Price",false),
	FIELD110("BDY","EQY_SPLIT_ADJ_INIT_PO_PX",0,"general",0,0,"Split Adj Init Pub Offer Price",false),
	FIELD111("BDY","EQY_FUND_TICKER",0,"general",0,0,"Fundamental Ticker",false),
	FIELD112("BDY","DTC_ELIGIBLE",0,"general",0,0,"DTC Eligible",false),
	FIELD113("BDY","TOTAL_VOTING_SHARES_VALUE",0,"general",0,0,"Total Voting Shares Value",false),
	FIELD114("BDY","ID_EXCH_SYMBOL",0,"general",0,0,"Local Exchange Symbol",false),
	FIELD115("BDY","ID_BB_CONNECT",30,"general",0,0,"ID BB Connect",false),
	FIELD116("BDY","ID_NAICS_CODE",0,"general",0,0,"NAICS Code",false),
	FIELD117("BDY","TOTAL_NON_VOTING_SHARES_VALUE",0,"general",0,0,"Total Non-Voting Shares Value",false),
	FIELD118("BDY","CDR_SETTLE_CODE",0,"general",0,0,"CDR Settle Code",false),
	FIELD119("BDY","CFI_CODE",0,"general",0,0,"CFI Code",false),
	FIELD120("BDY","EQY_DVD_SH_12M",0,"general",0,0,"Dividend Per Share 12 Month (Gross)",false),
	FIELD121("BDY","HIGH_52WEEK",0,"general",0,0,"52 Week High",false),
	FIELD122("BDY","LOW_52WEEK",0,"general",0,0,"52 Week Low",false),
	FIELD123("BDY","HIGH_DT_52WEEK",0,"general",0,0,"52 Week High Date",false),
	FIELD124("BDY","LOW_DT_52WEEK",0,"general",0,0,"52 Week Low Date",false),
	FIELD125("BDY","PX_BID",0,"general",0,0,"Bid Price",false),
	FIELD126("BDY","PX_MID",0,"general",0,0,"Mid Price",false),
	FIELD127("BDY","PX_ASK",0,"general",0,0,"Ask Price",false),
	FIELD128("BDY","PX_OPEN",0,"general",0,0,"Open Price",false),
	FIELD129("BDY","PX_HIGH",0,"general",0,0,"High Price",false),
	FIELD130("BDY","PX_LOW",0,"general",0,0,"Low Price",false),
	FIELD131("BDY","PX_LAST",0,"general",0,0,"Last Price",false),
	FIELD132("BDY","PX_FIXING",0,"general",0,0,"Fixing Price",false),
	FIELD133("BDY","PX_VOLUME",0,"general",0,0,"Volume",false),
	FIELD134("BDY","PRICING_SOURCE",0,"general",0,0,"Pricing Source",false),
	FIELD135("BDY","LAST_UPDATE",0,"general",0,0,"Time/Date of Last Update",false),
	FIELD136("BDY","EQY_BETA",0,"general",0,0,"Beta",false),
	FIELD137("BDY","CUR_MKT_CAP",0,"general",0,0,"#N/A",false),
	FIELD138("BDY","LAST_UPDATE_DT_EXCH_TZ",0,"general",0,0,"Last Update Date Exchange Timezone",false),
	FIELD139("BDY","EQY_FLOAT",0,"general",0,0,"Equity Float",false),
	FIELD140("BDY","EQY_DVD_YLD_IND",0,"general",0,0,"Dividend Indicated Yld - Gross",false),
	FIELD141("BDY","EQY_DVD_YLD_12M",0,"general",0,0,"Dividend 12 Month Yld - Gross",false),
	FIELD142("BDY","EQY_DVD_YLD_12M_NET",0,"general",0,0,"Dividend 12 Month Yld - Net",false),
	FIELD143("BDY","COMPOSITE_EXCH_CODE",0,"general",0,0,"Composite Exchange Code",false),
	FIELD144("BDY","PX_NASDAQ_CLOSE",0,"general",0,0,"NASDAQ Official Closing Price",false),
	FIELD145("BDY","MKT_CAP_LISTED",0,"general",0,0,"#N/A",false);
	
	private String path=null; 
	private String fieldName=null; 
	private int fieldLength=0; 
	private String displayGroup=null; 
	private int displayRow=0; 
	private int displayColumn=0; 
	private String description=null;
	private boolean hidden=false;
	private String provider="Bloomberg";
	private String type=null;
	
	// Constructor WITHOUT provider and type
	AssetMessageTypeField(String _path,
			String _fieldName,int _fieldLength,String _displayGroup,
			int _displayRow,int _displayColumn,String _description,
			boolean _hidden){
		this(_path,_fieldName,_fieldLength,_displayGroup,_displayRow,_displayColumn,_description,_hidden,"bloomberg",null);
	}
	
	// Constructor with provider and type
	AssetMessageTypeField(String _path,
			String _fieldName, int _fieldLength, String _displayGroup,
			int _displayRow, int _displayColumn, String _description,
			boolean _hidden, String _provider, String _type) {
		this.path=_path;
		this.fieldName=_fieldName;
		this.fieldLength=_fieldLength;
		this.displayGroup=_displayGroup;
		this.displayRow=_displayRow;
		this.displayColumn=_displayColumn;
		this.description=_description;
		this.hidden=_hidden;
		this.provider=_provider;
		this.type=_type;
	}
	
	public String getPath() {
		return path;
	}
	public String getFieldName() {
		return fieldName;
	}
	public int getFieldLength() {
		return fieldLength;
	}
	public String getDisplayGroup() {
		return displayGroup;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public int getDisplayColumn() {
		return displayColumn;
	}
	public String getDescription() {
		return description;
	}
	public boolean getHidden() {
		return hidden;
	}
	public String getProvider() {
		return provider;
	}
	public String getType() {
		return type;
	}
}
