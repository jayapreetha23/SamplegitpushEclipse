package com.prac.ListenerWithExtRep;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.TestUtils;

public class TestListnerWithExtRep implements ITestListener {

	TestUtils utils;
	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " On start");
		utils = new TestUtils();
		String time = utils.GetCurrentTime();
		String testname = "TestExec";
		String repName = testname + "_" + time + ".html";
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(repName);
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " On Test Start");
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " Success");
		test.pass(result.getName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " Failure");
		test.fail(result.getName() + " Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName() + " Skipped");
		test.skip(result.getName() + " Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + " Finished");
		extent.flush();
	}
}
