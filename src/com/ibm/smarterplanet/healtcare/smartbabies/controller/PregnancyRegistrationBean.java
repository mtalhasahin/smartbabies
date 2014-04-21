package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;

//yeni gebelik kaydı oluşturur

@Stateless
public class PregnancyRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Pregnancy> pregnancyEvent;

	public void registerPregnancy(Pregnancy pregnancy) {

		try {
			
			entityManager.persist(pregnancy);
			pregnancyEvent.fire(pregnancy);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
