package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.data.DoctorListProducer;
import com.ibm.smarterplanet.healtcare.smartbabies.data.UserListProducer;

//Timer durumuna göre çalışır, sistem kullanıcılarının doğum günlerini denetler

@Stateless
public class BirthdayScannerBean {

	@Inject
	private UserListProducer userListProducer;

	@Inject
	private DoctorListProducer doctorListProducer;

	@Inject
	private TodayDateGetterBean todayDateGetterBean;

	private List<String> mailedList;

	@Produces
	public List<String> getMailedList() {
		return mailedList;
	}

	// Sırası ile kullanıcıların ve doktorların doğum günleri ile günün tarihini
	// karşılaştırır ve bulunan kayıtların mail adreslerini bir list'e ekler

	public void scan() {
		for (int i = 0; i < userListProducer.getUsers().size(); i++) {
			if (userListProducer.getUsers().get(i).getUserBirthday()
					.equals(todayDateGetterBean.getTodayDate())) {
				mailedList.add(userListProducer.getUsers().get(i)
						.getUserEmail());
			}
		}

		for (int i = 0; i < doctorListProducer.getDoctors().size(); i++) {
			if (doctorListProducer.getDoctors().get(i).getDoctorDetail()
					.getDoctorBirthday()
					.equals(todayDateGetterBean.getTodayDate())) {
				mailedList.add(doctorListProducer.getDoctors().get(i)
						.getDoctorEmail());
			}
		}

	}

	@PostConstruct
	public void initNewMailedList() {
		mailedList = new ArrayList<String>();
	}

}
