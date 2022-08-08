/**
 * 
 */
package com.cba.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author subashkumar.t
 *
 */
@Entity
@Table(name = "cmm_einvcirn_tb")
public class EInvoice {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "irn_cmpn_no")
	private String irnCmpnNo;
		
	@Column(name = "irn_corp_no")
	private String irnCorpNo;
	
	@Column(name = "irn_dlr_no")
	private String irnDlrNo;
	
	@Column(name = "irn_transeq")
	private Integer irnTranSeq;
	
	@Column(name = "irn_trantype")
	private String irnTranType;
	
	@Column(name = "irn_irn_no")
	private String  IrnNo;
	
	@Column(name = "irn_date")
	private String irnDate;
	
	@Column(name = "irn_qr_code")
	private String irnQrCode;
	
	@Column(name = "irn_crte_emp_no")
	private String irnCrteEmpNo;
	
	@Column(name = "irn_crte_dtime")
	private Date irnCrteDtime;
	
	@Column(name = "irn_updt_emp_no")
	private String irnUpdtEmpNo;
	
	@Column(name = "irn_updt_dtime")
	private Date irnUpdtDtime;
	
	@Column(name = "irn_status")
	private String irnStatus;
	
	@Column(name = "irn_invoice_no")
	private String irnInvoiceNo;
	
	@Column(name = "irn_business_type")
	private String irnBusinessType;
	
	@Column(name = "irn_vin_no")
	private String irnVinNo;
	
	@Column(name = "irn_bsns_type")
	private String irnBsnsType;
	
	@Column(name = "irn_bsns_type_no")
	private String irnBsnsTypeNo;
	
	@Column(name = "irn_ack_no")
	private String irnAckNo;

	/**
	 * 
	 */
	public EInvoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param irnCmpnNo
	 * @param irnCorpNo
	 * @param irnDlrNo
	 * @param irnTranSeq
	 * @param irnTranType
	 * @param irnNo
	 * @param irnDate
	 * @param irnQrCode
	 * @param irnCrteEmpNo
	 * @param irnCrteDtime
	 * @param irnUpdtEmpNo
	 * @param irnUpdtDtime
	 * @param irnStatus
	 * @param irnInvoiceNo
	 * @param irnBusinessType
	 * @param irnVinNo
	 * @param irnBsnsType
	 * @param irnBsnsTypeNo
	 * @param irnAckNo
	 */
	public EInvoice(String irnCmpnNo, String irnCorpNo, String irnDlrNo, Integer irnTranSeq, String irnTranType,
			String irnNo, String irnDate, String irnQrCode, String irnCrteEmpNo, Date irnCrteDtime, String irnUpdtEmpNo,
			Date irnUpdtDtime, String irnStatus, String irnInvoiceNo, String irnBusinessType, String irnVinNo,
			String irnBsnsType, String irnBsnsTypeNo, String irnAckNo) {
		super();
		this.irnCmpnNo = irnCmpnNo;
		this.irnCorpNo = irnCorpNo;
		this.irnDlrNo = irnDlrNo;
		this.irnTranSeq = irnTranSeq;
		this.irnTranType = irnTranType;
		this.IrnNo = irnNo;
		this.irnDate = irnDate;
		this.irnQrCode = irnQrCode;
		this.irnCrteEmpNo = irnCrteEmpNo;
		this.irnCrteDtime = irnCrteDtime;
		this.irnUpdtEmpNo = irnUpdtEmpNo;
		this.irnUpdtDtime = irnUpdtDtime;
		this.irnStatus = irnStatus;
		this.irnInvoiceNo = irnInvoiceNo;
		this.irnBusinessType = irnBusinessType;
		this.irnVinNo = irnVinNo;
		this.irnBsnsType = irnBsnsType;
		this.irnBsnsTypeNo = irnBsnsTypeNo;
		this.irnAckNo = irnAckNo;
	}

	/**
	 * @return the irnCmpnNo
	 */
	public String getIrnCmpnNo() {
		return irnCmpnNo;
	}

	/**
	 * @param irnCmpnNo the irnCmpnNo to set
	 */
	public void setIrnCmpnNo(String irnCmpnNo) {
		this.irnCmpnNo = irnCmpnNo;
	}

	/**
	 * @return the irnCorpNo
	 */
	public String getIrnCorpNo() {
		return irnCorpNo;
	}

	/**
	 * @param irnCorpNo the irnCorpNo to set
	 */
	public void setIrnCorpNo(String irnCorpNo) {
		this.irnCorpNo = irnCorpNo;
	}

	/**
	 * @return the irnDlrNo
	 */
	public String getIrnDlrNo() {
		return irnDlrNo;
	}

	/**
	 * @param irnDlrNo the irnDlrNo to set
	 */
	public void setIrnDlrNo(String irnDlrNo) {
		this.irnDlrNo = irnDlrNo;
	}

	/**
	 * @return the irnTranSeq
	 */
	public Integer getIrnTranSeq() {
		return irnTranSeq;
	}

	/**
	 * @param irnTranSeq the irnTranSeq to set
	 */
	public void setIrnTranSeq(Integer irnTranSeq) {
		this.irnTranSeq = irnTranSeq;
	}

	/**
	 * @return the irnTranType
	 */
	public String getIrnTranType() {
		return irnTranType;
	}

	/**
	 * @param irnTranType the irnTranType to set
	 */
	public void setIrnTranType(String irnTranType) {
		this.irnTranType = irnTranType;
	}

	/**
	 * @return the irnNo
	 */
	public String getIrnNo() {
		return IrnNo;
	}

	/**
	 * @param irnNo the irnNo to set
	 */
	public void setIrnNo(String irnNo) {
		IrnNo = irnNo;
	}

	/**
	 * @return the irnDate
	 */
	public String getIrnDate() {
		return irnDate;
	}

	/**
	 * @param irnDate the irnDate to set
	 */
	public void setIrnDate(String irnDate) {
		this.irnDate = irnDate;
	}

	/**
	 * @return the irnQrCode
	 */
	public String getIrnQrCode() {
		return irnQrCode;
	}

	/**
	 * @param irnQrCode the irnQrCode to set
	 */
	public void setIrnQrCode(String irnQrCode) {
		this.irnQrCode = irnQrCode;
	}

	/**
	 * @return the irnCrteEmpNo
	 */
	public String getIrnCrteEmpNo() {
		return irnCrteEmpNo;
	}

	/**
	 * @param irnCrteEmpNo the irnCrteEmpNo to set
	 */
	public void setIrnCrteEmpNo(String irnCrteEmpNo) {
		this.irnCrteEmpNo = irnCrteEmpNo;
	}

	/**
	 * @return the irnCrteDtime
	 */
	public Date getIrnCrteDtime() {
		return irnCrteDtime;
	}

	/**
	 * @param irnCrteDtime the irnCrteDtime to set
	 */
	public void setIrnCrteDtime(Date irnCrteDtime) {
		this.irnCrteDtime = irnCrteDtime;
	}

	/**
	 * @return the irnUpdtEmpNo
	 */
	public String getIrnUpdtEmpNo() {
		return irnUpdtEmpNo;
	}

	/**
	 * @param irnUpdtEmpNo the irnUpdtEmpNo to set
	 */
	public void setIrnUpdtEmpNo(String irnUpdtEmpNo) {
		this.irnUpdtEmpNo = irnUpdtEmpNo;
	}

	/**
	 * @return the irnUpdtDtime
	 */
	public Date getIrnUpdtDtime() {
		return irnUpdtDtime;
	}

	/**
	 * @param irnUpdtDtime the irnUpdtDtime to set
	 */
	public void setIrnUpdtDtime(Date irnUpdtDtime) {
		this.irnUpdtDtime = irnUpdtDtime;
	}

	/**
	 * @return the irnStatus
	 */
	public String getIrnStatus() {
		return irnStatus;
	}

	/**
	 * @param irnStatus the irnStatus to set
	 */
	public void setIrnStatus(String irnStatus) {
		this.irnStatus = irnStatus;
	}

	/**
	 * @return the irnInvoiceNo
	 */
	public String getIrnInvoiceNo() {
		return irnInvoiceNo;
	}

	/**
	 * @param irnInvoiceNo the irnInvoiceNo to set
	 */
	public void setIrnInvoiceNo(String irnInvoiceNo) {
		this.irnInvoiceNo = irnInvoiceNo;
	}

	/**
	 * @return the irnBusinessType
	 */
	public String getIrnBusinessType() {
		return irnBusinessType;
	}

	/**
	 * @param irnBusinessType the irnBusinessType to set
	 */
	public void setIrnBusinessType(String irnBusinessType) {
		this.irnBusinessType = irnBusinessType;
	}

	/**
	 * @return the irnVinNo
	 */
	public String getIrnVinNo() {
		return irnVinNo;
	}

	/**
	 * @param irnVinNo the irnVinNo to set
	 */
	public void setIrnVinNo(String irnVinNo) {
		this.irnVinNo = irnVinNo;
	}

	/**
	 * @return the irnBsnsType
	 */
	public String getIrnBsnsType() {
		return irnBsnsType;
	}

	/**
	 * @param irnBsnsType the irnBsnsType to set
	 */
	public void setIrnBsnsType(String irnBsnsType) {
		this.irnBsnsType = irnBsnsType;
	}

	/**
	 * @return the irnBsnsTypeNo
	 */
	public String getIrnBsnsTypeNo() {
		return irnBsnsTypeNo;
	}

	/**
	 * @param irnBsnsTypeNo the irnBsnsTypeNo to set
	 */
	public void setIrnBsnsTypeNo(String irnBsnsTypeNo) {
		this.irnBsnsTypeNo = irnBsnsTypeNo;
	}

	/**
	 * @return the irnAckNo
	 */
	public String getIrnAckNo() {
		return irnAckNo;
	}

	/**
	 * @param irnAckNo the irnAckNo to set
	 */
	public void setIrnAckNo(String irnAckNo) {
		this.irnAckNo = irnAckNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IrnNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EInvoice other = (EInvoice) obj;
		return Objects.equals(IrnNo, other.IrnNo);
	}

	@Override
	public String toString() {
		return "Invoice [irnCmpnNo=" + irnCmpnNo + ", irnCorpNo=" + irnCorpNo + ", irnDlrNo=" + irnDlrNo
				+ ", irnTranSeq=" + irnTranSeq + ", irnTranType=" + irnTranType + ", IrnNo=" + IrnNo + ", irnDate="
				+ irnDate + ", irnQrCode=" + irnQrCode + ", irnCrteEmpNo=" + irnCrteEmpNo + ", irnCrteDtime="
				+ irnCrteDtime + ", irnUpdtEmpNo=" + irnUpdtEmpNo + ", irnUpdtDtime=" + irnUpdtDtime + ", irnStatus="
				+ irnStatus + ", irnInvoiceNo=" + irnInvoiceNo + ", irnBusinessType=" + irnBusinessType + ", irnVinNo="
				+ irnVinNo + ", irnBsnsType=" + irnBsnsType + ", irnBsnsTypeNo=" + irnBsnsTypeNo + ", irnAckNo="
				+ irnAckNo + "]";
	}
	
	

}
