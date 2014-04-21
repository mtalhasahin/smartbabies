package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userDetailId;
	
	private String userBirthday;
	
	private double userHeight;
	
	private double userWeight;
	
	private char userDetailIsDeleted;
	
	@OneToOne
	private User user;
	
	@OneToMany(mappedBy="userDetail")
	private List<Pregnancy> pregnancies;

	@OneToMany(mappedBy = "userDetail")
	private List<AnswerOfUser> answerOfUsers;

	@OneToMany(mappedBy = "userDetail")
	private List<Appointment> appointments;

	public long getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public double getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(double userHeight) {
		this.userHeight = userHeight;
	}

	public double getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(double userWeight) {
		this.userWeight = userWeight;
	}

	public char getUserDetailIsDeleted() {
		return userDetailIsDeleted;
	}

	public void setUserDetailIsDeleted(char userDetailIsDeleted) {
		this.userDetailIsDeleted = userDetailIsDeleted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Pregnancy> getPregnancies() {
		return pregnancies;
	}

	public void setPregnancies(List<Pregnancy> pregnancies) {
		this.pregnancies = pregnancies;
	}

	public List<AnswerOfUser> getAnswerOfUsers() {
		return answerOfUsers;
	}

	public void setAnswerOfUsers(List<AnswerOfUser> answerOfUsers) {
		this.answerOfUsers = answerOfUsers;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


}
