package com.neu.edu.webtools.project.backend.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id @GeneratedValue
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
    private OrderInfo orderInfo;
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToOne
    private Item item;
	
	@Column(name ="price")
	private double price;
	
	public OrderItem(){
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public OrderInfo getOrderInfo() {
		return orderInfo;
	}


	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
	public double itemTotal() {
		return this.quantity * this.price;
	}
	
	
	
	
}