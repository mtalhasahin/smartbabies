package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.SexualIntercourseCycle;

//yeni bir gebelik için istenilen doğum tarihine göre
//uygun cinsel birliktelik tarih aralığını hesaplar
@Stateless
public class SexualIntercourseCalculationBean {

	private DateCalculationBean dateCalculationBean;

	private SexualIntercourseCycle sexualIntercourseCycle;

	@Produces
	public SexualIntercourseCycle getSexualIntercourseCycle() {
		return sexualIntercourseCycle;
	}

	public void setSexualIntercourseCycle(
			SexualIntercourseCycle sexualIntercourseCycle) {
		this.sexualIntercourseCycle = sexualIntercourseCycle;
	}

	public void apropriateSexualIntercourseDate(MenstrualCycle menstrualCycle) {

		// anne adayının menstruasyon dönemine göre
		// uygun ovulasyon dönemini hesaplar
		sexualIntercourseCycle.setOvulationStartDate(dateCalculationBean
				.addingDaysToDate(menstrualCycle.getLastMenstruationDate(), 6));
		sexualIntercourseCycle
				.setOvulationEndDate(dateCalculationBean.addingDaysToDate(
						menstrualCycle.getNextMenstruationDate(), -3));

		// istenilen doğum tarihini ortalama gebelik süresine göre
		// ovulasyon tarihi ile karşılaştırma amaçlı geri bir tarihealır
		sexualIntercourseCycle
				.setCycleStartDate(dateCalculationBean.addingDaysToDate(
						sexualIntercourseCycle.getDesiredStartBornDate(), -270));
		sexualIntercourseCycle.setCycleEndDate(dateCalculationBean
				.addingDaysToDate(
						sexualIntercourseCycle.getDesiredEndBornDate(), -270));

		// istenilen doğum tarih aralıpını listeler
		ArrayList<String> desiredDateRange = new ArrayList<String>();

		for (int i = 0; i < dateCalculationBean.differenceBetweenTwoDates(
				sexualIntercourseCycle.getCycleEndDate(),
				sexualIntercourseCycle.getCycleStartDate()); i++) {
			desiredDateRange.add(dateCalculationBean.addingDaysToDate(
					sexualIntercourseCycle.getCycleStartDate(), i));
		}

		// anne adayının ovulasyon tarih aralığını listeler
		ArrayList<String> ovulationDateRange = new ArrayList<String>();

		for (int i = 0; i < dateCalculationBean.differenceBetweenTwoDates(
				sexualIntercourseCycle.getOvulationEndDate(),
				sexualIntercourseCycle.getOvulationStartDate()); i++) {
			ovulationDateRange.add(dateCalculationBean.addingDaysToDate(
					sexualIntercourseCycle.getOvulationStartDate(), i));
		}

		// anne adayının ovulasyon tarih aralığı ile
		// istenilen doğum tarih aralığının filtrelemesini tutar
		ArrayList<String> sexualIntercourseCycleList = new ArrayList<String>();

		do {

			sexualIntercourseCycleList.clear();

			// anne adayının ovulasyon tarih aralığı ile
			// istenilen doğum tarih aralığının filtrelemesini yapar
			for (int i = 0; i < desiredDateRange.size(); i++) {
				for (int j = 0; j < ovulationDateRange.size(); j++) {
					if (desiredDateRange.get(i).equals(
							ovulationDateRange.get(j))) {
						sexualIntercourseCycleList.add(ovulationDateRange
								.get(j));
					}
				}
			}

			// anne adayının ovulasyon tarih aralığı ile
			// istenilen doğum tarih aralığının listeler
			if (sexualIntercourseCycleList.size() != 0) {
				sexualIntercourseCycle
						.setCycleStartDate(sexualIntercourseCycleList.get(0));
				sexualIntercourseCycle
						.setCycleEndDate(sexualIntercourseCycleList
								.get(sexualIntercourseCycleList.size() - 1));
			}

			// anne adayının ovulasyon tarih aralığı ile
			// istenilen doğum tarih aralığının listesi boş ise
			// anne adayının ovulasyon tarihini ileri bir tarihe atar
			for (int i = 0; i < ovulationDateRange.size(); i++) {
				ovulationDateRange.set(
						i,
						dateCalculationBean.addingDaysToDate(
								ovulationDateRange.get(i),
								menstrualCycle.getAverageMenstruationPeriod()));
			}

		} while (sexualIntercourseCycleList.size() == 0);

	}

	@PostConstruct
	public void initNewSexualIntercourse() {
		sexualIntercourseCycle = new SexualIntercourseCycle();
		dateCalculationBean = new DateCalculationBean();
		// dateCalculationBean.initDateCalculate();
	}

}
