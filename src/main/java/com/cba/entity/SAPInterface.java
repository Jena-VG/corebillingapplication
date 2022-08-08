/**
 * 
 */
package com.cba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author subashkumar.t
 *
 */


@Entity
@Table(name = "sal_cc_plan_is")
public class SAPInterface {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	@Column(name = "cc_plan_id")
	private int ccPlanId;
	
	@Column(name = "zinvno")
	private String zinvNo;
	
	@Column(name = "zinvdt")
	private String zinvDt;
	
 
	@Column(name = "kunnr")
	private String kunnr;
	
	@Column(name = "certno")
	private String certNo;
	
	 
	@Column(name = "regcan")
	private String regCan;
	
	@Column(name = "zcust_veh_reg_no")
	private String zcustVehRegNo;
	
	@Column(name = "vinno")
	private String vinNo;
	
	@Column(name = "csprwo")
	private Double cspRwo;
	
	@Column(name = "csprw")
	private Double cspRw;
	
	@Column(name = "zpcgst")
	private Double zpcGst;
	
	@Column(name = "zpsgst")
	private Double zpsGst;
	
	@Column(name = "zpigst")
	private Double zpiGst;
	
	@Column(name = "zsac")
	private String zsac;
	
	
	
	@Column(name = "taxcode")
	private String taxCode;
	
	
	@Column(name = "rctrdt")
	private String rctRdt;
	
	@Column(name = "rctrtm")
	private String rctrTm;
	
	@Column(name = "rctflg")
	private String rctFlg;
	
	@Column(name = "rctmsg")
	private String rctMsg;
	

	@Column(name = "irn_no")
	private String irnNo;
	
	@Column(name = "ack_no")
	private String ackTn;
	
	@Column(name = "ack_dt")
	private String ackDt;
	
	@Column(name = "rsa_cgst")
	private Double rsaCgst;
	
	@Column(name = "rsa_sgst")
	private Double rsaSgst;
	
	@Column(name = "rsa_igst")
	private Double rsaIgst;
	
	@Column(name = "ccs_rsa_amt")
	private Double ccsRsaAmt;
	
	@Column(name = "cust_gstin")
	private String custGstin;
	
	@Column(name = "zname1")
	private String zname1;
	
	@Column(name = "zaddr")
	private String zaddr;
	
	
	@Column(name = "zpost_cd")
	private String zpostCd;
	
	@Column(name = "zdesc1")
	private String zdesc1;
	
	@Column(name = "zsez")
	private String zsez;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "taxcl")
	private String taxCl;
	
	@Column(name = "plc_sup")
	private String plcSup;
	
	@Column(name = "rctno")
	private String rctNo;
	 

	@Column(name = "rctdt")
	private String rctDt;
	
	@Column(name = "rcttm")
	private String rctTm;
	
	@Column(name = "rcttyp")
	private String rcttyp;
	
	@Column(name = "utrno")
	private String utrno;

	/**
	 * @return the ccPlanId
	 */
	public int getCcPlanId() {
		return ccPlanId;
	}

	/**
	 * @param ccPlanId the ccPlanId to set
	 */
	public void setCcPlanId(int ccPlanId) {
		this.ccPlanId = ccPlanId;
	}

	/**
	 * @return the zinvNo
	 */
	public String getZinvNo() {
		return zinvNo;
	}

	/**
	 * @param zinvNo the zinvNo to set
	 */
	public void setZinvNo(String zinvNo) {
		this.zinvNo = zinvNo;
	}

	/**
	 * @return the zinvDt
	 */
	public String getZinvDt() {
		return zinvDt;
	}

	/**
	 * @param zinvDt the zinvDt to set
	 */
	public void setZinvDt(String zinvDt) {
		this.zinvDt = zinvDt;
	}


	/**
	 * @return the kunnr
	 */
	public String getKunnr() {
		return kunnr;
	}

	/**
	 * @param kunnr the kunnr to set
	 */
	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
	}

	/**
	 * @return the certNo
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * @param certNo the certNo to set
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * @return the regCan
	 */
	public String getRegCan() {
		return regCan;
	}

	/**
	 * @param regCan the regCan to set
	 */
	public void setRegCan(String regCan) {
		this.regCan = regCan;
	}

	/**
	 * @return the vinNo
	 */
	public String getVinNo() {
		return vinNo;
	}

	/**
	 * @param vinNo the vinNo to set
	 */
	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	/**
	 * @return the cspRwo
	 */
	public Double getCspRwo() {
		return cspRwo;
	}

	/**
	 * @param cspRwo the cspRwo to set
	 */
	public void setCspRwo(Double cspRwo) {
		this.cspRwo = cspRwo;
	}

	/**
	 * @return the cspRw
	 */
	public Double getCspRw() {
		return cspRw;
	}

	/**
	 * @param cspRw the cspRw to set
	 */
	public void setCspRw(Double cspRw) {
		this.cspRw = cspRw;
	}

	/**
	 * @return the zpcGst
	 */
	public Double getZpcGst() {
		return zpcGst;
	}

	/**
	 * @param zpcGst the zpcGst to set
	 */
	public void setZpcGst(Double zpcGst) {
		this.zpcGst = zpcGst;
	}

	/**
	 * @return the zpsGst
	 */
	public Double getZpsGst() {
		return zpsGst;
	}

	/**
	 * @param zpsGst the zpsGst to set
	 */
	public void setZpsGst(Double zpsGst) {
		this.zpsGst = zpsGst;
	}

	/**
	 * @return the zpiGst
	 */
	public Double getZpiGst() {
		return zpiGst;
	}

	/**
	 * @param zpiGst the zpiGst to set
	 */
	public void setZpiGst(Double zpiGst) {
		this.zpiGst = zpiGst;
	}

	/**
	 * @return the zsac
	 */
	public String getZsac() {
		return zsac;
	}

	/**
	 * @param zsac the zsac to set
	 */
	public void setZsac(String zsac) {
		this.zsac = zsac;
	}

	/**
	 * @return the taxCode
	 */
	public String getTaxCode() {
		return taxCode;
	}

	/**
	 * @param taxCode the taxCode to set
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	/**
	 * @return the rctRdt
	 */
	public String getRctRdt() {
		return rctRdt;
	}

	/**
	 * @param rctRdt the rctRdt to set
	 */
	public void setRctRdt(String rctRdt) {
		this.rctRdt = rctRdt;
	}

	/**
	 * @return the rctrTm
	 */
	public String getRctrTm() {
		return rctrTm;
	}

	/**
	 * @param rctrTm the rctrTm to set
	 */
	public void setRctrTm(String rctrTm) {
		this.rctrTm = rctrTm;
	}

	/**
	 * @return the rctFlg
	 */
	public String getRctFlg() {
		return rctFlg;
	}

	/**
	 * @param rctFlg the rctFlg to set
	 */
	public void setRctFlg(String rctFlg) {
		this.rctFlg = rctFlg;
	}

	/**
	 * @return the rctMsg
	 */
	public String getRctMsg() {
		return rctMsg;
	}

	/**
	 * @param rctMsg the rctMsg to set
	 */
	public void setRctMsg(String rctMsg) {
		this.rctMsg = rctMsg;
	}

	/**
	 * @return the irnNo
	 */
	public String getIrnNo() {
		return irnNo;
	}

	/**
	 * @param irnNo the irnNo to set
	 */
	public void setIrnNo(String irnNo) {
		this.irnNo = irnNo;
	}

	/**
	 * @return the ackTn
	 */
	public String getAckTn() {
		return ackTn;
	}

	/**
	 * @param ackTn the ackTn to set
	 */
	public void setAckTn(String ackTn) {
		this.ackTn = ackTn;
	}

	/**
	 * @return the ackDt
	 */
	public String getAckDt() {
		return ackDt;
	}

	/**
	 * @param ackDt the ackDt to set
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}

	/**
	 * @return the rsaCgst
	 */
	public Double getRsaCgst() {
		return rsaCgst;
	}

	/**
	 * @param rsaCgst the rsaCgst to set
	 */
	public void setRsaCgst(Double rsaCgst) {
		this.rsaCgst = rsaCgst;
	}

	/**
	 * @return the rsaSgst
	 */
	public Double getRsaSgst() {
		return rsaSgst;
	}

	/**
	 * @param rsaSgst the rsaSgst to set
	 */
	public void setRsaSgst(Double rsaSgst) {
		this.rsaSgst = rsaSgst;
	}

	/**
	 * @return the rsaIgst
	 */
	public Double getRsaIgst() {
		return rsaIgst;
	}

	/**
	 * @param rsaIgst the rsaIgst to set
	 */
	public void setRsaIgst(Double rsaIgst) {
		this.rsaIgst = rsaIgst;
	}

	/**
	 * @return the ccsRsaAmt
	 */
	public Double getCcsRsaAmt() {
		return ccsRsaAmt;
	}

	/**
	 * @param ccsRsaAmt the ccsRsaAmt to set
	 */
	public void setCcsRsaAmt(Double ccsRsaAmt) {
		this.ccsRsaAmt = ccsRsaAmt;
	}

	/**
	 * @return the custGstin
	 */
	public String getCustGstin() {
		return custGstin;
	}

	/**
	 * @param custGstin the custGstin to set
	 */
	public void setCustGstin(String custGstin) {
		this.custGstin = custGstin;
	}

	/**
	 * @return the zname1
	 */
	public String getZname1() {
		return zname1;
	}

	/**
	 * @param zname1 the zname1 to set
	 */
	public void setZname1(String zname1) {
		this.zname1 = zname1;
	}

	/**
	 * @return the zaddr
	 */
	public String getZaddr() {
		return zaddr;
	}

	/**
	 * @param zaddr the zaddr to set
	 */
	public void setZaddr(String zaddr) {
		this.zaddr = zaddr;
	}

	/**
	 * @return the zpostCd
	 */
	public String getZpostCd() {
		return zpostCd;
	}

	/**
	 * @param zpostCd the zpostCd to set
	 */
	public void setZpostCd(String zpostCd) {
		this.zpostCd = zpostCd;
	}

	/**
	 * @return the zdesc1
	 */
	public String getZdesc1() {
		return zdesc1;
	}

	/**
	 * @param zdesc1 the zdesc1 to set
	 */
	public void setZdesc1(String zdesc1) {
		this.zdesc1 = zdesc1;
	}

	/**
	 * @return the zsez
	 */
	public String getZsez() {
		return zsez;
	}

	/**
	 * @param zsez the zsez to set
	 */
	public void setZsez(String zsez) {
		this.zsez = zsez;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the taxCl
	 */
	public String getTaxCl() {
		return taxCl;
	}

	/**
	 * @param taxCl the taxCl to set
	 */
	public void setTaxCl(String taxCl) {
		this.taxCl = taxCl;
	}

	/**
	 * @return the plcSup
	 */
	public String getPlcSup() {
		return plcSup;
	}

	/**
	 * @param plcSup the plcSup to set
	 */
	public void setPlcSup(String plcSup) {
		this.plcSup = plcSup;
	}

	/**
	 * @return the rctNo
	 */
	public String getRctNo() {
		return rctNo;
	}

	/**
	 * @param rctNo the rctNo to set
	 */
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	/**
	 * @return the rctDt
	 */
	public String getRctDt() {
		return rctDt;
	}

	/**
	 * @param rctDt the rctDt to set
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}

	/**
	 * @return the rctTm
	 */
	public String getRctTm() {
		return rctTm;
	}

	/**
	 * @param rctTm the rctTm to set
	 */
	public void setRctTm(String rctTm) {
		this.rctTm = rctTm;
	}

	/**
	 * @return the rcttyp
	 */
	public String getRcttyp() {
		return rcttyp;
	}

	/**
	 * @param rcttyp the rcttyp to set
	 */
	public void setRcttyp(String rcttyp) {
		this.rcttyp = rcttyp;
	}

	/**
	 * @return the utrno
	 */
	public String getUtrno() {
		return utrno;
	}

	/**
	 * @param utrno the utrno to set
	 */
	public void setUtrno(String utrno) {
		this.utrno = utrno;
	}

	@Override
	public String toString() {
		return "SAPInterface [ccPlanId=" + ccPlanId + ", zinvNo=" + zinvNo + ", zinvDt=" + zinvDt
				+ ", kunnr=" + kunnr + ", certNo=" + certNo + ", regCan=" + regCan + ", vinNo=" + vinNo + ", cspRwo="
				+ cspRwo + ", cspRw=" + cspRw + ", zpcGst=" + zpcGst + ", zpsGst=" + zpsGst + ", zpiGst=" + zpiGst
				+ ", zsac=" + zsac + ", taxCode=" + taxCode + ", rctRdt=" + rctRdt + ", rctrTm=" + rctrTm + ", rctFlg="
				+ rctFlg + ", rctMsg=" + rctMsg + ", irnNo=" + irnNo + ", ackTn=" + ackTn + ", ackDt=" + ackDt
				+ ", rsaCgst=" + rsaCgst + ", rsaSgst=" + rsaSgst + ", rsaIgst=" + rsaIgst + ", ccsRsaAmt=" + ccsRsaAmt
				+ ", custGstin=" + custGstin + ", zname1=" + zname1 + ", zaddr=" + zaddr + ", zpostCd=" + zpostCd
				+ ", zdesc1=" + zdesc1 + ", zsez=" + zsez + ", city=" + city + ", taxCl=" + taxCl + ", plcSup=" + plcSup
				+ ", rctNo=" + rctNo + ", rctDt=" + rctDt + ", rctTm=" + rctTm + ", rcttyp=" + rcttyp + ", utrno="
				+ utrno + "]";
	}

	/**
	 * @return the zcustVehRegNo
	 */
	public String getZcustVehRegNo() {
		return zcustVehRegNo;
	}

	/**
	 * @param zcustVehRegNo the zcustVehRegNo to set
	 */
	public void setZcustVehRegNo(String zcustVehRegNo) {
		this.zcustVehRegNo = zcustVehRegNo;
	}
		

	


 
	
	
}
