package com.hedou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProblemPassageSingle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Problem_Passage_Single", catalog = "hedou")
public class ProblemPassageSingle implements java.io.Serializable {

	// Fields

	private Long ppsId;
	private String ppsContent;
	private String ppsChoice1;
	private String ppsChoice2;
	private String ppsChoice3;
	private String ppsChoice4;
	private String ppsAnswer;

	// Constructors

	/** default constructor */
	public ProblemPassageSingle() {
	}

	/** full constructor */
	public ProblemPassageSingle(String ppsContent, String ppsChoice1,
			String ppsChoice2, String ppsChoice3, String ppsChoice4,
			String ppsAnswer) {
		this.ppsContent = ppsContent;
		this.ppsChoice1 = ppsChoice1;
		this.ppsChoice2 = ppsChoice2;
		this.ppsChoice3 = ppsChoice3;
		this.ppsChoice4 = ppsChoice4;
		this.ppsAnswer = ppsAnswer;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pps_id", unique = true, nullable = false)
	public Long getPpsId() {
		return this.ppsId;
	}

	public void setPpsId(Long ppsId) {
		this.ppsId = ppsId;
	}

	@Column(name = "pps_content", length = 65535)
	public String getPpsContent() {
		return this.ppsContent;
	}

	public void setPpsContent(String ppsContent) {
		this.ppsContent = ppsContent;
	}

	@Column(name = "pps_choice1", length = 65535)
	public String getPpsChoice1() {
		return this.ppsChoice1;
	}

	public void setPpsChoice1(String ppsChoice1) {
		this.ppsChoice1 = ppsChoice1;
	}

	@Column(name = "pps_choice2", length = 65535)
	public String getPpsChoice2() {
		return this.ppsChoice2;
	}

	public void setPpsChoice2(String ppsChoice2) {
		this.ppsChoice2 = ppsChoice2;
	}

	@Column(name = "pps_choice3", length = 65535)
	public String getPpsChoice3() {
		return this.ppsChoice3;
	}

	public void setPpsChoice3(String ppsChoice3) {
		this.ppsChoice3 = ppsChoice3;
	}

	@Column(name = "pps_choice4", length = 65535)
	public String getPpsChoice4() {
		return this.ppsChoice4;
	}

	public void setPpsChoice4(String ppsChoice4) {
		this.ppsChoice4 = ppsChoice4;
	}

	@Column(name = "pps_answer", length = 2)
	public String getPpsAnswer() {
		return this.ppsAnswer;
	}

	public void setPpsAnswer(String ppsAnswer) {
		this.ppsAnswer = ppsAnswer;
	}

}