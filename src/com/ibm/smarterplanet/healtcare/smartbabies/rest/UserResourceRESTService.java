package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Stateless
public class UserResourceRESTService {
	
	private static List<User> testRESTList = new ArrayList<User>();
	static{
		testRESTList.add(new User(0, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
		testRESTList.add(new User(1, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
		testRESTList.add(new User(2, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
		testRESTList.add(new User(3, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
		testRESTList.add(new User(4, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
		testRESTList.add(new User(5, "Batuhan", "CIKRIKCI", "batuhancikrikci@gmail.com", "5442448064"));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getList() {
		return testRESTList;
	}	

}
