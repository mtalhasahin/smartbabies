package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

//Sistem için gerekli bazı tarih hesaplamalarını yapar

@Stateless
public class DateCalculationBean {

	private SimpleDateFormat simpleDateFormat;

	private SimpleDateFormat simpleYearFormat;

	private Date date;

	private Calendar calendar;

	private Calendar previousCalendar;

	private Calendar nextCalendar;

	// parametre olarak gelen (dd-MM-yyyy) formatındaki iki tarih arasındaki gün
	// farkını hesaplar ve bir tamsayı return eder(negatiflik durumu
	// çıkartılmış)

	public int differenceBetweenTwoDates(String nextDate, String previousDate) {

		try {
			previousCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(previousDate));
			nextCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(nextDate));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (nextCalendar.get(Calendar.DAY_OF_YEAR)
				- previousCalendar.get(Calendar.DAY_OF_YEAR) < 0) {
			return nextCalendar.get(Calendar.DAY_OF_YEAR)
					- previousCalendar.get(Calendar.DAY_OF_YEAR) + 365;
		}

		else {
			return nextCalendar.get(Calendar.DAY_OF_YEAR)
					- previousCalendar.get(Calendar.DAY_OF_YEAR);
		}

	}

	// parametre olarak gelen (dd-MM-yyyy) formatındaki iki tarih arasındaki gün
	// farkını hesaplar ve bir tamsayı return eder(negatiflik durumu dahil)

	public int differenceBetweenTwoDatesOnlyNegative(String nextDate,
			String previousDate) {

		try {
			previousCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(previousDate));
			nextCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(nextDate));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (nextCalendar.get(Calendar.YEAR)
				- previousCalendar.get(Calendar.YEAR) < 0) {

			return -1
					* (nextCalendar.get(Calendar.DAY_OF_YEAR)
							- previousCalendar.get(Calendar.DAY_OF_YEAR) - (365 * (nextCalendar
							.get(Calendar.YEAR) - previousCalendar
							.get(Calendar.YEAR))));

		}

		else {

			return (nextCalendar.get(Calendar.DAY_OF_YEAR)
					- previousCalendar.get(Calendar.DAY_OF_YEAR) + (365 * (nextCalendar
					.get(Calendar.YEAR) - previousCalendar.get(Calendar.YEAR))));

		}

	}

	// parametre olarak gelen (dd-MM-yyyy) farmatındaki tarihe, yine parametre
	// olarak gelen tamsayı kadar gün ekler ve yeni oluşan tarihi return eder

	public String addingDaysToDate(String startDate, int day) {
		try {
			calendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.DATE, day);
		date = calendar.getTime();
		return new String(simpleDateFormat.format(date));
	}

	// parametre olarak gelen (yyyy) farmatındaki tarihe, yine parametre
	// olarak gelen tamsayı kadar yıl ekler ve yeni oluşan tarihi return eder

	public String addingYearToCurrentYear(String currentYear, int year) {
		try {
			calendar.setTime(new SimpleDateFormat("yyyy").parse(currentYear));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.add(Calendar.YEAR, year);
		date = calendar.getTime();
		return new String(simpleYearFormat.format(date));
	}

	@PostConstruct
	public void initDateCalculate() {
		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		simpleYearFormat = new SimpleDateFormat("yyyy");
		date = new Date();
		calendar = Calendar.getInstance();

		previousCalendar = new GregorianCalendar();
		nextCalendar = new GregorianCalendar();
	}

}
