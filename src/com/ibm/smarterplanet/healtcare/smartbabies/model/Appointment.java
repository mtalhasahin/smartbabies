package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date appointmantDate;

	private char appointmentIsAccept;

	private char appointmentIsDeleted;

	@ManyToOne
	private Doctor doctor;

	@ManyToOne
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAppointmantDate() {
		return appointmantDate;
	}

	public void setAppointmantDate(Date appointmantDate) {
		this.appointmantDate = appointmantDate;
	}

	public char getAppointmentIsAccept() {
		return appointmentIsAccept;
	}

	public void setAppointmentIsAccept(char appointmentIsAccept) {
		this.appointmentIsAccept = appointmentIsAccept;
	}

	public char getAppointmentIsDeleted() {
		return appointmentIsDeleted;
	}

	public void setAppointmentIsDeleted(char appointmentIsDeleted) {
		this.appointmentIsDeleted = appointmentIsDeleted;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
