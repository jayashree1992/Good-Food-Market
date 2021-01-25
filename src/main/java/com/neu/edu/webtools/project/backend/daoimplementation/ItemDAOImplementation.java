package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dto.Item;

@Repository("itemDAO")
@Transactional
public class ItemDAOImplementation implements ItemDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Item get(int itemId) {
		try {
			return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(itemId));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> listofitems() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Item",Item.class).getResultList();
	}

	@Override
	public boolean add(Item item) {	
		
		try {
		 sessionFactory.getCurrentSession().persist(item);
		 return true;
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return false;
	
	}

	@Override
	public boolean update(Item item) {
		
		try {
		 sessionFactory.getCurrentSession().update(item);
		 return true;
		}
		catch(Exception ex) {
		ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Item item) {
		try {
			item.setActive(false);
			 return this.update(item);
			}
			catch(Exception ex) {
			ex.printStackTrace();
			}
			return false;
	}

	@Override
	public List<Item> listItemsActive() {
		String selectActiveItems = "FROM Item WHERE active = :active";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveItems,Item.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Item> listItemsActiveByCategory(int categoryId) {
        String selectItemsActiveByCategory = "FROM Item WHERE active = :active AND categoryId = :categoryId";
		
		return sessionFactory.getCurrentSession().createQuery(selectItemsActiveByCategory,Item.class).setParameter("active", true).setParameter("categoryId",categoryId).getResultList();
	}

	@Override
	public List<Item> getLatestActiveItems(int count) {
		
		
		return sessionFactory.getCurrentSession().createQuery("FROM Item WHERE active = :active ORDER BY id",Item.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		
	
	}

	
	
	
}
