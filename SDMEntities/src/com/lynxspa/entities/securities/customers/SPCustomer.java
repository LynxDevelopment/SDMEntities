package com.lynxspa.entities.securities.customers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.lynxspa.entities.securities.managers.SPManager;

@Entity
@DiscriminatorValue("manager")
@org.hibernate.annotations.Table(appliesTo="TB_SP_CUSTOMERS",indexes={
})
public class SPCustomer extends SPCustomerGroup {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5971567175526951324L;
	private SPManager manager=null;
	
	public SPCustomer (){
		this(null, null);
	}
	public SPCustomer (String _user, String _name){
		super(_user, _name);
	}
	public SPCustomer (String _user,String _name,String _customerId){
		super(_user, _name,_customerId,null);
	}
	
	@ManyToOne(targetEntity = SPManager.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_CUSTOMER_MANAGER")
	@JoinColumn(name="FKCUSTMANAGER",nullable=true, updatable=true)
	public SPManager getManager() {
		return manager;
	}
	public void setManager(SPManager _manager) {
		this.manager = _manager;
	}
}
