package com.mastek.training.packone;

// interface: a type which contains only method declarations and constants
// the interface does not extends any existing type

public interface Shape {
	//all variables and methods are abstract
	//no constructors can be defined in the interfaces
	
	double PI = Math.PI;
	
	public double getArea();
	
	public double getPerimeter();
	

}
