package com.lynxspa.sdm.dictionaries.securities.securityfinancialassets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;

public enum FUNDSecurityFinancialAssetsDetails implements SecurityDetailAdapter{

	SECURITYFUNDDETAIL1("LONGSTRING:1","sec_des",ClassType.LONGSTRING,"",32,"general",1,10,0,0,0,0,"",false,true,true,true,0),
	SECURITYFUNDDETAIL2("LONGSTRING:2","id_bb_unique",ClassType.LONGSTRING,"",32,"general",1,11,0,0,0,0,"Unique Bloomberg Identifier",false,true,true,true,0),
	SECURITYFUNDDETAIL3("SHORTSTRING:1","id_bb_company",ClassType.SHORTSTRING,"",8,"general",1,2,0,0,0,0,"Company ID",false,false,true,true,0),
	SECURITYFUNDDETAIL4("SHORTSTRING:2","ticker",ClassType.SHORTSTRING,"",8,"general",1,12,0,0,0,0,"Ticker",false,true,true,true,0),
	SECURITYFUNDDETAIL5("SHORTSTRING:3","exch_code",ClassType.SHORTSTRING,"",8,"general",1,13,0,0,0,0,"Exchange Code",false,true,true,true,0),
	SECURITYFUNDDETAIL6("MIDDLESTRING:1","market_sector_des",ClassType.MIDDLESTRING,"",16,"general",1,14,0,0,0,0,"Market Sector Description",false,true,true,true,0),
	SECURITYFUNDDETAIL7("SHORTSTRING:4","crncy",ClassType.SHORTSTRING,"",8,"general",1,3,0,0,0,0,"Currency",false,false,true,true,0),
	SECURITYFUNDDETAIL8("SHORTSTRING:5","cntry_issue_iso",ClassType.SHORTSTRING,"",8,"general",1,15,0,0,0,0,"Country of Issue (ISO)",false,true,true,true,0),
	SECURITYFUNDDETAIL9("MIDDLESTRING:2","security_typ",ClassType.MIDDLESTRING,"",16,"general",1,4,0,0,0,0,"Security Type",false,false,true,true,0),
	SECURITYFUNDDETAIL10("MIDDLESTRING:3","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,5,0,0,0,0,"ISIN Number",false,false,true,true,0),
	SECURITYFUNDDETAIL11("VERYLONGSTRING:1","long_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,16,0,0,0,0,"Long Company Name",false,true,true,true,0),
	SECURITYFUNDDETAIL12("SHORTSTRING:6","dvd_crncy",ClassType.SHORTSTRING,"",8,"general",1,17,0,0,0,0,"Dividend Currency",false,true,true,true,0),
	SECURITYFUNDDETAIL13("SHORTSTRING:7","dvd_declared_dt",ClassType.SHORTSTRING,"",8,"general",1,18,0,0,0,0,"Dividend Declared Date",false,true,true,true,0),
	SECURITYFUNDDETAIL14("SHORTSTRING:8","dvd_ex_dt",ClassType.SHORTSTRING,"",8,"general",1,19,0,0,0,0,"Dividend Ex Date",false,true,true,true,0),
	SECURITYFUNDDETAIL15("SHORTSTRING:9","dvd_freq",ClassType.SHORTSTRING,"",8,"general",1,20,0,0,0,0,"",false,true,true,true,0),
	SECURITYFUNDDETAIL16("SHORTSTRING:10","dvd_pay_dt",ClassType.SHORTSTRING,"",8,"general",1,21,0,0,0,0,"Dividend Pay Date",false,true,true,true,0),
	SECURITYFUNDDETAIL17("SHORTSTRING:11","dvd_record_dt",ClassType.SHORTSTRING,"",8,"general",1,22,0,0,0,0,"Dividend Record Date",false,true,true,true,0),
	SECURITYFUNDDETAIL18("SHORTSTRING:12","dvd_sh_last",ClassType.SHORTSTRING,"",8,"general",1,23,0,0,0,0,"Dividend Per Share Last Net",false,true,true,true,0),
	SECURITYFUNDDETAIL19("MIDDLESTRING:4","dvd_typ_last",ClassType.MIDDLESTRING,"",16,"general",1,24,0,0,0,0,"",false,true,true,true,0),
	SECURITYFUNDDETAIL20("MIDDLESTRING:5","eqy_prim_exch",ClassType.MIDDLESTRING,"",16,"general",1,6,0,0,0,0,"Primary Exchange",false,false,true,true,0),
	SECURITYFUNDDETAIL21("SHORTSTRING:13","eqy_split_dt",ClassType.SHORTSTRING,"",8,"general",1,25,0,0,0,0,"Split Date",false,true,true,true,0),
	SECURITYFUNDDETAIL22("SHORTSTRING:14","eqy_split_ratio",ClassType.SHORTSTRING,"",8,"general",1,26,0,0,0,0,"Split Ratio",false,true,true,true,0),
	SECURITYFUNDDETAIL23("SHORTSTRING:15","fund_expense_ratio",ClassType.SHORTSTRING,"",8,"general",1,27,0,0,0,0,"Expense Ratio",false,true,true,true,0),
	SECURITYFUNDDETAIL24("MIDDLESTRING:6","fund_incept_dt",ClassType.MIDDLESTRING,"",16,"general",1,28,0,0,0,0,"Inception Date",false,true,true,true,0),
	SECURITYFUNDDETAIL25("SHORTSTRING:16","fund_mgr_fee",ClassType.SHORTSTRING,"",8,"general",1,29,0,0,0,0,"Management Fee",false,true,true,true,0),
	SECURITYFUNDDETAIL26("SHORTSTRING:17","fund_min_invest",ClassType.SHORTSTRING,"",8,"general",1,30,0,0,0,0,"Minimum Investment",false,true,true,true,0),
	SECURITYFUNDDETAIL27("LONGSTRING:3","industry_group",ClassType.LONGSTRING,"",32,"general",1,7,0,0,0,0,"Industry Group",false,false,true,true,0),
	SECURITYFUNDDETAIL28("LONGSTRING:4","industry_sector",ClassType.LONGSTRING,"",32,"general",1,8,0,0,0,0,"Industry Sector",false,false,true,true,0),
	SECURITYFUNDDETAIL29("LONGSTRING:5","industry_subgroup",ClassType.LONGSTRING,"",32,"general",1,9,0,0,0,0,"Industry Subgroup",false,false,true,true,0),
	SECURITYFUNDDETAIL30("SHORTSTRING:18","market_status",ClassType.SHORTSTRING,"",8,"general",1,31,0,0,0,0,"Market Status",false,true,true,true,0),
	SECURITYFUNDDETAIL31("VERYLONGSTRING:2","name",ClassType.VERYLONGSTRING,"",64,"general",1,1,0,0,0,0,"Name",false,false,true,true,0),
	SECURITYFUNDDETAIL32("VERYLONGSTRING:3","parent_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,32,0,0,0,0,"Parent Company Name",false,true,true,true,0),
	SECURITYFUNDDETAIL33("SHORTSTRING:19","rel_index",ClassType.SHORTSTRING,"",8,"general",1,33,0,0,0,0,"Relative Index",false,true,true,true,0),
	SECURITYFUNDDETAIL34("VERYLONGSTRING:4","fund_objective_long",ClassType.VERYLONGSTRING,"",64,"general",1,34,0,0,0,0,"Fund Objective",false,true,true,true,0),
	SECURITYFUNDDETAIL35("VERYLONGSTRING:5","transfer_agent",ClassType.VERYLONGSTRING,"",64,"general",1,35,0,0,0,0,"Transfer Agent",false,true,true,true,0),
	SECURITYFUNDDETAIL36("LONGSTRING:6","fund_strategy",ClassType.LONGSTRING,"",32,"general",1,36,0,0,0,0,"Strategy",false,true,true,true,0),
	SECURITYFUNDDETAIL37("MIDDLESTRING:7","fund_mgmt_style",ClassType.MIDDLESTRING,"",16,"general",1,37,0,0,0,0,"Management Style",false,true,true,true,0),
	SECURITYFUNDDETAIL38("MIDDLESTRING:8","fund_typ",ClassType.MIDDLESTRING,"",16,"general",1,38,0,0,0,0,"Fund Type",false,true,true,true,0),
	SECURITYFUNDDETAIL39("LONGSTRING:7","fund_geo_focus",ClassType.LONGSTRING,"",32,"general",1,39,0,0,0,0,"Geographic Focus",false,true,true,true,0),
	SECURITYFUNDDETAIL40("LONGSTRING:8","fund_asset_class_focus",ClassType.LONGSTRING,"",32,"general",1,40,0,0,0,0,"Asset Class Focus",false,true,true,true,0),
	SECURITYFUNDDETAIL41("MIDDLESTRING:9","id_cusip",ClassType.MIDDLESTRING,"",16,"general",1,41,0,0,0,0,"Cusip Number",false,true,true,true,0),
	SECURITYFUNDDETAIL42("SHORTSTRING:20","px_trade_lot_size",ClassType.SHORTSTRING,"",8,"general",1,42,0,0,0,0,"Trade Lot Size",false,true,true,true,0),
	SECURITYFUNDDETAIL43("SHORTSTRING:21","cntry_of_incorporation",ClassType.SHORTSTRING,"",8,"general",1,43,0,0,0,0,"The Country Of Incorporation",false,true,true,true,0),
	SECURITYFUNDDETAIL44("SHORTSTRING:22","id_mic_prim_exch",ClassType.SHORTSTRING,"",8,"general",1,44,0,0,0,0,"Primary Exchange MIC",false,true,true,true,0),
	SECURITYFUNDDETAIL45("VERYLONGSTRING:6","fund_management_co",ClassType.VERYLONGSTRING,"",64,"general",1,45,0,0,0,0,"Management Company",false,true,true,true,0),
	SECURITYFUNDDETAIL46("LONGSTRING:9","security_typ2",ClassType.LONGSTRING,"",32,"general",1,46,0,0,0,0,"Security Type 2",false,true,true,true,0),
	SECURITYFUNDDETAIL47("MIDDLESTRING:10","fund_open_shr_class",ClassType.MIDDLESTRING,"",16,"general",1,47,0,0,0,0,"Open-end Share Class",false,true,true,true,0),
	SECURITYFUNDDETAIL48("MIDDLESTRING:11","fund_open_pymnt_shr",ClassType.MIDDLESTRING,"",16,"general",1,48,0,0,0,0,"Open-end Payment Share Type",false,true,true,true,0),
	SECURITYFUNDDETAIL49("VERYLONGSTRING:7","fund_custodian_long",ClassType.VERYLONGSTRING,"",64,"general",1,49,0,0,0,0,"Custodian (Long)",false,true,true,true,0),
	SECURITYFUNDDETAIL50("SHORTSTRING:23","min_subsequent_invest",ClassType.SHORTSTRING,"",8,"general",1,50,0,0,0,0,"Minimum Subsequent Investment",false,true,true,true,0);

	private String fieldPath=null;
	private String name=null;
	private ClassType fieldType=null;
	private String format=null;
	private int maxLength=0;
	private boolean displayInTable=false;
	private int displayInTableOrder=0;
	private String displayGroup=null;
	private int displayGroupOrder=0;
	private int displayInGroupOrder=0;
	private int displayRow=0;
	private int displayColumn=0;
	private int displayTop=0;
	private int displayLeft=0;
	private String description=null;
	private boolean extension=false;
	private boolean hidden=false;
	private boolean store=false;
	
	FUNDSecurityFinancialAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder){
		this.fieldPath=_fieldPath;
		this.name=_name;
		this.fieldType=_fieldType;
		this.format=_format;
		this.maxLength=_maxLength;
		this.displayInTable=_displayInTable;
		this.displayInTableOrder=_displayInTableOrder;
		this.displayGroup=_displayGroup;
		this.displayGroupOrder=_displayGroupOrder;
		this.displayInGroupOrder=_displayInGroupOrder;
		this.displayRow=_displayRow;
		this.displayColumn=_displayColumn;
		this.displayTop=_displayTop; 
		this.displayLeft=_displayLeft;
		this.description=_description;
		this.extension=_extension;
		this.hidden=_hidden;
		this.store= _store;
	}

	public String getFieldPath() {
		return fieldPath;
	}

	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassType getFieldType() {
		return fieldType;
	}

	public void setFieldType(ClassType fieldType) {
		this.fieldType = fieldType;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean isDisplayInTable() {
		return displayInTable;
	}

	public void setDisplayInTable(boolean displayInTable) {
		this.displayInTable = displayInTable;
	}

	public int getDisplayInTableOrder() {
		return displayInTableOrder;
	}

	public void setDisplayInTableOrder(int displayInTableOrder) {
		this.displayInTableOrder = displayInTableOrder;
	}

	public String getDisplayGroup() {
		return displayGroup;
	}

	public void setDisplayGroup(String displayGroup) {
		this.displayGroup = displayGroup;
	}

	public int getDisplayGroupOrder() {
		return displayGroupOrder;
	}

	public void setDisplayGroupOrder(int displayGroupOrder) {
		this.displayGroupOrder = displayGroupOrder;
	}

	public int getDisplayInGroupOrder() {
		return displayInGroupOrder;
	}

	public void setDisplayInGroupOrder(int displayInGroupOrder) {
		this.displayInGroupOrder = displayInGroupOrder;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayColumn() {
		return displayColumn;
	}

	public void setDisplayColumn(int displayColumn) {
		this.displayColumn = displayColumn;
	}

	public int getDisplayTop() {
		return displayTop;
	}

	public void setDisplayTop(int displayTop) {
		this.displayTop = displayTop;
	}

	public int getDisplayLeft() {
		return displayLeft;
	}

	public void setDisplayLeft(int displayLeft) {
		this.displayLeft = displayLeft;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isStore() {
		return store;
	}

	public void setStore(boolean store) {
		this.store = store;
	}
}
