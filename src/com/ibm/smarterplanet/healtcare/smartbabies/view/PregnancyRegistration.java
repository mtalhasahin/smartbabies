package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.DateCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.MenstrualCycleCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.PregnancyRegistrationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.SexualIntercourseCalculationBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.TodayDateGetterBean;
import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserUpdaterBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.MenstrualCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.Pregnancy;
import com.ibm.smarterplanet.healtcare.smartbabies.model.SexualIntercourseCycle;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;

// Son üç menstruasyon tarihine göre olası bir gebelik tarihi üzerinden, bir gebelik takibi oluşturur

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

	@EJB
	UserUpdaterBean userUpdaterBean;

	private TodayDateGetterBean todayDateGetterBean;

	private DateCalculationBean dateCalculationBean;

	private UserLoginLogout userLoginLogout;

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

	public SexualIntercourseCycle getSexualIntercourseCycle() {
		return sexualIntercourseCycle;
	}

	public void setSexualIntercourseCycle(
			SexualIntercourseCycle sexualIntercourseCycle) {
		this.sexualIntercourseCycle = sexualIntercourseCycle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// olası gebelik tarihi ve kullanıcı bilgilerine göre yeni gebelik kaydı
	// oluşturur
	public void registerPregnancy() {
		if (userLoginLogout.getCurrentUser().getPregnancies().size() != 0
				&& dateCalculationBean.differenceBetweenTwoDates(
						todayDateGetterBean.getTodayDate(),
						userLoginLogout
								.getCurrentUser()
								.getPregnancies()
								.get(userLoginLogout.getCurrentUser()
										.getPregnancies().size() - 1)
								.getPregnancyStartDate()) < (280 + 90)) {
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Not Registered!",
					"Registration unsuccessful"));

		} else {

			try {

				menstrualCycleCalculationBean.setMenstrualCycle(menstrualCycle);
				menstrualCycleCalculationBean.nextMenstruationDateCalculate();
				menstrualCycle = menstrualCycleCalculationBean
						.getMenstrualCycle();

				pregnancy
						.setPregnancyStartDate(sexualIntercourseCalculationBean
								.apropriateSexualIntercourseDate(
										menstrualCycle, sexualIntercourseCycle)
								.getCycleEndDate());
				pregnancy.setUser(userUpdaterBean.updateUserDetail(user,
						userLoginLogout.getCurrentUser()));
				pregnancyRegistrationBean.registerPregnancy(pregnancy);
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Registered!",
						"Registration successful"));

				initNewPregnancy();

			} catch (Exception e) {

				e.printStackTrace();

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Not Registered!",
						"Registration unsuccessful"));

			}
		}

	}

	@PostConstruct
	public void initNewPregnancy() {
		menstrualCycle = new MenstrualCycle();
		sexualIntercourseCycle = new SexualIntercourseCycle();

		pregnancy = new Pregnancy();
		userLoginLogout = new UserLoginLogout();

		user = new User();

		dateCalculationBean = new DateCalculationBean();
		dateCalculationBean.initDateCalculate();

		todayDateGetterBean = new TodayDateGetterBean();
		todayDateGetterBean.initNewTodayDate();

	}

}
