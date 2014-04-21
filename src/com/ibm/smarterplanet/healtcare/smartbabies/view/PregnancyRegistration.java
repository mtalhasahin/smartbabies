package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.MenstrualCycleCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.PregnancyRegistrationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.SexualIntercourseCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;
import com.ibm.smarterplanet.healtcare.smartbabies.model.SexualIntercourseCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

//Son üç menstruasyon tarihine göre olası bir gebelik tarihi üzerinden, bir gebelik oluşturur

@RequestScoped
@ManagedBean(name = "PregnancyRegistration")
public class PregnancyRegistration {

	@Inject
	private FacesContext facesContext;

	@EJB
	PregnancyRegistrationBean pregnancyRegistrationBean;

	@EJB
	MenstrualCycleCalculationBean menstrualCycleCalculationBean;

	@EJB
	SexualIntercourseCalculationBean sexualIntercourseCalculationBean;

	private SexualIntercourseCycle sexualIntercourseCycle;

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

	public SexualIntercourseCycle getSexualIntercourseCycle() {
		return sexualIntercourseCycle;
	}

	public void setSexualIntercourseCycle(
			SexualIntercourseCycle sexualIntercourseCycle) {
		this.sexualIntercourseCycle = sexualIntercourseCycle;
	}

	// olası gebelik tarihi ve kullanıcı bilgilerine göre yeni gebelik kaydı
	// oluşturur
	public void registerPregnancy() {
		try {

			menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
			menstrualCycleCalculationBean.nextMenstruationDateCalculate();
			menstrualCycle = menstrualCycleCalculationBean.getMenstrualCycle();

			pregnancy.setPregnancyStartDate(sexualIntercourseCalculationBean.apropriateSexualIntercourseDate(menstrualCycle, sexualIntercourseCycle).getCycleEndDate());
			pregnancy.setUser(user);

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
		sexualIntercourseCycle = new SexualIntercourseCycle();
		pregnancy = new Pregnancy();
		user = new User();

	}

}
