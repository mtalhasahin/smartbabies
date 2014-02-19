package com.ibm.smarterplanet.healtcare.smartbabies.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.TodayDateGetterBean;

public class TodayDateGetterBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		TodayDateGetterBean todayDateGetterBean = new TodayDateGetterBean();
		todayDateGetterBean.initNewTodayDate();
		Assert.assertEquals("19-02-2014", todayDateGetterBean.getTodayDate());
	}	

}
