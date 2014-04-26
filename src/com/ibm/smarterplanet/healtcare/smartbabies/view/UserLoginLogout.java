package com.ibm.smarterplanet.healtcare.smartbabies.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserServiceBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;

@SessionScoped
@ManagedBean(name = "UserLoginLogout")
public class UserLoginLogout implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	@Produces
	private static User currentUser;

	@EJB
	UserServiceBean userServiceBean;

	@EJB
	HashingBean hashingBean;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		UserLoginLogout.currentUser = currentUser;
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
			return "/login/index.xhtml?faces-redirect=true";
		} else {
			return "/member/profile/index.xhtml?faces-redirect=true";
		}
	}

	public String logout() {
		currentUser = null;
		return "index.xhtml?faces-redirect=true";
	}

	@PostConstruct
	public void initNewCurrentUser() {
		user = new User();
		currentUser = new User();
	}

}
