package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class SurveyAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String surveyAnswerName;
	
	private char surveyAbswerIsDeleted;
	
	@ManyToOne
	private Survey survey;

	@OneToMany(mappedBy="surveyAnswer")
	private List<AnswerOfUser> answerOfUsers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurveyAnswerName() {
		return surveyAnswerName;
	}

	public void setSurveyAnswerName(String surveyAnswerName) {
		this.surveyAnswerName = surveyAnswerName;
	}

	public char getSurveyAbswerIsDeleted() {
		return surveyAbswerIsDeleted;
	}

	public void setSurveyAbswerIsDeleted(char surveyAbswerIsDeleted) {
		this.surveyAbswerIsDeleted = surveyAbswerIsDeleted;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<AnswerOfUser> getAnswerOfUsers() {
		return answerOfUsers;
	}

	public void setAnswerOfUsers(List<AnswerOfUser> answerOfUsers) {
		this.answerOfUsers = answerOfUsers;
	}

}
