package com.actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;

	@Test
	public void TakeScreenshot() {
		driver.get("https://jqueryui.com/droppable/");
		TakesScreenshot ss = (TakesScreenshot) driver; // Converting or casting the driver instance to screenshot
		File filess = ss.getScreenshotAs(OutputType.FILE); // Returns the screenshot as a file
		// this can also written as
		// File filess = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String cTime = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
		// SimpleDateFormat is a class - creating obj of it. Date() method is to get
		// current date & time. Through format option formatting the current date and
		// time
		String tc = "TC002";
		String pathfile = "C:\\Users\\C o r e - i 5\\OneDrive\\Desktop\\Preetha\\SimpliLearn\\Phase2\\" + tc + "_"
				+ cTime + ".png";
		System.out.println(System.getProperty("user.dir"));
		// Give you the current working directory path - using this we can store the
		// multiple screenshots in this path.
		File file = new File(pathfile);
		try {
			FileUtils.copyFile(filess, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
