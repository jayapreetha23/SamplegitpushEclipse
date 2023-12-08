package com.seleniumBasics;

public class TestClass {

	public static void main(String[] args) {

		MyClass obj = new MyClass();
		obj.display(9);

		// obj value is 9 here, as display method has its local variable. Private global
		// var value will not be considered here
	}

}
