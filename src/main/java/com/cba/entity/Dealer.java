package com.cba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
* Dealer is the entity class to map ccs_dealer Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

@Entity
@Table(name = "ccs_dealer")
public class Dealer {

	@Id
	@Column(name = "dealer_id")
	private Long dealerId;

	@Column(name = "dealer_nbr")
	private String dealerNbr;

	@Column(name = "dealer_name")
	private String dealerName;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	private String city;
	private String email;

	@Column(name = "dealer_gst_nbr")
	private String dealerGstNbr;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updatedDate;

	@Override
	public String toString() {
		return "Dealer [dealer_id=" + dealerId + ", dealerNbr=" + dealerNbr + ", dealerName=" + dealerName
				+ ", addressLine_1=" + addressLine1 + ", addressline_2=" + addressLine2 + ", city=" + city
				+ ", email=" + email + ", dealerGstNbr=" + dealerGstNbr + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	public Dealer(Long dealerId, String dealerNbr, String dealerName, String addressLine_1, String addressLine2,
			String city, String email, String dealerGstNbr, Date createdDate, Date updatedDate) {
		super();
		this.dealerId = dealerId;
		this.dealerNbr = dealerNbr;
		this.dealerName = dealerName;
		this.addressLine1 = addressLine_1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.email = email;
		this.dealerGstNbr = dealerGstNbr;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Dealer() {
		super();
	}

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

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

}
