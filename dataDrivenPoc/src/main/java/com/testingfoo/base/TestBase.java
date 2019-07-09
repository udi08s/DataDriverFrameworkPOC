package com.testingfoo.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	/**
	 * WebDriver
	 * Properties
	 * Logs
	 * Extent Reports
	 * DB
	 * Excel
	 * Mail
	 * 
	 */
	
	public static WebDriver driver;
	
	public static Properties or=new Properties();
	public static Properties config=new Properties();
	public static FileInputStream fis;
	
	public String log4jConfPath = System.getProperty("user.dir")+"//src//main//resources//properties//log4j.properties";
	//PropertyConfigurator.configure(log4jConfPath);
	
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setUp() 
	{
		if(driver==null) {
			
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//properties//config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
				log.debug("Config file is loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				or.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String log4jConfPath = System.getProperty("user.dir")+"//src//main//resources//properties//log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			
			if(config.getProperty("browser").equals("firefox")) {
				
				//System.setProperty("webdriver.gecko.driver","gecko.exe")
				driver=new FirefoxDriver();
				
				
			}
			
			else if(config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//executables//chromedriver");
				driver=new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Chrome browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
			
		}
		
	}
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}
		
		catch(NoSuchElementException e) {
			
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		
		log.debug("Test Suite execution completed");
	}
}
