package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserRegistrationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;

//Yeni bir kullanıcı hesabı oluşturur.
//Kullanıcı şifresini hashing işlemine tabii tutup, ilgili kaydı gerçekleştirecek EJB ye iletir.

@RequestScoped
@ManagedBean(name = "UserRegistration")
public class UserRegistration {

	@Inject
	private FacesContext facesContext;

	@EJB
	UserRegistrationBean userRegistrationBean;

	@EJB
	HashingBean hashingBean;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void registerUser() {

		try {
			user.setUserPassword(hashingBean.Hashing(user.getUserPassword()));
			userRegistrationBean.registerUser(user);

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));

			initNewUser();

		} catch (Exception e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));
		}

	}

	@PostConstruct
	public void initNewUser() {
		user = new User();
	}

}
