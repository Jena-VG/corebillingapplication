package com.cba.api.dto;

import java.math.BigDecimal;

public class ReportResultDTO {
	
	private String activationFromDate;
	
	private String activationToDate;
	
	private String customerName;
	
	private Integer pkgTypeId;
	
	private String certificateNbr;
		
	private String source;
	
	private String deptName;
	
	private String modelName;
	
	private String regNbr;
	
	private String isActive;
	
	private String  empId ;
	
	private String employeeName;
	
	private String invoiceNo;

	private String vinNo;
	
	private String gstNbr;

	private String invoiceDate;

	private String customerNumber;

	private String customerAddress;
	
	private String customerGst;

	private String packageEndDate;

	private String dealerCode;

	private String subscriptionPurchaseDate;
	
	private String subscriptionNbr;

	private String schemeCode;

	private String packageDesc;
  
	private BigDecimal packPrice = new BigDecimal(0);
	
	private BigDecimal rsaAmount = new BigDecimal(0);
	
	private BigDecimal sgst = new BigDecimal(0);
	
	private BigDecimal igst = new BigDecimal(0);
	
	private BigDecimal  cgst = new BigDecimal(0);
	
	private BigDecimal rsaIgst = new BigDecimal(0);
	
	private BigDecimal rsaSgst = new BigDecimal(0); 
	
	private BigDecimal rsaCgst = new BigDecimal(0);
	
    private BigDecimal netValue = new BigDecimal(0);
    
    private BigDecimal totalAmount = new BigDecimal(0);
	
	private String qrCode;
	
	private String irnNo;
	
	private BigDecimal subScriptionPrice = new BigDecimal(0);
	
	private BigDecimal tax = new BigDecimal(0);
	
	private String subPriceInWords;
	
	private String taxInWords;
	
	private String state;
	
	private String city;

	/**
	 * @return the activationFromDate
	 */
	public String getActivationFromDate() {
		return activationFromDate;
	}

	/**
	 * @param activationFromDate the activationFromDate to set
	 */
	public void setActivationFromDate(String activationFromDate) {
		this.activationFromDate = activationFromDate;
	}

	/**
	 * @return the activationToDate
	 */
	public String getActivationToDate() {
		return activationToDate;
	}

	/**
	 * @param activationToDate the activationToDate to set
	 */
	public void setActivationToDate(String activationToDate) {
		this.activationToDate = activationToDate;
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
	 * @return the pkgTypeId
	 */
	public Integer getPkgTypeId() {
		return pkgTypeId;
	}

	/**
	 * @param pkgTypeId the pkgTypeId to set
	 */
	public void setPkgTypeId(Integer pkgTypeId) {
		this.pkgTypeId = pkgTypeId;
	}

	/**
	 * @return the certificateNbr
	 */
	public String getCertificateNbr() {
		return certificateNbr;
	}

	/**
	 * @param certificateNbr the certificateNbr to set
	 */
	public void setCertificateNbr(String certificateNbr) {
		this.certificateNbr = certificateNbr;
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
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return the regNbr
	 */
	public String getRegNbr() {
		return regNbr;
	}

	/**
	 * @param regNbr the regNbr to set
	 */
	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the vinNo
	 */
	public String getVinNo() {
		return vinNo;
	}

	/**
	 * @param vinNo the vinNo to set
	 */
	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	/**
	 * @return the gstNbr
	 */
	public String getGstNbr() {
		return gstNbr;
	}

	/**
	 * @param gstNbr the gstNbr to set
	 */
	public void setGstNbr(String gstNbr) {
		this.gstNbr = gstNbr;
	}

	/**
	 * @return the invoiceDate
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return the customerGst
	 */
	public String getCustomerGst() {
		return customerGst;
	}

	/**
	 * @param customerGst the customerGst to set
	 */
	public void setCustomerGst(String customerGst) {
		this.customerGst = customerGst;
	}

	/**
	 * @return the packageEndDate
	 */
	public String getPackageEndDate() {
		return packageEndDate;
	}

	/**
	 * @param packageEndDate the packageEndDate to set
	 */
	public void setPackageEndDate(String packageEndDate) {
		this.packageEndDate = packageEndDate;
	}

	/**
	 * @return the dealerCode
	 */
	public String getDealerCode() {
		return dealerCode;
	}

	/**
	 * @param dealerCode the dealerCode to set
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	/**
	 * @return the subscriptionPurchaseDate
	 */
	public String getSubscriptionPurchaseDate() {
		return subscriptionPurchaseDate;
	}

	/**
	 * @param subscriptionPurchaseDate the subscriptionPurchaseDate to set
	 */
	public void setSubscriptionPurchaseDate(String subscriptionPurchaseDate) {
		this.subscriptionPurchaseDate = subscriptionPurchaseDate;
	}

	/**
	 * @return the subscriptionNbr
	 */
	public String getSubscriptionNbr() {
		return subscriptionNbr;
	}

	/**
	 * @param subscriptionNbr the subscriptionNbr to set
	 */
	public void setSubscriptionNbr(String subscriptionNbr) {
		this.subscriptionNbr = subscriptionNbr;
	}

	/**
	 * @return the schemeCode
	 */
	public String getSchemeCode() {
		return schemeCode;
	}

	/**
	 * @param schemeCode the schemeCode to set
	 */
	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	/**
	 * @return the packageDesc
	 */
	public String getPackageDesc() {
		return packageDesc;
	}

	/**
	 * @param packageDesc the packageDesc to set
	 */
	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	/**
	 * @return the packPrice
	 */
	public BigDecimal getPackPrice() {
		return packPrice;
	}

	/**
	 * @param packPrice the packPrice to set
	 */
	public void setPackPrice(BigDecimal packPrice) {
		this.packPrice = packPrice;
	}

	/**
	 * @return the rsaAmount
	 */
	public BigDecimal getRsaAmount() {
		return rsaAmount;
	}

	/**
	 * @param rsaAmount the rsaAmount to set
	 */
	public void setRsaAmount(BigDecimal rsaAmount) {
		this.rsaAmount = rsaAmount;
	}

	/**
	 * @return the sgst
	 */
	public BigDecimal getSgst() {
		return sgst;
	}

	/**
	 * @param sgst the sgst to set
	 */
	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

	/**
	 * @return the igst
	 */
	public BigDecimal getIgst() {
		return igst;
	}

	/**
	 * @param igst the igst to set
	 */
	public void setIgst(BigDecimal igst) {
		this.igst = igst;
	}

	/**
	 * @return the cgst
	 */
	public BigDecimal getCgst() {
		return cgst;
	}

	/**
	 * @param cgst the cgst to set
	 */
	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	/**
	 * @return the rsaIgst
	 */
	public BigDecimal getRsaIgst() {
		return rsaIgst;
	}

	/**
	 * @param rsaIgst the rsaIgst to set
	 */
	public void setRsaIgst(BigDecimal rsaIgst) {
		this.rsaIgst = rsaIgst;
	}

	/**
	 * @return the rsaSgst
	 */
	public BigDecimal getRsaSgst() {
		return rsaSgst;
	}

	/**
	 * @param rsaSgst the rsaSgst to set
	 */
	public void setRsaSgst(BigDecimal rsaSgst) {
		this.rsaSgst = rsaSgst;
	}

	/**
	 * @return the rsaCgst
	 */
	public BigDecimal getRsaCgst() {
		return rsaCgst;
	}

	/**
	 * @param rsaCgst the rsaCgst to set
	 */
	public void setRsaCgst(BigDecimal rsaCgst) {
		this.rsaCgst = rsaCgst;
	}

	/**
	 * @return the netValue
	 */
	public BigDecimal getNetValue() {
		return netValue;
	}

	/**
	 * @param netValue the netValue to set
	 */
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * @return the irnNo
	 */
	public String getIrnNo() {
		return irnNo;
	}

	/**
	 * @param irnNo the irnNo to set
	 */
	public void setIrnNo(String irnNo) {
		this.irnNo = irnNo;
	}

	/**
	 * @return the subScriptionPrice
	 */
	public BigDecimal getSubScriptionPrice() {
		return subScriptionPrice;
	}

	/**
	 * @param subScriptionPrice the subScriptionPrice to set
	 */
	public void setSubScriptionPrice(BigDecimal subScriptionPrice) {
		this.subScriptionPrice = subScriptionPrice;
	}

	/**
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * @return the subPriceInWords
	 */
	public String getSubPriceInWords() {
		return subPriceInWords;
	}

	/**
	 * @param subPriceInWords the subPriceInWords to set
	 */
	public void setSubPriceInWords(String subPriceInWords) {
		this.subPriceInWords = subPriceInWords;
	}

	/**
	 * @return the taxInWords
	 */
	public String getTaxInWords() {
		return taxInWords;
	}

	/**
	 * @param taxInWords the taxInWords to set
	 */
	public void setTaxInWords(String taxInWords) {
		this.taxInWords = taxInWords;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	


}