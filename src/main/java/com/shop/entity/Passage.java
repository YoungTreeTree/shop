package com.shop.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Passage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Passage", catalog = "shop")
public class Passage implements java.io.Serializable {

	// Fields

	private Long PId;
	private Long claId;
	private String PTitle;
	private String PTextContent;
	private String PAuthor;
	private Timestamp PTime;
	private Integer PType;
	private String PExcerpt;
	private String PPoster;
	private String PVideo;

	// Constructors

	/** default constructor */
	public Passage() {
	}

	/** full constructor */
	public Passage(Long claId, String PTitle, String PTextContent,
			String PAuthor, Timestamp PTime, Integer PType, String PExcerpt,
			String PPoster, String PVideo) {
		this.claId = claId;
		this.PTitle = PTitle;
		this.PTextContent = PTextContent;
		this.PAuthor = PAuthor;
		this.PTime = PTime;
		this.PType = PType;
		this.PExcerpt = PExcerpt;
		this.PPoster = PPoster;
		this.PVideo = PVideo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "p_id", unique = true, nullable = false)
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	@Column(name = "cla_id")
	public Long getClaId() {
		return this.claId;
	}

	public void setClaId(Long claId) {
		this.claId = claId;
	}

	@Column(name = "p_title")
	public String getPTitle() {
		return this.PTitle;
	}

	public void setPTitle(String PTitle) {
		this.PTitle = PTitle;
	}

	@Column(name = "p_textContent")
	public String getPTextContent() {
		return this.PTextContent;
	}

	public void setPTextContent(String PTextContent) {
		this.PTextContent = PTextContent;
	}

	@Column(name = "p_author")
	public String getPAuthor() {
		return this.PAuthor;
	}

	public void setPAuthor(String PAuthor) {
		this.PAuthor = PAuthor;
	}

	@Column(name = "p_time", length = 19)
	public Timestamp getPTime() {
		return this.PTime;
	}

	public void setPTime(Timestamp PTime) {
		this.PTime = PTime;
	}

	@Column(name = "p_type")
	public Integer getPType() {
		return this.PType;
	}

	public void setPType(Integer PType) {
		this.PType = PType;
	}

	@Column(name = "p_excerpt")
	public String getPExcerpt() {
		return this.PExcerpt;
	}

	public void setPExcerpt(String PExcerpt) {
		this.PExcerpt = PExcerpt;
	}

	@Column(name = "p_poster")
	public String getPPoster() {
		return this.PPoster;
	}

	public void setPPoster(String PPoster) {
		this.PPoster = PPoster;
	}

	@Column(name = "p_video")
	public String getPVideo() {
		return this.PVideo;
	}

	public void setPVideo(String PVideo) {
		this.PVideo = PVideo;
	}

}