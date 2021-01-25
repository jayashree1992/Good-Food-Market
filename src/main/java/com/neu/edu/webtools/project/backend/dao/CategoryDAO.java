package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.Category;


public interface CategoryDAO {
	
	
	
	 Category get(int id);
	 
	 List<Category> listofcategories();
	 
	 boolean add(Category category);
	 boolean update(Category category);
	 boolean delete(Category category);
	 

}
