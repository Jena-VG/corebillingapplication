package com.cba.api.dto;

public class SubscriptionParamsDTO {

	private String certificateNumber;
	
	private String vinNumber;
	
	private String packageTypeCode;

	/**
	 * @return the certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * @param certificateNumber the certificateNumber to set
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	/**
	 * @return the vinNumnber
	 */
	public String getVinNumber() {
		return vinNumber;
	}

	/**
	 * @param vinNumnber the vinNumnber to set
	 */
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	/**
	 * @return the packageTypeCode
	 */
	public String getPackageTypeCode() {
		return packageTypeCode;
	}

	/**
	 * @param packageTypeCode the packageTypeCode to set
	 */
	public void setPackageTypeCode(String packageTypeCode) {
		this.packageTypeCode = packageTypeCode;
	}
	
	
	
}
