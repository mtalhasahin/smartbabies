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

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

//Yeni kullanıcı kayıt eder

@Model
@Stateful
public class UserRegistrationBean {

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
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));
			userEvent.fire(user);
			initNewUser();

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

	public void initNewUser() {
		user = new User();
	}

}
