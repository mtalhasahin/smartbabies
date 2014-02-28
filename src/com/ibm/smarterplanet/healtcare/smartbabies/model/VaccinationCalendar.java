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
public class VaccinationCalendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vaccinationId;
	
	@OneToMany(mappedBy="vaccinationCalendar")
	private List<Vaccine> vaccines;
	
	private char vaccinationIsComplete;
	
	private char vaccinationIsChild;
	
	@OneToOne
	private Pregnancy pregnancy;

	public long getVaccinationId() {
		return vaccinationId;
	}

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public char getVaccinationIsComplete() {
		return vaccinationIsComplete;
	}

	public char getVaccinationIsChild() {
		return vaccinationIsChild;
	}

	public Pregnancy getPregnancy() {
		return pregnancy;
	}

	public void setVaccinationId(long vaccinationId) {
		this.vaccinationId = vaccinationId;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public void setVaccinationIsComplete(char vaccinationIsComplete) {
		this.vaccinationIsComplete = vaccinationIsComplete;
	}

	public void setVaccinationIsChild(char vaccinationIsChild) {
		this.vaccinationIsChild = vaccinationIsChild;
	}

	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}
		

}
