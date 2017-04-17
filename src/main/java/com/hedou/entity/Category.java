package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Category", catalog = "hedou")
public class Category implements java.io.Serializable {

	// Fields

	private Long catId;
	private String catName;
	private String catDescription;
	private Timestamp catCreateTime;
	private Timestamp catModificationTime;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String catName, String catDescription,
			Timestamp catCreateTime, Timestamp catModificationTime) {
		this.catName = catName;
		this.catDescription = catDescription;
		this.catCreateTime = catCreateTime;
		this.catModificationTime = catModificationTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cat_id", unique = true, nullable = false)
	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	@Column(name = "cat_name")
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "cat_description")
	public String getCatDescription() {
		return this.catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	@Column(name = "cat_createTime", length = 19)
	public Timestamp getCatCreateTime() {
		return this.catCreateTime;
	}

	public void setCatCreateTime(Timestamp catCreateTime) {
		this.catCreateTime = catCreateTime;
	}

	@Column(name = "cat_modificationTime", length = 19)
	public Timestamp getCatModificationTime() {
		return this.catModificationTime;
	}

	public void setCatModificationTime(Timestamp catModificationTime) {
		this.catModificationTime = catModificationTime;
	}

}