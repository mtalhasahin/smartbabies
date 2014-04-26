package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.ActivityCreatorBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Activity;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

@Path("/member/activity")
@Stateful
public class ActivityRESTService {

	@EJB
	ActivityCreatorBean activityCreatorBean;

	private Pregnancy pregnancy;

	@Inject
	private EntityManager entityManager;

	@GET
	@Path("/vaccine")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> vaccineActivities() {
		activityCreatorBean.initNewActivity();
		pregnancy.setPregnancyStartDate("26-04-2014");
		activityCreatorBean.creatActivity(pregnancy);
		return activityCreatorBean.getVaccineActivities();

	}

	@GET
	@Path("/vaccine/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> vaccineActivities(@PathParam("id") long id) {

		activityCreatorBean
				.creatActivity(entityManager
						.find(User.class, id)
						.getPregnancies()
						.get(entityManager.find(User.class, id)
								.getPregnancies().size() - 1));

		return activityCreatorBean.getVaccineActivities();
	}

	@GET
	@Path("/check/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> checkActivities(@PathParam("id") long id) {

		activityCreatorBean
				.creatActivity(entityManager
						.find(User.class, id)
						.getPregnancies()
						.get(entityManager.find(User.class, id)
								.getPregnancies().size() - 1));

		return activityCreatorBean.getCheckActivities();
	}

	@PostConstruct
	public void initNewPregnancy() {
		pregnancy = new Pregnancy();
	}

}
