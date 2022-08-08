package com.cba.gst.integration.response;

import java.io.Serializable;

public class Data3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eway_bill_no;
	private String eway_bill_date;
	private String valid_upto;

	public String getEway_bill_no() {
		return eway_bill_no;
	}

	public void setEway_bill_no(String eway_bill_no) {
		this.eway_bill_no = eway_bill_no;
	}

	public String getEway_bill_date() {
		return eway_bill_date;
	}

	public void setEway_bill_date(String eway_bill_date) {
		this.eway_bill_date = eway_bill_date;
	}

	public String getValid_upto() {
		return valid_upto;
	}

	public void setValid_upto(String valid_upto) {
		this.valid_upto = valid_upto;
	}

}
