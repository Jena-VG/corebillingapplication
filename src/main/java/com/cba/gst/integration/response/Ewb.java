package com.cba.gst.integration.response;

import java.io.Serializable;

public class Ewb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private Data3 data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data3 getData() {
		return data;
	}

	public void setData(Data3 data) {
		this.data = data;
	}

}
