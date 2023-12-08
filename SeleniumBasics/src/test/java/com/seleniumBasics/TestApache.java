package com.seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestApache {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/Ecomm/");

	}

}
