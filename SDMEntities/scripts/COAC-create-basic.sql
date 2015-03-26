
    create table HS_SP_SECURITYPORTFOLIO (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        REFID number(19,0),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERAMOUNT number(19,0),
        CUSTODIANAMOUNT number(19,0),
        FKPORTFOLIO varchar2(16 char) not null,
        FKSECURITY number(19,0) not null,
        primary key (ID)
    )
	PCTFREE 10 PCTUSED 80
	STORAGE(
            INITIAL          10M
            NEXT             15M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_APPLICATIONS (
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        DESCRIPTION varchar2(128 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        primary key (ID)
    );

    create table TB_CA_DOMAINCLUSTERFORMATS (
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        FKAPPLICATION varchar2(16 char),
        FKDOMAIN varchar2(16 char),
        FKDOMAINCLUSTER varchar2(32 char),
        FKMESSAGEFORMAT varchar2(16 char),
        primary key (FKMESSAGEFORMAT, FKAPPLICATION, FKDOMAIN, FKDOMAINCLUSTER)
    );

    create table TB_CA_EVENTCONFIGFIELDS (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        MRSCRIPT varchar2(512 char),
        ISREQUIRED number(1,0) not null,
        FKRESTRUEPROVIDER varchar2(16 char),
        FKEVENTCONFIG number(19,0) not null,
        FKRESFALSEPROVIDER varchar2(16 char),
        FKEVENTTYPEDETAIL number(19,0) not null,
        primary key (ID),
        unique (FKEVENTCONFIG, FKEVENTTYPEDETAIL)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;


    create table TB_CA_EVENTCONFIGMSGFLDS (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        NORMSCRIPT varchar2(2048 char),
        FKEVENTPROVIDER varchar2(16 char),
        FKEVENTFIELDCONFIG number(19,0) not null,
        FKMSGTYPE varchar2(16 char) not null,
        FKFORMAT varchar2(16 char) not null,
        primary key (ID),
        unique (FKEVENTFIELDCONFIG, FKFORMAT, FKMSGTYPE, FKEVENTPROVIDER)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTCONFIGS (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FKPREFPROVIDER1 varchar2(16 char),
        FKEVENTTYPE varchar2(4 char) not null,
        FKSECPREFPROV2 varchar2(16 char),
        primary key (ID),
        unique (FKEVENTTYPE)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTDETAILS (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        REFID number(19,0),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISDELETED number(1,0) not null,
        EXPIRATIONDATE date,
        SECURITY varchar2(12 char),
        SUSCRIPTIONDATE date,
        EXECUTIONDATE date,
        SECURITYCODETYPE varchar2(16 char),
        BOOLEAN1 number(1,0),
        BOOLEAN2 number(1,0),
        BOOLEAN3 number(1,0),
        BOOLEAN4 number(1,0),
        BOOLEAN5 number(1,0),
        BOOLEAN6 number(1,0),
        BOOLEAN7 number(1,0),
        BOOLEAN8 number(1,0),
        BOOLEAN9 number(1,0),
        BOOLEAN10 number(1,0),
        LONG1 number(19,0),
        LONG2 number(19,0),
        LONG3 number(19,0),
        LONG4 number(19,0),
        LONG5 number(19,0),
        LONG6 number(19,0),
        LONG7 number(19,0),
        LONG8 number(19,0),
        LONG9 number(19,0),
        LONG10 number(19,0),
        DOUBLE1 double precision,
        DOUBLE2 double precision,
        DOUBLE3 double precision,
        DOUBLE4 double precision,
        DOUBLE5 double precision,
        DOUBLE6 double precision,
        DOUBLE7 double precision,
        DOUBLE8 double precision,
        DOUBLE9 double precision,
        DOUBLE10 double precision,
        TIMESTAMP1 number(19,0),
        TIMESTAMP2 number(19,0),
        TIMESTAMP3 number(19,0),
        TIMESTAMP4 number(19,0),
        TIMESTAMP5 number(19,0),
        TIMESTAMP6 number(19,0),
        TIMESTAMP7 number(19,0),
        TIMESTAMP8 number(19,0),
        TIMESTAMP9 number(19,0),
        TIMESTAMP10 number(19,0),
        SHORTSTRING1 varchar2(16 char),
        SHORTSTRING2 varchar2(16 char),
        SHORTSTRING3 varchar2(16 char),
        SHORTSTRING4 varchar2(16 char),
        SHORTSTRING5 varchar2(16 char),
        SHORTSTRING6 varchar2(16 char),
        SHORTSTRING7 varchar2(16 char),
        SHORTSTRING8 varchar2(16 char),
        SHORTSTRING9 varchar2(16 char),
        SHORTSTRING10 varchar2(16 char),
        MIDDLESTRING1 varchar2(64 char),
        MIDDLESTRING2 varchar2(64 char),
        MIDDLESTRING3 varchar2(64 char),
        MIDDLESTRING4 varchar2(64 char),
        MIDDLESTRING5 varchar2(64 char),
        MIDDLESTRING6 varchar2(64 char),
        MIDDLESTRING7 varchar2(64 char),
        MIDDLESTRING8 varchar2(64 char),
        MIDDLESTRING9 varchar2(64 char),
        MIDDLESTRING10 varchar2(64 char),
        LONGSTRING1 varchar2(128 char),
        LONGSTRING2 varchar2(128 char),
        LONGSTRING3 varchar2(128 char),
        LONGSTRING4 varchar2(128 char),
        LONGSTRING5 varchar2(128 char),
        LONGSTRING6 varchar2(128 char),
        LONGSTRING7 varchar2(128 char),
        LONGSTRING8 varchar2(128 char),
        LONGSTRING9 varchar2(128 char),
        LONGSTRING10 varchar2(128 char),
        VERYLONGSTRING1 varchar2(256 char),
        VERYLONGSTRING2 varchar2(256 char),
        VERYLONGSTRING3 varchar2(256 char),
        VERYLONGSTRING4 varchar2(256 char),
        VERYLONGSTRING5 varchar2(256 char),
        VERYLONGSTRING6 varchar2(256 char),
        VERYLONGSTRING7 varchar2(256 char),
        VERYLONGSTRING8 varchar2(256 char),
        VERYLONGSTRING9 varchar2(256 char),
        VERYLONGSTRING10 varchar2(256 char),
        primary key (ID)
    )
	PCTFREE 60 PCTUSED 30
	STORAGE(
            INITIAL          100M
            NEXT             150M
            MINEXTENTS       1
            MAXEXTENTS       50
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTEXTDETAILS (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        REFID number(19,0),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISDELETED number(1,0) not null,
        BOOLEAN1 number(1,0),
        BOOLEAN2 number(1,0),
        BOOLEAN3 number(1,0),
        BOOLEAN4 number(1,0),
        BOOLEAN5 number(1,0),
        BOOLEAN6 number(1,0),
        BOOLEAN7 number(1,0),
        BOOLEAN8 number(1,0),
        BOOLEAN9 number(1,0),
        BOOLEAN10 number(1,0),
        LONG1 number(19,0),
        LONG2 number(19,0),
        LONG3 number(19,0),
        LONG4 number(19,0),
        LONG5 number(19,0),
        LONG6 number(19,0),
        LONG7 number(19,0),
        LONG8 number(19,0),
        LONG9 number(19,0),
        LONG10 number(19,0),
        DOUBLE1 double precision,
        DOUBLE2 double precision,
        DOUBLE3 double precision,
        DOUBLE4 double precision,
        DOUBLE5 double precision,
        DOUBLE6 double precision,
        DOUBLE7 double precision,
        DOUBLE8 double precision,
        DOUBLE9 double precision,
        DOUBLE10 double precision,
        TIMESTAMP1 number(19,0),
        TIMESTAMP2 number(19,0),
        TIMESTAMP3 number(19,0),
        TIMESTAMP4 number(19,0),
        TIMESTAMP5 number(19,0),
        TIMESTAMP6 number(19,0),
        TIMESTAMP7 number(19,0),
        TIMESTAMP8 number(19,0),
        TIMESTAMP9 number(19,0),
        TIMESTAMP10 number(19,0),
        SHORTSTRING1 varchar2(16 char),
        SHORTSTRING2 varchar2(16 char),
        SHORTSTRING3 varchar2(16 char),
        SHORTSTRING4 varchar2(16 char),
        SHORTSTRING5 varchar2(16 char),
        SHORTSTRING6 varchar2(16 char),
        SHORTSTRING7 varchar2(16 char),
        SHORTSTRING8 varchar2(16 char),
        SHORTSTRING9 varchar2(16 char),
        SHORTSTRING10 varchar2(16 char),
        MIDDLESTRING1 varchar2(64 char),
        MIDDLESTRING2 varchar2(64 char),
        MIDDLESTRING3 varchar2(64 char),
        MIDDLESTRING4 varchar2(64 char),
        MIDDLESTRING5 varchar2(64 char),
        MIDDLESTRING6 varchar2(64 char),
        MIDDLESTRING7 varchar2(64 char),
        MIDDLESTRING8 varchar2(64 char),
        MIDDLESTRING9 varchar2(64 char),
        MIDDLESTRING10 varchar2(64 char),
        LONGSTRING1 varchar2(128 char),
        LONGSTRING2 varchar2(128 char),
        LONGSTRING3 varchar2(128 char),
        LONGSTRING4 varchar2(128 char),
        LONGSTRING5 varchar2(128 char),
        LONGSTRING6 varchar2(128 char),
        LONGSTRING7 varchar2(128 char),
        LONGSTRING8 varchar2(128 char),
        LONGSTRING9 varchar2(128 char),
        LONGSTRING10 varchar2(128 char),
        VERYLONGSTRING1 varchar2(256 char),
        VERYLONGSTRING2 varchar2(256 char),
        VERYLONGSTRING3 varchar2(256 char),
        VERYLONGSTRING4 varchar2(256 char),
        VERYLONGSTRING5 varchar2(256 char),
        VERYLONGSTRING6 varchar2(256 char),
        VERYLONGSTRING7 varchar2(256 char),
        VERYLONGSTRING8 varchar2(256 char),
        VERYLONGSTRING9 varchar2(256 char),
        VERYLONGSTRING10 varchar2(256 char),
        EXTENSIONNAME varchar2(16 char) not null,
        EXTENSIONNUMBER number(10,0) not null,
        NARRATIVE clob,
        FKEVENTDETAIL number(19,0) not null,
        primary key (ID)
    )
	PCTFREE 60 PCTUSED 30
	STORAGE(
            INITIAL          100M
            NEXT             150M
            MINEXTENTS       1
            MAXEXTENTS       50
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTMESSAGEFIELDS (
        ID number(19,0) not null,
        FIELDTYPE number(10,0) not null,
        PATH varchar2(128 char) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        VALUESHORT varchar2(16 char),
        VALUELONG varchar2(128 char),
        VALUEVERYLONG varchar2(256 char),
        valueClob clob,
        FKEVENTMESSAGE number(19,0) not null,
        primary key (ID)
    )
	PCTFREE 5 PCTUSED 80
	STORAGE(
            INITIAL          100M
            NEXT             150M
            MINEXTENTS       1
            MAXEXTENTS       50
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTMESSAGES (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        SECURITYTYPE varchar2(64 char),
        SECURITY varchar2(64 char),
        EVENTTYPE varchar2(64 char),
        ISENDED number(1,0) not null,
        FKEVENT number(19,0),
        ORIGINID varchar2(16 char),
        ORIGINNAME varchar2(512 char),
        ORIGINTYPE varchar2(64 char),
        ORIGINPOSITION number(10,0),
        MESSAGEID varchar2(64 char),
        OPERATION varchar2(64 char),
        SENDER varchar2(64 char),
        RECEIVER varchar2(64 char),
        EVENTREFERENCE varchar2(64 char),
        EVENTMESSGREF varchar2(64 char),
        PREVEVENTMESSGREF varchar2(64 char),
        SECURITYNAME varchar2(128 char),
        ANNOUNCEDATE date,
        EFFECTIVEDATE date,
        ACCOUNT varchar2(64 char),
        AMOUNT number(19,0),
        ORIGINALMESSAGE clob,
        FKEVENTTYPE varchar2(4 char),
        FKTYPE varchar2(16 char),
        FKFORMAT varchar2(16 char),
        FKSECURITY number(19,0),
        FKSTATE varchar2(16 char) not null,
        FKSTATEFLOW varchar2(16 char) not null,
        primary key (ID)
    )
	PCTFREE 10 PCTUSED 80
	STORAGE(
            INITIAL          30M
            NEXT             40M
            MINEXTENTS       1
            MAXEXTENTS       50
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTPROVIDERS (
        EVENTPROVCLASS varchar2(16 char) not null,
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        IDATMESSAGE varchar2(255 char) not null,
        FKMESSAGEFORMAT varchar2(16 char),
        primary key (ID)
    );

    create table TB_CA_EVENTS (
        EVENTCLASS varchar2(32 char) not null,
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        REFID number(19,0),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISDELETED number(1,0) not null,
        EXPIRATIONDATE date,
        SUSCRIPTIONDATE date,
        EXECUTIONDATE date,
        ISENDED number(1,0) not null,
        ISCOMPLETE number(1,0),
        FKEVENTDETAIL number(19,0),
        FKEVENTPROVIDER varchar2(16 char),
        FKMASTEREVENT number(19,0),
        FKEVENTGROUP number(19,0),
        FKEVENTTYPE varchar2(4 char) not null,
        FKSTATE varchar2(16 char) not null,
        FKSTATEFLOW varchar2(16 char) not null,
        FKSECURITY number(19,0),
        primary key (ID)
    )
	PCTFREE 60 PCTUSED 30
	STORAGE(
            INITIAL          100M
            NEXT             150M
            MINEXTENTS       1
            MAXEXTENTS       50
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTTYPEDETAILS (
        ID number(19,0) not null,
        NAME varchar2(64 char) not null,
        ISHIDDEN number(1,0) not null,
        VERSION number(10,0) not null,
        DESCRIPTION varchar2(256 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FIELDPATH varchar2(32 char) not null,
        FORMAT varchar2(32 char),
        MAXLENGTH number(10,0),
        DISPLAYGROUP varchar2(16 char) not null,
        DISPLAYGROUPORDER number(10,0) not null,
        DISPLAYINGROUPORDER number(10,0),
        DISPLAYROW number(10,0),
        DISPLAYCOLUMN number(10,0),
        DISPLAYTOP number(10,0),
        DISPLAYLEFT number(10,0),
        ISEXTENSION number(1,0) not null,
        ISBASIC number(1,0) not null,
        FKEVENTTYPE varchar2(4 char) not null,
        primary key (ID)
    )
	PCTFREE 60 PCTUSED 30
	STORAGE(
            INITIAL          2M
            NEXT             3M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_EVENTTYPES (
        ID varchar2(4 char) not null,
        NAME varchar2(64 char) not null,
        DESCRIPTION varchar2(256 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISOPTIONAL number(1,0) not null,
        primary key (ID)
    );

    create table TB_CA_MESSAGEFIELDCONFIGS (
        PATH varchar2(128 char) not null,
        HIDDEN number(1,0) not null,
        DESCRIPTION varchar2(128 char),
        FIELDNAME varchar2(64 char) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        DISPLAYGROUP varchar2(64 char),
        DISPLAYROW number(10,0) not null,
        DISPLAYCOLUMN number(10,0) not null,
        FIELDLENGTH number(10,0),
        FIELDTYPE varchar2(32 char) not null,
        FIELDFORMAT varchar2(32 char),
        FKTYPE varchar2(16 char) not null,
        FKFORMAT varchar2(16 char) not null,
        primary key (FKTYPE, FKFORMAT, PATH)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_CA_MESSAGEFORMATS (
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        PATH varchar2(128 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        PATTERN varchar2(64 char) not null,
        primary key (ID)
    );

    create table TB_CA_MESSAGETYPES (
        CODE varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        FKFORMAT varchar2(16 char) not null,
        primary key (CODE, FKFORMAT)
    );

    create table TB_CONFIGS (
        ID varchar2(32 char) not null,
        TYPEVALUE varchar2(15 char) not null,
        VERSION number(10,0) not null,
        DESCRIPTION varchar2(64 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        BOOLEANVALUE number(1,0),
        LONGVALUE number(19,0),
        DOUBLEVALUE double precision,
        TIMESTAMPVALUE timestamp,
        SHORTSTRINGVALUE varchar2(16 char),
        MIDDLESTRINGVALUE varchar2(64 char),
        LONGSTRINGVALUE varchar2(128 char),
        VERYLONGSTRINGVALUE varchar2(256 char),
        FKAPPLICATION varchar2(16 char) not null,
        primary key (FKAPPLICATION, ID)
    );

    create table TB_DOMAINCLUSTERS (
        CODE varchar2(32 char) not null,
        NAME varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FKAPPLICATION varchar2(16 char),
        FKDOMAIN varchar2(16 char),
        primary key (FKAPPLICATION, FKDOMAIN, CODE)
    );

    create table TB_DOMAINNORMS (
        CODE varchar2(32 char) not null,
        VERSION number(10,0) not null,
        DESCRIPTION varchar2(64 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FKAPPLICATION varchar2(16 char),
        FKDOMAIN varchar2(16 char),
        primary key (FKAPPLICATION, FKDOMAIN, CODE)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_DOMAINS (
        CODE varchar2(16 char) not null,
        NAME varchar2(64 char),
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FKAPPLICATION varchar2(16 char) not null,
        primary key (FKAPPLICATION, CODE)
    );

    create table TB_DOMAINVALUES (
        ORIGINALVALUE varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        FKNRMAPPLICATION varchar2(16 char),
        FKNRMDOMAIN varchar2(16 char),
        FKNORM varchar2(32 char),
        FKCLTAPPLICATION varchar2(16 char),
        FKCLTDOMAIN varchar2(16 char),
        FKCLUSTER varchar2(32 char),
        primary key (ORIGINALVALUE, FKNRMAPPLICATION, FKNRMDOMAIN, FKNORM, FKCLTAPPLICATION, FKCLTDOMAIN, FKCLUSTER)
    )
	PCTFREE 30 PCTUSED 60
	STORAGE(
            INITIAL          3M
            NEXT             4M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_FLOWS (
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        DESCRIPTION varchar2(128 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        FKAPPLICATION varchar2(16 char) not null,
        primary key (ID)
    );

    create table TB_LOGFIELDUPDATES (
        ID number(10,0) not null,
        NEWVALUE varchar2(256 char) not null,
        OLDVALUE varchar2(256 char) not null,
        FIELDNAME varchar2(128 char) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        FKLOG number(19,0) not null,
        primary key (ID)
    )
	PCTFREE 5 PCTUSED 90
	STORAGE(
            INITIAL          15M
            NEXT             30M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_LOGS (
        LOGCLASS varchar2(32 char) not null,
        ID number(19,0) not null,
        MESSAGE varchar2(1750 char) not null,
        LOGTYPE varchar2(128 char) not null,
        LOGLEVEL number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        FKAPPLICATION varchar2(16 char) not null,
        STACKTRACE clob,
        ENTITYNAME varchar2(255 char),
        OPERATIONID number(19,0),
        FKFLOW varchar2(16 char),
        FKTRANSITION varchar2(16 char),
        UPDATEDENTITY varchar2(128 char),
        primary key (ID)
    )
	PCTFREE 5 PCTUSED 90
	STORAGE(
            INITIAL          15M
            NEXT             30M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_SP_MANAGERGROUPS (
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERID varchar2(64 char),
        primary key (ID)
    );

    create table TB_SP_MANAGERS (
        ID number(19,0) not null,
        NAME varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERID varchar2(64 char),
        FKMANAGERGROUP varchar2(16 char),
        primary key (ID)
    );

    create table TB_SP_MARKETS (
        ID number(19,0) not null,
        NAME varchar2(128 char),
        COUNTRY varchar2(2 char),
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERID varchar2(64 char),
        TICKER varchar2(32 char),
        MIC varchar2(32 char) not null,
        CITY varchar2(32 char),
        primary key (ID)
    )
	PCTFREE 5 PCTUSED 90
	STORAGE(
            INITIAL          5M
            NEXT             15M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_SP_PORTFOLIOS (
        ID varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERID varchar2(64 char),
        CUSTODIANID varchar2(64 char),
        FKMANAGERGROUP varchar2(16 char),
        primary key (ID)
    );

    create table TB_SP_SECURITIES (
        SECURITYCLASS varchar2(16 char) not null,
        ID number(19,0) not null,
        NAME varchar2(64 char) not null,
        COUNTRY varchar2(2 char),
        VERSION number(10,0) not null,
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        UPDUSER varchar2(128 char) not null,
        UPDDATE timestamp not null,
        ISDELETED number(1,0) not null,
        ISIN varchar2(12 char),
        CUSIP varchar2(9 char),
        SEDOL varchar2(7 char),
        PROVIDER_ID1 varchar2(16 char),
        PROVIDER_ID2 varchar2(16 char),
        PROVIDER_ID3 varchar2(16 char),
        SEC_TYPE varchar2(32 char),
        IND_SECTOR varchar2(32 char),
        IND_GROUP varchar2(32 char),
        IND_SUBGROUP varchar2(32 char),
        REL_INDEX varchar2(8 char),
        CURRENCY varchar2(3 char),
        CUSTOMERID varchar2(64 char),
        TICKER varchar2(32 char),
        EXPIRATIONDATE date,
        INCUSTPORTFOLIO number(1,0),
        FKMARKET number(19,0),
        primary key (ID)
    )	
	PCTFREE 20 PCTUSED 70
	STORAGE(
            INITIAL          8M
            NEXT             9M
            MINEXTENTS       1
            MAXEXTENTS       15
            PCTINCREASE      1
    )
	LOGGING 
	NOCACHE
	NOPARALLEL
	NOMONITORING;

    create table TB_SP_SECURITYPORTFOLIO (
        ID number(19,0) not null,
        VERSION number(10,0) not null,
        REFID number(19,0),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISDELETED number(1,0) not null,
        CUSTOMERAMOUNT number(19,0),
        CUSTODIANAMOUNT number(19,0),
        FKPORTFOLIO varchar2(16 char) not null,
        FKSECURITY number(19,0) not null,
        primary key (ID)
    );

    create table TB_STATES (
        CODE varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        DESCRIPTION varchar2(128 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        ISINITIAL number(1,0) not null,
        ISEND number(1,0) not null,
        FKFLOW varchar2(16 char) not null,
        primary key (CODE, FKFLOW)
    );

    create table TB_TRANSITIONS (
        CODE varchar2(16 char) not null,
        NAME varchar2(64 char) not null,
        DESCRIPTION varchar2(128 char),
        CRTUSER varchar2(128 char) not null,
        CRTDATE timestamp not null,
        TRANSITIONEXECLASS varchar2(128 char),
        FKFLOW varchar2(16 char) not null,
        FKINITIALSTATE varchar2(16 char),
        FKINITIALSTATEFLOW varchar2(16 char),
        FKENDSTATE varchar2(16 char) not null,
        FKENDSTATEFLOW varchar2(16 char) not null,
        primary key (CODE, FKFLOW)
    );

    create index IDX_HSSECPORT_DELETED on HS_SP_SECURITYPORTFOLIO (ISDELETED);

    alter table HS_SP_SECURITYPORTFOLIO 
        add constraint FK_HS_SECPORT_SECURITY 
        foreign key (FKSECURITY) 
        references TB_SP_SECURITIES;

    alter table HS_SP_SECURITYPORTFOLIO 
        add constraint FK_HS_SECPORT_PORTFOLIO 
        foreign key (FKPORTFOLIO) 
        references TB_SP_PORTFOLIOS;

    alter table TB_CA_DOMAINCLUSTERFORMATS 
        add constraint FK_DOMCLSFORM_CLUSTER 
        foreign key (FKAPPLICATION, FKDOMAIN, FKDOMAINCLUSTER) 
        references TB_DOMAINCLUSTERS;

    alter table TB_CA_DOMAINCLUSTERFORMATS 
        add constraint FK_DOMCLSFORM_FORMAT 
        foreign key (FKMESSAGEFORMAT) 
        references TB_CA_MESSAGEFORMATS;

    create index IDX_EVCONFFLD_FKEVTYPEDET on TB_CA_EVENTCONFIGFIELDS (FKEVENTTYPEDETAIL);

    create index IDX_EVCONFFLD_FKEVCONF on TB_CA_EVENTCONFIGFIELDS (FKEVENTCONFIG);

    create index IDX_EVCONFFLD_DELETED on TB_CA_EVENTCONFIGFIELDS (ISDELETED);

    alter table TB_CA_EVENTCONFIGFIELDS 
        add constraint FK_EVNCONFFIELD_EVNTYPEDET 
        foreign key (FKEVENTTYPEDETAIL) 
        references TB_CA_EVENTTYPEDETAILS;

    alter table TB_CA_EVENTCONFIGFIELDS 
        add constraint FK_EVNCONFFIELD_PROVRESFALSE 
        foreign key (FKRESFALSEPROVIDER) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTCONFIGFIELDS 
        add constraint FK_EVNCONFFIELD_PROVRESTRUE 
        foreign key (FKRESTRUEPROVIDER) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTCONFIGFIELDS 
        add constraint FK_EVNCONFFIELD_EVENTCONFIG 
        foreign key (FKEVENTCONFIG) 
        references TB_CA_EVENTCONFIGS;

    create index IDX_EVCONFMSGFLD_DELETED on TB_CA_EVENTCONFIGMSGFLDS (ISDELETED);

    create index IDX_EVCONFMSGFLD_FKMESSAGETYPE on TB_CA_EVENTCONFIGMSGFLDS (FKFORMAT, FKMSGTYPE);

    create index IDX_EVCONFMSGFLD_FKEVFILDCONF on TB_CA_EVENTCONFIGMSGFLDS (FKEVENTFIELDCONFIG);

    create index IDX_EVCONFMSGFLD_FKEVPROVIDER on TB_CA_EVENTCONFIGMSGFLDS (FKEVENTPROVIDER);

    alter table TB_CA_EVENTCONFIGMSGFLDS 
        add constraint FK_EVNCONFFLDPRV_EVENTPROV 
        foreign key (FKEVENTPROVIDER) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTCONFIGMSGFLDS 
        add constraint FK_EVNCONFFLDPRV_EVNCONFFLD 
        foreign key (FKEVENTFIELDCONFIG) 
        references TB_CA_EVENTCONFIGFIELDS;

    alter table TB_CA_EVENTCONFIGMSGFLDS 
        add constraint FK_EVNCONFFLDMT_EVENTMESG 
        foreign key (FKMSGTYPE, FKFORMAT) 
        references TB_CA_MESSAGETYPES;

    create index IDX_EVCONFIG_DELETED on TB_CA_EVENTCONFIGS (ISDELETED);

    alter table TB_CA_EVENTCONFIGS 
        add constraint FK_EVENTCONFIG_EVENTPROVIDER1 
        foreign key (FKPREFPROVIDER1) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTCONFIGS 
        add constraint FK_EVENTCONFIG_EVENTPROVIDER2 
        foreign key (FKSECPREFPROV2) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTCONFIGS 
        add constraint FK_EVENTCONFIG_EVENTTYPE 
        foreign key (FKEVENTTYPE) 
        references TB_CA_EVENTTYPES;

    create index IDX_EVDETAIL_VERSION on TB_CA_EVENTDETAILS (VERSION);

    create index IDX_EVDETAIL_DELETED on TB_CA_EVENTDETAILS (ISDELETED);

    create index IDX_EVTEXTDETAIL_VERSION on TB_CA_EVENTEXTDETAILS (VERSION);

    create index IDX_EVTEXTDETAIL_FKEVENTDETAIL on TB_CA_EVENTEXTDETAILS (FKEVENTDETAIL);

    create index IDX_EVTEXTDETAIL_DELETED on TB_CA_EVENTEXTDETAILS (ISDELETED);

    alter table TB_CA_EVENTEXTDETAILS 
        add constraint FK_EXTENDED_DETAIL 
        foreign key (FKEVENTDETAIL) 
        references TB_CA_EVENTDETAILS;

    create index IDX_EVMESGFLD_FKEVENTMESSAGE on TB_CA_EVENTMESSAGEFIELDS (FKEVENTMESSAGE);

    alter table TB_CA_EVENTMESSAGEFIELDS 
        add constraint FK_FIELD_MESSAGE 
        foreign key (FKEVENTMESSAGE) 
        references TB_CA_EVENTMESSAGES;

    create index IDX_EVMESSAGE_FKFORMAT on TB_CA_EVENTMESSAGES (FKFORMAT);

    create index IDX_EVMESSAGE_CRTDATE on TB_CA_EVENTMESSAGES (CRTDATE);

    create index IDX_EVMESSAGE_STATUS on TB_CA_EVENTMESSAGES (ISENDED, FKSTATE);

    create index IDX_EVMESSAGE_DELETED on TB_CA_EVENTMESSAGES (ISDELETED);

    create index IDX_EVMESSAGE_FKEVENT on TB_CA_EVENTMESSAGES (FKEVENT);

    create index IDX_EVMESSAGE_MESSAGEID on TB_CA_EVENTMESSAGES (MESSAGEID);

    create index IDX_EVMESSAGE_FKSECURITY on TB_CA_EVENTMESSAGES (FKSECURITY);

    create index IDX_EVMESSAGE_FKEVENTTYPE on TB_CA_EVENTMESSAGES (FKEVENTTYPE);

    create index IDX_EVMESSAGE_EFFECTIVEDATE on TB_CA_EVENTMESSAGES (EFFECTIVEDATE);

    alter table TB_CA_EVENTMESSAGES 
        add constraint FK_EVENTMESSAGE_SECURITY 
        foreign key (FKSECURITY) 
        references TB_SP_SECURITIES;

    alter table TB_CA_EVENTMESSAGES 
        add constraint FK_MESSAGE_TYPE 
        foreign key (FKTYPE, FKFORMAT) 
        references TB_CA_MESSAGETYPES;

    alter table TB_CA_EVENTMESSAGES 
        add constraint FK_EVENTMESSAGE_EVENTTYPE 
        foreign key (FKEVENTTYPE) 
        references TB_CA_EVENTTYPES;

    alter table TB_CA_EVENTMESSAGES 
        add constraint FKEC50F156FC4CA9B4 
        foreign key (FKSTATE, FKSTATEFLOW) 
        references TB_STATES;

    create index IDX_EVPROVIDER_EVENTPROVCLASS on TB_CA_EVENTPROVIDERS (EVENTPROVCLASS);

    create index IDX_EVPROVIDER_FKMESSFORMAT on TB_CA_EVENTPROVIDERS (FKMESSAGEFORMAT);

    create index IDX_EVPROVIDER_DELETED on TB_CA_EVENTPROVIDERS (ISDELETED);

    alter table TB_CA_EVENTPROVIDERS 
        add constraint FK_PROVIDER_FORMAT 
        foreign key (FKMESSAGEFORMAT) 
        references TB_CA_MESSAGEFORMATS;

    create index IDX_EVENT_FKMASTEREVENT on TB_CA_EVENTS (FKMASTEREVENT);

    create index IDX_EVENT_FKEVENTDETAIL on TB_CA_EVENTS (FKEVENTDETAIL);

    create index IDX_EVENT_FKEVENTPROVIDER on TB_CA_EVENTS (FKEVENTPROVIDER);

    create index IDX_EVENT_EVENTCLASS on TB_CA_EVENTS (EVENTCLASS);

    create index IDX_EVENT_FKEVENTGROUP on TB_CA_EVENTS (FKEVENTGROUP);

    create index IDX_EVENT_SECURITY on TB_CA_EVENTS (FKSECURITY);

    create index IDX_EVENT_DELETED on TB_CA_EVENTS (ISDELETED);

    create index IDX_EVENT_STATUS on TB_CA_EVENTS (ISENDED, FKSTATEFLOW, FKSTATE);

    create index IDX_EVENT_EVENTTYPE on TB_CA_EVENTS (FKEVENTTYPE);

    create index IDX_EVENT_VERSION on TB_CA_EVENTS (VERSION);

    alter table TB_CA_EVENTS 
        add constraint FK_EVENT_SECURITY 
        foreign key (FKSECURITY) 
        references TB_SP_SECURITIES;

    alter table TB_CA_EVENTS 
        add constraint FK_EVENT_EVENTDETAIL 
        foreign key (FKEVENTDETAIL) 
        references TB_CA_EVENTDETAILS;

    alter table TB_CA_EVENTS 
        add constraint FK_EVENT_PROVIDER 
        foreign key (FKEVENTPROVIDER) 
        references TB_CA_EVENTPROVIDERS;

    alter table TB_CA_EVENTS 
        add constraint FK_EVENT_EVENTTYPE 
        foreign key (FKEVENTTYPE) 
        references TB_CA_EVENTTYPES;

    alter table TB_CA_EVENTS 
        add constraint FKDAA19789FC4CA9B4 
        foreign key (FKSTATE, FKSTATEFLOW) 
        references TB_STATES;

    alter table TB_CA_EVENTS 
        add constraint FK_GROUP_COLLECTED 
        foreign key (FKMASTEREVENT) 
        references TB_CA_EVENTS;

    alter table TB_CA_EVENTS 
        add constraint FK_COLLECTED_GROUP 
        foreign key (FKEVENTGROUP) 
        references TB_CA_EVENTS;

    create index IDX_EVTYPEDET_FKEVENTTYPE on TB_CA_EVENTTYPEDETAILS (FKEVENTTYPE);

    create index IDX_EVTYPEDET_DELETED on TB_CA_EVENTTYPEDETAILS (ISDELETED);

    create index IDX_EVTYPEDET_FIELDPATH on TB_CA_EVENTTYPEDETAILS (FIELDPATH);

    alter table TB_CA_EVENTTYPEDETAILS 
        add constraint FK_DETAIL_EVENTTYPE 
        foreign key (FKEVENTTYPE) 
        references TB_CA_EVENTTYPES;

    alter table TB_CA_MESSAGEFIELDCONFIGS 
        add constraint FK_FIELD_TYPE 
        foreign key (FKTYPE, FKFORMAT) 
        references TB_CA_MESSAGETYPES;

    create index IDX_MESGFORMAT_DELETED on TB_CA_MESSAGEFORMATS (ISDELETED);

    alter table TB_CA_MESSAGETYPES 
        add constraint FK_TYPE_FORMAT 
        foreign key (FKFORMAT) 
        references TB_CA_MESSAGEFORMATS;

    create index IDX_CONFIG_DELETED on TB_CONFIGS (ISDELETED);

    alter table TB_CONFIGS 
        add constraint FK_CONFIG_APPLICATION 
        foreign key (FKAPPLICATION) 
        references TB_APPLICATIONS;

    create index IDX_DOMCLUSTER_DELETED on TB_DOMAINCLUSTERS (ISDELETED);

    alter table TB_DOMAINCLUSTERS 
        add constraint FK_DOMAINCLUSTER_DOMAIN 
        foreign key (FKAPPLICATION, FKDOMAIN) 
        references TB_DOMAINS;

    create index IDX_DOMNORM_DELETED on TB_DOMAINNORMS (ISDELETED);

    alter table TB_DOMAINNORMS 
        add constraint FK_DOMAINNORM_DOMAIN 
        foreign key (FKAPPLICATION, FKDOMAIN) 
        references TB_DOMAINS;

    create index IDX_DOMAIN_DELETED on TB_DOMAINS (ISDELETED);

    alter table TB_DOMAINS 
        add constraint FK_DOMAIN_APPLICATION 
        foreign key (FKAPPLICATION) 
        references TB_APPLICATIONS;

    create index IDX_DOMVALUE_DELETED on TB_DOMAINVALUES (ISDELETED);

    alter table TB_DOMAINVALUES 
        add constraint FK_VALUE_CLUSTER 
        foreign key (FKCLTAPPLICATION, FKCLTDOMAIN, FKCLUSTER) 
        references TB_DOMAINCLUSTERS;

    alter table TB_DOMAINVALUES 
        add constraint FK_VALUE_NORM 
        foreign key (FKNRMAPPLICATION, FKNRMDOMAIN, FKNORM) 
        references TB_DOMAINNORMS;

    create index IDX_STATE_FKAPPLICATION on TB_FLOWS (FKAPPLICATION);

    alter table TB_FLOWS 
        add constraint FK_FLOW_APPLICATION 
        foreign key (FKAPPLICATION) 
        references TB_APPLICATIONS;

    create index IDX_LOGFIELDUPDATE_FKLOG on TB_LOGFIELDUPDATES (FKLOG);

    alter table TB_LOGFIELDUPDATES 
        add constraint FK_LOGFIELDUPDATE_LOG 
        foreign key (FKLOG) 
        references TB_LOGS;

    create index IDX_LOG_LOGCLASS on TB_LOGS (LOGCLASS);

    create index IDX_LOG_CRTDATE on TB_LOGS (CRTDATE);

    create index IDX_MANAGERGROUP_DELETED on TB_SP_MANAGERGROUPS (ISDELETED);

    create index IDX_MANAGER_DELETED on TB_SP_MANAGERS (ISDELETED);

    create index IDX_MANAGER_FKMANAGERGROUP on TB_SP_MANAGERS (FKMANAGERGROUP);

    alter table TB_SP_MANAGERS 
        add constraint FK_MANAGER_MANAGERGROUP 
        foreign key (FKMANAGERGROUP) 
        references TB_SP_MANAGERGROUPS;

    create index IDX_MARKET_DELETED on TB_SP_MARKETS (ISDELETED);

    create index IDX_MARKET_COUNTRY on TB_SP_MARKETS (COUNTRY);

    create index IDX_MARKET_MIC on TB_SP_MARKETS (MIC);

    create index IDX_PORTFOLIO_FKMANAGERGROUP on TB_SP_PORTFOLIOS (FKMANAGERGROUP);

    create index IDX_PORTFOLIO_DELETED on TB_SP_PORTFOLIOS (ISDELETED);

    alter table TB_SP_PORTFOLIOS 
        add constraint FK_PORTFOLIO_MANAGERGROUP 
        foreign key (FKMANAGERGROUP) 
        references TB_SP_MANAGERGROUPS;

    create index IDX_SECURITY_SEDOL on TB_SP_SECURITIES (SEDOL);

    create index IDX_SECURITY_INCUSTPORTF on TB_SP_SECURITIES (INCUSTPORTFOLIO);

    create index IDX_SECURITY_INFPROV2 on TB_SP_SECURITIES (PROVIDER_ID2);

    create index IDX_SECURITY_DELETED on TB_SP_SECURITIES (ISDELETED);

    create index IDX_SECURITY_CUSIP on TB_SP_SECURITIES (CUSIP);

    create index IDX_SECURITY_ISIN on TB_SP_SECURITIES (ISIN);

    create index IDX_SECURITY_SECURITYCLASS on TB_SP_SECURITIES (SECURITYCLASS);

    create index IDX_SECURITY_INFPROV3 on TB_SP_SECURITIES (PROVIDER_ID3);

    create index IDX_SECURITY_FKMARKET on TB_SP_SECURITIES (FKMARKET);

    create index IDX_SECURITY_TICKER on TB_SP_SECURITIES (TICKER);

    create index IDX_SECURITY_INFPROV1 on TB_SP_SECURITIES (PROVIDER_ID1);

    alter table TB_SP_SECURITIES 
        add constraint FK_SECURITY_MARKET 
        foreign key (FKMARKET) 
        references TB_SP_MARKETS;

    create index IDX_SECPORT_FKPORTFOLIO on TB_SP_SECURITYPORTFOLIO (FKPORTFOLIO);

    create index IDX_SECPORT_DELETED on TB_SP_SECURITYPORTFOLIO (ISDELETED);

    create index IDX_SECPORT_VERSION on TB_SP_SECURITYPORTFOLIO (VERSION);

    create index IDX_SECPORT_FKSECURITY on TB_SP_SECURITYPORTFOLIO (FKSECURITY);

    alter table TB_SP_SECURITYPORTFOLIO 
        add constraint FK_SECPORT_SECURITY 
        foreign key (FKSECURITY) 
        references TB_SP_SECURITIES;

    alter table TB_SP_SECURITYPORTFOLIO 
        add constraint FK_SECPORT_PORTFOLIO 
        foreign key (FKPORTFOLIO) 
        references TB_SP_PORTFOLIOS;

    create index IDX_STATE_CODE on TB_STATES (CODE);

    create index IDX_STATE_FKFLOW on TB_STATES (FKFLOW);

    alter table TB_STATES 
        add constraint FK_STATE_FLOW 
        foreign key (FKFLOW) 
        references TB_FLOWS;

    create index IDX_TRANSITION_CODE on TB_TRANSITIONS (CODE);

    create index IDX_TRANSITION_FKFLOW on TB_TRANSITIONS (FKFLOW);

    alter table TB_TRANSITIONS 
        add constraint FK_TRANSITION_FLOW 
        foreign key (FKFLOW) 
        references TB_FLOWS;

    alter table TB_TRANSITIONS 
        add constraint FK_TRANSITION_ENDSTATE 
        foreign key (FKENDSTATE, FKENDSTATEFLOW) 
        references TB_STATES;

    alter table TB_TRANSITIONS 
        add constraint FK_TRANSITION_INITSTATE 
        foreign key (FKINITIALSTATE, FKINITIALSTATEFLOW) 
        references TB_STATES;

    create sequence hibernate_sequence;
