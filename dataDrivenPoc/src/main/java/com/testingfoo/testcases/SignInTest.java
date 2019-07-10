package com.testingfoo.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testingfoo.base.TestBase;

public class SignInTest extends TestBase {
	
	
	@Test
	public void test() throws InterruptedException {
		
		driver.findElement(By.xpath(or.getProperty("signinBtn"))).click();
		log.debug(" Clicked on Sign-in button");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(or.getProperty("signInMailIDTextField"))).sendKeys("udays2@maildrop.cc");
		
		driver.findElement(By.xpath(or.getProperty("signInPasswordTextField"))).sendKeys("pass1234");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(or.getProperty("signInButton"))).click();
		
		Thread.sleep(8000);
		
		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("signOutBtn"))).getText(), "Sign out");

		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("accountDetailsOption"))).getText(), "Uday"+" "+"s");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.findElement(By.xpath(or.getProperty("signOutBtn"))).click();
		
		driver.findElement(By.xpath(or.getProperty("siteLogo"))).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
