package com.neu.edu.webtools.project.backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//	private User user;

	@NotBlank(message="Please enter Address Line One!")
	private String locationLineOne;
	@NotBlank(message="Please enter Address Line Two!")
	private String locationLineTwo;
	@NotBlank(message="Please enter your City!")
	private String city;
	@NotBlank(message="Please enter your State!")
	private String state;
	@NotBlank(message="Please enter your Country!")
	private String country;
	@NotBlank(message="Please enter your Zip!")
	private String zip;
	private Boolean shipping;
	private Boolean billing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	

	public String getLocationLineOne() {
		return locationLineOne;
	}
	public void setLocationLineOne(String locationLineOne) {
		this.locationLineOne = locationLineOne;
	}
	public String getLocationLineTwo() {
		return locationLineTwo;
	}
	public void setLocationLineTwo(String locationLineTwo) {
		this.locationLineTwo = locationLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Boolean getShipping() {
		return shipping;
	}
	public void setShipping(Boolean shipping) {
		this.shipping = shipping;
	}
	public Boolean getBilling() {
		return billing;
	}
	public void setBilling(Boolean billing) {
		this.billing = billing;
	}
	
//	@Override
//	public String toString() {
//		return "Location [id=" + id + ", user=" + user + ", locationLineOne=" + locationLineOne + ", locationLineTwo="
//				+ locationLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip
//				+ ", shipping=" + shipping + ", billing=" + billing + "]";
//	}
	
//	
//	public int getUserId() {
//		return user.getId();
//	}
//	public void setUserId(int userId) {
//		this.user.setId(userId);
//	}
	
	@Column(name = "user_id")
	private int userId;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
