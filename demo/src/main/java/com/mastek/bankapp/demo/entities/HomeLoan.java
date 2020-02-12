package com.mastek.bankapp.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_JOINED_HOME_LOAN")
public class HomeLoan extends Loan{

	private int homeLoanId;
	private String homeLoanProvider;
	
	
	public int getHomeLoanId() {
		return homeLoanId;
	}
	public void setHomeLoanId(int homeLoanId) {
		this.homeLoanId = homeLoanId;
	}
	public String getHomeLoanProvider() {
		return homeLoanProvider;
	}
	public void setHomeLoanProvider(String homeLoanProvider) {
		this.homeLoanProvider = homeLoanProvider;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", homeLoanProvider=" + homeLoanProvider + ", getLoanId()="
				+ getLoanId() + ", getAmount()=" + getAmount() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
	
}
