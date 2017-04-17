package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HedouClassNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Hedou_Class_News", catalog = "hedou")
public class HedouClassNews implements java.io.Serializable {

	// Fields

	private Long newsId;
	private String newsTitle;
	private String newsLink;
	private Timestamp newsCreateTime;
	private String newsType;

	// Constructors

	/** default constructor */
	public HedouClassNews() {
	}

	/** full constructor */
	public HedouClassNews(String newsTitle, String newsLink,
			Timestamp newsCreateTime, String newsType) {
		this.newsTitle = newsTitle;
		this.newsLink = newsLink;
		this.newsCreateTime = newsCreateTime;
		this.newsType = newsType;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "news_id", unique = true, nullable = false)
	public Long getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	@Column(name = "news_title")
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_link")
	public String getNewsLink() {
		return this.newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	@Column(name = "news_create_time", length = 19)
	public Timestamp getNewsCreateTime() {
		return this.newsCreateTime;
	}

	public void setNewsCreateTime(Timestamp newsCreateTime) {
		this.newsCreateTime = newsCreateTime;
	}

	@Column(name = "news_type")
	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

}