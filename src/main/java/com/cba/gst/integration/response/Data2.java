package com.cba.gst.integration.response;

import java.io.Serializable;

public class Data2 implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String irn;
	private String ack_no;
	private String ack_dt;
	private String signed_invoice;
	private String signed_qrcode;
	private String document_type;
	private String gen_status;

	public String getIrn() {
		return irn;
	}

	public void setIrn(String irn) {
		this.irn = irn;
	}

	public String getAck_no() {
		return ack_no;
	}

	public void setAck_no(String ack_no) {
		this.ack_no = ack_no;
	}

	public String getAck_dt() {
		return ack_dt;
	}

	public void setAck_dt(String ack_dt) {
		this.ack_dt = ack_dt;
	}

	public String getSigned_invoice() {
		return signed_invoice;
	}

	public void setSigned_invoice(String signed_invoice) {
		this.signed_invoice = signed_invoice;
	}

	public String getSigned_qrcode() {
		return signed_qrcode;
	}

	public void setSigned_qrcode(String signed_qrcode) {
		this.signed_qrcode = signed_qrcode;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getGen_status() {
		return gen_status;
	}

	public void setGen_status(String gen_status) {
		this.gen_status = gen_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data2 [irn=" + irn + ", ack_no=" + ack_no + ", ack_dt=" + ack_dt + ", signed_invoice=" + signed_invoice
				+ ", signed_qrcode=" + signed_qrcode + ", document_type=" + document_type + ", gen_status=" + gen_status
				+ "]";
	}
  
	
}
