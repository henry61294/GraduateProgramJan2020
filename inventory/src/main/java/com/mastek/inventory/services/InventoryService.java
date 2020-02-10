package com.mastek.inventory.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.inventory.DAO.CategoryDAO;
import com.mastek.inventory.DAO.CustomerDAO;
import com.mastek.inventory.DAO.IngredientDAO;
import com.mastek.inventory.DAO.OrderDAO;
import com.mastek.inventory.DAO.ProductDAO;
import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Customer;
import com.mastek.inventory.entities.Ingredient;
import com.mastek.inventory.entities.Order;
import com.mastek.inventory.entities.Product;


@Component // marking the class as bean to be created
@Scope("singleton")//singleton: one object used across test cases, prototype: one object per request
public class InventoryService {
	String exampleProperty;
	
	@Autowired
	CategoryDAO catDAO;
	@Autowired
	CustomerDAO custDAO;
	@Autowired
	IngredientDAO ingDAO;
	@Autowired
	OrderDAO ordDAO;
	@Autowired
	ProductDAO proDAO;
	
	
	public InventoryService() {
		System.out.println("inventory service created");
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("employee service initiliased");
		
	}
	
	@PreDestroy// calls before the shutting down the application
	public void terminateService() {
		System.out.println("employee service terminated");
	}
	
	
	
	public void exampleMethod() {
		System.out.println("connect to " + getExampleProperty()+" for business data");
	}


	public String getExampleProperty() {
		return exampleProperty;
	}

@Value("Spring Example Data Source") 
	public void setExampleProperty(String exampleProperty) {
		System.out.println("example property set: "+ exampleProperty);
		this.exampleProperty = exampleProperty;
	}


public Order assignOrderToCustomer(int orderId, int custId ) {
	Customer cust = custDAO.findById(custId).get();
	Order ord = ordDAO.findById(orderId).get();
	
	ord.setCurrentCustomer(cust);
	cust.getTeam().add(ord);
	
	ordDAO.save(ord);
	custDAO.save(cust);
	
	return ord;
	
}

@Transactional
public Order assignOrderToProduct(int orderId, int productId) {
	Order ord = ordDAO.findById(orderId).get();
	Product newProduct =  proDAO.findById(productId).get();
	
	ord.getProductAssigned().add(newProduct);
	ordDAO.save(ord);
	
	return ord;
}

@Transactional
public Ingredient assignIngredientToProduct(int ingredientId, int productId) {
	Ingredient ing = ingDAO.findById(ingredientId).get();
	Product newProduct =  proDAO.findById(productId).get();
	
	ing.getProductAssigned().add(newProduct);
	ingDAO.save(ing);
	
	return ing;
}
@Transactional
public Ingredient assignIngredientToCategory(int ingredientId, int categoryId ) {
	Category cat = catDAO.findById(categoryId).get();
	Ingredient ing = ingDAO.findById(ingredientId).get();
	
	ing.setCurrentCategory(cat);
	cat.getIngred().add(ing);
	
	ingDAO.save(ing);
	catDAO.save(cat);
	
	return ing;

}

}


	

