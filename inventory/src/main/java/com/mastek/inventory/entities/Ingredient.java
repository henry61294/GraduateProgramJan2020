package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity// this annotation declares the class as entity , which will be managed by JPA
@Table(name="JPA_Ingredient")//declares the table name associated with this class
public class Ingredient {
	
	private int ingredientId;
	private String name;
	
Category currentCategory;
	
	@ManyToOne// One employee is associated with one of the many departments 
	@JoinColumn(name="fk_category_number")
	public Category getCurrentCategory() {
		return currentCategory;
	}
	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}
	
	
Set<Product> productAssigned = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="JPA_PRODUCT_INGREDIENT_ASSIGNMENT", joinColumns= {@JoinColumn(name="fk_ingredientId")},//provide join table name, FK for current class
	inverseJoinColumns =  {@JoinColumn(name="fk_productId")})//fk column for collection
	public Set<Product> getProductAssigned() {
		return productAssigned;
	}

	public void setProductAssigned(Set<Product> productAssigned) {
		this.productAssigned = productAssigned;
	}
	
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}
	@Id//marking the property as primary key
	@Column(name="ingredient_number")//using column to provide the default column name
	@GeneratedValue
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
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
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		return true;
	}
	
	
	

}
