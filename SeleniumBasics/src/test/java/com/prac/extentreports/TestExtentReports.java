package com.prac.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestExtentReports {

	public static void main(String[] args) {
		// Create report, attach report using extent reports, Create Test, Update
		// status, flush

		// OnStart
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyReport.html");
		ExtentReports extentRep = new ExtentReports();
		extentRep.attachReporter(htmlReport);
		// OnTestStart
		ExtentTest Test1 = extentRep.createTest("MyTest1");
		// OnSuccess
		Test1.pass("Test Passed");
		ExtentTest Test2 = extentRep.createTest("MyTest2");
		// OnFailure
		Test2.fail("Test Failed");
		extentRep.flush();
	}

}
