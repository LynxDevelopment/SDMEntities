package com.lynxspa.sdm.dictionaries.sdm.assets;

import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.entities.securities.assets.adapters.AssetTypeDetailAdapter;

public enum EQAssetsDetails implements AssetTypeDetailAdapter {

	ASSETEQFIELD1("BOOLEAN:1","multiple_share",ClassType.BOOLEAN,"",8,"general",1,42,0,0,0,0,"Is Multiple Share",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD2("DOUBLE:1","par_amt",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,7,0,0,0,0,"Par Amount",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD3("DOUBLE:2","adr_sh_per_adr",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,16,0,0,0,0,"Shares per ADR",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD4("DOUBLE:3","dvd_sh_last",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,18,0,0,0,0,"Dividend Per Share Last Net",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD5("DOUBLE:4","last_dps_gross",ClassType.DOUBLE,"#,###,###,##0.000000",8,"general",1,19,0,0,0,0,"Dividend Per Share Last (Gross)",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD6("DOUBLE:5","voting_rights",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,34,0,0,0,0,"Voting Rights Per Share",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD7("DOUBLE:6","eqy_sh_out",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,36,0,0,0,0,"Current Shares Outstanding",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD8("DOUBLE:7","adr_adr_per_sh",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,40,0,0,0,0,"ADR per Share",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD9("DOUBLE:8","eqy_sh_out_real",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,41,0,0,0,0,"Current Shares Outstanding Real",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD10("DOUBLE:9","px_quote_lot_size",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,43,0,0,0,0,"Quote Lot Size",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD11("DOUBLE:10","eqy_sh_out_tot_mult_sh",ClassType.DOUBLE,"#,###,###,##0.000000",16,"general",1,46,0,0,0,0,"Current Shares Outstanding For All Classes",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD12("DOUBLE:11","total_voting_shares_value",ClassType.DOUBLE,"#,###,###,##0.000000",32,"general",1,50,0,0,0,0,"Total Voting Shares Value",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD13("LONG:1","id_bb_company",ClassType.LONG,"",16,"general",1,10,0,0,0,0,"Company ID",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD14("LONG:2","id_bb_security",ClassType.LONG,"",8,"general",1,14,0,0,0,0,"Security ID",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD15("LONG:3","px_trade_lot_size",ClassType.LONG,"",8,"general",1,31,0,0,0,0,"Trade Lot Size",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD16("LONGSTRING:1","name",ClassType.LONGSTRING,"",16,"general",1,13,0,0,0,0,"Name",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD17("LONGSTRING:2","industry_group",ClassType.LONGSTRING,"",32,"general",1,5,0,0,0,0,"Industry Group",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD18("LONGSTRING:3","industry_subgroup",ClassType.LONGSTRING,"",32,"general",1,6,0,0,0,0,"Industry Subgroup",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD19("LONGSTRING:4","industry_sector",ClassType.LONGSTRING,"",32,"general",1,4,0,0,0,0,"Industry Sector",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD20("LONGSTRING:5","parent_comp_name",ClassType.LONGSTRING,"",32,"general",1,32,0,0,0,0,"Parent Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD21("LONGSTRING:6","security_typ2",ClassType.LONGSTRING,"",32,"general",1,47,0,0,0,0,"Security Type 2",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD22("MIDDLESTRING:1","security_typ",ClassType.MIDDLESTRING,"",16,"general",1,3,0,0,0,0,"Security Type",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD23("MIDDLESTRING:2","eqy_prim_exch",ClassType.MIDDLESTRING,"",16,"general",1,8,0,0,0,0,"Primary Exchange",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD24("MIDDLESTRING:3","id_isin",ClassType.MIDDLESTRING,"",16,"general",1,9,0,0,0,0,"ISIN Number",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD25("MIDDLESTRING:4","id_cusip",ClassType.MIDDLESTRING,"",16,"general",1,15,0,0,0,0,"Cusip Number",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD26("MIDDLESTRING:5","dvd_typ_last",ClassType.MIDDLESTRING,"",16,"general",1,20,0,0,0,0,"Dividend Type",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD27("MIDDLESTRING:6","market_sector_des",ClassType.MIDDLESTRING,"",16,"general",1,38,0,0,0,0,"Market Sector Description",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD28("SHORTSTRING:1","ticker",ClassType.SHORTSTRING,"",8,"general",1,11,0,0,0,0,"Ticker",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD29("SHORTSTRING:2","exch_code",ClassType.SHORTSTRING,"",8,"general",1,12,0,0,0,0,"Exchange Code",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD30("SHORTSTRING:3","country",ClassType.SHORTSTRING,"",8,"general",1,1,0,0,0,0,"Country",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD31("SHORTSTRING:4","crncy",ClassType.SHORTSTRING,"",8,"general",1,2,0,0,0,0,"Currency",false,false,true,true,0,"S",true,false,true),
	ASSETEQFIELD32("SHORTSTRING:5","dvd_crncy",ClassType.SHORTSTRING,"",8,"general",1,17,0,0,0,0,"Dividend Currency",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD33("SHORTSTRING:6","dvd_freq",ClassType.SHORTSTRING,"",8,"general",1,21,0,0,0,0,"Dividend Frequency",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD34("SHORTSTRING:7","eqy_split_ratio",ClassType.SHORTSTRING,"",8,"general",1,26,0,0,0,0,"Split Ratio",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD35("SHORTSTRING:8","cntry_issue_iso",ClassType.SHORTSTRING,"",8,"general",1,28,0,0,0,0,"Country of Issue (ISO)",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD36("SHORTSTRING:9","market_status",ClassType.SHORTSTRING,"",8,"general",1,29,0,0,0,0,"Market Status",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD37("SHORTSTRING:10","rel_index",ClassType.SHORTSTRING,"",8,"general",1,30,0,0,0,0,"Relative Index",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD38("SHORTSTRING:11","par_val_crncy",ClassType.SHORTSTRING,"",8,"general",1,35,0,0,0,0,"Par Value Currency",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD39("SHORTSTRING:12","eqy_prim_security_ticker",ClassType.SHORTSTRING,"",8,"general",1,39,0,0,0,0,"Primary Security Ticker",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD40("SHORTSTRING:13","id_mic_prim_exch",ClassType.SHORTSTRING,"",8,"general",1,44,0,0,0,0,"Primary Exchange MIC",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD41("SHORTSTRING:14","id_mic_local_exch",ClassType.SHORTSTRING,"",8,"general",1,45,0,0,0,0,"Local Exchange MIC",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD42("TIMESTAMP:1","dvd_pay_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,22,0,0,0,0,"Dividend Pay Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD43("TIMESTAMP:2","dvd_record_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,23,0,0,0,0,"Dividend Record Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD44("TIMESTAMP:3","dvd_declared_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,24,0,0,0,0,"Dividend Declared Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD45("TIMESTAMP:4","eqy_split_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,25,0,0,0,0,"Split Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD46("TIMESTAMP:5","dvd_ex_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,27,0,0,0,0,"Dividend Ex Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD47("TIMESTAMP:6","eqy_sh_out_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,37,0,0,0,0,"Current Shares Outstanding Date",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD48("TIMESTAMP:7","eqy_init_po_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,48,0,0,0,0,"Initial Pub Offer (Date)",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD49("TIMESTAMP:8","eqy_po_dt",ClassType.TIMESTAMP,"dd/mm/yyyy",8,"general",1,49,0,0,0,0,"Last Pub Offer (Date)",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD50("VERYLONGSTRING:1","long_comp_name",ClassType.VERYLONGSTRING,"",32,"general",1,33,0,0,0,0,"Long Company Name",false,true,true,true,0,"S",true,false,true),
	ASSETEQFIELD51("DOUBLE:12","high_52week",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"52 Week High",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD52("DOUBLE:13","low_52week",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"52 Week Low",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD53("TIMESTAMP:9","high_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week High Date",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD54("TIMESTAMP:10","low_dt_52week",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"52 Week Low Date",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD55("DOUBLE:14","px_bid",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Bid Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD56("DOUBLE:15","px_mid",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Mid Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD57("DOUBLE:16","px_ask",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Ask Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD58("DOUBLE:17","px_open",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Open Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD59("DOUBLE:18","px_high",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"High Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD60("DOUBLE:19","px_low",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Low Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD61("DOUBLE:20","px_last",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Last Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD62("DOUBLE:21","px_fixing",ClassType.DOUBLE,"#,###,###,##0.000000",0,"general",1,0,0,0,0,0,"Fixing Price",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD63("LONG:4","px_volume",ClassType.LONG,"",0,"general",1,0,0,0,0,0,"Volume",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD64("LONGSTRING:7","pricing_source",ClassType.LONGSTRING,"",0,"general",1,0,0,0,0,0,"Pricing Source",false,true,true,true,0,"D",true,false,true),
	ASSETEQFIELD65("TIMESTAMP:11","last_update",ClassType.TIMESTAMP,"dd/mm/yyyy",0,"general",1,0,0,0,0,0,"Time/Date of Last Update",false,true,true,true,0,"D",true,false,true);
	
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
	
	EQAssetsDetails (String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden, boolean _store,boolean _displayInTable,int _displayInTableOrder,String _nature,boolean _editable, boolean _filter,boolean _editableNormalization){
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
