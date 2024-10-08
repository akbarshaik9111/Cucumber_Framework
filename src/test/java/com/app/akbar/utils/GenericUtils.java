package com.app.akbar.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToWindow() {
		Set<String> windows = driver.getWindowHandles();
	    Iterator<String> it = windows.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();
	    driver.switchTo().window(childWindowId);
	}

}
