package com.mastek.training.packone;

import java.util.Scanner;

public class ExceptionExample {
	
	public static void main(String[]args) {
	
		int num1=0, num2=0, result=0;
		
		Scanner sc = new Scanner(System.in); // scanner has to be delcared outside the try block
		
		try {
			System.out.println("enter num1: ");
			num1 =Integer.parseInt(sc.nextLine()); //fetch the string from console and parse to int
			
			System.out.println("enter num2: ");
			num2 =Integer.parseInt(sc.nextLine());
			
			result = num1/num2;
			
			System.out.println("Division is: "+ result);
		} catch (NumberFormatException e) { //HANDLE SPECIFIC EXCEPTIONS

			e.printStackTrace(); // it will print the exception info on the console
			System.err.println("Invalid Number Entered");
		}
		
		catch(Exception ex) { // HANDLES ALL types of exceptions.
			System.err.println("Exception Occured: " +ex); // print the exception with message
			System.err.println("Exception Message: " +ex.getMessage()); //print the message
			ex.printStackTrace(); // print the complete info about the exception :: stack trace
		}
		
		finally { //block will be exectured in all scenarios of success or failure
			// in case the exception is not handled, it will report the appliation after the finally block
			System.out.println("scanner closed");
			
			sc.close(); //even for valid cases you still have to close the scanner.
		}
		
		
		//represents the rest of the code
		System.out.println("program completed!");
				
	}

}
