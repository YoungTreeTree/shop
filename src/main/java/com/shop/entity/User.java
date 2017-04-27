package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User", catalog = "shop")
public class User implements java.io.Serializable {

	// Fields

	private Long UId;
	private String UName;
	private String UPassword;
	private String UEmailAddress;
	private String UType;
	private String USignature;
	private String UPortrait;
	private String UFullName;
	private String USchool;
	private String UGrade;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String UName, String UPassword, String UEmailAddress,
			String UType, String USignature, String UPortrait,
			String UFullName, String USchool, String UGrade) {
		this.UName = UName;
		this.UPassword = UPassword;
		this.UEmailAddress = UEmailAddress;
		this.UType = UType;
		this.USignature = USignature;
		this.UPortrait = UPortrait;
		this.UFullName = UFullName;
		this.USchool = USchool;
		this.UGrade = UGrade;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "u_id", unique = true, nullable = false)
	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
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

	@Column(name = "u_type")
	public String getUType() {
		return this.UType;
	}

	public void setUType(String UType) {
		this.UType = UType;
	}

	@Column(name = "u_signature")
	public String getUSignature() {
		return this.USignature;
	}

	public void setUSignature(String USignature) {
		this.USignature = USignature;
	}

	@Column(name = "u_portrait")
	public String getUPortrait() {
		return this.UPortrait;
	}

	public void setUPortrait(String UPortrait) {
		this.UPortrait = UPortrait;
	}

	@Column(name = "u_full_name")
	public String getUFullName() {
		return this.UFullName;
	}

	public void setUFullName(String UFullName) {
		this.UFullName = UFullName;
	}

	@Column(name = "u_school")
	public String getUSchool() {
		return this.USchool;
	}

	public void setUSchool(String USchool) {
		this.USchool = USchool;
	}

	@Column(name = "u_grade")
	public String getUGrade() {
		return this.UGrade;
	}

	public void setUGrade(String UGrade) {
		this.UGrade = UGrade;
	}

}