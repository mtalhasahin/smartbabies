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
public class Pregnancy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pregnancyId;
	
	private String pregnancyStartDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Doctor doctor;

	public long getPregnancyId() {
		return pregnancyId;
	}

	public void setPregnancyId(long pregnancyId) {
		this.pregnancyId = pregnancyId;
	}

	public String getPregnancyStartDate() {
		return pregnancyStartDate;
	}

	public void setPregnancyStartDate(String pregnancyStartDate) {
		this.pregnancyStartDate = pregnancyStartDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
