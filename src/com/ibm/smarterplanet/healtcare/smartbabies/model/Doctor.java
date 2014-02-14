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
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String doctorName;
	
	private String doctorSurname;
	
	private String doctorEmail;
	
	private String doctorPhone;
	
	private Date doctorBirthday;
	
	private char doctorIsDeleted;
	
	@OneToOne(mappedBy="doctor")
	private DoctorDetail doctorDetail;
	
	@OneToMany(mappedBy="doctor")
	private List<UserList> userLists;
	
	@OneToMany(mappedBy="doctor")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="doctor")
	private List<NutritionCalendar> nutritionCalendars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public Date getDoctorBirthday() {
		return doctorBirthday;
	}

	public void setDoctorBirthday(Date doctorBirthday) {
		this.doctorBirthday = doctorBirthday;
	}

	public char getDoctorIsDeleted() {
		return doctorIsDeleted;
	}

	public void setDoctorIsDeleted(char doctorIsDeleted) {
		this.doctorIsDeleted = doctorIsDeleted;
	}

	public DoctorDetail getDoctorDetail() {
		return doctorDetail;
	}

	public void setDoctorDetail(DoctorDetail doctorDetail) {
		this.doctorDetail = doctorDetail;
	}

	public List<UserList> getUserLists() {
		return userLists;
	}

	public void setUserLists(List<UserList> userLists) {
		this.userLists = userLists;
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
	

}
