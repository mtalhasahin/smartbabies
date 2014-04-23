package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.ActivityCreatorBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Activity;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;

@Path("/member/activity")
@Stateful
public class ActivityRESTService {
	
	@EJB
	ActivityCreatorBean activityCreatorBean;
	
	private Pregnancy pregnancy;
	
	@GET
	@Path("/check")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> checkActivities(){
		activityCreatorBean.initNewActivity();
		pregnancy.setPregnancyStartDate("23-04-2014");
		activityCreatorBean.creatActivity(pregnancy);
		return activityCreatorBean.getCheckActivities();
	}
	
	@GET
	@Path("/vaccine")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> vaccineActivities(){
		activityCreatorBean.initNewActivity();
		pregnancy.setPregnancyStartDate("23-04-2014");
		activityCreatorBean.creatActivity(pregnancy);
		return activityCreatorBean.getVaccineActivities();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> testActivities(){
		activityCreatorBean.initNewActivity();
		pregnancy.setPregnancyStartDate("23-04-2014");
		activityCreatorBean.creatActivity(pregnancy);
		return activityCreatorBean.getTestActivities();
	}
	
	@PostConstruct
	public void initPregnancy(){
		pregnancy = new Pregnancy();
	}

}
