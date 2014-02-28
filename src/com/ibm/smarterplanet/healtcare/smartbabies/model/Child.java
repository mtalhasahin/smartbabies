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
public class Child implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long childId;
	
	private String childName;
	
	private char chilGender;
	
	private String childBirthdate;
	
	@ManyToOne
	private Pregnancy pregnancy;

	public long getChildId() {
		return childId;
	}

	public String getChildName() {
		return childName;
	}

	public char getChilGender() {
		return chilGender;
	}

	public String getChildBirthdate() {
		return childBirthdate;
	}

	public Pregnancy getPregnancy() {
		return pregnancy;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public void setChilGender(char chilGender) {
		this.chilGender = chilGender;
	}

	public void setChildBirthdate(String childBirthdate) {
		this.childBirthdate = childBirthdate;
	}

	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}
		

}
