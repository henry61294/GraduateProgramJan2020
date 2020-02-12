package com.mastek.bankapp.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_JOINED_CAR_LOAN")
public class CarLoan extends Loan {
	
	private int carLoanId;
	private String carLoanProvider;
	
	
	public int getCarLoanId() {
		return carLoanId;
	}
	public void setCarLoanId(int carLoanId) {
		this.carLoanId = carLoanId;
	}
	public String getCarLoanProvider() {
		return carLoanProvider;
	}
	public void setCarLoanProvider(String carLoanProvider) {
		this.carLoanProvider = carLoanProvider;
	}
	@Override
	public String toString() {
		return "CarLoan [carLoanId=" + carLoanId + ", carLoanProvider=" + carLoanProvider + ", getLoanId()="
				+ getLoanId() + ", getAmount()=" + getAmount() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	

}
