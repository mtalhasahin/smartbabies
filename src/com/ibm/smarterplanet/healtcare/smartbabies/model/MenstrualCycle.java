package com.ibm.smarterplanet.healtcare.smartbabies.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MenstrualCycle {

	private String lastMenstruationDate;
	
	private String previousMenstruationDate;
	
	private String twoPreviousMenstruationDate;
	
	private String nextMenstruationDate;
	
	private String delayedNextMenstruationDate;
	
	private String ovulationDate;
	
	private String possiblePregnancyDate;

	public String getLastMenstruationDate() {
		return lastMenstruationDate;
	}

	public void setLastMenstruationDate(String lastMenstruationDate) {
		this.lastMenstruationDate = lastMenstruationDate;
	}

	public String getPreviousMenstruationDate() {
		return previousMenstruationDate;
	}

	public void setPreviousMenstruationDate(String previousMenstruationDate) {
		this.previousMenstruationDate = previousMenstruationDate;
	}

	public String getTwoPreviousMenstruationDate() {
		return twoPreviousMenstruationDate;
	}

	public void setTwoPreviousMenstruationDate(String twoPreviousMenstruationDate) {
		this.twoPreviousMenstruationDate = twoPreviousMenstruationDate;
	}

	public String getNextMenstruationDate() {
		return nextMenstruationDate;
	}

	public void setNextMenstruationDate(String nextMenstruationDate) {
		this.nextMenstruationDate = nextMenstruationDate;
	}

	public String getDelayedNextMenstruationDate() {
		return delayedNextMenstruationDate;
	}

	public void setDelayedNextMenstruationDate(String delayedNextMenstruationDate) {
		this.delayedNextMenstruationDate = delayedNextMenstruationDate;
	}

	public String getOvulationDate() {
		return ovulationDate;
	}

	public void setOvulationDate(String ovulationDate) {
		this.ovulationDate = ovulationDate;
	}

	public String getPossiblePregnancyDate() {
		return possiblePregnancyDate;
	}

	public void setPossiblePregnancyDate(String possiblePregnancyDate) {
		this.possiblePregnancyDate = possiblePregnancyDate;
	}

}
