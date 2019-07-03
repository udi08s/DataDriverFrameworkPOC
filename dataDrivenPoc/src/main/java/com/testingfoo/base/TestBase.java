package com.testingfoo.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	
	@BeforeMethod
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("firefox")) {
				
				//System.setProperty("webdriver.gecko.driver","gecko.exe")
				driver=new FirefoxDriver();
				
				
			}
			
			else if(config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//executables//chromedriver");
				driver=new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
			
		}
		
	}
	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
	}
}
