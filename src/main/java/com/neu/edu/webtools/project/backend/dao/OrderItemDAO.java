package com.neu.edu.webtools.project.backend.dao;

import java.util.List;

import com.neu.edu.webtools.project.backend.dto.CartDetail;
import com.neu.edu.webtools.project.backend.dto.OrderInfo;
import com.neu.edu.webtools.project.backend.dto.OrderItem;
import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

public interface OrderItemDAO {
	public boolean add(OrderItem orderItem);
}
