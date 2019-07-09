package com.testingfoo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testingfoo.base.TestBase;

public class LoginTest extends TestBase {
	
	public WebDriverWait wait;

	@Test
	public void LoginTestForWebsite() throws InterruptedException {
		
		driver.findElement(By.xpath(or.getProperty("signinBtn"))).click();
		log.debug(" Clicked on Sign-in button");
		
		wait=new WebDriverWait(driver, 360);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("createAccountMailID"))));
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		driver.navigate().to(config.getProperty("testsiteurl"));
		
		Thread.sleep(5000);
	}

	
	
	
	
}
