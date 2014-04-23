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
	private GeneralActivityListProducer generalActivityListProducer;

	private DateCalculationBean dateCalculationBean;

	private TodayDateGetterBean todayDateGetterBean;

	// activityType 0
	// aşılar
	private List<Activity> vaccineActivities;

	// activityType 1
	// genel kontroller
	private List<Activity> checkActivities;

	@Produces
	public List<Activity> getVaccineActivities() {
		return vaccineActivities;
	}

	@Produces
	public List<Activity> getCheckActivities() {
		return checkActivities;
	}

	public void creatActivity(Pregnancy pregnancy) {

		String activityDate = "";

		vaccineActivities.clear();
		checkActivities.clear();

		for (int i = 0; i < generalActivityListProducer.getActivities().size(); i++) {

			activityDate = dateCalculationBean.addingDaysToDate(
					pregnancy.getPregnancyStartDate(),
					(generalActivityListProducer.getActivities().get(i)
							.getActivityDate() + 280));

			if (dateCalculationBean.differenceBetweenTwoDatesOnlyNegative(
					activityDate, todayDateGetterBean.getTodayDate()) >= 0) {

				if (generalActivityListProducer.getActivities().get(i)
						.getActivityType() == '0') {
					generalActivityListProducer.getActivities().get(i)
							.setActivityRealizationDate(activityDate);
					generalActivityListProducer
							.getActivities()
							.get(i)
							.setActivityDateDifference(
									dateCalculationBean
											.differenceBetweenTwoDatesOnlyNegative(
													activityDate,
													todayDateGetterBean
															.getTodayDate()));
					vaccineActivities.add(generalActivityListProducer
							.getActivities().get(i));
				}

				else {
					generalActivityListProducer.getActivities().get(i)
							.setActivityRealizationDate(activityDate);
					checkActivities.add(generalActivityListProducer
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
		checkActivities = new ArrayList<Activity>();
	}

}
