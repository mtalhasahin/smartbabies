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
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;

	private String doctorName;

	private String doctorSurname;

	private String doctorEmail;

	private String doctorPhone;

	private char doctorIsDeleted;

	@OneToOne(mappedBy = "doctor")
	private DoctorDetail doctorDetail;

	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;

	public long getDoctorId() {
		return doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getDoctorSurname() {
		return doctorSurname;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public char getDoctorIsDeleted() {
		return doctorIsDeleted;
	}

	public DoctorDetail getDoctorDetail() {
		return doctorDetail;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public void setDoctorIsDeleted(char doctorIsDeleted) {
		this.doctorIsDeleted = doctorIsDeleted;
	}

	public void setDoctorDetail(DoctorDetail doctorDetail) {
		this.doctorDetail = doctorDetail;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
}
