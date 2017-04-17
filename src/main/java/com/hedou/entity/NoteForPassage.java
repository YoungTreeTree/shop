package com.hedou.entity;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NoteForPassage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Note_For_Passage", catalog = "hedou")
public class NoteForPassage implements java.io.Serializable {

	// Fields

	private NoteForPassageId id;
	private String noteContent;
	private Timestamp noteDate;

	// Constructors

	/** default constructor */
	public NoteForPassage() {
	}

	/** minimal constructor */
	public NoteForPassage(NoteForPassageId id) {
		this.id = id;
	}

	/** full constructor */
	public NoteForPassage(NoteForPassageId id, String noteContent,
			Timestamp noteDate) {
		this.id = id;
		this.noteContent = noteContent;
		this.noteDate = noteDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "PId", column = @Column(name = "p_id", nullable = false)),
			@AttributeOverride(name = "UId", column = @Column(name = "u_id", nullable = false)) })
	public NoteForPassageId getId() {
		return this.id;
	}

	public void setId(NoteForPassageId id) {
		this.id = id;
	}

	@Column(name = "note_content")
	public String getNoteContent() {
		return this.noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	@Column(name = "note_date", length = 19)
	public Timestamp getNoteDate() {
		return this.noteDate;
	}

	public void setNoteDate(Timestamp noteDate) {
		this.noteDate = noteDate;
	}

}