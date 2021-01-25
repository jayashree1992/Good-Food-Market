package com.neu.edu.webtools.project.shoppingcartservice;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.edu.webtools.project.backend.dao.CartDetailDAO;
import com.neu.edu.webtools.project.backend.dao.ItemDAO;
import com.neu.edu.webtools.project.backend.dao.OrderInfoDAO;
import com.neu.edu.webtools.project.backend.dao.OrderItemDAO;
import com.neu.edu.webtools.project.backend.dao.UserDAO;
import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.Item;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.OrderItem;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;
import com.neu.edu.webtools.project.backend.dto.User;
import com.neu.edu.webtools.project.register.ModelUser;

@Service("shoppingCartService")
public class ShoppingCartService {
	
	@Autowired
	private CartDetailDAO cartDetailDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	
	@Autowired
	private OrderItemDAO orderItemDAO;
	
	
	@Autowired
	private HttpSession session;
	
	private ShoppingCart getCart() {
		return((ModelUser) session.getAttribute("modelUser")).getCart();
	}
	
	public User getSessionUser() {
		return((User) session.getAttribute("sessionUser"));
	}

	public List<CartDetail> getCartDetails() {

		ShoppingCart cart = this.getCart();
		return cartDetailDAO.list(cart.getId());

	}
	
	public boolean checkout(int cart_id) {

		User user = this.getSessionUser();
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCreatedOn(new Date());
		
		
		orderInfo.setUser(user);
		user.getOrderInfo().add(orderInfo);
		orderInfo.setTotal(this.getCart().getTotal());
		
		
		List<CartDetail> cartDetails = getCartDetails();
		for(CartDetail cd: cartDetails) {
			OrderItem oi = new OrderItem();
			Item item = cd.getItem();
			oi.setItem(cd.getItem());
			oi.setOrderInfo(orderInfo);
			oi.setQuantity(cd.getItemCount());
			oi.setPrice(item.getPerunitprice());
			orderInfo.getOrderItems().add(oi);
			this.removeCartDetail(cd.getId());
			item.setQuantity(item.getQuantity() - cd.getItemCount());
			itemDAO.update(item);
		}
		
		orderInfoDAO.add(orderInfo);
		
		return true;

	}

	public String updateCartDetail(int cartDetailId, int count) {
		
		CartDetail cartDetail = cartDetailDAO.get(cartDetailId);
		
		if(cartDetail == null) {
			return "result=error";
		}else {
			
			Item item = cartDetail.getItem();
			
			double oldTotal = cartDetail.getTotal();
			
			if(item.getQuantity()<count) {
				return "result=unavailable";
			}
			
			cartDetail.setItemCount(count);
			
			cartDetail.setBuyingPrice(item.getPerunitprice());
			
			cartDetail.setTotal(item.getPerunitprice() * count);
			
			cartDetailDAO.update(cartDetail);
			
			ShoppingCart cart = this.getCart();
			
			cart.setTotal(cart.getTotal() - oldTotal + cartDetail.getTotal());
			
			cartDetailDAO.updateShoppingCart(cart);
			
			return "result=updated";
		}
	}

	public String addCartDetail(int itemId) {
		String response = null;
		ShoppingCart cart = this.getCart();
		
		CartDetail cartDetail = cartDetailDAO.getByCartAndItem(cart.getId(), itemId);
		
		if(cartDetail == null) {
			cartDetail = new CartDetail();
			
			Item item = itemDAO.get(itemId);
			cartDetail.setCartId(cart.getId());
			
			cartDetail.setItem(item);
			
			cartDetail.setBuyingPrice(item.getPerunitprice());
			
			cartDetail.setItemCount(1);
			
			cartDetail.setTotal(item.getPerunitprice());
			
			cartDetail.setAvailable(true);
			
			cartDetailDAO.add(cartDetail);
			
			cart.setCartLines(cart.getCartLines()+1);
			
			cart.setTotal(cart.getTotal()+ cartDetail.getTotal());
			cartDetailDAO.updateShoppingCart(cart);
			
			response = "result=added";
			
			
		}else {
			if(cartDetail.getItemCount()<5) {
				response = this.updateCartDetail(cartDetail.getId(), cartDetail.getItemCount()+1);
			}else {
				response = "result=maximum";
			}
		}
		return response;
	}

	public String removeCartDetail(int cartDetailId) {
	CartDetail cartDetail = cartDetailDAO.get(cartDetailId);
		
		if(cartDetail == null) {
			return "result=error";
		}else {
			ShoppingCart cart = this.getCart();
			
			cart.setTotal(cart.getTotal() - cartDetail.getTotal());
			
			cart.setCartLines(cart.getCartLines()-1);
			
			cartDetailDAO.updateShoppingCart(cart);
			cartDetailDAO.remove(cartDetail);
			
			return "result=deleted";
			
			
		}
	}

	public String validateCartDetail() {
//		ShoppingCart cart = this.getCart();
//		System.out.println(cart);
		
		// TODO Auto-generated method stub
		return null;
	}
}
