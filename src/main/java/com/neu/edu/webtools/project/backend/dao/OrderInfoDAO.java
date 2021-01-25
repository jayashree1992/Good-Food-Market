package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.Item;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

public interface OrderInfoDAO {	
	public boolean add(OrderInfo orderInfo);
	public List<OrderInfo> allOrders();
	public List<OrderInfo> myOrders(int user_id);
	public OrderInfo get(int id);
}
