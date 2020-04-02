//package com.mastek.hrapp;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.mastek.hrapp.dao.DepartmentJPADAO;
//import com.mastek.hrapp.dao.EmployeeJPADO;
//import com.mastek.hrapp.dao.JobPositionDAO;
//import com.mastek.hrapp.dao.PaymentJPADAO;
//import com.mastek.hrapp.dao.ProjectJPADAO;
//import com.mastek.hrapp.entities.CardPayment;
//import com.mastek.hrapp.entities.ChequePayment;
//import com.mastek.hrapp.entities.Department;
//import com.mastek.hrapp.entities.Designation;
//import com.mastek.hrapp.entities.Employee;
//import com.mastek.hrapp.entities.JobPosition;
//import com.mastek.hrapp.entities.Payment;
//import com.mastek.hrapp.entities.Project;
//import com.mastek.hrapp.services.EmployeeService;
//
////@SpringBootTest
//class HrappApplicationTests {
//	
//	@Autowired//spring will provide the object using IOC, dependency injection technique
//	EmployeeService empSvc;
//	
//	@Autowired
//	EmployeeService empSvc1;
//
//	@Autowired
//	EmployeeJPADO empDAO;
//	
//	@Autowired
//	DepartmentJPADAO deptDAO;
//	
//	@Autowired
//	ProjectJPADAO projectDAO;
//	
//	@Autowired
//	PaymentJPADAO paymentDAO;
//	
//	@Autowired
//	JobPositionDAO jobDAO;
//	
//
//	@Test
//	void testJobPositionDocument() {
//		JobPosition jp = new JobPosition();
//		jp.setJobId(128);
//		jp.setClientName("henry");
//		jp.setLocation("LEEDS");
//		jp.setSkillsRequired("JAVA");
//		jp.setNumberOfPositions(3);
//
//		jp = jobDAO.save(jp);
//		
//		assertNotNull(jp, "job position not saved");
//	}
//	
////	@Test
////	void testApplyForJobPositions() {
////		int jobId = 125;
////		int empno  = 6;		
////		JobPosition jp = empSvc.applyForJobPosition(jobId, empno);
////		
////		assertNotNull(jp, "job positions not  applied");
////		System.out.println("applications for job id: "+ jobId);
////		for(Employee applicant : jp.getApplicants()) {
////			System.out.println(applicant);
////		}
////	}
//	
//	@Test
//	void testListAllJobPositions() {
//		System.out.println("print all job positions");
//		for (JobPosition jp : jobDAO.findAll()) {
//			System.out.println(jp);
//		}
//	}
//	
//	@Test
//	void testFindEmployeesBySalary(){
//		//empDAO.findBySalary(minSalary,maxSalary)
//		double minSalary = 100;
//		double maxSalary = 5000;		
//		Iterable<Employee> emps  = empDAO.findBySalary(minSalary,maxSalary);
//		
//		System.out.println("all employees having salary between " + minSalary + " and "+ maxSalary);
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//	}
//	
//	@Test
//	void testFindEmployeesByDesignation(){
//		Iterable<Employee> emps = empDAO.findByDesignation(Designation.MANAGER);
//		System.out.println("all employees with designation "+ Designation.MANAGER);
//		
//		for (Employee employee: emps) {
//			System.out.println(employee);
//		}
//	}
//	
//	@Test
//	void testFindEmployeesByDesignations(){
//		
//	}
//	
//	@Test
//	void testCashPayemnt() {
//		Payment cashP = new Payment();
//		cashP.setAmount(100);
//		
//		cashP = paymentDAO.save(cashP);
//		System.out.println(cashP);
//		assertNotNull(cashP, "Cash PAyment not Stored");
//	}
//	
//	@Test
//	void testCardPayemntAdd() {
//		CardPayment cardP = new CardPayment();
//		cardP.setAmount(2300);
//		cardP.setCardNumber(1237838734);
//		cardP.setCardService("VISA");
//		
//		cardP = paymentDAO.save(cardP);
//		System.out.println(cardP);
//		assertNotNull(cardP, "Card Payment not Stored");
//		
//	}
//	
//	@Test
//	
//	void testChequePayemnt() {
//		ChequePayment cheqP = new ChequePayment();
//		cheqP.setAmount(3400);
//		cheqP.setBankName("RBS");
//		cheqP.setChequeNumber(23333);
//		
//		cheqP = paymentDAO.save(cheqP);
//		System.out.println(cheqP);
//		assertNotNull(cheqP, "Cheque Payment not Stored");
//		
//	}
//	@Test
//	void testEmployeeServiceExampleMehtod() {
//		empSvc.exampleMethod();
//		empSvc1.exampleMethod();
//	}
//
//	@Test
//	void testEmployeeDAOAdd() {
//		Employee emp = new Employee();
//		emp.setName("New Emp");
//		emp.setSalary(2234);
//		emp.setDesignation(Designation.ARCHITECT);
//		
//		emp = empDAO.save(emp);
//		
//		System.out.println(emp);
//		assertNotNull((emp), "Employee not stored");
//	}
//	
//	@Test
//	void TestListEmployee() {
//		Iterable<Employee> emps = empDAO.findAll();
//		assertNotNull((emps), "Employee not found");
//		for (Employee employee : emps) {
//			System.out.println(employee);
//		}
//	}
////	@Test
////	void testDepartmentDAOAdd() {
////		Department dept = new Department();
////		dept.setName("Admin");
////		dept.setLocation("UK");
////		
////		dept = deptDAO.save(dept);
////		
////		System.out.println(dept);
////		assertNotNull((dept), "dept not stored");
////	}
////	
////	@Test
////	void TestListDepartment() {
////		Iterable<Department> depts = deptDAO.findAll();
////		assertNotNull((depts), "dept not found");
////		for (Department department : depts) {
////			System.out.println(department);
////		}
////	}
////	@Test
////	void testProjectDAOAdd() {
////		Project proj = new Project();
////		proj.setCustomerName("NHS");
////		proj.setName("project name test");;
////		
////		proj = projectDAO.save(proj);
////		
////		System.out.println(proj);
////		assertNotNull((proj), "Project not stored");
////	}
////	
////	@Test
////	void TestListProject() {
////		Iterable<Project> projs = projectDAO.findAll();
////		assertNotNull((projs), "Project not found");
////		for (Project projects : projs) {
////			System.out.println(projects);
////		}
////	}
////	
////	@Test
////	void testUpdateEmployees() {
////		Employee emp = empDAO.findById(1).get();
////		System.out.println("Employee Fetched "+emp);
////		
////		emp.setSalary(emp.getSalary()+1001);
////		emp.setDesignation(Designation.TESTER);
////		
////		emp = empDAO.save(emp);
////		
////		System.out.println("epdated Employee: "+emp);
////		
////	}
////	
////	@Test
////	void testDeleteEmployeeById() {
////		//empDAO.delete(emp);			deletes by object
////		//empDAO.deleteById(21); //		deletes by ID
////		
////	}
////	
////	@Test
////	void testAssignEmployeeToDepartment() {
////		//empSvc.assignEmployeeToDepartment(empno,deptno);
////		Employee emp = empSvc.assignEmployeeToDepartment(24,16);
////		assertNotNull(emp.getCurrentDepartment(), "Deprtment not Assigned");
////	}
////	
////	@Test
////	void testAssignEmployeeToProject() { //empno project id
////		Employee emp = empSvc.assignEmployeeToProject(24,17);
////		assertTrue(emp.getProjectsAssigned().size()>0, "Project not Assigned");
////	}
////	
//	
//};
