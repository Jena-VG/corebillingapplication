package com.cba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
* Subscription is the entity class to map ccs_subscriptions Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/
@Entity
@Table(name="ccs_subscriptions")
public class Subscription {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="subscription_id")
	private Long subscriptionId;
	
	
	@Column(name = "pkg_type_id")
	private int pkgTypeId;
	

	@Column(name = "vin_nbr")
	private String vinNbr;
	
	@Column(name = "subscription_nbr")
	private String subscriptionNbr;
	
	@Column(name = "certificate_nbr")
	private String certificateNbr;
	
	@Column(name = "dealer_id")
	private int dealerId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "program_type")
	private String programType;
	

	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	@Column(name = "variant_name")
	private String variantName;
	
	@Column(name = "vehicle_sold_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date vehicleSoldDate;
	
	@Column(name = "reg_nbr")
	private String regNbr;
	
	@Column(name = "reg_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date regDate;
	
	
	@Column(name = "odometer_reading")
	private String odometerReading;
	
	@Column(name = "activation_from_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date activationFromDate;
	

	@Column(name = "activation_to_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date activationToDate;
	
	@Column(name = "irn_nbr")
	private String irnNbr;
	
	

	@Column(name = "qr_code")
	private String qrCode;
	
	@Column(name = "pkg_price")
	private double pkgPrice;
	
	

	private double igst;
	
	private double cgst;
	

	private double sgst;
	
	@Column(name = "discount_amount")
	private double discountAmount;
	
	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "pymt_trans_nbr")
	private String pymtTransNbr;

	@Column(name = "pymt_trans_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date pymtTransDate;

	@Column(name = "paid_amount")
	private double paidAmount;

	
	@Column(name = "pymt_status")
	private String pymtStatus;
	

	@Column(name = "inv_nbr")
	private String invNbr;


	@Column(name = "inv_generated_on")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date invGeneratedOn;

	/*
	 * @Column(name = "active_flag") private String active_flag;
	 */
	@Column(name = "created_by")
	private int created_by;
	
	@Column(name = "updated_by")
	private int updated_by;
	
	 @Column(name = "created_date")
 	 @Temporal(TemporalType.DATE)
 	 @JsonFormat(pattern="dd-MM-yyyy")
 	 private Date createdDate;
 	 
     @Column(name = "updated_date")
 	 @Temporal(TemporalType.DATE)
 	 @JsonFormat(pattern="dd-MM-yyyy")
 	 private Date updatedDate;
     
	 @Column(name = "rsa_amount")
	 private double rsaAmount;
    
	 @Column(name = "rsaigst")
	 private double rsaigst;
	 
	 @Column(name = "rsacgst")
	 private double rsacgst;
	 
	 @Column(name = "rsasgst")
	 private double rsasgst;
	 
	 @Column(name = "source")
	 private String source;
	 
	 @Column(name = "utrno")
	 private String utrno;
	 
	 @Transient
	 private String ackNbr;
	 
	 @Transient
	 private String ackDt;
	 
	 @Transient
	 private String customerEmail;
	 
	 @Transient
	 private String customerName;

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getPkgTypeId() {
		return pkgTypeId;
	}

	public double getRsaAmount() {
		return rsaAmount;
	}

	public void setRsaAmount(double rsaAmount) {
		this.rsaAmount = rsaAmount;
	}

	public void setPkgTypeId(int pkgTypeId) {
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

	public void setCertificateNbr(String certifictaeNbr) {
		this.certificateNbr = certifictaeNbr;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
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

	public Date getVehicleSoldDate() {
		return vehicleSoldDate;
	}

	public void setVehicleSoldDate(Date vehicleSoldDate) {
		this.vehicleSoldDate = vehicleSoldDate;
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

	public Date getActivationFromDate() {
		return activationFromDate;
	}

	public void setActivationFromDate(Date activationFromDate) {
		this.activationFromDate = activationFromDate;
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

	public Date getPymtTransDate() {
		return pymtTransDate;
	}

	public void setPymtTransDate(Date pymtTransDate) {
		this.pymtTransDate = pymtTransDate;
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

	public Date getInvGeneratedOn() {
		return invGeneratedOn;
	}

	public void setInvGeneratedOn(Date invGeneratedOn) {
		this.invGeneratedOn = invGeneratedOn;
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

	public Subscription() {
		super();
	}


	/**
	 * @return the rsacgst
	 */
	public double getRsacgst() {
		return rsacgst;
	}

	/**
	 * @param rsacgst the rsacgst to set
	 */
	public void setRsacgst(double rsacgst) {
		this.rsacgst = rsacgst;
	}

	/**
	 * @return the rsasgst
	 */
	public double getRsasgst() {
		return rsasgst;
	}

	/**
	 * @param rsasgst the rsasgst to set
	 */
	public void setRsasgst(double rsasgst) {
		this.rsasgst = rsasgst;
	}

	 

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the ackNbr
	 */
	public String getAckNbr() {
		return ackNbr;
	}

	/**
	 * @param ackNbr the ackNbr to set
	 */
	public void setAckNbr(String ackNbr) {
		this.ackNbr = ackNbr;
	}

	/**
	 * @return the ackDt
	 */
	public String getAckDt() {
		return ackDt;
	}

	/**
	 * @param ackDt the ackDt to set
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the rsaigst
	 */
	public double getRsaigst() {
		return rsaigst;
	}

	/**
	 * @param rsaigst the rsaigst to set
	 */
	public void setRsaigst(double rsaigst) {
		this.rsaigst = rsaigst;
	}

	/**
	 * @return the utrno
	 */
	public String getUtrno() {
		return utrno;
	}

	/**
	 * @param utrno the utrno to set
	 */
	public void setUtrno(String utrno) {
		this.utrno = utrno;
	}

	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", pkgTypeId=" + pkgTypeId + ", vinNbr=" + vinNbr
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
				+ updatedDate + ", rsaAmount=" + rsaAmount + ", rsaigst=" + rsaigst + ", rsacgst=" + rsacgst
				+ ", rsasgst=" + rsasgst + ", source=" + source + ", utrno=" + utrno + ", ackNbr=" + ackNbr + ", ackDt="
				+ ackDt + ", customerEmail=" + customerEmail + ", customerName=" + customerName + "]";
	}

	public Subscription(Long subscriptionId, int pkgTypeId, String vinNbr, String subscriptionNbr,
			String certificateNbr, int dealerId, String deptName, long customerId, Integer empId, String programType,
			String modelName, String fuelType, String variantName, Date vehicleSoldDate, String regNbr, Date regDate,
			String odometerReading, Date activationFromDate, Date activationToDate, String irnNbr, String qrCode,
			double pkgPrice, double igst, double cgst, double sgst, double discountAmount, double totalAmount,
			String pymtTransNbr, Date pymtTransDate, double paidAmount, String pymtStatus, String invNbr,
			Date invGeneratedOn, int created_by, int updated_by, Date createdDate, Date updatedDate, double rsaAmount,
			double rsaigst, double rsacgst, double rsasgst, String source, String utrno, String ackNbr, String ackDt,
			String customerEmail, String customerName) {
		super();
		this.subscriptionId = subscriptionId;
		this.pkgTypeId = pkgTypeId;
		this.vinNbr = vinNbr;
		this.subscriptionNbr = subscriptionNbr;
		this.certificateNbr = certificateNbr;
		this.dealerId = dealerId;
		this.deptName = deptName;
		this.customerId = customerId;
		this.empId = empId;
		this.programType = programType;
		this.modelName = modelName;
		this.fuelType = fuelType;
		this.variantName = variantName;
		this.vehicleSoldDate = vehicleSoldDate;
		this.regNbr = regNbr;
		this.regDate = regDate;
		this.odometerReading = odometerReading;
		this.activationFromDate = activationFromDate;
		this.activationToDate = activationToDate;
		this.irnNbr = irnNbr;
		this.qrCode = qrCode;
		this.pkgPrice = pkgPrice;
		this.igst = igst;
		this.cgst = cgst;
		this.sgst = sgst;
		this.discountAmount = discountAmount;
		this.totalAmount = totalAmount;
		this.pymtTransNbr = pymtTransNbr;
		this.pymtTransDate = pymtTransDate;
		this.paidAmount = paidAmount;
		this.pymtStatus = pymtStatus;
		this.invNbr = invNbr;
		this.invGeneratedOn = invGeneratedOn;
		this.created_by = created_by;
		this.updated_by = updated_by;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.rsaAmount = rsaAmount;
		this.rsaigst = rsaigst;
		this.rsacgst = rsacgst;
		this.rsasgst = rsasgst;
		this.source = source;
		this.utrno = utrno;
		this.ackNbr = ackNbr;
		this.ackDt = ackDt;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
	}

	
     

	
	
}
