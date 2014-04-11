package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;

//Menstruasyon döngüsündeki bazı önemli günleri yaklaşık olarak hesaplar

@Stateless
public class MenstrualCycleCalculationBean {

	private MenstrualCycle menstrualCycle;

	@Inject
	private DateCalculationBean dateCalculationBean;	

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

		// en son ve en sondan bir önceki menstruasyon gün farkını tutar

		int firstMenstruationsPeriodDifference = dateCalculationBean
				.differenceBetweenTwoDates(
						menstrualCycle.getPreviousMenstruationDate(),
						menstrualCycle.getTwoPreviousMenstruationDate());

		// en sondan bir önceki ve en sondan iki önceki menstruasyon gün farkını
		// tutar

		int secondMenstruationsPeriodDifference = dateCalculationBean
				.differenceBetweenTwoDates(
						menstrualCycle.getLastMenstruationDate(),
						menstrualCycle.getPreviousMenstruationDate());

		// en son 3 menstruasyon tarihine göre yaklaşık ortalama menstruasyon
		// periyod gününü tutar

		int averageMenstruationPeriod = (firstMenstruationsPeriodDifference + secondMenstruationsPeriodDifference) / 2;

		// ortalama menstruasyon period gününe göre bir sonraki yaklaşık
		// menstruasyon tarihini hesaplar ve atamasını yapar

		menstrualCycle.setNextMenstruationDate(dateCalculationBean
				.addingDaystoDate(menstrualCycle.getLastMenstruationDate(),
						averageMenstruationPeriod));

		// ortalama menstruasyon period gününe göre bir sonraki yaklaşık ve
		// doğal gecikmeli menstruasyon tarihini hesaplar ve atamasını yapar

		menstrualCycle
				.setDelayedNextMenstruationDate(dateCalculationBean
						.addingDaystoDate(
								menstrualCycle.getLastMenstruationDate(), 35));

	}

	// olası ovulasyon ve gebelik tarihini hesaplar

	public void possiblePregnancyDateCalculate() {

		// ortalama menstruasyon period gününe göre normal ve olası en son
		// ovulasyon tarihini hesaplar ve atamasını yapar

		menstrualCycle.setOvulationDate(dateCalculationBean.addingDaystoDate(
				menstrualCycle.getNextMenstruationDate(), -14));

		// normal olarak gerçekleşmeyen menstruasyon tarihine göre olası gebelik
		// gününü hesplar ve atamasını yapar

		menstrualCycle
				.setPossiblePregnancyDate(dateCalculationBean.addingDaystoDate(
						menstrualCycle.getNextMenstruationDate(), -10));

	}

	@PostConstruct
	public void initMenstrualCycle() {
		menstrualCycle = new MenstrualCycle();

	}

}
