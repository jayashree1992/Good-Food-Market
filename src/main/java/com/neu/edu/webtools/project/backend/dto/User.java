package com.neu.edu.webtools.project.backend.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="person_user")
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please enter First Name!")
	private String firstname;
	@NotBlank(message="Please enter Last Name!")
	private String lastname;
	
	private String role;
	@NotBlank(message="Please enter your Password!")
	private String password;
	@NotBlank(message="Please enter your Email!")
	private String email;
	@NotBlank(message="Please enter Phone Number!")
	private String contactnumber;

	private boolean enabled = true;
	
	@Transient
	private String confirmpassword;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<OrderInfo> orderInfo = new HashSet<>();
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private ShoppingCart cart;
	
	
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<OrderInfo> getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Set<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role
				+ ", password=" + password + ", email=" + email + ", contactnumber=" + contactnumber + ", enabled="
				+ enabled + "]";
	}
	
	
}
