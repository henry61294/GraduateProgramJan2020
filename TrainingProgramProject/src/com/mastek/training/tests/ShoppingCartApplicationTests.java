package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartApplicationTests {
	ShoppingCart<Item> sc ;

	@BeforeEach
	void setUp() throws Exception {
		//sc = new ListShoppingCart(); List example
		
		//sc = new SetShoppingCart(); //set example
		
		
		sc = new MapShoppingCart(); //map example
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShoppingCartAddItem() {
		int size = sc.addItems(new Item(1,"Name", 233,1));
		assertEquals(1,size,"item added");
	}

	@Test
	void testShoppingCartRemoveItems() {
		sc.addItems(new Item(1,"Name 1", 233,1));
		sc.addItems(new Item(2,"Name 2", 233,1));
		sc.addItems(new Item(3,"Name 3", 233,1));
		sc.printItems();

		int size = sc.removeItems(new Item(2));
		sc.printItems();
		
		assertEquals(2, size, "item removed");
	
	}
	
	@Test
	void testShoppingCartPrintItems() {
		sc.addItems(new Item(3,"Name 3", 233,1));
		sc.addItems(new Item(1,"Name 1", 233,1));
		sc.addItems(new Item(2,"Name 2", 233,1));
		sc.addItems(new Item(3,"Name 3", 233,1));
		sc.addItems(new Item(3,"Name 3", 233,1));
		sc.printItems();

	
	}
}
