package com.ibm.smarterplanet.healtcare.smartbabies.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MenstrualCycle {
	
	private String lastMenstruation;
	
	private String previousMenstruation;
	
	private String twoPreviousMenstruation;
	
	private String nextMenstruation;
	
	private String maxNextMenstruation;
	
	private String ovulation;
	
	private String possiblePregnancyDate;

	public String getLastMenstruation() {
		return lastMenstruation;
	}

	public void setLastMenstruation(String lastMenstruation) {
		this.lastMenstruation = lastMenstruation;
	}

	public String getPreviousMenstruation() {
		return previousMenstruation;
	}

	public void setPreviousMenstruation(String previousMenstruation) {
		this.previousMenstruation = previousMenstruation;
	}

	public String getTwoPreviousMenstruation() {
		return twoPreviousMenstruation;
	}

	public void setTwoPreviousMenstruation(String twoPreviousMenstruation) {
		this.twoPreviousMenstruation = twoPreviousMenstruation;
	}

	public String getNextMenstruation() {
		return nextMenstruation;
	}

	public void setNextMenstruation(String nextMenstruation) {
		this.nextMenstruation = nextMenstruation;
	}

	public String getMaxNextMenstruation() {
		return maxNextMenstruation;
	}

	public void setMaxNextMenstruation(String maxNextMenstruation) {
		this.maxNextMenstruation = maxNextMenstruation;
	}

	public String getOvulation() {
		return ovulation;
	}

	public void setOvulation(String ovulation) {
		this.ovulation = ovulation;
	}

	public String getPossiblePregnancyDate() {
		return possiblePregnancyDate;
	}

	public void setPossiblePregnancyDate(String possiblePregnancyDate) {
		this.possiblePregnancyDate = possiblePregnancyDate;
	}

}
