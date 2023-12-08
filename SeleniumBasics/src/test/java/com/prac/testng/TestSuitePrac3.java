package com.prac.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuitePrac3 {
	@Test
	public void f() {
		System.err.println("test1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethodclass1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethodclass1");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeclass1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterclass1");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest1");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite1");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite1");
	}

}
