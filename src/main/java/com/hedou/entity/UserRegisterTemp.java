package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRegisterTemp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User_Register_Temp", catalog = "hedou")
public class UserRegisterTemp implements java.io.Serializable {

	// Fields

	private Long id;
	private String UName;
	private String UPassword;
	private String UEmailAddress;
	private Timestamp UGenerateDate;
	private Integer UVerifyCode;

	// Constructors

	/** default constructor */
	public UserRegisterTemp() {
	}

	/** full constructor */
	public UserRegisterTemp(String UName, String UPassword,
			String UEmailAddress, Timestamp UGenerateDate, Integer UVerifyCode) {
		this.UName = UName;
		this.UPassword = UPassword;
		this.UEmailAddress = UEmailAddress;
		this.UGenerateDate = UGenerateDate;
		this.UVerifyCode = UVerifyCode;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "u_name")
	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	@Column(name = "u_password")
	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	@Column(name = "u_email_address")
	public String getUEmailAddress() {
		return this.UEmailAddress;
	}

	public void setUEmailAddress(String UEmailAddress) {
		this.UEmailAddress = UEmailAddress;
	}

	@Column(name = "u_generate_date", length = 19)
	public Timestamp getUGenerateDate() {
		return this.UGenerateDate;
	}

	public void setUGenerateDate(Timestamp UGenerateDate) {
		this.UGenerateDate = UGenerateDate;
	}

	@Column(name = "u_verify_code")
	public Integer getUVerifyCode() {
		return this.UVerifyCode;
	}

	public void setUVerifyCode(Integer UVerifyCode) {
		this.UVerifyCode = UVerifyCode;
	}

}