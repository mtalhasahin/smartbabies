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

	private String activityDate;

	private char activityIsChild;

	private char activityType;

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

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
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

}
