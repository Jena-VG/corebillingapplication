package com.cba.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
/**
* DealerDto is used to store dealer details from JSON
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

public class DealerDTO {

	private Long dealerId;

	@NotNull(message = "Dealer number cannot be Null")
	private String dealerNbr;

	private String dealerName;

	private String addressLine1;

	private String addressline2;

	private String city;
	
	@Email(message = "Dealer email should be valid")
	private String email;

	private String dealerGstNbr;

	private Date createdDate;

	private Date updatedDate;

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerNbr() {
		return dealerNbr;
	}

	public void setDealerNbr(String dealerNbr) {
		this.dealerNbr = dealerNbr;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDealerGstNbr() {
		return dealerGstNbr;
	}

	public void setDealerGstNbr(String dealerGstNbr) {
		this.dealerGstNbr = dealerGstNbr;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "DealerDao [dealer_id=" + dealerId + ", dealerNbr=" + dealerNbr + ", dealerName=" + dealerName
				+ ", addressLine_1=" + addressLine1 + ", addressline_2=" + addressline2 + ", city=" + city
				+ ", email=" + email + ", dealerGstNbr=" + dealerGstNbr + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
