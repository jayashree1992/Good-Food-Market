package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.CartDetailDAO;
import com.neu.edu.webtools.project.backend.dao.OrderInfoDAO;
import com.neu.edu.webtools.project.backend.dao.OrderItemDAO;
import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.OrderItem;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

@Repository("orderItemDAO")
@Transactional
public class OrderItemDAOImplementation implements OrderItemDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(OrderItem orderItem) {
		try {
			sessionFactory.getCurrentSession().persist(orderItem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
