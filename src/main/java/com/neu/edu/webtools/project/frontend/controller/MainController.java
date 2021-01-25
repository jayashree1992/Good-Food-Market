package com.neu.edu.webtools.project.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.webtools.project.backend.dao.CategoryDAO;
import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dao.OrderInfoDAO;
import com.neu.edu.webtools.project.backend.dto.Category;
import com.neu.edu.webtools.project.backend.dto.Item;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.User;
import com.neu.edu.webtools.project.shoppingcartservice.ShoppingCartService;

@Controller
public class MainController {

	public MainController() {

	}
	

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private OrderInfoDAO orderInfoDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView masterpage() {
		ModelAndView mv = new ModelAndView("masterpage");

		mv.addObject("pageTitle", "Home");

		mv.addObject("homeItems", itemDAO.listItemsActive());
		mv.addObject("allCategories", categoryDAO.listofcategories());

		mv.addObject("homePageClicked", true);

		return mv;
	}

	@RequestMapping("/about")
	public ModelAndView aboutUs() {
		ModelAndView mv = new ModelAndView("masterpage");

		mv.addObject("pageTitle", "About Us");
		mv.addObject("aboutPageClicked", true);

		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("masterpage");

		mv.addObject("pageTitle", "Contact Us");
		mv.addObject("contactPageClicked", true);

		return mv;
	}

	@RequestMapping("/view/allItems")
	public ModelAndView showAllItems() {
		ModelAndView mv = new ModelAndView("masterpage");

		mv.addObject("pageTitle", "All Items");

		mv.addObject("allCategories", categoryDAO.listofcategories());

		mv.addObject("allItemsPageClicked", true);

		return mv;
	}

	@RequestMapping("/view/category/{id}/items")
	public ModelAndView showCategoryItems(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("masterpage");

		Category category = null;

		category = categoryDAO.get(id);

		mv.addObject("pageTitle", category.getName());
		mv.addObject("category", category);
		mv.addObject("allCategories",categoryDAO.listofcategories());

		mv.addObject("categoryPageClicked", true);

		return mv;
	}

	@RequestMapping("/view/{id}/item")
	public ModelAndView showItemDetail(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("masterpage");

		Item item = itemDAO.get(id);

		item.setNo_of_people_viewed(item.getNo_of_people_viewed() + 1);

		itemDAO.update(item);

		mv.addObject("pageTitle", item.getName());

		mv.addObject("item", item);

		mv.addObject("showItemDetailClicked", true);

		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registerPage() {
		ModelAndView mv = new ModelAndView("masterpage");

		mv.addObject("pageTitle", "Registeration");

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView loginPage(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		ModelAndView mv = new ModelAndView("loginpage");

		if (error != null) {
			mv.addObject("message", "Invalid Credentials!");
		}

		if (logout != null) {
			mv.addObject("logout", "Successfully Logged out!");
		}

		mv.addObject("pageTitle", "Login Page");

		return mv;
	}

	@RequestMapping("/access-denied")
	public ModelAndView deniedAccess() {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("pageTitle", "403  - access denied");

		mv.addObject("errorTitle", "403  - access denied");

		mv.addObject("errorDescription", "403  - access denied");

		return mv;
	}

	@RequestMapping("/do-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout";

	}
	
	@RequestMapping("/view/myorders")
	public ModelAndView showMyOrders(@RequestParam(name="order_id",required=false)Integer order_id) {
		ModelAndView mv = new ModelAndView("masterpage");
		
		mv.addObject("showOrdersClicked", true);
		mv.addObject("pageTitle", "My Orders");
		User user = shoppingCartService.getSessionUser();
		mv.addObject("ordersList", orderInfoDAO.myOrders(user.getId()));
		if(order_id != null) {
			OrderInfo orderInfo = orderInfoDAO.get(order_id);
			if(orderInfo != null) {
				mv.addObject("orderItems", orderInfo.getOrderItems());
			}
		}
		return mv;
	}

}
