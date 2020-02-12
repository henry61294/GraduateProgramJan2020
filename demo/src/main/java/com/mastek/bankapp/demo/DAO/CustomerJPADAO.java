package com.mastek.bankapp.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankapp.demo.entities.Customer;
@Repository
public interface CustomerJPADAO extends CrudRepository<Customer, Integer> {

}
