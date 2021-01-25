package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.Item;

public interface ItemDAO {
	Item get(int itemId);
	
	List<Item> listofitems();
	
	boolean add(Item item);
	boolean update(Item item);
	boolean delete(Item item);
	
	List<Item> listItemsActive();
	List<Item> listItemsActiveByCategory(int categoryId);
	List<Item> getLatestActiveItems(int count);
}
