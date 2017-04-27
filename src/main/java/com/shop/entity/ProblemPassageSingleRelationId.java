package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProblemPassageSingleRelationId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ProblemPassageSingleRelationId implements java.io.Serializable {

	// Fields

	private Long PId;
	private Long ppsId;

	// Constructors

	/** default constructor */
	public ProblemPassageSingleRelationId() {
	}

	/** full constructor */
	public ProblemPassageSingleRelationId(Long PId, Long ppsId) {
		this.PId = PId;
		this.ppsId = ppsId;
	}

	// Property accessors

	@Column(name = "p_id", nullable = false)
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	@Column(name = "pps_id", nullable = false)
	public Long getPpsId() {
		return this.ppsId;
	}

	public void setPpsId(Long ppsId) {
		this.ppsId = ppsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProblemPassageSingleRelationId))
			return false;
		ProblemPassageSingleRelationId castOther = (ProblemPassageSingleRelationId) other;

		return ((this.getPId() == castOther.getPId()) || (this.getPId() != null
				&& castOther.getPId() != null && this.getPId().equals(
				castOther.getPId())))
				&& ((this.getPpsId() == castOther.getPpsId()) || (this
						.getPpsId() != null && castOther.getPpsId() != null && this
						.getPpsId().equals(castOther.getPpsId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPId() == null ? 0 : this.getPId().hashCode());
		result = 37 * result
				+ (getPpsId() == null ? 0 : this.getPpsId().hashCode());
		return result;
	}

}