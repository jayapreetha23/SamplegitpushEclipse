package com.seleniumBasics;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pizzahut {

	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// SET CHROME OPTIONS
		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 2);
		contentSettings.put("notifications", 2);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		// SET CAPABILITY
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/");
		Thread.sleep(2000);

		By searchElement = By.xpath("//input[@placeholder='Enter your location for delivery']");
		driver.findElement(searchElement).sendKeys("Chennai");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(searchElement).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(searchElement).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[text()='Start your order']")).click();
//		Thread.sleep(2);
		By pizzaTab1 = By.xpath("//a[contains(@class,'typography-4')][@href='/order/pizzas/']//span[text()='Pizzas']");
		By pizzaTab2 = By.xpath("//a[contains(@class,'inline-block')][@href='/order/pizzas/']//span[text()='Pizzas']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pizzaTab2));
			driver.findElement(pizzaTab2).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(pizzaTab1));
			driver.findElement(pizzaTab1).click();
			e.printStackTrace();
		}

//		WebElement addBtnElement = driver.findElement(By.xpath(
//				"//button[contains(@class,'green flex')][contains(@data-synth,'button--margherita-bestseller-pan')]/span/span[text()='Add']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,420)");
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//button[contains(@class,'green flex')][contains(@data-synth,'button--tandoori-paneer')]/span/span[text()='Add']"))
				.click();
		Thread.sleep(3);

		// SubTotal
		String textTotalString = driver.findElement(By.xpath("//span[@class='subtotal']")).getText();
		System.out.println("Subtotal:" + textTotalString);
		String subtotString = textTotalString.trim().substring(1);
		System.out.println(subtotString);
		float f = Float.parseFloat(subtotString);
		System.out.println(f);

		// Tax
		String textTaxString = driver.findElement(By.xpath(
				"//span[text()='Total Tax']/parent::span/parent::div//following-sibling::span[contains(text(),'₹')]"))
				.getText();
		System.out.println("Tax:" + textTaxString);
		String TaxString = textTaxString.trim().substring(1);
		System.out.println(TaxString);
		float y = Float.parseFloat(TaxString);
		System.out.println(y);

		// FinalAmount
		String textFinalAmountString = driver.findElement(By.xpath(
				"//span[text()='Amount payable']/parent::span/parent::div//following-sibling::span[@class='amountdue']"))
				.getText();
		System.out.println("FinalAmount:" + textFinalAmountString);
		String AmountString = textFinalAmountString.trim().substring(1);
		System.out.println(AmountString);
		float z = Float.parseFloat(AmountString);
		System.out.println(z);

		// Restaurant Handling Charges
		String rhcString = driver.findElement(By.xpath("//div[@class='display-supplement-value']")).getText();
		System.out.println("Restaurant Handling Charges:" + rhcString);
		String chargesString = rhcString.trim().substring(1);
		System.out.println(chargesString);
		float x = Float.parseFloat(chargesString);
		System.out.println(x);

		float xyz = f + y + x;
		System.out.println(xyz);
		if (xyz == z) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		// Getting List of basket items & its size
		List<WebElement> BasketItems = driver.findElements(By.xpath("//div[@data-synth='basket-deal-item']"));
		int basketSize = BasketItems.size();
		System.out.println("Items in Basket: " + basketSize);

		// Validating item count in checkout button
		String iCountBasketString = driver
				.findElement(By.xpath("//span[@class='mr-auto text-left']//span[contains(text(),'item')]")).getText();
		String iCountBasket = iCountBasketString.replace("item", "").trim();
		int count = Integer.parseInt(iCountBasket);
		System.out.println(count);

		if (count == basketSize) {
			System.out.println("Match");
		} else {
			System.out.println("Not Match");
		}

		// Validating total price in checkout button
		String totalPricechkoutString = driver
				.findElement(By.xpath("//span[@class='ml-auto text-right']//span[@data-synth='basket-value']"))
				.getText();
		System.out.println("FinalAmount in checkout button:" + totalPricechkoutString);
		String tpString = totalPricechkoutString.trim().substring(1);
		System.out.println(tpString);
		float a = Float.parseFloat(tpString);
		System.out.println(a);

		if (z == a) {
			System.out.println("Price Match");
		} else {
			System.out.println("Price not match");
		}

		driver.findElement(
				By.xpath("//a[contains(@href,'drinks')][contains(@class,'typography')]//span[text()='Drinks']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//span[text()='Add']/parent::span/parent::button[contains(@data-synth,'pepsi-600ml')]"))
				.click();

		// count of items in Basket
		List<WebElement> BasketItemsPepsi = driver.findElements(By.xpath("//div[@data-synth='basket-deal-item']"));
		int basketSizePepsi = BasketItemsPepsi.size();
		System.out.println("Items in Basket: " + basketSizePepsi);

		// Validating item count in checkout button
		String iCountBasketPepString = driver
				.findElement(By.xpath("//span[@class='mr-auto text-left']//span[contains(text(),'item')]")).getText();
		String iCountPepBasket = iCountBasketPepString.replace("item", "").trim();
		iCountPepBasket = iCountPepBasket.replace("s", "").trim();
		int count1 = Integer.parseInt(iCountPepBasket);
		System.out.println(count1);

		if (count1 == basketSizePepsi) {
			System.out.println("Match");
		} else {
			System.out.println("Not Match");
		}

		// Validating total price in checkout button
		String totalPricechkoutPepString = driver
				.findElement(By.xpath("//span[@class='ml-auto text-right']//span[@data-synth='basket-value']"))
				.getText();
		System.out.println("FinalAmount in checkout button:" + totalPricechkoutPepString);
		String tpPepString = totalPricechkoutPepString.trim().substring(1);
		System.out.println(tpPepString);
		float a1 = Float.parseFloat(tpPepString);
		System.out.println(a1);

		if (z < a1) {
			System.out.println("Price added for Pepsi");
		} else {
			System.out.println("Price not added for Pepsi");
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//button[contains(@class,'icon-close')][contains(@data-synth,'basket-item-remove--tandoori-paneer')]"))
				.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ml-auto text-right']")));
			System.out.println("Price Tag not removed");
		} catch (Exception e) {
			System.out.println("Price tag is removed");
			e.printStackTrace();
		}

		// Validating item count in checkout button
		String countPepsiRemoved = driver
				.findElement(By.xpath("//span[@class='mr-auto text-left']//span[contains(text(),'item')]")).getText();
		String countPepBasketRem = countPepsiRemoved.replace("item", "").trim();
		countPepBasketRem = countPepBasketRem.replace("s", "").trim();
		int count2 = Integer.parseInt(countPepBasketRem);
		System.out.println(count2);

		if (count2 == 1) {
			System.out.println("1 item in checkout button");
		} else {
			System.out.println("item count not matching");
		}

		driver.findElement(By.xpath("//button[@data-synth='link--checkout']")).click();
		Thread.sleep(2000);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait3.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@data-synth='link--continue-shopping']")));
			System.out.println("Success");

		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
}