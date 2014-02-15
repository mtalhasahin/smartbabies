package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.Doctor;

@Model
@Stateful
public class DoctorRegistrationBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Doctor> doctorEvent;

	private Doctor doctor;

	@Named
	@Produces
	public Doctor getDoctor() {
		return doctor;
	}

	public void registerDoctor() {

		try {
			entityManager.persist(doctor);
			// success message
			doctorEvent.fire(doctor);
			initNewDoctor();

		} catch (EJBException e) {
			// error message

		} catch (Exception e) {
			// error message

		}

	}

	@PostConstruct
	public void initNewDoctor() {
		doctor = new Doctor();
	}

}
