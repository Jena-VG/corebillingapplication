package com.cba.api.dto;

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
public class CertificateGenerationDTO {

	private String certificateNumber;

	private String vinNumber;

	private String modelCode;

	private String customerNumber;

	private String customerName;

	private String modelName;

	private String packageEndDate;

	private String dealerCode;

	private String subscriptionPurchaseDate;

	private String schemeCode;

	private String packageType;

	private String corpNo;

	private String type;

	private String dlrNo;

	private String compNo;

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getCorpNo() {
		return corpNo;
	}

	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDlrNo() {
		return dlrNo;
	}

	public void setDlrNo(String dlrNo) {
		this.dlrNo = dlrNo;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	@Override
	public String toString() {
		return "CertificateGenerationDTO [certificateNumber=" + certificateNumber + ", vinNumber=" + vinNumber
				+ ", modelCode=" + modelCode + ", customerNumber=" + customerNumber + ", customerName=" + customerName
				+ ", modelName=" + modelName + ", packageEndDate=" + packageEndDate + ", dealerCode=" + dealerCode
				+ ", subscriptionPurchaseDate=" + subscriptionPurchaseDate + ", schemeCode=" + schemeCode
				+ ", packageType=" + packageType + ", corpNo=" + corpNo + ", type=" + type + ", dlrNo=" + dlrNo
				+ ", compNo=" + compNo + "]";
	}

}
