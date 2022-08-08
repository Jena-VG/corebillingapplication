package com.cba.gst.integration.response;

public class Error {

	private String error_code;
	private String error_desc;
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError_desc() {
		return error_desc;
	} 
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
	@Override
	public String toString() {
		return "Error [error_code=" + error_code + ", error_desc=" + error_desc + "]";
	}

	
}
