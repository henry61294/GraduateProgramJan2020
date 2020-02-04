package com.mastek.training.myshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetShoppingCart implements ShoppingCart<Item> {

	Set<Item> items;
	
	public SetShoppingCart(){
		//using hashset to manage unique items in random order
		//items = new HashSet<>(); //diamond operator with new keyword
		//new hashset<Item>();
		//using treeset t store items in order
		items = new TreeSet<>();
	}
	
	
	@Override
	public int addItems(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItems(Item i) {
	items.remove(i);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
