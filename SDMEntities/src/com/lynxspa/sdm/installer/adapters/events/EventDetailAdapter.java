package com.lynxspa.sdm.installer.adapters.events;

import com.lynxspa.dictionaries.ClassType;

public interface EventDetailAdapter {

	public abstract String getFieldPath();
	public abstract String getName();
	public abstract ClassType getFieldType();
	public abstract String getFormat();
	public abstract int getMaxLength();
	public abstract boolean isDisplayInTable();
	public abstract int getDisplayInTableOrder();
	public abstract String getDisplayGroup();
	public abstract int getDisplayGroupOrder();
	public abstract int getDisplayInGroupOrder();
	public abstract int getDisplayRow();
	public abstract int getDisplayColumn();
	public abstract int getDisplayTop();
	public abstract int getDisplayLeft();
	public abstract String getDescription();
	public abstract boolean isExtension();
	public abstract boolean isHidden();
	public abstract boolean isBasic();
	public abstract boolean isEditableNormalization();
}