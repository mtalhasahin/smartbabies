package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.data.GeneralActivityListProducer;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Activity;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;

// sisteme belirli tüm activiteleri süzer ve belirlenen list lere atar

@Stateless
public class ActivityCreatorBean {

	@Inject
	private GeneralActivityListProducer generalActivtyListProducer;

	private DateCalculationBean dateCalculationBean;

	private TodayDateGetterBean todayDateGetterBean;

	// activtyType 0
	// aşılar
	private List<Activity> vaccineActivities;

	// activtyType 1
	// testler
	private List<Activity> testActivities;

	// activtyType 2
	// genel kontroller
	private List<Activity> checkActivities;

	@Produces
	public List<Activity> getVaccineActivities() {
		return vaccineActivities;
	}

	@Produces
	public List<Activity> getTestActivities() {
		return testActivities;
	}

	@Produces
	public List<Activity> getCheckActivities() {
		return checkActivities;
	}

	public void creatActivity(Pregnancy pregnancy) {

		String activityDate = "";

		for (int i = 0; i < generalActivtyListProducer.getActivities().size(); i++) {

			activityDate = dateCalculationBean.addingDaysToDate(
					pregnancy.getPregnancyStartDate(),
					generalActivtyListProducer.getActivities().get(i)
							.getActivityDate());

			if (dateCalculationBean.differenceBetweenTwoDatesOnlyNegative(
					activityDate, todayDateGetterBean.getTodayDate()) >= 0) {
				if (generalActivtyListProducer.getActivities().get(i)
						.getActivityType() == 0) {
					vaccineActivities.add(generalActivtyListProducer
							.getActivities().get(i));
				} else if (generalActivtyListProducer.getActivities().get(i)
						.getActivityType() == 1) {
					testActivities.add(generalActivtyListProducer
							.getActivities().get(i));
				} else {
					checkActivities.add(generalActivtyListProducer
							.getActivities().get(i));
				}
			}
		}

	}

	@PostConstruct
	public void initNewActivity() {
		todayDateGetterBean = new TodayDateGetterBean();
		todayDateGetterBean.initNewTodayDate();

		dateCalculationBean = new DateCalculationBean();
		dateCalculationBean.initDateCalculate();

		vaccineActivities = new ArrayList<Activity>();
		testActivities = new ArrayList<Activity>();
		checkActivities = new ArrayList<Activity>();
	}

}
