package com.ibm.smarterplanet.healtcare.smartbabies.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

@RequestScoped
public class UserListProducer {

	@Inject
	private EntityManager entityManager;

	private List<User> users;

	@Produces
	@Named
	public List<User> getUsers() {
		return users;
	}

	public void onUserListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final User user) {
		retrieveAllUsers();
	}

	@PostConstruct
	public void retrieveAllUsers() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder
				.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		criteriaQuery.select(user);
		users = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
