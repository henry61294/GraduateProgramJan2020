package com.mastek.bankapp.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.bankapp.demo.DAO.AccountJPADAO;
import com.mastek.bankapp.demo.DAO.CustomerJPADAO;
import com.mastek.bankapp.demo.DAO.LoanJPADAO;
import com.mastek.bankapp.demo.DAO.TransactionJPADAO;
import com.mastek.bankapp.demo.DAO.TransferJPADAO;
import com.mastek.bankapp.demo.entities.Account;
import com.mastek.bankapp.demo.entities.CarLoan;
import com.mastek.bankapp.demo.entities.Customer;
import com.mastek.bankapp.demo.entities.HomeLoan;
import com.mastek.bankapp.demo.entities.Loan;
import com.mastek.bankapp.demo.entities.Transaction;
import com.mastek.bankapp.demo.entities.Transfer;
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
	
	@Autowired
	LoanJPADAO loaDAO;
	
	@Autowired
	TransferJPADAO trDAO;
	
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
	
	@Test
	void testLoanAdd() {
		Loan loa = new Loan();
		loa.setAmount(100);
		
		loa = loaDAO.save(loa);
		System.out.println(loa);
		assertNotNull(loa, "loan not stored");
		
	}

	@Test
	void testCarLoanAdd() {
		CarLoan carLoa = new CarLoan();
		carLoa.setAmount(200);
		carLoa.setCarLoanProvider("mongoexample");
		carLoa.setCarLoanId(12);
		
		carLoa = loaDAO.save(carLoa);
		System.out.println(carLoa);
		assertNotNull(carLoa, "car loan not stored");
	}
	
	@Test
	void testHomeLoanAdd() {
		HomeLoan homLoa = new HomeLoan();
		homLoa.setAmount(300);
		homLoa.setHomeLoanProvider("home loan example provider");
		homLoa.setHomeLoanId(14);
		
		homLoa = loaDAO.save(homLoa);
		System.out.println(homLoa);
		assertNotNull(homLoa, "home loan not stored");
	}
	
	@Test
	void carLoanAdd() {
		
	}
	@Test
	void testTransferDocument() {
		Transfer tr = new Transfer();
		tr.setDescription("hello");
		tr.setFromAccount("first account");
		tr.setToAccount("second account");
		tr.setId(7);
		
		tr = trDAO.save(tr);
	}
	@Test
	void assignTransfertoTransaction() {
		Transfer tr = banDAO.assignTrtoTransaction(3, 16);
		for (Transaction tra : tr.getTr()) {
			System.out.println(tra);
		}
	}
}
