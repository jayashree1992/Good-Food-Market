package com.neu.edu.webtools.project.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dto.Item;

@Controller
@RequestMapping("/json/data")
public class JsonController {
	
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping("/view/allItems")
	@ResponseBody // we use response body when we want the data in JSON, instead of using model and view
	public List<Item> getAllItems(){
		return itemDAO.listItemsActive();
	}
	
	
	@RequestMapping("/admin/view/allItems")
	@ResponseBody // we use response body when we want the data in JSON, instead of using model and view
	public List<Item> getAllItemsForAdmin(){
		return itemDAO.listofitems();
	}
	
	
	@RequestMapping("/category/{id}/items")
	@ResponseBody
	public List<Item> getItemsByCategory(@PathVariable int id){
		return itemDAO.listItemsActiveByCategory(id);
	}


}
