package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.view.UserLoginLogout;

@Path("/member/session")
@Stateful
@SessionScoped
public class LoginLogutRESTService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private UserLoginLogout userLoginLogout;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("userName") String userName, @FormParam("userPassword") String userPassword){
		
		
		System.out.println(userName);
		System.out.println(userPassword);
		
		return "<meta http-equiv='refresh' content='0; url=http://192.168.2.50:10080/smartbabies_mobile/apps/services/preview/SmartBabies/common/1.0/default/menu.html'/>";
	}
	
	@PostConstruct
	public void initNewUser(){
		user=new User();
		userLoginLogout = new UserLoginLogout();
		
	}
	

}
