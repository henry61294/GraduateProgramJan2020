package com.mastek.training.hrapp;

//each class specifies their base/parent class name using extends keyword
//if the class does ot have extends keyword it is by default inheriting java.lang.Object
public class SalesEmployee extends Employee {


	private long target;
	private double commision;
	public SalesEmployee() {
		// use the super keyword to call the base class constructor from the child.
		// super constructor call must be the first line in the constructor 
		super(777, "salesexample",99,Designations.OFFICER);
		System.out.println("Sales Employee Created");
	}
	
	
	///Method overriding 
	// we write the same method available in base class in child with different or additional logic for processing
	//the result
	@Override
	public double getNetSalary(int noOfDays) {
		// TODO Auto-generated method stub
		return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommision()));
	}



	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}
	
	

}
