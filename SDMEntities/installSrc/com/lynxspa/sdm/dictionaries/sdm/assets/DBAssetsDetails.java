package com.lynxspa.sdm.dictionaries.sdm.assets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.assets.adapters.AssetTypeDetailAdapter;

public enum DBAssetsDetails implements AssetTypeDetailAdapter {
	
	ASSETDBFIELD1("BOOLEAN:1","structured_note",ClassType.BOOLEAN,"",8,"general",1,43,0,0,0,0,"Is Structured Note",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD2("BOOLEAN:2","is_unit_traded",ClassType.BOOLEAN,"",8,"general",1,44,0,0,0,0,"Is Unit Traded",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD3("BOOLEAN:3","trade_status",ClassType.BOOLEAN,"",8,"general",1,47,0,0,0,0,"Trading Status",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD4("BOOLEAN:4","is_perpetual",ClassType.BOOLEAN,"",8,"general",1,49,0,0,0,0,"Is Perpetual",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD5("BOOLEAN:5","extendible",ClassType.BOOLEAN,"",8,"general",1,50,0,0,0,0,"Extendible",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD6("DOUBLE:1","cpn",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,12,0,0,0,0,"Coupon",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD7("DOUBLE:2","amt_issued",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,16,0,0,0,0,"Amount Issued",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD8("DOUBLE:3","amt_outstanding",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,17,0,0,0,0,"Amount Outstanding",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD9("DOUBLE:4","min_piece",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,18,0,0,0,0,"Minimum Piece",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD10("DOUBLE:5","min_increment",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,19,0,0,0,0,"Minimum Increment",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD11("DOUBLE:6","par_amt",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,20,0,0,0,0,"Par Amount",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD12("DOUBLE:7","redemp_val",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,22,0,0,0,0,"Redemption Value",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD13("DOUBLE:8","issue_px",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,26,0,0,0,0,"Issue Price",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD14("DOUBLE:9","basic_spread",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,31,0,0,0,0,"Basic Spread (Percent)",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD15("DOUBLE:10","high_52week",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"52 Week High",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD16("DOUBLE:11","low_52week",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"52 Week Low",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD17("DOUBLE:12","px_bid",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Bid Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD18("DOUBLE:13","px_mid",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Mid Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD19("DOUBLE:14","px_ask",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Ask Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD20("DOUBLE:15","px_open",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Open Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD21("DOUBLE:16","px_high",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"High Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD22("DOUBLE:17","px_low",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Low Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD23("DOUBLE:18","px_last",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Last Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD24("DOUBLE:19","px_fixing",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,0,0,0,0,0,"Fixing Price",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD25("LONG:1","cpn_freq",ClassType.LONG,"",8,"general",1,8,0,0,0,0,"Coupon Frequency",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD26("LONG:2","px_volume",ClassType.LONG,"",8,"general",1,0,0,0,0,0,"Volume",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD27("LONGSTRING:1","calc_typ_des",ClassType.LONGSTRING,"",32,"general",1,4,0,0,0,0,"Calculation Type Description",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD28("LONGSTRING:2","industry_sector",ClassType.LONGSTRING,"",32,"general",1,32,0,0,0,0,"Industry Sector",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD29("LONGSTRING:3","industry_group",ClassType.LONGSTRING,"",32,"general",1,33,0,0,0,0,"Industry Group",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD30("LONGSTRING:4","security_des",ClassType.LONGSTRING,"",32,"general",1,34,0,0,0,0,"Security Description",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD31("LONGSTRING:5","post_euro_day_cnt_des",ClassType.LONGSTRING,"",32,"general",1,36,0,0,0,0,"Post-Euro Day Count Description",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD32("LONGSTRING:6","pre_euro_day_cnt_des",ClassType.LONGSTRING,"",32,"general",1,37,0,0,0,0,"Pre-Euro Day Count Description",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD33("LONGSTRING:7","issuer",ClassType.LONGSTRING,"",32,"general",1,46,0,0,0,0,"Issuer",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD34("LONGSTRING:8","pricing_source",ClassType.LONGSTRING,"",0,"general",1,0,0,0,0,0,"Pricing Source",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD35("MIDDLESTRING:1","issuer_industry",ClassType.MIDDLESTRING,"",16,"general",1,7,0,0,0,0,"Issuer Industry",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD36("MIDDLESTRING:2","mty_typ",ClassType.MIDDLESTRING,"",16,"general",1,6,0,0,0,0,"Mty/Refund Type",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD37("MIDDLESTRING:3","market_issue",ClassType.MIDDLESTRING,"",16,"general",1,9,0,0,0,0,"Market Issue",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD38("MIDDLESTRING:4","collat_typ",ClassType.MIDDLESTRING,"",16,"general",1,15,0,0,0,0,"Collateral Type",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD39("MIDDLESTRING:5","exch_code",ClassType.MIDDLESTRING,"",16,"general",1,21,0,0,0,0,"Exchange Code",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD40("MIDDLESTRING:6","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,27,0,0,0,0,"ISIN Number",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD41("MIDDLESTRING:7","id_cusip",ClassType.MIDDLESTRING,"",16,"general",1,28,0,0,0,0,"Cusip Number",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD42("MIDDLESTRING:8","security_typ",ClassType.MIDDLESTRING,"",16,"general",1,35,0,0,0,0,"Security Type",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD43("MIDDLESTRING:9","id_bb_unique",ClassType.MIDDLESTRING,"",16,"general",1,39,0,0,0,0,"Unique Bloomberg Identifier",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD44("SHORTSTRING:1","ticker",ClassType.SHORTSTRING,"",8,"general",1,11,0,0,0,0,"Ticker",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD45("SHORTSTRING:2","series",ClassType.SHORTSTRING,"",8,"general",1,1,0,0,0,0,"Series",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD46("SHORTSTRING:3","cpn_typ",ClassType.SHORTSTRING,"",8,"general",1,5,0,0,0,0,"Coupon Type",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD47("SHORTSTRING:4","country",ClassType.SHORTSTRING,"",8,"general",1,10,0,0,0,0,"Country",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD48("SHORTSTRING:5","crncy",ClassType.SHORTSTRING,"",8,"general",1,14,0,0,0,0,"Currency",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD49("SHORTSTRING:6","redemp_crncy",ClassType.SHORTSTRING,"",8,"general",1,41,0,0,0,0,"Redemption Currency",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD50("SHORTSTRING:7","cpn_crncy",ClassType.SHORTSTRING,"",8,"general",1,42,0,0,0,0,"Coupon Currency",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD51("SHORTSTRING:8","trade_crncy",ClassType.SHORTSTRING,"",8,"general",1,45,0,0,0,0,"Trade Currency",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD52("TIMESTAMP:1","maturity",ClassType.TIMESTAMP,"dd/mm/yyyy",16,"general",1,13,0,0,0,0,"Maturity",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD53("TIMESTAMP:2","announce_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,23,0,0,0,0,"Announce Date",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD54("TIMESTAMP:3","first_cpn_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,24,0,0,0,0,"First Coupon Date",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD55("TIMESTAMP:4","issue_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,25,0,0,0,0,"Issue Date",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD56("TIMESTAMP:5","prev_cpn_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,38,0,0,0,0,"Previous Coupon Date Per Settle Date",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD57("TIMESTAMP:6","final_maturity",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,48,0,0,0,0,"Final Maturity",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD58("TIMESTAMP:7","high_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week High Date",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD59("TIMESTAMP:8","low_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week Low Date",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD60("TIMESTAMP:9","last_update",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"Time/Date of Last Update",false,true,true,true,0,"D",true,false,true),
	ASSETDBFIELD61("VERYLONGSTRING:1","name",ClassType.VERYLONGSTRING,"",64,"general",1,2,0,0,0,0,"Name",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD62("VERYLONGSTRING:2","short_name",ClassType.VERYLONGSTRING,"",64,"general",1,3,0,0,0,0,"Short Name",false,false,true,true,0,"S",true,false,true),
	ASSETDBFIELD63("VERYLONGSTRING:3","reset_idx",ClassType.VERYLONGSTRING,"",64,"general",1,29,0,0,0,0,"Reset Index",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD64("VERYLONGSTRING:4","parent_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,30,0,0,0,0,"Parent Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETDBFIELD65("VERYLONGSTRING:5","long_comp_name",ClassType.VERYLONGSTRING,"",64,"general",1,40,0,0,0,0,"Long Company Name",false,true,true,true,0,"S",true,false,true);
	
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
	
	DBAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,
			int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,
			String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder,
			String _nature,boolean _editable, boolean _filter,boolean _editableNormalization){
		
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
