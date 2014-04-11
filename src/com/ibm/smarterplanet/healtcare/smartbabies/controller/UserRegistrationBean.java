package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

//Yeni kullanıcı kayıt eder

@Stateless
public class UserRegistrationBean {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<User> userEvent;

	public void registerUser(User user) {

		try {
			entityManager.persist(user);
			userEvent.fire(user);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}