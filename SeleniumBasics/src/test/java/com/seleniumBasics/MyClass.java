package com.seleniumBasics;

public class MyClass {

	private int obj1 = 4;
	private int obj2 = 5;
	private static int obj3;

	public void display(int obj1) {
		// obj2 = obj1; // --> In this case, obj1 and obj2 both have same value = 9
		this.obj1 = obj1;
		System.out.println(this.obj1); // result: 9
		System.out.println(obj2);// result: 5
		// obj1 = obj1;
		System.out.println(obj1);
		MyClass.obj3 = obj2; // this keyword cannot be used to call static variables
		System.out.println(obj3);
	}

}
