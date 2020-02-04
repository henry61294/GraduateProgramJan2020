package com.mastek.training.myshop;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListShoppingCart implements ShoppingCart<Item> {

	
	
	List<Item> items;
	
		public ListShoppingCart() {
		
		items = new LinkedList<Item>();
	}
	
	
	
	
	@Override
	public int addItems(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItems(Item i) {
		System.out.println("index of item" + items.indexOf(i));
		items.remove(i); // uses the equals emthod of the Item class [equals and hashcode]
		return items.size();
		
	}

	@Override
	public void printItems() {
		System.out.println("items in cart");
		for (Item item : items) {
			System.out.println(item);
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountRatio) {
		
		return 0;
	}

}
