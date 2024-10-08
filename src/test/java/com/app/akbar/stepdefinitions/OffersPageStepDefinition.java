package com.app.akbar.stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.akbar.pageobjects.LandingPage;
import com.app.akbar.pageobjects.OffersPage;
import com.app.akbar.pageobjects.PageObjectManager;
import com.app.akbar.utils.TestContextSetup;

import io.cucumber.java.en.Then;

public class OffersPageStepDefinition {
	
	public WebDriver driver;
	String landingpageProdName;
	String offerspageProdName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_short_name_in_offers_page(String shortName) throws InterruptedException {
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
	    switchToWindows();
	    offersPage.searchProduct(shortName);
	    Thread.sleep(1000);
	    offerspageProdName = offersPage.getProductName();
	}
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerspageProdName, testContextSetup.landingpageProdName);
	}
	
	public void switchToWindows() throws InterruptedException {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickTopDeals();
		testContextSetup.genericUtils.switchToWindow();
	}
}