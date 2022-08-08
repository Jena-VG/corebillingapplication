package com.cba.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * AuditLog is the entity class to map ccs_interface_audit_log_seq Table from Database
 * 
 * @author subashkumar.t
 *@version 1.0
 * @since   2022-06-17
 */

@Entity
@Table(name= "ccs_interface_audit_log")
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ccs_interface_id")	
	private int ccsInterfaceId;
	
	@Column(name="requested_on")
	private Timestamp requestedOn;
	
	@Column(name="requested_from" ,length =45 )
	private String requestedFrom;
	
	@Column(name="requested_parameter",columnDefinition = "TEXT")
	private String requestedParameter;
	
	@Column(name="destination_api",length=45)
	private String destinationApi;
	
	@Column(name="dest_request_on")
    private  Timestamp destrequestOn;
	
	@Column(name="response_parameter",columnDefinition = "TEXT")
    private String responseParameter;
	
	@Column(name="response_on")
    private Timestamp responseOn;
	
	@Column(name="response_status",length=150)
    private String responseStatus;
	
	@Column(name="resp_error_msg",columnDefinition = "TEXT")
    private String respErrorMsg;
	
	@Column(name="created_by")
    private Integer createdBy;
	
	@Column(name="created_date")
    private Timestamp createdDate;
	
	@Column(name="updated_by")
    private Integer updatedBy;
	
	@Column(name="updated_date")
    private Timestamp updatedDate;
	
	public AuditLog() {
		super();
	}

	public AuditLog(int ccsInterfaceId, Timestamp requestedOn, String requestedFrom, String requestedParameter,
			String destinationApi, Timestamp destrequestOn, String responseParameter, Timestamp responseOn, String responseStatus,
			String respErrorMsg, Integer createdBy, Timestamp createdDate, Integer updatedBy, Timestamp updatedDate) {
		super();
		this.ccsInterfaceId = ccsInterfaceId;
		this.requestedOn = requestedOn;
		this.requestedFrom = requestedFrom;
		this.requestedParameter = requestedParameter;
		this.destinationApi = destinationApi;
		this.destrequestOn = destrequestOn;
		this.responseParameter = responseParameter;
		this.responseOn = responseOn;
		this.responseStatus = responseStatus;
		this.respErrorMsg = respErrorMsg;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the ccsInterfaceId
	 */
	public int getCcsInterfaceId() {
		return ccsInterfaceId;
	}

	/**
	 * @param ccsInterfaceId the ccsInterfaceId to set
	 */
	public void setCcsInterfaceId(int ccsInterfaceId) {
		this.ccsInterfaceId = ccsInterfaceId;
	}

	/**
	 * @return the requestedOn
	 */
	public Date getRequestedOn() {
		return requestedOn;
	}

	/**
	 * @param requestedOn the requestedOn to set
	 */
	public void setRequestedOn(Timestamp requestedOn) {
		this.requestedOn = requestedOn;
	}

	/**
	 * @return the requestedFrom
	 */
	public String getRequestedFrom() {
		return requestedFrom;
	}

	/**
	 * @param requestedFrom the requestedFrom to set
	 */
	public void setRequestedFrom(String requestedFrom) {
		this.requestedFrom = requestedFrom;
	}

	/**
	 * @return the requestedParameter
	 */
	public String getRequestedParameter() {
		return requestedParameter;
	}

	/**
	 * @param requestedParameter the requestedParameter to set
	 */
	public void setRequestedParameter(String requestedParameter) {
		this.requestedParameter = requestedParameter;
	}

	/**
	 * @return the destinationApi
	 */
	public String getDestinationApi() {
		return destinationApi;
	}

	/**
	 * @param destinationApi the destinationApi to set
	 */
	public void setDestinationApi(String destinationApi) {
		this.destinationApi = destinationApi;
	}

	/**
	 * @return the destrequestOn
	 */
	public Date getDestrequestOn() {
		return destrequestOn;
	}

	/**
	 * @param destrequestOn the destrequestOn to set
	 */
	public void setDestrequestOn(Timestamp destrequestOn) {
		this.destrequestOn = destrequestOn;
	}

	/**
	 * @return the responseParameter
	 */
	public String getResponseParameter() {
		return responseParameter;
	}

	/**
	 * @param responseParameter the responseParameter to set
	 */
	public void setResponseParameter(String responseParameter) {
		this.responseParameter = responseParameter;
	}

	/**
	 * @return the responseOn
	 */
	public Date getResponseOn() {
		return responseOn;
	}

	/**
	 * @param responseOn the responseOn to set
	 */
	public void setResponseOn(Timestamp responseOn) {
		this.responseOn = responseOn;
	}

	/**
	 * @return the responseStatus
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the respErrorMsg
	 */
	public String getRespErrorMsg() {
		return respErrorMsg;
	}

	/**
	 * @param respErrorMsg the respErrorMsg to set
	 */
	public void setRespErrorMsg(String respErrorMsg) {
		this.respErrorMsg = respErrorMsg;
	}

	
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * @return get Create By
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * 
	 * @param set createdBy
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 
	 * @return get updateBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * 
	 * @param set updatedBy
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ccsInterfaceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditLog other = (AuditLog) obj;
		return ccsInterfaceId == other.ccsInterfaceId;
	}

	@Override
	public String toString() {
		return "AuditLog [ccsInterfaceId=" + ccsInterfaceId + ", requestedOn=" + requestedOn + ", requestedFrom="
				+ requestedFrom + ", requestedParameter=" + requestedParameter + ", destinationApi=" + destinationApi
				+ ", destrequestOn=" + destrequestOn + ", responseParameter=" + responseParameter + ", responseOn="
				+ responseOn + ", responseStatus=" + responseStatus + ", respErrorMsg=" + respErrorMsg + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}
    
    
    
    
	  

}
