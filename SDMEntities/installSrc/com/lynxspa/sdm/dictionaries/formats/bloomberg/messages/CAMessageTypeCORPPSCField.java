package com.lynxspa.sdm.dictionaries.formats.bloomberg.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageTypeCORPPSCField implements CAMessageTypeFieldsDictAdapter{

	//Message fields
	FIELD0("MSG:SN","serial number","STRING",8,null,"formats",0,0,"Bloomberg Professional Service serial number",true),
	FIELD1("MSG:WS","workstation number","STRING",8,null,"formats",0,0,"Bloomberg Professional Service workstation number",true),
	FIELD2("MSG:SECMASTER","sec master","STRING",8,null,"formats",0,0,"It allows customers to request data via fields from both the End of Day Pricing and the Security Master categories",true),
	FIELD3("MSG:USERNUMBER","user number","STRING",8,null,"formats",0,0,"This is the user number of the BLOOMBERG PROFESSIONAL service login",true),
	FIELD4("MSG:FIRMNAME","firm name","STRING",8,null,"formats",0,0,"This is the login name assigned by Bloomberg",true),
	FIELD5("MSG:FILETYPE","file type","STRING",8,null,"formats",0,0,"If FILETYPE=PC, then a carriage return is added to the end of each line of the reply file before it is encrypted",true),
	FIELD6("MSG:RUNDATE","run date","STRING",8,null,"formats",0,0,"This option controls the date on which requests are processed",true),
	FIELD7("MSG:HEADER","header indicator","STRING",4,null,"formats",0,0,"This allows customers to specify if the header should be returned in the reply file",true),
	FIELD8("MSG:COLUMNHEADER","column header indicator","STRING",4,null,"formats",0,0,"The default is no; if set to yes, the output file will return the title of each column of data",true),
	FIELD9("MSG:REPLYFILENAME","file name responded","STRING",32,null,"formats",0,0,"This specifies the name of the file that will be created to contain the output of a data request",true),
	FIELD10("MSG:PROGRAMNAME","program runned by Bloomberg","STRING",32,null,"formats",0,0,"This names the program to be run by Bloomberg",true),
	FIELD11("MSG:PROGRAMFLAG","program flag","STRING",8,null,"formats",0,0,"This flag determines how often to process the request",true),
	FIELD12("MSG:DATEFORMAT","date format","STRING",16,null,"formats",0,0,"Format of date like java",true),
	FIELD13("MSG:TIMESTARTED","start message timestamp","STRING",16,null,"formats",0,0,"Start message timestamp",true),
	FIELD14("MSG:TIMEFINISHED","end message timestamp","STRING",16,null,"formats",0,0,"End message timestamp",true),
	FIELD15("MSG:DERIVED","From derived data category","STRING",3,null,"formats",0,0,"Allows customers to request data via fields from the Derived Data category",true),
	FIELD16("MSG:SECID","Security identifier type","STRING",3,null,"formats",0,0,"This option allows the specification of a default security identifier",true),
	//Header fields
	FIELD17("HDR:0","identifier","STRING",32,null,"message.header",0,0,"Security identifier used in the request file",true),
	FIELD18("HDR:1","return code","STRING",4,null,"message.header",0,0,"Return code. A return distinct of 0 indicate error and no further fields will be delivered in that record",true),
	FIELD19("HDR:2","number of fields","STRING",8,null,"message.header",0,0,"Number of fields requested and received",true),
	//Standard fields
	FIELD20("STD:0","event type","STRING",8,null,"message.header",0,0,"Event type code",true),
	FIELD21("STD:1","operation","STRING",8,null,"message.header",0,0,"Operation code",true),
	//Body fields
	FIELD22("BDY:CPN:ID_ISIN","ISIN Number","STRING",12,"Char (12)","Additional notes",0,0,"A twelve-character number assigned by the local national numbering agency",true),
	FIELD23("BDY:CPN:CPN","Coupon","STRING",12,"Real (12,6)",null,0,0,"Current interest rate of the security. Fixed Income: Floating rate securities that have not settled will return a projected rate",false),
	FIELD24("BDY:CPN:CPN_TYP","Coupon Type","STRING",24,"Char (24)",null,0,0,"Type of interest to be paid to investors. Mortgages: For Canadian Pools, this is intentionally left blank",false),
	FIELD25("BDY:CPN:MULTI_CPN_SCHEDULE_TYP","Multi Coupon Schedule Type","STRING",4,"Integer (4)","Multi-cupon schedule",0,0,"This field is used to clarify the output of SC011 MULTI_CPN_SCHEDULE. SC020 will return a 0, 1, or 2",false),
	FIELD26("BDY:CPN:BH_MULTI_CPN_SCHEDULE","Multi Coupon Schedule Bulk Header","TABLEHDR",512,"MULTI_CPN_SCHEDULE","cupon schedulle",0,0,"Returns a list of column headers for Multi Coupon Schedule",false),
	FIELD27("BDY:CPN:MULTI_CPN_SCHEDULE:TYPE","Multi Coupon Schedule cell type","STRING",128,"MULTI_CPN_SCHEDULE","cupon schedulle",0,0,"Used when a bond does not have a fixed coupon rate for the life of the bond type cell type",true),
	FIELD28("BDY:CPN:MULTI_CPN_SCHEDULE:VALUE","Multi Coupon Schedule value","TABLE",128,"MULTI_CPN_SCHEDULE","cupon schedulle",0,0,"Used when a bond does not have a fixed coupon rate for the life of the bond value cell value",false),
	FIELD29("BDY:CPN:PAR_AMT","Par Amount","STRING",23,"Real (23,9)","Additional notes",0,0,"Par amount is synonymous with face amount.",false),
	FIELD30("BDY:CPN:CPN_CRNCY","Coupon Currency","STRING",8,"Char (8)","Additional notes",0,0,"The currency the security's coupon is paid in",false),
	FIELD31("BDY:CPN:MATURITY","Maturity","STRING",10,"Date","Additional notes",0,0,"Date the principal of a security is due and payable",false),
	FIELD32("BDY:CPN:SECURITY_DES","Security Description","STRING",30,"Char (30)","Additional notes",0,0,"Bloomberg description of security",true),
	FIELD33("BDY:CPN:ISSUER","Issuer","STRING",30,"Char (30)","Additional notes",0,0,"Name of the issuing entity of the security",false),
	FIELD34("BDY:CPN:CPN_FREQ","Coupon Frequency","STRING",4,"Integer (4)","Additional notes",0,0,"Number of times per year interest is paid",false),
	FIELD35("BDY:CPN:RESET_IDX","Reset Index","STRING",15,"Char (15)","Additional notes",0,0,"The index (benchmark) off which the interest rate is spread",false),
	FIELD36("BDY:CPN:CPN_ASOF_DT","Coupon as of Date","STRING",10,"Date","Additional notes",0,0,"As of date of the most recently reported coupon for floating rate notes or securities with a variable coupon rate.",false),
	FIELD37("BDY:CPN:FLT_DAYS_PRIOR","Float Days Prior","STRING",4,"Integer (4)","Additional notes",0,0,"The number of days prior to the next coupon date the security will refix the interest rate",false),
	FIELD38("BDY:CPN:FINAL_MATURITY","Final Maturity","STRING",10,"Date","Additional notes",0,0,"The legal final maturity of the security as stated in the official documentation",false),
	FIELD39("BDY:CPN:LONG_COMP_NAME","Long Company Name","STRING",100,"Char (100)","Additional notes",0,0,"The official long name of the company",false),
	FIELD40("BDY:CPN:BH_DES_CASH_FLOW","Bond Cash Flow Bulk Header","TABLEHDR",128,"DES_CASH_FLOW","Cash flow",0,0,"Returns a list of column headers for Cash Flow Schedule (DS367, DES_CASH_FLOW) using standard data elements or bulk column names",false),
	FIELD41("BDY:CPN:BH_DES_CASH_FLOW:BC_DT","Date","TABLEDES",10,"Date","Cash flow",0,0,"Date Column Information. This column name is used to document data elements returned for a bulk field",false),
	FIELD42("BDY:CPN:BH_DES_CASH_FLOW:BC_DES_CASH_FLOW_CPN_AMT","Cash Flow Coupon Amount","TABLEDES",10,"Real (10,3)","Cash flow",0,0,"Cash Flow Coupon Amount Column Information. This column name is used to document data elements returned for a bulk field",false),
	FIELD43("BDY:CPN:BH_DES_CASH_FLOW:BC_DES_CASH_FLOW_PRINC_AMT","Cash Flow Principal Amount","TABLEDES",12,"Real (12,3)","Cash flow",0,0,"Cash Flow Principal Amount Column Information. This column name is used to document data elements returned for a bulk field",false),
	FIELD44("BDY:CPN:DES_CASH_FLOW:TYPE","Cash Flow Schedule","STRING",128,"DES_CASH_FLOW","Cash flow",0,0,"This field returns the securities cashflow schedule. (cell type)",true),
	FIELD45("BDY:CPN:DES_CASH_FLOW:VALUE","Cash Flow Schedule","TABLE",128,"DES_CASH_FLOW","Cash flow",0,0,"This field returns the securities cashflow schedule. (cell value)",false),
	FIELD46("BDY:CPN:FIRST_CPN_DT","First Coupon Payment Date","STRING",10,"Date","Additional notes",0,0,"The first coupon payment date following the initial settlement date",false),
	FIELD47("BDY:CPN:PREV_CPN_DT","Previous Coupon Settle Date","STRING",10,"Date","Additional notes",0,0,"The date on which the previous coupon was paid",false),
	FIELD48("BDY:CPN:NXT_CPN_DT","Next Coupon Settle Date","STRING",10,"Date","Additional notes",0,0,"The date on which the next coupon will be paid",false),
	FIELD49("BDY:CPN:CP_NXT_RESET_DT","Next Reset Date","STRING",10,"Date","Additional notes",0,0,"The next day the coupon resets",false),
	FIELD50("BDY:CPN:LAST_UPDATE","Time/Date of Last Update","STRING",10,"Date/Time","Additional notes",0,0,"Either the time or date at which the security last traded/updated",false),
	FIELD51("BDY:CPN:LAST_UPDATE_DT","Date Of Last Update","STRING",10,"Date","Additional notes",0,0,"Date the security last traded/updated. All values are translated into the user's date and time",false),
	FIELD52("BDY:CPN:ANNOUNCE_DT","Announce Date","STRING",10,"Date","Additional notes",0,0,"The date the security is announced and offered to the public",true),
	FIELD53("BDY:CPN:DES_NOTES","DES Notes","STRING",1120,"Char (1120)","Additional notes",0,0,"Contains information relevant to the issue.",false);
	
	
	private String path=null; 
	private String fieldName=null; 
	private String fieldType=null; 
	private int fieldLength=0; 
	private String fieldFormat=null; 
	private String displayGroup=null; 
	private int displayRow=0; 
	private int displayColumn=0; 
	private String description=null;
	private boolean hidden=false;

	
	CAMessageTypeCORPPSCField(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
		this.path=_path;
		this.fieldName=_fieldName;
		this.fieldLength=_fieldLength;
		this.fieldType=_fieldType;
		this.fieldFormat=_fieldFormat;
		this.displayGroup=_displayGroup;
		this.displayRow=_displayRow;
		this.displayColumn=_displayColumn;
		this.description=_description;
		this.hidden=_hidden;
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
	public String getFieldType() {
		return fieldType;
	}
	public String getFieldFormat() {
		return fieldFormat;
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
}
