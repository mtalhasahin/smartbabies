package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.VaccinationCalendar;

//Yeni aşı takvimi kayıt eder

@Model
@Stateful
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
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));
			vaccinationCalendarEvent.fire(vaccinationCalendar);
			initNewVaccinationCalendar();

		} catch (EJBException e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));

		} catch (Exception e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));

		}

	}

	public void initNewVaccinationCalendar() {
		vaccinationCalendar = new VaccinationCalendar();
	}

}
