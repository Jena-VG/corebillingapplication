package com.cba.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
/**
* CustomerDto is used to store Customer details from JSON
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

public class CustomerDTO {

	private Long customerId;
	
	@NotNull(message = "Customer Number cannot be Null")
	private String customerNbr;
	
	@NotNull(message = "Customer address line 1 cannot be Null")
	private String addressLine1;
	
	private String addressLine2;
	
	@NotNull(message = "Customer city cannot be null")
	private String city;
	
	private String cityCode;
	
	private String pincode;
	
	private String district;
	
	private String state;
	
	private String sacCode;
	
	private String gstNbr;
	
	@Email(message = "Customer email should be valid")
	private String email;
	
	private String mobile;
	
	@NotNull(message = "Customer name cannot be null")
	private String name;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	private String isSez;
	
	private VehicleDetailsDTO vehicleDetails;

	
	public String getEmail() {
		return email;
	}

	 
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	 * @return the vehicleDetails
	 */
	public VehicleDetailsDTO getVehicleDetails() {
		return vehicleDetails;
	}


	/**
	 * @param vehicleDetails the vehicleDetails to set
	 */
	public void setVehicleDetails(VehicleDetailsDTO vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

}
