package com.neu.edu.webtools.project.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neu.edu.webtools.project.backend.dao.CategoryDAO;
import com.neu.edu.webtools.project.backend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context =  new AnnotationConfigApplicationContext();
		
		context.scan("com.neu.edu.webtools.project");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}

	
	@Test
	public void testCategoryCRUDOperations() {
	
		category = new Category();
		
		category.setName("Dairy");
		category.setDescription("this is desc");
		category.setImgURL("xyz.png");
		
		assertEquals("Could not add category", true,categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Fruits");
		category.setDescription("this is desc");
		category.setImgURL("xyz.png");
		
		assertEquals("Could not add category", true,categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Snacks");
		category.setDescription("this is desc");
		category.setImgURL("xyz.png");
		
		assertEquals("Could not add category", true,categoryDAO.add(category));
		
		
		
		category = categoryDAO.get(2);
		
		category.setName("Fresh Fruits and Vegatables");
		
		assertEquals("Successfully fetched a single category", "Fresh Fruits and Vegatables",category.getName());
		
		
			
	    assertEquals("Successfully deleted a single category", true,categoryDAO.delete(category));
	    
	    
	    assertEquals("Successfully fetched list where it is active",2,categoryDAO.listofcategories().size());
		
		
		
		
		
	}
	
}
