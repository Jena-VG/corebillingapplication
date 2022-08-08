package com.cba.gst.integration.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Desc")
	private String desc;
	@JsonProperty("InfCd")
	private String infCd;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getInfCd() {
		return infCd;
	}

	public void setInfCd(String infCd) {
		this.infCd = infCd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Info [desc=" + desc + ", infCd=" + infCd + "]";
	}

	
	
}
