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

import com.ibm.smarterplanet.healtcare.smartbabies.model.NutritionCalendar;

//Yeni beslenme takvimi kayıt eder

@Model
@Stateful
public class NutritionCalendarRegistrationBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<NutritionCalendar> nutritionCalendarEvent;

	private NutritionCalendar nutritionCalendar;

	@Named
	@Produces
	public NutritionCalendar getNutritionCalendar() {
		return nutritionCalendar;
	}

	public void registerNutritionCalendar() {

		try {
			entityManager.persist(nutritionCalendar);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));
			nutritionCalendarEvent.fire(nutritionCalendar);
			initNewNutritionCalendar();

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

	public void initNewNutritionCalendar() {
		nutritionCalendar = new NutritionCalendar();
	}

}
