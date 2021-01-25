package com.neu.edu.webtools.project.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.webtools.project.shoppingcartservice.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping("/show")
	public ModelAndView displayCart(@RequestParam(name="result",required=false)String result) {
		
		ModelAndView mv = new ModelAndView("masterpage");
	
		
		if(result!=null) {
			switch(result) {
				case "added":
					mv.addObject("message", "Item added successfully!");					
					break;
				case "unavailable":
					mv.addObject("message", "Item is not available!");					
					break;
				case "updated":
					mv.addObject("message", "Item Updated!");					
					break;
				case "modified":
					mv.addObject("message", "Item Modified!");
					break;
				case "maximum":
					mv.addObject("message", "Maximum limit for the item has been reached!");
					break;
				case "deleted":
					mv.addObject("message", "Cart has been deleted successfully!");
					break;
				case "error":
					mv.addObject("message", "Something went Wrong!");
					break;
			}
		}
//		else {
//			String response = shoppingCartService.validateCartDetail();
//			if(response.equals("result=modified")) {
//				mv.addObject("message", "One or more items inside cart has been modified!");
//			}
//		}
		
		mv.addObject("pageTitle", "Shopping Cart");
		mv.addObject("shoppingCartClicked", true);
		mv.addObject("cartDetail", shoppingCartService.getCartDetails());
		return mv;
		
	}
	
	
	@RequestMapping("/{cartDetailId}/update")
	public String udpateCartDetail(@PathVariable int cartDetailId, @RequestParam int count) {
		String response = shoppingCartService.updateCartDetail(cartDetailId, count);		
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/add/{itemId}/item")
	public String addCartLine(@PathVariable int itemId) {
		String response = shoppingCartService.addCartDetail(itemId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/{cartDetailId}/delete")
	public String deleteCartDetail(@PathVariable int cartDetailId) {
		String response = shoppingCartService.removeCartDetail(cartDetailId);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/{cart_id}/checkout")
	public String validateCart(@PathVariable int cart_id) {	
		shoppingCartService.checkout(cart_id);
		return "redirect:/view/myorders";
	}	
	
	
	
	
}
