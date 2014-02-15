package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.Appointment;

@Model
@Stateful
public class AppointmentRegistartionBean {
	
	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Appointment> appointmentEvent;

	private Appointment appointment;

	@Named
	@Produces
	public Appointment getAppointment() {
		return appointment;
	}

	public void registerAppointment() {

		try {
			entityManager.persist(appointment);
			// success message
			appointmentEvent.fire(appointment);
			initNewAppointment();

		} catch (EJBException e) {
			// error message

		} catch (Exception e) {
			// error message

		}

	}

	public void initNewAppointment() {
		appointment = new Appointment();
	}
	
}
