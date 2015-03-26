package com.lynxspa.sdm.dictionaries.sdm.assets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.assets.adapters.AssetTypeDetailAdapter;

public enum FUNDAssetsDetails implements AssetTypeDetailAdapter{

	ASSETFUNDFIELD1("DOUBLE:1","dvd_sh_last",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,23,0,0,0,0,"Dividend Per Share Last Net",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD2("DOUBLE:3","fund_expense_ratio",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,27,0,0,0,0,"Expense Ratio",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD3("DOUBLE:4","fund_mgr_fee",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,29,0,0,0,0,"Management Fee",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD4("DOUBLE:5","fund_min_invest",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,30,0,0,0,0,"Minimum Investment",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD5("DOUBLE:6","min_subsequent_invest",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,50,0,0,0,0,"Minimum Subsequent Investment",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD6("LONG:1","id_bb_company",ClassType.LONG,"",8,"general",1,2,0,0,0,0,"Company ID",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD7("LONG:2","px_trade_lot_size",ClassType.LONG,"",8,"general",1,42,0,0,0,0,"Trade Lot Size",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD8("LONGSTRING:1","long_comp_name",ClassType.LONGSTRING,"",64,"general",1,16,0,0,0,0,"Long Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD9("LONGSTRING:2","name",ClassType.LONGSTRING,"",64,"general",1,1,0,0,0,0,"Name",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD10("LONGSTRING:3","parent_comp_name",ClassType.LONGSTRING,"",64,"general",1,32,0,0,0,0,"Parent Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD11("LONGSTRING:4","rel_index",ClassType.LONGSTRING,"",8,"general",1,33,0,0,0,0,"Relative Index",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD12("LONGSTRING:5","fund_objective_long",ClassType.LONGSTRING,"",64,"general",1,34,0,0,0,0,"Fund Objective",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD13("LONGSTRING:6","fund_strategy",ClassType.LONGSTRING,"",32,"general",1,36,0,0,0,0,"Strategy",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD14("LONGSTRING:7","fund_mgmt_style",ClassType.LONGSTRING,"",16,"general",1,37,0,0,0,0,"Management Style",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD15("LONGSTRING:8","security_typ2",ClassType.LONGSTRING,"",32,"general",1,46,0,0,0,0,"Security Type 2",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD16("MIDDLESTRING:1","id_bb_unique",ClassType.MIDDLESTRING,"",32,"general",1,11,0,0,0,0,"Unique Bloomberg Identifier",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD17("MIDDLESTRING:2","crncy",ClassType.MIDDLESTRING,"",8,"general",1,3,0,0,0,0,"Currency",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD18("MIDDLESTRING:3","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,5,0,0,0,0,"ISIN Number",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD19("MIDDLESTRING:4","dvd_crncy",ClassType.MIDDLESTRING,"",8,"general",1,17,0,0,0,0,"Dividend Currency",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD20("MIDDLESTRING:5","dvd_freq",ClassType.MIDDLESTRING,"",8,"general",1,20,0,0,0,0,"",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD21("MIDDLESTRING:6","dvd_typ_last",ClassType.MIDDLESTRING,"",16,"general",1,24,0,0,0,0,"",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD22("MIDDLESTRING:7","eqy_prim_exch",ClassType.MIDDLESTRING,"",16,"general",1,6,0,0,0,0,"Primary Exchange",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD23("MIDDLESTRING:8","eqy_split_ratio",ClassType.MIDDLESTRING,"",8,"general",1,26,0,0,0,0,"Split Ratio",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD24("MIDDLESTRING:9","industry_group",ClassType.MIDDLESTRING,"",32,"general",1,7,0,0,0,0,"Industry Group",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD25("MIDDLESTRING:10","industry_sector",ClassType.MIDDLESTRING,"",32,"general",1,8,0,0,0,0,"Industry Sector",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD26("MIDDLESTRING:11","transfer_agent",ClassType.MIDDLESTRING,"",64,"general",1,35,0,0,0,0,"Transfer Agent",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD27("MIDDLESTRING:12","fund_geo_focus",ClassType.MIDDLESTRING,"",32,"general",1,39,0,0,0,0,"Geographic Focus",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD28("SHORTSTRING:1","sec_des",ClassType.SHORTSTRING,"",32,"general",1,10,0,0,0,0,"",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD29("SHORTSTRING:2","ticker",ClassType.SHORTSTRING,"",8,"general",1,12,0,0,0,0,"Ticker",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD30("SHORTSTRING:3","cntry_issue_iso",ClassType.SHORTSTRING,"",8,"general",1,15,0,0,0,0,"Country of Issue (ISO)",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD31("SHORTSTRING:4","security_typ",ClassType.SHORTSTRING,"",16,"general",1,4,0,0,0,0,"Security Type",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD32("SHORTSTRING:5","fund_typ",ClassType.SHORTSTRING,"",16,"general",1,38,0,0,0,0,"Fund Type",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD33("SHORTSTRING:6","id_cusip",ClassType.SHORTSTRING,"",16,"general",1,41,0,0,0,0,"Cusip Number",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD34("SHORTSTRING:7","cntry_of_incorporation",ClassType.SHORTSTRING,"",8,"general",1,43,0,0,0,0,"The Country Of Incorporation",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD35("SHORTSTRING:8","id_mic_prim_exch",ClassType.SHORTSTRING,"",8,"general",1,44,0,0,0,0,"Primary Exchange MIC",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD36("SHORTSTRING:9","fund_management_co",ClassType.SHORTSTRING,"",64,"general",1,45,0,0,0,0,"Management Company",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD37("SHORTSTRING:10","fund_open_shr_class",ClassType.SHORTSTRING,"",16,"general",1,47,0,0,0,0,"Open-end Share Class",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD38("SHORTSTRING:11","fund_open_pymnt_shr",ClassType.SHORTSTRING,"",16,"general",1,48,0,0,0,0,"Open-end Payment Share Type",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD39("SHORTSTRING:12","fund_custodian_long",ClassType.SHORTSTRING,"",64,"general",1,49,0,0,0,0,"Custodian (Long)",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD40("TIMESTAMP:1","dvd_declared_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,18,0,0,0,0,"Dividend Declared Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD41("TIMESTAMP:2","dvd_ex_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,19,0,0,0,0,"Dividend Ex Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD42("TIMESTAMP:3","dvd_pay_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,21,0,0,0,0,"Dividend Pay Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD43("TIMESTAMP:4","dvd_record_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,22,0,0,0,0,"Dividend Record Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD44("TIMESTAMP:5","eqy_split_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,25,0,0,0,0,"Split Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD45("TIMESTAMP:6","fund_incept_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",16,"general",1,28,0,0,0,0,"Inception Date",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD46("VERYLONGSTRING:1","exch_code",ClassType.VERYLONGSTRING,"",8,"general",1,13,0,0,0,0,"Exchange Code",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD47("VERYLONGSTRING:2","market_sector_des",ClassType.VERYLONGSTRING,"#,###,###,##0.000000",16,"general",1,14,0,0,0,0,"Market Sector Description",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD48("VERYLONGSTRING:3","industry_subgroup",ClassType.VERYLONGSTRING,"",32,"general",1,9,0,0,0,0,"Industry Subgroup",false,false,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD49("VERYLONGSTRING:4","market_status",ClassType.VERYLONGSTRING,"",8,"general",1,31,0,0,0,0,"Market Status",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD50("VERYLONGSTRING:5","fund_asset_class_focus",ClassType.VERYLONGSTRING,"",32,"general",1,40,0,0,0,0,"Asset Class Focus",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD51("VERYLONGSTRING:1","long_comp_name",ClassType.VERYLONGSTRING,"",32,"general",1,33,0,0,0,0,"Long Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETFUNDFIELD52("DOUBLE:7","high_52week",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"52 Week High",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD53("DOUBLE:8","low_52week",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"52 Week Low",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD54("TIMESTAMP:7","high_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week High Date",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD55("TIMESTAMP:8","low_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week Low Date",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD56("DOUBLE:9","px_bid",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Bid Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD57("DOUBLE:10","px_mid",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Mid Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD58("DOUBLE:11","px_ask",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Ask Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD59("DOUBLE:12","px_open",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Open Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD60("DOUBLE:13","px_high",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"High Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD61("DOUBLE:14","px_low",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Low Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD62("DOUBLE:15","px_last",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Last Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD63("DOUBLE:16","px_fixing",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Fixing Price",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD64("LONG:3","px_volume",ClassType.LONG,"",0,"general",1,0,0,0,0,0,"Volume",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD65("LONGSTRING:9","pricing_source",ClassType.LONGSTRING,"",0,"general",1,0,0,0,0,0,"Pricing Source",false,true,true,true,0,"D",true,false,true),
	ASSETFUNDFIELD66("TIMESTAMP:9","last_update",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"Time/Date of Last Update",false,true,true,true,0,"D",true,false,true);
	
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
	private String nature=null;
	private boolean editable=false;
	private boolean filter=false;
	private boolean editableNormalization=false;
	
	FUNDAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder,String _nature,boolean _editable, boolean _filter,boolean _editableNormalization){
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
		this.nature=_nature;
		this.editable=_editable;
		this.filter=_filter;
		this.editableNormalization=_editableNormalization;
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

	@Override
	public String getNature() {
		return nature;
	}
	
	@Override
	public boolean isEditable() {
		return editable;
	}


	@Override
	public boolean isFilter() {
		return filter;
	}


	@Override
	public boolean isEditableNormalization() {
		return editableNormalization;
	}
}
