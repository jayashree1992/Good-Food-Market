package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.UserDAO;
import com.neu.edu.webtools.project.backend.dto.Location;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;
import com.neu.edu.webtools.project.backend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImplementation implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {

		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addLocation(Location location) {

		try {
			sessionFactory.getCurrentSession().persist(location);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}



	@Override
	public User getByEmail(String email) {
		
		String selectQuery = "FROM User WHERE email = :email";
		
		try {
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery,User.class).setParameter("email", email).getSingleResult();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Location getBillingLocation(User user) {
		
		
		String selectQuery="FROM Location WHERE user = :user AND billing = :billing";
		
		try {
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Location.class).setParameter("user", user).setParameter("billing", true).getSingleResult();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Location> shippingLocationList(User user) {
		
		String selectQuery="FROM Location WHERE user = :user AND shipping = :shipping";
		
		try {
			
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Location.class).setParameter("user", user).setParameter("shipping", true).getResultList();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
}
