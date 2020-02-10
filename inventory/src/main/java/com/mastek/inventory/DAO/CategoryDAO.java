package com.mastek.inventory.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.inventory.entities.Category;

@Repository//declare the DAO layer as repository to manage data operations
public interface CategoryDAO extends CrudRepository<Category, Integer> {

	
	
}
