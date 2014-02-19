package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.data.DoctorListProducer;
import com.ibm.smarterplanet.healtcare.smartbabies.data.UserListProducer;

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

	public void scan() {
		for (int i = 0; i < userListProducer.getUsers().size(); i++) {
			if (userListProducer.getUsers().get(i).getBirthday()
					.equals(todayDateGetterBean.getTodayDate())) {
				mailedList.add(userListProducer.getUsers().get(i).getEmail());
			}
		}

		for (int i = 0; i < doctorListProducer.getDoctors().size(); i++) {
			if (doctorListProducer.getDoctors().get(i).getBirthday()
					.equals(todayDateGetterBean.getTodayDate())) {
				mailedList.add(doctorListProducer.getDoctors().get(i).getEmail());
			}
		}

	}

	@PostConstruct
	public void initNewMailedList() {
		mailedList = new ArrayList<String>();
	}

}
