package com.neu.edu.webtools.project.backend.daoimplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.webtools.project.backend.dao.CategoryDAO;
import com.neu.edu.webtools.project.backend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImplementation implements CategoryDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	

	@Override
	public List<Category> listofcategories() {
		// TODO Auto-generated method stub
		
		String activeCategories = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(activeCategories);
		query.setParameter("active",true);
		
		return query.getResultList();
	}


	@Override
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}


	@Override
	public boolean add(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	
	}


	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}