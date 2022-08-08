/**
 * 
 */
package com.cba.api.dto;

/**
 * @author subashkumar.t
 *
 */
public class ReportSearchCriteriaDTO {
	
	private String reportName;
	
	private String vinNbr;
	
	private String customerName;
	
	private Integer pkgTypeId;
	
	private String customerNbr;
	
	private String certificateNbr;
	
	private String source;
	
	private String dealerNbr;
	
	private String activationFromDate;
	
	private String activationToDate;
	
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
	 * @return the vinNbr
	 */
	public String getVinNbr() {
		return vinNbr;
	}

	/**
	 * @param vinNbr the vinNbr to set
	 */
	public void setVinNbr(String vinNbr) {
		this.vinNbr = vinNbr;
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
	 * @return the customerNbr
	 */
	public String getCustomerNbr() {
		return customerNbr;
	}

	/**
	 * @param customerNbr the customerNbr to set
	 */
	public void setCustomerNbr(String customerNbr) {
		this.customerNbr = customerNbr;
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
	 * @return the dealerNbr
	 */
	public String getDealerNbr() {
		return dealerNbr;
	}

	/**
	 * @param dealerNbr the dealerNbr to set
	 */
	public void setDealerNbr(String dealerNbr) {
		this.dealerNbr = dealerNbr;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
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

	@Override
	public String toString() {
		return "ReportSearchCriteriaDTO [activationFromDate=" + activationFromDate + ", activationToDate="
				+ activationToDate + ", vinNbr=" + vinNbr + ", customerName=" + customerName + ", pkgTypeId="
				+ pkgTypeId + ", customerNbr=" + customerNbr + ", certificateNbr=" + certificateNbr + ", source="
				+ source + ", dealerNbr=" + dealerNbr + ", reportName=" + reportName  
				+ ", state=" + state + ", city=" + city + "]";
	}

	
}
