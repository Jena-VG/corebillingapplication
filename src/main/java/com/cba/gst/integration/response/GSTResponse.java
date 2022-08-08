package com.cba.gst.integration.response;

import java.io.Serializable;
import java.util.List;

public class GSTResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private Data data;
	private String docno;
	private String self_gstin;
	private String document_type;
	private String docdt;
	private List<Info> info;
	private List<Error> error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getDocno() {
		return docno;
	}

	public void setDocno(String docno) {
		this.docno = docno;
	}

	public String getSelf_gstin() {
		return self_gstin;
	}

	public void setSelf_gstin(String self_gstin) {
		this.self_gstin = self_gstin;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocdt() {
		return docdt;
	}

	public void setDocdt(String docdt) {
		this.docdt = docdt;
	}

	public List<Info> getInfo() {
		return info;
	}

	public void setInfo(List<Info> info) {
		this.info = info;
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "GSTResponse [status=" + status + ", data=" + data + ", docno=" + docno + ", self_gstin=" + self_gstin
				+ ", document_type=" + document_type + ", docdt=" + docdt + ", info=" + info + ", error=" + error + "]";
	}

	
	
}
