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
		Assert.assertEquals("26-12-2013",
				dateCalculationBean.addingDaystoDate("25-01-2014", -30));
	}

	@Test
	public void testdifferenceBetweenTwoDates() {
		Assert.assertEquals(30, dateCalculationBean.differenceBetweenTwoDates(
				"25-01-2014", "26-12-2013"));
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
