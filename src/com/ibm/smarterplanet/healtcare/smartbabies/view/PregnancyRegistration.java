package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.MenstrualCycleCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.PregnancyRegistrationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

//Son üç menstruasyon tarihine göre olası bir gebelik tarihi üzerinden, bir gebelik oluşturur

@SessionScoped
@ManagedBean(name = "PregnancyRegistration")
public class PregnancyRegistration {

	@Inject
	private FacesContext facesContext;

	@EJB
	PregnancyRegistrationBean pregnancyRegistrationBean;

	@EJB
	MenstrualCycleCalculationBean menstrualCycleCalculationBean;

	private Pregnancy pregnancy;

	private MenstrualCycle menstrualCycle;

	private User user;

	public Pregnancy getPregnancy() {
		return pregnancy;
	}

	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}

	public MenstrualCycle getMenstrualCycle() {
		return menstrualCycle;
	}

	public void setMenstrualCycle(MenstrualCycle menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Kullanıcıdan alınan son üç menstruasyon tarihine göre olası gebelik
	// başlangıç tarihini hesaplatır
	public void calculateMenstrualCycle() {

		try {

			menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
			menstrualCycleCalculationBean.nextMenstruationDateCalculate();
			menstrualCycleCalculationBean.possiblePregnancyDateCalculate();
			menstrualCycle = menstrualCycleCalculationBean.getMenstrualCycle();

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Calculated!",
					"Calculation successful"));

		} catch (Exception e) {

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Calculated!",
					"Calculation unsuccessful"));

		}

	}

	// olasık gebelik tarihi ve kullanıcı bilgilerine göre yeni gebelik kaydı
	// oluşturur
	// bu kaydın geçerli olması doktor muayenesine bağlıdır
	public void registerPregnancy() {

		try {

			pregnancy.setUser(user);
			pregnancy.setPregnancyStartDate(menstrualCycleCalculationBean
					.getMenstrualCycle().getPossiblePregnancyDate());

			pregnancyRegistrationBean.registerPregnancy(pregnancy);

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
					"Registration successful"));

			initNewPregnancy();

		} catch (Exception e) {

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));

		}
	}

	@PostConstruct
	public void initNewPregnancy() {
		menstrualCycle = new MenstrualCycle();
		pregnancy = new Pregnancy();
		user = new User();

	}

}
