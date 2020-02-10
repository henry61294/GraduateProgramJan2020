package com.mastek.inventory.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Order")
public class Order {
	
	private int orderId;
	private double price;
	private int quantity;
	
	

	
	Set<Product> productAssigned = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="JPA_PRODUCT_ORDER_ASSIGNMENT", joinColumns= {@JoinColumn(name="fk_orderId")},//provide join table name, FK for current class
	inverseJoinColumns =  {@JoinColumn(name="fk_productId")})//fk column for collection
	public Set<Product> getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Set<Product> productAssigned) {
		this.productAssigned = productAssigned;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	Customer currentCustomer;
	
	@ManyToOne// One employee is associated with one of the many departments 
	@JoinColumn(name="fk_customer_number")// the foreign key column to store the associate deptno
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}


	@Id//marking the property as primary key
	@Column(name="order_number")//using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)// auto numbering config as per DB 
	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", quantity=" + quantity + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	

}
