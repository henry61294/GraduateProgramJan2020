package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Project;

@Component // marking the class as bean to be created
@Scope("singleton")//singleton: one object used across test cases, prototype: one object per request
public class EmployeeService {
	String exampleProperty;
	
	@Autowired
	EmployeeJPADO empDAO;
	@Autowired
	DepartmentJPADAO deptDAO;
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Autowired
	JobPositionDAO jobsDAO;
	
	public EmployeeService() {
		System.out.println("employee service created");
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("employee service initiliased");
		
	}
	
	@PreDestroy// calls before the shutting down the application
	public void terminateService() {
		System.out.println("employee service terminated");
	}
	
	
	
	public void exampleMethod() {
		System.out.println("connect to " + getExampleProperty()+" for business data");
	}


	public String getExampleProperty() {
		return exampleProperty;
	}

@Value("Spring Example Data Source") // initiliase the propertywith the simple value
	public void setExampleProperty(String exampleProperty) {
		System.out.println("example property set: "+ exampleProperty);
		this.exampleProperty = exampleProperty;
	}

@Transactional//this will keep the session open until the method returns the value
public Employee assignEmployeeToDepartment(int empno, int deptno) {
	Employee emp = empDAO.findById(empno).get();//fetch employee if it exists
	Department dept = deptDAO.findById(deptno).get();//fetch department if it exists
	
	//assign the association between employee and department
	emp.setCurrentDepartment(dept);//assign employee to department
	dept.getTeam().add(emp);//add the employee in the department team
	
	empDAO.save(emp);
	deptDAO.save(dept);
	
	
	return emp;// save all the changes and then return the result
}

@Transactional
public Employee assignEmployeeToProject(int empno, int projectId) {
	Employee emp = empDAO.findById(empno).get();
	Project newProject =  projectDAO.findById(projectId).get();
	
	emp.getProjectsAssigned().add(newProject);
	empDAO.save(emp);
	
	return emp;
}
@Transactional
public JobPosition applyForJobPosition(int jobId, int empno) {
	JobPosition job = jobsDAO.findById(jobId).get();
	Employee emp = empDAO.findById(empno).get();
	//adding employee in applicants collection
	job.getApplicants().add(emp);
	job = jobsDAO.save(job);
	return job;
}

}
	
	

