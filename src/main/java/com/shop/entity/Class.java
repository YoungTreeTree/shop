package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Class", catalog = "shop")
public class Class implements java.io.Serializable {

	// Fields

	private Long claId;
	private Long CId;
	private String claName;
	private String claIndex;

	// Constructors

	/** default constructor */
	public Class() {
	}

	/** full constructor */
	public Class(Long CId, String claName, String claIndex) {
		this.CId = CId;
		this.claName = claName;
		this.claIndex = claIndex;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cla_id", unique = true, nullable = false)
	public Long getClaId() {
		return this.claId;
	}

	public void setClaId(Long claId) {
		this.claId = claId;
	}

	@Column(name = "c_id")
	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	@Column(name = "cla_name")
	public String getClaName() {
		return this.claName;
	}

	public void setClaName(String claName) {
		this.claName = claName;
	}

	@Column(name = "cla_index")
	public String getClaIndex() {
		return this.claIndex;
	}

	public void setClaIndex(String claIndex) {
		this.claIndex = claIndex;
	}

}