package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

public interface CartDetailDAO {

	public List<CartDetail> list(int cartId);
	public CartDetail get(int id);	
	public boolean add(CartDetail cartdetail);
	public boolean update(CartDetail cartdetail);
	public boolean remove(CartDetail cartdetail);
	
	
	
	public List<CartDetail> listAvailable(int cartId);
	public CartDetail getByCartAndItem(int cartId, int itemId);		
		
	boolean updateShoppingCart(ShoppingCart cart);



}
