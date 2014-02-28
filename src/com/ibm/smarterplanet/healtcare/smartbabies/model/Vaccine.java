package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Vaccine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private long vaccineId;
	
	private String vaccineName;
	
	private String vaccineDate;
	
	@ManyToOne
	private VaccinationCalendar vaccinationCalendar;

	public long getVaccineId() {
		return vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public String getVaccineDate() {
		return vaccineDate;
	}

	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void setVaccineId(long vaccineId) {
		this.vaccineId = vaccineId;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public void setVaccineDate(String vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public void setVaccinationCalendar(VaccinationCalendar vaccinationCalendar) {
		this.vaccinationCalendar = vaccinationCalendar;
	}
	

}
