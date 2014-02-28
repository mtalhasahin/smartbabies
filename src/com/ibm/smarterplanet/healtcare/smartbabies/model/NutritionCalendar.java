package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class NutritionCalendar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long nutritionCalendarId;
		
	private char nutritionIsDeleted;
	
	@ManyToOne
	private Pregnancy pregnancy;
	
	@ManyToOne
	private MealMenu mealMenu;

	public long getNutritionCalendarId() {
		return nutritionCalendarId;
	}

	public char getNutritionIsDeleted() {
		return nutritionIsDeleted;
	}

	public Pregnancy getPregnancy() {
		return pregnancy;
	}

	public MealMenu getMealMenu() {
		return mealMenu;
	}

	public void setNutritionCalendarId(long nutritionCalendarId) {
		this.nutritionCalendarId = nutritionCalendarId;
	}

	public void setNutritionIsDeleted(char nutritionIsDeleted) {
		this.nutritionIsDeleted = nutritionIsDeleted;
	}

	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}

	public void setMealMenu(MealMenu mealMenu) {
		this.mealMenu = mealMenu;
	}
	
	
}
