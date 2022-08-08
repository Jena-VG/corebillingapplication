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
* Customer is the entity class to map ccs_customer Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/


@Entity
@Table(name = "ccs_customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "customer_nbr")
	private String customerNbr;
	@Column(name = "address_line_1")
	private String addressLine1;
	@Column(name = "address_line_2")
	private String addressLine2;
	private String city;
	private String pincode;
	private String state;
	@Column(name = "sac_code")
	private String sacCode;
	@Column(name = "gst_nbr")
	private String gstNbr;
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;
	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updatedDate;
	
	@Column(name = "city_code")
	private String cityCode;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "isSEZ ")
	private String isSez;
	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNbr() {
		return customerNbr;
	}

	public void setCustomerNbr(String customerNbr) {
		this.customerNbr = customerNbr;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSacCode() {
		return sacCode;
	}

	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}

	public String getGstNbr() {
		return gstNbr;
	}

	public void setGstNbr(String gstNbr) {
		this.gstNbr = gstNbr;
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

	public Customer() {
		super();
	}

	public Customer(Long customer_id, String customerNbr, String addressLine_1, String addressLine_2, String city,
			String pincode, String state, String sacCode, String gstNbr, Date createdDate, Date updatedDate) {
		super();
		this.customerId = customer_id;
		this.customerNbr = customerNbr;
		this.addressLine1 = addressLine_1;
		this.addressLine2 = addressLine_2;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.sacCode = sacCode;
		this.gstNbr = gstNbr;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

 
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the isSez
	 */
	public String getIsSez() {
		return isSez;
	}

	/**
	 * @param isSez the isSez to set
	 */
	public void setIsSez(String isSez) {
		this.isSez = isSez;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerNbr=" + customerNbr + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", pincode=" + pincode + ", state=" + state
				+ ", sacCode=" + sacCode + ", gstNbr=" + gstNbr + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", cityCode=" + cityCode + ", district=" + district + ", isSez=" + isSez + "]";
	}

}
