package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		// in the Another class of a different package  we can access none of the types of members except for public members
		System.out.println(
				//"Private: " + sc1.privateNumber+
				//"\nDefault: "+ sc1.defualtNumber+
				//"\nProtected: "+ sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}

}
