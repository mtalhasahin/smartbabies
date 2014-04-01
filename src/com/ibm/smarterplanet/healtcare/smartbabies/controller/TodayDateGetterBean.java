package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

//Günün tarih bilgisini getirir

@Stateless
public class TodayDateGetterBean {

	private SimpleDateFormat simpleDateFormat;

	private String todayDate;

	@Produces
	public String getTodayDate() {
		return todayDate;
	}

	@PostConstruct
	public void initNewTodayDate() {
		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		todayDate = simpleDateFormat.format(new Date());
	}
}