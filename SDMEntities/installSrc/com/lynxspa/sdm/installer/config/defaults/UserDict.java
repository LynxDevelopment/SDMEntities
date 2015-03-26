package com.lynxspa.sdm.installer.config.defaults;

import com.lynxspa.xweb.installer.adapters.UserDictAdapter;

public enum UserDict implements UserDictAdapter{
	
	XWEBADMIN("xweb.admin",true,null,null,null,null,null,null,"es",new String[]{GroupDict.SDMCONFIGURATOR.getCode(),"EVERYONE"});
	
	
	private String id=null;
	private boolean existent=false;
	private String password=null;
	private String homepage=null;
	private String firstName="routing";
	private String lastName="user";
	private String email="routing.user@lynxspa.com";
	private String gender="M";
	private String locale="es";
	private String[] groups=null;
	
	
	UserDict(String _id,boolean _existent,String _password,String _homepage,String _firstName,String _lastName,String _email,String _gender,String _locale,String[] _groups){
		this.id=_id;
		this.existent=_existent;
		this.password=_password;
		this.homepage=_homepage;
		this.firstName=_firstName;
		this.lastName=_lastName;
		this.email=_email;
		this.gender=_gender;
		this.locale=_locale;
		this.groups=_groups;
	}
	
	public String getId() {
		return id;
	}
	public boolean isExistent() {
		return existent;
	}
	public String getPassword() {
		return password;
	}
	public String getHomepage() {
		return homepage;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getLocale() {
		return locale;
	}
	public String[] getGroups() {
		return groups;
	}
}
