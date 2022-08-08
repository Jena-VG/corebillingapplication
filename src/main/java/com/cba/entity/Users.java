package com.cba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
* Users is the entity class to map ccs_users Table from Database
*
* @author  manikandan.rajendran
* @version 1.0
* @since   2022-06-17 
*/

@Entity
@Table(name = "ccs_users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "login")
	private String login;

	@Column(name = "token")
	private String token;

	@Column(name = "pan_nbr")
	private String panNbr;

	@Column(name = "aadhar_nbr")
	private String aadharNbr;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;
	
	// added for security
	@Column(name = "client_id")
	private String clientId;
	
	@Column(name = "client_secret_key")
	private String clientSecretKey;
	
	@Column(name = "token_status")
	private String tokenStatus;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy = 0;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createdDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date updatedDate;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPanNbr() {
		return panNbr;
	}

	public void setPanNbr(String panNbr) {
		this.panNbr = panNbr;
	}

	public String getAadharNbr() {
		return aadharNbr;
	}

	public void setAadharNbr(String aadharNbr) {
		this.aadharNbr = aadharNbr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecretKey() {
		return clientSecretKey;
	}

	public void setClientSecretKey(String clientSecretKey) {
		this.clientSecretKey = clientSecretKey;
	}

	public String getTokenStatus() {
		return tokenStatus;
	}

	public void setTokenStatus(String tokenStatus) {
		this.tokenStatus = tokenStatus;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
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
	


	public Users(Long user_id, String userType, String userName, String login, String token, String panNbr,
			String aadharNbr, String mobile, String email, String clientId, String clientSecretKey, String tokenStatus,
			int createdBy, Integer updatedBy, Date createdDate, Date updatedDate) {
		super();
		this.userId = user_id;
		this.userType = userType;
		this.userName = userName;
		this.login = login;
		this.token = token;
		this.panNbr = panNbr;
		this.aadharNbr = aadharNbr;
		this.mobile = mobile;
		this.email = email;
		this.clientId = clientId;
		this.clientSecretKey = clientSecretKey;
		this.tokenStatus = tokenStatus;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Users() {
		super();
	}


}
