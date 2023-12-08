package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");

		driver.manage().window().maximize();
// Using Class name to find the frame
//	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
// We can use index to find the iframe

		driver.switchTo().frame(0);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
//		actions.dragAndDrop(source, target).perform();
//		actions.clickAndHold(source).moveToElement(target).release().perform();

		int x = target.getLocation().getX();
		int y = target.getLocation().getY();
		actions.clickAndHold(source).moveToLocation(x, y);

	}

}
