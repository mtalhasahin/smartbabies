package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.EJBException;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

public class UserRagistrationBean {
	
	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<User> userEvent;

	private User user;

	@Named
	@Produces
	public User getUser() {
		return user;
	}

	public void registerUser() {

		try {
			entityManager.persist(user);
			// success message
			userEvent.fire(user);
			initNewUser();

		} catch (EJBException e) {
			// error message

		} catch (Exception e) {
			// error message

		}

	}

	public void initNewUser() {
		user = new User();
	}
	

}
