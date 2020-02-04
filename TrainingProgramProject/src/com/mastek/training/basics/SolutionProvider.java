package com.mastek.training.basics;

public class SolutionProvider {

	/*
	 * take two numbers from the user and display the maximum as the output. 
	 * 
	 */
	
	// public static <return-datatype> <name> (<param_type1> <param_name1>, ...)
	public static int getMaxNumber (int num1,int num2) {// declare inputs as params
		int max=0; //declare output as local variable
		if (num1>num2) { //validate the conditions for logical result
			max=num1;
		} else {
			 max=num2;			
		}
		return max; //return the result to the caller
	}
	
	public static String getQuotientRemainder(int num1, int num2) {
		int quotient=(num1/num2);
		int remainder=(num1%num2);
		return (quotient +","+ remainder);
		
	}
	
	public static double getKmMile(double num1) {
		double miles = (num1/8)*5;
		
		return (miles);
		
	}
	
	public static String getShapeArea (int num1, int num2) {
		if (num1 == num2) {
			int area = (num1*num2);
			return ("square area is" + area);
		}
		else {
			int area =(num1*num2);
			return ("rectangle area is " + area);
			
		}		
		
	}
	
	public static int getJourneyTime (int dist, int speed) {
		int time = (dist/speed);
		return (time);
		
	}
	
	public static double getCircleArea(double radius) {
		double area = (Math.pow(radius, 2)*Math.PI);
		System.out.println(area);
		return (area);
	}
	
	
	public static String getMultiTable(int num1) {
		String table = "";
		for(int i=1; i<=10; i++){
			table+=num1+"x"+i+"="+num1*i+"\n";
		}
		System.out.println(table);
		return table;
	}
	
	public static int getLowestNumber(int num1, int num2, int num3) {
		int result = 0;
		if (num1<num2 && num1<num3) { 
		result = num1;
		}
		else if (num1>num2 && num2<num3){
		result = num2;
		}
		else {
			result = num3;
		}
		return result;
		}
		
	public static String getPassMark(int StudentID, String StudentName, int StudentAge, int Marks1, int Marks2, int Marks3) {
		int total = Marks1+Marks2+Marks3;
		int percen = (total/300)*100;
		String result = "";
		if (percen>50) {
			result = "PASS";
		}
		else{
			result = "FAIL";
		}
		return (total + ","+ result);
		
	}
}
