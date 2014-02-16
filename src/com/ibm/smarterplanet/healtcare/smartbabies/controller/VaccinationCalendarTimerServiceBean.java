package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class VaccinationCalendarTimerServiceBean {
	
	@Schedule(hour="3,5",month="*",year="*",dayOfMonth="*")
	public void checkBirthday(){
		
	}

}
