package com.app.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By imgCart = By.xpath("//img[@alt='Cart']");
	By btnCheckout = By.xpath("//button[contains(text(), 'PROCEED TO')]");
	By btnPromo = By.cssSelector(".promoBtn");
	By btnPlaceOrder = By.xpath("//button[text()='Place Order']");
	By txtProdName = By.cssSelector("p[class='product-name']");
	
	public void clickImageBtn() {
		driver.findElement(imgCart).click();
	}
	
	public void clickProccedToCheckOutBtn() {
		driver.findElement(btnCheckout).click();
	}
	
	public boolean visibilityOfPromoBtn() {
		return driver.findElement(btnPromo).isDisplayed();
	}
	
	public boolean visibilityOfPlaceOrderBtn() {
		return driver.findElement(btnPlaceOrder).isDisplayed();
	}
	
	public String getProductName(String productName) {
		return driver.findElement(txtProdName).getText().split("-")[0].trim();
	}
}