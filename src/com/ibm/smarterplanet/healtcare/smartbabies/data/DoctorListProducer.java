package com.ibm.smarterplanet.healtcare.smartbabies.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ibm.smarterplanet.healtcare.smartbabies.model.Doctor;

@RequestScoped
public class DoctorListProducer {

	@Inject
	private EntityManager entityManager;

	private List<Doctor> doctors;

	@Produces
	@Named
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void onDoctorListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Doctor doctor) {
		retrieveAllDoctors();
	}

	@PostConstruct
	public void retrieveAllDoctors() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteriaQuery = criteriaBuilder
				.createQuery(Doctor.class);
		Root<Doctor> doctor = criteriaQuery.from(Doctor.class);
		criteriaQuery.select(doctor);
		doctors = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
