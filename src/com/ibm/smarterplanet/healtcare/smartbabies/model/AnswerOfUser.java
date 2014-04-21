package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class AnswerOfUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long answerOfUserId;

	@ManyToOne
	private UserDetail userDetail;

	@ManyToOne
	private SurveyAnswer surveyAnswer;

	@ManyToOne
	private Survey survey;

	public long getAnswerOfUserId() {
		return answerOfUserId;
	}

	public void setAnswerOfUserId(long answerOfUserId) {
		this.answerOfUserId = answerOfUserId;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public SurveyAnswer getSurveyAnswer() {
		return surveyAnswer;
	}

	public void setSurveyAnswer(SurveyAnswer surveyAnswer) {
		this.surveyAnswer = surveyAnswer;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	
}
