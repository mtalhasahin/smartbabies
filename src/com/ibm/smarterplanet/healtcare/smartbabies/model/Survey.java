package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Survey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String surveyQuestion;
	
	private char surveyQuestionIsDeleted;
	
	@OneToMany(mappedBy="survey")
	private List<SurveyAnswer> surveyAnswers;
	
	@OneToMany(mappedBy="survey")
	private List<AnswerOfUser> answerOfUsers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(String surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public char getSurveyQuestionIsDeleted() {
		return surveyQuestionIsDeleted;
	}

	public void setSurveyQuestionIsDeleted(char surveyQuestionIsDeleted) {
		this.surveyQuestionIsDeleted = surveyQuestionIsDeleted;
	}

	public List<SurveyAnswer> getSurveyAnswers() {
		return surveyAnswers;
	}

	public void setSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public List<AnswerOfUser> getAnswerOfUsers() {
		return answerOfUsers;
	}

	public void setAnswerOfUsers(List<AnswerOfUser> answerOfUsers) {
		this.answerOfUsers = answerOfUsers;
	}
	

}
