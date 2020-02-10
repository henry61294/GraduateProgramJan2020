package com.mastek.inventory.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Product;

@Repository//declare the DAO layer as repository to manage data operations
public interface ProductDAO extends CrudRepository<Product, Integer> {

	
	
}
