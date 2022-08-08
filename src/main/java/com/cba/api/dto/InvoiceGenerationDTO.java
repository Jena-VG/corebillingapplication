package com.cba.api.dto;

import java.math.BigDecimal;
import java.math.MathContext;

import com.cba.api.utils.AmountToWordsConverter;
import com.cba.api.utils.BarcodeUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer object that is used get the parameters for printing Certificate
 *
 * @author Balaji Desikan
 * @version 1.0
 * @since 2022-07-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceGenerationDTO {

	private String invoiceNo;

	private String vinNo;

	private String invoiceDate;

	private String kiaAddress ="NH-44, Sy.No.151-2, Erramanchi Village, Penukonda (M),\r\n"
			+ "Anantapur District, Andhra Pradesh – 515 164";
	
	private String kiaGst ="37AAGCK5972Q6ZG";
	
	private String customerNumber;

	private String customerName;
	
	private String customerAddress;
	
	private String customerGst;

	private String modelName;

	private String packageEndDate;

	private String dealerCode;

	private String subscriptionPurchaseDate;

	private String schemeCode;

	private String packageDesc;
  
	private String dlrNo;

	
	private BigDecimal packPrice = new BigDecimal(0);
	
	private BigDecimal rsaAmount = new BigDecimal(0);
	
	private BigDecimal sgst = new BigDecimal(0);
	
	private BigDecimal igst = new BigDecimal(0);
	
	private BigDecimal  cgst = new BigDecimal(0);
	
	private BigDecimal rsaIgst = new BigDecimal(0);
	
	private BigDecimal rsaSgst = new BigDecimal(0); 
	
	private BigDecimal rsaCgst = new BigDecimal(0);
	
    private BigDecimal netValue = new BigDecimal(0);
	
	private String qrCode;
	
	private String irnNo;
	
	private BigDecimal subScriptionPrice = new BigDecimal(0);
	
	private BigDecimal tax = new BigDecimal(0);
	
	private String subPriceInWords;
	
	private String taxInWords;
	


	public String getQrCode() {
		if (qrCode != null && qrCode.trim().length() > 0) {
			qrCode = BarcodeUtils.getQRCodeImage(this.qrCode, 100, 100);
		} else {
			// Generate Local QR Code
			qrCode = BarcodeUtils.getQRCodeImage(this.invoiceNo+ "INV" + this.invoiceDate+ this.subScriptionPrice, 100, 100);
		}
		qrCode = "data:image/png;base64," +qrCode;
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		
		 this.qrCode = qrCode;
		
		
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getKiaAddress() {
		return kiaAddress;
	}

	public void setKiaAddress(String kiaAddress) {
		this.kiaAddress = kiaAddress;
	}

	public String getKiaGst() {
		return kiaGst;
	}

	public void setKiaGst(String kiaGst) {
		this.kiaGst = kiaGst;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerGst() {
		return customerGst;
	}

	public void setCustomerGst(String customerGst) {
		this.customerGst = customerGst;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getPackageEndDate() {
		return packageEndDate;
	}

	public void setPackageEndDate(String packageEndDate) {
		this.packageEndDate = packageEndDate;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getSubscriptionPurchaseDate() {
		return subscriptionPurchaseDate;
	}

	public void setSubscriptionPurchaseDate(String subscriptionPurchaseDate) {
		this.subscriptionPurchaseDate = subscriptionPurchaseDate;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public String getDlrNo() {
		return dlrNo;
	}

	public void setDlrNo(String dlrNo) {
		this.dlrNo = dlrNo;
	}

	public BigDecimal getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(BigDecimal packPrice) {
		this.packPrice = packPrice;
	}

	public BigDecimal getRsaAmount() {
		return rsaAmount;
	}

	public void setRsaAmount(BigDecimal rsaAmount) {
		this.rsaAmount = rsaAmount;
	}

	public BigDecimal getSgst() {
		return sgst.add(rsaSgst);
	}

	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

	public BigDecimal getIgst() {
		return igst.add(rsaIgst);
	}

	public void setIgst(BigDecimal igst) {
		this.igst = igst;
	}

	public BigDecimal getCgst() {
		return cgst.add(rsaCgst);
	}

	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}

	public BigDecimal getRsaIgst() {
		return rsaIgst;
	}

	public void setRsaIgst(BigDecimal rsaIgst) {
		this.rsaIgst = rsaIgst;
	}

	public BigDecimal getRsaSgst() {
		return rsaSgst;
	}

	public void setRsaSgst(BigDecimal rsaSgst) {
		this.rsaSgst = rsaSgst;
	}

	public BigDecimal getRsaCgst() {
		return rsaCgst;
	}

	public void setRsaCgst(BigDecimal rsaCgst) {
		this.rsaCgst = rsaCgst;
	}

	public String getIrnNo() {
		return irnNo;
	}

	public void setIrnNo(String irnNo) {
		this.irnNo = irnNo;
	}

	public BigDecimal getSubScriptionPrice() {
		
		subScriptionPrice = packPrice.add(rsaAmount).add(getTax());
		subScriptionPrice = subScriptionPrice.round(new MathContext(0));
		return subScriptionPrice;
	}

	public void setSubScriptionPrice(BigDecimal subScriptionPrice) {
		this.subScriptionPrice = subScriptionPrice;
	}

	public BigDecimal getTax() {
		tax = sgst.add(igst).add(cgst).add(rsaCgst).add(rsaIgst).add(rsaSgst);
		tax = tax.round(new MathContext(0));
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "InvoiceGenerationDTO [invoiceNo=" + invoiceNo + ", vinNo=" + vinNo + ", invoiceDate=" + invoiceDate
				+ ", kiaAddress=" + kiaAddress + ", kiaGst=" + kiaGst + ", customerNumber=" + customerNumber
				+ ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerGst="
				+ customerGst + ", modelName=" + modelName + ", packageEndDate=" + packageEndDate + ", dealerCode="
				+ dealerCode + ", subscriptionPurchaseDate=" + subscriptionPurchaseDate + ", schemeCode=" + schemeCode
				+ ", packageDesc=" + packageDesc + ", dlrNo=" + dlrNo + ", packPrice=" + packPrice + ", rsaAmount="
				+ rsaAmount + ", sgst=" + sgst + ", igst=" + igst + ", cgst=" + cgst + ", rsaIgst=" + rsaIgst
				+ ", rsaSgst=" + rsaSgst + ", rsaCgst=" + rsaCgst + ", qrCode=" + qrCode + ", irnNo=" + irnNo
				+ ", subScriptionPrice=" + subScriptionPrice + ", tax=" + tax + "]";
	}

	public String getSubPriceInWords() {
		subPriceInWords = AmountToWordsConverter.convert(getSubScriptionPrice().intValue());
		return subPriceInWords;
	}

	public void setSubPriceInWords(String subPriceInWords) {
		this.subPriceInWords = subPriceInWords;
	}

	public String getTaxInWords() {
		taxInWords = AmountToWordsConverter.convert(getTax().intValue());
		return taxInWords;
	}

	public void setTaxInWords(String taxInWords) {
		this.taxInWords = taxInWords;
	}

	public BigDecimal getNetValue() {
		netValue = packPrice.add(rsaAmount);
		return netValue.round(new MathContext(0));
	}

	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	
 
}
