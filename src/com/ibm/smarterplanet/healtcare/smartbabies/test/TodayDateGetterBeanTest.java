package com.ibm.smarterplanet.healtcare.smartbabies.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.TodayDateGetterBean;

@SuppressWarnings({ "deprecation" })
public class TodayDateGetterBeanTest {

	TodayDateGetterBean todayDateGetterBean = new TodayDateGetterBean();

	@Before
	public void setUp() throws Exception {
		todayDateGetterBean.initNewTodayDate();
	}

	@After
	public void tearDown() throws Exception {
		todayDateGetterBean.initNewTodayDate();
	}

	@Test
	public void testTodayDate() {
		Assert.assertEquals("22-02-2014", todayDateGetterBean.getTodayDate());
	}

}
