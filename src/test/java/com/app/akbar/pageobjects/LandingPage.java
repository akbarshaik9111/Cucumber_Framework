package com.app.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By txtSearch = By.xpath("//input[@type='search']");
	By getProduct = By.cssSelector("h4.product-name");
	By linkTopDeals = By.linkText("Top Deals");
	By btnIncrement = By.xpath("//a[@class='increment']");
	By txtQuantity = By.xpath("//input[@class='quantity']");
	By btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
	
	public void searchProduct(String prodName) {
		driver.findElement(txtSearch).sendKeys(prodName);
	}
	
	public String getProductName() {
		return driver.findElement(getProduct).getText().split("-")[0].trim();
	}
	
	public void clickTopDeals() {
		driver.findElement(linkTopDeals).click();
	}
	
	public String getTitleOfLandingPage() {
		return driver.getTitle();
	}
	
	public void clickOnIncrementBtn(int quantity) {
		for(int i = 1; i < quantity; i++) {
			driver.findElement(btnIncrement).click();
		}
	}
	
	public String getQuantityValue() {
		return driver.findElement(txtQuantity).getAttribute("value");
	}
	
	public void clickOnAddToCartBtn() {
		driver.findElement(btnAddToCart).click();
	}
}
