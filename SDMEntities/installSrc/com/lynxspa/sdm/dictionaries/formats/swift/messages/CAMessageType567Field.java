package com.lynxspa.sdm.dictionaries.formats.swift.messages;


import com.lynxspa.sdm.installer.adapters.formats.fields.CAMessageTypeFieldsDictAdapter;


public enum CAMessageType567Field implements CAMessageTypeFieldsDictAdapter{

	FIELD1("4:16R:CADETL:19::SOIC/","sundry / other income amount","STRING",0,null,null,0,0,"Amount of money related to taxable income that cannot be categorised.",false),
	FIELD2("4:16R:CADETL:19::SPCN/","special concessions","STRING",0,null,null,0,0,"Amount of drawdown or other reduction from or in addition to the deal price.",false),
	FIELD3("4:16R:CADETL:19::STAM/","stamp duty","STRING",0,null,null,0,0,"Amount of stamp duty.",false),
	FIELD4("4:16R:CADETL:19::STEX/","stock exchange tax","STRING",0,null,null,0,0,"Amount of stock exchange tax.",false),
	FIELD5("4:16R:CADETL:19::SUBS/","additional subscription costs","STRING",0,null,null,0,0,"Additional costs - coming on top of the subscription costs - which the subscriber should pay as per the subscription process. No",false),
	FIELD6("4:16R:CADETL:19::TAXC/","amount of tax credit","STRING",0,null,null,0,0,"Amount of taxes that have been previously paid in relation to the taxable event.",false),
	FIELD7("4:16R:CADETL:19::TAXR/","withholding tax amount","STRING",0,null,null,0,0,"Amount of a cash distribution that will be withheld by a tax authority",false),
	FIELD8("4:16R:CADETL:19::TRAN/","transfer tax","STRING",0,null,null,0,0,"Amount of tax levied on a transfer of ownership of financial instrument.",false),
	FIELD9("4:16R:CADETL:19::TRAX/","transaction tax","STRING",0,null,null,0,0,"Amount of transaction tax.",false),
	FIELD10("4:16R:CADETL:19::TXDF/","tax deferred amount","STRING",0,null,null,0,0,"Amount of income eligible for deferred taxation.",false),
	FIELD11("4:16R:CADETL:19::TXFR/","tax free amount","STRING",0,null,null,0,0,"Amount of money that has not been subject to taxation.",false),
	FIELD12("4:16R:CADETL:19::TXRC/","reclaim of taxes","STRING",0,null,null,0,0,"Amount that was paid in excess of actual tax obligation and was reclaimed.",false),
	FIELD13("4:16R:CADETL:19::UNFR/","unfranked amount","STRING",0,null,null,0,0,"Amount resulting from an unfranked dividend paid by a company; the amount doesn’t include tax credit and is subject to withholdi",false),
	FIELD14("4:16R:CADETL:19::VATA/","value-added tax","STRING",0,null,null,0,0,"Amount of value added tax.",false),
	FIELD15("4:16R:CADETL:19::WITF/","withholding of foreign tax","STRING",0,null,null,0,0,"Amount of money withheld by the jurisdiction in which the income was originally paid, for which relief at source and/or reclaim ",false),
	FIELD16("4:16R:CADETL:19::WITL/","withholding of local tax","STRING",0,null,null,0,0,"Amount of money withheld by the jurisdiction in which the account owner is located, for which relief at source and/or reclaim ma",false),
	FIELD17("4:16R:CADETL:93::ELIG/","total eligible for corporate action balance","STRING",0,null,null,0,0,"Total balance of securities eligible for this corporate action event. The entitlement calculation is based on this balance",false),
	FIELD18("4:16R:CADETL:93::INBA/","instructed balance","STRING",0,null,null,0,0,"Balance of instructed position.",false),
	FIELD19("4:16R:CADETL:93::UNBA/","uninstructed balance","STRING",0,null,null,0,0,"Balance of uninstructed position.",false),
	FIELD20("4:16R:ADDINFO:70::ADTX/","additional text","STRING",0,null,null,0,0,"Provides additional information or specifies in more detail the content of a message. This field may only be used when the infor",false),
	FIELD21("4:16R:ADDINFO:70::COMP/","information to be complied with","STRING",0,null,null,0,0,"Provides information conditions to the account owner that are to be complied with, e.g., not open to US/Canadian residents, QIB ",false),
	FIELD22("4:16R:ADDINFO:70::INCO/","information conditions","STRING",0,null,null,0,0,"Provides conditional information related to the event, e.g., an offer is subject to 50% acceptance, the offeror allows the secur",false),
	FIELD23("4:16R:ADDINFO:70::PACO/","party narrative","STRING",0,null,null,0,0,"Provides additional information regarding the party, e.g., the contact unit or person responsible for the transaction identified",false),
	FIELD24("4:16R:ADDINFO:95::MEOR/","originator of message","STRING",0,null,null,0,0,"Party that originated the message, if other than the Sender",false),
	FIELD25("4:16R:ADDINFO:95::MERE/","recipient of message","STRING",0,null,null,0,0,"Party that is the final destination of the message, if other than the Receiver.",false),
	FIELD26("5:MAC:","message authentication code","STRING",0,null,"message.trailer.info",0,0,"Message authentication code",true),
	FIELD27("5:CHK:","checksum","STRING",0,null,"message.trailer.info",0,0,"Checksum",true),
	FIELD28("5:PDE:","possible duplicates emission","STRING",0,null,"message.trailer.info",0,0,"Possible duplicates emission",true),
	FIELD29("5:DLM:","urgent","STRING",0,null,"message.trailer.info",0,0,"urgent",true),
	FIELD30("S:SAC:","sac","STRING",0,null,"message.trailer.info",0,0,"sac",true),
	FIELD31("S:COP:","cop","STRING",0,null,"message.trailer.info",0,0,"cop",true),
	FIELD32("1:APPID:","application","STRING",1,null,"message.info",0,0,"Application ID: F = FIN(financial application),A = GPA(general purpose application),L = GPA(for logins, and so on)",true),
	FIELD33("1:SRVID:","service","INTEGER",2,null,"message.info",0,0,"Service ID: 01 = FIN/GPA, 21 = ACK/NAK",true),
	FIELD34("1:TERM:","terminal","STRING",12,null,"message.info",0,0,"Logical terminal (LT) address.",true),
	FIELD35("1:SESSN:","session","INTEGER",4,null,"message.info",0,0,"Session number. It is generated by the user's computer and is padded with zeros.",true),
	FIELD36("1:SEQN:","sequence","INTEGER",6,null,"message.info",0,0,"Sequence number that is generated by the user's computer. It is padded with zeros.",true),
	FIELD37("2:IO:","input output","STRING",1,null,"message.info",0,0,"Input/Output indicator",true),
	FIELD38("2:MSGT:","message type","INTEGER",3,null,"message.info",0,0,"Message type",true),
	FIELD39("2:I:ADD:","receivers address","STRING",12,null,"message.info",0,0,"Receiver's address with X in position 9/ It is padded with Xs if no branch is required.",true),
	FIELD40("2:I:MSGP:","message priority","STRING",1,null,"message.info",0,0,"The message priority as follows: S = System, N = Normal, U = Urgent",true),
	FIELD41("2:I:DMF:","delivery monitoring","INTEGER",1,null,"message.info",0,0,"Delivery monitoring field is as follows: 1 = Non delivery warning (MT010), 2 = Delivery notification (MT011), 3 = Both valid = U",true),
	FIELD42("2:I:OBP:","obsolescence period","INTEGER",3,null,"message.info",0,0,"Obsolescence period. It specifies when a non-delivery notification is generated as follows:",true),
	FIELD43("2:O:MIR:TIME","input time respect sender","DATE",4,"HHmm","message.info",0,0,"Input time with respect to the sender",true),
	FIELD44("2:O:MIR:DATE","input date respect sender","DATE",6,"yyMMdd","message.info",0,0,"Input date with respect to the sender",true),
	FIELD45("2:O:MIR:ADD:","sender address","STRING",12,null,"message.info",0,0,"The Message Input Reference (MIR), including input date, with Sender's address",true),
	FIELD46("2:O:MIR:SESSN:","sender session","INTEGER",4,null,"message.info",0,0,"Sender session",true),
	FIELD47("2:O:MIR:SEQN:","sender sequence","INTEGER",6,null,"message.info",0,0,"Sender sequence",true),
	FIELD48("2:O:DATE:","output date respect receiver","DATE",6,"yyMMdd","message.info",0,0,"Output date with respect to Receiver",true),
	FIELD49("2:O:TIME:","output time respect receiver","DATE",4,"HHmm","message.info",0,0,"Output time with respect to Receiver",true),
	FIELD50("2:O:MSGP:","message priority","STRING",1,null,"message.info",0,0,"The message priority as follows: S = System, N = Normal, U = Urgent",true),
	FIELD51("3:113:","optional banking priority code","STRING",4,null,"message.user.info",0,0,"Optional banking priority code",true),
	FIELD52("3:108:","message user reference","STRING",0,null,"message.user.info",0,0,"Message User Reference",true),
	FIELD53("4:16R:GENL:20::CORP/","corporate action reference","STRING",0,null,null,0,0,"Reference assigned by the account servicer to unambiguously identify a corporate action event.",false),
	FIELD54("4:16R:GENL:20::SEME/","sender message reference","STRING",0,null,null,0,0,"Reference assigned by the Sender to unambiguously identify the message.",false),
	FIELD55("4:16R:GENL:23:","message function","STRING",0,null,null,0,0,"Message requesting the cancellation of a previously sent message.",true),
	FIELD56("4:16R:GENL:22::CAEV/","corporate action event indicator","STRING",0,null,null,0,0,"Specifies the type of corporate event.",false),
	FIELD57("4:16R:GENL:98::PREP/","preparation date","STRING",0,null,null,0,0,"Date at which message was prepared.",false),
	FIELD58("4:16R:GENL:16R:LINK:13::LINK/","linked message","STRING",0,null,null,0,0,"Message type number / message identifier of the message referenced in the linkage sequence.",false),
	FIELD59("4:16R:GENL:16R:LINK:20::CACN/","case number","STRING",0,null,null,0,0,"Reference assigned by a court to a class action.",false),
	FIELD60("4:16R:GENL:16R:LINK:20::CORP/","corporate action reference","STRING",0,null,null,0,0,"Reference assigned by the account servicer to unambiguously identify a corporate action event.",false),
	FIELD61("4:16R:GENL:16R:LINK:20::PREV/","previous reference message","STRING",0,null,null,0,0,"Message reference of the linked message which was previously sent.",false),
	FIELD62("4:16R:GENL:16R:LINK:20::RELA/","related reference message","STRING",0,null,null,0,0,"Message reference of the linked message which was previously received.",false),
	FIELD63("4:16R:GENL:16R:STAT:25::CPRC/","cancellation processing status","STRING",0,null,null,0,0,"Provides the status of a cancellation request",false),
	FIELD64("4:16R:GENL:16R:STAT:25::EPRC/","corporate action event processing status","STRING",0,null,null,0,0,"Provides the status of a corporate action or the status of a payment",false),
	FIELD65("4:16R:GENL:16R:STAT:25::ESTA/","corporate action event stage","STRING",0,null,null,0,0,"Stage in the corporate action event life cycle",false),
	FIELD66("4:16R:GENL:16R:STAT:25::IPRC/","instruction processing status","STRING",0,null,null,0,0,"Provides the status of an instruction",false),
	FIELD67("4:16R:GENL:16R:STAT::16R:REAS:24::CAND/","cancellation reason","STRING",0,null,null,0,0,"Specifies the reason why the instruction is cancelled.",false),
	FIELD68("4:16R:GENL:16R:STAT::16R:REAS:24::CANP/","cancellation pending reason","STRING",0,null,null,0,0,"Specifies the reason why a cancellation request sent for the related instruction is pending.",false),
	FIELD69("4:16R:GENL:16R:STAT::16R:REAS:24::PACK/","acknowledged/accepted reason","STRING",0,null,null,0,0,"Specifies additional information about the processed instruction.",false),
	FIELD70("4:16R:GENL:16R:STAT::16R:REAS:24::PEND/","pending reason","STRING",0,null,null,0,0,"Specifies the reason why the instruction/event has a pending status.",false),
	FIELD71("4:16R:GENL:16R:STAT::16R:REAS:24::REJT/","rejection reason","STRING",0,null,null,0,0,"Specifies the reason why the instruction/cancellation request has a rejected status.",false),
	FIELD72("4:16R:GENL:16R:STAT::16R:REAS:70::REAS/","reason narrative","STRING",0,null,null,0,0,"Provides additional reason information",false),
	FIELD73("4:16R:CADETL:13::CAON/","ca option number","STRING",0,null,null,0,0,"Number identifying the available corporate action options.",false),
	FIELD74("4:16R:CADETL:22::CAOP/","corporate action option code indicator","STRING",0,null,null,0,0,"Specifies the corporate action options available to the account owner.",false),
	FIELD75("4:16R:CADETL:95::ACOW/","account owner","STRING",0,null,null,0,0,"Party that owns the account.",false),
	FIELD76("4:16R:CADETL:97::CASH/","cash account","STRING",0,null,null,0,0,"Account in which cash is maintained.",false),
	FIELD77("4:16R:CADETL:97::SAFE/","safekeeping account","STRING",0,null,null,0,0,"Account where financial instruments are maintained.",false),
	FIELD78("4:16R:CADETL:94::SAFE/","place of safekeeping","STRING",0,null,null,0,0,"Location where the financial instruments are/will be safekept.",false),
	FIELD79("4:16R:CADETL:35:","identification of security","STRING",0,null,null,0,0,"Identifies the financial instrument.",true),
	FIELD80("4:16R:CADETL:36::QREC/","quantity to receive","STRING",0,null,null,0,0,"Quantity of the benefits that the account owner wants to receive, e.g., as a result of dividend reinvestment.",false),
	FIELD81("4:16R:CADETL:36::STAQ/","status quantity","STRING",0,null,null,0,0,"Quantity of securities that has been assigned the status indicated.",false),
	FIELD82("4:16R:CADETL:19::ATAX/","additional tax amount","STRING",0,null,null,0,0,"Amount of additional taxes that cannot be categorised.",false),
	FIELD83("4:16R:CADETL:19::CAPG/","capital gains amount","STRING",0,null,null,0,0,"Amount of money distributed as the result of a capital gain.",false),
	FIELD84("4:16R:CADETL:19::CHAR/","charges fees amount","STRING",0,null,null,0,0,"Amount of money paid for the provision of financial services that cannot be categorised by another qualifier.",false),
	FIELD85("4:16R:CADETL:19::CINL/","cash in lieu of shares","STRING",0,null,null,0,0,"Cash disbursement in lieu of a fractional quantity of, e.g., equity.",false),
	FIELD86("4:16R:CADETL:19::COUN/","country, national federal tax","STRING",0,null,null,0,0,"Amount of country, national or federal tax charged by the jurisdiction in which the account servicer is located.",false),
	FIELD87("4:16R:CADETL:19::EXEC/","executing brokers amount","STRING",0,null,null,0,0,"Amount of money paid to an executing broker as a commission.",false),
	FIELD88("4:16R:CADETL:19::FISC/","fiscal stamp","STRING",0,null,null,0,0,"Amount of fiscal tax to apply.",false),
	FIELD89("4:16R:CADETL:19::FLFR/","fully franked amount","STRING",0,null,null,0,0,"Amount resulting from a fully franked dividend paid by a company; amount includes tax credit for companies that have made suffic",false),
	FIELD90("4:16R:CADETL:19::GRSS/","gross amount","STRING",0,null,null,0,0,"Amount of money before any deductions and allowances have been made.",false),
	FIELD91("4:16R:CADETL:19::INDM/","indemnity amount","STRING",0,null,null,0,0,"(Unique to France) Amount due to a buyer of securities dealt prior to ex date which may be subject to different rate of taxation",false),
	FIELD92("4:16R:CADETL:19::INTR/","interest amount","STRING",0,null,null,0,0,"Amount of money representing a coupon payment.",false),
	FIELD93("4:16R:CADETL:19::ISDI/","issue discount amount","STRING",0,null,null,0,0,"Amount of money defined as a discount on a new issue or on a tranche of an existing issue.",false),
	FIELD94("4:16R:CADETL:19::LADT/","local tax de specific 1","STRING",0,null,null,0,0,"Local tax (ZAS Anrechnungsbetrag) subject to interest down payment tax (proportion of interest liable for interest down payment ",false),
	FIELD95("4:16R:CADETL:19::LEVY/","payment levy tax","STRING",0,null,null,0,0,"Payment levy tax.",false),
	FIELD96("4:16R:CADETL:19::LIDT/","local tax de specific 2","STRING",0,null,null,0,0,"Local tax (ZAS Pflichtige Zinsen) interest liable for interest down payment tax (proportion of gross interest per unit/interim p",false),
	FIELD97("4:16R:CADETL:19::LOCL/","local tax","STRING",0,null,null,0,0,"Amount of tax charged by the jurisdiction in which the financial instrument settles.",false),
	FIELD98("4:16R:CADETL:19::LOCO/","local broker’s commission","STRING",0,null,null,0,0,"Local broker’s commission.",false),
	FIELD99("4:16R:CADETL:19::LOTE/","local tax de specific 3","STRING",0,null,null,0,0,"Local tax (Zinstopf) offset interest per unit against tax exempt amount (variation to offset interest per unit in relation to ta",false),
	FIELD100("4:16R:CADETL:19::LYDT/","local tax de specific 4","STRING",0,null,null,0,0,"Local tax (Ertrag Besitzanteilig) yield liable for interest down payment tax.",false),
	FIELD101("4:16R:CADETL:19::MKTC/","market claim","STRING",0,null,null,0,0,"Amount of money resulting from a market claim.",false),
	FIELD102("4:16R:CADETL:19::NETT/","net cash amount","STRING",0,null,null,0,0,"Amount of money after deductions and allowances have been made, if any, i.e., the total amount +/- charges/fees.",false),
	FIELD103("4:16R:CADETL:19::OCMT/","original currency and ordered amount","STRING",0,null,null,0,0,"Posting/settlement amount in its original currency when conversion from/into another currency has occurred",false),
	FIELD104("4:16R:CADETL:19::PAMM/","paying/sub-paying agent commission","STRING",0,null,null,0,0,"Amount of paying/sub-paying agent commission.",false),
	FIELD105("4:16R:CADETL:19::PRIN/","principal or corpus","STRING",0,null,null,0,0,"Amount of money representing a distribution of a bond’s principal, e.g., repayment of outstanding debt.",false),
	FIELD106("4:16R:CADETL:19::REDP/","redemption premium amount","STRING",0,null,null,0,0,"Amount of money (not interest) in addition to the principal at the redemption of a bond.",false),
	FIELD107("4:16R:CADETL:19::REGF/","regulatory fees","STRING",0,null,null,0,0,"Amount of money charged by a regulatory authority, e.g., Securities and Exchange fees.",false),
	FIELD108("4:16R:CADETL:19::REIN/","reinvestment amount","STRING",0,null,null,0,0,"Amount of money reinvested in additional securities.",false),
	FIELD109("4:16R:CADETL:19::SHIP/","shipping amount","STRING",0,null,null,0,0,"Amount of money (including insurance) paid for delivery by carrier.",false),
	FIELD110("4:16R:CADETL:19::SOFE/","solicitation fee","STRING",0,null,null,0,0,"Amount of cash premium made available in order to encourage participation in the offer. Payment is made to a third party who has",false);	


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

	
	CAMessageType567Field(String _path,String _fieldName,String _fieldType,int _fieldLength,String _fieldFormat,String _displayGroup,int _displayRow,int _displayColumn,String _description,boolean _hidden){
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
