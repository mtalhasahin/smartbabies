package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.DateCalculationBean;

public class DateCalculationBeanTest {

	DateCalculationBean dateCalculationBean = new DateCalculationBean();

	@Test
	public void testAddingDaysToDate() {
		Assert.assertEquals("02-01-2015",
				dateCalculationBean.addingDaysToDate("28-03-2014", 280));
	}

	@Test
	public void testAddingYearToCurrentYear() {
		Assert.assertEquals("2015",
				dateCalculationBean.addingYearToCurrentYear("2014", 3));
	}

	@Test
	public void testdifferenceBetweenTwoDates() {
		Assert.assertEquals(30, dateCalculationBean.differenceBetweenTwoDates(
				"28-04-2014", "18-04-2016"));
	}

	@Test
	public void testdifferenceBetweenTwoDatesOnlyNegative() {
		Assert.assertEquals(0, dateCalculationBean
				.differenceBetweenTwoDatesOnlyNegative("28-04-2014",
						"18-04-2016"));
	}

	@BeforeTest
	public void setUp() throws Exception {
		dateCalculationBean.initDateCalculate();
	}

	@AfterTest
	public void tearDown() throws Exception {
		dateCalculationBean.initDateCalculate();
	}

}
