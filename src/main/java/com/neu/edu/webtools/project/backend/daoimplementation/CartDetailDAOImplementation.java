package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.CartDetailDAO;
import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

@Repository("cartDetailDAO")
@Transactional
public class CartDetailDAOImplementation implements CartDetailDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CartDetail> list(int cartId) {
		String query = "FROM CartDetail WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartDetail.class)
									.setParameter("cartId", cartId)
										.getResultList();	
	}

	@Override
	public CartDetail get(int id) {
		return sessionFactory.getCurrentSession().get(CartDetail.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(CartDetail cartdetail) {
		try {
			sessionFactory.getCurrentSession().persist(cartdetail);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartDetail cartdetail) {
		try {
			sessionFactory.getCurrentSession().update(cartdetail);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartDetail cartdetail) {
		try {			
			sessionFactory.getCurrentSession().delete(cartdetail);
			return true;
		}catch(Exception ex) {
			return false;
		}	
	}

	@Override
	public List<CartDetail> listAvailable(int cartId) {
		String query = "FROM CartDetail WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartDetail.class)
									.setParameter("cartId", cartId).setParameter("available", true)
										.getResultList();	
	}

	@Override
	public CartDetail getByCartAndItem(int cartId, int itemId) {
		String query = "FROM CartDetail WHERE cartId = :cartId AND item.id = :itemId ";
		
		try {	
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartDetail.class)
									.setParameter("cartId", cartId).setParameter("itemId", itemId)
										.getSingleResult();
		
	}catch(Exception ex) {
		return null;
	}	
		
		
	}


	

	@Override
	public boolean updateShoppingCart(ShoppingCart cart) {
		
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}
