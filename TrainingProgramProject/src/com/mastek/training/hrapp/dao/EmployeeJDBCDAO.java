package com.mastek.training.hrapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class EmployeeJDBCDAO implements DataAccessObject<Employee> {
	
	
	Connection conMysql;
	
	public EmployeeJDBCDAO() {
		try {
			//1. Load the database Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Open COnnection to the MYSQL 
			conMysql = DriverManager.getConnection(
					//connection string to identify the database
					"jdbc:mysql://localhost:3306/graduate_2020_masteknet", 
					"root", //username
					"root"); //password
			
			System.out.println("connection is successful!");
					
					
			
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public Employee add(Employee newEmployee) {
		
		//1. define the query in sql format with parameters if required
		String sqlInsert = "Insert into jdbc_employees" +
							"(empno, name, unit_salary, grade, designation)"+ 
							"values (?, ?, ?, ?, ?)";
		
		//2. prepare the sql object
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)) {
			
			//3. set all the parameters required within the query
			psInsert.setInt(1, newEmployee.getEmpno());
			psInsert.setString(2, newEmployee.getName());
			psInsert.setDouble(3, newEmployee.getUnitSalary());
			psInsert.setString(4, newEmployee.getGrade().toString());
			psInsert.setString(5, newEmployee.getDesignation().toString());
			
			//4. execute the query on the databasetable  return the rows affected
			int recordsAffected = psInsert.executeUpdate(); //insert or update or delete in sql
			System.out.println(recordsAffected+ "Employee Inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
			newEmployee = null; //return null in case of failure 
		}
		return newEmployee; // upon success return this
	}

	@Override
	public Collection<Employee> listAll() {
		String sqlSelectAll = "select * from jdbc_employees";
			List<Employee> employees = new LinkedList<Employee>();
			
			try (Statement stSelectAll = conMysql.createStatement()) {
				ResultSet rsEmployees = stSelectAll.executeQuery(sqlSelectAll);
				while(rsEmployees.next()) {// loop until the resultset has net record
					//create object record in each database
					Employee e = new Employee();
					//read the data from current row using resultset
					e.setEmpno(rsEmployees.getInt("empno"));
					e.setName(rsEmployees.getString("name"));
					e.setUnitSalary(rsEmployees.getDouble("unit_salary"));
					e.setDesignation(Designations.valueOf(rsEmployees.getString("designation")));
					e.setGrade(Grades.valueOf(rsEmployees.getString("grade")));
					
					//add collection to the data
					employees.add(e);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		return employees; //return the collection with employees fetched from the DB
	}

	@Override
	public Employee find(int key) {
		String findSQL = "select * from jdbc_employees where empno =?"; //wherever there is a ? you need aprepared statement
		Employee emp = null;
		try (PreparedStatement psFind = conMysql.prepareStatement(findSQL)) {
			
			psFind.setInt(1, key);// set the empno for search
			
			ResultSet rsFindResult = psFind.executeQuery();
			
			if (rsFindResult.next()) {
				emp = new Employee();
				emp.setEmpno(rsFindResult.getInt("empno"));
				emp.setName(rsFindResult.getString("name"));
				emp.setUnitSalary(rsFindResult.getDouble("unit_salary"));
				emp.setGrade(Grades.valueOf(rsFindResult.getString("grade")));
				emp.setDesignation(Designations.valueOf(rsFindResult.getString("designation")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee remove(int key) {
		Employee empRemoved = find(key);
		if (empRemoved!=null) {
			String sqlDelete = "delete from jdbc_employees where empno =?";
			
			
			try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)){
				psDelete.setInt(1, key);
				
				int rowsDeleted = psDelete.executeUpdate();
				System.out.println(rowsDeleted+ "Employee Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empRemoved;
	}

}
