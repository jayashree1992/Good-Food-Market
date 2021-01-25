package com.neu.edu.webtools.project.register;

import java.io.Serializable;

import com.neu.edu.webtools.project.backend.dto.ShoppingCart;

public class ModelUser implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private int id;
	private String fullname;
	private String email;
	private String role;
	private ShoppingCart cart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "ModelUser [id=" + id + ", fullname=" + fullname + ", email=" + email + ", role=" + role + ", cart="
				+ cart + "]";
	}
	
	

}
