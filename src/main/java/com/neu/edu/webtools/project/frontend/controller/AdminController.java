package com.neu.edu.webtools.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.webtools.project.backend.dao.CategoryDAO;
import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dto.Category;
import com.neu.edu.webtools.project.backend.dto.Item;
import com.neu.edu.webtools.project.utility.UploadingImg;
import com.neu.edu.webtools.project.validation.ValidatingItem;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value="/manage/item", method=RequestMethod.GET)
	public ModelAndView viewManageItems(@RequestParam(name="process",required=false) String process) {
		
		
		ModelAndView mv =  new ModelAndView("masterpage");
		
		mv.addObject("manageItemsClicked", true);
		mv.addObject("pageTitle", "Manage Items");
		
		Item item = new Item();
		
		item.setSupplierId(1);
		item.setActive(true);
		
		mv.addObject("item", item);
		
		if(process !=null) {
			if(process.equals("item")) {
				mv.addObject("successMsg","Item added successfully!");
			}
			else if(process.equals("category")) {
				mv.addObject("successMsg","Category added successfully!");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/item" , method=RequestMethod.GET)
	public ModelAndView EditItems(@PathVariable int id) {
		
		
		ModelAndView mv =  new ModelAndView("masterpage");
		
		mv.addObject("manageItemsClicked", true);
		mv.addObject("pageTitle", "Manage Items");
		
		Item item = itemDAO.get(id);
	
	
		
		mv.addObject("item", item);
		
	
		
		return mv;
	}
	
	
	@RequestMapping(value="/manage/item",method=RequestMethod.POST)
	public String manageItemSubmission(@Valid @ModelAttribute() Item item, BindingResult results, Model model, HttpServletRequest request) {
		
		
		if(item.getId()==0) {
			new ValidatingItem().validate(item,results);
		}
		else {
			if(!item.getFile().getOriginalFilename().equals("")) {
				new ValidatingItem().validate(item,results);
			}
		}
		
		
		if(results.hasErrors()) {
						
			model.addAttribute("manageItemsClicked", true);
			model.addAttribute("pageTitle", "Manage Items");
			model.addAttribute("successMsg", "Validation failed");
			return  "masterpage";
		}
		
		if(item.getId()==0) {
			itemDAO.add(item);
		}
		else {
			itemDAO.update(item);
		}
		
		
		if(!item.getFile().getOriginalFilename().equals("")) {
			UploadingImg.uploadFile(request, item.getFile(),item.getItemcode());
		}
			
		
		
		return "redirect:/admin/manage/item?process=item";
	}
	
	@RequestMapping(value="/manage/item/{id}/active", method=RequestMethod.POST)
	@ResponseBody
	public String manageActivingItem(@PathVariable int id) {
		Item item = itemDAO.get(id);
		
		boolean isActive = item.isActive();
		
		item.setActive(!item.isActive());
		
		itemDAO.update(item);
		
		return (isActive)? "Item with id" + item.getId()+ "got deactivated successfully!" : "Item with id" +item.getId() + "got activated successfully!";
		
	}
	
	
	@RequestMapping(value="/manage/category", method=RequestMethod.POST)
	public String manageCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/admin/manage/item?process=category";
		
	}

	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.listofcategories();
	}
	
	
	@ModelAttribute("category")
	public Category getcategory() {
		return new Category();
	}
	
	
}
