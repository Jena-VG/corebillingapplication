package com.cba.api.dto;

public class GSTParamsDTO {

	/** Certificate Number */
	private String certificateNbr;

	/** GST IRN Number **/
	private String irnNbr;

	/** GST QR Code **/
	private String qrCode;

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
	 * @return the irnNbr
	 */
	public String getIrnNbr() {
		return irnNbr;
	}

	/**
	 * @param irnNbr the irnNbr to set
	 */
	public void setIrnNbr(String irnNbr) {
		this.irnNbr = irnNbr;
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

}
