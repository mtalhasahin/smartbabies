package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;

public class HashingBeanTest {

	HashingBean hashingBean = new HashingBean();

	@Test
	public void hashingTest() {
		Assert.assertEquals("ab359e3fe67472070e2cd80ad9606ce7",
				hashingBean.Hashing("SmartBabies"));
	}

	@BeforeTest 
	public void setUp() throws Exception {
	}

	@AfterTest
	public void tearDown() throws Exception {
	}

}
