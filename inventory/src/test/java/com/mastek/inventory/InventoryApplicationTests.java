package com.mastek.inventory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mastek.inventory.DAO.CategoryDAO;
import com.mastek.inventory.DAO.CustomerDAO;
import com.mastek.inventory.DAO.IngredientDAO;
import com.mastek.inventory.DAO.OrderDAO;
import com.mastek.inventory.DAO.ProductDAO;
import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Customer;
import com.mastek.inventory.entities.Ingredient;
import com.mastek.inventory.entities.Order;
import com.mastek.inventory.entities.Product;
import com.mastek.inventory.services.InventoryService;


@SpringBootTest
class InventoryAppApplicationTests {

	@Autowired //spring will provide the object using IOC, dependency Injection technique
	com.mastek.inventory.services.InventoryService invSvc;
	
	@Autowired
	InventoryService invSvc1;
	
	@Autowired
	CategoryDAO catDAO; 
	
	@Autowired 
	CustomerDAO cusDAO;
	
	@Autowired
	IngredientDAO ingDAO;
	
	@Autowired
	OrderDAO ordDAO;
	
	@Autowired
	ProductDAO proDAO;
	
	@Test
	void testEmployeeServiceExampleMethod() {
		invSvc.exampleMethod();
		invSvc1.exampleMethod();
	}
	
	@Test
	void testCustomerDAOAdd() {
		Customer cus = new Customer();
		cus.setName("Customer Example");
		cus.setEmail("CustomerExample@mastek.com");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
		assertNotNull(cus,"Employee Not Added");
	}
	
	@Test
	void testCategoryDAOAdd() {
		Category cat = new Category();
		cat.setName("Category Example");
		
		cat = catDAO.save(cat);
		System.out.println(cat);
		assertNotNull(cat, "Category Not Added");
	}
	
	@Test
	void testIngredientDAOAdd() {
		Ingredient ing = new Ingredient();
		ing.setName("Ingredient Example");
		
		ing = ingDAO.save(ing);
		System.out.println(ing);
		assertNotNull(ing, "Ingredient Not Added");
	}
	
	@Test
	void testOrderDAOAdd() {
		Order ord = new Order();
		ord.setPrice(1.89);
		
		ord= ordDAO.save(ord);
		System.out.println(ord);
		assertNotNull(ord, "Order Not Added");
	}
	
	@Test
	void testProductDAOAdd() {
		Product pro = new Product();
		pro.setProductName("Product Example");
		pro.setUnitPrice(0.89);
		
		pro=proDAO.save(pro);
		System.out.println(pro);
		assertNotNull(pro, "Product not Added");	
	}
	
//@Test
	void testAssignOrderToCustomer() {
		Order ord = invSvc.assignOrderToCustomer(70, 69);
		assertNotNull(ord.getCurrentCustomer(),"Customer not Assigned");
	}
	
	//@Test
	void testassignIngredientToCategory() {
		Ingredient ing = invSvc.assignIngredientToCategory(67, 68);
		assertNotNull(ing.getCurrentCategory(),"Category not Assigned");
	}
	
	//@Test
	void testAssignProductToIngredient() {
		Ingredient ing = invSvc.assignIngredientToProduct(66, 67);
		assertTrue(ing.getProductAssigned().size()>0,"Ingredients Assigned");
	}
	
	@Test
	void testAssignProductToOrder() {
		Order ord = invSvc.assignOrderToProduct(70, 66);
		assertTrue(ord.getProductAssigned().size()>0,"Order Assigned");
	}

}
	
	