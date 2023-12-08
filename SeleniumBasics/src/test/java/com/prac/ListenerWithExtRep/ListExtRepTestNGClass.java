package com.prac.ListenerWithExtRep;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListnerWithExtRep.class)
public class ListExtRepTestNGClass {
	@Test
	public void TestPass() {
		Assert.assertEquals(10, 10);
	}

	@Test
	public void TestFail() {
		Assert.assertEquals(10, 9);
	}

	@Test(dependsOnMethods = "TestFail")
	public void TestSkip() {

	}
}
