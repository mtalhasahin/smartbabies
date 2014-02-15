package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.EJBException;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.VaccinationCalendar;

public class VaccinationCalendarRegistrationBean {
	
	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<VaccinationCalendar> vaccinationCalendarEvent;

	private VaccinationCalendar vaccinationCalendar;

	@Named
	@Produces
	public VaccinationCalendar getVaccinationCalendar() {
		return vaccinationCalendar;
	}

	public void registerVaccinationCalendar() {

		try {
			entityManager.persist(vaccinationCalendar);
			// success message
			vaccinationCalendarEvent.fire(vaccinationCalendar);
			initNewVaccinationCalendar();

		} catch (EJBException e) {
			// error message

		} catch (Exception e) {
			// error message

		}

	}

	public void initNewVaccinationCalendar() {
		vaccinationCalendar = new VaccinationCalendar();
	}

}
