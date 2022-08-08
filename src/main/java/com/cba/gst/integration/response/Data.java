package com.cba.gst.integration.response;

import java.io.Serializable;

public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Irn irn;
	private Ewb ewb;

	public Irn getIrn() {
		return irn;
	}

	public void setIrn(Irn irn) {
		this.irn = irn;
	}

	public Ewb getEwb() {
		return ewb;
	}

	public void setEwb(Ewb ewb) {
		this.ewb = ewb;
	}

	@Override
	public String toString() {
		return "Data [irn=" + irn + ", ewb=" + ewb + "]";
	}

	
}
