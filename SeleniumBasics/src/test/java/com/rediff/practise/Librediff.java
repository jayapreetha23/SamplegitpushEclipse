package com.rediff.practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Librediff {

	public String Login(WebDriver driver, String UN, String PW) {
		String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		} catch (TimeoutException e1) {
			// e1.printStackTrace();
			// System.out.println(e1.getMessage());
			return "Username field does not exist";
		}
		driver.findElement(By.id("login1")).sendKeys(UN);
		WebElement password = driver.findElement(By.name("passwd"));
		password.sendKeys(PW);

		WebElement remember = driver.findElement(By.id("remember"));

		boolean chkbox = remember.isSelected();
		if (!chkbox) {
			remember.click();
		}

		driver.findElement(By.name("proceed")).click();
		return "logged in";
	}

}
