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
	private long appointmentId;

	private Date appointmantDate;

	private char appointmentIsAccept;

	private char appointmentIsDeleted;

	@ManyToOne
	private DoctorDetail doctorDetail;

	@ManyToOne
	private UserDetail userDetail;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
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

	public DoctorDetail getDoctorDetail() {
		return doctorDetail;
	}

	public void setDoctorDetail(DoctorDetail doctorDetail) {
		this.doctorDetail = doctorDetail;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	

}
