package com.neu.edu.webtools.project.register;

import java.io.Serializable;

import com.neu.edu.webtools.project.backend.dto.Location;
import com.neu.edu.webtools.project.backend.dto.User;

public class ModelRegister implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private User user;
	private Location billing;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Location getBilling() {
		return billing;
	}
	public void setBilling(Location billing) {
		this.billing = billing;
	}
		
}