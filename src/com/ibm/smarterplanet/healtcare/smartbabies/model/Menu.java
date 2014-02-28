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
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long menuId;
	
	private String menuName;
	
	private char menuIsDeleted;
	
	private String menuRepast;
	
	@OneToMany(mappedBy="menu")
	private List<MealMenu> mealMenus;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public char getMenuIsDeleted() {
		return menuIsDeleted;
	}

	public void setMenuIsDeleted(char menuIsDeleted) {
		this.menuIsDeleted = menuIsDeleted;
	}

	public String getMenuRepast() {
		return menuRepast;
	}

	public void setMenuRepast(String menuRepast) {
		this.menuRepast = menuRepast;
	}

	public List<MealMenu> getMealMenus() {
		return mealMenus;
	}

	public void setMealMenus(List<MealMenu> mealMenus) {
		this.mealMenus = mealMenus;
	}
	

}
