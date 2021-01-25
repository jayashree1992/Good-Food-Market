package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.Location;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;
import com.neu.edu.webtools.project.backend.dto.User;

public interface UserDAO {
	
	

	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean addLocation(Location location);
	Location getBillingLocation(User user);
	List<Location> shippingLocationList(User user);
	

}
