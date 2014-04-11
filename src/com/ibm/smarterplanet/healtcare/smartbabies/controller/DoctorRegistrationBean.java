package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.Doctor;

//Yeni doktor kayıt eder

@Stateless
public class DoctorRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Doctor> doctorEvent;

	public void registerDoctor(Doctor doctor) {

		try {
			entityManager.persist(doctor);
			doctorEvent.fire(doctor);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
