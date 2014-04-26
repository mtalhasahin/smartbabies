package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

@Stateless
public class UserUpdaterBean {

	@Inject
	private EntityManager entityManager;
	
	private User updatingUser;

	public User updateUserDetail(User newUser, User currentUser) {

		try {
			
			updatingUser=entityManager.find(User.class, currentUser.getUserId());
			
			updatingUser.setUserBirthday(newUser.getUserBirthday());
			updatingUser.setUserHeight(newUser.getUserHeight());
			updatingUser.setUserWeight(newUser.getUserWeight());
			
			entityManager.persist(updatingUser);
			return updatingUser;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostConstruct
	public void initNewUserDetail(){
		updatingUser = new User();
	}

}
