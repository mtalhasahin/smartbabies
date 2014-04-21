package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.annotations.Test;
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
		Assert.assertEquals("25-04-2014",
				menstrualCycle.getNextMenstruationDate());
		Assert.assertEquals("02-05-2014",
				menstrualCycle.getDelayedNextMenstruationDate());
		Assert.assertEquals(28, menstrualCycle.getAverageMenstruationPeriod());

	}

	@Test
	public void testPossiblePregnancyDateCalculator() {
		Assert.assertEquals("11-04-2014", menstrualCycle.getOvulationDate());
		Assert.assertEquals("15-04-2014",
				menstrualCycle.getPossiblePregnancyDate());

	}

	@BeforeTest
	public void setUp() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
		menstrualCycle.setLastMenstruationDate("28-03-2014");
		menstrualCycle.setPreviousMenstruationDate("28-02-2014");
		menstrualCycle.setTwoPreviousMenstruationDate("31-01-2014");
//		menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
//		menstrualCycleCalculationBean.nextMenstruationDateCalculate();
//		menstrualCycleCalculationBean.possiblePregnancyDateCalculate();
	}

	@AfterTest
	public void tearDown() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
	}

}
