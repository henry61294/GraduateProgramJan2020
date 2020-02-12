package com.mastek.bankapp.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.bankapp.demo.entities.Loan;

@Repository
public interface LoanJPADAO extends CrudRepository<Loan, Integer>{

}
