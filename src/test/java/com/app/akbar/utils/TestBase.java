package com.app.akbar.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	public Properties props;
	public FileInputStream fis;
	
	public WebDriver webDriverManager() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		props = new Properties();
		props.load(fis);
		String url = props.getProperty("url");
		String browser_properties = props.getProperty("browser");
		String browser_mvn = System.getProperty("browser");
		String browser = browser_mvn != null ? browser_mvn : browser_properties;
		
		if(driver == null) {
			if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid browser ..!");
			}
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
		}
		return driver;
	}
}