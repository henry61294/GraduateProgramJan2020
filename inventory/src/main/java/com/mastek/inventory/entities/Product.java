package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity// this annotation declares the class as entity , which will be managed by JPA
@Table(name="JPA_Product")//declares the table name associated with this class
public class Product {
	
	private int productId;
	private double unitPrice;
	private String productName;
	
	
	
	Set<Ingredient> ingredientAssigned = new HashSet<>();
	
	
	
	@ManyToMany(mappedBy="productAssigned")
	public Set<Ingredient> getIngredientAssigned() {
		return ingredientAssigned;
	}


	public void setIngredientAssigned(Set<Ingredient> ingredientAssigned) {
		this.ingredientAssigned = ingredientAssigned;
	}

	Set<Order> orderAssigned = new HashSet<>();
	
	@ManyToMany(mappedBy="productAssigned")
	public Set<Order> getOrderAssigned() {
		return orderAssigned;
	}


	public void setOrderAssigned(Set<Order> orderAssigned) {
		this.orderAssigned = orderAssigned;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	@Id//marking the property as primary key
	@Column(name="product_number")//using column to provide the default column name
	@GeneratedValue
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", unitPrice=" + unitPrice + ", productName=" + productName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	
	
	

}
