package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.DoctorRegistrationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.HashingBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Doctor;

//Yeni bir doktor hesabı oluşturur.
//Kullanıcı şifresini hashing işlemine tabii tutup, ilgili kaydı gerçekleştirecek EJB ye iletir.

@RequestScoped
@ManagedBean(name = "DoctorRegistration")
public class DoctorRegistration {

	@Inject
	private FacesContext facesContext;

	@EJB
	DoctorRegistrationBean doctorRegistrationBean;

	@EJB
	HashingBean hashingBean;

	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void registerDoctor() {

		try {

			doctor.setDoctorPassword(hashingBean.Hashing(doctor
					.getDoctorPassword()));
			doctorRegistrationBean.registerDoctor(doctor);

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));

		} catch (Exception e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));
		}
	}

	@PostConstruct
	public void initNewDoctor() {
		doctor = new Doctor();
	}

}
