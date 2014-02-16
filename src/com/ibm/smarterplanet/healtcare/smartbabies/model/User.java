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
	private long id;

	private String name;

	private String surname;

	private String email;

	private String phone;

	private Date birthday;

	private char isDeleted;

	@OneToOne(mappedBy = "user")
	private UserDetail userDetail;

	@OneToMany(mappedBy = "user")
	private List<UserList> userLists;

	@OneToMany(mappedBy = "user")
	private List<AnswerOfUser> answerOfUsers;

	@OneToMany(mappedBy = "user")
	private List<Appointment> appointments;

	@OneToMany(mappedBy = "user")
	private List<NutritionCalendar> nutritionCalendars;

	@OneToMany(mappedBy = "user")
	private List<VaccinationCalendar> vaccinationCalendars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public char getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
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

	public List<VaccinationCalendar> getVaccinationCalendars() {
		return vaccinationCalendars;
	}

	public void setVaccinationCalendars(
			List<VaccinationCalendar> vaccinationCalendars) {
		this.vaccinationCalendars = vaccinationCalendars;
	}

}
