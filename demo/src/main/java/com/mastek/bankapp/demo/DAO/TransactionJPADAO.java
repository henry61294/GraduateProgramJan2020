package com.mastek.bankapp.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankapp.demo.entities.Transaction;
@Repository
public interface TransactionJPADAO extends CrudRepository<Transaction, Integer> {

}
