package com.neu.edu.webtools.project.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.neu.edu.webtools.project.backend.dao.UserDAO;
import com.neu.edu.webtools.project.backend.dto.User;
import com.neu.edu.webtools.project.register.ModelUser;

@ControllerAdvice
public class FullController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	private ModelUser modelUser = null;
	private User sessionUser = null;
		
	
	@ModelAttribute("modelUser")
	public ModelUser getModelUser() {
		
		if(session.getAttribute("modelUser")==null){
		
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			

				User user = userDAO.getByEmail(authentication.getName());
				
				if(user!=null) {
			
					modelUser = new ModelUser();
			
					modelUser.setId(user.getId());
					modelUser.setEmail(user.getEmail());
					modelUser.setFullname(user.getFirstname() + " " + user.getLastname());
					modelUser.setRole(user.getRole());
					
				
					
					if(modelUser.getRole().equals("USER")) {
						modelUser.setCart(user.getCart());					
					}				
	
					session.setAttribute("modelUser", modelUser);
					return modelUser;
				}			
			}
			
	
		
		
		return (ModelUser) session.getAttribute("modelUser");
	}
	
	@ModelAttribute("sessionUser")
	public User getSessionUser() {
		
		if(session.getAttribute("sessionUser")==null){
		
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				sessionUser = userDAO.getByEmail(authentication.getName());
				
				if(sessionUser!=null) {
					session.setAttribute("sessionUser", sessionUser);
					return sessionUser;
				}			
			}
			
	
		
		
		return (User) session.getAttribute("sessionUser");
	}

}
