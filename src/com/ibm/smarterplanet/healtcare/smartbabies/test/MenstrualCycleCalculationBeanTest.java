package com.ibm.smarterplanet.healtcare.smartbabies.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.DateCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.MenstrualCycleCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;

@SuppressWarnings({ "unused", "deprecation" })
public class MenstrualCycleCalculationBeanTest {

	MenstrualCycle menstrualCycle = new MenstrualCycle();
	MenstrualCycleCalculationBean menstrualCycleCalculationBean = new MenstrualCycleCalculationBean();

	@Before
	public void setUp() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
		menstrualCycle.setLastMenstruation("22-02-2014");
		menstrualCycle.setPreviousMenstruation("25-01-2014");
		menstrualCycle.setTwoPreviousMenstruation("26-12-2013");
		menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
		menstrualCycleCalculationBean.nextMenstruationDateCalculate();
		menstrualCycleCalculationBean.possiblePregnancyDateCalculate();
	}

	@After
	public void tearDown() throws Exception {
		menstrualCycleCalculationBean.initMenstrualCycle();
	}

	@Test
	public void testNextMenstruationDateCalculator() {
		Assert.assertEquals("23-03-2014", menstrualCycle.getNextMenstruation());
		Assert.assertEquals("29-03-2014",
				menstrualCycle.getMaxNextMenstruation());

	}

	@Test
	public void testPossiblePregnancyDateCalculator() {
		Assert.assertEquals("09-03-2014", menstrualCycle.getOvulation());
		Assert.assertEquals("13-03-2014",
				menstrualCycle.getPossiblePregnancyDate());

	}

}
