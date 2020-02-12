package com.mastek.bankapp.demo.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_TRANSFER")
public class Transfer {

	private int id;
	private String fromAccount;
	private String toAccount;
	private String description;
	
	Set<Transaction> tr = new HashSet<>();
	
	
	public Set<Transaction> getTr() {
		return tr;
	}
	public void setTr(Set<Transaction> tr) {
		this.tr = tr;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", description="
				+ description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transfer other = (Transfer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
