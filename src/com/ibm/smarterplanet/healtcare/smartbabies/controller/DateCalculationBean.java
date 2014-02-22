package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class DateCalculationBean {
	
	private SimpleDateFormat simpleDateFormat;
	
	private Date date;
	
	private Calendar calendar;
	
	private Calendar previousCalendar;
	
	private Calendar nextCalendar;

	public int differenceBetweenTwoDates(String previousDate, String nextDate) {
		
		try {
			previousCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(previousDate));
			nextCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(nextDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextCalendar.get(Calendar.DAY_OF_YEAR)-previousCalendar.get(Calendar.DAY_OF_YEAR);

	}

	public String addingDaystoDate(String startDate, int day) {
		try {
			calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.DATE, day);
		date = calendar.getTime();
		return new String(simpleDateFormat.format(date));
	}
	
	@PostConstruct
	public void initDateCalculate(){
		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date = new Date();
		calendar = Calendar.getInstance();
		
		previousCalendar = new GregorianCalendar();
		nextCalendar = new GregorianCalendar();
	}

}
