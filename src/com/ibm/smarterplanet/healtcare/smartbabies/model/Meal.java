package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Meal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mealId;
	
	private String mealName;
	
	private double mealCalorie;
	
	private char mealIsDeleted;
	
	@OneToMany(mappedBy="meal")
	private List<MealMenu> mealMenus;

	public long getMealId() {
		return mealId;
	}

	public void setMealId(long mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getMealCalorie() {
		return mealCalorie;
	}

	public void setMealCalorie(double mealCalorie) {
		this.mealCalorie = mealCalorie;
	}

	public char getMealIsDeleted() {
		return mealIsDeleted;
	}

	public void setMealIsDeleted(char mealIsDeleted) {
		this.mealIsDeleted = mealIsDeleted;
	}

	public List<MealMenu> getMealMenus() {
		return mealMenus;
	}

	public void setMealMenus(List<MealMenu> mealMenus) {
		this.mealMenus = mealMenus;
	}	
	
}
