package com.mastek.training.myshop;

//using generic type interface
//Type<I>: I would be defined at usage time with type of class
public interface ShoppingCart<I> {
	
	public int addItems(I i);
	public int removeItems(I i);
	public void printItems();
	public double getTotalPrice(double taxPercentage, double discountRatio);
	
	

}
