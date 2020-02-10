package com.mastek.inventory.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity// this annotation declares the class as entity , which will be managed by JPA
@Table(name="JPA_Category")//declares the table name associated with this class
public class Category {
	
	private int categoryId;
	private String name;
	
	Set<Ingredient> ingred = new HashSet<>();
	
	@OneToMany(mappedBy="currentCategory", cascade = CascadeType.ALL)
	public Set<Ingredient> getIngred() {
		return ingred;
	}

	public void setIngred(Set<Ingredient> ingred) {
		this.ingred = ingred;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}
	@Id//marking the property as primary key
	@Column(name="category_number")//using column to provide the default column name
	@GeneratedValue
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
	
	
	
	

}
