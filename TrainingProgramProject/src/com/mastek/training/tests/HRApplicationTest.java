package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;
import com.sun.corba.se.impl.protocol.SharedCDRClientRequestDispatcherImpl;

class HRApplicationTest {
	
	Employee ex1;

	@BeforeEach
	public void setupEmpTestCases() {
		System.out.println("Before test case create");
		//Employee.DEFAULT_ZERO; //<Class_Name>.<staticMember>
		ex1 = new Employee();
		ex1.setEmpno(34322);
		ex1.setName("example");
		ex1.setUnitSalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		Employee ex2 = new Employee(1122);
		Employee ex3 =new Employee(2244, "example", 344.0, Designations.DEVELOPER);
		
		ex2=null; //release the object to mark as garbage
		ex3=null;
		System.gc(); //notify the system to collect the garbage
		//ex2.getEmpno(); will throw NullPointerException
		
	}
	@AfterEach
	public void tearDownEmpTestCases() {
		System.out.println("After test case create");
	}
	
	
	
	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("test case create");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(34322);
		ex1.setName("example");
		ex1.setUnitSalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);*/
		
		System.out.println(
		"Number: "+ex1.getEmpno()+
		"\nName: "+ex1.getName()+
		"\nDay salary: "+ex1.getUnitSalary()+
		"\nDesignation: "+ex1.getDesignation()+
		"\nGrade: "+ex1.getGrade());
	}

	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		/*Employee ex1 = new Employee();
		ex1.setEmpno(34322);
		ex1.setName("example");
		ex1.setUnitSalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);*/
		
		try {
			assertEquals(9000.0, ex1.getNetSalary(30), "Invalid Net Salary Returned");
			assertEquals(0, ex1.getNetSalary(-30), "Invalid Net Salary Returned");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	@Test
	void testSalesEmployeeObjectUsage() {
		SalesEmployee saleEx1 = new SalesEmployee();
		
		saleEx1.setEmpno(224);
		saleEx1.setName("example");
		saleEx1.setUnitSalary(100);
		saleEx1.setDesignation(Designations.OFFICER);
		saleEx1.setGrade(Grades.G10);
		saleEx1.setCommision(0.8);
		saleEx1.setTarget(100000000);
		
		assertEquals(1620, saleEx1.getNetSalary(9), "invlaid salary calculated");
	}

	
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<======Object features start==========>");
		System.out.println(ex1.toString());
		System.out.println("HashCode "+ ex1.hashCode());
		
		System.out.println("<=======object features finish================>");
		
	}
	@Test
	void testSendAnnouncementToEmployees() {
		//we cannot create an object of abstract class using the 'new' keyword 
		//Announcement exAnnouncement = new Announcement ();
		
		//to use an abstract class object you must extend it with derived class
		//and override ALL abstract methods defined in base/parent class
		Announcement exSMS = new SMSAnnouncement();
		exSMS.setFrom("uk");
		exSMS.setForGroup("mastekeer at glasgow");
		exSMS.setSubject("inclement weather");
		exSMS.setContentText("all employees go home");
		
		Announcement exEmail = new EmailAnnouncement();
		exEmail.setFrom("leadership team");
		exEmail.setForGroup("mastekeers");
		exEmail.setSubject("QMEjan202");
		exEmail.setContentText("go to quaterly webex meet");
		
		if (exSMS instanceof SMSAnnouncement) {
			System.out.println("connect to telecom sms service");
		}
		
		if (exEmail instanceof EmailAnnouncement) {
			System.out.println("connect to email service");
		}
		
		exSMS.sendAnnouncement(); // this will automatically connect to SMS and use the send from SMSAnnoucement
		exEmail.sendAnnouncement();// connect to email and use send from SMS announcement
		
		assertTrue (exSMS instanceof SMSAnnouncement, "invalid announcement implementation");
		assertTrue (exEmail instanceof EmailAnnouncement, "invalid announcement implementation");
		
	}
	
	
	@Test
	void testShapeExample(){
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(20);
		
		Shape shRect = rect;
		Shape shCircle = circle;
		
		System.out.println("rectangle area is "+ shRect.getArea());
		System.out.println("rectangle area is "+ shRect.getPerimeter());
		System.out.println("circle area is " + shCircle.getArea());
		System.out.println("circle area is " + shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape, "invalid shape type");
		assertTrue(circle instanceof Shape, "invalid shape tupe");
		
	}
	
}
