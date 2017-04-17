package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChildComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Child_Comment", catalog = "hedou")
public class ChildComment implements java.io.Serializable {

	// Fields

	private Long ccId;
	private Long CId;
	private Long UId;
	private String ccContent;
	private Timestamp ccCreateTime;
	private Timestamp ccModificationTime;

	// Constructors

	/** default constructor */
	public ChildComment() {
	}

	/** full constructor */
	public ChildComment(Long CId, Long UId, String ccContent,
			Timestamp ccCreateTime, Timestamp ccModificationTime) {
		this.CId = CId;
		this.UId = UId;
		this.ccContent = ccContent;
		this.ccCreateTime = ccCreateTime;
		this.ccModificationTime = ccModificationTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cc_id", unique = true, nullable = false)
	public Long getCcId() {
		return this.ccId;
	}

	public void setCcId(Long ccId) {
		this.ccId = ccId;
	}

	@Column(name = "c_id")
	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	@Column(name = "u_id")
	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	@Column(name = "cc_content")
	public String getCcContent() {
		return this.ccContent;
	}

	public void setCcContent(String ccContent) {
		this.ccContent = ccContent;
	}

	@Column(name = "cc_createTime", length = 19)
	public Timestamp getCcCreateTime() {
		return this.ccCreateTime;
	}

	public void setCcCreateTime(Timestamp ccCreateTime) {
		this.ccCreateTime = ccCreateTime;
	}

	@Column(name = "cc_modificationTime", length = 19)
	public Timestamp getCcModificationTime() {
		return this.ccModificationTime;
	}

	public void setCcModificationTime(Timestamp ccModificationTime) {
		this.ccModificationTime = ccModificationTime;
	}

}