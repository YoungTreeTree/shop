package com.hedou.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserCourseRelationId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UserCourseRelationId implements java.io.Serializable {

	// Fields

	private Long CId;
	private Long UId;

	// Constructors

	/** default constructor */
	public UserCourseRelationId() {
	}

	/** full constructor */
	public UserCourseRelationId(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	// Property accessors

	@Column(name = "c_id", nullable = false)
	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	@Column(name = "u_id", nullable = false)
	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserCourseRelationId))
			return false;
		UserCourseRelationId castOther = (UserCourseRelationId) other;

		return ((this.getCId() == castOther.getCId()) || (this.getCId() != null
				&& castOther.getCId() != null && this.getCId().equals(
				castOther.getCId())))
				&& ((this.getUId() == castOther.getUId()) || (this.getUId() != null
						&& castOther.getUId() != null && this.getUId().equals(
						castOther.getUId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCId() == null ? 0 : this.getCId().hashCode());
		result = 37 * result
				+ (getUId() == null ? 0 : this.getUId().hashCode());
		return result;
	}

}