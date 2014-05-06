package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

//Günün tarih bilgisini ve yılını getirir

@Stateless
public class TodayDateGetterBean {

	private SimpleDateFormat simpleDateFormat;
	
	private SimpleDateFormat simpleYearFormat;

	private String todayDate;
	
	private String currentYear;

	@Produces
	public String getTodayDate() {
		return todayDate;
	}
	
	@Produces
	public String getCurrentYear() {
		return currentYear;
	}

	@PostConstruct
	public void initNewTodayDate() {
		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		todayDate = simpleDateFormat.format(new Date());
		
		simpleYearFormat = new SimpleDateFormat("yyyy");
		currentYear = simpleYearFormat.format(new Date());
	}

	
}
