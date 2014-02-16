package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	public final long id;
	public final String name;
	public final String surname;
	public final String email;
	public final String phone;

	public User(long id, String name, String surname, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

}
