package com.app.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By getProduct = By.cssSelector("tr td:nth-child(1)");
	
	public void searchProduct(String productName) {
		driver.findElement(search).sendKeys(productName);
	}
	
	public String getProductName() {
		return driver.findElement(getProduct).getText();
	}
}