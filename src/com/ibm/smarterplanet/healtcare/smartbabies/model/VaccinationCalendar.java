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
public class VaccinationCalendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String vaccinationName;
	
	private Date date;
	
	private char vaccinationIsComplete;
	
	private char vaccinationIsChild;
	
	@ManyToOne
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVaccinationName() {
		return vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getVaccinationIsComplete() {
		return vaccinationIsComplete;
	}

	public void setVaccinationIsComplete(char vaccinationIsComplete) {
		this.vaccinationIsComplete = vaccinationIsComplete;
	}

	public char getVaccinationIsChild() {
		return vaccinationIsChild;
	}

	public void setVaccinationIsChild(char vaccinationIsChild) {
		this.vaccinationIsChild = vaccinationIsChild;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

}
