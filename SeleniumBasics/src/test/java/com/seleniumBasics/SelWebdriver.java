package com.seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rediff.practise.Librediff;

public class SelWebdriver {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Librediff rediff = new Librediff();
		String UN = "admin";
		String PW = "password";
		String loginResult = rediff.Login(driver, UN, PW);
		System.out.println(loginResult);

		driver.quit();

	}
}
