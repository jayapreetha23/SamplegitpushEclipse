package com.prac.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsAndDepends {

	@Test(groups = { "smoke", "login" })
	public void Method1() {
		int a = 2;
		int b = 2;
		Assert.assertEquals(a, b);
	}

	@Test(groups = { "smoke", "login" })
	public void Method2() {
		System.out.println("Method2");
	}

	@Test(dependsOnMethods = { "Method1" }, groups = { "login" })
	public void Method3() {
		System.out.println("Method3 depends on Method2");

	}
}
