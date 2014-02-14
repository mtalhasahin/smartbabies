package com.ibm.smarterplanet.healtcare.smartbabies.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private Date lastMenstruationDate;
	
	private char userDetailsIsDeleted;
	
	@OneToOne
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLastMenstruationDate() {
		return lastMenstruationDate;
	}

	public void setLastMenstruationDate(Date lastMenstruationDate) {
		this.lastMenstruationDate = lastMenstruationDate;
	}

	public char getUserDetailsIsDeleted() {
		return userDetailsIsDeleted;
	}

	public void setUserDetailsIsDeleted(char userDetailsIsDeleted) {
		this.userDetailsIsDeleted = userDetailsIsDeleted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
