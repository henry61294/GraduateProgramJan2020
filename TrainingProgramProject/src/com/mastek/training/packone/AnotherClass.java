package com.mastek.training.packone;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// in the Another class of same package  we can access all the types of members of the same class except private
		System.out.println(
				//"Private: " + sc1.privateNumber+
				"\nDefault: "+ sc1.defualtNumber+
				"\nProtected: "+ sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
