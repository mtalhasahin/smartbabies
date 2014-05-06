package com.ibm.smarterplanet.healtcare.smartbabies.rest;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.ibm.smarterplanet.healtcare.smartbabies.controller.UserServiceBean;
import com.ibm.smarterplanet.healtcare.smartbabies.model.User;
import com.ibm.smarterplanet.healtcare.smartbabies.util.HashingBean;
import com.ibm.smarterplanet.healtcare.smartbabies.view.UserLoginLogout;

@Path("/member/session")
@Stateful
@SessionScoped
public class LoginLogutRESTService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	HashingBean hashingBean;
	
	@EJB
	UserServiceBean userServiceBean;

	private User user;

	private User currentUser;
	
	private UserLoginLogout userLoginLogout;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String login(@FormParam("userName") String userName, @FormParam("userPassword") String userPassword){
		
		user.setUserEmail(userName);
		user.setUserPassword(hashingBean.Hashing(userPassword));
		currentUser = userServiceBean.findUser(user); 		
		if (currentUser == null) {
			System.out.println("A");
			user=null;
			
			return "<meta http-equiv='refresh' content='0; url=http://192.168.2.50:10080/smartbabies_mobile/apps/services/preview/SmartBabies/common/1.0/default/login.html'/>";
		}
		else {
			System.out.println("B");
			userLoginLogout.setCurrentUser(currentUser);
			
			return "<meta http-equiv='refresh' content='0; url=http://192.168.2.50:10080/smartbabies_mobile/apps/services/preview/SmartBabies/common/1.0/default/menu.html'/>";
		}
		
	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String logout(@FormParam("userName") String userName){		
		currentUser = null;
		userLoginLogout.setCurrentUser(null);
		return "<meta http-equiv='refresh' content='0; url=http://192.168.2.50:10080/smartbabies_mobile/apps/services/preview/SmartBabies/common/1.0/default/index.html'/>";
	}
	
	@PostConstruct
	public void initNewUser(){
		user=new User();
		userLoginLogout = new UserLoginLogout();
		
	}
	

}
