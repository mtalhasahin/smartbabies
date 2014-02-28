package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class MealMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mealMenuId;
	
	private char mealMenuIsDeleted;
	
	@ManyToOne
	private Meal meal;
	
	@ManyToOne
	private Menu menu;
	
	@OneToMany(mappedBy="mealMenu")
	private List<NutritionCalendar> nutritionCalendars;

	public long getMealMenuId() {
		return mealMenuId;
	}

	public void setMealMenuId(long mealMenuId) {
		this.mealMenuId = mealMenuId;
	}

	public char getMealMenuIsDeleted() {
		return mealMenuIsDeleted;
	}

	public void setMealMenuIsDeleted(char mealMenuIsDeleted) {
		this.mealMenuIsDeleted = mealMenuIsDeleted;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<NutritionCalendar> getNutritionCalendars() {
		return nutritionCalendars;
	}

	public void setNutritionCalendars(List<NutritionCalendar> nutritionCalendars) {
		this.nutritionCalendars = nutritionCalendars;
	}
	
	

}
