package com.shop.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProblemPassageSingleRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Problem_Passage_Single_Relation", catalog = "shop")
public class ProblemPassageSingleRelation implements java.io.Serializable {

	// Fields

	private ProblemPassageSingleRelationId id;

	// Constructors

	/** default constructor */
	public ProblemPassageSingleRelation() {
	}

	/** full constructor */
	public ProblemPassageSingleRelation(ProblemPassageSingleRelationId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "PId", column = @Column(name = "p_id", nullable = false)),
			@AttributeOverride(name = "ppsId", column = @Column(name = "pps_id", nullable = false)) })
	public ProblemPassageSingleRelationId getId() {
		return this.id;
	}

	public void setId(ProblemPassageSingleRelationId id) {
		this.id = id;
	}

}