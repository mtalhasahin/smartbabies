package com.ibm.smarterplanet.healtcare.smartbabies.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.SexualIntercourseCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.SexualIntercourseCycle;

public class SexualIntercourseCalculationBeanTest {

	MenstrualCycle menstrualCycle = new MenstrualCycle();
	SexualIntercourseCycle sexualIntercourseCycle = new SexualIntercourseCycle();
	SexualIntercourseCalculationBean sexualIntercourseCalculationBean = new SexualIntercourseCalculationBean();

	@Test
	public void sexualIntercourseCalculationTest() {

		sexualIntercourseCycle.setDesiredStartBornDate("05-01-2017");
		sexualIntercourseCycle.setDesiredEndBornDate("05-02-2017");

//		sexualIntercourseCalculationBean
//				.setSexualIntercourseCycle(sexualIntercourseCycle);
//
//		sexualIntercourseCalculationBean
//				.apropriateSexualIntercourseDate(menstrualCycle);
//
//		Assert.assertEquals("10-04-2016", sexualIntercourseCalculationBean
//				.getSexualIntercourseCycle().getCycleStartDate());
//		Assert.assertEquals("18-04-2016", sexualIntercourseCalculationBean
//				.getSexualIntercourseCycle().getCycleEndDate());

	}

	@BeforeTest
	public void setUp() throws Exception {
		sexualIntercourseCalculationBean.initNewSexualIntercourse();
		menstrualCycle.setLastMenstruationDate("28-03-2014");
		menstrualCycle.setPreviousMenstruationDate("28-02-2014");
		menstrualCycle.setTwoPreviousMenstruationDate("31-01-2014");
		menstrualCycle.setAverageMenstruationPeriod(28);
		menstrualCycle.setDelayedNextMenstruationDate("02-05-2014");
		menstrualCycle.setNextMenstruationDate("25-04-2014");
		menstrualCycle.setOvulationDate("11-04-2014");
		menstrualCycle.setPossiblePregnancyDate("15-04-2014");
	}

	@AfterTest
	public void tearDown() throws Exception {
		sexualIntercourseCalculationBean.initNewSexualIntercourse();

	}

}
