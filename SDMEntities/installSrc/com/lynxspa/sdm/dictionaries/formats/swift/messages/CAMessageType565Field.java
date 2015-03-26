package com.lynxspa.sdm.dictionaries.formats.swift.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageType565Field implements CAMessageTypeFieldsDictAdapter{

	FIELD1("1:APPID:","application","STRING",1,null,"message.info",0,0,"Application ID: F = FIN(financial application),A = GPA(general purpose application),L = GPA(for logins, and so on)",true),
	FIELD2("1:SRVID:","service","INTEGER",2,null,"message.info",0,0,"Service ID: 01 = FIN/GPA, 21 = ACK/NAK",true),
	FIELD3("1:TERM:","terminal","STRING",12,null,"message.info",0,0,"Logical terminal (LT) address.",true),
	FIELD4("1:SESSN:","session","INTEGER",4,null,"message.info",0,0,"Session number. It is generated by the user's computer and is padded with zeros.",true),
	FIELD5("1:SEQN:","sequence","INTEGER",6,null,"message.info",0,0,"Sequence number that is generated by the user's computer. It is padded with zeros.",true),
	FIELD6("2:IO:","input output","STRING",1,null,"message.info",0,0,"Input/Output indicator",true),
	FIELD7("2:MSGT:","message type","INTEGER",3,null,"message.info",0,0,"Message type",true),
	FIELD8("2:I:ADD:","receivers address","STRING",12,null,"message.info",0,0,"Receiver's address with X in position 9/ It is padded with Xs if no branch is required.",true),
	FIELD9("2:I:MSGP:","message priority","STRING",1,null,"message.info",0,0,"The message priority as follows: S = System, N = Normal, U = Urgent",true),
	FIELD10("2:I:DMF:","delivery monitoring","INTEGER",1,null,"message.info",0,0,"Delivery monitoring field is as follows: 1 = Non delivery warning (MT010), 2 = Delivery notification (MT011), 3 = Both valid = U",true),
	FIELD11("2:I:OBP:","obsolescence period","INTEGER",3,null,"message.info",0,0,"Obsolescence period. It specifies when a non-delivery notification is generated as follows:",true),
	FIELD12("2:O:MIR:TIME","input time respect sender","DATE",4,"HHmm","message.info",0,0,"Input time with respect to the sender",true),
	FIELD13("2:O:MIR:DATE","input date respect sender","DATE",6,"yyMMdd","message.info",0,0,"Input date with respect to the sender",true),
	FIELD14("2:O:MIR:ADD:","sender address","STRING",12,null,"message.info",0,0,"The Message Input Reference (MIR), including input date, with Sender's address",true),
	FIELD15("2:O:MIR:SESSN:","sender session","INTEGER",4,null,"message.info",0,0,"Sender session",true),
	FIELD16("2:O:MIR:SEQN:","sender sequence","INTEGER",6,null,"message.info",0,0,"Sender sequence",true),
	FIELD17("2:O:DATE:","output date respect receiver","DATE",6,"yyMMdd","message.info",0,0,"Output date with respect to Receiver",true),
	FIELD18("2:O:TIME:","output time respect receiver","DATE",4,"HHmm","message.info",0,0,"Output time with respect to Receiver",true),
	FIELD19("2:O:MSGP:","message priority","STRING",1,null,"message.info",0,0,"The message priority as follows: S = System, N = Normal, U = Urgent",true),
	FIELD20("3:113:","optional banking priority code","STRING",4,null,"message.user.info",0,0,"Optional banking priority code",true),
	FIELD21("3:108:","message user reference","STRING",0,null,"message.user.info",0,0,"Message User Reference",true),
	FIELD22("4:16R:GENL:20::CORP/","corporate action reference","STRING",0,null,null,0,0,"Reference assigned by the account servicer to unambiguously identify a corporate action event.",false),
	FIELD23("4:16R:GENL:20::SEME//","sender message reference","STRING",0,null,null,0,0,"Reference assigned by the Sender to unambiguously identify the message.",false),
	FIELD24("4:16R:GENL:23:CANC/","cancellation","STRING",0,null,null,0,0,"This is a request to cancel a previously sent instruction",false),
	FIELD25("4:16R:GENL:23:NEWM/","new","STRING",0,null,null,0,0,"This is a new instruction.",false),
	FIELD26("4:16R:GENL:22::CAEV/","corporate action event indicator","STRING",0,null,null,0,0,"Type of CA event to which the message relates.",false),
	FIELD27("4:16R:GENL:98::PREP/","preparation date","STRING",0,null,null,0,0,"Date at which message was prepared.",false),
	FIELD28("4:16R:GENL:16R:LINK:22::LINK/","linkage type indicator","STRING",0,null,null,0,0,"When the message is to be executed relative to the transaction referenced in the sequence.",false),
	FIELD29("4:16R:GENL:16R:LINK:13::LINK/","linked message","STRING",0,null,null,0,0,"Message type number / name of the message referenced in the linkage sequence.",false),
	FIELD30("4:16R:GENL:16R:LINK:20::CORP/","corporate action reference","STRING",0,null,null,0,0,"Reference assigned by the account servicer to unambiguously identify a related CA event.",false),
	FIELD31("4:16R:GENL:16R:LINK:20::PREV/","previous message reference","STRING",0,null,null,0,0,"Reference of the linked message which was previously sent.",false),
	FIELD32("4:16R:GENL:16R:LINK:20::RELA/","related message reference","STRING",0,null,null,0,0,"Reference of the linked message which was previously received.",false),
	FIELD33("4:16R:USECU:35:","identification of security","STRING",0,null,null,0,0,"Identifies the financial instrument.",false),
	FIELD34("4:16R:USECU:16R:FIA:94::PLIS/","place of listing","STRING",0,null,null,0,0,"Identifies the place where the referenced financial instrument is listed.",false),
	FIELD35("4:16R:USECU:16R:FIA:22::MICO/","method of interest computation indicator","STRING",0,null,null,0,0,"Specifies the computation method of (accrued) interest of the financial instrument.",false),
	FIELD36("4:16R:USECU:16R:FIA:12::CLAS/","classification type","STRING",0,null,null,0,0,"Classification type of the financial instrument, e.g., ISO Classification of Financial instrument (CFI).",false),
	FIELD37("4:16R:USECU:16R:FIA:11::DENO/","currency of denomination","STRING",0,null,null,0,0,"Currency in which a financial instrument is currently denominated.",false),
	FIELD38("4:16R:USECU:16R:FIA:98::CALD/","call date","STRING",0,null,null,0,0,"Date on which a financial instrument is called away/redeemed before its scheduled maturity.",false),
	FIELD39("4:16R:USECU:16R:FIA:98::CONV/","conversion date","STRING",0,null,null,0,0,"Deadline by which a convertible security must be converted, according to the terms of the issue.",false),
	FIELD40("4:16R:USECU:16R:FIA:98::COUP/","coupon date","STRING",0,null,null,0,0,"Next payment date of an interest bearing financial instrument.",false),
	FIELD41("4:16R:USECU:16R:FIA:98::DDTE/","dated date","STRING",0,null,null,0,0,"Date on which an interest bearing financial instrument begins to accrue interest.",false),
	FIELD42("4:16R:USECU:16R:FIA:98::EXPI/","expiry date","STRING",0,null,null,0,0,"Date on which an order expires or at which a privilege or offer terminates.",false),
	FIELD43("4:16R:USECU:16R:FIA:98::FRNR/","floating rate note reset date","STRING",0,null,null,0,0,"Date on which the interest rate of an interest bearing financial instrument will be/was calculated and reset, according to the t",false),
	FIELD44("4:16R:USECU:16R:FIA:98::ISSU/","issue date","STRING",0,null,null,0,0,"Date on which the financial instrument is issued.",false),
	FIELD45("4:16R:USECU:16R:FIA:98::MATU/","maturity date","STRING",0,null,null,0,0,"Date on which a financial instrument becomes due and assets are to be repaid.",false),
	FIELD46("4:16R:USECU:16R:FIA:98::PUTT/","put date","STRING",0,null,null,0,0,"Date on which a holder of a financial instrument has the right to request redemption of the principal amount prior to its schedu",false),
	FIELD47("4:16R:USECU:16R:FIA:92::INTR/","interest rate","STRING",0,null,null,0,0,"Annual rate of a financial instrument.",false),
	FIELD48("4:16R:USECU:16R:FIA:92::NWFC/","next factor","STRING",0,null,null,0,0,"Factor used to calculate the value of the outstanding principal of the financial instrument (for factored securities) that will ",false),
	FIELD49("4:16R:USECU:16R:FIA:92::NXRT/","next interest rate","STRING",0,null,null,0,0,"Interest rate applicable to the next interest payment period in relation to variable rate instruments.",false),
	FIELD50("4:16R:USECU:16R:FIA:92::PRFC/","previous factor","STRING",0,null,null,0,0,"Factor used to calculate the value of the outstanding principal of the financial instrument (for factored securities) until the ",false),
	FIELD51("4:16R:USECU:16R:FIA:36::MIEX/","minimum exercisable quantity","STRING",0,null,null,0,0,"Minimum quantity of financial instrument or lot of rights/warrants that must be exercised.",false),
	FIELD52("4:16R:USECU:16R:FIA:36::MILT/","minimum exercisable multiple quantity","STRING",0,null,null,0,0,"Minimum multiple quantity of financial instrument or lot of rights/warrants that must be exercised.",false),
	FIELD53("4:16R:USECU:16R:FIA:36::MINO/","minimum nominal quantity minimum nominal value quantity","STRING",0,null,null,0,0,"Minimum nominal quantity of financial instrument that must be purchased/sold.",false),
	FIELD54("4:16R:USECU:16R:FIA:36::SIZE/","contract size quantity ","STRING",0,null,null,0,0,"Ratio or multiplying factor used to convert one contract into a financial instrument quantity.",false),
	FIELD55("4:16R:USECU:16R:ACCTINFO:95::ACOW/","account owner","STRING",0,null,null,0,0,"Party that owns the account.",false),
	FIELD56("4:16R:USECU:16R:ACCTINFO:97::SAFE/","safekeeping account","STRING",0,null,null,0,0,"Account where financial instruments are maintained",false),
	FIELD57("4:16R:USECU:16R:ACCTINFO:94::SAFE/","places of safekeeping","STRING",0,null,null,0,0,"Location where the financial instruments are/will be safekept.",false),
	FIELD58("4:16R:USECU:16R:ACCTINFO:93::BLOK/","blocked balance","STRING",0,null,null,0,0,"Balance of financial instruments that are blocked.",false),
	FIELD59("4:16R:USECU:16R:ACCTINFO:93::BORR/","borrowed balance","STRING",0,null,null,0,0,"Balance of financial instruments that have been borrowed from another party",false),
	FIELD60("4:16R:USECU:16R:ACCTINFO:93::COLI/","collateral in balance","STRING",0,null,null,0,0,"Balance of securities that belong to a third party and that are held for the purpose of collateralisation.",false),
	FIELD61("4:16R:USECU:16R:ACCTINFO:93::COLO/","collateral out balance","STRING",0,null,null,0,0,"Balance of securities that belong to the safekeeping account indicated within this message, and are deposited with a third party",false),
	FIELD62("4:16R:USECU:16R:ACCTINFO:93::ELIG/","total eligible for corporate action balance","STRING",0,null,null,0,0,"Total balance of securities eligible for this corporate action event. The entitlement calculation is based on this balance",false),
	FIELD63("4:16R:USECU:16R:ACCTINFO:93::LOAN/","on loan balance ","STRING",0,null,null,0,0,"Balance of financial instruments that have been loaned to a third party",false),
	FIELD64("4:16R:USECU:16R:ACCTINFO:93::NOMI/","registered balance","STRING",0,null,null,0,0,"Balance of financial instruments that are registered (in the name of a nominee name or of the beneficial owner).",false),
	FIELD65("4:16R:USECU:16R:ACCTINFO:93::PEND/","pending delivery balance","STRING",0,null,null,0,0,"Balance of financial instruments that are pending delivery.",false),
	FIELD66("4:16R:USECU:16R:ACCTINFO:93::PENR/","pending receipt balance","STRING",0,null,null,0,0,"Balance of financial instruments that are pending receipt.",false),
	FIELD67("4:16R:USECU:16R:ACCTINFO:93::REGO/","out for registration balance","STRING",0,null,null,0,0,"Balance of financial instruments currently being processed by the institution responsible for registering the new beneficial own",false),
	FIELD68("4:16R:USECU:16R:ACCTINFO:93::SETT/","settlement position balance","STRING",0,null,null,0,0,"Balance of securities representing only settled transactions; pending transactions not included.",false),
	FIELD69("4:16R:USECU:16R:ACCTINFO:93::SPOS/","street position balance","STRING",0,null,null,0,0,"Balance of financial instruments that remain registered in the name of the prior beneficial owner.",false),
	FIELD70("4:16R:USECU:16R:ACCTINFO:93::TRAD/","trade date position balance","STRING",0,null,null,0,0,"Balance of securities based on trade date, e.g., includes all pending transactions in addition to the balance of settled transac",false),
	FIELD71("4:16R:USECU:16R:ACCTINFO:93::TRAN/","in transhipment balance","STRING",0,null,null,0,0,"Balance of physical securities that are in the process of being transferred from one depository/agent to another.",false),
	FIELD72("4:16R:BENODET:95::ALTE/","alternate id","STRING",0,null,null,0,0,"Alternate identification for a party.",false),
	FIELD73("4:16R:BENODET:95::OWND/","beneficial owner�s id","STRING",0,null,null,0,0,"Party that is the beneficial owner of the specified quantity of securities.",false),
	FIELD74("4:16R:BENODET:94::DOMI/","country of domicile","STRING",0,null,null,0,0,"Country in which a person is permanently domiciled (the place of a person�s permanent home).",false),
	FIELD75("4:16R:BENODET:94::NDOM/","country of non-domicile","STRING",0,null,null,0,0,"Country in which a person is not domiciled",false),
	FIELD76("4:16R:BENODET:36::OWND/","quantity of securities owned","STRING",0,null,null,0,0,"Quantity of securities belonging to the beneficial owner specified.",false),
	FIELD77("4:16R:BENODET:70::DECL/","declaration details","STRING",0,null,null,0,0,"Provides details relative to the beneficial owner not included within structured fields of this message.",false),
	FIELD78("4:16R:CAINST:13::CAON/","ca option number","STRING",0,null,null,0,0,"Number identifying the available corporate action options.",false),
	FIELD79("4:16R:CAINST:22::CHAN/","change type indicator","STRING",0,null,null,0,0,"Specifies the type of change announced.",false),
	FIELD80("4:16R:CAINST:22::DISF/","disposition of fractions indicator","STRING",0,null,null,0,0,"Specifies how fractional amount/quantities are treated.",false),
	FIELD81("4:16R:CAINST:22::CAOP/","corporate action option code indicator","STRING",0,null,null,0,0,"Specifies the corporate action options available to the account owner.",false),
	FIELD82("4:16R:CAINST:11::FXIB/","currency to buy","STRING",0,null,null,0,0,"Account servicer is instructed to buy the indicated currency after the receipt of cash proceeds.",false),
	FIELD83("4:16R:CAINST:11::FXIS/","currency to sell","STRING",0,null,null,0,0,"Account servicer is instructed to sell the indicated currency in order to obtain the necessary currency to fund the transaction ",false),
	FIELD84("4:16R:CAINST:11::OPTN/","currency option","STRING",0,null,null,0,0,"Currency in which the cash disbursed from an interest or dividend payment is offered.",false),
	FIELD85("4:16R:CAINST:35:","identification of security","STRING",0,null,null,0,0,"Identifies the financial instrument.",false),
	FIELD86("4:16R:CAINST:36::COND/","conditional quantity","STRING",0,null,null,0,0,"Minimum quantity of securities to be accepted (used in the framework of conditional privilege on election). In case of proration",false),
	FIELD87("4:16R:CAINST:36::QOVE/","quantity over and above normal ensured entitlement","STRING",0,null,null,0,0,"Quantity instructed to be received over and above normal ensured entitlement",false),
	FIELD88("4:16R:CAINST:36::QINS/","quantity of securities instructed","STRING",0,null,null,0,0,"Quantity of underlying securities to which this instruction applies.",false),
	FIELD89("4:16R:CAINST:36::QREC/","quantity to receive","STRING",0,null,null,0,0,"Quantity of the benefits that the account owner wants to receive, e.g., as a result of dividend reinvestment.",false),
	FIELD90("4:16R:CAINST:98::EXRQ/","execution requested date/time","STRING",0,null,null,0,0,"Date/time at which the instructing party requests the instruction to be executed.",false),
	FIELD91("4:16R:CAINST:92::OFFR/","proposed rate","STRING",0,null,null,0,0,"Rate proposed in a remarketing of variable rate notes.",false),
	FIELD92("4:16R:CAINST:92::TAXB/","requested taxation rate","STRING",0,null,null,0,0,"Requested tax rate in case of breakdown of tax rate, e.g., used for adjustment of tax rate. This is the new requested applicable",false),
	FIELD93("4:16R:CAINST:92::OSUB/","over-subscription rate","STRING",0,null,null,0,0,"Rate of allowed over-subscription.",false),
	FIELD94("4:16R:CAINST:90::EXER/","exercise price","STRING",0,null,null,0,0,"1. Price at which security will be purchased/sold if warrant is exercised, represented either as an actual amount (option B) or ",false),
	FIELD95("4:16R:CAINST:90::INDC/","indicative price","STRING",0,null,null,0,0,"Estimated price, e.g., for valuation purposes.",false),
	FIELD96("4:16R:CAINST:90::ISSU/","issue price","STRING",0,null,null,0,0,"Initial issue price of a financial instrument.",false),
	FIELD97("4:16R:CAINST:90::MRKT/","market price","STRING",0,null,null,0,0,"Last reported/known price of a financial instrument in a market.",false),
	FIELD98("4:16R:CAINST:90::PRPP/","generic cash price paid per product","STRING",0,null,null,0,0,"Generic cash price paid per product by the underlying security holder either as a percentage or an amount, e.g., reinvestment pr",false),
	FIELD99("4:16R:CAINST:90::OFFR/","generic cash price received per product","STRING",0,null,null,0,0,"Generic cash price received per product by the underlying security holder either as a percentage or an amount, e.g., redemption ",false),
	FIELD100("4:16R:CAINST:70::COMP/","information to be complied with","STRING",0,null,null,0,0,"Provides information conditions to the account owner that are to be complied with, e.g., not open to US/Canadian residents, QIB ",false),
	FIELD101("4:16R:CAINST:70::DISC/","disclaimer","STRING",0,null,null,0,0,"Disclaimer relative to the information provided in the message. It may be ignored for automated processing. No information about",false),
	FIELD102("4:16R:CAINST:70::DLVR/","delivery details","STRING",0,null,null,0,0,"Provides additional information on the delivery details of the out-turned (derived) securities. This narrative is only to be use",false),
	FIELD103("4:16R:CAINST:70::FXIN/","foreign exchange instructions narrative","STRING",0,null,null,0,0,"Provides additional details pertaining to foreign exchange instructions.",false),
	FIELD104("4:16R:CAINST:70::INST/","corporate action instructions narrative","STRING",0,null,null,0,0,"Provides additional details pertaining to the corporate action instruction.",false),
	FIELD105("4:16R:ADDINFO:70::ADTX/","additional text","STRING",0,null,null,0,0,"Provides additional information or specifies in more detail the content of a message. This field may only be used when the infor",false),
	FIELD106("4:16R:ADDINFO:70::DISC/","disclaimer","STRING",0,null,null,0,0,"Provides a disclaimer relative to the information provided in the message. It may be ignored for automated processing.",false),
	FIELD107("4:16R:ADDINFO:70::PACO/","party narrative","STRING",0,null,null,0,0,"Provides additional information regarding the party, e.g., the contact unit or person responsible for the transaction identified",false),
	FIELD108("4:16R:ADDINFO:70::REGI/","registration details","STRING",0,null,null,0,0,"Provides information required for the registration.",false),
	FIELD109("4:16R:ADDINFO:70::TXNR/","narrative version","STRING",0,null,null,0,0,"Provides information that can be ignored for automated processing; - reiteration of information that has been included within st",false),
	FIELD110("4:16R:ADDINFO:95::MEOR/","originator of message","STRING",0,null,null,0,0,"Party that originated the message, if other than the Sender",false),
	FIELD111("4:16R:ADDINFO:95::MERE/","recipient of message","STRING",0,null,null,0,0,"Party that is the final destination of the message, if other than the Receiver.",false),
	FIELD112("5:MAC:","message authentication code","STRING",0,null,"message.trailer.info",0,0,"Message authentication code",true),
	FIELD113("5:CHK:","checksum","STRING",0,null,"message.trailer.info",0,0,"Checksum",true),
	FIELD114("5:PDE:","possible duplicates emission","STRING",0,null,"message.trailer.info",0,0,"Possible duplicates emission",true),
	FIELD115("5:DLM:","urgent","STRING",0,null,"message.trailer.info",0,0,"urgent",true),
	FIELD116("S:SAC:","sac","STRING",0,null,"message.trailer.info",0,0,"sac",true),
	FIELD117("S:COP:","cop","STRING",0,null,"message.trailer.info",0,0,"cop",true);	


	private String path=null; 
	private String fieldName=null; 
	private int fieldLength=0; 
	private String fieldType=null; 
	private String fieldFormat=null; 
	private String displayGroup=null; 
	private int displayRow=0; 
	private int displayColumn=0; 
	private String description=null;
	private boolean hidden=false;

	
	CAMessageType565Field(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
