package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String userName;
	
	private String userSurname;
	
	private String userEmail;
	
	private String userPhone;
	
	private Date userBirthday;
	
	private char userIsDeleted;
	
	@OneToOne(mappedBy="user")
	private UserDetail userDetail;
	
	@OneToMany(mappedBy="user")
	private List<UserList> userLists;
	
	@OneToMany(mappedBy="user")
	private List<AnswerOfUser> answerOfUsers;

	@OneToMany(mappedBy="user")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="user")
	private List<NutritionCalendar> nutritionCalendars;
	
	@OneToMany(mappedBy="user")
	private List<OvulationCalendar> vaccinationCalendars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public char getUserIsDeleted() {
		return userIsDeleted;
	}

	public void setUserIsDeleted(char userIsDeleted) {
		this.userIsDeleted = userIsDeleted;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<UserList> getUserLists() {
		return userLists;
	}

	public void setUserLists(List<UserList> userLists) {
		this.userLists = userLists;
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

	public List<NutritionCalendar> getNutritionCalendars() {
		return nutritionCalendars;
	}

	public void setNutritionCalendars(List<NutritionCalendar> nutritionCalendars) {
		this.nutritionCalendars = nutritionCalendars;
	}

	public List<OvulationCalendar> getVaccinationCalendars() {
		return vaccinationCalendars;
	}

	public void setVaccinationCalendars(
			List<OvulationCalendar> vaccinationCalendars) {
		this.vaccinationCalendars = vaccinationCalendars;
	}
	

}
