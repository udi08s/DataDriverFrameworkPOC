package com.testingfoo.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testingfoo.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void LoginTestForWebsite() throws InterruptedException {
		
		driver.findElement(By.xpath(or.getProperty("signinBtn"))).click();
		
		Thread.sleep(3000);
		
	}
	
	
	
}
