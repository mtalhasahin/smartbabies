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
public class Pregnancy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pregnancyId;
	
	private String pregnancyStartDate;
	
	@OneToMany(mappedBy="pregnancy")
	private List<Child> childs;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private DoctorDetail doctorDetail;
	
	@OneToMany(mappedBy="pregnancy")
	private List<NutritionCalendar> calendars;
	
	@OneToOne(mappedBy="pregnancy")
	private VaccinationCalendar vaccinationCalendar;

	public long getPregnancyId() {
		return pregnancyId;
	}

	public String getPregnancyStartDate() {
		return pregnancyStartDate;
	}

	public List<Child> getChilds() {
		return childs;
	}

	public User getUser() {
		return user;
	}

	public DoctorDetail getDoctorDetail() {
		return doctorDetail;
	}

	public List<NutritionCalendar> getCalendars() {
		return calendars;
	}

	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void setPregnancyId(long pregnancyId) {
		this.pregnancyId = pregnancyId;
	}

	public void setPregnancyStartDate(String pregnancyStartDate) {
		this.pregnancyStartDate = pregnancyStartDate;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDoctorDetail(DoctorDetail doctorDetail) {
		this.doctorDetail = doctorDetail;
	}

	public void setCalendars(List<NutritionCalendar> calendars) {
		this.calendars = calendars;
	}

	public void setVaccinationCalendar(VaccinationCalendar vaccinationCalendar) {
		this.vaccinationCalendar = vaccinationCalendar;
	}
	
}
