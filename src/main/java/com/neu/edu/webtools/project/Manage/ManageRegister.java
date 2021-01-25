package com.neu.edu.webtools.project.Manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.neu.edu.webtools.project.backend.dao.UserDAO;
import com.neu.edu.webtools.project.backend.dto.Location;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;
import com.neu.edu.webtools.project.backend.dto.User;
import com.neu.edu.webtools.project.register.ModelRegister;

@Component
public class ManageRegister {


	
	
 @Autowired
 private UserDAO userDAO;
 
 public ModelRegister init() { 
  return new ModelRegister();
 } 
 
 public void addUser(ModelRegister modelRegister, User user){

	 modelRegister.setUser(user);
}

 
 
 public void addBilling(ModelRegister modelRegister, Location billing){

	 modelRegister.setBilling(billing);
}
 
 

 
 public String validateUser(User user, MessageContext error) {
	  String transitionValue = "success";
	   if(!user.getPassword().equals(user.getConfirmpassword())) {
	    error.addMessage(new MessageBuilder().error().source(
	      "confirmpassword").defaultText("Password does not match confirm password!").build());
	    transitionValue = "failure";    
	   }  
	   if(userDAO.getByEmail(user.getEmail())!=null) {
	    error.addMessage(new MessageBuilder().error().source(
	      "email").defaultText("Email address is already taken!").build());
	    transitionValue = "failure";
	   }
	  return transitionValue;
	 }
 

 
 public String saveAll(ModelRegister modelRegister) {
	 String transitionValue = "success";
	 
	 User user = modelRegister.getUser();
	 
	 if(user.getRole().equals("USER")) {
		 ShoppingCart cart = new ShoppingCart();
		 cart.setUser(user);
		 user.setCart(cart);
		 
	 }
	 
	 userDAO.addUser(user);
	 
	 Location billing = modelRegister.getBilling();
	 billing.setUserId(user.getId());
	 
	 billing.setBilling(true);
	 
	 userDAO.addLocation(billing);
	 
	 return transitionValue;
 }
 
 


 
}