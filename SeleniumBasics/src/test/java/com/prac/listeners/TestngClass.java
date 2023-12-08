package com.prac.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Testlisteners.class)
public class TestngClass {
	@Test
	public void TestPass() {
		Assert.assertEquals(10, 10);
	}

	@Test
	public void TestFail() {
		Assert.assertEquals(10, 1);
	}

	@Test(dependsOnMethods = "TestFail")
	public void TestSkip() {
		Assert.assertEquals(10, 9);
	}
}
