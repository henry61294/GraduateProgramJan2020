package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component//class is initialised by Spring Application Context
public class EmployeeListener {
	
	//@<lifecyle-event>
	//public void <method-name>()
	
	@PrePersist //call this method before nserting each emp object in the employee table 
	public void beforeEmpInsert(Employee e) {
		System.out.println("before employee insert");
		System.out.println("raise laptop request for "+ e.getName());
		
	}
	
	@PostPersist//call this method after inserting each emp object in the employee table
	public void afterEmpInsert(Employee e) {
		System.out.println("after employee insert");
		System.out.println("Screen name generated "+ e.getName()+ e.getEmpno());
	}

	@PreUpdate //call before udateing each emp object in employee table
	public void beforeEmpUpdate(Employee e) {
		System.out.println("before employee update" +e);
		
	}
	
	@PostUpdate  //call after udateing each emp object in employee table
	public void afterEmpUpdate(Employee e) {
		System.out.println("after employee update" +e);
		
	}
	@PostLoad
	public void afterLoading(Employee e) {
		System.out.println("Employee fetched "+e);
	}
	
	@PreRemove 
	public void beforeDelete(Employee e) {
		System.out.println("before removing "+ e);
		System.out.println("Disable profile for "+e.getEmpno());
	}
		
}
