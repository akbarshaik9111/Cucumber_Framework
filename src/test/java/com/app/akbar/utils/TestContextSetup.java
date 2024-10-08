package com.app.akbar.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.app.akbar.pageobjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingpageProdName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webDriverManager());
		genericUtils = new GenericUtils(testBase.webDriverManager());
	}
}
