package com.app.akbar.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.app.akbar.pageobjects.LandingPage;
import com.app.akbar.pageobjects.PageObjectManager;
import com.app.akbar.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	String landingpageProdName;
	String offerspageProdName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		Assert.assertTrue(landingPage.getTitleOfLandingPage().contains("GreenKart "));
	}
	
	@When("^user searched with short name (.+) and extracted acutal name of product$")
	public void user_searched_with_short_name_and_extracted_acutal_name_of_product(String shortName) throws InterruptedException {
		landingPage.searchProduct(shortName);
	    Thread.sleep(1000);
	    testContextSetup.landingpageProdName = landingPage.getProductName();
	    System.out.println(testContextSetup.landingpageProdName);
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_3_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
		landingPage.clickOnIncrementBtn(Integer.parseInt(quantity));
		Thread.sleep(1000);
		Assert.assertEquals(landingPage.getQuantityValue(), quantity);
		landingPage.clickOnAddToCartBtn();
	}
}