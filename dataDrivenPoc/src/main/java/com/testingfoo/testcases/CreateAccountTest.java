package com.testingfoo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.testingfoo.base.TestBase;

public class CreateAccountTest extends TestBase{
	
	private WebDriverWait wait;

	@Test
	public void test() throws InterruptedException {
		
		
		driver.findElement(By.xpath(or.getProperty("signinBtn"))).click();
		log.debug(" Clicked on Sign-in button");
		
		//wait=new WebDriverWait(driver,360);
		Thread.sleep(5000);
		
		
		String inputText = "udays1@maildrop.cc";
		WebElement myElement = driver.findElement(By.id("email_create"));
		String js = "arguments[0].setAttribute('value','"+inputText+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath(or.getProperty("createAccountBtn"))).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='id_gender' and @value='1']")).click();
		
		driver.findElement(By.xpath(or.getProperty("firstNameTxtField"))).sendKeys("Uday");
		 
		driver.findElement(By.xpath(or.getProperty("lastNameTxtField"))).sendKeys("s");
		
		driver.findElement(By.xpath(or.getProperty("passwordTxtField"))).sendKeys("pass1234");
		
		Thread.sleep(3000);
		
		WebElement element1=driver.findElement(By.id(or.getProperty("dobDaysID")));
		Select sel= new Select(element1);
		sel.selectByValue("8");
		
		element1=driver.findElement(By.id(or.getProperty("dobMonthsID")));
		sel=new Select(element1);
		sel.selectByValue("4");
		
		element1=driver.findElement(By.id(or.getProperty("dobYearsID")));
		sel=new Select(element1);
		sel.selectByValue("2000");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(or.getProperty("addressTextField"))).sendKeys("Beresford Road");
		
		driver.findElement(By.xpath(or.getProperty("cityTextField"))).sendKeys("New York");
		
		WebElement stateDropdown=driver.findElement(By.id(or.getProperty("stateDropDownID")));
		sel=new Select(stateDropdown);
		sel.selectByVisibleText("New York");
		
		driver.findElement(By.xpath(or.getProperty("zipCode"))).sendKeys("10001");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(or.getProperty("mobilePhone"))).sendKeys("9900083346");
		
		driver.findElement(By.xpath(or.getProperty("aliasAddressTxtField"))).sendKeys("My home address");
		
		driver.findElement(By.xpath(or.getProperty("registerBtn"))).click();
		
		Thread.sleep(5000);
		
		
		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("signOutBtn"))).getText(), "Sign out");

		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("accountDetailsOption"))).getText(), "Uday"+" "+"s");
		
		
	}
}
