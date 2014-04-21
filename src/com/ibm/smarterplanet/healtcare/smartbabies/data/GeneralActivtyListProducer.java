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

import com.ibm.smarterplanet.healtcare.smartbabies.model.Activity;

//sisteme önceden kayıtlı tüm aktiviteleri(aşı,test,kontrol) getirir ve bir list e atar

@RequestScoped
public class GeneralActivtyListProducer {

	@Inject
	private EntityManager entityManager;

	private List<Activity> activities;

	@Produces
	@Named
	public List<Activity> getActivities() {
		return activities;
	}

	public void onActivityListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Activity activity) {
		retrieveAllActivities();
	}

	@PostConstruct
	public void retrieveAllActivities() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Activity> criteriaQuery = criteriaBuilder
				.createQuery(Activity.class);
		Root<Activity> activity = criteriaQuery.from(Activity.class);
		criteriaQuery.select(activity);
		activities = entityManager.createQuery(criteriaQuery).getResultList();
	}

}
