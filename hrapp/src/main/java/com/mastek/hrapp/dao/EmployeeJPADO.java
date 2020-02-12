package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

@Repository//declare the DAO layer as repository to manage data operations
public interface EmployeeJPADO extends CrudRepository<Employee, Integer> {//<class, PK type>

	Iterable<Employee> findBySalary(
			@Param("minSalary")double minSalary, 
			@Param("maxSalary")double maxSalary);

	Iterable<Employee> findByDesignation(
			@Param("designation")Designation designation);
	
}
