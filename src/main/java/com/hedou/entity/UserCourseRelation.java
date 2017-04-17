package com.hedou.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UserCourseRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User_Course_Relation", catalog = "hedou")
public class UserCourseRelation implements java.io.Serializable {

	// Fields

	private UserCourseRelationId id;

	// Constructors

	/** default constructor */
	public UserCourseRelation() {
	}

	/** full constructor */
	public UserCourseRelation(UserCourseRelationId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "CId", column = @Column(name = "c_id", nullable = false)),
			@AttributeOverride(name = "UId", column = @Column(name = "u_id", nullable = false)) })
	public UserCourseRelationId getId() {
		return this.id;
	}

	public void setId(UserCourseRelationId id) {
		this.id = id;
	}

}