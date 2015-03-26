package com.lynxspa.sdm.dictionaries.events;


import com.lynxspa.dictionaries.ClassType;
import com.lynxspa.sdm.installer.adapters.events.EventDetailAdapter;


public enum BasicEventDetail implements EventDetailAdapter {

	//Hidden fields
	DETAIL0("BODY:OPERATIONALDATE","event.operational.date",ClassType.TIMESTAMP,"dd/MM/yyyy",0,false,1,"general",0,0,0,0,0,0,"event.operational.date.description",false,true,true),
	DETAIL1("${complete}","event.complete",ClassType.BOOLEAN,"I18N:event.complete.{0}",0,false,2,"general",0,0,0,0,0,0,"event.complete.description",false,true,false),
	//Event info
	DETAIL2("${id}","event.id",ClassType.LONG,null,0,false,0,"event.info",1,0,0,0,0,0,"event.id.description",false,false,false),
	DETAIL3("${eventType.id}","event.type",ClassType.MIDDLESTRING,"I18N:event.type.{0}",0,false,0,"event.info",1,1,0,0,0,0,"event.type.description",false,false,false),
	DETAIL4("${eventType.optional}","event.type.optional",ClassType.BOOLEAN,"I18N:event.type.optional.{0}",0,false,0,"event.info",1,2,0,0,0,0,"event.type.optional.description",false,false,false),
	DETAIL5("BODY:EXECUTIONDATE","event.execution.date",ClassType.TIMESTAMP,"dd/MM/yyyy",0,false,0,"event.info",1,3,0,0,0,0,"event.execution.date.description",false,false,true),
	DETAIL6("BODY:SUBSCRIPTIONDATE","event.subscription.date",ClassType.TIMESTAMP,"dd/MM/yyyy",0,false,0,"event.info",1,4,0,0,0,0,"event.subscription.date.description",false,false,true),
	DETAIL7("BODY:EXPIRATIONDATE","event.expiration.date",ClassType.TIMESTAMP,"dd/MM/yyyy",0,false,0,"event.info",1,5,0,0,0,0,"event.expiration.date.description",false,false,true),
	DETAIL8("BODY:BOOLEAN:1","event.mandatory",ClassType.BOOLEAN,"I18N",0,false,0,"event.info",1,7,0,0,0,0,"event.mandatory.description",false,false,true),
	//Provider info
	DETAIL9("${eventProvider.id}","event.provider",ClassType.MIDDLESTRING,"LINK:EVENTPROVIDER",0,false,0,"event.provider.info",2,0,0,0,0,0,"event.provider.description",false,false,false),
	DETAIL10("${security.currency}","event.provider.currency",ClassType.SHORTSTRING,null,0,false,0,"event.provider.info",2,1,0,0,0,0,"event.provider.currency.description",false,false,false),
	DETAIL11("${security.id}","event.security",ClassType.LONG,"LINK:SECURITY",0,false,0,"event.provider.info",2,2,0,0,0,0,"event.security.description",false,false,false),
	DETAIL12("${security.ticker}","event.security.code",ClassType.MIDDLESTRING,null,0,false,0,"event.provider.info",2,3,0,0,0,0,"event.security.code.description",false,false,false);

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
	private boolean editableNormalization=false;

	BasicEventDetail(String _fieldPath,String _name,ClassType _fieldType,String _format,int _maxLength,boolean _displayInTable,int _displayInTableOrder,String _displayGroup,int _displayGroupOrder,int _displayInGroupOrder,int _displayRow,int _displayColumn,int _displayTop,int _displayLeft,String _description,boolean _extension,boolean _hidden,boolean _editableNormalization){
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
		this.editableNormalization=_editableNormalization;
	}

	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getFieldPath()
	 */
	public String getFieldPath() {
		return fieldPath;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getName()
	 */
	public String getName() {
		return name;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getFieldType()
	 */
	public ClassType getFieldType() {
		return this.fieldType;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getFormat()
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getMaxLength()
	 */
	public int getMaxLength() {
		return maxLength;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#isDisplayInTable()
	 */
	public boolean isDisplayInTable() {
		return this.displayInTable;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayInTableOrder()
	 */
	public int getDisplayInTableOrder() {
		return this.displayInTableOrder;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayGroup()
	 */
	public String getDisplayGroup() {
		return displayGroup;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayGroupOrder()
	 */
	public int getDisplayGroupOrder() {
		return displayGroupOrder;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayInGroupOrder()
	 */
	public int getDisplayInGroupOrder() {
		return displayInGroupOrder;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayRow()
	 */
	public int getDisplayRow() {
		return displayRow;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayColumn()
	 */
	public int getDisplayColumn() {
		return displayColumn;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayTop()
	 */
	public int getDisplayTop() {
		return displayTop;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDisplayLeft()
	 */
	public int getDisplayLeft() {
		return displayLeft;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#isExtension()
	 */
	public boolean isExtension() {
		return extension;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#isHidden()
	 */
	public boolean isHidden() {
		return hidden;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#isBasic()
	 */
	public boolean isBasic() {
		return true;
	}
	/**
	 * @see com.lynxspa.sdm.dictionaries.events.EventDetailAdapter#isEditableNormalization()
	 */
	public boolean isEditableNormalization(){
		return editableNormalization;
	}
}
