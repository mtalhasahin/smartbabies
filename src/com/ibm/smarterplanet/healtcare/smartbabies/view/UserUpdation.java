package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserUpdaterBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;

@RequestScoped
@ManagedBean(name = "UserUpdation")
public class UserUpdation {

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@EJB
	UserUpdaterBean userUpdaterBean;

	@EJB
	HashingBean hashingBean;

	private String newPassword;

	private String newPasswordRepeat;

	private User editedUser;

	private UserLoginLogout userLoginLogout;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRepeat() {
		return newPasswordRepeat;
	}

	public void setNewPasswordRepeat(String newPasswordRepeat) {
		this.newPasswordRepeat = newPasswordRepeat;
	}

	public User getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(User editedUser) {
		this.editedUser = editedUser;
	}

	public void editUser() {

		try {
			userUpdaterBean.updateUserDetail(editedUser,
					userLoginLogout.getCurrentUser());

			userLoginLogout.setCurrentUser(entityManager.find(User.class,
					userLoginLogout.getCurrentUser().getUserId()));

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Updated!",
					"Updation successful"));
		} catch (Exception e) {
			e.printStackTrace();

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Updated!",
					"Updation unsuccessful"));
		}

	}

	public void updatePassword() {

		if (hashingBean.Hashing(editedUser.getUserPassword()).equals(
				userLoginLogout.getCurrentUser().getUserPassword())) {
			if (newPassword.equals(newPasswordRepeat)) {

				editedUser.setUserPassword(newPassword);

				userUpdaterBean.updateUserDetail(editedUser,
						userLoginLogout.getCurrentUser());

				userLoginLogout.setCurrentUser(entityManager.find(User.class,
						userLoginLogout.getCurrentUser().getUserId()));

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Updated!",
						"Updation successful"));
			} else {
				// uyuşmayan yeni şifre
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Not Updated!",
						"Updation unsuccessful"));
			}

		} else {

			// ynlış şifre
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Updated!",
					"Updation unsuccessful"));
		}

	}

	@PostConstruct
	public void initNewEditedUser() {

	}

}
