package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "outdoor")
public class Product implements java.io.Serializable {

	// Fields

	private Long id;
	private Double offPrice;
	private Double originalPrice;
	private Integer brokerage;
	private Long isSale;
	private String mainPicRoute;
	private String content1;
	private String content2;
	private String content3;
	private String content4;
	private String title;
	private Long maxPeople;
	private String description1;
	private String description2;
	private String description3;
	private String tag1;
	private String tag2;
	private String tag3;
	private String destination;
	private String costComponent;
	private Long score;
	private Integer kind;
	private Integer outPeople;
	private Integer attendance;
	private Integer whetherDisplaySchool;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(Double offPrice, Double originalPrice, Integer brokerage,
			Long isSale, String mainPicRoute, String content1, String content2,
			String content3, String content4, String title, Long maxPeople,
			String description1, String description2, String description3,
			String tag1, String tag2, String tag3, String destination,
			String costComponent, Long score, Integer kind, Integer outPeople,
			Integer attendance, Integer whetherDisplaySchool) {
		this.offPrice = offPrice;
		this.originalPrice = originalPrice;
		this.brokerage = brokerage;
		this.isSale = isSale;
		this.mainPicRoute = mainPicRoute;
		this.content1 = content1;
		this.content2 = content2;
		this.content3 = content3;
		this.content4 = content4;
		this.title = title;
		this.maxPeople = maxPeople;
		this.description1 = description1;
		this.description2 = description2;
		this.description3 = description3;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.destination = destination;
		this.costComponent = costComponent;
		this.score = score;
		this.kind = kind;
		this.outPeople = outPeople;
		this.attendance = attendance;
		this.whetherDisplaySchool = whetherDisplaySchool;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "OFF_PRICE", precision = 10, scale = 4)
	public Double getOffPrice() {
		return this.offPrice;
	}

	public void setOffPrice(Double offPrice) {
		this.offPrice = offPrice;
	}

	@Column(name = "ORIGINAL_PRICE", precision = 10, scale = 4)
	public Double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Column(name = "BROKERAGE")
	public Integer getBrokerage() {
		return this.brokerage;
	}

	public void setBrokerage(Integer brokerage) {
		this.brokerage = brokerage;
	}

	@Column(name = "IS_SALE")
	public Long getIsSale() {
		return this.isSale;
	}

	public void setIsSale(Long isSale) {
		this.isSale = isSale;
	}

	@Column(name = "MAIN_PIC_ROUTE")
	public String getMainPicRoute() {
		return this.mainPicRoute;
	}

	public void setMainPicRoute(String mainPicRoute) {
		this.mainPicRoute = mainPicRoute;
	}

	@Column(name = "CONTENT1")
	public String getContent1() {
		return this.content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	@Column(name = "CONTENT2")
	public String getContent2() {
		return this.content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	@Column(name = "CONTENT3")
	public String getContent3() {
		return this.content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	@Column(name = "CONTENT4")
	public String getContent4() {
		return this.content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "MAX_PEOPLE")
	public Long getMaxPeople() {
		return this.maxPeople;
	}

	public void setMaxPeople(Long maxPeople) {
		this.maxPeople = maxPeople;
	}

	@Column(name = "DESCRIPTION1")
	public String getDescription1() {
		return this.description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	@Column(name = "DESCRIPTION2")
	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	@Column(name = "DESCRIPTION3")
	public String getDescription3() {
		return this.description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	@Column(name = "TAG1")
	public String getTag1() {
		return this.tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	@Column(name = "TAG2")
	public String getTag2() {
		return this.tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	@Column(name = "TAG3")
	public String getTag3() {
		return this.tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	@Column(name = "DESTINATION")
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Column(name = "COST_COMPONENT")
	public String getCostComponent() {
		return this.costComponent;
	}

	public void setCostComponent(String costComponent) {
		this.costComponent = costComponent;
	}

	@Column(name = "SCORE")
	public Long getScore() {
		return this.score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	@Column(name = "KIND")
	public Integer getKind() {
		return this.kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	@Column(name = "OUT_PEOPLE")
	public Integer getOutPeople() {
		return this.outPeople;
	}

	public void setOutPeople(Integer outPeople) {
		this.outPeople = outPeople;
	}

	@Column(name = "ATTENDANCE")
	public Integer getAttendance() {
		return this.attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	@Column(name = "WHETHER_DISPLAY_SCHOOL")
	public Integer getWhetherDisplaySchool() {
		return this.whetherDisplaySchool;
	}

	public void setWhetherDisplaySchool(Integer whetherDisplaySchool) {
		this.whetherDisplaySchool = whetherDisplaySchool;
	}

}