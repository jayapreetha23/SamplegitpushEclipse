package com.actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CtrlClickTest {
	WebDriver driver;

	@Test
	public void TestWindow() {
		driver.get("https://jqueryui.com/droppable/");
		WebElement lnk = driver.findElement(By.linkText("Selectable"));

		String Pwh = driver.getWindowHandle(); // Parent Window Handle - Single String which handles only current window
		System.out.println(Pwh);
		System.out.println(driver.getTitle());

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(lnk).keyUp(Keys.CONTROL).perform(); // KeyDown - Pressing a key, KeyDown -
																				// Releasing a key,

		Set<String> Whs = driver.getWindowHandles(); // Window Handles for multiple window - Set of String

		for (String Cwh : Whs) { // For each child window in all opened window
			System.out.println(Cwh);

			if (!Cwh.equals(Pwh)) { // if child window is not the parent window, then switch the focus to the child
									// window
				driver.switchTo().window(Cwh);
				System.out.println(driver.getTitle());
				break;
			}
		}
		driver.switchTo().window(Pwh); // switching back to parent window
		System.out.println(driver.getTitle());
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
