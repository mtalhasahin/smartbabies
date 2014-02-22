package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;

@Stateful
public class MenstrualCycleCalculationBean {

	private MenstrualCycle menstrualCycle;

	private DateCalculationBean dateCalculationBean;

	@Named
	@Produces
	public MenstrualCycle getMenstrualCycle() {
		return menstrualCycle;
	}

	public void setMenstrualCycle(MenstrualCycle menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}

	// olası bir sonraki menstruasyon ve doğal gecikmeli menstruasyon tarihini
	// hesaplar
	public void nextMenstruationDateCalculate() {

		// en son ve en sondan bir önceki menstruasyon gün farkını hesaplar
		int firstMenstruationsPeriodDifference = dateCalculationBean
				.differenceBetweenTwoDates(
						menstrualCycle.getPreviousMenstruation(),
						menstrualCycle.getTwoPreviousMenstruation());

		// en sondan bir önceki ve en sondan iki önceki menstruasyon gün farkını
		// hesaplar
		int secondMenstruationsPeriodDifference = dateCalculationBean
				.differenceBetweenTwoDates(
						menstrualCycle.getLastMenstruation(),
						menstrualCycle.getPreviousMenstruation());

		// en son 3 menstruasyon tarihine göre yaklaşık ortalama menstruasyon
		// periyod gününü hesaplar
		int averageMenstruationPeriod = (firstMenstruationsPeriodDifference + secondMenstruationsPeriodDifference) / 2;

		// ortalama menstruasyon period gününe göre bir sonraki yaklaşık
		// menstruasyon tarihini hesaplar
		menstrualCycle.setNextMenstruation(dateCalculationBean
				.addingDaystoDate(menstrualCycle.getLastMenstruation(),
						averageMenstruationPeriod));

		// ortalama menstruasyon period gününe göre bir sonraki yaklaşık ve
		// doğal gecikmeli menstruasyon tarihini hesaplar
		menstrualCycle.setMaxNextMenstruation(dateCalculationBean
				.addingDaystoDate(menstrualCycle.getLastMenstruation(), 35));

	}

	// olası ovulasyon ve gebelik tarihini hesaplar
	public void possiblePregnancyDateCalculate() {

		// ortalama menstruasyon period gününe göre normal ve olası en son
		// ovulasyon tarihini hesaplar
		menstrualCycle.setOvulation(dateCalculationBean.addingDaystoDate(
				menstrualCycle.getNextMenstruation(), -14));

		// normal olarak gerçekleşmeyen menstruasyon tarihine göre olası gebelik
		// gününü hesplar
		menstrualCycle.setPossiblePregnancyDate(dateCalculationBean
				.addingDaystoDate(menstrualCycle.getNextMenstruation(), -10));

	}

	@PostConstruct
	public void initMenstrualCycle() {
		menstrualCycle = new MenstrualCycle();
		dateCalculationBean = new DateCalculationBean();
		dateCalculationBean.initDateCalculate();

	}

}
