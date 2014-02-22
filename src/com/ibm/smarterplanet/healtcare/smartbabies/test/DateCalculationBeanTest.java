package com.ibm.smarterplanet.healtcare.smartbabies.test;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.DateCalculationBean;

@SuppressWarnings({ "unused", "deprecation" })
public class DateCalculationBeanTest {

	DateCalculationBean dateCalculationBean = new DateCalculationBean();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		dateCalculationBean.initDateCalculate();
	}

	@Test
	public void testAddingDaysToDate() {
		Assert.assertEquals("01-03-2014",
				dateCalculationBean.addingDaystoDate("28-02-2014", 1));
	}

	@Test
	public void testdifferenceBetweenTwoDates() {
		Assert.assertEquals(3, dateCalculationBean.differenceBetweenTwoDates(
				"22-02-2014", "25-02-2014"));
	}

}
