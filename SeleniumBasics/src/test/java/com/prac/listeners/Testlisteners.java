package com.prac.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testlisteners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Skipped");
	}
}
