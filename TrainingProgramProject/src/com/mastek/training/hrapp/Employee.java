
//location of the java class in the project structure.
package com.mastek.training.hrapp;

import java.io.Serializable;
import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.bson.Document;
import org.glassfish.json.JsonParserImpl;

//final keyword at class level

//if the class is declared as final then you cannot subclass/inherit/extends the class

public class Employee implements Serializable{
	//we use serializable as a marker interface to manage the serialisation 
	//using objectoutput/inputStreams classes
	
	
	private int empno;
	private String name;
	private double unitSalary;
	private Designations designation;
	private transient Grades grade; //transient keyword will denotes the serializer to skip this field whilst storing binary files
	
	public static final int MAX_PAID_DAYS=90;
	public static final int MIN_DAY_RATE=10;
	public static final int MAX_DAY_RATE=9999999;
	public static final int DEFAULT_ZERO=0;
	public static final int MAX_EMPNO=9999999;
	
	
	
	//blocks
	//static block: execuates at class loading time for each class.
	static {System.out.println("employee static block called");} //you can only access static members here.
	
	//instance block: execuated before the constructor is called for any object of class
	{
		setEmpno(999);
		setName("example");
		setUnitSalary(MIN_DAY_RATE);
		setDesignation(Designations.OTHER);
		System.out.println("employee instance block called");
	}
	
	
	//default constructor: A class constructorwithout any agruments 
	//constructor helps the developer to create a usable object for simulations
	// public <ClassName>
	//Method Constructor Overloading: we define the same method/constructor with different number/type of parameter to allow 
	//multiple forms of the same method.
	public Employee() {
		System.out.println("Employee Default Constructor Called");
		System.out.println("eno:" +getEmpno()+ ",name:"+getName()+
				",unit salary:" +getUnitSalary()+ ",designation:"+getDesignation());
	}
	
	
	//this is an internal method called by garbage collector before deleting the object
	//you can notify to collect the garbage using System.gc();
	public void finalize(){
		
		setEmpno(0);
		setName(null);
		setUnitSalary(0);
		setDesignation(null);
		setGrade(null);
		System.out.println("employee object finalised");
	}
	

	
	public Employee( int empno) {
		this.setEmpno(empno);
		System.out.println("Employee Default Constructor Called");
		System.out.println("eno:" +getEmpno()+ ",name:"+getName()+
				",unit salary:" +getUnitSalary()+ ",designation:"+getDesignation());
	}
	
	
	public Employee(int empno, String name, double unitSalary, Designations designation) {
	this.setEmpno(empno);
	this.setName(name);
	this.setUnitSalary(unitSalary);
	this.setDesignation(designation);
	System.out.println("Employee Master Constructor Called");
	System.out.println("eno:" +getEmpno()+ ",name:"+getName()+
			",unit salary:" +getUnitSalary()+ ",designation:"+getDesignation());
	}
	
	
	
	
	public int getEmpno() {
		return empno;
		
	}
	public void setEmpno(int empno) {
		if (empno>0 && empno<99999) {
		this.empno = empno;
	}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitSalary() {
		return unitSalary;
	}
	public void setUnitSalary(double unitSalary) {
		if (unitSalary>MIN_DAY_RATE && unitSalary<MAX_DAY_RATE) {
		this.unitSalary = unitSalary;
		}
	}
	public Designations getDesignation() {
		return designation;
	}
	public void setDesignation(Designations designation) {
		this.designation = designation;
	}
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	
	//final keyword on methods 
	//final method cannot be overridden in the derived class
	public double getNetSalary(int noOfDays) throws Exception {
		if (noOfDays<DEFAULT_ZERO) {
			//throw is helping you raise an exception on a business condition
			//throw new Exception("Invalid input for number of days: "+ noOfDays);
			throw new RuntimeException("Invalid input for number of days: "+ noOfDays);
			//raise an unchecked exception on business condition
		}
		
		if (noOfDays<DEFAULT_ZERO || noOfDays>MAX_PAID_DAYS) {
			noOfDays=DEFAULT_ZERO;
		}
		return getUnitSalary()*noOfDays;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", unitSalary=" + unitSalary + ", designation="
				+ designation + ", grade=" + grade + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	public static String getJSONString(Employee emp) {
		JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
		jsonBuilder.add("empno", emp.getEmpno());
		jsonBuilder.add("name", emp.getName());
		jsonBuilder.add("day salary", emp.getUnitSalary());
		jsonBuilder.add("designation", emp.getDesignation().toString());
		jsonBuilder.add("grade", emp.getGrade().toString());
		
		String jsonEmp = jsonBuilder.build().toString();
		System.out.println(jsonEmp);
		return jsonEmp;
	}

	public static Employee parseJSONString(String empJSON) {
		JsonReader reader = new JsonReader(new StringReader(empJSON));
		JsonObject empJSONObject = reader.readObject();
		
		Employee emp = new Employee();
		emp.setEmpno(empJSONObject.getIntValue("empno"));
		emp.setName(empJSONObject.getStringValue("name"));
		emp.setUnitSalary(empJSONObject.getIntValue("day salary"));
		emp.setGrade(Grades.valueOf(empJSONObject.getStringValue("grade")));
		emp.setDesignation(Designations.valueOf(empJSONObject.getStringValue("designation")));
		
		System.out.println("from JSON: "+ empJSON);
		System.out.println("TO Emp: "+ emp);
		
		reader.close();
		return emp;
		
	}
	
	public static Document getEmployeeMongoDocument(Employee emp) {
		Document docEmp = new Document();
		docEmp.put("empno", emp.getEmpno());
		docEmp.put("name", emp.getName());
		docEmp.put("unit-salary", emp.getUnitSalary());
		docEmp.put("grade", emp.getGrade().toString());
		docEmp.put("designation", emp.getDesignation().toString());
		
		return docEmp;
	}
	
	
	public static Employee getEmloyeeFromMongoDocument(Document empDoc) {
		Employee emp = new Employee();
		System.out.println(empDoc.toJson());
		try {
		emp.setEmpno(empDoc.getInteger("empno"));
		emp.setName(empDoc.getString("name"));
		emp.setUnitSalary(empDoc.getDouble("unit-salary"));
		emp.setGrade(Grades.valueOf(empDoc.getString("grade")));
		emp.setDesignation(Designations.valueOf(empDoc.getString("designation")));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			emp=null;
	}
		return emp;
	
	}
}
