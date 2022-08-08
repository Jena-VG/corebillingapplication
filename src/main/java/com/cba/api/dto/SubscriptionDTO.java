package com.cba.api.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
* SubscriptionDto is used to store Subscription details from JSON
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

public class SubscriptionDTO {

	private Long subscriptionId;
	private String pkgTypeId;
	
	@NotNull(message = "VIN numer cannot be Null")
	private String vinNbr;
	private String subscriptionNbr;
	private String certificateNbr;
	private long dealerId;
	private String deptName;
	private long customerId;
	private long empId;
	private String programType;
	private String modelName;
	private String fuelType;
	private String variantName;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date vehicleSoldDate;
	private String regNbr;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date regDate;
	private String odometerReading;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date activationFromDate;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date activationToDate;
	private String irnNbr;
	private String qrCode;
	private double pkgPrice;
	private double igst;
	private double cgst;
	private double sgst;
	private double discountAmount;
	private double totalAmount;
	private String pymtTransNbr;
	private Date pymtTransDate;
	private double paidAmount;
	private String pymtStatus;
	private String invNbr;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date invGeneratedOn;
	private int created_by;
	private int updated_by;
	private Date createdDate;
	private Date updatedDate;
	private String pkgCode;
	private double rsaAmount;

	public double getRsaAmount() {
		return rsaAmount;
	}

	public void setRsaAmount(double rsaAmount) {
		this.rsaAmount = rsaAmount;
	}

	public String getPkgCode() {
		return pkgCode;
	}

	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getPkgTypeId() {
		return pkgTypeId;
	}

	public void setPkgTypeId(String pkgTypeId) {
		this.pkgTypeId = pkgTypeId;
	}

	public String getVinNbr() {
		return vinNbr;
	}

	public void setVinNbr(String vinNbr) {
		this.vinNbr = vinNbr;
	}

	public String getSubscriptionNbr() {
		return subscriptionNbr;
	}

	public void setSubscriptionNbr(String subscriptionNbr) {
		this.subscriptionNbr = subscriptionNbr;
	}

	public String getCertificateNbr() {
		return certificateNbr;
	}

	public void setCertificateNbr(String certificateNbr) {
		this.certificateNbr = certificateNbr;
	}

	public long getDealerId() {
		return dealerId;
	}

	public void setDealerId(long dealerId) {
		this.dealerId = dealerId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public String getRegNbr() {
		return regNbr;
	}

	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(String odometerReading) {
		this.odometerReading = odometerReading;
	}

	public Date getActivationToDate() {
		return activationToDate;
	}

	public void setActivationToDate(Date activationToDate) {
		this.activationToDate = activationToDate;
	}

	public String getIrnNbr() {
		return irnNbr;
	}

	public void setIrnNbr(String irnNbr) {
		this.irnNbr = irnNbr;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public double getPkgPrice() {
		return pkgPrice;
	}

	public void setPkgPrice(double pkgPrice) {
		this.pkgPrice = pkgPrice;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPymtTransNbr() {
		return pymtTransNbr;
	}

	public void setPymtTransNbr(String pymtTransNbr) {
		this.pymtTransNbr = pymtTransNbr;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPymtStatus() {
		return pymtStatus;
	}

	public void setPymtStatus(String pymtStatus) {
		this.pymtStatus = pymtStatus;
	}

	public String getInvNbr() {
		return invNbr;
	}

	public void setInvNbr(String invNbr) {
		this.invNbr = invNbr;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
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

	public Date getVehicleSoldDate() {
		return vehicleSoldDate;
	}

	public void setVehicleSoldDate(Date vehicleSoldDate) {
		this.vehicleSoldDate = vehicleSoldDate;
	}

	public Date getActivationFromDate() {
		return activationFromDate;
	}

	public void setActivationFromDate(Date activationFromDate) {
		this.activationFromDate = activationFromDate;
	}

	public Date getInvGeneratedOn() {
		return invGeneratedOn;
	}

	public void setInvGeneratedOn(Date invGeneratedOn) {
		this.invGeneratedOn = invGeneratedOn;
	}

	public Date getPymtTransDate() {
		return pymtTransDate;
	}

	public void setPymtTransDate(Date pymtTransDate) {
		this.pymtTransDate = pymtTransDate;
	}

	@Override
	public String toString() {
		return "SubscriptionDao [subscription_id=" + subscriptionId + ", pkgTypeId=" + pkgTypeId + ", vinNbr=" + vinNbr
				+ ", subscriptionNbr=" + subscriptionNbr + ", certificateNbr=" + certificateNbr + ", dealerId="
				+ dealerId + ", deptName=" + deptName + ", customerId=" + customerId + ", empId=" + empId
				+ ", programType=" + programType + ", modelName=" + modelName + ", fuelType=" + fuelType
				+ ", variantName=" + variantName + ", vehicleSoldDate=" + vehicleSoldDate + ", regNbr=" + regNbr
				+ ", regDate=" + regDate + ", odometerReading=" + odometerReading + ", activationFromDate="
				+ activationFromDate + ", activationToDate=" + activationToDate + ", irnNbr=" + irnNbr + ", qrCode="
				+ qrCode + ", pkgPrice=" + pkgPrice + ", igst=" + igst + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", discountAmount=" + discountAmount + ", totalAmount=" + totalAmount + ", pymtTransNbr="
				+ pymtTransNbr + ", pymtTransDate=" + pymtTransDate + ", paidAmount=" + paidAmount + ", pymtStatus="
				+ pymtStatus + ", invNbr=" + invNbr + ", invGeneratedOn=" + invGeneratedOn + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", pkgCode=" + pkgCode + ", rsaAmount=" + rsaAmount + ", getRsaAmount()="
				+ getRsaAmount() + ", getPkgCode()=" + getPkgCode() + ", getSubscription_id()=" + getSubscriptionId()
				+ ", getPkgTypeId()=" + getPkgTypeId() + ", getVinNbr()=" + getVinNbr() + ", getSubscriptionNbr()="
				+ getSubscriptionNbr() + ", getCertificateNbr()=" + getCertificateNbr() + ", getDealerId()="
				+ getDealerId() + ", getDeptName()=" + getDeptName() + ", getCustomerId()=" + getCustomerId()
				+ ", getEmpId()=" + getEmpId() + ", getProgramType()=" + getProgramType() + ", getModelName()="
				+ getModelName() + ", getFuelType()=" + getFuelType() + ", getVariantName()=" + getVariantName()
				+ ", getRegNbr()=" + getRegNbr() + ", getRegDate()=" + getRegDate() + ", getOdometerReading()="
				+ getOdometerReading() + ", getActivationToDate()=" + getActivationToDate() + ", getIrnNbr()="
				+ getIrnNbr() + ", getQrCode()=" + getQrCode() + ", getPkgPrice()=" + getPkgPrice() + ", getIgst()="
				+ getIgst() + ", getCgst()=" + getCgst() + ", getSgst()=" + getSgst() + ", getDiscountAmount()="
				+ getDiscountAmount() + ", getTotalAmount()=" + getTotalAmount() + ", getPymtTransNbr()="
				+ getPymtTransNbr() + ", getPaidAmount()=" + getPaidAmount() + ", getPymtStatus()=" + getPymtStatus()
				+ ", getInvNbr()=" + getInvNbr() + ", getCreated_by()=" + getCreated_by() + ", getUpdated_by()="
				+ getUpdated_by() + ", getCreatedDate()=" + getCreatedDate() + ", getUpdatedDate()=" + getUpdatedDate()
				+ ", getVehicleSoldDate()=" + getVehicleSoldDate() + ", getActivationFromDate()="
				+ getActivationFromDate() + ", getInvGeneratedOn()=" + getInvGeneratedOn() + ", getPymtTransDate()="
				+ getPymtTransDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
