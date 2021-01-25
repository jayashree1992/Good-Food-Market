package com.neu.edu.webtools.project.backend.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemcode;
	
	@NotBlank(message = "Item name is required!")
	private String name;
	
	
	@NotBlank(message = "Brand Name is required!")
	private String brandname;
	@JsonIgnore // Here we are telling JSON to ignore this particular field as we dont want it
	@NotBlank(message = "Description is required!")
	private String description;
	
	@Min(value=1, message="The price cannot be lesser than 1")
	private double perunitprice;
	private int quantity;
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name = "supplier_id")
	@JsonIgnore
	private int supplierId;
	private int sold;
	private int no_of_people_viewed;
	
	@Transient
	private MultipartFile file;
	
	
	
	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public Item() {
		
		this.itemcode = "ITM" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemcode=" + itemcode + ", name=" + name + ", brandname=" + brandname
				+ ", description=" + description + ", perunitprice=" + perunitprice + ", quantity=" + quantity
				+ ", active=" + active + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", sold=" + sold
				+ ", no_of_people_viewed=" + no_of_people_viewed + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemcode() {
		return itemcode;
	}


	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrandname() {
		return brandname;
	}


	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPerunitprice() {
		return perunitprice;
	}


	public void setPerunitprice(double perunitprice) {
		this.perunitprice = perunitprice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public int getSold() {
		return sold;
	}


	public void setSold(int sold) {
		this.sold = sold;
	}


	public int getNo_of_people_viewed() {
		return no_of_people_viewed;
	}


	public void setNo_of_people_viewed(int no_of_people_viewed) {
		this.no_of_people_viewed = no_of_people_viewed;
	}
	
}
