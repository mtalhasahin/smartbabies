package com.ibm.smarterplanet.healtcare.smartbabies.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserServiceBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;

@SessionScoped
@ManagedBean(name = "UserLoginLogout", eager = true)
public class UserLoginLogout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	private User currentUser;

	@EJB
	UserServiceBean userServiceBean;

	@EJB
	HashingBean hashingBean;

	@Produces
	public User getCurrentUser() {
		return currentUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		user.setUserPassword(hashingBean.Hashing(user.getUserPassword()));
		currentUser = userServiceBean.findUser(user);

		if (currentUser == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Unknown login, try again"));
			user = null;
			return "login/index.xhtml?faces-redirect=true";
		} else {
			return "member/profile/index.xhtml?faces-redirect=true";
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void initNewCurrentUser() {
		user = new User();
		currentUser = new User();
	}

}
