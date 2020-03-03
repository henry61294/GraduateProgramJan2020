package com.mastek.hrapp.services;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.api.DepartmentAPI;
import com.mastek.hrapp.api.EmployeeAPI;
import com.mastek.hrapp.api.ProjectAPI;
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
public class EmployeeService implements EmployeeAPI, DepartmentAPI, ProjectAPI{
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

@Override
public Iterable<Employee> listAllEmployees() {
    System.out.println("Listing ll Employees");
    return empDAO.findAll();
}

@Override
public Employee findByEmpno(int empno) {
	
	return empDAO.findById(empno).get();
}

@Override
public Employee registerNewEmployee(Employee newEmployee) {
	newEmployee = empDAO.save(newEmployee);
	return newEmployee;
}

@Override
public Iterable<Project> listAllProjects() {
	  System.out.println("Listing all Projects");
	    return projectDAO.findAll();
}

@Override
public Project findByprojectId(int projectId) {
	return projectDAO.findById(projectId).get();
}

@Override
public Project registerNewProject(Project newProject) {
	newProject = projectDAO.save(newProject);
	return newProject;
}

@Override
public Iterable<Department> listAllDepartments() {
	  System.out.println("Listing all Departments");
	  return deptDAO.findAll();
}

@Override
public Department findBydeptno(int deptno) {
	return deptDAO.findById(deptno).get();
}

@Override
public Department registerNewDepartment(Department newDepartment) {
	newDepartment= deptDAO.save(newDepartment);
	return newDepartment;
}


@Override
    @Transactional // to fetch all collections
    public Set<Project> getEmployeeProjects(int empno) {
        Employee currentEmp = empDAO.findById(empno).get();
        int count = currentEmp.getProjectsAssigned().size();
        System.out.println(count+" Projects Found");
        Set<Project> projects = currentEmp.getProjectsAssigned();
        return projects;
    }



    @Override
    @Transactional
    public Project registerProjectForEmployee(int empno, Project newProject) {
        newProject = projectDAO.save(newProject);
        assignEmployeeToProject(empno, newProject.getProjectId());
        return newProject;
    }





}
	
	

