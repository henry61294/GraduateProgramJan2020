package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		// in the derived class class of a different package  we can access pubic and protected members of the class
		System.out.println(
				//"Private: " + sc1.privateNumber+
				//"\nDefault: "+ sc1.defualtNumber+
				"\nProtected: "+ sc1.protectedNumber+
				"\nPublic: "+sc1.publicNumber);
	}
}
