package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

//EJB Timer Services
//Her gün saat 3 - 5 aralığında çalışır ve doğum günlerini denetlemesi için durumsuz bir nesne çağırır

@Singleton
public class BirthdayTimerServiceBean {

	@Inject
	private BirthdayScannerBean birthdayScannerBean;

	@Schedule(hour = "3,5", month = "*", year = "*", dayOfMonth = "*")
	public void checkBirthday() {
		birthdayScannerBean.scan();

	}

}
