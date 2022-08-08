package com.cba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
* Employee is the entity class to map ccs_employee Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

@Entity
@Table(name = "ccs_employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "dealer_id")
	private Long dealerId;

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "emp_nbr")
	private String empNbr;

	@Column
	private String designation;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "updated_by")
	private int updatedBy;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updatedDate;

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + empId + ", dealerId=" + dealerId + ", deptId=" + deptId + ", empNbr=" + empNbr
				+ ", designation=" + designation + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	public Employee(Long empId, Long dealerId, String deptId, String empNbr, String designation, int createdBy,
			int updatedBy, Date createdDate, Date updatedDate) {
		super();
		this.empId = empId;
		this.dealerId = dealerId;
		this.deptId = deptId;
		this.empNbr = empNbr;
		this.designation = designation;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEmpNbr() {
		return empNbr;
	}

	public void setEmpNbr(String empNbr) {
		this.empNbr = empNbr;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
