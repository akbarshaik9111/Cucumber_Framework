package com.app.akbar.stepdefinitions;

import org.testng.Assert;

import com.app.akbar.pageobjects.CheckoutPage;
import com.app.akbar.utils.TestContextSetup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	String landingpageProdName;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_name_items_in_checkout_page(String name) throws InterruptedException {
		checkoutPage.clickImageBtn();
		checkoutPage.clickProccedToCheckOutBtn();
		String productName = checkoutPage.getProductName(name);
		Assert.assertEquals(productName, testContextSetup.landingpageProdName);
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	    Assert.assertTrue(checkoutPage.visibilityOfPromoBtn());
	    Assert.assertTrue(checkoutPage.visibilityOfPlaceOrderBtn());
	}
	

}
