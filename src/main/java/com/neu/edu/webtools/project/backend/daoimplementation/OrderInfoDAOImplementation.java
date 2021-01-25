package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.CartDetailDAO;
import com.neu.edu.webtools.project.backend.dao.OrderInfoDAO;
import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.Item;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

@Repository("orderInfoDAO")
@Transactional
public class OrderInfoDAOImplementation implements OrderInfoDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(OrderInfo orderInfo) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(orderInfo);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<OrderInfo> allOrders() {		
		return sessionFactory.getCurrentSession().createQuery("FROM OrderInfo",OrderInfo.class).getResultList();
	}
	
	@Override
	public List<OrderInfo> myOrders(int user_id) {		
		return sessionFactory.getCurrentSession().
				createQuery("FROM OrderInfo where user_id = :user_id",OrderInfo.class).
				setParameter("user_id", user_id).
				getResultList();
	}
	
	@Override
	public OrderInfo get(int id) {
		return sessionFactory.getCurrentSession().get(OrderInfo.class, Integer.valueOf(id));
	}

}
