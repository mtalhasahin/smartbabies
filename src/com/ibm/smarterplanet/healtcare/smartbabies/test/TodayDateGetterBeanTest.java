package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.TodayDateGetterBean;

public class TodayDateGetterBeanTest {

	TodayDateGetterBean todayDateGetterBean = new TodayDateGetterBean();

	@Test
	public void testTodayDate() {
		Assert.assertEquals("23-02-2014", todayDateGetterBean.getTodayDate());
	}

	@BeforeTest
	public void setUp() throws Exception {
		todayDateGetterBean.initNewTodayDate();
	}

	@AfterTest
	public void tearDown() throws Exception {
		todayDateGetterBean.initNewTodayDate();
	}

}
