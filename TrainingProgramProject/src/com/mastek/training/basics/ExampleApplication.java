package com.mastek.training.basics;

public class ExampleApplication {
	
	public static void main(String[] args) {
		int maxResult = 0; //declaration of a variable that can be used over and over again.
		
		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("max result is " + maxResult);
		
	    maxResult = SolutionProvider.getMaxNumber(10, 10);
		System.out.println("max result is " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(-110, -2);
		System.out.println("max result is " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(100129372, 2);
		System.out.println("max result is " + maxResult);
		
		
	}

}
