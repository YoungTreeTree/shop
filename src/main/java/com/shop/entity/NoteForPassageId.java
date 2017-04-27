package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NoteForPassageId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class NoteForPassageId implements java.io.Serializable {

	// Fields

	private Long PId;
	private Long UId;

	// Constructors

	/** default constructor */
	public NoteForPassageId() {
	}

	/** full constructor */
	public NoteForPassageId(Long PId, Long UId) {
		this.PId = PId;
		this.UId = UId;
	}

	// Property accessors

	@Column(name = "p_id", nullable = false)
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
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
		if (!(other instanceof NoteForPassageId))
			return false;
		NoteForPassageId castOther = (NoteForPassageId) other;

		return ((this.getPId() == castOther.getPId()) || (this.getPId() != null
				&& castOther.getPId() != null && this.getPId().equals(
				castOther.getPId())))
				&& ((this.getUId() == castOther.getUId()) || (this.getUId() != null
						&& castOther.getUId() != null && this.getUId().equals(
						castOther.getUId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPId() == null ? 0 : this.getPId().hashCode());
		result = 37 * result
				+ (getUId() == null ? 0 : this.getUId().hashCode());
		return result;
	}

}