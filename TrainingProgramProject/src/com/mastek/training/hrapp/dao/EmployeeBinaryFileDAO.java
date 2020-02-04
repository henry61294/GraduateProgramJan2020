package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {
	Map<Integer, Employee> empMap;
	
	private String fileName;
	

	public EmployeeBinaryFileDAO(String fileName) {
		
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		//read all the data from file and load in the collection
		readMapFromFile();
	}
	
	
	// read the data from the file and add it to the map shared
	private void readMapFromFile() {
		//ObjectInputSTream: read object from binary input stream
		//FIleInputSTream: read binary data from file objects
		//File: open or refer to the file using Filename/File Path
		try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(new File(fileName)))){
			
			// we use the try block with resources to manage autoclosing of streams
			
			empMap = (Map<Integer, Employee>) objIn.readObject();
		} catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
		
	}
	//update file with the map content
	private void writeMapToFile() {
		//object outpt stream: write binary object in serialised format in fileputputstream
		//fileoutputstream: will write binary objects to files
		//file: file object will refer ti the file to be updated/created if not present 
		try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
			
			objOut.writeObject(empMap);//write all he data in serialised format in the file
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee add(Employee newEmployee) {
		if (!empMap.containsKey(newEmployee.getEmpno())) {
		empMap.put(newEmployee.getEmpno(), newEmployee);
		//Update the file with the new content
		writeMapToFile();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values(); //returns all the values of the map
	}

	@Override
	public Employee find(int key) {
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();
		Employee removedEmp = null;
		if (empMap.containsKey(key)) {
			
		removedEmp = empMap.remove(key);
		writeMapToFile();
		}
		return removedEmp;
	}

}
