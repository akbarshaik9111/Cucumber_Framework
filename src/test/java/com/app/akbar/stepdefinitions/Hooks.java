package com.app.akbar.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.akbar.utils.TestContextSetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void tearDown() throws IOException {
		testContextSetup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void getScreenShot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.webDriverManager();
		if(scenario.isFailed()) {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] sourcePath = FileUtils.readFileToByteArray(source);
			scenario.attach(sourcePath, "image/png", "image");
		}
	}
}