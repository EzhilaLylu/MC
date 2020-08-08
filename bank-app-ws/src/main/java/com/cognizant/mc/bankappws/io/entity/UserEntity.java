package com.cognizant.mc.bankappws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long privateUserID;
	
	@Column(nullable=false)
	private String publicUserId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String encryptedPassword;
	
	@Column
	private String address; 
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@Column (nullable = false, length = 100)
	private String email;
	
	@Column (nullable = false)
	private String pan;
	
	@Column
	private String contactNo;
	
	@Column
	private String dob;
	
	@Column(nullable = false)
	private String accountType;

	public long getPrivateUserID() {
		return privateUserID;
	}

	public void setPrivateUserID(long privateUserID) {
		this.privateUserID = privateUserID;
	}

	public String getPublicUserId() {
		return publicUserId;
	}

	public void setPublicUserId(String publicUserId) {
		this.publicUserId = publicUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
