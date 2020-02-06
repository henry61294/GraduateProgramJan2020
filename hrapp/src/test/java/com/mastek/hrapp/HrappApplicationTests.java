package com.mastek.hrapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest
class HrappApplicationTests {
	
	@Autowired//spring will provide the object using IOC, dependency injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;

	@Autowired
	EmployeeJPADO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Test
	void testEmployeeServiceExampleMehtod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}

	@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("New Emp");
		emp.setSalary(2234);
		emp.setDesignation(Designation.ARCHITECT);
		
		emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull((emp), "Employee not stored");
	}
	
	@Test
	void TestListEmployee() {
		Iterable<Employee> emps = empDAO.findAll();
		assertNotNull((emps), "Employee not found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	@Test
	void testDepartmentDAOAdd() {
		Department dept = new Department();
		dept.setName("Admin");
		dept.setLocation("UK");
		
		dept = deptDAO.save(dept);
		
		System.out.println(dept);
		assertNotNull((dept), "dept not stored");
	}
	
	@Test
	void TestListDepartment() {
		Iterable<Department> depts = deptDAO.findAll();
		assertNotNull((depts), "dept not found");
		for (Department department : depts) {
			System.out.println(department);
		}
	}
	@Test
	void testProjectDAOAdd() {
		Project proj = new Project();
		proj.setCustomerName("NHS");
		proj.setName("project name test");;
		
		proj = projectDAO.save(proj);
		
		System.out.println(proj);
		assertNotNull((proj), "Project not stored");
	}
	
	@Test
	void TestListProject() {
		Iterable<Project> projs = projectDAO.findAll();
		assertNotNull((projs), "Project not found");
		for (Project projects : projs) {
			System.out.println(projects);
		}
	}
	
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched "+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("epdated Employee: "+emp);
		
	}
	
	@Test
	void testDeleteEmployeeById() {
		//empDAO.delete(emp);			deletes by object
		//empDAO.deleteById(21); //		deletes by ID
		
	}
	
	@Test
	void testAssignEmployeeToDepartment() {
		//empSvc.assignEmployeeToDepartment(empno,deptno);
		Employee emp = empSvc.assignEmployeeToDepartment(24,16);
		assertNotNull(emp.getCurrentDepartment(), "Deprtment not Assigned");
	}
	
	@Test
	void testAssignEmployeeToProject() { //empno project id
		Employee emp = empSvc.assignEmployeeToProject(24,17);
		assertTrue(emp.getProjectsAssigned().size()>0, "Project not Assigned");
	}
	
};
