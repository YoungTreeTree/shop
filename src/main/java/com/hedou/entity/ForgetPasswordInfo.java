package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ForgetPasswordInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Forget_Password_Info", catalog = "hedou")
public class ForgetPasswordInfo implements java.io.Serializable {

	// Fields

	private Long fpId;
	private String fpEmailAddress;
	private String fpVerifyCode;
	private Timestamp fpCreateTime;

	// Constructors

	/** default constructor */
	public ForgetPasswordInfo() {
	}

	/** full constructor */
	public ForgetPasswordInfo(String fpEmailAddress, String fpVerifyCode,
			Timestamp fpCreateTime) {
		this.fpEmailAddress = fpEmailAddress;
		this.fpVerifyCode = fpVerifyCode;
		this.fpCreateTime = fpCreateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "fp_id", unique = true, nullable = false)
	public Long getFpId() {
		return this.fpId;
	}

	public void setFpId(Long fpId) {
		this.fpId = fpId;
	}

	@Column(name = "fp_email_address")
	public String getFpEmailAddress() {
		return this.fpEmailAddress;
	}

	public void setFpEmailAddress(String fpEmailAddress) {
		this.fpEmailAddress = fpEmailAddress;
	}

	@Column(name = "fp_verify_code")
	public String getFpVerifyCode() {
		return this.fpVerifyCode;
	}

	public void setFpVerifyCode(String fpVerifyCode) {
		this.fpVerifyCode = fpVerifyCode;
	}

	@Column(name = "fp_create_time", length = 19)
	public Timestamp getFpCreateTime() {
		return this.fpCreateTime;
	}

	public void setFpCreateTime(Timestamp fpCreateTime) {
		this.fpCreateTime = fpCreateTime;
	}

}