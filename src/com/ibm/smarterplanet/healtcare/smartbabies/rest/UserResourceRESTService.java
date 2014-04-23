package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Stateless
public class UserResourceRESTService {

	private List<User> users;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return users;
	}

	@PostConstruct
	public void initNewUser() {
		users = new ArrayList<User>();
		users.add(new User(0, "Batuhan", "CIKRIKCI"));

	}
}
