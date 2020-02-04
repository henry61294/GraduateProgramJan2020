package com.mastek.training.hrapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeJSONFileDAO implements DataAccessObject<Employee> {
	Map<Integer, Employee> empMap;
	String fileName;

	public EmployeeJSONFileDAO (String fileName){
		empMap =new HashMap<>();
		this.fileName = fileName;
	
	}
	
	
	private void readJSONFileData() {
		//BufferedReader: it reads line by line data from string/text/json file
		//filereader: it reads data from file
		//file: refers/creates a file in the system
		
		try (BufferedReader brJSONFile = new BufferedReader(new FileReader(new File(fileName)))){
			String line = brJSONFile.readLine();
			while (line!= null) { //if it cant detect a line after reading the file it wont return anything
				Employee emp = Employee.parseJSONString(line);
				empMap.put(emp.getEmpno(), emp);
				line = brJSONFile.readLine(); //if there IS content then it'll read the data and then, here, read the next line.
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void writeJSONFileData() {
		//BufferedWriter: it writes string line by line data from string/text/json file
				//filewriter: it writes text data from file
				//file: refers/creates a file in the system
		try (BufferedWriter bw = new BufferedWriter
							(new FileWriter
									(new File(fileName)))){
			for(Integer empno:empMap.keySet()) {
				bw.write(Employee.getJSONString(empMap.get(empno))+ "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public Employee add(Employee newEmployee) {
		if (!empMap.containsKey(newEmployee.getEmpno())) {
			empMap.put(newEmployee.getEmpno(), newEmployee);
			writeJSONFileData();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readJSONFileData();
		return empMap.values(); //returns all the values of the map
	}

	@Override
	public Employee find(int key) {
		readJSONFileData();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readJSONFileData();
		Employee removedEmp = null;
		if (empMap.containsKey(key)) {
		removedEmp = empMap.remove(key);
		writeJSONFileData();
		}
		return removedEmp;
	}

}