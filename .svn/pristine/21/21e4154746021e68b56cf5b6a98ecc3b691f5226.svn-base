package com.qrcode.buspass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_mst",schema="public")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="email_add")
	private String emailAdd;
	
	@Column(name="roleId")
	private String roleId;
	
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="confirm_password")
	private String confirmPassword;
	
	
	@Column(name="user_type")
	private String userType;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailAdd() {
		return emailAdd;
	}


	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	


}
