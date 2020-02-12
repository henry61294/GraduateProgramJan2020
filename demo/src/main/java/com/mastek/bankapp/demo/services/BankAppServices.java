package com.mastek.bankapp.demo.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.bankapp.demo.DAO.AccountJPADAO;
import com.mastek.bankapp.demo.DAO.CustomerJPADAO;
import com.mastek.bankapp.demo.DAO.TransactionJPADAO;
import com.mastek.bankapp.demo.entities.Account;
import com.mastek.bankapp.demo.entities.Customer;
import com.mastek.bankapp.demo.entities.Transaction;
@Component
@Scope("singleton")
public class BankAppServices {
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	public BankAppServices() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("employee service initiliased");
		
	}
	
	@PreDestroy// calls before the shutting down the application
	public void terminateService() {
		System.out.println("employee service terminated");
	}
	
	@Transactional
	public Customer assignCustomerToAccount(int cusId, int accId) {
		Customer cus = cusDAO.findById(cusId).get();
		Account acc = accDAO.findById(accId).get();
		
		cus.getAccountAssigned().add(acc);
		
		cusDAO.save(cus);
		accDAO.save(acc);
		
		return cus;
		
	}
	@Transactional
	public Transaction assignTransactionToAccount(int traId, int accId ) {
		Transaction tra = traDAO.findById(traId).get();
		Account acc = accDAO.findById(accId).get();
		
		tra.setLinkedAccount(acc);
		acc.getTransactionHistory().add(tra);
		
		traDAO.save(tra);
		accDAO.save(acc);
		
		
		return tra;

	}
}
