package com.shop.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Course", catalog = "shop")
public class Course implements java.io.Serializable {

	// Fields

	private Long CId;
	private String CName;
	private String CAuthor;
	private Timestamp CCreateTime;
	private String CPic;
	private String CExcerpt;
	private Long catId;
	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String CName, String CAuthor, Timestamp CCreateTime,
			String CPic, String CExcerpt) {
		this.CName = CName;
		this.CAuthor = CAuthor;
		this.CCreateTime = CCreateTime;
		this.CPic = CPic;
		this.CExcerpt = CExcerpt;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "c_id", unique = true, nullable = false)
	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	@Column(name = "c_name")
	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Column(name = "c_author")
	public String getCAuthor() {
		return this.CAuthor;
	}

	public void setCAuthor(String CAuthor) {
		this.CAuthor = CAuthor;
	}

	@Column(name = "c_create_time", length = 19)
	public Timestamp getCCreateTime() {
		return this.CCreateTime;
	}

	public void setCCreateTime(Timestamp CCreateTime) {
		this.CCreateTime = CCreateTime;
	}

	@Column(name = "c_pic")
	public String getCPic() {
		return this.CPic;
	}

	public void setCPic(String CPic) {
		this.CPic = CPic;
	}

	@Column(name = "c_excerpt")
	public String getCExcerpt() {
		return this.CExcerpt;
	}

	public void setCExcerpt(String CExcerpt) {
		this.CExcerpt = CExcerpt;
	}

	@Column(name = "cat_id", unique = true, nullable = false)
	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}
}