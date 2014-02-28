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
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	private String userName;

	private String userSurname;

	private String userEmail;

	private String userPhone;

	private String userBirthday;

	private char userIsDeleted;
	
	@OneToMany(mappedBy="user")
	private List<Pregnancy> pregnancies;

	@OneToMany(mappedBy = "user")
	private List<AnswerOfUser> answerOfUsers;

	@OneToMany(mappedBy = "user")
	private List<Appointment> appointments;

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public char getUserIsDeleted() {
		return userIsDeleted;
	}

	public List<Pregnancy> getPregnancies() {
		return pregnancies;
	}

	public List<AnswerOfUser> getAnswerOfUsers() {
		return answerOfUsers;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public void setUserIsDeleted(char userIsDeleted) {
		this.userIsDeleted = userIsDeleted;
	}

	public void setPregnancies(List<Pregnancy> pregnancies) {
		this.pregnancies = pregnancies;
	}

	public void setAnswerOfUsers(List<AnswerOfUser> answerOfUsers) {
		this.answerOfUsers = answerOfUsers;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	

}
