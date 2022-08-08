package com.cba.api.utils;

import java.io.File;
import java.util.HashMap;

public class EmailDetails {

	
	private String recipientEmail;
	private String recipientName;
	private HashMap<String, File> attachment;
	private String ccMailId;
	private String subject;
	private String refNumber;
	
	/**
	 * @return the recipientEmail
	 */
	public String getRecipientEmail() {
		return recipientEmail;
	}
	/**
	 * @param recipientEmail the recipientEmail to set
	 */
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	/**
	 * @return the recipientName
	 */
	public String getRecipientName() {
		return recipientName;
	}
	/**
	 * @param recipientName the recipientName to set
	 */
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	/**
	 * @return the attachment
	 */
	public HashMap<String, File> getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(HashMap<String, File> attachment) {
		this.attachment = attachment;
	}
	/**
	 * @return the ccMailId
	 */
	public String getCcMailId() {
		return ccMailId;
	}
	/**
	 * @param ccMailId the ccMailId to set
	 */
	public void setCcMailId(String ccMailId) {
		this.ccMailId = ccMailId;
	}
	
	public void addAttachment(String name, File attachment) {
		if(this.attachment == null) {
			this.attachment = new HashMap<String, File>();
		}
		this.attachment.put(name, attachment);
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the refNumber
	 */
	public String getRefNumber() {
		return refNumber;
	}
	/**
	 * @param refNumber the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
 
	
	
}
