package com.ibm.smarterplanet.healtcare.smartbabies.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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

// Son üç menstruasyon tarihine göre olası bir gebelik tarihi üzerinden gebelik takibi oluşturur

@RequestScoped
@ManagedBean(name = "PregnancyRegistrationByHoroscope")
public class PregnancyRegistrationByHoroscope {

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

	@Inject
	EntityManager entityManager;

	private TodayDateGetterBean todayDateGetterBean;

	private DateCalculationBean dateCalculationBean;

	private UserLoginLogout userLoginLogout;

	private SexualIntercourseCycle sexualIntercourseCycle;

	private Pregnancy pregnancy;

	private MenstrualCycle menstrualCycle;

	private User user;
	
	private int selectedHoroscope;

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

	public int getSelectedHoroscope() {
		return selectedHoroscope;
	}

	public void setSelectedHoroscope(int selectedHoroscope) {
		this.selectedHoroscope = selectedHoroscope;
	}

	// olası gebelik tarihi ve kullanıcı bilgilerine göre yeni gebelik kaydı
	// oluşturur
	public void registerPregnancy() {
		
		if(selectedHoroscope==1){			
			sexualIntercourseCycle.setDesiredStartBornDate("21-03-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("20-04-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));			
		}
		else if (selectedHoroscope==2) {
			sexualIntercourseCycle.setDesiredStartBornDate("21-04-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("20-05-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			
		}
		else if (selectedHoroscope==3) {
			sexualIntercourseCycle.setDesiredStartBornDate("21-05-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("21-06-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			
		}
		else if (selectedHoroscope==4) {
			sexualIntercourseCycle.setDesiredStartBornDate("22-06-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("22-07-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		else if (selectedHoroscope==5) {
			sexualIntercourseCycle.setDesiredStartBornDate("23-07-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("23-08-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		else if (selectedHoroscope==6) {
			sexualIntercourseCycle.setDesiredStartBornDate("24-08-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("23-09-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		else if (selectedHoroscope==7) {
			sexualIntercourseCycle.setDesiredStartBornDate("24-09-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("23-10-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		else if (selectedHoroscope==8) {
			sexualIntercourseCycle.setDesiredStartBornDate("24-10-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("22-11-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			
		}
		else if (selectedHoroscope==9) {
			sexualIntercourseCycle.setDesiredStartBornDate("23-11-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("21-12-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
		
		}
		else if (selectedHoroscope==10) {
			sexualIntercourseCycle.setDesiredStartBornDate("22-12-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("20-01-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		else if (selectedHoroscope==11) {
			sexualIntercourseCycle.setDesiredStartBornDate("21-01-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("19-02-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			
		}
		else{
			sexualIntercourseCycle.setDesiredStartBornDate("20-02-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
			sexualIntercourseCycle.setDesiredEndBornDate("20-03-"
					+ dateCalculationBean.addingYearToCurrentYear(
							todayDateGetterBean.getCurrentYear(), 1));
	
		}
		
		if (userLoginLogout.getCurrentUser().getPregnancies().size() > 0) {

			if (dateCalculationBean.differenceBetweenTwoDatesOnlyNegative(
					todayDateGetterBean.getTodayDate(),
					userLoginLogout
							.getCurrentUser()
							.getPregnancies()
							.get(userLoginLogout.getCurrentUser()
									.getPregnancies().size() - 1)
							.getPregnancyStartDate()) < (280 + 730)) {

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Not Registered!",
						"Registration unsuccessful"));
				
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Aktif gebelik kaydı var veya sağlıklı yeni bir gebelik için uygun zaman geçmemiş!",
						"Sağlıklı bir gebelik için yaptığınız son doğum üzerinden en az 2 yıl geçmiş olması gerekmektedir."));
				
				

			}

		}

		else {

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

				userUpdaterBean.updateUserDetail(user,
						userLoginLogout.getCurrentUser());

				pregnancy.setUser(userLoginLogout.getCurrentUser());

				pregnancyRegistrationBean.registerPregnancy(pregnancy);

				userLoginLogout.setCurrentUser(entityManager.find(User.class,
						userLoginLogout.getCurrentUser().getUserId()));

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Registered!",
						"Registration successful"));

				facesContext
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_INFO,
										"Sistem tarafından uygun görülen cinsel birliktelik tarihi: ",
										sexualIntercourseCycle
												.getCycleStartDate()
												+ " - "
												+ sexualIntercourseCycle
														.getCycleEndDate()));

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
