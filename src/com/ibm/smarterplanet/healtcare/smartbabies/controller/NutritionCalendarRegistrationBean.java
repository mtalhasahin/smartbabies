package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.EJBException;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.NutritionCalendar;

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
			// success message
			nutritionCalendarEvent.fire(nutritionCalendar);
			initNewNutritionCalendar();

		} catch (EJBException e) {
			// error message

		} catch (Exception e) {
			// error message

		}

	}

	public void initNewNutritionCalendar() {
		nutritionCalendar = new NutritionCalendar();
	}

}
