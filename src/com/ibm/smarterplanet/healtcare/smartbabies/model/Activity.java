package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long activityId;

	private String activityName;

	private int activityDate;

	private char activityIsChild;

	private char activityType;

	private String activityRealizationDate;
	
	private int activityDateDifference;

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(int activityDate) {
		this.activityDate = activityDate;
	}

	public char getActivityIsChild() {
		return activityIsChild;
	}

	public void setActivityIsChild(char activityIsChild) {
		this.activityIsChild = activityIsChild;
	}

	public char getActivityType() {
		return activityType;
	}

	public void setActivityType(char activityType) {
		this.activityType = activityType;
	}

	public String getActivityRealizationDate() {
		return activityRealizationDate;
	}

	public void setActivityRealizationDate(String activityRealizationDate) {
		this.activityRealizationDate = activityRealizationDate;
	}

	public int getActivityDateDifference() {
		return activityDateDifference;
	}

	public void setActivityDateDifference(int activityDateDifference) {
		this.activityDateDifference = activityDateDifference;
	}

}
