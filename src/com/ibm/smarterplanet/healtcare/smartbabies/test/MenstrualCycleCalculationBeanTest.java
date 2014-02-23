package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.MenstrualCycleCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;

public class MenstrualCycleCalculationBeanTest {

	MenstrualCycle menstrualCycle = new MenstrualCycle();
	MenstrualCycleCalculationBean menstrualCycleCalculationBean = new MenstrualCycleCalculationBean();

	@Test
	public void testNextMenstruationDateCalculator() {
		AssertJUnit.assertEquals("23-03-2014",
				menstrualCycle.getNextMenstruation());
		AssertJUnit.assertEquals("29-03-2014",
				menstrualCycle.getMaxNextMenstruation());

	}

	@Test
	public void testPossiblePregnancyDateCalculator() {
		Assert.assertEquals("09-03-2014", menstrualCycle.getOvulation());
		Assert.assertEquals("13-03-2014",
				menstrualCycle.getPossiblePregnancyDate());

	}

	@BeforeTest
	public void setUp() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
		menstrualCycle.setLastMenstruation("22-02-2014");
		menstrualCycle.setPreviousMenstruation("25-01-2014");
		menstrualCycle.setTwoPreviousMenstruation("26-12-2013");
		menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
		menstrualCycleCalculationBean.nextMenstruationDateCalculate();
		menstrualCycleCalculationBean.possiblePregnancyDateCalculate();
	}

	@AfterTest
	public void tearDown() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
	}

}
