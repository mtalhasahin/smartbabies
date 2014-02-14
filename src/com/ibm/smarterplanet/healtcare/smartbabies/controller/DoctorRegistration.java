package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
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
public class DoctorRegistration {

	@Inject
	private Logger logger;

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
	
	public void registerDoctor(){
		
	}
	
	@PostConstruct
	public void initNewDoctor(){
		doctor = new Doctor();
	}
	
	
	
}
