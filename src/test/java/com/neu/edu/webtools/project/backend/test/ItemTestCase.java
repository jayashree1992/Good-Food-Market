package com.neu.edu.webtools.project.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dto.Category;
import com.neu.edu.webtools.project.backend.dto.Item;

public class ItemTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ItemDAO itemDAO;
	
	private Item item;
	
	@BeforeClass
	public static void init() {
		context =  new AnnotationConfigApplicationContext();
		
		context.scan("com.neu.edu.webtools.project");
		context.refresh();
		itemDAO = (ItemDAO)context.getBean("itemDAO");
		
	}
	

	@Test
	public void testItemCRUDOperations() {
	
		item = new Item();
		
		item.setName("Curd");
		item.setBrandname("Garelick");
		item.setDescription("This is low fat curd");
		item.setPerunitprice(6);
		item.setActive(true);
		item.setCategoryId(1);
		item.setSupplierId(3);
		
		
		assertEquals("Could not add item", true,itemDAO.add(item));
		
	
		
		
		
		item = itemDAO.get(2);
		
		item.setName("Wafers");
		
		assertEquals("Could not update the item", true, itemDAO.update(item));
		
		
			
	    assertEquals("Could not update the item", true,itemDAO.delete(item));
	    
	    
	    assertEquals("Could not fetch the list of active items",2,itemDAO.listofitems().size());
		
		
		
		
		
	}
	
	@Test
	public void testActiveItemsList() {
	    
	    assertEquals("Could not fetch the list of active items",2,itemDAO.listItemsActive().size());
	}
	
	@Test
	public void testItemsActiveByCategoryList() {
	    
	    assertEquals("Could not fetch the list of active items by category",2,itemDAO.listItemsActiveByCategory(1).size());
	}
	
	@Test
	public void testLatestActiveItems() {
	    
	    assertEquals("Could not fetch the list of active items by category",2,itemDAO.getLatestActiveItems(1).size());
	}
	
	
	
	
	
}
