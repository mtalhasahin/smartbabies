package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.data.UserListProducer;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

@Stateless
public class UserServiceBean {

	@Inject
	private UserListProducer userListProducer;

	public User findUser(User user) {
		for (int i = 0; i < userListProducer.getUsers().size(); i++) {
			if (userListProducer.getUsers().get(i).getUserEmail()
					.equals(user.getUserEmail())
					&& userListProducer.getUsers().get(i).getUserPassword()
							.equals(user.getUserPassword())) {
				return userListProducer.getUsers().get(i);
			}
		}
		return null;
	}

}
