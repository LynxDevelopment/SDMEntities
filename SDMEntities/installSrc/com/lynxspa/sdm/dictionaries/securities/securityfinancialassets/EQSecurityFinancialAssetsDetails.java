package com.lynxspa.sdm.dictionaries.securities.securityfinancialassets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;

public enum EQSecurityFinancialAssetsDetails implements SecurityDetailAdapter {

	SECURITYRVDETAIL1("SHORTSTRING:1","ticker",ClassType.SHORTSTRING,"",8,"general",1,11,0,0,0,0,"Ticker",false,true,true,true,0),
	SECURITYRVDETAIL2("SHORTSTRING:2","exch_code",ClassType.SHORTSTRING,"",8,"general",1,12,0,0,0,0,"Exchange Code",false,true,true,true,0),
	SECURITYRVDETAIL3("LONGSTRING:1","name",ClassType.LONGSTRING,"",16,"general",1,13,0,0,0,0,"Name",false,true,true,true,0),
	SECURITYRVDETAIL4("SHORTSTRING:3","country",ClassType.SHORTSTRING,"",8,"general",1,1,0,0,0,0,"Country",false,false,true,true,0),
	SECURITYRVDETAIL5("SHORTSTRING:4","crncy",ClassType.SHORTSTRING,"",8,"general",1,2,0,0,0,0,"Currency",false,false,true,true,0),
	SECURITYRVDETAIL6("MIDDLESTRING:2","security_typ",ClassType.MIDDLESTRING,"",16,"general",1,3,0,0,0,0,"Security Type",false,false,true,true,0),
	SECURITYRVDETAIL7("LONGSTRING:2","par_amt",ClassType.LONGSTRING,"",32,"general",1,7,0,0,0,0,"Par Amount",false,false,true,true,0),
	SECURITYRVDETAIL8("MIDDLESTRING:3","eqy_prim_exch",ClassType.MIDDLESTRING,"",16,"general",1,8,0,0,0,0,"Primary Exchange",false,false,true,true,0),
	SECURITYRVDETAIL9("LONGSTRING:3","industry_group",ClassType.LONGSTRING,"",32,"general",1,5,0,0,0,0,"Industry Group",false,false,true,true,0),
	SECURITYRVDETAIL10("LONGSTRING:4","industry_subgroup",ClassType.LONGSTRING,"",32,"general",1,6,0,0,0,0,"Industry Subgroup",false,false,true,true,0),
	SECURITYRVDETAIL11("LONGSTRING:5","industry_sector",ClassType.LONGSTRING,"",32,"general",1,4,0,0,0,0,"Industry Sector",false,false,true,true,0),
	SECURITYRVDETAIL12("MIDDLESTRING:4","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,9,0,0,0,0,"ISIN Number",false,false,true,true,0),
	SECURITYRVDETAIL13("MIDDLESTRING:5","id_bb_company",ClassType.MIDDLESTRING,"",16,"general",1,10,0,0,0,0,"Company ID",false,false,true,true,0),
	SECURITYRVDETAIL14("SHORTSTRING:5","id_bb_security",ClassType.SHORTSTRING,"",8,"general",1,14,0,0,0,0,"Security ID",false,true,true,true,0),
	SECURITYRVDETAIL15("MIDDLESTRING:6","id_cusip",ClassType.MIDDLESTRING,"",16,"general",1,15,0,0,0,0,"Cusip Number",false,true,true,true,0),
	SECURITYRVDETAIL16("LONGSTRING:6","adr_sh_per_adr",ClassType.LONGSTRING,"",32,"general",1,16,0,0,0,0,"Shares per ADR",false,true,true,true,0),
	SECURITYRVDETAIL17("SHORTSTRING:6","dvd_crncy",ClassType.SHORTSTRING,"",8,"general",1,17,0,0,0,0,"Dividend Currency",false,true,true,true,0),
	SECURITYRVDETAIL18("SHORTSTRING:7","dvd_sh_last",ClassType.SHORTSTRING,"",8,"general",1,18,0,0,0,0,"Dividend Per Share Last Net",false,true,true,true,0),
	SECURITYRVDETAIL19("SHORTSTRING:8","last_dps_gross",ClassType.SHORTSTRING,"",8,"general",1,19,0,0,0,0,"Dividend Per Share Last (Gross)",false,true,true,true,0),
	SECURITYRVDETAIL20("MIDDLESTRING:7","dvd_typ_last",ClassType.MIDDLESTRING,"",16,"general",1,20,0,0,0,0,"Dividend Type",false,true,true,true,0),
	SECURITYRVDETAIL21("SHORTSTRING:9","dvd_freq",ClassType.SHORTSTRING,"",8,"general",1,21,0,0,0,0,"Dividend Frequency",false,true,true,true,0),
	SECURITYRVDETAIL22("SHORTSTRING:10","dvd_pay_dt",ClassType.SHORTSTRING,"",8,"general",1,22,0,0,0,0,"Dividend Pay Date",false,true,true,true,0),
	SECURITYRVDETAIL23("SHORTSTRING:11","dvd_record_dt",ClassType.SHORTSTRING,"",8,"general",1,23,0,0,0,0,"Dividend Record Date",false,true,true,true,0),
	SECURITYRVDETAIL24("SHORTSTRING:12","dvd_declared_dt",ClassType.SHORTSTRING,"",8,"general",1,24,0,0,0,0,"Dividend Declared Date",false,true,true,true,0),
	SECURITYRVDETAIL25("SHORTSTRING:13","eqy_split_dt",ClassType.SHORTSTRING,"",8,"general",1,25,0,0,0,0,"Split Date",false,true,true,true,0),
	SECURITYRVDETAIL26("SHORTSTRING:14","eqy_split_ratio",ClassType.SHORTSTRING,"",8,"general",1,26,0,0,0,0,"Split Ratio",false,true,true,true,0),
	SECURITYRVDETAIL27("SHORTSTRING:15","dvd_ex_dt",ClassType.SHORTSTRING,"",8,"general",1,27,0,0,0,0,"Dividend Ex Date",false,true,true,true,0),
	SECURITYRVDETAIL28("SHORTSTRING:16","cntry_issue_iso",ClassType.SHORTSTRING,"",8,"general",1,28,0,0,0,0,"Country of Issue (ISO)",false,true,true,true,0),
	SECURITYRVDETAIL29("SHORTSTRING:17","market_status",ClassType.SHORTSTRING,"",8,"general",1,29,0,0,0,0,"Market Status",false,true,true,true,0),
	SECURITYRVDETAIL30("SHORTSTRING:18","rel_index",ClassType.SHORTSTRING,"",8,"general",1,30,0,0,0,0,"Relative Index",false,true,true,true,0),
	SECURITYRVDETAIL31("SHORTSTRING:19","px_trade_lot_size",ClassType.SHORTSTRING,"",8,"general",1,31,0,0,0,0,"Trade Lot Size",false,true,true,true,0),
	SECURITYRVDETAIL32("LONGSTRING:7","parent_comp_name",ClassType.LONGSTRING,"",32,"general",1,32,0,0,0,0,"Parent Company Name",false,true,true,true,0),
	SECURITYRVDETAIL33("VERYLONGSTRING:1","long_comp_name",ClassType.VERYLONGSTRING,"",32,"general",1,33,0,0,0,0,"Long Company Name",false,true,true,true,0),
	SECURITYRVDETAIL34("MIDDLESTRING:8","voting_rights",ClassType.MIDDLESTRING,"",16,"general",1,34,0,0,0,0,"Voting Rights Per Share",false,true,true,true,0),
	SECURITYRVDETAIL35("SHORTSTRING:20","par_val_crncy",ClassType.SHORTSTRING,"",8,"general",1,35,0,0,0,0,"Par Value Currency",false,true,true,true,0),
	SECURITYRVDETAIL36("MIDDLESTRING:9","eqy_sh_out",ClassType.MIDDLESTRING,"",16,"general",1,36,0,0,0,0,"Current Shares Outstanding",false,true,true,true,0),
	SECURITYRVDETAIL37("SHORTSTRING:21","eqy_sh_out_dt",ClassType.SHORTSTRING,"",8,"general",1,37,0,0,0,0,"Current Shares Outstanding Date",false,true,true,true,0),
	SECURITYRVDETAIL38("MIDDLESTRING:10","market_sector_des",ClassType.MIDDLESTRING,"",16,"general",1,38,0,0,0,0,"Market Sector Description",false,true,true,true,0),
	SECURITYRVDETAIL39("SHORTSTRING:22","eqy_prim_security_ticker",ClassType.SHORTSTRING,"",8,"general",1,39,0,0,0,0,"Primary Security Ticker",false,true,true,true,0),
	SECURITYRVDETAIL40("LONGSTRING:8","adr_adr_per_sh",ClassType.LONGSTRING,"",32,"general",1,40,0,0,0,0,"ADR per Share",false,true,true,true,0),
	SECURITYRVDETAIL41("MIDDLESTRING:11","eqy_sh_out_real",ClassType.MIDDLESTRING,"",16,"general",1,41,0,0,0,0,"Current Shares Outstanding Real",false,true,true,true,0),
	SECURITYRVDETAIL42("SHORTSTRING:23","multiple_share",ClassType.SHORTSTRING,"",8,"general",1,42,0,0,0,0,"Is Multiple Share",false,true,true,true,0),
	SECURITYRVDETAIL43("MIDDLESTRING:12","px_quote_lot_size",ClassType.MIDDLESTRING,"",16,"general",1,43,0,0,0,0,"Quote Lot Size",false,true,true,true,0),
	SECURITYRVDETAIL44("SHORTSTRING:24","id_mic_prim_exch",ClassType.SHORTSTRING,"",8,"general",1,44,0,0,0,0,"Primary Exchange MIC",false,true,true,true,0),
	SECURITYRVDETAIL45("SHORTSTRING:25","id_mic_local_exch",ClassType.SHORTSTRING,"",8,"general",1,45,0,0,0,0,"Local Exchange MIC",false,true,true,true,0),
	SECURITYRVDETAIL46("MIDDLESTRING:13","eqy_sh_out_tot_mult_sh",ClassType.MIDDLESTRING,"",16,"general",1,46,0,0,0,0,"Current Shares Outstanding For All Classes",false,true,true,true,0),
	SECURITYRVDETAIL47("LONGSTRING:9","security_typ2",ClassType.LONGSTRING,"",32,"general",1,47,0,0,0,0,"Security Type 2",false,true,true,true,0),
	SECURITYRVDETAIL48("SHORTSTRING:26","eqy_init_po_dt",ClassType.SHORTSTRING,"",8,"general",1,48,0,0,0,0,"Initial Pub Offer (Date)",false,true,true,true,0),
	SECURITYRVDETAIL49("SHORTSTRING:27","eqy_po_dt",ClassType.SHORTSTRING,"",8,"general",1,49,0,0,0,0,"Last Pub Offer (Date)",false,true,true,true,0),
	SECURITYRVDETAIL50("LONGSTRING:10","total_voting_shares_value",ClassType.LONGSTRING,"",32,"general",1,50,0,0,0,0,"Total Voting Shares Value",false,true,true,true,0);
	
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
	
	EQSecurityFinancialAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder){
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
