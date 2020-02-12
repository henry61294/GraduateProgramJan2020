package com.mastek.bankapp.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.bankapp.demo.DAO.AccountJPADAO;
import com.mastek.bankapp.demo.DAO.CustomerJPADAO;
import com.mastek.bankapp.demo.DAO.TransactionJPADAO;
import com.mastek.bankapp.demo.entities.Account;
import com.mastek.bankapp.demo.entities.Customer;
import com.mastek.bankapp.demo.entities.Transaction;
import com.mastek.bankapp.demo.services.BankAppServices;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	@Autowired
	BankAppServices banDAO;
	
	@Test
	void testCustomerJPADAOAdd() {
		Customer cus = new Customer();
		cus.setName("Customer Example");
		cus.setAddress("LEEDS");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
		assertNotNull(cus,"Employee Not Added");
	}
	
	@Test
	void testAccountJPADAOAdd() {
		Account acc = new Account();
		acc.setBankName("HSBC");
		acc.setSortCode(17971);
		
		acc = accDAO.save(acc);
		System.out.println(acc);
		assertNotNull(acc,"Account Not Added");
	}
	
	@Test
	void testTransactionJPADAOAdd() {
		Transaction tra = new Transaction();
		tra.setPaymentType("VISA");
		tra.setAmount(199);
		
		tra = traDAO.save(tra);
		System.out.println(tra);
		assertNotNull(tra,"Transaction Not Added");
	}
	
	void testAssignCustomerToAccount() {
		Customer cus = banDAO.assignCustomerToAccount(1, 3);
		assertNotNull(cus.getAccountAssigned(),"Customer not Assigned");
	}
	
	void testAssignTransactionToAccount() {
		Transaction tra = banDAO.assignTransactionToAccount(2, 3);
		assertNotNull(tra.getLinkedAccount(), "transaction not assigned");
	}

	@Test
	void contextLoads() {
	}

}
