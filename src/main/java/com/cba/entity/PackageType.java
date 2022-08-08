package com.cba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
* PackageType is the entity class to map ccs_package_type Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/


@Entity
@Table(name = "ccs_package_type")
public class PackageType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pkg_type_id")
	private Integer pkgTypeId;

	@Column(name = "pkg_code")
	private String pkgCode;

	@Column(name = "duration")
	private int duration;

	@Column(name = "pkg_desc")
	private String pkgDesc;

	@Column(name = "pkg_price")
	private Double pkgPrice;

	@Column(name = "rsa_price")
	private Double rsaPrice;

	@Column(name = "is_active")
	private String isActive;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	public Integer getPkgTypeId() {
		return pkgTypeId;
	}

	public void setPkgTypeId(Integer pkgTypeId) {
		this.pkgTypeId = pkgTypeId;
	}

	public String getPkgCode() {
		return pkgCode;
	}

	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPkgDesc() {
		return pkgDesc;
	}

	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Double getPkgPrice() {
		return pkgPrice;
	}

	public void setPkgPrice(Double pkgPrice) {
		this.pkgPrice = pkgPrice;
	}

	public Double getRsaPrice() {
		return rsaPrice;
	}

	public void setRsaPrice(Double rsaPrice) {
		this.rsaPrice = rsaPrice;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public PackageType(Integer pkgTypeId, String pkgCode, int duration, String pkgDesc, Double pkgPrice,
			Double rsaPrice, String isActive, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate) {
		super();
		this.pkgTypeId = pkgTypeId;
		this.pkgCode = pkgCode;
		this.duration = duration;
		this.pkgDesc = pkgDesc;
		this.pkgPrice = pkgPrice;
		this.rsaPrice = rsaPrice;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public PackageType() {
		super();
	}

}
