package com.ibm.smarterplanet.healtcare.smartbabies.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

	@Produces
	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();

	}

}
