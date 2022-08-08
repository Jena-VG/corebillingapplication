package com.cba.gst.integration.response;

import java.io.Serializable;
import java.util.List;

public class Irn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private Data2 data;
	public List<Error> error;

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data2 getData() {
		return data;
	}

	public void setData(Data2 data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Irn [status=" + status + ", data=" + data + ", error=" + error + "]";
	}

	
	
}
