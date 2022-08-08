package com.cba.api.dto;

/**
 * Data Transfer object that is used to convert the incoming JSON parameters to
 * the API into java objects.
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

public class CustomerDealerDTO {

	/*
	 * DTO to carry the customer details for subscription renewal
	 */
	private CustomerDTO customerinfo;
	
	/**
	 * @return the customerinfo
	 */
	public CustomerDTO getCustomerinfo() {
		return customerinfo;
	}

	/**
	 * @param customerinfo the customerinfo to set
	 */
	public void setCustomerinfo(CustomerDTO customerinfo) {
		this.customerinfo = customerinfo;
	}

	/*
	 * DTO to carry dealter information for subscription renewal
	 */
	private DealerDTO dealerinfo;

	/**
	 * @return the dealerinfo
	 */
	public DealerDTO getDealerinfo() {
		return dealerinfo;
	}

	/**
	 * @param dealerinfo the dealerinfo to set
	 */
	public void setDealerinfo(DealerDTO dealerinfo) {
		this.dealerinfo = dealerinfo;
	}

	/**
	 * @return the employeeinfo
	 */
	public EmployeeDTO getEmployeeinfo() {
		return employeeinfo;
	}

	/**
	 * @param employeeinfo the employeeinfo to set
	 */
	public void setEmployeeinfo(EmployeeDTO employeeinfo) {
		this.employeeinfo = employeeinfo;
	}

	/**
	 * @return the subscriptioninfo
	 */
	public SubscriptionDTO getSubscriptioninfo() {
		return subscriptioninfo;
	}

	/**
	 * @param subscriptioninfo the subscriptioninfo to set
	 */
	public void setSubscriptioninfo(SubscriptionDTO subscriptioninfo) {
		this.subscriptioninfo = subscriptioninfo;
	}

	/*
	 * The Dealer employee who renewed the subscription
	 */
	private EmployeeDTO employeeinfo;
	
	/*
	 * Subscription details
	 */
	private SubscriptionDTO subscriptioninfo;
	
	
	 

	
}
