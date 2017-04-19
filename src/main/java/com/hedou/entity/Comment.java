package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Comment", catalog = "hedou")
public class Comment implements java.io.Serializable {

	// Fields

	private Long comId;
	private Long UId;
	private Long PId;
	private String comContent;
	private Timestamp comCreateTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Long UId, Long PId, String comContent,
			Timestamp comCreateTime) {
		this.UId = UId;
		this.PId = PId;
		this.comContent = comContent;
		this.comCreateTime = comCreateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "com_id", unique = true, nullable = false)
	public Long getComId() {
		return this.comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	@Column(name = "u_id")
	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	@Column(name = "p_id")
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	@Column(name = "com_content")
	public String getComContent() {
		return this.comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	@Column(name = "com_createTime", length = 19)
	public Timestamp getComCreateTime() {
		return this.comCreateTime;
	}

	public void setComCreateTime(Timestamp comCreateTime) {
		this.comCreateTime = comCreateTime;
	}

}