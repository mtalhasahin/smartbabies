package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class DoctorDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long doctorDetailId;
	
	private char doctorDetailIsDeleted;
	
	@OneToOne
	private Doctor doctor;
	
	@ManyToOne
	private Hospital hospital;

	private String doctorBirthday;
	
	@OneToMany(mappedBy="doctorDetail")
	private List<Pregnancy> pregnancies;

	@OneToMany(mappedBy = "doctorDetail")
	private List<Appointment> appointments;

	public long getDoctorDetailId() {
		return doctorDetailId;
	}

	public void setDoctorDetailId(long doctorDetailId) {
		this.doctorDetailId = doctorDetailId;
	}

	public char getDoctorDetailIsDeleted() {
		return doctorDetailIsDeleted;
	}

	public void setDoctorDetailIsDeleted(char doctorDetailIsDeleted) {
		this.doctorDetailIsDeleted = doctorDetailIsDeleted;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getDoctorBirthday() {
		return doctorBirthday;
	}

	public void setDoctorBirthday(String doctorBirthday) {
		this.doctorBirthday = doctorBirthday;
	}

	public List<Pregnancy> getPregnancies() {
		return pregnancies;
	}

	public void setPregnancies(List<Pregnancy> pregnancies) {
		this.pregnancies = pregnancies;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
}
