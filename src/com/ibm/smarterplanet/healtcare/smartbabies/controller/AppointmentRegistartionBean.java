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

import com.ibm.smarterplanet.healtcare.smartbabies.model.Appointment;

//Yeni randevu kayıt eder

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
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));
			appointmentEvent.fire(appointment);
			initNewAppointment();

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

	public void initNewAppointment() {
		appointment = new Appointment();
	}

}
