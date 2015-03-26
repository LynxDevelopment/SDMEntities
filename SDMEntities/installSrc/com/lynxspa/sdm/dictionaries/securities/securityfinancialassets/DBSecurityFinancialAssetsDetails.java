package com.lynxspa.sdm.dictionaries.securities.securityfinancialassets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.adapters.SecurityDetailAdapter;

public enum DBSecurityFinancialAssetsDetails implements SecurityDetailAdapter {
	

	SECURITYRFDETAIL1("SHORTSTRING:1","ticker",ClassType.SHORTSTRING,"",8,"general",1,11,0,0,0,0,"Ticker",false,true,true,true,0),
	SECURITYRFDETAIL2("MIDDLESTRING:1","cpn",ClassType.MIDDLESTRING,"",16,"general",1,12,0,0,0,0,"Coupon",false,true,true,true,0),
	SECURITYRFDETAIL3("MIDDLESTRING:2","maturity",ClassType.MIDDLESTRING,"",16,"general",1,13,0,0,0,0,"Maturity",false,true,true,true,0),
	SECURITYRFDETAIL4("SHORTSTRING:2","series",ClassType.SHORTSTRING,"",8,"general",1,1,0,0,0,0,"Series",false,false,true,true,0),
	SECURITYRFDETAIL5("VERYLONGSTRING:1","name",ClassType.VERYLONGSTRING,"",64,"general",1,2,0,0,0,0,"Name",false,false,true,true,0),
	SECURITYRFDETAIL6("VERYLONGSTRING:2","short_name",ClassType.VERYLONGSTRING,"",64,"general",1,3,0,0,0,0,"Short Name",false,false,true,true,0),
	SECURITYRFDETAIL7("MIDDLESTRING:3","issuer_industry",ClassType.MIDDLESTRING,"",16,"general",1,7,0,0,0,0,"Issuer Industry",false,false,true,true,0),
	SECURITYRFDETAIL8("SHORTSTRING:3","cpn_freq",ClassType.SHORTSTRING,"",8,"general",1,8,0,0,0,0,"Coupon Frequency",false,false,true,true,0),
	SECURITYRFDETAIL9("SHORTSTRING:4","cpn_typ",ClassType.SHORTSTRING,"",8,"general",1,5,0,0,0,0,"Coupon Type",false,false,true,true,0),
	SECURITYRFDETAIL10("MIDDLESTRING:4","mty_typ",ClassType.MIDDLESTRING,"",16,"general",1,6,0,0,0,0,"Mty/Refund Type",false,false,true,true,0),
	SECURITYRFDETAIL11("LONGSTRING:1","calc_typ_des",ClassType.LONGSTRING,"",32,"general",1,4,0,0,0,0,"Calculation Type Description",false,false,true,true,0),
	SECURITYRFDETAIL12("MIDDLESTRING:5","market_issue",ClassType.MIDDLESTRING,"",16,"general",1,9,0,0,0,0,"Market Issue",false,false,true,true,0),
	SECURITYRFDETAIL13("SHORTSTRING:5","country",ClassType.SHORTSTRING,"",8,"general",1,10,0,0,0,0,"Country",false,false,true,true,0),
	SECURITYRFDETAIL14("SHORTSTRING:6","crncy",ClassType.SHORTSTRING,"",8,"general",1,14,0,0,0,0,"Currency",false,true,true,true,0),
	SECURITYRFDETAIL15("MIDDLESTRING:6","collat_typ",ClassType.MIDDLESTRING,"",16,"general",1,15,0,0,0,0,"Collateral Type",false,true,true,true,0),
	SECURITYRFDETAIL16("MIDDLESTRING:7","amt_issued",ClassType.MIDDLESTRING,"",16,"general",1,16,0,0,0,0,"Amount Issued",false,true,true,true,0),
	SECURITYRFDETAIL17("MIDDLESTRING:8","amt_outstanding",ClassType.MIDDLESTRING,"",16,"general",1,17,0,0,0,0,"Amount Outstanding",false,true,true,true,0),
	SECURITYRFDETAIL18("MIDDLESTRING:9","min_piece",ClassType.MIDDLESTRING,"",16,"general",1,18,0,0,0,0,"Minimum Piece",false,true,true,true,0),
	SECURITYRFDETAIL19("MIDDLESTRING:10","min_increment",ClassType.MIDDLESTRING,"",16,"general",1,19,0,0,0,0,"Minimum Increment",false,true,true,true,0),
	SECURITYRFDETAIL20("MIDDLESTRING:11","par_amt",ClassType.MIDDLESTRING,"",16,"general",1,20,0,0,0,0,"Par Amount",false,true,true,true,0),
	SECURITYRFDETAIL21("MIDDLESTRING:12","exch_code",ClassType.MIDDLESTRING,"",16,"general",1,21,0,0,0,0,"Exchange Code",false,true,true,true,0),
	SECURITYRFDETAIL22("MIDDLESTRING:13","redemp_val",ClassType.MIDDLESTRING,"",16,"general",1,22,0,0,0,0,"Redemption Value",false,true,true,true,0),
	SECURITYRFDETAIL23("SHORTSTRING:7","announce_dt",ClassType.SHORTSTRING,"",8,"general",1,23,0,0,0,0,"Announce Date",false,true,true,true,0),
	SECURITYRFDETAIL24("SHORTSTRING:8","first_cpn_dt",ClassType.SHORTSTRING,"",8,"general",1,24,0,0,0,0,"First Coupon Date",false,true,true,true,0),
	SECURITYRFDETAIL25("SHORTSTRING:9","issue_dt",ClassType.SHORTSTRING,"",8,"general",1,25,0,0,0,0,"Issue Date",false,true,true,true,0),
	SECURITYRFDETAIL26("MIDDLESTRING:14","issue_px",ClassType.MIDDLESTRING,"",16,"general",1,26,0,0,0,0,"Issue Price",false,true,true,true,0),
	SECURITYRFDETAIL27("MIDDLESTRING:15","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,27,0,0,0,0,"ISIN Number",false,true,true,true,0),
	SECURITYRFDETAIL28("MIDDLESTRING:16","id_cusip",ClassType.MIDDLESTRING,"",16,"general",1,28,0,0,0,0,"Cusip Number",false,true,true,true,0),
	SECURITYRFDETAIL29("VERYLONGSTRING:3","reset_idx",ClassType.VERYLONGSTRING,"",64,"general",1,29,0,0,0,0,"Reset Index",false,true,true,true,0),
	SECURITYRFDETAIL30("VERYLONGSTRING:4","parent_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,30,0,0,0,0,"Parent Company Name",false,true,true,true,0),
	SECURITYRFDETAIL31("LONGSTRING:2","basic_spread",ClassType.LONGSTRING,"",32,"general",1,31,0,0,0,0,"Basic Spread (Percent)",false,true,true,true,0),
	SECURITYRFDETAIL32("LONGSTRING:3","industry_sector",ClassType.LONGSTRING,"",32,"general",1,32,0,0,0,0,"Industry Sector",false,true,true,true,0),
	SECURITYRFDETAIL33("LONGSTRING:4","industry_group",ClassType.LONGSTRING,"",32,"general",1,33,0,0,0,0,"Industry Group",false,true,true,true,0),
	SECURITYRFDETAIL34("LONGSTRING:5","security_des",ClassType.LONGSTRING,"",32,"general",1,34,0,0,0,0,"Security Description",false,true,true,true,0),
	SECURITYRFDETAIL35("MIDDLESTRING:17","security_typ",ClassType.MIDDLESTRING,"",16,"general",1,35,0,0,0,0,"Security Type",false,true,true,true,0),
	SECURITYRFDETAIL36("LONGSTRING:6","post_euro_day_cnt_des",ClassType.LONGSTRING,"",32,"general",1,36,0,0,0,0,"Post-Euro Day Count Description",false,true,true,true,0),
	SECURITYRFDETAIL37("LONGSTRING:7","pre_euro_day_cnt_des",ClassType.LONGSTRING,"",32,"general",1,37,0,0,0,0,"Pre-Euro Day Count Description",false,true,true,true,0),
	SECURITYRFDETAIL38("SHORTSTRING:10","prev_cpn_dt",ClassType.SHORTSTRING,"",8,"general",1,38,0,0,0,0,"Previous Coupon Date Per Settle Date",false,true,true,true,0),
	SECURITYRFDETAIL39("MIDDLESTRING:18","id_bb_unique",ClassType.MIDDLESTRING,"",16,"general",1,39,0,0,0,0,"Unique Bloomberg Identifier",false,true,true,true,0),
	SECURITYRFDETAIL40("VERYLONGSTRING:5","long_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,40,0,0,0,0,"Long Company Name",false,true,true,true,0),
	SECURITYRFDETAIL41("SHORTSTRING:11","redemp_crncy",ClassType.SHORTSTRING,"",8,"general",1,41,0,0,0,0,"Redemption Currency",false,true,true,true,0),
	SECURITYRFDETAIL42("SHORTSTRING:12","cpn_crncy",ClassType.SHORTSTRING,"",8,"general",1,42,0,0,0,0,"Coupon Currency",false,true,true,true,0),
	SECURITYRFDETAIL43("SHORTSTRING:13","structured_note",ClassType.SHORTSTRING,"",8,"general",1,43,0,0,0,0,"Is Structured Note",false,true,true,true,0),
	SECURITYRFDETAIL44("SHORTSTRING:14","is_unit_traded",ClassType.SHORTSTRING,"",8,"general",1,44,0,0,0,0,"Is Unit Traded",false,true,true,true,0),
	SECURITYRFDETAIL45("SHORTSTRING:15","trade_crncy",ClassType.SHORTSTRING,"",8,"general",1,45,0,0,0,0,"Trade Currency",false,true,true,true,0),
	SECURITYRFDETAIL46("LONGSTRING:8","issuer",ClassType.LONGSTRING,"",32,"general",1,46,0,0,0,0,"Issuer",false,true,true,true,0),
	SECURITYRFDETAIL47("SHORTSTRING:16","trade_status",ClassType.SHORTSTRING,"",8,"general",1,47,0,0,0,0,"Trading Status",false,true,true,true,0),
	SECURITYRFDETAIL48("SHORTSTRING:17","final_maturity",ClassType.SHORTSTRING,"",8,"general",1,48,0,0,0,0,"Final Maturity",false,true,true,true,0),
	SECURITYRFDETAIL49("SHORTSTRING:18","is_perpetual",ClassType.SHORTSTRING,"",8,"general",1,49,0,0,0,0,"Is Perpetual",false,true,true,true,0),
	SECURITYRFDETAIL50("SHORTSTRING:19","extendible",ClassType.SHORTSTRING,"",8,"general",1,50,0,0,0,0,"Extendible",false,true,true,true,0);


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

	
	DBSecurityFinancialAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder){
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
