package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IndexCarouselItems entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Index_Carousel_Items", catalog = "hedou")
public class IndexCarouselItems implements java.io.Serializable {

	// Fields

	private Integer carId;
	private String carPic;
	private String carCaption;
	private String carLink;
	private Integer carIndex;
	private Timestamp carCreateTime;

	// Constructors

	/** default constructor */
	public IndexCarouselItems() {
	}

	/** full constructor */
	public IndexCarouselItems(String carPic, String carCaption, String carLink,
			Integer carIndex, Timestamp carCreateTime) {
		this.carPic = carPic;
		this.carCaption = carCaption;
		this.carLink = carLink;
		this.carIndex = carIndex;
		this.carCreateTime = carCreateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "car_id", unique = true, nullable = false)
	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	@Column(name = "car_pic")
	public String getCarPic() {
		return this.carPic;
	}

	public void setCarPic(String carPic) {
		this.carPic = carPic;
	}

	@Column(name = "car_caption")
	public String getCarCaption() {
		return this.carCaption;
	}

	public void setCarCaption(String carCaption) {
		this.carCaption = carCaption;
	}

	@Column(name = "car_link")
	public String getCarLink() {
		return this.carLink;
	}

	public void setCarLink(String carLink) {
		this.carLink = carLink;
	}

	@Column(name = "car_index")
	public Integer getCarIndex() {
		return this.carIndex;
	}

	public void setCarIndex(Integer carIndex) {
		this.carIndex = carIndex;
	}

	@Column(name = "car_create_time", length = 19)
	public Timestamp getCarCreateTime() {
		return this.carCreateTime;
	}

	public void setCarCreateTime(Timestamp carCreateTime) {
		this.carCreateTime = carCreateTime;
	}

}